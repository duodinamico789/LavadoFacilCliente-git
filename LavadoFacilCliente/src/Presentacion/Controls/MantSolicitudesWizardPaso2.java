package Presentacion.Controls;

import Entidades.Constantes;
import Entidades.Datatypes.PrendaExtended;
import Entidades.Enumeraciones;
import Entidades.Objetos.Excepcion;
import Entidades.Objetos.Prenda;
import Entidades.Objetos.PrendaEnvio;
import Presentacion.Interfaces.NotificarResultListener;
import Presentacion.Interfaces.ParentFrameSolicAdapter;
import Presentacion.Interfaces.PrendaExistsInListListener;
import static ch.lambdaj.Lambda.exists;
import static ch.lambdaj.Lambda.having;
import static ch.lambdaj.Lambda.on;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import org.hamcrest.Matchers;

public class MantSolicitudesWizardPaso2 extends javax.swing.JPanel implements NotificarResultListener, PrendaExistsInListListener {
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
    
    private MantSolicitudesWizardPaso2Dialog dialog;
    
    private LinkedList<PrendaExtended> listaPrendasSol = new LinkedList<>();
    private PrendaExtended selectedPrenda;
    private LinkedList<String> listaTiposPendasSol;
    
    public LinkedList<PrendaExtended> getListaPrendasExtSol() {
        return listaPrendasSol;
    }
    
    public LinkedList<PrendaEnvio> getListaPrendaEnvio()
    {
      return dialog.getListaPrendasEnvio();
    }
    public LinkedList<Prenda> getListaPrendasSol() {
        LinkedList<Prenda> prendas = new LinkedList<>();
        
        for(PrendaExtended pe : listaPrendasSol) {
            prendas.add(pe.getPrenda());
        }
        
        return prendas;
    }
    
    public MantSolicitudesWizardPaso2() {
        initComponents();
    }
           
    public void ProcesarPrimerCargado() throws Exception {
        ModoDefault();
        
        //Cargamos evento de seleccion de prenda
        tablePrendas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                //Este metodo es el que se dispara cuando hacemos click en una fila.
                tablePrendas_ValueChanged(lse);
            }
        });
        
        dialog = new MantSolicitudesWizardPaso2Dialog();
        dialog.addNotificarResultListener(MantSolicitudesWizardPaso2.this);
        dialog.setPrendaExistsInListListener(MantSolicitudesWizardPaso2.this);
        dialog.ProcesarPrimerCargado(true);
    } 
    
    public void ModoDefault() throws Exception {
        //Cargar lista vacia
        listaPrendasSol = new LinkedList<>();
        
        
//        LinkedList<Prenda> aux = new LinkedList<>();
//        for(PrendaExtended pe : listaPrendasSol) {
//            aux.add(pe.getPrenda());
//        }  
        SetearTabla(listaPrendasSol, tablePrendas);        
    }    
    
    public void SetearTabla(LinkedList<PrendaExtended> pren, javax.swing.JTable tabla) {
        try {
            Object[][] datos;
            
            if(pren == null || pren.size() == 0) {
                datos = new Object[][]{};
            } else {
                datos = new String[pren.size()][3];
                for (int i = 0; i < pren.size(); i++) {
                    
                    datos[i][0] = pren.get(i).getPrenda().getTipo();
                    datos[i][1] = String.valueOf(pren.get(i).getCantPrendas());
                    datos[i][2] = ObtenerExcepcionesStr(pren.get(i).getPrenda().getExcepcionesList());
                }
            }
                
            tabla.setModel(
                new DefaultTableModel(datos, Constantes.prendasExtended_titulosColumnas){
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
    
    private void tablePrendas_ValueChanged(ListSelectionEvent lse) {
        try {
            int row = tablePrendas.getSelectedRow();
            
            if(row != -1) {
//                selectedPrenda = ((PrendaExtended)selectFirst(listaPrendasSol,
//                        having(on(Prenda.class).getTipo(),
//                        Matchers.equalTo(listaPrendasSol.get(row).getPrenda().getTipo()))));
                selectedPrenda = listaPrendasSol.get(row);
            } else {
                selectedPrenda = null;
            }
            
            jbtnUpdate.setEnabled(row != -1);            
            jbtnEliminar.setEnabled(row != -1);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            selectedPrenda = null;
            jbtnUpdate.setEnabled(false);            
            jbtnEliminar.setEnabled(false);
        }
    }
    
    private void CargarListaTiposExistentes() {
        //Cargamos los nombres de prendas que ya estan agregadas en la tabla del step 2 para evitar ingresar otra ya existente
        //La idea es forzar al usuario a que modifique la ya existente
        LinkedList<String> list = new LinkedList<>();
        for(PrendaExtended p : listaPrendasSol) {
            list.add(p.getPrenda().getTipo());
        }

        listaTiposPendasSol = list;
    }
    
    public String ObtenerExcepcionesStr(List<Excepcion> excepciones) {
        String retorno = Constantes.EMPTY;
                
        if(excepciones.size() > 0) {
            for(int i = 0; i < excepciones.size(); i++) {
                retorno += excepciones.get(i).getNombre() + ", ";
            }
        }

        if(retorno != Constantes.EMPTY) retorno = retorno.substring(0, retorno.length() - 1);
        return retorno;
    }
    
    @Override
    public void NotificarResult_Event(Object resultado) {
        if(resultado != null) {
            //Si objeto no es nulo significa que se confirmo los cambios
            PrendaExtended pe = (PrendaExtended) resultado;
            
            switch(/*pe.getOperacion()*/ dialog.getOperacionPrendaExtended()) {
                case Alta:
                    //Agregar prenda
                    pe.setIndex(listaPrendasSol.size());
                    listaPrendasSol.add(pe);
                    break;
                case Modificar:
//                    //Cambiar objeto prenda por el nuevo
//                    int found = -1;
//                    
//                    //Quitamos excepciones que estan en la tabla al combobox
//                    for(int i = 0; i < listaPrendasSol.size(); i++) {
//                        PrendaExtended current = listaPrendasSol.get(i);
//                        
//                        if(current.getIndex() == pe.getPrenda().getTipo()) {
//                            found = i;
//                            break;
//                        }
//                    }
//                    
//                    if(found == -1)
//                        SetMensajeErrorEvent("Referencia nula!");
//                    else
//                        listaPrendasSol.set(found, pe);
                    listaPrendasSol.set(pe.getIndex(), pe);
                    break;                
            }
            
            //Actualizamos tabla
            SetearTabla(listaPrendasSol, tablePrendas); 
        }
    }
    
    @Override
    public boolean PrendaExistsInList_Event(Object param, Enumeraciones.OperacionPrendaExtended ope) {
//        switch(ope) {
//            case Alta:
//                
//            case Modificar:
//                return exists(listaTiposPendasSol, having(on(String.class), Matchers.equalTo((String) param)));
//                break;            
//        }            
//        return false;
        return exists(listaTiposPendasSol, having(on(String.class), Matchers.equalTo((String) param)));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePrendas = new javax.swing.JTable();
        jbtnAlta = new javax.swing.JButton();
        jbtnUpdate = new javax.swing.JButton();
        jbtnEliminar = new javax.swing.JButton();
        jSeparator = new javax.swing.JLabel();

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Lista de prendas:");

        jLabel1.setText("Seleccione las prendas que desea incluir, modificar o eliminar en la solicitud.");

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/cancel-icon24x24.png"))); // NOI18N
        btnCancelar.setToolTipText("Limpiar lista");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });

        tablePrendas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablePrendas);

        jbtnAlta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/insert-icon24x24.png"))); // NOI18N
        jbtnAlta.setToolTipText("Agregar una prenda");
        jbtnAlta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnAltaMouseClicked(evt);
            }
        });

        jbtnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/update2-icon24x24.png"))); // NOI18N
        jbtnUpdate.setToolTipText("Modificar prenda seleccionada");
        jbtnUpdate.setEnabled(false);
        jbtnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnUpdateMouseClicked(evt);
            }
        });

        jbtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/delete-icon24x24.png"))); // NOI18N
        jbtnEliminar.setToolTipText("Borrar prenda seleccionada");
        jbtnEliminar.setEnabled(false);
        jbtnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnEliminarMouseClicked(evt);
            }
        });

        jSeparator.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/Separator-icon.png"))); // NOI18N
        jSeparator.setPreferredSize(new java.awt.Dimension(6, 24));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE))
                        .addGap(41, 41, 41)
                        .addComponent(jbtnAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addComponent(jbtnUpdate)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnEliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jbtnAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        Thread queryThread = new Thread() {
            @Override
            public void run() {
                try {
                    ModoDefault();
                } catch (Exception ex) {
                    SetMensajeErrorEvent(ex.getMessage());
                }
                MostrarLoadingEvent(false);
            }
        };
        MostrarLoadingEvent(true);
        queryThread.start();
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void jbtnAltaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnAltaMouseClicked
        if (jbtnAlta.isEnabled()) {
            Thread hilo = new Thread() {
                @Override
                public void run() {
                    try {
                        dialog.setLocationRelativeTo(null);
                        dialog.setModal(true);
                        dialog.setTitle("Agregar una nueva prenda");
                        dialog.setOperacionPrendaExtended(Enumeraciones.OperacionPrendaExtended.Alta);
                        dialog.setPrendaCargada(null);
                        CargarListaTiposExistentes();
                        dialog.ModoAlta();
                        MostrarLoadingEvent(false);
                        dialog.setVisible(true);
                        //Despues se ejecutara el evento notificarResultado
                    } catch (Exception ex) {
                        SetMensajeErrorEvent(ex.getMessage());
                    }
                    
                }
            };
            MostrarLoadingEvent(true);
            hilo.start();
        }
    }//GEN-LAST:event_jbtnAltaMouseClicked
    
    private void jbtnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnUpdateMouseClicked
        if (jbtnUpdate.isEnabled()) {
            Thread hilo = new Thread() {
                @Override
                public void run() {
                    try {
                        dialog.setLocationRelativeTo(null);
                        dialog.setModal(true);
                        dialog.setTitle("Modificar prenda existente");
                        dialog.setOperacionPrendaExtended(Enumeraciones.OperacionPrendaExtended.Modificar); 
                        dialog.setPrendaCargada(selectedPrenda);
                        CargarListaTiposExistentes();
                        dialog.ModoModificar();
                        MostrarLoadingEvent(false);
                        dialog.setVisible(true);
                        //Despues se ejecutara el evento notificarResultado
                    } catch (Exception ex) {
                        SetMensajeErrorEvent(ex.getMessage());
                    }
                    MostrarLoadingEvent(false);
                }
            };
            MostrarLoadingEvent(true);
            hilo.start();
        }
    }//GEN-LAST:event_jbtnUpdateMouseClicked

    private void jbtnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnEliminarMouseClicked
        try {
            if (jbtnEliminar.isEnabled()) {
                int opcionElegida = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar esta prenda?", "Está seguro?", JOptionPane.YES_NO_OPTION);
                if (opcionElegida == JOptionPane.YES_OPTION) {
                    listaPrendasSol.remove(selectedPrenda);
                    SetearTabla(listaPrendasSol, tablePrendas);
                }
            }
        } catch (Exception ex) {
            SetMensajeErrorEvent(ex.getMessage());
        }
    }//GEN-LAST:event_jbtnEliminarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jSeparator;
    private javax.swing.JButton jbtnAlta;
    private javax.swing.JButton jbtnEliminar;
    private javax.swing.JButton jbtnUpdate;
    private javax.swing.JTable tablePrendas;
    // End of variables declaration//GEN-END:variables

}
