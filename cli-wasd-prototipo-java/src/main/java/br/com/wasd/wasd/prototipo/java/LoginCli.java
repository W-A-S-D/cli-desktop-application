package br.com.wasd.wasd.prototipo.java;

import br.com.wasd.wasd.prototipo.java.model.Usuario;
import br.com.wasd.wasd.prototipo.java.model.dao.UsuarioDAO;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginCli {

    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws UnknownHostException, InterruptedException {

        Scanner leitor = new Scanner(System.in);
        Usuario usuario;
        UsuarioDAO dao = new UsuarioDAO();

        String login;
        String senha;
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
        System.out.println("Bem vindo ao WASD! \nfaça seu login:");
        login = leitor.next();
        System.out.println("Digite a sua senha");
        senha = leitor.next();
        usuario = dao.login(login, senha);

        LoginCli load = new LoginCli();
        load.teste(true);
        if (usuario != null) {
            System.out.println("Bem vindo");
            new DesktopCli();
        } else {
            System.out.println("Senha ou Usuario Incorreto");
            load.teste(false);
        }

    }

    public void teste(Boolean l) {
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    sb.setLength(0);
                    for (int j = 0; j < i; j++) {
                        sb.append("█");
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(LoginCli.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.print("[" + String.format("%-100s", sb.toString()) + "] " + i + "%");
                    System.out.print("\r");
                }
            }
        }
        ).start();
    }
}
