/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReservaYa.interfaz;

/**
 *
 * @author santi
 */
public class menu extends javax.swing.JFrame {

    /**
     * Creates new form menu
     */
    public menu() {
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

        ir_kfc = new javax.swing.JButton();
        ir_mcd = new javax.swing.JButton();
        ir_bk = new javax.swing.JButton();
        ir_cw = new javax.swing.JButton();
        ir_sopas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ir_kfc.setText("KFC");
        ir_kfc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ir_kfcActionPerformed(evt);
            }
        });

        ir_mcd.setText("McDonald's");
        ir_mcd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ir_mcdActionPerformed(evt);
            }
        });

        ir_bk.setText("BurguerKing");
        ir_bk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ir_bkActionPerformed(evt);
            }
        });

        ir_cw.setText("Creeps and Whaffles");
        ir_cw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ir_cwActionPerformed(evt);
            }
        });

        ir_sopas.setText("Sopas de mama y postres de la abuela");
        ir_sopas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ir_sopasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ir_mcd, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                    .addComponent(ir_kfc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ir_bk, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                    .addComponent(ir_cw, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                    .addComponent(ir_sopas, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(ir_kfc, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(ir_mcd, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(ir_bk, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(ir_cw, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(ir_sopas, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ir_bkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ir_bkActionPerformed
        BK a = new BK();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ir_bkActionPerformed

    private void ir_cwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ir_cwActionPerformed
        CW a = new CW();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ir_cwActionPerformed

    private void ir_sopasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ir_sopasActionPerformed
        sopas a = new sopas();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ir_sopasActionPerformed

    private void ir_kfcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ir_kfcActionPerformed
        kfc a = new kfc();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ir_kfcActionPerformed

    private void ir_mcdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ir_mcdActionPerformed
        McD a = new McD();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ir_mcdActionPerformed

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
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ir_bk;
    private javax.swing.JButton ir_cw;
    private javax.swing.JButton ir_kfc;
    private javax.swing.JButton ir_mcd;
    private javax.swing.JButton ir_sopas;
    // End of variables declaration//GEN-END:variables
}