package br.com.wasd.wasd.prototipo.java;

import br.com.wasd.wasd.prototipo.java.log.LogDesktop;
import br.com.wasd.wasd.prototipo.java.model.Maquina;
import br.com.wasd.wasd.prototipo.java.model.Pedido;
import br.com.wasd.wasd.prototipo.java.model.Usuario;
import br.com.wasd.wasd.prototipo.java.model.dao.MaquinaDao;
import br.com.wasd.wasd.prototipo.java.model.dao.PedidoDao;
import br.com.wasd.wasd.prototipo.java.model.dao.UsuarioDAO;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.profesorfalken.jsensors.model.components.Components;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import me.tongfei.progressbar.ProgressBar;

public class LoginCli {

    /**
     * Creates new form Login
     */
    private Looca looca;
    private Sistema sistema;
    private Memoria memoria;
    private Processador processador;
    private DiscosGroup grupoDeDiscos;
    private Components componentes;
    private Maquina maquina;
    private ProcessosGroup grupoDeProcessos;
    private Pedido pedido;
    private PedidoDao pedidoDao;
    private String hostname;
    private UsuarioDAO dao;
    LogDesktop logSalvo = new LogDesktop();

    public LoginCli() throws UnknownHostException {
        pedidoDao = new PedidoDao();
        pedido = new Pedido();
    }

    public static void main(String[] args) throws UnknownHostException, InterruptedException, SQLException {
        String login, senha;
        String dialog = "";
        Usuario usuario;
        Scanner leitor = new Scanner(System.in);
        UsuarioDAO dao = new UsuarioDAO();
        Pedido pedido = new Pedido();
        PedidoDao pedidoDao = new PedidoDao();
        String hostname = InetAddress.getLocalHost().getHostName();
        SlackWebhook slack = new SlackWebhook();

        System.out.println("                                                       \n"
                + "                                                       \n"
                + "           .---.   ,---,       .--.--.       ,---,     \n"
                + "          /. ./|  '  .' \\     /  /    '.   .'  .' `\\   \n"
                + "      .--'.  ' ; /  ;    '.  |  :  /`. / ,---.'     \\  \n"
                + "     /__./ \\ : |:  :       \\ ;  |  |--`  |   |  .`\\  | \n"
                + " .--'.  '   \\' .:  |   /\\   \\|  :  ;_    :   : |  '  | \n"
                + "/___/ \\ |    ' '|  :  ' ;.   :\\  \\    `. |   ' '  ;  : \n"
                + ";   \\  \\;      :|  |  ;/  \\   \\`----.   \\'   | ;  .  | \n"
                + " \\   ;  `      |'  :  | \\  \\ ,'__ \\  \\  ||   | :  |  ' \n"
                + "  .   \\    .\\  ;|  |  '  '--' /  /`--'  /'   : | /  ;  \n"
                + "   \\   \\   ' \\ ||  :  :      '--'.     / |   | '` ,/   \n"
                + "    :   '  |--\" |  | ,'        `--'---'  ;   :  .'     \n"
                + "     \\   \\ ;    `--''                    |   ,.'       \n"
                + "      '---\"                              '---'         \n"
                + "                                                       ");
        System.out.println("Bem vindo ao WASD!");
        System.out.println("Digite o seu Login");
        login = leitor.next();
        System.out.println("Digite a sua Senha");
        senha = leitor.next();

        try (ProgressBar pb = new ProgressBar("WASD Carregando: ", 100)) { // name, initial max
            usuario = dao.login(login, senha);
            pedido = (Pedido) pedidoDao.findOne(hostname);

            if (usuario != null) {
                if (pedido == null) {
                    System.out.println("Essa máquina não existe em nosso banco de dados, deseja solicitar o cadastro?");
                    System.out.println("Solicitação de Cadastro: digite s/n");
                    dialog = leitor.next();
                    if (dialog.equals("s")) {
                        createRequest(usuario.getUsuario_id());
                        System.out.println("Solicitação de cadastro");
                        slack.sendMessageToSlackPedidoURL(hostname + " Pedindo Acesso!");  // SLACK AQUI !  
                        System.out.println("Aguarde a Confirmação do pedido... Até logo!");
                        System.exit(0);
                    }
                    System.out.println("Até logo!");
                    System.exit(0);
                } else if (pedido.getStatus() == 1) {
                    System.out.println("Bem vindo!");
                    pb.step(); // step by 1
                    pb.setExtraMessage("Coletando Dados:\n"); // Set extra message to display at the end of the bar
                    try {
                        pb.stepBy(30); // step by n
                        new DesktopCli(pb, usuario.getUsuario_id());
                    } catch (UnknownHostException ex) {
                        Logger.getLogger(LoginCli.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(LoginCli.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    System.out.println("O cadastro dessa máquina foi NEGADO!. Para mais informações informe-se em: https://wasdenterprise.atlassian.net/servicedesk/customer/user/login?destination=portals");
                }
            } else {
                System.out.println("Senha/Usuário incorreto");
            }
        } catch (SQLException ex) {
            System.out.println("Não foi possível conectar ao banco de dados");
        }
    }

    public static void createRequest(Integer userId) throws UnknownHostException {
        PedidoDao pedidoDao = new PedidoDao();
        String hostname = InetAddress.getLocalHost().getHostName();
        pedidoDao.insert(new Pedido(hostname, userId));
    }
}
