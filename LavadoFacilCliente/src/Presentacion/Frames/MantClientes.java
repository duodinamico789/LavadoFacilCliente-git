package Presentacion.Frames;

import Entidades.Objetos.Cliente;
import Entidades.Objetos.Persona;
import Entidades.Objetos.Ubicacion;
import java.util.LinkedList;

public class MantClientes extends BaseJFrame {

    private Entidades.Objetos.Persona cli;
    private LinkedList<Cliente> listaper;
    String contraseña;
    boolean registrado;

    public MantClientes() {
        initComponents();
        MostrarLoading(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jbtnAlta = new javax.swing.JButton();
        jbtnModificar = new javax.swing.JButton();
        jbtnEliminar = new javax.swing.JButton();
        jSeparator = new javax.swing.JLabel();
        jbtnCancelar = new javax.swing.JButton();
        lblcedula = new javax.swing.JLabel();
        txtcedula = new javax.swing.JTextField();
        lblnombre = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        panelUbicacion1 = new Presentacion.Controls.PanelUbicacion();
        lbltelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblcelular = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        lblerror = new javax.swing.JLabel();
        listadoClientes2 = new Presentacion.Controls.ListadoClientes();
        jLabel3 = new javax.swing.JLabel();
        jLabelLoading1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jbtnAlta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/insert-icon24x24.png"))); // NOI18N
        jbtnAlta.setEnabled(false);
        jbtnAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAltaActionPerformed(evt);
            }
        });

        jbtnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/update2-icon24x24.png"))); // NOI18N
        jbtnModificar.setEnabled(false);
        jbtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnModificarActionPerformed(evt);
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

        jbtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/cancel-icon24x24.png"))); // NOI18N
        jbtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarActionPerformed(evt);
            }
        });

        lblcedula.setText("Cedula:");

        txtcedula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtcedulaFocusGained(evt);
            }
        });
        txtcedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcedulaKeyTyped(evt);
            }
        });

        lblnombre.setText("Nombre:");

        txtnombre.setEnabled(false);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/search-icon24x24.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lbltelefono.setText("Telefono:");

        txtTelefono.setEnabled(false);
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        lblcelular.setText("Celular:");

        txtCelular.setEnabled(false);
        txtCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCelularKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jbtnAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblcedula)
                                    .addComponent(lblnombre)
                                    .addComponent(lbltelefono)
                                    .addComponent(lblcelular))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jbtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(panelUbicacion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblerror)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnAlta)
                    .addComponent(jbtnModificar)
                    .addComponent(jbtnEliminar)
                    .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnCancelar))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblcedula)
                                .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnBuscar))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblnombre))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbltelefono))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblcelular)
                            .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(panelUbicacion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(lblerror)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Mantenimiento", jPanel1);
        jTabbedPane1.addTab("Listado", listadoClientes2);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Clientes:");

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
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabelLoading1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelLoading1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reinicio() {
        txtcedula.setEnabled(true);
        txtCelular.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtnombre.setEnabled(false);
        panelUbicacion1.setEnabled(false);
        panelUbicacion1.ModoDefault();
        jbtnAlta.setEnabled(false);
        jbtnEliminar.setEnabled(false);
        jbtnModificar.setEnabled(false);
        btnBuscar.setEnabled(true);
        txtcedula.setText("");
        txtCelular.setText("");
        txtTelefono.setText("");
        txtnombre.setText("");
    }

    private void mostrardatos() {
        txtcedula.setEnabled(false);
        txtCelular.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtnombre.setEnabled(true);
        txtcedula.setText(cli.getCedula());
        txtCelular.setText(cli.getCelular());
        txtTelefono.setText(cli.getTelefono());
        txtnombre.setText(cli.getNombre());
        panelUbicacion1.MostrarDatos(cli.getUbicacion());
        panelUbicacion1.setEnabled(true);
        jbtnAlta.setEnabled(false);
        jbtnEliminar.setEnabled(true);
        jbtnModificar.setEnabled(true);
        lblerror.setText("");
    }

    private void ActivoParaAlta() {
        txtcedula.setEnabled(false);
        txtTelefono.setEnabled(true);
        txtCelular.setEnabled(true);
        txtnombre.setEnabled(true);
        panelUbicacion1.setEnabled(true);
        panelUbicacion1.ActivoParaAlta();
        jbtnAlta.setEnabled(true);
        btnBuscar.setEnabled(false);
        lblerror.setText("");
    }
    private void jbtnAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAltaActionPerformed
        Thread queryThread = new Thread() {
            @Override
            public void run() {
                try {
                    MostrarLoading(true);
                    if ("".equals(txtcedula.getText())) {
                        throw new Exception("Primero debe ingresar una cedula para dar de alta");
                    }

                    contraseña = "Usuario1";
                    if ("".equals(txtnombre.getText())) {
                        throw new Exception("Nombre del cliente vacio");
                    }
                    if ("".equals(txtCelular.getText()) && "".equals(txtTelefono.getText())) {
                        throw new Exception("Debe ingresar al menos algun numero de contacto");
                    }
                    cli = new Cliente(txtcedula.getText(), contraseña, txtnombre.getText(),
                            txtTelefono.getText(), txtCelular.getText(), null, null);

                    if (cli != null) {
                        Ubicacion ub = panelUbicacion1.AltaUbicacion();
                        if(ub == null)
                        {
                          throw new Exception("Compruebe datos de ubicacion");
                        }
                        cli.setUbicacion(ub);
                    }
                    Logica.Clases.FabricaLogica.getInstancia().getILogicaPersonas().AltaPersona(cli);
                    lblerror.setText("Alta Exitosa");
                    reinicio();
                } catch (Exception ex) {
                    lblerror.setText(ex.getMessage());
                }
                MostrarLoading(false);
            }
        };
        queryThread.start();

    }//GEN-LAST:event_jbtnAltaActionPerformed

    private void jbtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnModificarActionPerformed
        Thread queryThread = new Thread() {
            @Override
            public void run() {
                try {
                    MostrarLoading(true);
                    Ubicacion ubactual = cli.getUbicacion();

                    contraseña = "Usuario1";
                    if ("".equals(txtCelular.getText()) || "".equals(txtTelefono.getText()) || "".equals(txtnombre.getText())) {
                        throw new Exception("Todos los campos son obligatorios");
                    }
                    cli = new Cliente(txtcedula.getText(), contraseña, txtnombre.getText(),
                            txtTelefono.getText(), txtCelular.getText(), null, null);

                    if (cli != null) {
                        Ubicacion ub = panelUbicacion1.ModificarUbicacion();
                        if(ub == null)
                        {
                          throw new Exception("Compruebe datos de ubicacion");
                        }
                        cli.setUbicacion(ub);
                    }
                    listaper = Logica.Clases.FabricaLogica.getInstancia().getILogicaPersonas().ListarClientesXFechareg();
                    int totales = 0;
                    for (int i = 0; i < listaper.size(); i++) {
                        Cliente c = listaper.get(i);
                        if (c.getUbicacion().getDireccion().equals(ubactual.getDireccion()) && !c.getCedula().equals(cli.getCedula())) {
                            totales++;
                        }
                    }
                  //  Logica.Clases.FabricaLogica.getInstancia().getILogicaUbicacion().BajaRelacion_UbicPerson(ubactual.getId(), cli.getCedula());
                    if (totales == 0 && !cli.getUbicacion().getDireccion().equals(ubactual.getDireccion())) {
                        Logica.Clases.FabricaLogica.getInstancia().getILogicaUbicacion().BajaUbicacion(ubactual.getId());
                    }

                    Logica.Clases.FabricaLogica.getInstancia().getILogicaPersonas().ModificarPersona(cli);

                    lblerror.setText("Modificacion exitosa");
                    reinicio();
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
                    int retorno = Logica.Clases.FabricaLogica.getInstancia().getILogicaPersonas().BajaPersona(txtcedula.getText());
                    if(retorno ==1)
                    {
                    Logica.Clases.FabricaLogica.getInstancia().getILogicaUbicacion().BajaUbicacion(cli.getUbicacion().getId());
                    }
                    reinicio();
                    lblerror.setText("Baja exitosa");
                } catch (Exception es) {
                    lblerror.setText(es.getMessage());
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
                    reinicio();
                } catch (Exception es) {
                    lblerror.setText(es.getMessage());
                }
                MostrarLoading(false);
            }
        };
        queryThread.start();
    }//GEN-LAST:event_jbtnCancelarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        if (btnBuscar.isEnabled()) {
            Thread queryThread = new Thread() {
                @Override
                public void run() {
                    try {
                        MostrarLoading(true);
                        if ("".equals(txtcedula.getText())) {
                            throw new Exception("Ingrese la cedula del cliente");
                        } else {
                            cli = Logica.Clases.FabricaLogica.getInstancia().getILogicaPersonas().BuscarPersona(txtcedula.getText());
                        }
                        if (cli instanceof Entidades.Objetos.Empleado) {
                            throw new Exception("La cedula corresponde a un empleado");
                        }
                        if (cli == null) {
                            ActivoParaAlta();
                        } else {
                            mostrardatos();
                        }
                    } catch (Exception es) {
                        lblerror.setText(es.getMessage());
                    }
                    MostrarLoading(false);
                }
            };
            queryThread.start();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed
    private void MostrarLoading(boolean mostrar) {
        jLabelLoading1.setVisible(mostrar);
    }
    private void txtcedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaKeyTyped
        char num = evt.getKeyChar();
        if (num < '0' || num > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtcedulaKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        char num = evt.getKeyChar();
        if (num < '0' || num > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularKeyTyped
        char num = evt.getKeyChar();
        if (num < '0' || num > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtCelularKeyTyped

    private void txtcedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcedulaActionPerformed

    private void txtcedulaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcedulaFocusGained
        lblerror.setText("");
    }//GEN-LAST:event_txtcedulaFocusGained

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
//            java.util.logging.Logger.getLogger(MantClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MantClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MantClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MantClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MantClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelLoading1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jSeparator;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbtnAlta;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnEliminar;
    private javax.swing.JButton jbtnModificar;
    private javax.swing.JLabel lblcedula;
    private javax.swing.JLabel lblcelular;
    private javax.swing.JLabel lblerror;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JLabel lbltelefono;
    private Presentacion.Controls.ListadoClientes listadoClientes2;
    private Presentacion.Controls.PanelUbicacion panelUbicacion1;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
