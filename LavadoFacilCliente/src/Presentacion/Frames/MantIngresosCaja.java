package Presentacion.Frames;

import Entidades.Constantes;
import Entidades.Enumeraciones;
import Entidades.Enumeraciones.TipoMov;
import Entidades.Objetos.Empleado;
import Entidades.Objetos.Movimiento;
import Entidades.Utilidades;
import static Entidades.Utilidades.*;
import Logica.Clases.FabricaLogica;
import Presentacion.Interfaces.ParentFrameMethodListener;
import java.math.BigDecimal;

public class MantIngresosCaja extends BaseJFrame implements ParentFrameMethodListener {

    Empleado usuLogueado;
    Movimiento objetoTemp;

    public MantIngresosCaja() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="1 Modos">
    public void ModoAlta() {
        //deshab botones accion
        jbtnAlta.setEnabled(true);
        jbtnModificar.setEnabled(false);
        jbtnEliminar.setEnabled(false);

        panelFecha1.Reset();
        //deshab nombre
        txtNombre.setEnabled(true);
        txtNombre.setText(Constantes.EMPTY);
        //limpio otros campose
        txtMonto.setEnabled(true);
        txtMonto.setText(Constantes.EMPTY);
        txtDesc.setEnabled(true);
        txtDesc.setText(Constantes.EMPTY);
        //limpio mens error
        lblError.setText(Constantes.EMPTY);
    }

    //Solo usado desde el panelListado
    @Override
    public void ModoModificar(Object objeto) {
        objetoTemp = (Movimiento)objeto;
        txtNombre.setText(objetoTemp.getNombreMov());
        ModoModificar();
    }

    private void ModoModificar() {
        //deshab botones accion
        jbtnAlta.setEnabled(false);
        jbtnModificar.setEnabled(true);
        jbtnEliminar.setEnabled(true);

        //limpio otros campose
        panelFecha1.Reset();
        
        //Convert date to calendar
        panelFecha1.setFecha(Utilidades.DateToCalendar(objetoTemp.getFechaMov()));
        
        txtNombre.setEnabled(true);
        txtNombre.setText(objetoTemp.getNombreMov());
        txtMonto.setEnabled(true);
        txtMonto.setText(String.valueOf(objetoTemp.getMonto()).replace('.', ','));
        txtDesc.setEnabled(true);
        txtDesc.setText(objetoTemp.getDescripcion());
        //limpio mens error
        lblError.setText(Constantes.EMPTY);
    }

    @Override
    public void ModoDefault(boolean ejecutarModoDefaultListado) throws Exception {
        ModoAlta();
        if (ejecutarModoDefaultListado) {
            panelListadoIngresos1.ModoDefault();
        }
    }
    // </editor-fold>

    private void Alta() throws Exception {
        String nombre = txtNombre.getText();
        String monto = txtMonto.getText().replace(',', '.');
        String desc = txtDesc.getText();
        
        
        if (IsNullOrEmpty(nombre) || IsNullOrEmpty(monto) || IsNullOrEmpty(desc) || panelFecha1.IsEmpty()) {
            throw new Exception(Constantes.compartido_Error_TodosCamposObligatorios);
        }
        if (IsNotABigDecimal(monto)) {
            throw new Exception(Constantes.ingresos_MontoErrorFormato);
        }

        BigDecimal montoNumero = new BigDecimal(monto);

        objetoTemp = new Movimiento();
        objetoTemp.setNombreMov(nombre);
        objetoTemp.setMonto(montoNumero);
        objetoTemp.setDescripcion(desc);
        objetoTemp.setTipoMov(Enumeraciones.TipoMov.Ingreso);
        objetoTemp.setfechaMov(panelFecha1.getFecha().getTime());
        objetoTemp.setSucursal(usuLogueado.getSucursal());

        int resultado = FabricaLogica.getInstancia().getILogicaMovimientos().AltaMovimiento(objetoTemp);

        //Alta
        switch (resultado) {
            case 0:
                //Caso exitoso
                ModoDefault(true);
                lblError.setText(Constantes.ingreso_ExitoAlta);
                break;
            case -2:
                lblError.setText(Constantes.ingreso_ErrorAlta_m2);
            case -1:
            default:
                lblError.setText(Constantes.ingreso_ErrorAlta_m1);
                break;
        }
    }

    @Override
    public void Eliminar(int idMov) throws Exception {
        int resultado = FabricaLogica.getInstancia().getILogicaMovimientos().BajaMovimiento(idMov);

        //Baja
        switch (resultado) {
            case 0:
                //Caso exitoso
                ModoDefault(true);
                lblError.setText(Constantes.ingreso_ExitoBaja);
                break;
            case -1:
            default:
                lblError.setText(Constantes.ingreso_ErrorBaja_m1);
                break;
        }
    }

    private void Modificar() throws Exception {
        String nombre = txtNombre.getText();
        String monto = txtMonto.getText().replace(',', '.');
        String desc = txtDesc.getText();

        if (IsNullOrEmpty(nombre) || IsNullOrEmpty(monto) || IsNullOrEmpty(desc)) {
            throw new Exception(Constantes.compartido_Error_TodosCamposObligatorios);
        }
        if (IsNotABigDecimal(monto)) {
            throw new Exception(Constantes.ingresos_MontoErrorFormato);
        }

        BigDecimal montoNumero = new BigDecimal(monto);

        //objetoTemp = new Ingreso();
        objetoTemp.setfechaMov(panelFecha1.getFecha().getTime());
        objetoTemp.setNombreMov(nombre);
        objetoTemp.setMonto(montoNumero);
        objetoTemp.setDescripcion(desc);

        int resultado = FabricaLogica.getInstancia().getILogicaMovimientos().ModificarMovimiento(objetoTemp);

        //Modificar
        switch (resultado) {
            case 0:
                //Caso exitoso
                ModoDefault(true);
                lblError.setText(Constantes.ingreso_ExitoModif);
                break;
            case -2:
                lblError.setText(Constantes.ingreso_ErrorModif_m2);
            case -1:
            default:
                lblError.setText(Constantes.ingreso_ErrorModif_m1);
                break;
        }
    }

    //Si se desea asignar una variable o realizar una accion antes de cargar la 
    //página, agregar código a este método.
    public void ProcesarPrimerCargado(Empleado _usuLogueado) throws Exception {
        usuLogueado = _usuLogueado;
        MostrarLoading(false);

        //Recargando datasource y asignarlo a la tabla
        panelListadoIngresos1.setSucActual(usuLogueado.getSucursal().getIdSuc());
        panelListadoIngresos1.ProcesarPrimerCargado(TipoMov.Ingreso);
        panelListadoIngresos1.Listar(null);
        panelListadoIngresos1.addParentFrameMethodListener(this);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="3 Otros Metodos">
    @Override
    public void MostrarLoading(boolean mostrar) {
        jLabelLoading1.setVisible(mostrar);
    }

    @Override
    public void SetMensajeError(String mensaje) {
        lblError.setText(mensaje);
    }
    // </editor-fold>

    private void jbtnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnCancelarMouseClicked
        try {
            ModoDefault(true);
        } catch (Exception ex) {
            lblError.setText(ex.getMessage());
        }
    }//GEN-LAST:event_jbtnCancelarMouseClicked

    private void jbtnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnEliminarMouseClicked
        if (jbtnEliminar.isEnabled()) {

            Thread hilo = new Thread() {
                @Override
                public void run() {
                    try {
                        Eliminar(objetoTemp.getIdMov());
                    } catch (Exception ex) {
                        lblError.setText(ex.getMessage());
                    }
                }
            };
            lblError.setText(Constantes.compartido_ProcesandoEliminar);
            hilo.start();
        }
    }//GEN-LAST:event_jbtnEliminarMouseClicked

    private void jbtnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnModificarMouseClicked
        if (jbtnModificar.isEnabled()) {
            Thread hilo = new Thread() {
                @Override
                public void run() {
                    try {
                        Modificar();
                    } catch (Exception ex) {
                        lblError.setText(ex.getMessage());
                    }
                }
            };
            lblError.setText(Constantes.compartido_ProcesandoModificar);
            hilo.start();
        }
    }//GEN-LAST:event_jbtnModificarMouseClicked

    private void jbtnAltaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnAltaMouseClicked
        if (jbtnAlta.isEnabled()) {
            Thread hilo = new Thread() {
                @Override
                public void run() {
                    try {
                        Alta();
                    } catch (Exception ex) {
                        lblError.setText(ex.getMessage());
                    }
                }
            };
            lblError.setText(Constantes.compartido_ProcesandoAlta);
            hilo.start();
        }
    }//GEN-LAST:event_jbtnAltaMouseClicked

    // </editor-fold>
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTitulo = new javax.swing.JPanel();
        lblTitulo3 = new javax.swing.JLabel();
        jLabelLoading1 = new javax.swing.JLabel();
        panelListadoIngresos1 = new Presentacion.Controls.PanelListadoMovs();
        jPanelMant = new javax.swing.JPanel();
        jbtnAlta = new javax.swing.JButton();
        jbtnModificar = new javax.swing.JButton();
        jbtnEliminar = new javax.swing.JButton();
        jbtnCancelar = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblMonto = new javax.swing.JLabel();
        txtMonto = new javax.swing.JFormattedTextField();
        lblDesc = new javax.swing.JLabel();
        txtDesc = new javax.swing.JTextField();
        jSeparator = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lblError = new javax.swing.JTextArea();
        lblTitulo1 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        panelFecha1 = new Presentacion.Controls.SelectDatePanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mantenimiento De Ingresos");
        setMinimumSize(new java.awt.Dimension(960, 575));

        lblTitulo3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTitulo3.setText("INGRESOS:");

        jLabelLoading1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLoading1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLoading1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/loading-24x24.GIF"))); // NOI18N
        jLabelLoading1.setToolTipText("Cargando pedido");

        javax.swing.GroupLayout jPanelTituloLayout = new javax.swing.GroupLayout(jPanelTitulo);
        jPanelTitulo.setLayout(jPanelTituloLayout);
        jPanelTituloLayout.setHorizontalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTituloLayout.createSequentialGroup()
                .addContainerGap(836, Short.MAX_VALUE)
                .addComponent(jLabelLoading1)
                .addContainerGap())
            .addGroup(jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelTituloLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblTitulo3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(814, Short.MAX_VALUE)))
        );
        jPanelTituloLayout.setVerticalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLoading1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelTituloLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblTitulo3, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jbtnAlta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/insert-icon24x24.png"))); // NOI18N
        jbtnAlta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnAltaMouseClicked(evt);
            }
        });

        jbtnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/update2-icon24x24.png"))); // NOI18N
        jbtnModificar.setEnabled(false);
        jbtnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnModificarMouseClicked(evt);
            }
        });

        jbtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/delete-icon24x24.png"))); // NOI18N
        jbtnEliminar.setEnabled(false);
        jbtnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnEliminarMouseClicked(evt);
            }
        });

        jbtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/cancel-icon24x24.png"))); // NOI18N
        jbtnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnCancelarMouseClicked(evt);
            }
        });

        lblNombre.setText("Nombre:");

        lblMonto.setText("Monto:");

        txtMonto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtMonto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMontoKeyTyped(evt);
            }
        });

        lblDesc.setText("Descripción:");

        jSeparator.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/Separator-icon.png"))); // NOI18N
        jSeparator.setPreferredSize(new java.awt.Dimension(6, 24));

        lblError.setEditable(false);
        lblError.setColumns(1);
        lblError.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        lblError.setForeground(new java.awt.Color(204, 0, 0));
        lblError.setLineWrap(true);
        lblError.setRows(5);
        lblError.setToolTipText("Consola de errores");
        jScrollPane2.setViewportView(lblError);

        lblTitulo1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTitulo1.setText("Mant. de ingresos generados:");

        lblFecha.setText("Fecha:");

        panelFecha1.setEnabled(false);

        javax.swing.GroupLayout jPanelMantLayout = new javax.swing.GroupLayout(jPanelMant);
        jPanelMant.setLayout(jPanelMantLayout);
        jPanelMantLayout.setHorizontalGroup(
            jPanelMantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMantLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanelMantLayout.createSequentialGroup()
                        .addGroup(jPanelMantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanelMantLayout.createSequentialGroup()
                                .addGroup(jPanelMantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanelMantLayout.createSequentialGroup()
                                        .addComponent(jbtnAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(198, 198, 198))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelMantLayout.createSequentialGroup()
                                        .addGroup(jPanelMantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblDesc)
                                            .addComponent(lblMonto))
                                        .addGap(18, 18, 18)
                                        .addComponent(txtDesc)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(10, 10, 10))
                    .addGroup(jPanelMantLayout.createSequentialGroup()
                        .addGroup(jPanelMantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelMantLayout.createSequentialGroup()
                                .addGroup(jPanelMantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(35, 35, 35)
                                .addGroup(jPanelMantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(panelFecha1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNombre))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanelMantLayout.setVerticalGroup(
            jPanelMantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMantLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtnAlta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(lblTitulo1)
                .addGap(50, 50, 50)
                .addGroup(jPanelMantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelFecha1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMonto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDesc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelMant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelListadoIngresos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelMant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelListadoIngresos1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoKeyTyped
        char num = evt.getKeyChar();
        
        boolean isNotANumber = (num < '0' || num > '9');
        boolean isCommaOrDot = (num == ',' || num == '.');
        
        if (!isCommaOrDot && isNotANumber) {
            evt.consume();
        }
        if (num == '.') {
            evt.setKeyChar(',');
        }
    }//GEN-LAST:event_txtMontoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelLoading1;
    private javax.swing.JPanel jPanelMant;
    private javax.swing.JPanel jPanelTitulo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jSeparator;
    private javax.swing.JButton jbtnAlta;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnEliminar;
    private javax.swing.JButton jbtnModificar;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JTextArea lblError;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblMonto;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo3;
    private Presentacion.Controls.SelectDatePanel panelFecha1;
    private Presentacion.Controls.PanelListadoMovs panelListadoIngresos1;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JFormattedTextField txtMonto;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
