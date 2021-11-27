package br.com.wasd.wasd.prototipo.java;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Bcrypt {

    private String password = "teste";

    private String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(8));
    

    public void checkPass(String password) {
        if (BCrypt.checkpw(password, hashedPassword)) {
            System.out.println("Password Match");
        } else {
            System.out.println("No match");
        }
    }
    
    public static void main(String[] args) {
        Bcrypt encriptar = new Bcrypt();
        
        encriptar.checkPass("admin");
        
        System.out.println(encriptar.hashedPassword);
    }
}
