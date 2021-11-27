package br.com.wasd.wasd.prototipo.java;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Bcrypt {

    public boolean checkPassDAO(String password, String passwordBD) {
        if (BCrypt.checkpw(password, passwordBD)) {
            System.out.println("Password Match");
            return true;
        } else {
            System.out.println("No match");
            return false;
        }
    }
}
