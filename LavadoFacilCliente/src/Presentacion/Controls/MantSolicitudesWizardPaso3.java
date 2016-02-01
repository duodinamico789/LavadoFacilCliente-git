package Presentacion.Controls;

import Entidades.Constantes;
import Entidades.DataConfiguration;
import Entidades.Datatypes.CategoriaOpcion;
import Entidades.Objetos.BrechaHoraria;
import Entidades.Objetos.Opcion;
import Presentacion.Interfaces.ParentFrameSolicAdapter;
import static ch.lambdaj.Lambda.having;
import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.selectFirst;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import org.hamcrest.Matchers;

public class MantSolicitudesWizardPaso3 extends javax.swing.JPanel {
    private LinkedList<Opcion> dataSourceOpciones;
    private LinkedList<Opcion> listaOpcionesCbo;
    private final String firstValueOpcionesCbo = "[Seleccione opción]";
    private LinkedList<Opcion> listaOpcionesTabla;
    //<editor-fold defaultstate="collapsed" desc="ParentFrameSolicAdapter">
    private final List<ParentFrameSolicAdapter> listeners = new ArrayList<>();
    
    public void addParentFrameSolicAdapter(ParentFrameSolicAdapter toAdd) {
        listeners.add(toAdd);
    }
    
    // An interface to be implemented by everyone interested in events
    public void MostrarLoadingEvent(Boolean mostrar) {
        // Notify everybody that may be interested.
        for (ParentFrameSolicAdapter hl : listeners)
            hl.MostrarLoading(mostrar);
    }
    
    public void SetMensajeErrorEvent(String mensaje) {
        // Notify everybody that may be interested.
        for (ParentFrameSolicAdapter hl : listeners)
            hl.SetMensajeError(mensaje);
    }    
    //</editor-fold>
    
    public MantSolicitudesWizardPaso3() {
        initComponents();     
    }
    
    //<editor-fold defaultstate="collapsed" desc="Getters propiedades">
    public LinkedList<Opcion> getListaOpcionesTabla() {
        return listaOpcionesTabla;
    }
    
    public String getObservaciones() {
        return txtObservaciones2.getText().trim();
    }
  
    public Calendar getFechaEntrega()throws Exception {
        return sdpFechaEntrega.getFecha(); 
        
    }
    //</editor-fold>    

    
    public BrechaHoraria getBrechaHoraria() throws Exception
    {
      return sdpFechaEntrega.getBrechaHoraria();
    }
    public boolean getIsDelivery() throws Exception
    {
      return sdpFechaEntrega.getIsDelivery();
    }
    public void ProcesarPrimerCargado(boolean forzarRecargaDesdeBd) throws Exception {
        ModoDefault();
        //Seteamos evento de seleccion de fila en excepciones
        tableOpciones.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                //Este metodo es el que se dispara cuando hacemos click en una fila.
                tableExcepciones_ValueChanged(lse);
            }
        });
    }   
    
//    public void Reiniciar() {
//        cboOpciones.setSelectedIndex(0);
//        tableOpciones.clearSelection();
//    }
    
    //<editor-fold defaultstate="collapsed" desc="Cargas comboboxes">
    private void CargarListaComboboxOpciones(boolean omitirCargaDataSource, List<Opcion> listadoOpciones) throws Exception {
        if(dataSourceOpciones == null)
            dataSourceOpciones = Logica.Clases.FabricaLogica.getInstancia().getILogicaOpciones().ListarOpciones();
        if(!omitirCargaDataSource)
            listaOpcionesCbo = new LinkedList<>(dataSourceOpciones);
        if(listadoOpciones != null) {
            //Quitamos excepciones que estan en la tabla al combobox
            for(int i = 0; i < listadoOpciones.size(); i++) {
                Opcion current = ((Opcion)selectFirst(listaOpcionesCbo,
                        having(on(Opcion.class).getNombre(),
                                Matchers.equalTo(listadoOpciones.get(i).getNombre()))));
                
                if(current != null) {
                    listaOpcionesCbo.remove(current);
                    i--;
                }
            }
        }
        
        List<String> array = new ArrayList<>();
        array.add(firstValueOpcionesCbo);
        for(Opcion ex : listaOpcionesCbo) {
            array.add(ex.getNombre());
        }
        
        cboOpciones.setModel(new DefaultComboBoxModel(array.toArray()));
    }
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Validaciones">
    public String ValidacionCorrecta() {
        String msj = Constantes.EMPTY;
        
        Calendar c = Calendar.getInstance();
        if(sdpFechaEntrega.IsEmpty()) {
            msj = "Por favor, ingrese una fecha de entrega. ";
        } else if(sdpFechaEntrega.getFecha().before(c)) {
            msj = "La fecha de entrega debe ser posterior a la fecha actual. ";
        }
        
        if(listaOpcionesTabla.size() == 0) {
            msj = "Por favor, ingrese al menos una opción en la tabla de opciones.";
        }
        
//        if(cbDelivery.isSelected() && cbBrechas.getSelectedIndex() < 0) {
//            msj = "Por favor, seleccione una brecha horaria en la que se entregará el pedido. ";
//        }
        
        if(TablaContieneDosOMasLavados()) {
            msj = "Una solicitud de lavado no puede tener dos o más lavados como opciones. "
                    + "Por favor, ingrese un sola opción de tipo lavado.";
        }
        
        String mensajeOpcIncompat = OpcionesTablaIncopatibles();
        if(!mensajeOpcIncompat.equals(Constantes.EMPTY)) {
            msj = mensajeOpcIncompat;
        }
        
        return msj;
    }
    
    private String OpcionesTablaIncopatibles() {
        String msj = Constantes.EMPTY;
        String NombreOpcLavado = Constantes.EMPTY;
        List<Integer> idsOpciones = new LinkedList<>();
        List<CategoriaOpcion> cats = new LinkedList<>();
        
        for(Opcion op : listaOpcionesTabla) {
            if(DataConfiguration.IsOpcionTipoLavado(op.getidOpcion())) {
                cats.addAll(DataConfiguration.getCategoriasOpciones(op.getidOpcion()));
                NombreOpcLavado = op.getNombre();
            }
            
            idsOpciones.add(op.getidOpcion());
        };
        
        
//        List<Integer> idsSubOpciones = new LinkedList<>();
//        for(Opcion op : listaOpcionesTabla) {
//            for(CategoriaOpcion cop : cats) {
//                if(cop.getIdSubOpcion() == op.getidOpcion() && !idsSubOpciones.contains(op.getidOpcion())){
//                    listSubOpciones.add(op);
//                    idsSubOpciones.add(op.getidOpcion());
//                }
//            }
//        }
        
        for(CategoriaOpcion cop : cats) {
            if(idsOpciones.contains(cop.getIdSubOpcion())) {
                Opcion subopcion = null;
                for(Opcion op : listaOpcionesTabla) {
                    if(op.getidOpcion() == cop.getIdSubOpcion())
                        subopcion = op;
                }
                
                msj = "No puede seleccionarse la opción " +
                        subopcion.getNombre() + " porque es parte de la opción " +
                        NombreOpcLavado;
            }
        }
        return msj;
    }
    
    private boolean TablaContieneDosOMasLavados() {
        int aux = 0;
        
        for(Opcion op : listaOpcionesTabla) {
            if(DataConfiguration.IsOpcionTipoLavado(op.getidOpcion())) {
                aux++;
            }
        };
        
        return (aux > 1);
    }
    //</editor-fold>
    
    public void SetearTabla(List<Opcion> opc) {
        try {
            Object[][] datos;
            
            if(opc == null || opc.size() == 0) {
                datos = new Object[][]{};
            } else {
                DecimalFormat d = new DecimalFormat("'$'0.00");
                
                datos = new String[opc.size()][2];
                for (int i = 0; i < opc.size(); i++) {
                    datos[i][0] = opc.get(i).getNombre();                    
                    datos[i][1] = d.format(opc.get(i).getPrecio());
                }
            }
                
            tableOpciones.setModel(
                new DefaultTableModel(datos, Constantes.opciones_titulosColumnas) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                       //all cells false
                       return false;
                    }
                }
            );
        } catch (Exception es) {
            JOptionPane.showMessageDialog(null, es.getMessage());
        }
    }    
    
    public void ModoDefault() throws Exception {       
        //cargar combobox excepciones,
        CargarListaComboboxOpciones(false, null);
        listaOpcionesTabla = new LinkedList<>();
        SetearTabla(listaOpcionesTabla);
        
        SetMensajeErrorEvent(Constantes.EMPTY);
    }
    
    
    //<editor-fold defaultstate="collapsed" desc="Codigo autogenerado Netbeans">
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblSeleccExc = new javax.swing.JLabel();
        cboOpciones = new javax.swing.JComboBox();
        jspOpciones = new javax.swing.JScrollPane();
        tableOpciones = new javax.swing.JTable();
        btnAgregarOpc = new javax.swing.JButton();
        btnQuitarOpc = new javax.swing.JButton();
        txtObservaciones = new javax.swing.JScrollPane();
        txtObservaciones2 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        sdpFechaEntrega = new Presentacion.Controls.PanelSelBrecha();

        setMinimumSize(new java.awt.Dimension(556, 459));
        setPreferredSize(new java.awt.Dimension(556, 459));

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTitulo.setText("Seleccione opciones de lavado:");

        lblSeleccExc.setText("Seleccione opciones de lavado deseadas:");

        cboOpciones.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jspOpciones.setMinimumSize(new java.awt.Dimension(530, 124));
        jspOpciones.setPreferredSize(new java.awt.Dimension(530, 124));

        tableOpciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jspOpciones.setViewportView(tableOpciones);

        btnAgregarOpc.setText("Agregar");
        btnAgregarOpc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarOpcMouseClicked(evt);
            }
        });

        btnQuitarOpc.setText("Quitar");
        btnQuitarOpc.setEnabled(false);
        btnQuitarOpc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQuitarOpcMouseClicked(evt);
            }
        });

        txtObservaciones2.setColumns(20);
        txtObservaciones2.setRows(5);
        txtObservaciones2.setMinimumSize(new java.awt.Dimension(20, 20));
        txtObservaciones2.setPreferredSize(new java.awt.Dimension(360, 68));
        txtObservaciones.setViewportView(txtObservaciones2);

        jLabel5.setText("Observaciones:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtObservaciones)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSeleccExc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cboOpciones, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAgregarOpc, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnQuitarOpc, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jspOpciones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(sdpFechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(10, 10, 10))
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSeleccExc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuitarOpc)
                    .addComponent(btnAgregarOpc)
                    .addComponent(cboOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jspOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sdpFechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarOpcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarOpcMouseClicked
        try {
            if (cboOpciones.getSelectedIndex() <= 0) {
                throw new Exception("Por favor, seleccione una excepción. ");
            }
            SetMensajeErrorEvent(Constantes.EMPTY);
            
            Opcion op = selectFirst
                    (listaOpcionesCbo,
                    having(on(Opcion.class).getNombre(),
                            Matchers.equalTo((String) cboOpciones.getSelectedItem()))
                    );
            
            listaOpcionesTabla.add(op);   
            listaOpcionesCbo.remove(op);
            SetearTabla(listaOpcionesTabla);
            CargarListaComboboxOpciones(true, null);
        } catch (Exception e) {
            SetMensajeErrorEvent(e.getMessage());
        }
    }//GEN-LAST:event_btnAgregarOpcMouseClicked

    private void btnQuitarOpcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuitarOpcMouseClicked
        if(btnQuitarOpc.isEnabled()) {
            try {
                if (tableOpciones.getSelectedRow() < 0) {
                    throw new Exception("Por favor, seleccione una excepción de la tabla para poder eliminar una. ");
                }
                SetMensajeErrorEvent(Constantes.EMPTY);

                Opcion op = listaOpcionesTabla.get(tableOpciones.getSelectedRow());

                if(op == null) {
                    SetMensajeErrorEvent("Referencia nula!");
                }
                listaOpcionesTabla.remove(op); 
                listaOpcionesCbo.add(op);
                SetearTabla(listaOpcionesTabla);                
                CargarListaComboboxOpciones(true, null);
            } catch (Exception e) {
                SetMensajeErrorEvent(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnQuitarOpcMouseClicked

    private void tableExcepciones_ValueChanged(ListSelectionEvent lse) {
        try {
            btnQuitarOpc.setEnabled(tableOpciones.getSelectedRow() != -1);            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            btnQuitarOpc.setEnabled(false);
        }
    }
 
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarOpc;
    private javax.swing.JButton btnQuitarOpc;
    private javax.swing.JComboBox cboOpciones;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jspOpciones;
    private javax.swing.JLabel lblSeleccExc;
    private javax.swing.JLabel lblTitulo;
    private Presentacion.Controls.PanelSelBrecha sdpFechaEntrega;
    private javax.swing.JTable tableOpciones;
    private javax.swing.JScrollPane txtObservaciones;
    private javax.swing.JTextArea txtObservaciones2;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>    
}