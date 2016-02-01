package Presentacion.Controls;

import Entidades.Constantes;
import Entidades.Datatypes.FrameMovInfo;
import Entidades.Enumeraciones;
import Entidades.Enumeraciones.TipoMov;
import Entidades.Objetos.Movimiento;
import Entidades.Utilidades;
import static Entidades.Utilidades.*;
import Logica.Clases.FabricaLogica;
import Presentacion.Interfaces.ParentFrameMethodListener;
import static ch.lambdaj.Lambda.having;
import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.select;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.hamcrest.Matchers;

public class PanelListadoMovs extends javax.swing.JPanel {
    //<editor-fold defaultstate="collapsed" desc="ParentFrameMethodListener">
    private final List<ParentFrameMethodListener> listeners = new ArrayList<>();
    
    public void addParentFrameMethodListener(ParentFrameMethodListener toAdd) {
        listeners.add(toAdd);
    }
    
    // An interface to be implemented by everyone interested in events
    public void MostrarLoadingEvent(Boolean mostrar) {
        // Notify everybody that may be interested.
        for (ParentFrameMethodListener hl : listeners)
            hl.MostrarLoading(mostrar);
    }
    
    public void SetMensajeErrorEvent(String mensaje) {
        // Notify everybody that may be interested.
        for (ParentFrameMethodListener hl : listeners)
            hl.SetMensajeError(mensaje);
    }
    
    public void ModoDefaultEvent(boolean ejecutarModoDefaultListado) throws Exception {
        // Notify everybody that may be interested.
        for (ParentFrameMethodListener hl : listeners)
            hl.ModoDefault(ejecutarModoDefaultListado);
    }
    
    public void ModoModificarEvent(Movimiento objeto) {
        // Notify everybody that may be interested.
        for (ParentFrameMethodListener hl : listeners)
            hl.ModoModificar(objeto);
    }
    public void EliminarEvent(int idMovimiento) throws Exception {
        // Notify everybody that may be interested.
        for (ParentFrameMethodListener hl : listeners)
            hl.Eliminar(idMovimiento);
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Variables para el listado">
    int defaultRowCount = 12;
    Movimiento movTemporal;
    List<Movimiento> dataSource;
    int idSucursalActualEmp;
    int selectedRow;
    int selectedIdMov;
    //Variables para validar el tipo de JFrame padre
    FrameMovInfo padreFrameInfo;
    // </editor-fold> 

    public void setSucActual(int idSuc) {
        this.idSucursalActualEmp = idSuc;
    }
    
    public PanelListadoMovs() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblFiltrarFecha2 = new javax.swing.JLabel();
        lblFiltrarId = new javax.swing.JLabel();
        panelSelectDate2 = new Presentacion.Controls.SelectDatePanel();
        txtFiltrarId = new javax.swing.JTextField();
        btnFiltrar = new javax.swing.JButton();
        lblFiltrarFecha = new javax.swing.JLabel();
        txtFiltrarNom = new javax.swing.JTextField();
        lblFiltrarNom = new javax.swing.JLabel();
        lblFiltrarFecha1 = new javax.swing.JLabel();
        panelSelectDate1 = new Presentacion.Controls.SelectDatePanel();
        btnLimpiar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jbtnRefrescar = new javax.swing.JButton();
        jbtnSelectForEditOrDelete = new javax.swing.JButton();
        jbtnEliminarRapido = new javax.swing.JButton();
        pagedJTableMovimientos1 = new Presentacion.Controls.PagedJTableMovimientos();

        setMinimumSize(new java.awt.Dimension(1, 1));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(445, 500));

        lblTitulo2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTitulo2.setText("Listado de movimientos generados:");

        lblFiltrarFecha2.setText("Fecha fin");

        lblFiltrarId.setText("Filtrar por ID:");
        lblFiltrarId.setToolTipText("");

        txtFiltrarId.setMaximumSize(new java.awt.Dimension(200, 200));
        txtFiltrarId.setMinimumSize(new java.awt.Dimension(6, 22));
        txtFiltrarId.setPreferredSize(new java.awt.Dimension(6, 22));

        btnFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/filled-filter-16.png"))); // NOI18N
        btnFiltrar.setText("Filtrar");
        btnFiltrar.setMaximumSize(null);
        btnFiltrar.setMinimumSize(null);
        btnFiltrar.setPreferredSize(null);
        btnFiltrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFiltrarMouseClicked(evt);
            }
        });

        lblFiltrarFecha.setText("Filtrar por rango de fechas:");

        txtFiltrarNom.setMaximumSize(new java.awt.Dimension(200, 200));
        txtFiltrarNom.setMinimumSize(new java.awt.Dimension(6, 22));
        txtFiltrarNom.setPreferredSize(new java.awt.Dimension(6, 22));

        lblFiltrarNom.setText("Filtrar por Nombre:");
        lblFiltrarNom.setToolTipText("");

        lblFiltrarFecha1.setText("Fecha inicio");

        btnLimpiar.setForeground(new java.awt.Color(153, 102, 0));
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/filled-filter-16.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFiltrarNom)
                            .addComponent(lblFiltrarId))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFiltrarId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFiltrarNom, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblFiltrarFecha)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblFiltrarFecha1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblFiltrarFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelSelectDate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(panelSelectDate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpiar)))))
                .addGap(26, 26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFiltrarId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFiltrarId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFiltrarNom)
                    .addComponent(txtFiltrarNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFiltrarFecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelSelectDate1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFiltrarFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelSelectDate2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFiltrarFecha2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbtnRefrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/refresh-icon24x24.png"))); // NOI18N
        jbtnRefrescar.setToolTipText("Recargar página.");
        jbtnRefrescar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnRefrescarMouseClicked(evt);
            }
        });

        jbtnSelectForEditOrDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/Select_for_edit_or_delete_white-icon24x24.png"))); // NOI18N
        jbtnSelectForEditOrDelete.setToolTipText("Seleccionar la brecha para su edición o borrado.");
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(pagedJTableMovimientos1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jbtnSelectForEditOrDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtnEliminarRapido, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbtnRefrescar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jbtnRefrescar)
                .addGap(5, 5, 5)
                .addComponent(jbtnSelectForEditOrDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnEliminarRapido)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(pagedJTableMovimientos1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTitulo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    //<editor-fold defaultstate="collapsed" desc="Modos">
    public void ModoDefault() throws Exception {
        //Tabla
        jbtnSelectForEditOrDelete.setEnabled(false);
        jbtnEliminarRapido.setEnabled(false);
        pagedJTableMovimientos1.setEnabled(true);
        RecargarDataSource();
        Listar(null);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos del listado">
    //Listado:
    //Actualiza el dataSource
    public void RecargarDataSource() throws Exception {
        if(idSucursalActualEmp <= 0)
            throw new Exception("Sucursal actual esta vacía");
        dataSource = FabricaLogica.getInstancia().getILogicaMovimientos().ListarMovimientosPorSucursal(padreFrameInfo.getTipoMovListado(), idSucursalActualEmp);
    }

    //Dejar parametro en null si se desea listar el dataSource
    public void Listar(List<Movimiento> dataSourceFiltrado) throws Exception {
        if (IsNull(dataSourceFiltrado)) {
            dataSourceFiltrado = dataSource;
        }

        pagedJTableMovimientos1.SetupJTableMovimientos(defaultRowCount, dataSourceFiltrado, TipoMov.Gasto);
    }

    public void Filtrar(boolean recargarDataSource) throws Exception {
        if (recargarDataSource) {
            RecargarDataSource();
        }

        List<Movimiento> dataSourceFiltrado = dataSource;

        String nombre = txtFiltrarNom.getText();
        String id = txtFiltrarId.getText();
        Calendar fechaI = panelSelectDate1.getFecha();
        Calendar fechaF = panelSelectDate2.getFecha();

        // <editor-fold desc="Filtros">
        if (!IsNullOrEmpty(nombre)) {
            dataSourceFiltrado = select(dataSourceFiltrado,
                    having(on(Movimiento.class).getNombreMov(),
                            Matchers.startsWith(nombre)));
        }
        if (!IsNullOrEmpty(id)) {
            dataSourceFiltrado = select(dataSourceFiltrado,
                    having(on(Movimiento.class).getIdMov(),
                            Matchers.equalTo(Integer.parseInt(id))));
        }

        if (fechaI != null && fechaF != null) {
            if (fechaI.after(fechaF) || fechaI.equals(fechaF)) {
                SetMensajeErrorEvent("La fecha final debe ser posterior a la fecha inicial.");
            } else {
                SetMensajeErrorEvent(Constantes.EMPTY);
                
                List<Movimiento> aux = dataSourceFiltrado;
                dataSourceFiltrado = Utilidades.GetMovimientosEntreDosFechas(
                        aux, 
                        fechaI.getTime(), 
                        fechaF.getTime());
            }
        }
        else if((fechaI != null && fechaF == null) || (fechaI == null && fechaF != null)) {
            SetMensajeErrorEvent("Se deben cargar ambas fechas para poder filtrar por ellas.");
        }
        
        // </editor-fold>
        Listar(dataSourceFiltrado);
    }

    private void SeleccionarMovParaModificar() throws Exception {
        if (selectedIdMov <= 0) {
            throw new Exception(Constantes.movs_Error_movNoCapturadoCorrect);
        }

        movTemporal = FabricaLogica.getInstancia().getILogicaMovimientos().BuscarMovimiento(selectedIdMov);
        //Ver como capturar desde el dataSource

        //Modo modificar
        jbtnSelectForEditOrDelete.setEnabled(false);
        jbtnEliminarRapido.setEnabled(false);
        pagedJTableMovimientos1.setEnabled(false);
        ModoModificarEvent(movTemporal);
    }

    public void ProcesarPrimerCargado(Enumeraciones.TipoMov tipoMov) throws Exception {
        //Creamos el dt de informacion acerca del padre y el tipo de movimiento que listaremos (para usar la misma clase, y diferenciar)
        padreFrameInfo = new FrameMovInfo();
        padreFrameInfo.setTipoMovListado(tipoMov);
        padreFrameInfo.setPadreFrame((JFrame) SwingUtilities.getWindowAncestor(this));
        
        //Evento para seleccion de la tabla
        pagedJTableMovimientos1.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                //Este metodo es el que se dispara cuando hacemos click en una fila.
                tableMovs_ValueChanged(lse);
            }
        });
        
        RecargarDataSource();
        Listar(null);
    }

    public void HabilitarBotonesListado(boolean habilitar) {
        jbtnSelectForEditOrDelete.setEnabled(habilitar);
        jbtnEliminarRapido.setEnabled(habilitar);
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Eventos">
    //Controla que si una fila esta seleccionada se activen los botones
    private void tableMovs_ValueChanged(ListSelectionEvent lse) {
        try {
            selectedIdMov = pagedJTableMovimientos1.getSelectedIdMov();
            boolean existsSelectedRow = (selectedIdMov != -1);
            HabilitarBotonesListado(existsSelectedRow);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            selectedIdMov = -1;
            HabilitarBotonesListado(false);
        }
    }

    private void jbtnRefrescarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnRefrescarMouseClicked
        if (jbtnRefrescar.isEnabled()) {
            Thread hilo = new Thread() {
                @Override
                public void run() {
                    try {
                        //Para probar el loader
                        ModoDefaultEvent(false);
                        pagedJTableMovimientos1.setEnabled(true);
                        Filtrar(true);
                    } catch (Exception ex) {
                        SetMensajeErrorEvent(Constantes.compartido_ErrorInesperado);
                    }
                    MostrarLoadingEvent(false);
                }
            };

            hilo.start();
        }
    }//GEN-LAST:event_jbtnRefrescarMouseClicked

    private void jbtnSelectForEditOrDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnSelectForEditOrDeleteMouseClicked
        if (jbtnSelectForEditOrDelete.isEnabled()) {
            Thread hilo = new Thread() {
                @Override
                public void run() {
                    try {
                        MostrarLoadingEvent(true);
                        SeleccionarMovParaModificar();
                    } catch (Exception ex) {
                        SetMensajeErrorEvent(Constantes.compartido_ErrorInesperado);
                    }
                    MostrarLoadingEvent(false);
                }
            };

            hilo.start();
        }
    }//GEN-LAST:event_jbtnSelectForEditOrDeleteMouseClicked

    private void jbtnEliminarRapidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnEliminarRapidoMouseClicked
        if (jbtnEliminarRapido.isEnabled()) {
            Thread hilo = new Thread() {
                @Override
                public void run() {
                    try {


                        //Ventana de confirmación
                        int opcionElegida = JOptionPane.showConfirmDialog(null, "Está seguro de eliminar este registro?", "Solicitud de confirmación", JOptionPane.YES_NO_OPTION);
                        if (opcionElegida == JOptionPane.YES_OPTION) {
                            EliminarEvent(selectedIdMov);
                        }
                    } catch (Exception ex) {
                        SetMensajeErrorEvent(Constantes.compartido_ErrorInesperado);
                    }
                    MostrarLoadingEvent(false);
                }
            };

            hilo.start();
        }
    }//GEN-LAST:event_jbtnEliminarRapidoMouseClicked

    private void btnFiltrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFiltrarMouseClicked
        Thread hilo = new Thread() {
            @Override
            public void run() {
                try {
                    MostrarLoadingEvent(true);
                    Filtrar(false);
                } catch (Exception ex) {
                    SetMensajeErrorEvent(ex.getMessage());
                }
                MostrarLoadingEvent(false);
            }
        };
        hilo.start();
    }//GEN-LAST:event_btnFiltrarMouseClicked

    private void btnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseClicked
        Thread hilo = new Thread() {
            @Override
            public void run() {
                try {
                    MostrarLoadingEvent(true);
                    txtFiltrarId.setText(Constantes.EMPTY);
                    txtFiltrarNom.setText(Constantes.EMPTY);
                    panelSelectDate1.Reset();
                    panelSelectDate2.Reset();
                } catch (Exception ex) {
                    SetMensajeErrorEvent(ex.getMessage());
                }
                MostrarLoadingEvent(false);
            }
        };
        hilo.start();
    }//GEN-LAST:event_btnLimpiarMouseClicked
    // </editor-fold> 

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbtnEliminarRapido;
    private javax.swing.JButton jbtnRefrescar;
    private javax.swing.JButton jbtnSelectForEditOrDelete;
    private javax.swing.JLabel lblFiltrarFecha;
    private javax.swing.JLabel lblFiltrarFecha1;
    private javax.swing.JLabel lblFiltrarFecha2;
    private javax.swing.JLabel lblFiltrarId;
    private javax.swing.JLabel lblFiltrarNom;
    private javax.swing.JLabel lblTitulo2;
    private Presentacion.Controls.PagedJTableMovimientos pagedJTableMovimientos1;
    private Presentacion.Controls.SelectDatePanel panelSelectDate1;
    private Presentacion.Controls.SelectDatePanel panelSelectDate2;
    private javax.swing.JTextField txtFiltrarId;
    private javax.swing.JTextField txtFiltrarNom;
    // End of variables declaration//GEN-END:variables
}
