package Presentacion.Frames;

import Logica.Clases.FabricaLogica;
import Entidades.Constantes;
import Entidades.DataConfiguration;
import Entidades.Objetos.Excepcion;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MantExcepciones extends BaseJFrame {

    private Excepcion selectedExcepcion;
    private int selectedExceptionRow;
    private List<Excepcion> dataSource;

    public MantExcepciones() {
        initComponents();
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
        jTableExcepciones = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        lblError = new javax.swing.JTextArea();
        jbtnSelectForEditOrDelete = new javax.swing.JButton();
        jbtnEliminarRapido = new javax.swing.JButton();
        jLabelLoading = new javax.swing.JLabel();
        jbtnCancelar = new javax.swing.JButton();
        jSeparator = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mantenimiento de excepciones");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(460, 500));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Mantenimiento de excepciones:");

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

        jScrollPane1.setToolTipText("Listado de excepciones.");

        jTableExcepciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom. Excepción"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableExcepciones.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTableExcepciones);
        jTableExcepciones.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (jTableExcepciones.getColumnModel().getColumnCount() > 0) {
            jTableExcepciones.getColumnModel().getColumn(0).setResizable(false);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtnEliminarRapido, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnSelectForEditOrDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblnombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))
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
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jbtnAlta)
                        .addComponent(jbtnModificar)
                        .addComponent(jbtnEliminar)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabelLoading, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblnombre))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnRefrescar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnSelectForEditOrDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnEliminarRapido)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ModoDefault() {
        txtNombre.setText(Constantes.EMPTY);
        //txtNombre.setEnabled(true);
        jbtnAlta.setEnabled(true);
        jbtnEliminar.setEnabled(false);
        jbtnModificar.setEnabled(false);
        jbtnRefrescar.setEnabled(true);
        jbtnSelectForEditOrDelete.setEnabled(false);
        jbtnEliminarRapido.setEnabled(false);
        jTableExcepciones.setEnabled(true);
        selectedExcepcion = null;
        selectedExceptionRow = -1;
        lblError.setText(Constantes.EMPTY);
    }

    private void ModoSeleccionExcepcionParaEditarOElim() {
        txtNombre.setText(selectedExcepcion.getNombre());
        //txtNombre.setEnabled(!DataConfiguration.IsExcepcionSoloLectura(selectedExcepcion.getid()));
        jbtnAlta.setEnabled(false);
        jbtnEliminar.setEnabled(true);
        jbtnModificar.setEnabled(true);
        jbtnRefrescar.setEnabled(false);
        jbtnSelectForEditOrDelete.setEnabled(false);
        jbtnEliminarRapido.setEnabled(false);
        jTableExcepciones.setEnabled(false);
        lblError.setText(Constantes.EMPTY);
    }

    public void MostrarLoading(boolean mostrar) {
        jLabelLoading.setVisible(mostrar);
    }
    
    //<editor-fold defaultstate="collapsed" desc="Metodos principales">
    private void Alta() {
        try {
            //Empty name validation
            if (txtNombre.getText().equals(Constantes.EMPTY)) {
                throw new Exception(Constantes.compartido_Error_NombreVacio);
            }
            
            Excepcion exc = new Excepcion(txtNombre.getText());
            
            int res = FabricaLogica.getInstancia().getILogicaExcepciones().AltaExcepcion(exc);
            
            switch (res) {
                case 0:
                    //Caso exitoso
                    ModoDefault();
                    TraerDatosYRecargarTabla();
                    lblError.setText(Constantes.excepcion_ExitoAlta);
                    break;
                case -1:
                case -2:
                case -3:
                default:
                    lblError.setText(Constantes.excepcion_ErrorAlta_m1);
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
            
            if (selectedExcepcion == null || selectedExcepcion.equals(Constantes.EMPTY)) {
                throw new Exception(Constantes.excepciones_Error_ExcepcionNoCapturadaCorrect);
            }
            
            if(DataConfiguration.IsExcepcionSoloLectura(selectedExcepcion.getid())) {
                throw new Exception(Constantes.excepciones_Error_ExcepcionSoloLectura);
            }
            
            String oldNombre = selectedExcepcion.getNombre();
            selectedExcepcion = new Excepcion(txtNombre.getText());
            
            int res = FabricaLogica.getInstancia().getILogicaExcepciones().ModificarExcepcion(oldNombre, selectedExcepcion);
            
            switch (res) {
                case 0:
                    //Caso exitoso
                    ModoDefault();
                    TraerDatosYRecargarTabla();
                    lblError.setText(Constantes.excepcion_ExitoModif);
                    break;
                case -2:
                    lblError.setText(Constantes.excepcion_ErrorModif_m2);
                    break;
                case -1:                
                case -3:
                default:
                    lblError.setText(Constantes.excepcion_ErrorModif_m1);
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
                selectedExceptionRow = jTableExcepciones.getSelectedRow();
                
                if (selectedExceptionRow == -1) {
                    throw new Exception(Constantes.excepciones_Error_seleccioneExcepcion);
                }
                
                selectedExcepcion = dataSource.get(selectedExceptionRow);
                
                if (selectedExcepcion == null || selectedExcepcion.equals(Constantes.EMPTY)) {
                    throw new Exception(Constantes.excepciones_Error_ExcepcionNoCapturadaCorrect);
                }
                
                if(DataConfiguration.IsExcepcionSoloLectura(selectedExcepcion.getid())) {
                    throw new Exception(Constantes.excepciones_Error_ExcepcionSoloLectura);
                }
                
                ModoSeleccionExcepcionParaEditarOElim();
            } catch (Exception ex) {
                lblError.setText(ex.getMessage());
            }
        }
    }
    
    private void EliminarExcepcion() {
        try {
            //Row not seledted validation
            selectedExceptionRow = jTableExcepciones.getSelectedRow();
            
            if (selectedExceptionRow == -1) {
                throw new Exception(Constantes.excepciones_Error_seleccioneExcepcion);
            }
            
            selectedExcepcion = dataSource.get(selectedExceptionRow);
            
            if (selectedExcepcion == null || selectedExcepcion.equals(Constantes.EMPTY)) {
                throw new Exception(Constantes.excepciones_Error_ExcepcionNoCapturadaCorrect);
            }
            
            if(DataConfiguration.IsExcepcionSoloLectura(selectedExcepcion.getid())) {
                throw new Exception(Constantes.excepciones_Error_ExcepcionSoloLectura);
            }
            
            int res = FabricaLogica.getInstancia().getILogicaExcepciones().BajaExcepcion(selectedExcepcion);
            
            switch (res) {
                case 0:
                    //Caso exitoso
                    ModoDefault();
                    TraerDatosYRecargarTabla();
                    lblError.setText(Constantes.excepcion_ExitoBaja);
                    break;
                default:
                    lblError.setText(Constantes.excepcion_ErrorBaja_m1);
                    break;
            }
        } catch (Exception ex) {
            lblError.setText(ex.getMessage());
        }
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Metodos de carga de tabla">
    private void TraerDatosYRecargarTabla() {
        Thread queryThread = new Thread() {
            @Override
            public void run() {
                try {
                    //Para probar nomas
                    jLabelLoading.setVisible(true);
                    dataSource = FabricaLogica.getInstancia().getILogicaExcepciones().ListarExcepciones();
                    CargarTabla();
                } catch (Exception ex) {
                    lblError.setText(ex.getMessage());
                } finally {
                    if (jLabelLoading.isVisible()) {
                        jLabelLoading.setVisible(false);
                    }
                }
            }
        };
        queryThread.start();
    }
    
    private void CargarTabla() {
        //Set String[]
        String[][] datos = new String[dataSource.size()][1];
        
        for (int i = 0; i < dataSource.size(); i++) {
            datos[i][0] = dataSource.get(i).getNombre();
        }
        
        //Set data to the model
        jTableExcepciones.setModel(
                new javax.swing.table.DefaultTableModel(datos, Constantes.excepciones_titulosColumnas) {
                    //Para que no pueda ser editado
                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return false;
                    }
                }
        );
    }
//</editor-fold>
    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantExcepciones().CorrerVentana();
            }
        });
    }  
    
    //Metodo para arrancar ventana desde la ventana principal
    public void CorrerVentana() {
         Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    jLabelLoading.setVisible(false);
                    
                    //Event when selecting a row
                    jTableExcepciones.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                        @Override
                        public void valueChanged(ListSelectionEvent lse) {
                            //Este metodo es el que se dispara cuando hacemos click en una fila.
                            jTableExcepciones_ValueChanged(lse);
                        }
                    });
                    
                    TraerDatosYRecargarTabla();
                    setVisible(true);
                } catch (Exception ex) {
                    if (ex instanceof NullPointerException) {
                        JOptionPane.showMessageDialog(null, Constantes.compartido_ErrorInesperadoNullPointer);
                    } else {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            }
        };
        t.start();
    }
    
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
            lblError.setText(Constantes.excepcion_ProcesandoAlta);
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
            lblError.setText(Constantes.excepcion_ProcesandoAlta);
            queryThread.start();
        }
    }//GEN-LAST:event_jbtnModificarMouseClicked

    private void jbtnRefrescarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnRefrescarMouseClicked
        if (jbtnRefrescar.isEnabled()) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    MostrarLoading(true);
                    jLabelLoading.setVisible(true);
                    TraerDatosYRecargarTabla();
                    MostrarLoading(false);
                }
            };
            thread.start();
        }
    }//GEN-LAST:event_jbtnRefrescarMouseClicked

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

    private void jbtnEliminarRapidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnEliminarRapidoMouseClicked
        Thread thread = new Thread() {
            @Override
            public void run() {
                if (jbtnEliminarRapido.isEnabled()) {
                    EliminarExcepcion();
                }
            }
        };
        thread.start();
    }//GEN-LAST:event_jbtnEliminarRapidoMouseClicked

    private void jbtnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnEliminarMouseClicked
        Thread thread = new Thread() {
            @Override
            public void run() {
                if (jbtnEliminar.isEnabled()) {
                    EliminarExcepcion();
                }
            }
        };
        lblError.setText(Constantes.excepcion_ProcesandoBaja);
        thread.start();
    }//GEN-LAST:event_jbtnEliminarMouseClicked

    private void jbtnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnCancelarMouseClicked
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    ModoDefault();
                } catch (Exception ex) {
                    lblError.setText(ex.getMessage());
                }
            }
        };
        thread.start();
    }//GEN-LAST:event_jbtnCancelarMouseClicked

    private void jTableExcepciones_ValueChanged(ListSelectionEvent lse) {
        try {
            selectedExceptionRow = jTableExcepciones.getSelectedRow();

            if (selectedExceptionRow == -1) {
                selectedExcepcion = null;
                jbtnSelectForEditOrDelete.setEnabled(false);
                jbtnEliminarRapido.setEnabled(false);
            } else {
                selectedExcepcion = dataSource.get(selectedExceptionRow);
                jbtnSelectForEditOrDelete.setEnabled(true);
                jbtnEliminarRapido.setEnabled(true);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            selectedExcepcion = null;
            jbtnSelectForEditOrDelete.setEnabled(false);
            jbtnEliminarRapido.setEnabled(false);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelLoading;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jSeparator;
    private javax.swing.JTable jTableExcepciones;
    private javax.swing.JButton jbtnAlta;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnEliminar;
    private javax.swing.JButton jbtnEliminarRapido;
    private javax.swing.JButton jbtnModificar;
    private javax.swing.JButton jbtnRefrescar;
    private javax.swing.JButton jbtnSelectForEditOrDelete;
    private javax.swing.JTextArea lblError;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    
}
