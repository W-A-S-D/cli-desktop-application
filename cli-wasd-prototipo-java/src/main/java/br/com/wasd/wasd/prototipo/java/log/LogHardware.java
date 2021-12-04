/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wasd.wasd.prototipo.java.log;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LogHardware {

    DateTimeFormatter data = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    DateTimeFormatter dataHoraMinuto = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    List<String> listaLog = new ArrayList();
    
    public void salvandoLog(String MensagemLog) {
        String dataLog = dataHoraMinuto.format(LocalDateTime.now());
        listaLog.add("      " + dataLog + "\n ------------------------------ \n" + MensagemLog + "\n ------------------------------ \n");

        try {
            gravarLog();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

    public void gravarLog() throws IOException {
        String dataLog = data.format(LocalDateTime.now());
        FileWriter gerarLog = new FileWriter(String.format("%s-hardware-log.txt", dataLog));
        PrintWriter gravarLog = new PrintWriter(gerarLog);
        
        gravarLog.print(listaLog.get(listaLog.size()-1));
        
        gerarLog.close();
    }
}
