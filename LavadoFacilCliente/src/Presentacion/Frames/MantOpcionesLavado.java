package Presentacion.Frames;

import Logica.Clases.FabricaLogica;
import Entidades.Constantes;
import Entidades.DataConfiguration;
import Entidades.Objetos.Opcion;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MantOpcionesLavado extends BaseJFrame {
    private int selectedOpcionRow;
    private LinkedList<Opcion> dataSource;
    Opcion selectedOpcion;

    public MantOpcionesLavado() {
        initComponents();
    }

    //<editor-fold defaultstate="collapsed" desc="1 Metodos - Modos">
    private void ModoDefault() {
        txtNombre.setText(Constantes.EMPTY);
        txtNombre.setEnabled(true);
        txtPrecio.setText(Constantes.EMPTY);
        jbtnAlta.setEnabled(true);
        jbtnEliminar.setEnabled(false);
        jbtnModificar.setEnabled(false);
        jbtnRefrescar.setEnabled(true);
        selectedOpcion = null;
        selectedOpcionRow = -1;
        jbtnSelectForEditOrDelete.setEnabled(false);
        jbtnEliminarRapido.setEnabled(false);
        jTableOpciones.setEnabled(true);
        jTableOpciones.clearSelection();
        lblError.setText(Constantes.EMPTY);
    }
    
    private void ModoSeleccionOpcionParaEditarOElim(Opcion opcion) {
        txtNombre.setText(opcion.getNombre());
        txtNombre.setEnabled(!DataConfiguration.IsOpcionSoloLectura(opcion.getidOpcion()));
        txtPrecio.setText(new DecimalFormat("#.##").format(opcion.getPrecio().doubleValue()));
        jbtnAlta.setEnabled(false);
        jbtnEliminar.setEnabled(true);
        jbtnModificar.setEnabled(true);
        jbtnRefrescar.setEnabled(false);
        jbtnSelectForEditOrDelete.setEnabled(false);
        jbtnEliminarRapido.setEnabled(false);
        jTableOpciones.setEnabled(false);
        lblError.setText(Constantes.EMPTY);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="2 Metodos - Principales">
    private void Alta() {
        try {
            //Empty name validation
            if (txtNombre.getText().equals(Constantes.EMPTY)) {
                throw new Exception(Constantes.compartido_Error_NombreVacio);
            }
            if (txtPrecio.getText().equals(Constantes.EMPTY)) {
                throw new Exception(Constantes.compartido_Error_TodosCamposObligatorios);
            }
            
            Opcion exc = new Opcion(txtNombre.getText());
            exc.setPrecio(new BigDecimal(txtPrecio.getText().replace(',', '.')));
            
            int res = FabricaLogica.getInstancia().getILogicaOpciones().AltaOpcion(exc);
            
            switch (res) {
                case 0:
                    //Caso exitoso
                    ModoDefault();
                    TraerDatosYRecargarTabla();
                    lblError.setText(Constantes.opcion_ExitoAlta);
                    break;
                case -1:
                case -2:
                case -3:
                default:
                    lblError.setText(Constantes.opcion_ErrorAlta_m1);
                    break;
            }
        } catch (Exception ex) {
            lblError.setText(ex.getMessage());
        }
    }
    
    private void Modificar() {
        try {
            //Empty name validation
            if (txtNombre.getText().equals(Constantes.EMPTY)) {
                throw new Exception(Constantes.compartido_Error_NombreVacio);
            }
            
            if (selectedOpcion == null || selectedOpcion.equals(Constantes.EMPTY)) {
                throw new Exception(Constantes.opciones_Error_OpcionNoCapturadaCorrect);
            }
            
            BigDecimal newPrecio = null;
            try {
                String toParse = txtPrecio.getText().replace(',', '.');
                double valor = Double.parseDouble(toParse);
                newPrecio = new BigDecimal(valor);
            } catch (NumberFormatException numberFormatException) {
                throw new Exception("Error en el formato del precio. Corrija el campo para poder continuar.");
            }
            
            Opcion newOpc = selectedOpcion;
            newOpc.setNombre(txtNombre.getText());
            newOpc.setPrecio(newPrecio);
            
            int res = FabricaLogica.getInstancia().getILogicaOpciones().ModificarOpcion(selectedOpcion.getNombre(), newOpc);
            
            switch (res) {
                case 0:
                    //Caso exitoso
                    ModoDefault();
                    TraerDatosYRecargarTabla();
                    lblError.setText(Constantes.opcion_ExitoModif);
                    break;
                case -1:
                case -2:
                case -3:
                default:
                    lblError.setText(Constantes.opcion_ErrorModif_m1);
                    break;
            }
            
        } catch (Exception ex) {
            lblError.setText(ex.getMessage());
        }
    }
    
    private void SelectForEditOrDelete() {
        if (jbtnSelectForEditOrDelete.isEnabled()) {
            try {
                //Row not seledted validation
                selectedOpcionRow = jTableOpciones.getSelectedRow();
                
                if (selectedOpcionRow == -1) {
                    throw new Exception(Constantes.opciones_Error_seleccioneOpcion);
                }
                
                Opcion selectedOpcion = dataSource.get(selectedOpcionRow);
                
                if (selectedOpcion == null || selectedOpcion.equals(Constantes.EMPTY)) {
                    throw new Exception(Constantes.opciones_Error_OpcionNoCapturadaCorrect);
                }
                
                //BRUNO ARREGLAR
                ModoSeleccionOpcionParaEditarOElim(selectedOpcion);
            } catch (Exception ex) {
                lblError.setText(ex.getMessage());
            }
        }
    }
    
    private void EliminarOpcion() {
        try {
            //Row not seledted validation
            if (selectedOpcionRow == -1) {
                throw new Exception(Constantes.opciones_Error_seleccioneOpcion);
            }
            
            if (selectedOpcion == null || selectedOpcion.equals(Constantes.EMPTY)) {
                throw new Exception(Constantes.opciones_Error_OpcionNoCapturadaCorrect);
            }
            
            if(DataConfiguration.IsOpcionSoloLectura(selectedOpcion.getidOpcion())) {
                throw new Exception(Constantes.opciones_Error_OpcionSoloLectura);
            }
            
            int res = FabricaLogica.getInstancia().getILogicaOpciones().BajaOpcion(selectedOpcion);
            
            switch (res) {
                case 0:
                    //Caso exitoso
                    ModoDefault();
                    TraerDatosYRecargarTabla();
                    lblError.setText(Constantes.opcion_ExitoBaja);
                    break;
                case -1:
                case -2:
                case -3:
                default:
                    lblError.setText(Constantes.opcion_ErrorBaja_m1);
                    break;
            }
        } catch (Exception ex) {
            lblError.setText(ex.getMessage());
        }
    }
//</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="3 Otros Metodos">
    private void TraerDatosYRecargarTabla() {
        try {
            //Para probar nomas
            //Thread.sleep(2000);
            dataSource = FabricaLogica.getInstancia().getILogicaOpciones().ListarOpciones();
            CargarTabla();
        } catch (NullPointerException nex) {
            lblError.setText(Constantes.compartido_ErrorInesperadoNullPointer);
        } catch (Exception ex) {
            lblError.setText(ex.getMessage());
        }
    }

    private void CargarTabla() {
        String[][] datos = new String[dataSource.size()][2];

        for (int i = 0; i < dataSource.size(); i++) {
            datos[i][0] = dataSource.get(i).getNombre();
            datos[i][1] = new DecimalFormat("#.##").format(dataSource.get(i).getPrecio());
        }

        //Set data to the model
        jTableOpciones.setModel(
                new javax.swing.table.DefaultTableModel(datos, Constantes.opciones_titulosColumnas) {
                    //Para que no pueda ser editado
                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return false;
                    }
                }
        );
    }
    
    //
    
    public void MostrarLoading(boolean mostrar) {
        jLabelLoading.setVisible(mostrar);
    }

    public void SetMensajeError(String mensaje) {
        lblError.setText(mensaje);
    }
    // </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="4 Correr ventana método">
    public void ProcesarPrimerCargado() throws Exception {
        dataSource = FabricaLogica.getInstancia().getILogicaOpciones().ListarOpciones();
        CargarTabla();

        jLabelLoading.setVisible(false);

        //Event when selecting a row
        jTableOpciones.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                //Este metodo es el que se dispara cuando hacemos click en una fila.
                jTableOpciones_ValueChanged(lse);
            }
        });
    }
    
    //Metodo para arrancar ventana desde la ventana principal
    public void CorrerVentana() {
        new Thread() {
            @Override
            public void run() {
                try {
                    ProcesarPrimerCargado();                    
                    setVisible(true);
                } catch (Exception ex) {
                    if (ex instanceof NullPointerException) {
                        JOptionPane.showMessageDialog(null, Constantes.compartido_ErrorInesperadoNullPointer);
                    } else {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                    
                    if(jLabelLoading.isVisible())
                        MostrarLoading(false);
                }
            }
        }.run();
    }
//</editor-fold>
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantOpcionesLavado().CorrerVentana();
            }
        });
    }  
    
    
    private void jTableOpciones_ValueChanged(ListSelectionEvent lse) {
        try {
            selectedOpcionRow = jTableOpciones.getSelectedRow();

            if (selectedOpcionRow == -1) {
                //selectedOpcionRow = Constantes.EMPTY;
                selectedOpcion = null;
                jbtnSelectForEditOrDelete.setEnabled(false);
                jbtnEliminarRapido.setEnabled(false);
            } else {
                selectedOpcion = dataSource.get(selectedOpcionRow);
                jbtnSelectForEditOrDelete.setEnabled(true);
                jbtnEliminarRapido.setEnabled(true);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            selectedOpcion = null;
            selectedOpcionRow = -1;
            jbtnSelectForEditOrDelete.setEnabled(false);
            jbtnEliminarRapido.setEnabled(false);
        }
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jbtnAlta = new javax.swing.JButton();
        jbtnModificar = new javax.swing.JButton();
        jbtnEliminar = new javax.swing.JButton();
        jbtnRefrescar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableOpciones = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        lblError = new javax.swing.JTextArea();
        jbtnSelectForEditOrDelete = new javax.swing.JButton();
        jbtnEliminarRapido = new javax.swing.JButton();
        jLabelLoading = new javax.swing.JLabel();
        jbtnCancelar = new javax.swing.JButton();
        jSeparator = new javax.swing.JLabel();
        jLabelTitulo2 = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mantenimiento de opciones de lavado");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(460, 500));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Mantenimiento de opciones de lavado:");

        lblnombre.setText("Nombre:");

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

        jbtnRefrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/refresh-icon24x24.png"))); // NOI18N
        jbtnRefrescar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnRefrescarMouseClicked(evt);
            }
        });

        jScrollPane1.setToolTipText("Listado de opciones.");

        jTableOpciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Nom. Opción", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableOpciones.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTableOpciones);
        jTableOpciones.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (jTableOpciones.getColumnModel().getColumnCount() > 0) {
            jTableOpciones.getColumnModel().getColumn(0).setResizable(false);
        }

        lblError.setEditable(false);
        lblError.setColumns(1);
        lblError.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        lblError.setForeground(new java.awt.Color(204, 0, 0));
        lblError.setLineWrap(true);
        lblError.setRows(5);
        lblError.setToolTipText("Consola de errores");
        jScrollPane2.setViewportView(lblError);

        jbtnSelectForEditOrDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/Select_for_edit_or_delete_white-icon24x24.png"))); // NOI18N
        jbtnSelectForEditOrDelete.setToolTipText("Seleccionar la excepción para su edición o borrado.");
        jbtnSelectForEditOrDelete.setEnabled(false);
        jbtnSelectForEditOrDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnSelectForEditOrDeleteMouseClicked(evt);
            }
        });

        jbtnEliminarRapido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/quick_delete-icon24x24.png"))); // NOI18N
        jbtnEliminarRapido.setToolTipText("Hacer un borrado al instante.");
        jbtnEliminarRapido.setEnabled(false);
        jbtnEliminarRapido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnEliminarRapidoMouseClicked(evt);
            }
        });

        jLabelLoading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLoading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/loading-24x24.GIF"))); // NOI18N
        jLabelLoading.setToolTipText("Cargando pedido");

        jbtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/cancel-icon24x24.png"))); // NOI18N
        jbtnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnCancelarMouseClicked(evt);
            }
        });

        jSeparator.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/Separator-icon.png"))); // NOI18N
        jSeparator.setPreferredSize(new java.awt.Dimension(6, 24));

        jLabelTitulo2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelTitulo2.setText("Listado:");

        lblPrecio.setText("Precio:");

        txtPrecio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblnombre)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPrecio)
                                .addGap(18, 18, 18)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jbtnSelectForEditOrDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jbtnRefrescar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jbtnEliminarRapido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(17, 17, 17))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelLoading, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelLoading, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbtnAlta)
                            .addComponent(jbtnModificar)
                            .addComponent(jbtnEliminar)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jbtnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTitulo2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblnombre))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblPrecio)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jbtnRefrescar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbtnSelectForEditOrDelete)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbtnEliminarRapido)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void jbtnAltaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnAltaMouseClicked
        if (jbtnAlta.isEnabled()) {
            Thread queryThread = new Thread() {
                @Override
                public void run() {
                    MostrarLoading(true);
                    Alta();
                    MostrarLoading(false);
                }
            };
            lblError.setText(Constantes.opcion_ProcesandoAlta);
            queryThread.start();
        }
    }//GEN-LAST:event_jbtnAltaMouseClicked

    private void jbtnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnModificarMouseClicked
        if (jbtnModificar.isEnabled()) {
            Thread queryThread = new Thread() {
                @Override
                public void run() {
                    MostrarLoading(true);
                    Modificar();
                    MostrarLoading(false);
                }
            };
            lblError.setText(Constantes.opcion_ProcesandoModif);
            queryThread.start();
        }
    }//GEN-LAST:event_jbtnModificarMouseClicked

    private void jbtnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnEliminarMouseClicked
        Thread thread = new Thread() {
            @Override
            public void run() {
                MostrarLoading(true);
                EliminarOpcion();
                MostrarLoading(false);
            }
        };
        lblError.setText(Constantes.opcion_ProcesandoBaja);
        thread.start();
    }//GEN-LAST:event_jbtnEliminarMouseClicked

    private void jbtnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnCancelarMouseClicked
        try {
            MostrarLoading(true);
            ModoDefault();
            MostrarLoading(false);
        } catch (Exception e) {
            lblError.setText(e.getMessage());
        }
    }//GEN-LAST:event_jbtnCancelarMouseClicked

    private void jbtnEliminarRapidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnEliminarRapidoMouseClicked
        Thread thread = new Thread() {
            @Override
            public void run() {
                MostrarLoading(true);
                EliminarOpcion();
                MostrarLoading(false);
            }
        };
        lblError.setText(Constantes.opcion_ProcesandoBaja);
        thread.start();
    }//GEN-LAST:event_jbtnEliminarRapidoMouseClicked

    private void jbtnSelectForEditOrDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnSelectForEditOrDeleteMouseClicked
        Thread thread = new Thread() {
            @Override
            public void run() {
                MostrarLoading(true);
                SelectForEditOrDelete();
                MostrarLoading(false);
            }
        };
        thread.start();
    }//GEN-LAST:event_jbtnSelectForEditOrDeleteMouseClicked

    private void jbtnRefrescarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnRefrescarMouseClicked
        Thread thread = new Thread() {
            @Override
            public void run() {
                if (jbtnRefrescar.isEnabled()) {
                    MostrarLoading(true);
                    TraerDatosYRecargarTabla();
                    MostrarLoading(false);
                }
            }
        };
        thread.start();
    }//GEN-LAST:event_jbtnRefrescarMouseClicked

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        char num = evt.getKeyChar();

        boolean isNotANumber = (num < '0' || num > '9');
        boolean isCommaOrDot = (num == ',' || num == '.');

        if (!isCommaOrDot && isNotANumber) {
            evt.consume();
        }
        if (num == '.') {
            evt.setKeyChar(',');
        }
    }//GEN-LAST:event_txtPrecioKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelLoading;
    private javax.swing.JLabel jLabelTitulo2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jSeparator;
    private javax.swing.JTable jTableOpciones;
    private javax.swing.JButton jbtnAlta;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnEliminar;
    private javax.swing.JButton jbtnEliminarRapido;
    private javax.swing.JButton jbtnModificar;
    private javax.swing.JButton jbtnRefrescar;
    private javax.swing.JButton jbtnSelectForEditOrDelete;
    private javax.swing.JTextArea lblError;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JFormattedTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
