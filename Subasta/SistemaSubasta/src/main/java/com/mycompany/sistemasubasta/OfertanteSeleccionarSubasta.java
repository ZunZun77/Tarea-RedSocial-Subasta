/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.sistemasubasta;

/**
 *
 * @author Aymer
 */
import java.net.*;

import javax.swing.DefaultListModel;
import javax.swing.JList;
public class OfertanteSeleccionarSubasta extends javax.swing.JFrame {
    int index = -1;
    String nick;

    /**
     * Creates new form InicioSesionSubastador
     */
    public OfertanteSeleccionarSubasta(String nick, Socket socket) {
        initComponents();
        this.nick = nick;
        NickLabel.setText(nick);
    }
        

    public OfertanteSeleccionarSubasta() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SeleccionarButton = new javax.swing.JButton();
        LabelRandom = new javax.swing.JLabel();
        NickLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DefaultListModel<Subasta> usuarioListModel = new DefaultListModel<>();
        SubastasList = new JList<>(usuarioListModel);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SeleccionarButton.setText("Seleccionar");
        SeleccionarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarButtonActionPerformed(evt);
            }
        });

        LabelRandom.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        LabelRandom.setText("Escoja una subasta");

        NickLabel.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        NickLabel.setText("Nick");

        SubastasList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SubastasListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(SubastasList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(NickLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelRandom)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(SeleccionarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(NickLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelRandom, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SeleccionarButton)))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SeleccionarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarButtonActionPerformed
        if (index != -1){
            System.out.println("Seleccione una subasta");
            return;
        }
        this.dispose();
    }//GEN-LAST:event_SeleccionarButtonActionPerformed

    private void SubastasListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SubastasListMouseClicked
        index = SubastasList.getSelectedIndex();
    }//GEN-LAST:event_SubastasListMouseClicked

    void AgregarPublicacion(Subasta subasta) {
        DefaultListModel<Subasta> model = (DefaultListModel<Subasta>) SubastasList.getModel();

        // Agregar la nueva publicación al modelo existente
        model.addElement(subasta);

        // Actualizar el JList para reflejar los cambios en el modelo
        SubastasList.setModel(model);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OfertanteSeleccionarSubasta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OfertanteSeleccionarSubasta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OfertanteSeleccionarSubasta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OfertanteSeleccionarSubasta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OfertanteSeleccionarSubasta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelRandom;
    private javax.swing.JLabel NickLabel;
    private javax.swing.JButton SeleccionarButton;
    private javax.swing.JList<Subasta> SubastasList;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
