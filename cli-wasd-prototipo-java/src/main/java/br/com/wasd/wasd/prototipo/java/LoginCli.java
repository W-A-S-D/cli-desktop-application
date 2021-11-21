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

                String a = "'🕛'🕧'🕐'🕜'🕑'🕝'🕒'🕞'🕓'🕟'🕔'🕠'🕕'🕖'🕗'🕘'🕙'🕚'🕡'🕢'🕣'🕤'🕥'🕦'\\";
                System.out.print("\033[2J");   // hide the cursor
                long start = System.currentTimeMillis();
                while (l) {
                    for (int i = 0; i < 4; i++) {
                        System.out.print("\033[2J");     // clear terminal
                        System.out.print("\033[0;0H");   // place cursor at top left corner
                        for (int j = 0; j < 80; j++) {   // 80 character terminal width, say
                            System.out.print(a.charAt(i));
                        }
                        try {
                            Thread.sleep(250);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(LoginCli.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    long now = System.currentTimeMillis();
                    // stop after 20 seconds, say
                    if (now - start >= 20000) {
                        break;
                    }
                }
                System.out.print("\033[?25h"); // restore the cursor
            }
        }
        ).start();
    }
}
