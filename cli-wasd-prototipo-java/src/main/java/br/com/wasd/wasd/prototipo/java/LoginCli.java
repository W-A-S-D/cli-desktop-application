package br.com.wasd.wasd.prototipo.java;

import br.com.wasd.wasd.prototipo.java.model.Usuario;
import br.com.wasd.wasd.prototipo.java.model.dao.UsuarioDAO;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginCli {

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
        load.teste(1);
        if (usuario != null) {
            System.out.println("Bem vindo");
            new DesktopCli();
        } else {
            System.out.println("Senha ou Usuario Incorreto");
            load.teste(0);
        }

    }

    public void teste(Integer l) {        
        new Thread(new Runnable() {
            public void run() {
                try {
                    for (int i = 0; l != 0; i++) {

                        System.out.print('.');
                        Thread.sleep(1000);
                        System.out.print('.');

                    }
                    System.out.println("\n");
                } catch (InterruptedException ex) {
                    Logger.getLogger(LoginCli.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }).start();
    }
}
