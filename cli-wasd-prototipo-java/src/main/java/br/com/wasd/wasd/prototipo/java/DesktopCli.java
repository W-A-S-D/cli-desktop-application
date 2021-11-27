package br.com.wasd.wasd.prototipo.java;

import br.com.wasd.wasd.prototipo.java.enums.TemperaturaAlerta;
import br.com.wasd.wasd.prototipo.java.model.dao.LogDao;
import br.com.wasd.wasd.prototipo.java.model.DiscoMaquina;
import br.com.wasd.wasd.prototipo.java.model.Log;
import br.com.wasd.wasd.prototipo.java.model.LogDisco;
import br.com.wasd.wasd.prototipo.java.model.Maquina;
import br.com.wasd.wasd.prototipo.java.model.Setor;
import br.com.wasd.wasd.prototipo.java.model.dao.DiscoDao;
import br.com.wasd.wasd.prototipo.java.model.dao.LogDiscoDAO;
import br.com.wasd.wasd.prototipo.java.model.dao.MaquinaDao;
import br.com.wasd.wasd.prototipo.java.model.dao.ProcessosDao;
import br.com.wasd.wasd.prototipo.java.model.dao.SetorDAO;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.util.Conversor;
import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;
import com.profesorfalken.jsensors.model.components.Gpu;
import com.profesorfalken.jsensors.model.sensors.Temperature;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Timer;
import javax.swing.table.DefaultTableModel;
import me.tongfei.progressbar.ProgressBar;

public class DesktopCli {

    private Looca looca;
    private Sistema sistema;
    private Memoria memoria;
    private Processador processador;
    private DiscosGroup grupoDeDiscos;
    private Components componentes;
    private Maquina maquina;
    private ProcessosGroup grupoDeProcessos;
    private String hostname;
    private Integer idUser;
    MaquinaDao maquinaDao;
    private SlackWebhook slack;

    public DesktopCli(ProgressBar pb, Integer idUser) throws UnknownHostException, InterruptedException {
        looca = new Looca();
        grupoDeProcessos = looca.getGrupoDeProcessos();
        sistema = looca.getSistema();
        memoria = looca.getMemoria();
        processador = looca.getProcessador();
        grupoDeDiscos = looca.getGrupoDeDiscos();
        componentes = JSensors.get.components();
        hostname = InetAddress.getLocalHost().getHostName();
        maquinaDao = new MaquinaDao();
        maquina = (Maquina) maquinaDao.findOne(hostname);
        slack = new SlackWebhook();
        this.idUser = idUser;

        getHardware(pb);
        //slack.sendMessageToSlackPedidoURL(hostname + " Pedindo Acesso!");  // SLACK AQUI !  

        new Timer().scheduleAtFixedRate(new TimerTask() {
            public void run() {
                try {
                    getHardwareUse();
                } catch (InterruptedException ex) {
                    //Logger.getLogger(Desktop.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }, 0, 30000);

//        new Timer().scheduleAtFixedRate(new TimerTask() {
//            public void run() {
//                getProccess();
//            }
//        }, 0, 120000);
    }

    public void getHardware(ProgressBar pb) throws UnknownHostException {
        pb.setExtraMessage("Coletando dados:");
        pb.stepTo(50); // step directly to n

        System.out.println("Componentes da Máquina:");
        DiscoDao discoDao = new DiscoDao();
        List<Disco> disco = grupoDeDiscos.getDiscos();
        List<Gpu> gpus = componentes.gpus;
        String so, cpu, gpuNome = "Sem GPU no sistema";
        Long ram = 0L;

        so = sistema.getSistemaOperacional();
        cpu = processador.getNome();
        ram = memoria.getTotal();

        if (gpus != null) {
            for (final Gpu gpu : gpus) {
                gpuNome = gpu.name;
            }
        }
        pb.setExtraMessage("\nExibindo dados:");
        pb.stepTo(100);
        System.out.println("Nome da GPU: " + gpuNome);
        System.out.println("Nome do Processador: " + cpu);
        System.out.println("Tamanho de Memoria RAM: " + Conversor.formatarBytes(ram));
        System.out.println("Sistema Operacional: " + so);
        System.out.println("Nome da maquina: " + hostname);

        if (maquina == null) {
            SetorDAO setorDao = new SetorDAO();
            Setor setor;

            setor = (Setor) setorDao.findOne(idUser);

            if (setor != null) {
                maquina = new Maquina(setor.getSetor_id(), hostname, so, cpu, ConversorDouble.formatarBytes(ram),
                        gpuNome, "pendente");
                Integer insertedMachine = maquinaDao.keyInsert(maquina);
                maquina.setMaquina_id(insertedMachine);

                for (Disco d : disco) {
                    DiscoMaquina discoMaquina = new DiscoMaquina(insertedMachine, d.getNome(),
                            ConversorDouble.formatarBytes(d.getTamanho()));
                    discoDao.insert(discoMaquina);
                }
                slack.sendMessageToSlackHostnameURL(hostname + " Maquina Cadastrada!!!");  // SLACK AQUI !

            } else {
                // log
                System.out.println("Setor não encontrado para inserir maquina!");
            }

        }
    }

    public void getHardwareUse() throws InterruptedException {
        Long usoRam, usoDisco = 0L;
        Double usoCpu, temperaturaGpu = 0.0;

        List<Volume> discoVolume = grupoDeDiscos.getVolumes();
        List<Gpu> gpus = componentes.gpus;

        // Classe para inserção de dados
        LogDao logDao = new LogDao();
        LogDiscoDAO logDiscoDao = new LogDiscoDAO();

        usoCpu = processador.getUso();
        usoRam = memoria.getEmUso();

        if (gpus != null) {
            for (final Gpu gpu : gpus) {
                if (gpu.sensors != null) {
                    System.out.println("Sensors: ");
                    // Print temperatures
                    List<Temperature> temps = gpu.sensors.temperatures;
                    for (final Temperature temp : temps) {
                        System.out.println("Temperatura gpu: " + temp.name + ": " + temp.value + " C");
                        temperaturaGpu = temp.value;
                        if (temp.value > 80) {
                            slack.sendMessageToSlackAlertaURL("Alerta!! Temperatura do " + hostname + ": " + temp.value + " C");  // SLACK AQUI !
                        } else if (temp.value > 55) {
                            slack.sendMessageToSlackAlertaURL("Atenção!! Temperatura do " + hostname + ": " + temp.value + " C");  // SLACK AQUI !
                        } else {
                            slack.sendMessageToSlackAlertaURL("Normal Temperatura do " + hostname + ": " + temp.value + " C");  // SLACK AQUI talvez n precise desse 
                        }
                        //lblTempGpu.setText(temp.value + " C");
                    }
                }
            }
        }

        for (Volume volume : discoVolume) {
            usoDisco = volume.getDisponivel();
            System.out.println("Volume do disco: " + Conversor.formatarBytes(volume.getDisponivel()));
            //lblDisco.setText(Conversor.formatarBytes(volume.getDisponivel()));
        }

        // UPDATE DO STATUS
        String status;
        status = TemperaturaAlerta.fromTemperatura(temperaturaGpu);

        System.out.println("Uso da memoria: " + (Conversor.formatarBytes(usoRam)));
        System.out.println("Memoria: Disponivel: " + (Conversor.formatarBytes(memoria.getDisponivel())));
        System.out.println("Uso do CPU: " + (usoCpu.toString()));

//        lblUsoMemoria.setText(Conversor.formatarBytes(usoRam));;
//        lblMemoriaDisponivel.setText(Conversor.formatarBytes(memoria.getDisponivel()));
//        lblCpu.setText(usoCpu.toString());
        if (maquina != null) {
            Log log = new Log(maquina.getMaquina_id(), usoCpu, ConversorDouble.formatarBytes(usoRam),
                    ConversorDouble.formatarBytes(usoDisco), temperaturaGpu);
            Integer insertedLog = logDao.keyInsert(log);
            System.out.println("log id: " + insertedLog);

            DiscoDao discoDao = new DiscoDao();

            List<DiscoMaquina> discos = discoDao.findAllBy(maquina.getMaquina_id());

            if (discos != null) {
                for (int i = 0; i < discos.size(); i++) {
                    usoDisco = discoVolume.get(i).getDisponivel();
                    System.out.println("Volume Disco disponivel: " + Conversor.formatarBytes(discoVolume.get(i).getDisponivel()));
                    //lblDisco.setText(Conversor.formatarBytes(discoVolume.get(i).getDisponivel()));

                    LogDisco logDisco = new LogDisco(insertedLog, discos.get(i).getDisco_id(), ConversorDouble.formatarBytes(discoVolume.get(i).getDisponivel()));
                    logDiscoDao.insert(logDisco);
                }
            }
        } else {
            // log
        }
    }

//    public void getProccess() {
//        List<Processo> processos = grupoDeProcessos.getProcessos();
//        DecimalFormat saida = new DecimalFormat("0.00");
//        ProcessosDao processosDao = new ProcessosDao();
//
//        DefaultTableModel model = (DefaultTableModel) tbProcessos.getModel();
//
//        processos.forEach(processo -> {
//
//            if (processosDao.findOne(processo.getNome()) != null) {
//                processosDao.update(processo);
//            } else {
//                processosDao.insert(processo);
//            }
//
//            Object[] processosAtuais = {processo.getNome(), saida.format(processo.getUsoCpu()),
//                saida.format(processo.getUsoMemoria())};
//            model.addRow(processosAtuais);
//        });
//    }
}
