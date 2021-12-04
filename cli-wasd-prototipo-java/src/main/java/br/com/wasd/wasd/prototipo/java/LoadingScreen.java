package br.com.wasd.wasd.prototipo.java;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class LoadingScreen extends javax.swing.JFrame {

    private Boolean LoadingVar;

    public LoadingScreen() {
        LoadingVar = true;
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoadingScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(LoadingScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(LoadingScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(LoadingScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public void setLoadingVar(Boolean LoadingVar) {
        this.LoadingVar = LoadingVar;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackgroundColor = new javax.swing.JPanel();
        LoadingLabel = new javax.swing.JLabel();
        LoadingValue = new javax.swing.JLabel();
        LoadingBar = new javax.swing.JProgressBar();
        gif_wasd = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        BackgroundColor.setBackground(new java.awt.Color(0, 0, 0));
        BackgroundColor.setForeground(new java.awt.Color(0, 0, 0));
        BackgroundColor.setPreferredSize(new java.awt.Dimension(705, 532));

        LoadingLabel.setBackground(new java.awt.Color(255, 255, 255));
        LoadingLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LoadingLabel.setForeground(new java.awt.Color(255, 255, 255));
        LoadingLabel.setText("Loading...");

        LoadingValue.setBackground(new java.awt.Color(255, 255, 255));
        LoadingValue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LoadingValue.setForeground(new java.awt.Color(255, 255, 255));
        LoadingValue.setText("0 %");

        LoadingBar.setBackground(new java.awt.Color(0, 0, 0));
        LoadingBar.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 3)); // NOI18N
        LoadingBar.setForeground(new java.awt.Color(0, 0, 0));

        gif_wasd.setBackground(new java.awt.Color(0, 0, 0));
        gif_wasd.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("http://minharede.ddns.net:85/projetoPi/Load.gif")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        gif_wasd.setPreferredSize(new java.awt.Dimension(705, 388));

        javax.swing.GroupLayout BackgroundColorLayout = new javax.swing.GroupLayout(BackgroundColor);
        BackgroundColor.setLayout(BackgroundColorLayout);
        BackgroundColorLayout.setHorizontalGroup(
            BackgroundColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LoadingBar, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
            .addGroup(BackgroundColorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BackgroundColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gif_wasd, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(BackgroundColorLayout.createSequentialGroup()
                        .addComponent(LoadingLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 553, Short.MAX_VALUE)
                        .addComponent(LoadingValue, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        BackgroundColorLayout.setVerticalGroup(
            BackgroundColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundColorLayout.createSequentialGroup()
                .addComponent(gif_wasd, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addGroup(BackgroundColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LoadingValue)
                    .addComponent(LoadingLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LoadingBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackgroundColor, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackgroundColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void load() {
        //Do whatever
        LoadingScreen sp = new LoadingScreen();
        sp.setVisible(true);
        Integer j = 100;
        try {
            sp.LoadingBar.setForeground(new Color(149, 173, 253));
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(j);
                sp.LoadingValue.setText(i + "%");

                if (i == 10) {
                    sp.LoadingLabel.setText("Efetuando login");
                    j = 300;
                }
                if (i == 30) {
                    sp.LoadingLabel.setText("Capturando dados do hardware...");
                    j = 200;
                }
                if (i == 50) {
                    sp.LoadingLabel.setText("Conectando com o Banco de Dados...");
                    j = 200;
                }
                if (i == 70) {
                    sp.LoadingLabel.setText("Carregando Interface...");
                    j = 300;
                }
                if (i == 85) {
                    sp.LoadingLabel.setText("Iniciando Aplicação...");
                    j = 100;
                }
                if (i == 99) {
                    dispose();
                    sp.setVisible(false);
                    break;
                }
                if (LoadingVar == false) {
                    dispose();
                    sp.setVisible(false);
                    break;
                }
                sp.LoadingBar.setValue(i);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackgroundColor;
    private javax.swing.JProgressBar LoadingBar;
    private javax.swing.JLabel LoadingLabel;
    private javax.swing.JLabel LoadingValue;
    private javax.swing.JLabel gif_wasd;
    // End of variables declaration//GEN-END:variables
}
