package Presentacion.Frames;

import Entidades.Objetos.Empleado;
import Entidades.Enumeraciones.TipoEmpleado;
import Presentacion.Interfaces.OpenFrameListener;
import javax.swing.JOptionPane;

public class VentanaPrincipal extends BaseJFrame implements OpenFrameListener {

    private MantGastosCaja mantGastos;
    private MantIngresosCaja mantIngresos;
    private MantOpcionesLavado mantOpciones;
    private MantBrechasHorarias mantBrechas;
    //private ConsultaContab consultaContab;
    private RestablecimientoPass restablecimientoPass;
    private CambioDePass cambioDePass;
    private MantClientes mantClientes;
    private MantEmpleados mantEmpleados;
    private MantTintorerias mantTintorerias;
    private MantSucursal mantSucursal;
    private MantPrendas mantPrendas;
    private MantSolicitudesWizard mantSolicitudesWizard;
    private MantExcepciones mantExcepciones;
    private MantSolicitudBusqueda mantSolicitudBusqueda;
    private CambioEstadoSol cambioEstadoSol;
    private ListadoSolicitud listadoSolicitud;
    
    
    Empleado usulogueado = null;

    public VentanaPrincipal(Empleado e) {
        super();
        initComponents();
        try {
            usulogueado = (Empleado) Logica.Clases.FabricaLogica.getInstancia().getILogicaPersonas().BuscarPersona(e.getCedula());
            if (usulogueado != null) {
                lblUsu.setText(usulogueado.getNombre());
                if (usulogueado.getTipoEmpleado().equals(TipoEmpleado.Mostrador)) {
                    btnResPass.setEnabled(false);
                    btnEmpleados.setEnabled(false);
                    btnSucursales.setEnabled(false);
                } else if (usulogueado.getTipoEmpleado().equals(TipoEmpleado.Interno)) {
                    btnResPass.setEnabled(false);
                    btnEmpleados.setEnabled(false);
                    btnSucursales.setEnabled(false);
                    btnClientes.setEnabled(false);
                    btnTintorerias.setEnabled(false);
                } else if (usulogueado.getTipoEmpleado().equals(TipoEmpleado.Supervisor)) {
                    btnResPass.setEnabled(false);
                } else if (usulogueado.getTipoEmpleado().equals(TipoEmpleado.Delivery)) {
                    btnResPass.setEnabled(false);
                    btnEmpleados.setEnabled(false);
                    btnSucursales.setEnabled(false);
                    btnSolicitud.setEnabled(false);
                    btnClientes.setEnabled(false);
                    btnTintorerias.setEnabled(false);
                }
            }
        } catch (Exception ex) {
         // InicioSesion _form = new InicioSesion();
            //_form.setVisible(true);
            //this.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelSup = new javax.swing.JPanel();
        lblUsu = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelSalir = new javax.swing.JLabel();
        lblContraseña = new javax.swing.JLabel();
        jPanelMedio = new javax.swing.JPanel();
        btnClientes = new javax.swing.JButton();
        btnEmpleados = new javax.swing.JButton();
        btnTintorerias = new javax.swing.JButton();
        btnSucursales = new javax.swing.JButton();
        btnPrendas = new javax.swing.JButton();
        btnSolicitud = new javax.swing.JButton();
        btnResPass = new javax.swing.JButton();
        btnMantGastos = new javax.swing.JButton();
        btnMantIngresos = new javax.swing.JButton();
        btnMantOpciones = new javax.swing.JButton();
        btnMantBrechas = new javax.swing.JButton();
        btnConsultarContab = new javax.swing.JButton();
        btnMantExcepciones = new javax.swing.JButton();
        btnBuscarSol = new javax.swing.JButton();
        btnCambioEstadoSol = new javax.swing.JButton();
        btnListadoSol = new javax.swing.JButton();
        jPanelInf = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(826, 568));

        jPanelSup.setBackground(new java.awt.Color(51, 51, 51));
        jPanelSup.setMaximumSize(new java.awt.Dimension(1250, 100));
        jPanelSup.setMinimumSize(new java.awt.Dimension(700, 70));
        jPanelSup.setPreferredSize(new java.awt.Dimension(700, 70));

        lblUsu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblUsu.setForeground(new java.awt.Color(255, 255, 255));
        lblUsu.setText("[Usuario actual]");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Bienvenido:");

        labelSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelSalir.setForeground(new java.awt.Color(255, 255, 255));
        labelSalir.setText("Salir");
        labelSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelSalirMouseClicked(evt);
            }
        });

        lblContraseña.setForeground(new java.awt.Color(255, 255, 255));
        lblContraseña.setText("Cambiar Contraseña");
        lblContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblContraseñaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelSupLayout = new javax.swing.GroupLayout(jPanelSup);
        jPanelSup.setLayout(jPanelSupLayout);
        jPanelSupLayout.setHorizontalGroup(
            jPanelSupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSupLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanelSupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSupLayout.createSequentialGroup()
                        .addComponent(lblContraseña)
                        .addGap(480, 619, Short.MAX_VALUE))
                    .addGroup(jPanelSupLayout.createSequentialGroup()
                        .addComponent(lblUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );
        jPanelSupLayout.setVerticalGroup(
            jPanelSupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSupLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanelSupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addComponent(labelSalir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblContraseña)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelSup, java.awt.BorderLayout.NORTH);

        jPanelMedio.setMaximumSize(new java.awt.Dimension(200, 15));
        jPanelMedio.setMinimumSize(new java.awt.Dimension(200, 15));
        jPanelMedio.setPreferredSize(new java.awt.Dimension(200, 15));
        jPanelMedio.setLayout(new java.awt.GridLayout(10, 3, 2, 2));

        btnClientes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/log7 (1).png"))); // NOI18N
        btnClientes.setText("CLIENTES");
        btnClientes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnClientes.setMaximumSize(new java.awt.Dimension(200, 15));
        btnClientes.setMinimumSize(new java.awt.Dimension(200, 15));
        btnClientes.setPreferredSize(new java.awt.Dimension(200, 15));
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });
        jPanelMedio.add(btnClientes);

        btnEmpleados.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/log7 (1).png"))); // NOI18N
        btnEmpleados.setText("EMPLEADOS");
        btnEmpleados.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEmpleados.setMaximumSize(new java.awt.Dimension(200, 15));
        btnEmpleados.setMinimumSize(new java.awt.Dimension(200, 15));
        btnEmpleados.setPreferredSize(new java.awt.Dimension(200, 15));
        btnEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadosActionPerformed(evt);
            }
        });
        jPanelMedio.add(btnEmpleados);

        btnTintorerias.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTintorerias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/log7 (1).png"))); // NOI18N
        btnTintorerias.setText("TINTORERIAS");
        btnTintorerias.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTintorerias.setMaximumSize(new java.awt.Dimension(200, 15));
        btnTintorerias.setMinimumSize(new java.awt.Dimension(200, 15));
        btnTintorerias.setPreferredSize(new java.awt.Dimension(200, 15));
        btnTintorerias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTintoreriasActionPerformed(evt);
            }
        });
        jPanelMedio.add(btnTintorerias);

        btnSucursales.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSucursales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/log7 (1).png"))); // NOI18N
        btnSucursales.setText("SUCURSALES");
        btnSucursales.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSucursales.setMaximumSize(new java.awt.Dimension(200, 15));
        btnSucursales.setMinimumSize(new java.awt.Dimension(200, 15));
        btnSucursales.setPreferredSize(new java.awt.Dimension(200, 15));
        btnSucursales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSucursalesActionPerformed(evt);
            }
        });
        jPanelMedio.add(btnSucursales);

        btnPrendas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPrendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/log7 (1).png"))); // NOI18N
        btnPrendas.setText("PRENDAS");
        btnPrendas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPrendas.setMaximumSize(new java.awt.Dimension(200, 15));
        btnPrendas.setMinimumSize(new java.awt.Dimension(200, 15));
        btnPrendas.setPreferredSize(new java.awt.Dimension(200, 15));
        btnPrendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrendasActionPerformed(evt);
            }
        });
        jPanelMedio.add(btnPrendas);

        btnSolicitud.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSolicitud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/log7 (1).png"))); // NOI18N
        btnSolicitud.setText("Mant. Solicitudes de Lavado");
        btnSolicitud.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSolicitud.setMaximumSize(new java.awt.Dimension(200, 15));
        btnSolicitud.setMinimumSize(new java.awt.Dimension(200, 15));
        btnSolicitud.setPreferredSize(new java.awt.Dimension(200, 15));
        btnSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitudActionPerformed(evt);
            }
        });
        jPanelMedio.add(btnSolicitud);

        btnResPass.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnResPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/log7 (1).png"))); // NOI18N
        btnResPass.setText("RESTABLECER CONTRASEÑA");
        btnResPass.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnResPass.setMaximumSize(new java.awt.Dimension(200, 15));
        btnResPass.setMinimumSize(new java.awt.Dimension(200, 15));
        btnResPass.setPreferredSize(new java.awt.Dimension(200, 15));
        btnResPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResPassActionPerformed(evt);
            }
        });
        jPanelMedio.add(btnResPass);

        btnMantGastos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnMantGastos.setText("Mant. Gastos Caja");
        btnMantGastos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMantGastos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMantGastosMouseClicked(evt);
            }
        });
        jPanelMedio.add(btnMantGastos);

        btnMantIngresos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnMantIngresos.setText("Mant. Ingresos Caja");
        btnMantIngresos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMantIngresos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMantIngresosMouseClicked(evt);
            }
        });
        jPanelMedio.add(btnMantIngresos);

        btnMantOpciones.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnMantOpciones.setText("Mant. Opciones");
        btnMantOpciones.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMantOpciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMantOpcionesMouseClicked(evt);
            }
        });
        jPanelMedio.add(btnMantOpciones);

        btnMantBrechas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnMantBrechas.setText("Mant. Brechas Horarias");
        btnMantBrechas.setToolTipText("");
        btnMantBrechas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMantBrechas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMantBrechasMouseClicked(evt);
            }
        });
        jPanelMedio.add(btnMantBrechas);

        btnConsultarContab.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnConsultarContab.setText("Consultar Contab.");
        btnConsultarContab.setToolTipText("");
        btnConsultarContab.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnConsultarContab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConsultarContabMouseClicked(evt);
            }
        });
        jPanelMedio.add(btnConsultarContab);

        btnMantExcepciones.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnMantExcepciones.setText("Mant. Excepciones Lavado");
        btnMantExcepciones.setToolTipText("");
        btnMantExcepciones.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMantExcepciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMantExcepcionesMouseClicked(evt);
            }
        });
        jPanelMedio.add(btnMantExcepciones);

        btnBuscarSol.setText("Buscar Solicitud de lavado");
        btnBuscarSol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarSolActionPerformed(evt);
            }
        });
        jPanelMedio.add(btnBuscarSol);

        btnCambioEstadoSol.setText("Cambio Estado Solicitud");
        btnCambioEstadoSol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambioEstadoSolActionPerformed(evt);
            }
        });
        jPanelMedio.add(btnCambioEstadoSol);

        btnListadoSol.setText("Listado Solicitudes");
        btnListadoSol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListadoSolActionPerformed(evt);
            }
        });
        jPanelMedio.add(btnListadoSol);

        getContentPane().add(jPanelMedio, java.awt.BorderLayout.CENTER);

        jPanelInf.setBackground(new java.awt.Color(51, 51, 51));
        jPanelInf.setMaximumSize(new java.awt.Dimension(1250, 100));
        jPanelInf.setMinimumSize(new java.awt.Dimension(700, 70));
        jPanelInf.setPreferredSize(new java.awt.Dimension(700, 70));
        jPanelInf.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanelInf, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSalirMouseClicked
        try {
            InicioSesion _form = new InicioSesion();
            _form.setVisible(true);
            this.dispose();
        } catch (Exception es) {
            JOptionPane.showMessageDialog(null, es.getMessage());
        }
    }//GEN-LAST:event_labelSalirMouseClicked

    private void btnSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitudActionPerformed
        try {
            if (mantSolicitudesWizard == null || mantSolicitudesWizard.isDisposed()) {
                mantSolicitudesWizard = new MantSolicitudesWizard();
                mantSolicitudesWizard.ProcesarPrimerCargado(usulogueado);
            }
            mantSolicitudesWizard.setVisible(true);
        } catch (Exception es) {
            JOptionPane.showMessageDialog(null, es.getMessage());
        }
    }//GEN-LAST:event_btnSolicitudActionPerformed

    private void btnPrendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrendasActionPerformed
        try {
            if (mantPrendas == null || mantPrendas.isDisposed()) {
                mantPrendas = new MantPrendas();
            }
            mantPrendas.setVisible(true);
        } catch (Exception es) {
            JOptionPane.showMessageDialog(null, es.getMessage());
        }
    }//GEN-LAST:event_btnPrendasActionPerformed

    private void btnSucursalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSucursalesActionPerformed
        try {
            if (mantSucursal == null || mantSucursal.isDisposed()) {
                mantSucursal = new MantSucursal();
            }
            mantSucursal.setVisible(true);
        } catch (Exception es) {
            JOptionPane.showMessageDialog(null, es.getMessage());
        }
    }//GEN-LAST:event_btnSucursalesActionPerformed

    private void btnTintoreriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTintoreriasActionPerformed
        try {
            if (mantTintorerias == null || mantTintorerias.isDisposed()) {
                mantTintorerias = new MantTintorerias();
            }
            mantTintorerias.setVisible(true);
        } catch (Exception es) {
            JOptionPane.showMessageDialog(null, es.getMessage());
        }
    }//GEN-LAST:event_btnTintoreriasActionPerformed

    private void btnEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadosActionPerformed
        try {
            if (mantEmpleados == null || mantEmpleados.isDisposed()) {
                mantEmpleados = new MantEmpleados();
            }
            mantEmpleados.setVisible(true);

        } catch (Exception es) {
            JOptionPane.showMessageDialog(null, es.getMessage());
        }
    }//GEN-LAST:event_btnEmpleadosActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        AbrirFrameMantClientes();
    }//GEN-LAST:event_btnClientesActionPerformed

    private void AbrirFrameMantClientes() {
        try {
            if (mantClientes == null || mantClientes.isDisposed()) {
                mantClientes = new MantClientes();
            }
            mantClientes.setVisible(true);
        } catch (Exception es) {
            JOptionPane.showMessageDialog(null, es.getMessage());
        }
    }
    
    private void lblContraseñaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblContraseñaMouseClicked
        try {
            if (cambioDePass == null || cambioDePass.isDisposed()) {
                cambioDePass = new CambioDePass(usulogueado);
            }
            cambioDePass.setVisible(true);
        } catch (Exception es) {
            JOptionPane.showMessageDialog(null, es.getMessage());
        }
    }//GEN-LAST:event_lblContraseñaMouseClicked

    private void btnResPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResPassActionPerformed
        try {
            if (restablecimientoPass == null || restablecimientoPass.isDisposed()) {
                restablecimientoPass = new RestablecimientoPass();
            }
            restablecimientoPass.setVisible(true);
        } catch (Exception es) {
            JOptionPane.showMessageDialog(null, es.getMessage());
            System.out.println("[BRUNO-EXCEPTION] " + es.getMessage());
        }
    }//GEN-LAST:event_btnResPassActionPerformed

    private void btnMantGastosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMantGastosMouseClicked
        try {
            if (mantGastos == null || mantGastos.isDisposed()) {
                mantGastos = new MantGastosCaja();
                mantGastos.ProcesarPrimerCargado(usulogueado);
            }
            mantGastos.setVisible(true);
        } catch (Exception ex) {
            System.out.println("[BRUNO-EXCEPTION] " + ex.getMessage());
        }
    }//GEN-LAST:event_btnMantGastosMouseClicked

    private void btnMantIngresosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMantIngresosMouseClicked
        try {
            if (mantIngresos == null || mantIngresos.isDisposed()) {
                mantIngresos = new MantIngresosCaja();
                mantIngresos.ProcesarPrimerCargado(usulogueado);
            }
            mantIngresos.setVisible(true);
        } catch (Exception ex) {
            System.out.println("[BRUNO-EXCEPTION] " + ex.getMessage());
        }
    }//GEN-LAST:event_btnMantIngresosMouseClicked

    private void btnMantOpcionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMantOpcionesMouseClicked
        try {
            if (mantOpciones == null || mantOpciones.isDisposed()) {
                mantOpciones = new MantOpcionesLavado();
            }
            mantOpciones.ProcesarPrimerCargado();
            mantOpciones.setVisible(true);
        } catch (Exception ex) {
            System.out.println("[BRUNO-EXCEPTION] " + ex.getMessage());
        }
    }//GEN-LAST:event_btnMantOpcionesMouseClicked

    private void btnMantBrechasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMantBrechasMouseClicked
        try {
            if (mantBrechas == null || mantBrechas.isDisposed()) {
                mantBrechas = new MantBrechasHorarias();
            }
            mantBrechas.setVisible(true);
        } catch (Exception ex) {
            System.out.println("[BRUNO-EXCEPTION] " + ex.getMessage());
        }
    }//GEN-LAST:event_btnMantBrechasMouseClicked

    private void btnConsultarContabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultarContabMouseClicked
//        try {
//            if (consultaContab == null || consultaContab.isDisposed()) {
//                consultaContab = new ConsultaContab();
//                consultaContab.CargarVisorContabilidadActual(usulogueado);
//            }
//            consultaContab.setVisible(true);
//        } catch (Exception ex) {
//            System.out.println("[BRUNO-EXCEPTION] " + ex.getMessage());
//        }
    }//GEN-LAST:event_btnConsultarContabMouseClicked

    private void btnMantExcepcionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMantExcepcionesMouseClicked
        try {
            if (mantExcepciones == null || mantExcepciones.isDisposed()) {
                mantExcepciones = new MantExcepciones();
            }
            mantExcepciones.CorrerVentana();
        } catch (Exception ex) {
            System.out.println("[BRUNO-EXCEPTION] " + ex.getMessage());
        }
    }//GEN-LAST:event_btnMantExcepcionesMouseClicked

    private void btnBuscarSolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarSolActionPerformed
        try {
            if (mantSolicitudBusqueda == null) {
                mantSolicitudBusqueda = new MantSolicitudBusqueda(usulogueado);
            }
            mantSolicitudBusqueda.setVisible(true);
            

        } catch (Exception es) {
            JOptionPane.showMessageDialog(null, es.getMessage());
        }
    }//GEN-LAST:event_btnBuscarSolActionPerformed

    private void btnCambioEstadoSolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambioEstadoSolActionPerformed
                try {
            if (cambioEstadoSol == null) {
                cambioEstadoSol = new CambioEstadoSol();
            }
            cambioEstadoSol.setVisible(true);
        } catch (Exception es) {
            JOptionPane.showMessageDialog(null, es.getMessage());
                }
    }//GEN-LAST:event_btnCambioEstadoSolActionPerformed

    private void btnListadoSolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListadoSolActionPerformed
       try {
            if (listadoSolicitud == null) {
                listadoSolicitud = new ListadoSolicitud();
            }
            listadoSolicitud.setVisible(true);
        } catch (Exception es) {
            JOptionPane.showMessageDialog(null, es.getMessage());
    }
    }//GEN-LAST:event_btnListadoSolActionPerformed
    
    @Override
    public void OpenFrameListener_Event(String formName) {
        switch(formName) {
            case "MCli":
                AbrirFrameMantClientes();
                break;                
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarSol;
    private javax.swing.JButton btnCambioEstadoSol;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnConsultarContab;
    private javax.swing.JButton btnEmpleados;
    private javax.swing.JButton btnListadoSol;
    private javax.swing.JButton btnMantBrechas;
    private javax.swing.JButton btnMantExcepciones;
    private javax.swing.JButton btnMantGastos;
    private javax.swing.JButton btnMantIngresos;
    private javax.swing.JButton btnMantOpciones;
    private javax.swing.JButton btnPrendas;
    private javax.swing.JButton btnResPass;
    private javax.swing.JButton btnSolicitud;
    private javax.swing.JButton btnSucursales;
    private javax.swing.JButton btnTintorerias;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelInf;
    private javax.swing.JPanel jPanelMedio;
    private javax.swing.JPanel jPanelSup;
    private javax.swing.JLabel labelSalir;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblUsu;
    // End of variables declaration//GEN-END:variables

    
}
