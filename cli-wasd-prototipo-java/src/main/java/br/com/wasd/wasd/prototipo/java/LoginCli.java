package br.com.wasd.wasd.prototipo.java;

import br.com.wasd.wasd.prototipo.java.model.DiscoMaquina;
import br.com.wasd.wasd.prototipo.java.model.Maquina;
import br.com.wasd.wasd.prototipo.java.model.Pedido;
import br.com.wasd.wasd.prototipo.java.model.Usuario;
import br.com.wasd.wasd.prototipo.java.model.dao.DiscoDao;
import br.com.wasd.wasd.prototipo.java.model.dao.MaquinaDao;
import br.com.wasd.wasd.prototipo.java.model.dao.PedidoDao;
import br.com.wasd.wasd.prototipo.java.model.dao.UsuarioDAO;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.profesorfalken.jsensors.model.components.Components;
import com.profesorfalken.jsensors.model.components.Gpu;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.profesorfalken.jsensors.model.components.Components;
import com.profesorfalken.jsensors.model.components.Gpu;
import java.util.Scanner;
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
    private PedidoDao pedidoDao;
    private String hostname;

    public LoginCli() throws UnknownHostException {
        pedidoDao = new PedidoDao();
        hostname = InetAddress.getLocalHost().getHostName();
    }

    public static void main(String[] args) throws UnknownHostException, InterruptedException {
        String login, senha;
        Scanner leitor = new Scanner(System.in);

        Usuario usuario;
        Pedido pedido;
        UsuarioDAO dao = new UsuarioDAO();
        MaquinaDao maquinaDao = new MaquinaDao();
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

        usuario = dao.login(login, senha);
        //pedido = (Pedido) pedidoDao.findOne(hostname);
        LoginCli load = new LoginCli();
        try (ProgressBar pb = new ProgressBar("Test", 100)) { // name, initial max
            // Use ProgressBar("Test", 100, ProgressBarStyle.ASCII) if you want ASCII output style
            pb.step(); // step by 1
            pb.setExtraMessage("Reading..."); // Set extra message to display at the end of the bar

            if (usuario != null) {
                System.out.println("Bem vindo");
                pb.stepBy(30); // step by n
                new DesktopCli(pb, usuario.getUsuario_id());
            } else {
                System.out.println("Senha ou Usuario Incorreto");
            }
        }
    }
}
