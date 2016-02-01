package Presentacion.Controls;

import Entidades.Constantes;
import Entidades.Datatypes.PrendaExtended;
import Entidades.Enumeraciones.OperacionPrendaExtended;
import Entidades.Objetos.Excepcion;
import Entidades.Objetos.Prenda;
import Entidades.Objetos.PrendaEnvio;
import Entidades.Utilidades;
import Presentacion.Interfaces.NotificarResultListener;
import Presentacion.Interfaces.PrendaExistsInListListener;
import static ch.lambdaj.Lambda.having;
import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.selectFirst;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import org.hamcrest.Matchers;

public class MantSolicitudesWizardPaso2Dialog extends javax.swing.JDialog implements NotificarResultListener{
    private LinkedList<Prenda> dataSourcePrendas;
    private LinkedList<Excepcion> dataSourceExcepciones;
    private LinkedList<Prenda> listaPrendasCbo;
    private final String firstValuePrendasCbo = "[Seleccione prenda]";
    private LinkedList<Excepcion> listaExcepcionesCbo;
    private final String firstValueExcepcionesCbo = "[Seleccione excepción]";
    private List<Excepcion> listaExcepcionesTabla;
    private PrendaExtended prendaCargada;
    private OperacionPrendaExtended operacionPrendaExtended;
    private LinkedList<PrendaEnvio> listaPrendasEnvio = new LinkedList<>();
    MantSolicitudesWizardpaso2Dialog2 dialog = new MantSolicitudesWizardpaso2Dialog2(new javax.swing.JDialog(), true);
    
    
    @Override
    public void NotificarResult_Event(Object resultado) {
        if(resultado != null) {
            //Si objeto no es nulo significa que se confirmo los cambios
            PrendaEnvio pe = (PrendaEnvio) resultado;
            listaPrendasEnvio.add(pe);
        }
    }
    
   public LinkedList<PrendaEnvio> getListaPrendasEnvio() {
        LinkedList<PrendaEnvio> prendas = new LinkedList<>();
        
        for(PrendaEnvio pe : listaPrendasEnvio) {
            prendas.add(pe);
        }       
        return prendas;
    }
    
    //<editor-fold defaultstate="collapsed" desc="NotificarResultListener">
    private final List<NotificarResultListener> listeners = new ArrayList<>();
    
    public void addNotificarResultListener(NotificarResultListener toAdd) {
        listeners.add(toAdd);
    }
    
    // An interface to be implemented by everyone interested in events
    public void NotificarResultEvent(Object resultado) {
        // Notify everybody that may be interested.
        for (NotificarResultListener hl : listeners)
            hl.NotificarResult_Event(resultado);    
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="NotificarResultListener">
    private PrendaExistsInListListener listener;
    
    
    public void setPrendaExistsInListListener(PrendaExistsInListListener toAdd) {
        listener = toAdd;
    }

    public void setPrendaCargada(PrendaExtended prendaCargada) {
        this.prendaCargada = prendaCargada;
    }
    
    // An interface to be implemented by everyone interested in events
    public boolean PrendaExistsInListEvent(Object param, OperacionPrendaExtended ope) {
        // Notify everybody that may be interested.
        return listener.PrendaExistsInList_Event(param, ope);
    }
    //</editor-fold>
    
    public void asignarPEaList(PrendaEnvio pe)
    {
     listaPrendasEnvio.add(pe);
    }
    
    public void setOperacionPrendaExtended(OperacionPrendaExtended operacionPrendaExtended) {
        this.operacionPrendaExtended = operacionPrendaExtended;
    }

    public OperacionPrendaExtended getOperacionPrendaExtended() {
        return operacionPrendaExtended;
    }    
    public MantSolicitudesWizardPaso2Dialog() {
        initComponents();
        
    }

    public void ProcesarPrimerCargado(boolean forzarRecargaDesdeBd) throws Exception {
        ModoAlta();
        //Seteamos evento de seleccion de fila en excepciones
        tableExcepciones.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                //Este metodo es el que se dispara cuando hacemos click en una fila.
                tableExcepciones_ValueChanged(lse);
            }
        });
        dialog.addNotificarResultListener(MantSolicitudesWizardPaso2Dialog.this);
    }   
    public void Reiniciar() {
        cboPrendas.setSelectedIndex(0);
        cboExcepciones.setSelectedIndex(0);
        txtCantidad.setText(Constantes.EMPTY);
        tableExcepciones.clearSelection();
    }
    private void CargarListaComboboxPrendas() throws Exception {
        if(dataSourcePrendas == null)
            dataSourcePrendas = Logica.Clases.FabricaLogica.getInstancia().getILogicaPrenda().ListarPrendas();
        //if(!omitirCargaDataSource)
            listaPrendasCbo = new LinkedList<>(dataSourcePrendas);
        
        List<String> array = new ArrayList<>();
        array.add(firstValuePrendasCbo);
        for(Prenda p : listaPrendasCbo) {
            array.add(p.getTipo());
        }        
        cboPrendas.setModel(new DefaultComboBoxModel(array.toArray()));
    }    
    private void CargarListaComboboxExcepciones(boolean omitirCargaDataSource, List<Excepcion> listadoExcepciones) throws Exception {
        if(dataSourceExcepciones == null)
            dataSourceExcepciones = Logica.Clases.FabricaLogica.getInstancia().getILogicaExcepciones().ListarExcepciones();
        if(!omitirCargaDataSource)
            listaExcepcionesCbo = new LinkedList<>(dataSourceExcepciones);
        if(listadoExcepciones != null) {
            //Quitamos excepciones que estan en la tabla al combobox
            for(int i = 0; i < listadoExcepciones.size(); i++) {
                Excepcion current = ((Excepcion)selectFirst(listaExcepcionesCbo,
                        having(on(Excepcion.class).getNombre(),
                        Matchers.equalTo(listadoExcepciones.get(i).getNombre()))));
                
                if(current != null) {
                    listaExcepcionesCbo.remove(current);
                    i--;
                }
            }
        }
        
        List<String> array = new ArrayList<>();
        array.add(firstValueExcepcionesCbo);
        for(Excepcion ex : listaExcepcionesCbo) {
            array.add(ex.getNombre());
        }
        
        cboExcepciones.setModel(new DefaultComboBoxModel(array.toArray()));
    }
    public void SetearTabla(List<Excepcion> exc) {
        try {
            Object[][] datos;
            
            if(exc == null || exc.size() == 0) {
                datos = new Object[][]{};
            } else {
                datos = new String[exc.size()][2];
                for (int i = 0; i < exc.size(); i++) {
                    
                    datos[i][0] = exc.get(i).getNombre();
                }
            }
                
            tableExcepciones.setModel(
                new DefaultTableModel(datos, Constantes.excepciones_titulosColumnas){
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
    private void tableExcepciones_ValueChanged(ListSelectionEvent lse) {
        try {
            btnQuitarExc.setEnabled(tableExcepciones.getSelectedRow() != -1);            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            btnQuitarExc.setEnabled(false);
        }
    }
    public void ModoAlta() throws Exception {
        if(prendaCargada != null) {
            throw new Exception("Error referencia no nula");
        }
        
        //cargar combobox prendas,
        CargarListaComboboxPrendas(/*true*/);
        //cargar combobox excepciones,
        CargarListaComboboxExcepciones(false, null);        
        //cboPrendas.setSelectedItem(prendaCargada.getPrenda().getTipo());
        txtCantidad.setText(Constantes.EMPTY);
        listaExcepcionesTabla = new LinkedList<>();
        SetearTabla(listaExcepcionesTabla);       
        lblError.setText(Constantes.EMPTY);
    }
    public void ModoModificar() throws Exception {
        if(prendaCargada == null) {
            throw new Exception("Error referencia nula");
        }
        
        //cargar combobox prendas,
        CargarListaComboboxPrendas();
        
        //cargar combobox excepciones,
        CargarListaComboboxExcepciones(false, prendaCargada.getPrenda().getExcepcionesList());        
        cboPrendas.setSelectedItem(prendaCargada.getPrenda().getTipo());
        txtCantidad.setText(String.valueOf(prendaCargada.getCantPrendas()));
        
        listaExcepcionesTabla = prendaCargada.getPrenda().getExcepcionesList();
        SetearTabla(listaExcepcionesTabla);
        
        lblError.setText(Constantes.EMPTY);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblSeleccPda = new javax.swing.JLabel();
        cboPrendas = new javax.swing.JComboBox();
        lblCant = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        lblSeleccExc = new javax.swing.JLabel();
        cboExcepciones = new javax.swing.JComboBox();
        jspExcepciones = new javax.swing.JScrollPane();
        tableExcepciones = new javax.swing.JTable();
        btnConfirmar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnAgregarExc = new javax.swing.JButton();
        btnQuitarExc = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lblError = new javax.swing.JTextArea();

        setMinimumSize(new java.awt.Dimension(567, 476));
        setModal(true);
        setResizable(false);

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTitulo.setText("Agregar prenda:");

        lblSeleccPda.setText("Seleccione prenda:");

        cboPrendas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboPrendas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboPrendasItemStateChanged(evt);
            }
        });

        lblCant.setText("Cantidad:");

        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        lblSeleccExc.setText("Seleccione excepciones a aplicar a esta prenda:");

        cboExcepciones.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jspExcepciones.setMinimumSize(new java.awt.Dimension(530, 124));
        jspExcepciones.setPreferredSize(new java.awt.Dimension(530, 124));

        tableExcepciones.setModel(new javax.swing.table.DefaultTableModel(
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
        jspExcepciones.setViewportView(tableExcepciones);

        btnConfirmar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnConfirmar.setText("Confirmar");
        btnConfirmar.setPreferredSize(new java.awt.Dimension(83, 30));
        btnConfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfirmarMouseClicked(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setPreferredSize(new java.awt.Dimension(83, 30));
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });

        btnAgregarExc.setText("Agregar");
        btnAgregarExc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarExcMouseClicked(evt);
            }
        });

        btnQuitarExc.setText("Quitar");
        btnQuitarExc.setEnabled(false);
        btnQuitarExc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQuitarExcMouseClicked(evt);
            }
        });

        lblError.setEditable(false);
        lblError.setBackground(new java.awt.Color(240, 240, 240));
        lblError.setColumns(20);
        lblError.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 0, 0));
        lblError.setLineWrap(true);
        lblError.setRows(5);
        lblError.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));
        jScrollPane1.setViewportView(lblError);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jspExcepciones, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnAgregarExc, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnQuitarExc, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTitulo)
                                    .addComponent(lblSeleccExc)
                                    .addComponent(cboExcepciones, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblCant)
                                            .addComponent(lblSeleccPda))
                                        .addGap(49, 49, 49)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cboPrendas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboPrendas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSeleccPda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCant)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSeleccExc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboExcepciones, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuitarExc)
                    .addComponent(btnAgregarExc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jspExcepciones, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        int lengthTxtCantidad = 3;
        char num = evt.getKeyChar();        
        
        boolean isNotANumber = (num < '0' || num > '9');  
        boolean lengthPassed = txtCantidad.getText().length() > lengthTxtCantidad;
        if (isNotANumber || lengthPassed) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        prendaCargada = null;
        
        this.dispose();
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnConfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmarMouseClicked
        try {
            if (cboPrendas.getSelectedIndex() <= 0) {
                throw new Exception("Por favor, seleccione una prenda. ");
            }
            if (Utilidades.IsNullOrEmpty(txtCantidad.getText()) || (Integer.parseInt(txtCantidad.getText()) == 0)) {
                throw new Exception("Por favor, ingrese una cantidad de prendas válida. ");
            }
            
            //Si es modo alta y existe ya la prenda o, si es modo edicion y se cambio la prenda 
            //y esta existe en la tabla del step 2: Validamos
            boolean isEditModeAndPrendaChanged = (operacionPrendaExtended == OperacionPrendaExtended.Modificar &&
                            (String)cboPrendas.getSelectedItem() != prendaCargada.getPrenda().getTipo());
            boolean isInsertMode = (operacionPrendaExtended == OperacionPrendaExtended.Alta);
            boolean existsInList = PrendaExistsInListEvent(cboPrendas.getSelectedItem(), operacionPrendaExtended);
            if ((isInsertMode && existsInList) || (isEditModeAndPrendaChanged && existsInList)) {
                throw new Exception("La prenda seleccionada ya existe en la lista de prendas de la solicitud. "
                        + "Intente modificar la ya existente o pruebe con otro tipo. ");
            }
            
            Prenda p = selectFirst(listaPrendasCbo,
                    having(on(Prenda.class).getTipo(),
                            Matchers.equalTo((String) cboPrendas.getSelectedItem())));
            p.setExcepcionesList(listaExcepcionesTabla);
            if(p.getTintoreria())
            {
                dialog.setLocationRelativeTo(null);
                dialog.setModal(true);
                dialog.setTitle("Precios de prenda");
                dialog.nombreprenda(p.getTipo());
                int result = dialog.llenarTabla(p);
                if(result == -1)
                {
                 throw new Exception("No existe tintoreria para esta prenda. Consulte a un supervisor");
                }
                else
                {
                  dialog.setVisible(true);
                } 
                
            }
            if(prendaCargada == null)
                prendaCargada = new PrendaExtended();
            prendaCargada.setPrenda(p);
            //prendaCargada.setOperacion(operacionPrendaExtended);
            prendaCargada.setCantPrendas(Integer.parseInt(txtCantidad.getText()));
            
            NotificarResultEvent(prendaCargada);
            
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnConfirmarMouseClicked

    private void btnAgregarExcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarExcMouseClicked
        try {
            if (cboExcepciones.getSelectedIndex() <= 0) {
                throw new Exception("Por favor, seleccione una excepción. ");
            }
            lblError.setText(Constantes.EMPTY);
            
            Excepcion ex = selectFirst
                    (listaExcepcionesCbo,
                    having(on(Excepcion.class).getNombre(),
                            Matchers.equalTo((String) cboExcepciones.getSelectedItem()))
                    );
            
            listaExcepcionesTabla.add(ex);   
            listaExcepcionesCbo.remove(ex);
            SetearTabla(listaExcepcionesTabla);
            CargarListaComboboxExcepciones(true, null);
        } catch (Exception e) {
            lblError.setText(e.getMessage());
        }
    }//GEN-LAST:event_btnAgregarExcMouseClicked

    private void btnQuitarExcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuitarExcMouseClicked
        if(btnQuitarExc.isEnabled()) {
            try {
                if (tableExcepciones.getSelectedRow() < 0) {
                    throw new Exception("Por favor, seleccione una excepción de la tabla para poder eliminar una. ");
                }
                lblError.setText(Constantes.EMPTY);

                Excepcion ex = listaExcepcionesTabla.get(tableExcepciones.getSelectedRow());

                if(ex == null) {
                    lblError.setText("Referencia nula!");
                }
                listaExcepcionesTabla.remove(ex); 
                listaExcepcionesCbo.add(ex);
                SetearTabla(listaExcepcionesTabla);                
                CargarListaComboboxExcepciones(true, null);
            } catch (Exception e) {
                lblError.setText(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnQuitarExcMouseClicked

    private void cboPrendasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboPrendasItemStateChanged
       String p = (String) cboPrendas.getSelectedItem();
       for(Prenda pe : dataSourcePrendas)
       {
         if(pe.getTintoreria())
         {
          if(pe.getTipo().equals(p))
          {
            cboExcepciones.setEnabled(false);
            btnAgregarExc.setEnabled(false);
            break;
          }
         } 
         else
         {
          cboExcepciones.setEnabled(true);
          btnAgregarExc.setEnabled(true);
          break;
         }
         
       }
    }//GEN-LAST:event_cboPrendasItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarExc;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnQuitarExc;
    private javax.swing.JComboBox cboExcepciones;
    private javax.swing.JComboBox cboPrendas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jspExcepciones;
    private javax.swing.JLabel lblCant;
    private javax.swing.JTextArea lblError;
    private javax.swing.JLabel lblSeleccExc;
    private javax.swing.JLabel lblSeleccPda;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tableExcepciones;
    private javax.swing.JTextField txtCantidad;
    // End of variables declaration//GEN-END:variables

    
}