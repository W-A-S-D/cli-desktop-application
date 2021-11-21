package br.com.wasd.wasd.prototipo.java;

import br.com.wasd.wasd.prototipo.java.model.Usuario;
import br.com.wasd.wasd.prototipo.java.model.dao.UsuarioDAO;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.tongfei.progressbar.ProgressBar;

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
        try ( ProgressBar pb = new ProgressBar("Test", 100)) { // name, initial max
            // Use ProgressBar("Test", 100, ProgressBarStyle.ASCII) if you want ASCII output style
            pb.step(); // step by 1
            pb.setExtraMessage("Reading..."); // Set extra message to display at the end of the bar

            if (usuario != null) {
                
                System.out.println("Bem vindo");
                pb.stepBy(30); // step by n
                new DesktopCli(pb);
            } else {
                System.out.println("Senha ou Usuario Incorreto");

            }

        }

    } // progress bar stops automatically after completion of try-with-resource block

}
