package Presentacion.Frames;

import Entidades.Objetos.Prenda;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class MantPrendas extends BaseJFrame {

    Prenda pren;
    boolean tinto = false;
    private LinkedList<Prenda> lista = new LinkedList<Prenda>();

    public MantPrendas() {
        initComponents();
        MostrarLoading(false);
        try {
            lista = Logica.Clases.FabricaLogica.getInstancia().getILogicaPrenda().ListarPrendas();
            SetearTabla(lista);
        } catch (Exception ex) {
            lblerror.setText(ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabelLoading1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btneliminarPrenda = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePrendas = new javax.swing.JTable();
        txtPrenda = new javax.swing.JTextField();
        btnAgregarPrenda = new javax.swing.JButton();
        lblerror = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Prendas:");

        jLabelLoading1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLoading1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLoading1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/loading-24x24.GIF"))); // NOI18N
        jLabelLoading1.setToolTipText("Cargando pedido");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 243, Short.MAX_VALUE)
                .addComponent(jLabelLoading1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelLoading1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)))
        );

        btneliminarPrenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/quick_delete-icon24x24.png"))); // NOI18N
        btneliminarPrenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarPrendaActionPerformed(evt);
            }
        });

        jTablePrendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTablePrendas.setOpaque(false);
        jTablePrendas.setRowSelectionAllowed(false);
        jTablePrendas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTablePrendas.setShowHorizontalLines(false);
        jTablePrendas.setShowVerticalLines(false);
        jTablePrendas.setUpdateSelectionOnSort(false);
        jTablePrendas.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(jTablePrendas);

        txtPrenda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrendaFocusGained(evt);
            }
        });

        btnAgregarPrenda.setText("Agregar A Lista");
        btnAgregarPrenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPrendaActionPerformed(evt);
            }
        });

        jLabel1.setText("Tipo de Prenda:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(4, 4, 4)
                        .addComponent(txtPrenda, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAgregarPrenda, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblerror, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btneliminarPrenda, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(46, 46, 46)
                        .addComponent(btnAgregarPrenda)
                        .addGap(31, 31, 31)
                        .addComponent(lblerror, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btneliminarPrenda)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 14, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Reinicio() {
        txtPrenda.setText("");
        try {
            lista = Logica.Clases.FabricaLogica.getInstancia().getILogicaPrenda().ListarPrendas();
            SetearTabla(lista);
        } catch (Exception ex) {
            lblerror.setText(ex.getMessage());
        }
    }

    private void MostrarLoading(boolean mostrar) {
        jLabelLoading1.setVisible(mostrar);
    }

    private void btnAgregarPrendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPrendaActionPerformed
        Thread queryThread = new Thread() {
            @Override
            public void run() {
                try {
                    MostrarLoading(true);
                    if ("".equals(txtPrenda.getText())) {
                        throw new Exception("Debe ingresar el tipo de prenda");
                    }
                    Prenda p = Logica.Clases.FabricaLogica.getInstancia().getILogicaPrenda().BuscarPrendas(txtPrenda.getText());
                    if (p == null) {
                        pren = new Prenda(txtPrenda.getText(), false);
                        Logica.Clases.FabricaLogica.getInstancia().getILogicaPrenda().AltaPrendas(pren);
                        lblerror.setText("Alta exitosa");
                        Reinicio();
                    }
                    else{
                      throw new Exception("Prenda ya existente");
                    }
                } catch (Exception ex) {
                    lblerror.setText(ex.getMessage());
                }
                MostrarLoading(false);
            }
        };
        queryThread.start();
    }//GEN-LAST:event_btnAgregarPrendaActionPerformed

    private void txtPrendaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrendaFocusGained
        lblerror.setText("");
    }//GEN-LAST:event_txtPrendaFocusGained

    private void btneliminarPrendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarPrendaActionPerformed
        Thread queryThread = new Thread() {
            @Override
            public void run() {
                try {
                    MostrarLoading(true);
                    int filaseleccionada = jTablePrendas.getSelectedRow();
                    Prenda p = lista.get(filaseleccionada);
                    Logica.Clases.FabricaLogica.getInstancia().getILogicaPrenda().BajaPrendas(p.getIdpda());
                    Reinicio();
                } catch (Exception ex) {
                    lblerror.setText(ex.getMessage());
                }
                MostrarLoading(false);
            }
        };
        queryThread.start();
    }//GEN-LAST:event_btneliminarPrendaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MantPrendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MantPrendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MantPrendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MantPrendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantPrendas().setVisible(true);
            }
        });
    }
    public void SetearTabla(LinkedList<Prenda> pren) {
        try {
            if (pren == null || pren.size() == 0) {
                //cargo tabla vacia
                jTablePrendas.setModel(
                        new javax.swing.table.DefaultTableModel(
                                new Object[][]{},
                                new String[]{
                                    "Nombre Prenda"
                                }
                        ));
            } else {
                //cargo tabla con datos
                Object[][] datos = new String[pren.size()][2];
                for (int i = 0; i < pren.size(); i++) {

                    datos[i][0] = pren.get(i).getTipo();
                }

                jTablePrendas.setModel(
                        new javax.swing.table.DefaultTableModel(
                                datos,
                                new String[]{
                                    "Nombre Prenda"
                                }
                        ));
            }
        } catch (Exception es) {
            JOptionPane.showMessageDialog(null, es.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarPrenda;
    private javax.swing.JButton btneliminarPrenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelLoading1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePrendas;
    private javax.swing.JLabel lblerror;
    private javax.swing.JTextField txtPrenda;
    // End of variables declaration//GEN-END:variables
}
