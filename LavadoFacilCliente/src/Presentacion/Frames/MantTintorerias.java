package Presentacion.Frames;

import java.util.LinkedList;
import Entidades.Objetos.Tintoreria;
import Entidades.Objetos.Sucursal;
import Entidades.Objetos.Ubicacion;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class MantTintorerias extends BaseJFrame {

    private static String EMPTY = "";
    private Tintoreria tint;
    private LinkedList<Sucursal> listaCombo = new LinkedList<Sucursal>();
    private LinkedList<Sucursal> listaTabla = new LinkedList<Sucursal>();
    private LinkedList<Tintoreria> listatint = new LinkedList<Tintoreria>();

    public MantTintorerias() {
        initComponents();
        SetModoDefault();
        MostrarLoading(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelLoading1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtxtNombre = new javax.swing.JTextField();
        jtxtTelefono = new javax.swing.JFormattedTextField();
        jbtnBuscar = new javax.swing.JButton();
        jbtnCancelar = new javax.swing.JButton();
        jbtnEliminar = new javax.swing.JButton();
        jbtnModificar = new javax.swing.JButton();
        jbtnAlta = new javax.swing.JButton();
        jSeparator = new javax.swing.JLabel();
        lblsucursal = new javax.swing.JLabel();
        jcombosucursales = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSucursal = new javax.swing.JTable();
        btnAgregarSuc = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();
        btnEliminarSuc = new javax.swing.JButton();
        panelUbicacion2 = new Presentacion.Controls.PanelUbicacion();
        datosTint1 = new Presentacion.Controls.PanelPreciosPrendaEnvio();
        listadoTintorerias1 = new Presentacion.Controls.ListadoTintorerias();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Tintorerias:");

        jLabelLoading1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLoading1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLoading1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/loading-24x24.GIF"))); // NOI18N
        jLabelLoading1.setToolTipText("Cargando pedido");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelLoading1)
                .addGap(26, 26, 26))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelLoading1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap())))
        );

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Nombre:");

        jLabel5.setText("Teléfono:");

        jtxtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtNombreFocusGained(evt);
            }
        });

        jtxtTelefono.setColumns(2);
        jtxtTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jtxtTelefono.setEnabled(false);
        jtxtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtTelefonoKeyTyped(evt);
            }
        });

        jbtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/search-icon24x24.png"))); // NOI18N
        jbtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscarActionPerformed(evt);
            }
        });

        jbtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/cancel-icon24x24.png"))); // NOI18N
        jbtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarActionPerformed(evt);
            }
        });

        jbtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/delete-icon24x24.png"))); // NOI18N
        jbtnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnEliminarMouseClicked(evt);
            }
        });

        jbtnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/update2-icon24x24.png"))); // NOI18N
        jbtnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnModificarMouseClicked(evt);
            }
        });

        jbtnAlta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/insert-icon24x24.png"))); // NOI18N
        jbtnAlta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnAltaMouseClicked(evt);
            }
        });

        jSeparator.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/Separator-icon.png"))); // NOI18N
        jSeparator.setPreferredSize(new java.awt.Dimension(6, 24));

        lblsucursal.setText("Sucursal:");

        jcombosucursales.setEnabled(false);

        jTableSucursal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableSucursal.setCellSelectionEnabled(true);
        jTableSucursal.setEnabled(false);
        jTableSucursal.setShowHorizontalLines(false);
        jTableSucursal.setShowVerticalLines(false);
        jTableSucursal.setUpdateSelectionOnSort(false);
        jScrollPane1.setViewportView(jTableSucursal);

        btnAgregarSuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/insert-icon24x24.png"))); // NOI18N
        btnAgregarSuc.setEnabled(false);
        btnAgregarSuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarSucActionPerformed(evt);
            }
        });

        lblError.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 0, 0));

        btnEliminarSuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/delete-icon24x24.png"))); // NOI18N
        btnEliminarSuc.setEnabled(false);
        btnEliminarSuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarSucActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(datosTint1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxtNombre))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jbtnAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblsucursal))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtxtTelefono)
                                    .addComponent(jcombosucursales, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnEliminarSuc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarSuc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addComponent(panelUbicacion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblError))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(panelUbicacion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(83, 83, 83)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                            .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(75, 75, 75)
                                        .addComponent(jbtnBuscar)))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jtxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblsucursal)
                                        .addComponent(jcombosucursales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnAgregarSuc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbtnAlta)
                                    .addComponent(jbtnModificar)
                                    .addComponent(jbtnEliminar)
                                    .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbtnCancelar))))
                        .addGap(22, 22, 22)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminarSuc, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16)
                .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(datosTint1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Mantenimiento", jPanel2);
        jTabbedPane1.addTab("Listado", listadoTintorerias1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarSucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarSucActionPerformed
        if (jTableSucursal.getSelectedRow() != -1) {
            int seleccion = jTableSucursal.getSelectedRow();
            Sucursal s = listaTabla.get(seleccion);
            listaTabla.remove(s);
            SetearTabla(listaTabla);
            listaCombo.add(s);
            jcombosucursales.setModel(new DefaultComboBoxModel(convertirListaCombo(listaCombo)));
        }
    }//GEN-LAST:event_btnEliminarSucActionPerformed


    private void btnAgregarSucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarSucActionPerformed
        if (jcombosucursales.getSelectedIndex() >= 0) {
            //Obtenemos el nombre seleccionado
            String sucnom = (String) jcombosucursales.getSelectedItem();

            try {
                Sucursal s = Logica.Clases.FabricaLogica.getInstancia().getILogicaSucursales().BuscarSucursal(sucnom);
                listaTabla.add(s);
                listaCombo.remove(s);
                jcombosucursales.setModel(new DefaultComboBoxModel(convertirListaCombo(listaCombo)));
            } catch (Exception ex) {
                lblError.setText(ex.getMessage());
            }
            SetearTabla(listaTabla);
        }
    }//GEN-LAST:event_btnAgregarSucActionPerformed

    private void jbtnAltaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnAltaMouseClicked
        if (jbtnAlta.isEnabled()) {
            Thread queryThread = new Thread() {
                @Override
                public void run() {
                    try {
                        MostrarLoading(true);
                        lblError.setText(EMPTY);
                        tint = new Tintoreria();
                        if ("".equals(jtxtNombre.getText())) {
                            throw new Exception("Primero debe ingresar el nombre de la sucursal para dar de alta");
                        }
                        if (jtxtTelefono.getText().isEmpty()) {
                            throw new Exception("Teléfono vacio!");
                        }
                        tint.setNombre(jtxtNombre.getText());
                        tint.setTelefono(jtxtTelefono.getText());
                        if (tint != null) {
                            Ubicacion ub = panelUbicacion2.AltaUbicacion();
                            if(ub == null)
                            {
                              throw new Exception("Compruebe datos de ubicacion");
                            }
                            tint.setUbicacion(ub);
                            tint.setSucursalCercana(listaTabla);
                        }
                        Logica.Clases.FabricaLogica.getInstancia().getILogicaTintoreria().AltaTintoreria(tint);
                        datosTint1.ObtenerDatos(tint);
                        lblError.setText("Alta exitosa");
                        SetModoDefault();

                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                        lblError.setText(ex.getMessage());
                    }
                    MostrarLoading(false);
                }
            };
            queryThread.start();
        }
    }//GEN-LAST:event_jbtnAltaMouseClicked

    private void jbtnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnModificarMouseClicked
        if (jbtnModificar.isEnabled()) {
            Thread queryThread = new Thread() {
                @Override
                public void run() {
                    try {
                        MostrarLoading(true);
                        lblError.setText(EMPTY);
                        Ubicacion ubactual = tint.getUbicacion();
                        if (jtxtTelefono.getText().isEmpty()) {
                            lblError.setText("Teléfono vacio!");
                        }
                        if (listaTabla.isEmpty()) {
                            throw new Exception("Debe seleccionar las sucursales correspondientes");
                        }                  
                        tint.setTelefono(jtxtTelefono.getText());
                        if (tint.getSucursalCercana() != null) {
                            for (int j = 0; j < tint.getSucursalCercana().size(); j++) {
                                Sucursal s = tint.getSucursalCercana().get(j);
                                Logica.Clases.FabricaLogica.getInstancia().getILogicaSucursales().BajaRelacion_TintoreriasSucursales(tint.getIdTint(), s.getIdSuc());
                            }
                        }
                        Ubicacion ub = panelUbicacion2.ModificarUbicacion();
                        if(ub == null)
                        {
                          throw new Exception("Compruebe datos de ubicacion");
                        }
                        tint.setUbicacion(ub);
                        tint.setSucursalCercana(listaTabla);

                        listatint = Logica.Clases.FabricaLogica.getInstancia().getILogicaTintoreria().ListarTintorerias(0);
                        int totales = 0;
                        for (int i = 0; i < listatint.size(); i++) {
                            Tintoreria ti = listatint.get(i);
                            if (ti.getUbicacion().getDireccion().equals(ubactual.getDireccion()) && !ti.getNombre().equals(tint.getNombre())) {
                                totales++;
                            }
                        }
                        Logica.Clases.FabricaLogica.getInstancia().getILogicaUbicacion().Bajarelacion_ubictintorerias(ubactual.getId(), tint.getIdTint());
                        if (totales == 0 && !tint.getUbicacion().getDireccion().equals(ubactual.getDireccion())) {
                            Logica.Clases.FabricaLogica.getInstancia().getILogicaUbicacion().BajaUbicacion(ubactual.getId());
                        }
                        Logica.Clases.FabricaLogica.getInstancia().getILogicaTintoreria().ModificarTintoreria(tint);
                        datosTint1.EliminarDatos(tint);
                        datosTint1.ObtenerDatos(tint);
                        lblError.setText("Modificacion exitosa");
                        SetModoDefault();

                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                        lblError.setText(ex.getMessage());
                    }
                    MostrarLoading(false);
                }
            };
            queryThread.start();
        }
    }//GEN-LAST:event_jbtnModificarMouseClicked

    private void jbtnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnEliminarMouseClicked
        if (jbtnModificar.isEnabled()) {
            Thread queryThread = new Thread() {
                @Override
                public void run() {
                    try {
                        MostrarLoading(true);
                        Ubicacion ub = panelUbicacion2.BuscarUbicacion(tint.getUbicacion().getDireccion());
                        Logica.Clases.FabricaLogica.getInstancia().getILogicaUbicacion().Bajarelacion_ubictintorerias(ub.getId(), tint.getIdTint());
                        if (tint.getSucursalCercana() != null) {
                            for (int j = 0; j < tint.getSucursalCercana().size(); j++) {
                                Sucursal s = tint.getSucursalCercana().get(j);
                                Logica.Clases.FabricaLogica.getInstancia().getILogicaSucursales().BajaRelacion_TintoreriasSucursales(tint.getIdTint(), s.getIdSuc());
                            }
                        }
                        datosTint1.EliminarDatos(tint);
                        Logica.Clases.FabricaLogica.getInstancia().getILogicaTintoreria().BajaTintoreria(tint.getIdTint());
                        Logica.Clases.FabricaLogica.getInstancia().getILogicaUbicacion().BajaUbicacion(ub.getId());
                        lblError.setText("Baja exitosa");
                        SetModoDefault();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                        lblError.setText(ex.getMessage());
                    }
                    MostrarLoading(false);
                }
            };
            queryThread.start();
        }
    }//GEN-LAST:event_jbtnEliminarMouseClicked

    private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarActionPerformed
        Thread queryThread = new Thread() {
            @Override
            public void run() {
                try {
                    MostrarLoading(true);
                    SetModoDefault();
                } catch (Exception es) {
                    lblError.setText(es.getMessage());
                }
                MostrarLoading(false);
            }
        };
        queryThread.start();
    }//GEN-LAST:event_jbtnCancelarActionPerformed

    private void jbtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarActionPerformed
        if (jbtnBuscar.isEnabled()) {
            Thread queryThread = new Thread() {
                @Override
                public void run() {
                    try {
                        MostrarLoading(true);
                        lblError.setText(EMPTY);
                        if (jtxtNombre.getText().isEmpty()) {
                            throw new Exception("Nombre vacio");
                        } else {
                            tint = Logica.Clases.FabricaLogica.getInstancia().getILogicaTintoreria()
                                    .BuscarTintoreria(jtxtNombre.getText());
                            if (tint == null) {
                                SetModoInsert();
                            } else {
                                SetModoUpdate();
                            }
                        }
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                        lblError.setText(ex.getMessage());
                    }
                    MostrarLoading(false);
                }
            };
            queryThread.start();
        }
    }//GEN-LAST:event_jbtnBuscarActionPerformed

    private void jtxtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtTelefonoKeyTyped
        char num = evt.getKeyChar();
        if (num < '0' || num > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_jtxtTelefonoKeyTyped

    private void jtxtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtNombreFocusGained
        lblError.setText("");
    }//GEN-LAST:event_jtxtNombreFocusGained

    private Object[] convertirListaCombo(LinkedList<Sucursal> lista) {
        String[] sucus = new String[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            sucus[i] = lista.get(i).getNombreSuc();
        }
        return sucus;
    }

    public void SetearTabla(LinkedList<Sucursal> suc) {
        try {
            if (suc == null || suc.size() == 0) {
                //cargo tabla vacia
                jTableSucursal.setModel(
                        new javax.swing.table.DefaultTableModel(
                                new Object[][]{ //{null, null}
                                },
                                new String[]{
                                    "Sucursal", "Direccion"
                                }
                        ));
            } else {
                //cargo tabla con datos
                String[][] datos = new String[suc.size()][3];
                for (int i = 0; i < suc.size(); i++) {

                    datos[i][0] = suc.get(i).getNombreSuc();
                    datos[i][1] = suc.get(i).getUbicacion().getDireccion();
                }
                jTableSucursal.setModel(
                        new javax.swing.table.DefaultTableModel(
                                datos,
                                new String[]{
                                    "Sucursal", "Direccion"
                                }
                        ) {
                            //Para que no pueda ser editado
                            @Override
                            public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return false;
                            }
                        });
            }
        } catch (Exception es) {
            JOptionPane.showMessageDialog(null, es.getMessage());
        }
    }

    private void MostrarLoading(boolean mostrar) {
        jLabelLoading1.setVisible(mostrar);
    }

    private void SetModoInsert() {
        btnAgregarSuc.setEnabled(true);
        btnEliminarSuc.setEnabled(true);
        jbtnCancelar.setEnabled(true);
        jbtnAlta.setEnabled(true);
        jbtnModificar.setEnabled(false);
        jbtnEliminar.setEnabled(false);
        jbtnBuscar.setEnabled(false);
        jtxtTelefono.setText(EMPTY);
        jtxtNombre.setEnabled(false);
        jtxtTelefono.setEnabled(true);
        jcombosucursales.setEnabled(true);
        panelUbicacion2.setEnabled(true);
        jTableSucursal.setEnabled(true);
        panelUbicacion2.ActivoParaAlta();
        datosTint1.ActivoParaAlta();
    }

    private void SetModoUpdate() throws Exception {
        jTableSucursal.setEnabled(true);
        btnAgregarSuc.setEnabled(true);
        btnEliminarSuc.setEnabled(true);
        jcombosucursales.setEnabled(true);
        jbtnCancelar.setEnabled(true);
        jbtnAlta.setEnabled(false);
        jbtnModificar.setEnabled(true);
        jbtnEliminar.setEnabled(true);
        jbtnBuscar.setEnabled(false);
        jtxtTelefono.setText(tint.getTelefono());
        jtxtNombre.setEnabled(false);
        jtxtTelefono.setEnabled(true);
        listaTabla = (LinkedList<Sucursal>) tint.getSucursalCercana();
         try { SetearTabla(listaTabla);
            } catch (Exception ex) {
                lblError.setText(ex.getMessage());
            }

        for (int i = 0; i < listaTabla.size(); i++) {
            Sucursal su = listaTabla.get(i);
            listaCombo.remove(su);
            jcombosucursales.setModel(new DefaultComboBoxModel(convertirListaCombo(listaCombo)));
        }
        panelUbicacion2.setEnabled(true);
        panelUbicacion2.MostrarDatos(tint.getUbicacion());
        datosTint1.MostrarDatos(tint);
    }

    private void SetModoDefault() {
        jTableSucursal.setEnabled(false);
        btnAgregarSuc.setEnabled(false);
        btnEliminarSuc.setEnabled(false);
        jcombosucursales.setEnabled(false);
        datosTint1.reinicio();
        panelUbicacion2.ModoDefault();
        jbtnCancelar.setEnabled(true);
        jbtnAlta.setEnabled(false);
        jbtnModificar.setEnabled(false);
        jbtnEliminar.setEnabled(false);
        jbtnBuscar.setEnabled(true);
        jtxtNombre.setText(EMPTY);
        jtxtTelefono.setText(EMPTY);
        jtxtNombre.setEnabled(true);
        jtxtTelefono.setEnabled(false);
        listaTabla = new LinkedList<>();
        SetearTabla(listaTabla);
        try {
            listaCombo = Logica.Clases.FabricaLogica.getInstancia().getILogicaSucursales().ListarSucursales();
            String[] sucus = new String[listaCombo.size()];
            for (int i = 0; i < listaCombo.size(); i++) {
                sucus[i] = listaCombo.get(i).getNombreSuc();
            }
            jcombosucursales.setModel(new DefaultComboBoxModel(sucus));
        } catch (Exception ex) {
            lblError.setText(ex.getMessage());
        }
    }

    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
////        try {
////            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
////                if ("Nimbus".equals(info.getName())) {
////                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
////                    break;
////                }
////            }
////        } catch (ClassNotFoundException ex) {
////            java.util.logging.Logger.getLogger(MantTintorerias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        } catch (InstantiationException ex) {
////            java.util.logging.Logger.getLogger(MantTintorerias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        } catch (IllegalAccessException ex) {
////            java.util.logging.Logger.getLogger(MantTintorerias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
////            java.util.logging.Logger.getLogger(MantTintorerias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        }
//        //</editor-fold>
//
//        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MantTintorerias frame = new MantTintorerias();
                frame.SetModoDefault();
                frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarSuc;
    private javax.swing.JButton btnEliminarSuc;
    private Presentacion.Controls.PanelPreciosPrendaEnvio datosTint1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelLoading1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jSeparator;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableSucursal;
    private javax.swing.JButton jbtnAlta;
    private javax.swing.JButton jbtnBuscar;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnEliminar;
    private javax.swing.JButton jbtnModificar;
    private javax.swing.JComboBox jcombosucursales;
    private javax.swing.JTextField jtxtNombre;
    private javax.swing.JFormattedTextField jtxtTelefono;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblsucursal;
    private Presentacion.Controls.ListadoTintorerias listadoTintorerias1;
    private Presentacion.Controls.PanelUbicacion panelUbicacion2;
    // End of variables declaration//GEN-END:variables
}
