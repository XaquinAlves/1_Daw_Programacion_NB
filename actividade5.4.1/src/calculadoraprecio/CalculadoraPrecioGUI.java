package calculadoraprecio;

import javax.swing.JOptionPane;

/**
 *
 * @author xaquin.alvesgonzalez
 */
public class CalculadoraPrecioGUI extends javax.swing.JFrame {

    private double tax = 21;
    private double discount = 0;

    /**
     * Creates new form CalculadoraPrecioGUI
     */
    public CalculadoraPrecioGUI() {
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

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabelUnidades = new javax.swing.JLabel();
        jLabelPrecio = new javax.swing.JLabel();
        jTextFieldUnidades = new javax.swing.JTextField();
        jTextFieldPrecio = new javax.swing.JTextField();
        jButtonCalcular = new javax.swing.JButton();
        jButtonConfig = new javax.swing.JButton();
        jLabelTotal = new javax.swing.JLabel();
        jLabelResult = new javax.swing.JLabel();

        jDesktopPane1.setPreferredSize(new java.awt.Dimension(300, 250));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelUnidades.setFont(new java.awt.Font("FreeMono", 1, 16)); // NOI18N
        jLabelUnidades.setText("Unidades:");

        jLabelPrecio.setFont(new java.awt.Font("FreeMono", 1, 16)); // NOI18N
        jLabelPrecio.setText("Precio:");

        jTextFieldUnidades.setText("0");

        jTextFieldPrecio.setText("0");

        jButtonCalcular.setText("Calcular");
        jButtonCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalcularActionPerformed(evt);
            }
        });

        jButtonConfig.setText("Configuración");
        jButtonConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfigActionPerformed(evt);
            }
        });

        jLabelTotal.setFont(new java.awt.Font("FreeMono", 1, 16)); // NOI18N
        jLabelTotal.setText("TOTAL:");

        jLabelResult.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelResult.setToolTipText("");
        jLabelResult.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelUnidades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldPrecio)
                            .addComponent(jTextFieldUnidades)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelResult, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonCalcular)
                        .addGap(40, 40, 40)
                        .addComponent(jButtonConfig)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUnidades)
                    .addComponent(jTextFieldUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPrecio)
                    .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTotal)
                    .addComponent(jLabelResult, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCalcular)
                    .addComponent(jButtonConfig))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalcularActionPerformed
        double result = 0.0;
        try {
            result = Double.parseDouble(jTextFieldPrecio.getText()) * 
                    Double.parseDouble(jTextFieldUnidades.getText()) * (tax/100 + 1) * (1 - discount/100);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, """
                                                O valor introducino no campo Precio ou Unidades non é numérico.
                                                Non se pode calcular""");
        }
  
        jLabelResult.setText(String.valueOf(result));
        
    }//GEN-LAST:event_jButtonCalcularActionPerformed
    /**
     * Amosa un dialogo no que se pode modificar o IVA e desconto aplicados
     *
     * @param evt
     */
    private void jButtonConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfigActionPerformed
        JDialogConfig dialogConfig = new JDialogConfig(this, true, tax, discount);
        dialogConfig.setVisible(true);
        
        if (dialogConfig.isAccepted()) {
            tax = dialogConfig.getIva();
            discount = dialogConfig.getDiscount();
        } 
    }//GEN-LAST:event_jButtonConfigActionPerformed
    /**
     *
     * @return iva gardado
     */
    public double getTax() {
        return tax;
    }

    /**
     * Establece o iva
     *
     * @param tax iva a establecer
     */
    public void setTax(double tax) {
        this.tax = tax;
    }

    /**
     *
     * @return desconto gardado
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * Establece o desconto
     *
     * @param discount
     */
    public void setDiscount(double discount) {
        this.discount = discount;
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
            java.util.logging.Logger.getLogger(CalculadoraPrecioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalculadoraPrecioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalculadoraPrecioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalculadoraPrecioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalculadoraPrecioGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCalcular;
    private javax.swing.JButton jButtonConfig;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JLabel jLabelResult;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JLabel jLabelUnidades;
    private javax.swing.JTextField jTextFieldPrecio;
    private javax.swing.JTextField jTextFieldUnidades;
    // End of variables declaration//GEN-END:variables
}
