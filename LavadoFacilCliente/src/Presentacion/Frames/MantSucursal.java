package Presentacion.Frames;

import Entidades.Objetos.Empleado;
import Entidades.Objetos.Sucursal;
import Entidades.Objetos.Ubicacion;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class MantSucursal extends BaseJFrame {

    Sucursal suc;
    Ubicacion ubic;

    private LinkedList<Sucursal> listasuc = new LinkedList<Sucursal>();

    public MantSucursal() {
        initComponents();
        MostrarLoading(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jbtnAlta = new javax.swing.JButton();
        lblnombre = new javax.swing.JLabel();
        lbltelefono = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        btnBuscar2 = new javax.swing.JButton();
        panelUbicacion1 = new Presentacion.Controls.PanelUbicacion();
        jbtnCancelar = new javax.swing.JButton();
        jbtnEliminar = new javax.swing.JButton();
        jSeparator = new javax.swing.JLabel();
        jbtnModificar = new javax.swing.JButton();
        lblerror = new javax.swing.JLabel();
        listadoSucursales1 = new Presentacion.Controls.ListadoSucursales();
        jLabel2 = new javax.swing.JLabel();
        jLabelLoading1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbtnAlta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/insert-icon24x24.png"))); // NOI18N
        jbtnAlta.setEnabled(false);
        jbtnAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAltaActionPerformed(evt);
            }
        });

        lblnombre.setText("Nombre:");

        lbltelefono.setText("Telefono");

        txtnombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtnombreFocusGained(evt);
            }
        });

        txttelefono.setEnabled(false);
        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefonoKeyTyped(evt);
            }
        });

        btnBuscar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/search-icon24x24.png"))); // NOI18N
        btnBuscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar2ActionPerformed(evt);
            }
        });

        jbtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/cancel-icon24x24.png"))); // NOI18N
        jbtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarActionPerformed(evt);
            }
        });

        jbtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/delete-icon24x24.png"))); // NOI18N
        jbtnEliminar.setEnabled(false);
        jbtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEliminarActionPerformed(evt);
            }
        });

        jSeparator.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/Separator-icon.png"))); // NOI18N
        jSeparator.setPreferredSize(new java.awt.Dimension(6, 24));

        jbtnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/update2-icon24x24.png"))); // NOI18N
        jbtnModificar.setEnabled(false);
        jbtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblerror)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblnombre)
                                    .addComponent(lbltelefono))
                                .addGap(56, 56, 56)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txttelefono)
                                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbtnAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addComponent(panelUbicacion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtnAlta)
                            .addComponent(jbtnModificar)
                            .addComponent(jbtnEliminar)
                            .addComponent(jbtnCancelar)
                            .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblnombre)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(btnBuscar2)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbltelefono)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(panelUbicacion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblerror)
                .addGap(232, 232, 232))
        );

        jTabbedPane1.addTab("Mantenimiento", jPanel1);
        jTabbedPane1.addTab("Listados", listadoSucursales1);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Mantenimiento de sucursales:");

        jLabelLoading1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLoading1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLoading1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/loading-24x24.GIF"))); // NOI18N
        jLabelLoading1.setToolTipText("Cargando pedido");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelLoading1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelLoading1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnModificarActionPerformed
        Thread queryThread = new Thread() {
            @Override
            public void run() {
                try {
                    MostrarLoading(true);
                    Ubicacion ubactual = suc.getUbicacion();
                    if ("".equals(txttelefono.getText())) {
                        throw new Exception("El telefono de la sucursal es necesario");
                    }
                    suc.setTelefono(txttelefono.getText());
                    Ubicacion ub = panelUbicacion1.ModificarUbicacion();
                    suc.setUbicacion(ub);

                    listasuc = Logica.Clases.FabricaLogica.getInstancia().getILogicaSucursales().ListarSucursales();
                    int totales = 0;
                    for (int i = 0; i < listasuc.size(); i++) {
                        Sucursal s = listasuc.get(i);
                        if (s.getUbicacion().getDireccion().equals(ubactual.getDireccion()))
                        {
                           if(!s.getNombreSuc().equals(suc.getNombreSuc()))
                           {
                            totales++;
                           }
                        }
                    }
                    Logica.Clases.FabricaLogica.getInstancia().getILogicaUbicacion().BajaRelacion_ubicsucursales(ubactual.getId(), suc.getIdSuc());
                    if (totales == 0 && !suc.getUbicacion().getDireccion().equals(ubactual.getDireccion())) {
                        Logica.Clases.FabricaLogica.getInstancia().getILogicaUbicacion().BajaUbicacion(ubactual.getId());
                    }
                    Logica.Clases.FabricaLogica.getInstancia().getILogicaSucursales().ModificarSucursal(suc);
                    lblerror.setText("Modificacion exitosa");
                    Reinicio();
                } catch (Exception ex) {
                    lblerror.setText(ex.getMessage());
                }
                MostrarLoading(false);
            }
        };
        queryThread.start();
    }//GEN-LAST:event_jbtnModificarActionPerformed

    private void jbtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEliminarActionPerformed
        Thread queryThread = new Thread() {
            @Override
            public void run() {
                try {
                    MostrarLoading(true);
                    Ubicacion ub = panelUbicacion1.BuscarUbicacion(suc.getUbicacion().getDireccion());
                    Logica.Clases.FabricaLogica.getInstancia().getILogicaUbicacion().BajaRelacion_ubicsucursales(ub.getId(), suc.getIdSuc());
                    Logica.Clases.FabricaLogica.getInstancia().getILogicaSucursales().BajaSucursal(suc.getIdSuc());
                    Logica.Clases.FabricaLogica.getInstancia().getILogicaUbicacion().BajaUbicacion(ub.getId());
                    lblerror.setText("Baja exitosa");
                    Reinicio();
                } catch (Exception ex) {
                    lblerror.setText(ex.getMessage());
                }
                MostrarLoading(false);
            }
        };
        queryThread.start();
    }//GEN-LAST:event_jbtnEliminarActionPerformed

    private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarActionPerformed
        Thread queryThread = new Thread() {
            @Override
            public void run() {
                try {
                    MostrarLoading(true);
                    Reinicio();
                } catch (Exception es) {
                    lblerror.setText(es.getMessage());
                }
                MostrarLoading(false);
            }
        };
        queryThread.start();
    }//GEN-LAST:event_jbtnCancelarActionPerformed

    private void btnBuscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar2ActionPerformed
        if (btnBuscar2.isEnabled()) {
            Thread queryThread = new Thread() {
                @Override
                public void run() {
                    try {
                        MostrarLoading(true);
                        if ("".equals(txtnombre.getText())) {
                            throw new Exception("Ingrese El nombre de la sucursal");
                        }
                        suc = Logica.Clases.FabricaLogica.getInstancia().getILogicaSucursales().BuscarSucursal(txtnombre.getText());

                        if (suc == null) {
                            ActivoParaAlta();
                        } else {
                            MostrarDatos();
                        }
                    } catch (Exception es) {
                        lblerror.setText(es.getMessage());
                    }
                    MostrarLoading(false);
                }
            };
            queryThread.start();
        }
    }//GEN-LAST:event_btnBuscar2ActionPerformed

    private void txttelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyTyped
        char num = evt.getKeyChar();
        if (num < '0' || num > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txttelefonoKeyTyped

    private void txtnombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnombreFocusGained
        lblerror.setText("");
    }//GEN-LAST:event_txtnombreFocusGained

    private void jbtnAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAltaActionPerformed
        Thread queryThread = new Thread() {
            @Override
            public void run() {
                try {
                    MostrarLoading(true);
                    if ("".equals(txtnombre.getText())) {
                        throw new Exception("Primero debe ingresar el nombre de la sucursal para dar de alta");
                    }
                    if ("".equals(txttelefono.getText())) {
                        throw new Exception("El telefono de la sucursal es necesario");
                    }

                    suc = new Sucursal(txtnombre.getText(), txttelefono.getText());
                    if (suc != null) {
                        Ubicacion ub = panelUbicacion1.AltaUbicacion();
                        suc.setUbicacion(ub);
                    }
                    Logica.Clases.FabricaLogica.getInstancia().getILogicaSucursales().AltaSucursales(suc);
                    lblerror.setText("Alta exitosa");
                    Reinicio();
                } catch (Exception ex) {
                    lblerror.setText(ex.getMessage());
                }
                MostrarLoading(false);
            }
        };
        queryThread.start();
    }//GEN-LAST:event_jbtnAltaActionPerformed

   

    public void ActivoParaAlta() {
        panelUbicacion1.ActivoParaAlta();
        txtnombre.setEnabled(false);
        txttelefono.setEnabled(true);
        panelUbicacion1.setEnabled(true);
        jbtnAlta.setEnabled(true);
        jbtnEliminar.setEnabled(false);
        jbtnModificar.setEnabled(false);
        btnBuscar2.setEnabled(false);
    }

    public void MostrarDatos() {
        txtnombre.setEnabled(false);
        txttelefono.setEnabled(true);
        txtnombre.setText(suc.getNombreSuc());
        txttelefono.setText(suc.getTelefono());
        jbtnAlta.setEnabled(false);
        jbtnEliminar.setEnabled(true);
        jbtnModificar.setEnabled(true);
        panelUbicacion1.MostrarDatos(suc.getUbicacion());
        panelUbicacion1.setEnabled(true);
    }

    public void Reinicio() {
        txtnombre.setEnabled(true);
        txttelefono.setEnabled(false);
        jbtnAlta.setEnabled(false);
        jbtnEliminar.setEnabled(false);
        jbtnModificar.setEnabled(false);
        btnBuscar2.setEnabled(true);
        txtnombre.setText("");
        txttelefono.setText("");
        panelUbicacion1.setEnabled(false);
        panelUbicacion1.ModoDefault();
    }
    private void MostrarLoading(boolean mostrar) {
        jLabelLoading1.setVisible(mostrar);
    }
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
//            java.util.logging.Logger.getLogger(MantSucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MantSucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MantSucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MantSucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantSucursal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelLoading1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jSeparator;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbtnAlta;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnEliminar;
    private javax.swing.JButton jbtnModificar;
    private javax.swing.JLabel lblerror;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JLabel lbltelefono;
    private Presentacion.Controls.ListadoSucursales listadoSucursales1;
    private Presentacion.Controls.PanelUbicacion panelUbicacion1;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
