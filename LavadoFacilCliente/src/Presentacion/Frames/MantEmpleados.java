package Presentacion.Frames;

import Entidades.Objetos.Empleado;
import Entidades.Objetos.Persona;
import Entidades.Enumeraciones.TipoEmpleado;
import Entidades.Objetos.Sucursal;
import Entidades.Objetos.Ubicacion;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;

public class MantEmpleados extends BaseJFrame {

    Persona emp;
    String contraseña = "usuario1";
    private LinkedList<Empleado> listaper;
    private LinkedList<Sucursal> listaSuc = new LinkedList<Sucursal>();

    public MantEmpleados() {
        initComponents();
        MostrarLoading(false);
        try {
            listaSuc = Logica.Clases.FabricaLogica.getInstancia().getILogicaSucursales().ListarSucursales();
            String[] sucus = new String[listaSuc.size()+1];
            sucus[0]= "Elija una Sucursal";
            for (int i = 0; i < listaSuc.size(); i++) {
                sucus[i+1] = listaSuc.get(i).getNombreSuc();
            }
            jcomboSucursales.setModel(new DefaultComboBoxModel(sucus));
        } catch (Exception ex) {
            lblerror.setText(ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jbtnCancelar = new javax.swing.JButton();
        jSeparator = new javax.swing.JLabel();
        jCalendar = new com.toedter.calendar.JCalendar();
        jLabel1 = new javax.swing.JLabel();
        lblcedula = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        panelUbicacion1 = new Presentacion.Controls.PanelUbicacion();
        lbltelefono = new javax.swing.JLabel();
        lblcelular = new javax.swing.JLabel();
        lblsueldo = new javax.swing.JLabel();
        lbltipoempleado = new javax.swing.JLabel();
        txtcedula = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        txtsueldo = new javax.swing.JTextField();
        comboTipo = new javax.swing.JComboBox();
        btnBuscar = new javax.swing.JButton();
        jbtnAlta = new javax.swing.JButton();
        jbtnModificar = new javax.swing.JButton();
        jbtnEliminar = new javax.swing.JButton();
        lblerror = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcomboSucursales = new javax.swing.JComboBox();
        listadoEmpleados1 = new Presentacion.Controls.ListadoEmpleados();
        jLabel3 = new javax.swing.JLabel();
        jLabelLoading1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/cancel-icon24x24.png"))); // NOI18N
        jbtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarActionPerformed(evt);
            }
        });

        jSeparator.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/Separator-icon.png"))); // NOI18N
        jSeparator.setPreferredSize(new java.awt.Dimension(6, 24));

        jCalendar.setEnabled(false);

        jLabel1.setText("Fecha de Ingreso:");

        lblcedula.setText("Cedula:");

        lblnombre.setText("Nombre:");

        lbltelefono.setText("Telefono:");

        lblcelular.setText("Celular");

        lblsueldo.setText("Sueldo:");

        lbltipoempleado.setText("Tipo de Empleado:");

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

        txtnombre.setEnabled(false);

        txtTelefono.setEnabled(false);
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        txtCelular.setEnabled(false);
        txtCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCelularKeyTyped(evt);
            }
        });

        txtsueldo.setEnabled(false);
        txtsueldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtsueldoKeyTyped(evt);
            }
        });

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Elija un tipo de Empleado", "Delivery", "Mostrador", "Interno", "Supervisor" }));
        comboTipo.setEnabled(false);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/search-icon24x24.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

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

        lblerror.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblerror.setForeground(new java.awt.Color(255, 51, 51));

        jLabel2.setText("Sucursal:");

        jcomboSucursales.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcomboSucursales.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 128, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblcedula)
                                            .addComponent(lblnombre)
                                            .addComponent(lbltelefono)
                                            .addComponent(lblcelular)
                                            .addComponent(lblsueldo))
                                        .addGap(58, 58, 58)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtcedula)
                                            .addComponent(txtnombre)
                                            .addComponent(txtTelefono)
                                            .addComponent(txtCelular)
                                            .addComponent(txtsueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(lblerror))
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbltipoempleado)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboTipo, 0, 160, Short.MAX_VALUE)
                                    .addComponent(jcomboSucursales, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelUbicacion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbtnAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jbtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtnAlta)
                            .addComponent(jbtnModificar)
                            .addComponent(jbtnEliminar)
                            .addComponent(jbtnCancelar)
                            .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblcedula)
                                    .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnBuscar)
                                .addGap(14, 14, 14)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblnombre)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbltelefono)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblcelular)
                            .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblsueldo)
                            .addComponent(txtsueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbltipoempleado)
                            .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jcomboSucursales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblerror))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(panelUbicacion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Mantenimiento", jPanel1);
        jTabbedPane1.addTab("Listado", listadoEmpleados1);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Empleados:");

        jLabelLoading1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLoading1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLoading1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/loading-24x24.GIF"))); // NOI18N
        jLabelLoading1.setToolTipText("Cargando pedido");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(30, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelLoading1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabelLoading1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEliminarActionPerformed
        Thread queryThread = new Thread() {
            @Override
            public void run() {
                try {
                    MostrarLoading(true);
                    int retorno = Logica.Clases.FabricaLogica.getInstancia().getILogicaPersonas().BajaPersona(txtcedula.getText());
                    if(retorno ==1)
                    {
                    Logica.Clases.FabricaLogica.getInstancia().getILogicaUbicacion().BajaUbicacion(emp.getUbicacion().getId());
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

    private void jbtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnModificarActionPerformed
        Thread queryThread = new Thread() {
            @Override
            public void run() {
                try {
                    MostrarLoading(true);
                    Ubicacion ubactual = emp.getUbicacion();
                    if ("".equals(txtnombre.getText()) || "".equals(txtsueldo.getText())) {
                        throw new Exception("Todos los campos son obligatorios");
                    }

                    if ("".equals(txtCelular.getText()) && "".equals(txtTelefono.getText())) {
                        throw new Exception("Celular o Telefono obligatorios");
                    }

                    if (comboTipo.getSelectedIndex() == 0) {
                        throw new Exception("Debe seleccionar que tipo de empleado es");
                    }
                    
                    if (jcomboSucursales.getSelectedIndex() == 0) {
                        throw new Exception("Debe seleccionar una Sucursal");
                    }

                    Sucursal suc = Logica.Clases.LogicaSucursales.getInstancia().BuscarSucursal(jcomboSucursales.getSelectedItem().toString());
                    Date fecha = (Date) jCalendar.getCalendar().getTime();
                    Double sueldo = Double.parseDouble(txtsueldo.getText());
                    emp = new Empleado(txtcedula.getText(), emp.getPassw(), txtnombre.getText(),txtTelefono.getText(), 
                            txtCelular.getText(), BigDecimal.valueOf(sueldo), fecha, 
                            TipoEmpleado.valueOf(comboTipo.getSelectedItem().toString()),suc);
                    if (emp != null) {
                        Ubicacion ub = panelUbicacion1.ModificarUbicacion();
                        if(ub == null)
                        {
                          throw new Exception("Compruebe datos de ubicacion");
                        }
                        emp.setUbicacion(ub);
                    }
                    listaper = Logica.Clases.FabricaLogica.getInstancia().getILogicaPersonas().ListadoEmpleados();
                    int totales = 0;
                    for (int i = 0; i < listaper.size(); i++) {
                        Empleado e = listaper.get(i);
                        if (!e.getCedula().equals(emp.getCedula()) && e.getUbicacion().getDireccion().equals(ubactual.getDireccion())) {
                            totales++;
                        }
                    }
                    //Logica.Clases.FabricaLogica.getInstancia().getILogicaUbicacion().BajaRelacion_UbicPerson(ubactual.getId(), emp.getCedula());
                    if (totales == 0 && !emp.getUbicacion().getDireccion().equals(ubactual.getDireccion())) {
                        Logica.Clases.FabricaLogica.getInstancia().getILogicaUbicacion().BajaUbicacion(ubactual.getId());
                    }

                    Logica.Clases.FabricaLogica.getInstancia().getILogicaPersonas().ModificarPersona(emp);

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

    private void jbtnAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAltaActionPerformed
        Thread queryThread = new Thread() {
            @Override
            public void run() {
                try {
                    MostrarLoading(true);
                    if ("".equals(txtcedula.getText())) {
                        throw new Exception("Primero debe ingresar una cedula para dar de alta");
                    }

                    if ("".equals(txtCelular.getText()) || "".equals(txtnombre.getText())
                            || "".equals(txtsueldo.getText())) {
                        throw new Exception("Todos los campos son obligatorios");
                    }
                    
                    if (comboTipo.getSelectedIndex() == 0) {
                        throw new Exception("Debe seleccionar que tipo de empleado es");
                    }
                    
                    if (jcomboSucursales.getSelectedIndex() == 0) {
                        throw new Exception("Debe seleccionar una Sucursal");
                    }
                    Sucursal suc = Logica.Clases.LogicaSucursales.getInstancia().BuscarSucursal(jcomboSucursales.getSelectedItem().toString());
                    Date fecha = jCalendar.getCalendar().getTime();
                    Double sueldo = Double.parseDouble(txtsueldo.getText());
                    emp = new Empleado(txtcedula.getText(), contraseña, txtnombre.getText(),
                            txtTelefono.getText(), txtCelular.getText(), BigDecimal.valueOf(sueldo), fecha, 
                            TipoEmpleado.valueOf(comboTipo.getSelectedItem().toString()),suc);

                    if (emp != null) {
                        Ubicacion ub = panelUbicacion1.AltaUbicacion();
                        if(ub == null)
                        {
                          throw new Exception("Compruebe datos de ubicacion");
                        }
                        emp.setUbicacion(ub);
                    }
                    Logica.Clases.FabricaLogica.getInstancia().getILogicaPersonas().AltaPersona(emp);
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

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (btnBuscar.isEnabled()) {
            Thread queryThread = new Thread() {
                @Override
                public void run() {
                    try {
                        MostrarLoading(true);
                        if ("".equals(txtcedula.getText())) {
                            throw new Exception("Ingrese la cedula del Empleado");
                        }
                        emp = Logica.Clases.FabricaLogica.getInstancia().getILogicaPersonas().BuscarPersona(txtcedula.getText());

                        if (emp instanceof Entidades.Objetos.Cliente) {
                            throw new Exception("La cedula corresponde a un cliente");
                        }
                        if (emp == null) {
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

    private void txtsueldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsueldoKeyTyped
        char num = evt.getKeyChar();
        if (num < '0' || num > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtsueldoKeyTyped

    private void txtCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularKeyTyped
        char num = evt.getKeyChar();
        if (num < '0' || num > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtCelularKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        char num = evt.getKeyChar();
        if (num < '0' || num > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtcedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaKeyTyped
        char num = evt.getKeyChar();
        if (num < '0' || num > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtcedulaKeyTyped

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

    private void txtcedulaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcedulaFocusGained
        lblerror.setText("");
    }//GEN-LAST:event_txtcedulaFocusGained

    private void MostrarLoading(boolean mostrar) {
        jLabelLoading1.setVisible(mostrar);
    }

    private void reinicio() {
        jcomboSucursales.setEnabled(false);
        jCalendar.setDate(Date.from(Instant.now()));
        comboTipo.setEnabled(false);
        jCalendar.setEnabled(false);
        txtsueldo.setEnabled(false);
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
        txtsueldo.setText("");
        comboTipo.setSelectedIndex(0);
        jcomboSucursales.setSelectedIndex(0);
    }

    private void mostrardatos() {
        txtcedula.setEnabled(false);
        txtCelular.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtnombre.setEnabled(true);
        txtsueldo.setEnabled(true);
        comboTipo.setEnabled(true);
        jCalendar.setEnabled(true);
        jcomboSucursales.setEnabled(true);
        jcomboSucursales.setSelectedItem(((Empleado)emp).getSucursal().getNombreSuc());
        comboTipo.setSelectedItem(((Empleado) emp).getTipoEmpleado().toString());
        jCalendar.setDate(((Empleado) emp).getFechaIngreso());
        txtsueldo.setText(String.valueOf(((Empleado) emp).getSueldo()));
        txtcedula.setText(emp.getCedula());
        txtCelular.setText(emp.getCelular());
        txtTelefono.setText(emp.getTelefono());
        txtnombre.setText(emp.getNombre());
        panelUbicacion1.MostrarDatos(emp.getUbicacion());
        panelUbicacion1.setEnabled(true);
        jbtnAlta.setEnabled(false);
        jbtnEliminar.setEnabled(true);
        jbtnModificar.setEnabled(true);
        lblerror.setText("");
    }

    private void ActivoParaAlta() {
        jcomboSucursales.setEnabled(true);
        comboTipo.setEnabled(true);
        jCalendar.setEnabled(true);
        txtsueldo.setEnabled(true);
        txtcedula.setEnabled(false);
        txtTelefono.setEnabled(true);
        txtCelular.setEnabled(true);
        txtnombre.setEnabled(true);
        panelUbicacion1.ActivoParaAlta();
        jbtnAlta.setEnabled(true);
        btnBuscar.setEnabled(false);
        lblerror.setText("");
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
            java.util.logging.Logger.getLogger(MantEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantEmpleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox comboTipo;
    private com.toedter.calendar.JCalendar jCalendar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelLoading1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jSeparator;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbtnAlta;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnEliminar;
    private javax.swing.JButton jbtnModificar;
    private javax.swing.JComboBox jcomboSucursales;
    private javax.swing.JLabel lblcedula;
    private javax.swing.JLabel lblcelular;
    private javax.swing.JLabel lblerror;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JLabel lblsueldo;
    private javax.swing.JLabel lbltelefono;
    private javax.swing.JLabel lbltipoempleado;
    private Presentacion.Controls.ListadoEmpleados listadoEmpleados1;
    private Presentacion.Controls.PanelUbicacion panelUbicacion1;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtsueldo;
    // End of variables declaration//GEN-END:variables
}
