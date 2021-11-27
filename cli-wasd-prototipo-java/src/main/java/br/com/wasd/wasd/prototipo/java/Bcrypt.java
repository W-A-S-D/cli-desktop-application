package br.com.wasd.wasd.prototipo.java;

import java.util.Scanner;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class Bcrypt {

    private String password = "admin";

    private String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(10));

    public String hashPassword(String password) {
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt(8));
        return hashed;
    }

//    public void checkPass(String password) {;
//        if (BCrypt.checkpw(password, hashedPassword)) {
//            System.out.println("Password Match");
//        } else {
//            System.out.println("No match");
//        }
//    }

//    public static void main(String[] args) {;
//        Bcrypt encriptar = new Bcrypt();
//        Scanner leitor = new Scanner(System.in);
//        String senha;
//
//        System.out.println("Digite sua senha");
//        senha = leitor.nextLine();
//        String hashedPassword = BCrypt.hashpw(senha, BCrypt.gensalt(10));
//
//        encriptar.checkPass(senha);
//
//        System.out.println("");
//        System.out.println("Senha digitada:");
//        System.out.println(senha);
//        System.out.println(hashedPassword);
//        System.out.println("");
//        System.out.println("");
//
//        System.out.println("Senha 'do azure' ");
//        System.out.println(encriptar.password);
//        System.out.println(encriptar.hashedPassword);
//
//        encriptar.checkPass(senha);
//    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

}
