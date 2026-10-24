/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tarea3;
import java.io.*;
import javax.swing.*;

/**
 *
 * @author nig
 */
public class Temperatura extends javax.swing.JFrame {
    double[] temperaturas = new double[6];
    int indice = 0;
    boolean datosCargados = false;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Temperatura.class.getName());

    /**
     * Creates new form Temperatura
     */
    public Temperatura() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCargar = new javax.swing.JButton();
        btnCalcular = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaResultados = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCargar.setText("cargar datos");
        btnCargar.addActionListener(this::btnCargarActionPerformed);

        btnCalcular.setText("calcular Es");
        btnCalcular.addActionListener(this::btnCalcularActionPerformed);

        areaResultados.setColumns(20);
        areaResultados.setRows(5);
        jScrollPane1.setViewportView(areaResultados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(btnCargar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(btnCalcular)
                .addGap(91, 91, 91))
            .addGroup(layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCargar)
                    .addComponent(btnCalcular))
                .addGap(118, 118, 118))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
try {

    BufferedReader lector =
            new BufferedReader(
                    new FileReader("temp/temperaturas.txt"));

    String linea;
    indice = 0;

    while ((linea = lector.readLine()) != null && indice < 6) {

        temperaturas[indice] = Double.parseDouble(linea);
        indice++;
    }

    lector.close();

    datosCargados = true;

    JOptionPane.showMessageDialog(this,
            "Datos cargados correctamente");

} catch (Exception e) {

    JOptionPane.showMessageDialog(this,
            "Error: " + e.getMessage());
}

        // TODO add your handling code here:
    }//GEN-LAST:event_btnCargarActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed

if (!datosCargados) {

    JOptionPane.showMessageDialog(this,
            "Primero cargue los datos");

    return;
}

double suma = 0;
int diasCalidos = 0;
int diasFrescos = 0;

for (int i = 0; i < temperaturas.length; i++) {

    suma += temperaturas[i];

    if (temperaturas[i] >= 25) {
        diasCalidos++;
    } else {
        diasFrescos++;
    }
}

double promedio = suma / temperaturas.length;

areaResultados.setText(
        "Análisis Climático\n\n" +
        "--------------------------\n\n" +
        "Promedio de Temperatura: "
        + promedio + "\n\n" +
        "Días Cálidos (>=25): "
        + diasCalidos + "\n\n" +
        "Días Frescos (<25): "
        + diasFrescos);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnCalcularActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Temperatura().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaResultados;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnCargar;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
