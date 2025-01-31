/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package exguiadomenus;

import java.awt.Color;

/**
 *
 * @author xaquin.alvesgonzalez
 */
public class MenuGUI extends javax.swing.JFrame {

    /**
     * Creates new form MenuGUI
     */
    public MenuGUI() {
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

        barraMenus = new javax.swing.JMenuBar();
        meuArchivo = new javax.swing.JMenu();
        jMenuItemAbrir = new javax.swing.JMenuItem();
        jMenuItemGuardar = new javax.swing.JMenuItem();
        jSeparatorArchivo1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemSalir = new javax.swing.JMenuItem();
        meuEdicion = new javax.swing.JMenu();
        jMenuColores = new javax.swing.JMenu();
        jMenuItemRojo = new javax.swing.JMenuItem();
        jMenuItemVerde = new javax.swing.JMenuItem();
        jMenuItemAzul = new javax.swing.JMenuItem();
        meuInsertar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        meuArchivo.setText("Archivo");

        jMenuItemAbrir.setText("Abrir");
        jMenuItemAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAbrirActionPerformed(evt);
            }
        });
        meuArchivo.add(jMenuItemAbrir);

        jMenuItemGuardar.setText("Guardar");
        meuArchivo.add(jMenuItemGuardar);
        meuArchivo.add(jSeparatorArchivo1);

        jMenuItemSalir.setText("Salir");
        jMenuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalirActionPerformed(evt);
            }
        });
        meuArchivo.add(jMenuItemSalir);

        barraMenus.add(meuArchivo);

        meuEdicion.setText("Edición");

        jMenuColores.setText("Colores");

        jMenuItemRojo.setText("Rojo");
        jMenuItemRojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRojoActionPerformed(evt);
            }
        });
        jMenuColores.add(jMenuItemRojo);

        jMenuItemVerde.setText("Verde");
        jMenuItemVerde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVerdeActionPerformed(evt);
            }
        });
        jMenuColores.add(jMenuItemVerde);

        jMenuItemAzul.setText("Azul");
        jMenuItemAzul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAzulActionPerformed(evt);
            }
        });
        jMenuColores.add(jMenuItemAzul);

        meuEdicion.add(jMenuColores);

        barraMenus.add(meuEdicion);

        meuInsertar.setText("Insertar");
        barraMenus.add(meuInsertar);

        setJMenuBar(barraMenus);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAbrirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemAbrirActionPerformed

    private void jMenuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemSalirActionPerformed

    private void jMenuItemRojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRojoActionPerformed
        this.getContentPane().setBackground(Color.RED);
    }//GEN-LAST:event_jMenuItemRojoActionPerformed

    private void jMenuItemVerdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVerdeActionPerformed
        this.getContentPane().setBackground(Color.GREEN);
    }//GEN-LAST:event_jMenuItemVerdeActionPerformed

    private void jMenuItemAzulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAzulActionPerformed
        this.getContentPane().setBackground(Color.BLUE);
    }//GEN-LAST:event_jMenuItemAzulActionPerformed

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
            java.util.logging.Logger.getLogger(MenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenus;
    private javax.swing.JMenu jMenuColores;
    private javax.swing.JMenuItem jMenuItemAbrir;
    private javax.swing.JMenuItem jMenuItemAzul;
    private javax.swing.JMenuItem jMenuItemGuardar;
    private javax.swing.JMenuItem jMenuItemRojo;
    private javax.swing.JMenuItem jMenuItemSalir;
    private javax.swing.JMenuItem jMenuItemVerde;
    private javax.swing.JPopupMenu.Separator jSeparatorArchivo1;
    private javax.swing.JMenu meuArchivo;
    private javax.swing.JMenu meuEdicion;
    private javax.swing.JMenu meuInsertar;
    // End of variables declaration//GEN-END:variables
}
