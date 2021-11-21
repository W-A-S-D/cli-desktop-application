package br.com.wasd.wasd.prototipo.java;

import br.com.wasd.wasd.prototipo.java.ConversorDouble;
import br.com.wasd.wasd.prototipo.java.enums.TemperaturaAlerta;
import br.com.wasd.wasd.prototipo.java.model.DiscoMaquina;
import br.com.wasd.wasd.prototipo.java.model.Log;
import br.com.wasd.wasd.prototipo.java.model.Maquina;
import br.com.wasd.wasd.prototipo.java.model.dao.DiscoDao;
import br.com.wasd.wasd.prototipo.java.model.dao.LogDao;
import br.com.wasd.wasd.prototipo.java.model.dao.LogDiscoDAO;
import br.com.wasd.wasd.prototipo.java.model.dao.MaquinaDao;
import br.com.wasd.wasd.prototipo.java.model.dao.ProcessosDao;
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
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class DesktopCli {

    private Looca looca;
    private Sistema sistema;
    private Memoria memoria;
    private Processador processador;
    private DiscosGroup grupoDeDiscos;
    private Components componentes;
    private Maquina maquina;
    private ProcessosGroup grupoDeProcessos;

    public DesktopCli() throws UnknownHostException, InterruptedException {
        looca = new Looca();
        grupoDeProcessos = looca.getGrupoDeProcessos();
        sistema = looca.getSistema();
        memoria = looca.getMemoria();
        processador = looca.getProcessador();
        grupoDeDiscos = looca.getGrupoDeDiscos();
        componentes = JSensors.get.components();
        getHardware();
        getHardwareUse();
    }

    public void getHardware() throws UnknownHostException {
        
        String so, cpu, gpuNome = "Sem GPU no sistema";
        Long ram = 0L;

        String hostname = InetAddress.getLocalHost().getHostName();

        List<Disco> disco = grupoDeDiscos.getDiscos();

        // Dados da GPU - Jsensors
        List<Gpu> gpus = componentes.gpus;

        MaquinaDao maquinaDao = new MaquinaDao();
        DiscoDao discoDao = new DiscoDao();

        so = sistema.getSistemaOperacional();
        cpu = processador.getNome();
        ram = memoria.getTotal();

        for (Disco d : disco) {
            DiscoMaquina discoMaquina = new DiscoMaquina(1, d.getNome(), ConversorDouble.formatarBytes(d.getTamanho()));
            discoDao.insert(discoMaquina);
        }

        if (gpus != null) {
            for (final Gpu gpu : gpus) {
                gpuNome = gpu.name;
            }
        }

        System.out.println(gpuNome);
        System.out.println(cpu);
        System.out.println(Conversor.formatarBytes(ram));
        System.out.println(so);
        System.out.println(hostname);

        maquina = new Maquina(hostname, so, cpu, ConversorDouble.formatarBytes(ram), gpuNome, "pendente");

        maquinaDao.insert(maquina);
        LoginCli load = new LoginCli();
        load.teste(false);
        
    }

    public void getHardwareUse() throws InterruptedException {
        Long usoRam, usoDisco = 0L;
        Double usoCpu, temperaturaGpu = 0.0;

        //Dados da api looca        
        Looca looca = new Looca();

        ProcessosGroup grupoDeProcessos = looca.getGrupoDeProcessos();
        List<Processo> processos = grupoDeProcessos.getProcessos();

        Processador processador = looca.getProcessador();
        Memoria memoria = looca.getMemoria();

        DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();
        List<Volume> discoVolume = grupoDeDiscos.getVolumes();

        // Dados da GPU - Jsensors
        Components componentes = JSensors.get.components();
        List<Gpu> gpus = componentes.gpus;

        //Classe para inserção de dados
        LogDao logDao = new LogDao();
        LogDiscoDAO logDiscoDao = new LogDiscoDAO();

        usoCpu = processador.getUso();
        usoRam = memoria.getEmUso();

        if (gpus != null) {
            for (final Gpu gpu : gpus) {
                if (gpu.sensors != null) {
                    System.out.println("Sensors: ");
                    //Print temperatures
                    List<Temperature> temps = gpu.sensors.temperatures;
                    for (final Temperature temp : temps) {
                        System.out.println("Temperatura gpu: " + temp.name + ": " + temp.value + " C");
                        temperaturaGpu = temp.value;
                        //lblTempGpu.setText(temp.value + " C");
                    }
                }
            }
        }

        for (Volume volume : discoVolume) {
            usoDisco = volume.getDisponivel();
            System.out.println("Volume do disco: " + Conversor.formatarBytes(volume.getDisponivel()));
        }

        //UPDATE DO STATUS
        String status;
        status = TemperaturaAlerta.fromTemperatura(temperaturaGpu);

        System.out.println("Uso da memoria: " + (Conversor.formatarBytes(usoRam)));
        System.out.println("Memoria: Disponivel: " + (Conversor.formatarBytes(memoria.getDisponivel())));
        System.out.println("Uso do CPU: " + (usoCpu.toString()));

        Log log = new Log(1, usoCpu, ConversorDouble.formatarBytes(usoRam), ConversorDouble.formatarBytes(usoDisco), temperaturaGpu);
        logDao.insert(log);

        // LEMBRAR DE FAZER O LOOPING
    }

    public void getProccess() {
        List<Processo> processos = grupoDeProcessos.getProcessos();
        DecimalFormat saida = new DecimalFormat("0.00");
        ProcessosDao processosDao = new ProcessosDao();

//        DefaultTableModel model = (DefaultTableModel) tbProcessos.getModel();

        processos.forEach(processo -> {

            if (processosDao.findOne(processo.getNome()) != null) {;;
                processosDao.update(processo);
            } else {
                processosDao.insert(processo);
            }

            Object[] processosAtuais = {processo.getNome(), saida.format(processo.getUsoCpu()), saida.format(processo.getUsoMemoria())};
//           model.addRow(processosAtuais);
        });
    }
}
