package animales;

import javax.swing.JOptionPane;

/**
 * Esta clase crea unha xanela con 3 opcions(can, gato, galo) e un boton que o
 * pulsalo crea un diálogo co son que fai o animal seleccionado
 *
 * @author Xaquin Alves Gonzalez
 */
public class AnimalesGUI extends javax.swing.JFrame {

    /**
     * Creates new form AnimalesGUI
     */
    public AnimalesGUI() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jDialogMensaxe = new javax.swing.JDialog();
        jRadioButtonCan = new javax.swing.JRadioButton();
        jRadioButtonGato = new javax.swing.JRadioButton();
        jRadioButtonGalo = new javax.swing.JRadioButton();
        jButtonFalar = new javax.swing.JButton();

        buttonGroup1.add(jRadioButtonCan);
        buttonGroup1.add(jRadioButtonGalo);
        buttonGroup1.add(jRadioButtonGato);

        javax.swing.GroupLayout jDialogMensaxeLayout = new javax.swing.GroupLayout(jDialogMensaxe.getContentPane());
        jDialogMensaxe.getContentPane().setLayout(jDialogMensaxeLayout);
        jDialogMensaxeLayout.setHorizontalGroup(
            jDialogMensaxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialogMensaxeLayout.setVerticalGroup(
            jDialogMensaxeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jRadioButtonCan.setText("Can");

        jRadioButtonGato.setText("Gato");

        jRadioButtonGalo.setText("Galo");

        jButtonFalar.setText("Falar");
        jButtonFalar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFalarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jRadioButtonGalo)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jRadioButtonGato)
                                .addComponent(jRadioButtonCan))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jButtonFalar)))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jRadioButtonCan)
                .addGap(20, 20, 20)
                .addComponent(jRadioButtonGato)
                .addGap(20, 20, 20)
                .addComponent(jRadioButtonGalo)
                .addGap(50, 50, 50)
                .addComponent(jButtonFalar)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Crea un JDialog con unha mensaxe dependendo da opcion seleccionada
     *
     * @param evt
     */
    private void jButtonFalarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFalarActionPerformed
        String mensage = "";
        if (jRadioButtonCan.isSelected()) {
            mensage = "GUAU!";
        } else if (jRadioButtonGato.isSelected()) {
            mensage = "miau";
        } else if (jRadioButtonGalo.isSelected()) {
            mensage = "KIKIRIKII!!!!";
        }

        JOptionPane.showMessageDialog(jDialogMensaxe, mensage);
    }//GEN-LAST:event_jButtonFalarActionPerformed

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
            java.util.logging.Logger.getLogger(AnimalesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnimalesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnimalesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnimalesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnimalesGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonFalar;
    private javax.swing.JDialog jDialogMensaxe;
    private javax.swing.JRadioButton jRadioButtonCan;
    private javax.swing.JRadioButton jRadioButtonGalo;
    private javax.swing.JRadioButton jRadioButtonGato;
    // End of variables declaration//GEN-END:variables
}
