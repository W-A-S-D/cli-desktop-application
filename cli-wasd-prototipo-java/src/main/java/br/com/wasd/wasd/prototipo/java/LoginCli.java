package br.com.wasd.wasd.prototipo.java;

import br.com.wasd.wasd.prototipo.java.model.Usuario;
import br.com.wasd.wasd.prototipo.java.model.dao.UsuarioDAO;
import java.net.UnknownHostException;
import java.util.Scanner;

public class LoginCli {

    public static void main(String[] args) throws UnknownHostException, InterruptedException {
        Scanner leitor = new Scanner(System.in);
        Usuario usuario;
        UsuarioDAO dao = new UsuarioDAO();

        String login;
        String senha;

        System.out.println("Bem vindo ao WASD! \nfaça seu login:");
        login = leitor.next();
        System.out.println("Digite a sua senha");
        senha = leitor.next();
        usuario = dao.login(login, senha);
        
        if (usuario != null) {
            System.out.println("Bem vindo");
            new DesktopCli();
        }else{
            System.out.println("Senha ou Usuario Incorreto");
        }
    }
}
