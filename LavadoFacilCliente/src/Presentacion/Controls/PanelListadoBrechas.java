package Presentacion.Controls;

import Logica.Clases.FabricaLogica;
import Entidades.Constantes;
import Entidades.Objetos.BrechaHoraria;
import Entidades.Utilidades;
import static Entidades.Utilidades.*;
import Presentacion.Frames.MantBrechasHorarias;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import static ch.lambdaj.Lambda.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import org.hamcrest.Matchers;

public class PanelListadoBrechas extends javax.swing.JPanel {

    //<editor-fold defaultstate="collapsed" desc="Variables">
    JFrame padreFrame;
    private String selectedBrecha_HoraInicio;
    private String selectedBrecha_HoraFin;
    private int selectedRow;
    private List<BrechaHoraria> dataSource;
    //</editor-fold>

    public PanelListadoBrechas() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="1 Modos">
    public void ModoDefault() throws Exception {
        jtxtFiltrarHIni.setText(Constantes.EMPTY);
        jtxtFiltrarHFin.setText(Constantes.EMPTY);
        jtxtFiltrarLim.setText(Constantes.EMPTY);
        jcomboDisp.setSelectedItem("No Filtrar");
        tableBrechas.setEnabled(true);
        lblErrorPanelListado.setText(Constantes.EMPTY);
        RecargarLista();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="2 Metodos asignados a eventos">
    public BrechaHoraria GetBrecha() throws Exception {
        //Row not selected validation
        selectedRow = tableBrechas.getSelectedRow();

        if (selectedRow == -1) {
            throw new Exception(Constantes.Brechaes_Error_seleccioneBrecha);
        }

        selectedBrecha_HoraInicio = String.valueOf(tableBrechas.getValueAt(selectedRow, 0));
        selectedBrecha_HoraFin = String.valueOf(tableBrechas.getValueAt(selectedRow, 1));

        if (Utilidades.IsNullOrEmpty(selectedBrecha_HoraInicio)
                || Utilidades.IsNullOrEmpty(selectedBrecha_HoraFin)) {
            throw new Exception(Constantes.Brechaes_Error_BrechaNoCapturadaCorrect);
        }

        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        Date horaInicio = formatter.parse(selectedBrecha_HoraInicio);
        Date horaFin = formatter.parse(selectedBrecha_HoraFin);

        return FabricaLogica.getInstancia().getILogicaBrechasHorarias().BuscarBrechaHoraria(horaInicio, horaFin);
    }

    private void Refrescar() throws InterruptedException, Exception {

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    ((MantBrechasHorarias) padreFrame).MostrarLoading(true);

                    //Para probar el loader
                    Thread.sleep(2000);
                    Filtrar(true);

                    ((MantBrechasHorarias) padreFrame).MostrarLoading(false);
                } catch (NullPointerException npex) {
                    ((MantBrechasHorarias) padreFrame).SetMensajeError("NullPointerException.");
                } catch (Exception e) {
                    ((MantBrechasHorarias) padreFrame).SetMensajeError(e.getMessage());
                }
            }
        };
        thread.start();
    }

    private void SeleccionarElementoParaModificar() throws Exception {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    ((MantBrechasHorarias) padreFrame).MostrarLoading(true);
                    BrechaHoraria bh = GetBrecha();
                    ((MantBrechasHorarias) padreFrame).ModoSeleccionOpcionParaEditarOElim(bh);
                    
                } catch (NullPointerException npex) {
                    ((MantBrechasHorarias) padreFrame).SetMensajeError("NullPointerException.");
                } catch (Exception exception) {
                    ((MantBrechasHorarias) padreFrame).SetMensajeError(exception.getMessage());
                }
                ((MantBrechasHorarias) padreFrame).MostrarLoading(false);
            }
        };
        thread.start();;
    }

    private void ComboDisponibilidadChanged() throws Exception {
        Filtrar(false);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="3 Otros Metodos">
    public void HabilitarTabla(boolean habilitar) {
        tableBrechas.setEnabled(habilitar);
    }

    public void HabilitarBotonesListado(boolean habilitar) {
        jbtnSelectForEditOrDelete.setEnabled(habilitar);
        jbtnEliminarRapido.setEnabled(habilitar);
    }
    // </editor-fold>

    //<editor-fold defaultstate="collapsed" desc="4 Metodos referidos al listado y filtrado de elementos">
    //Actualiza el dataSource
    private void RecargarDataSource() throws Exception {
        dataSource = FabricaLogica.getInstancia().getILogicaBrechasHorarias().ListarBrechasHorarias();
    }

    //Dejar parametro en null si se desea listar el dataSource
    private void Listar(List<BrechaHoraria> dataSourceFiltrado) throws Exception {
        if (IsNull(dataSourceFiltrado)) {
            dataSourceFiltrado = dataSource;
        }

        tableBrechas.setModel(GetModeloTabla(dataSourceFiltrado));
    }

    private void Filtrar(boolean recargarDataSource) throws Exception {
        if (recargarDataSource) {
            RecargarDataSource();
        }

        String filtrarNoDisp = Constantes.EMPTY;
        if (jcomboDisp.getSelectedItem().toString().equals("Disponible")) {
            filtrarNoDisp = "False";
        } else if (jcomboDisp.getSelectedItem().toString().equals("No disponible")) {
            filtrarNoDisp = "True";
        }

        Filtrar_ProcesoDos(jtxtFiltrarHIni.getText(),
                jtxtFiltrarHFin.getText(),
                jtxtFiltrarLim.getText(),
                filtrarNoDisp);
    }

    private void Filtrar_ProcesoDos(String filtroHoraIni, String filtroHoraFin, String filtroLimite, String filtroNoDisp) throws Exception {
        List<BrechaHoraria> dataSourceFiltrado = dataSource;

        // <editor-fold desc="Filtros">
        if (!Utilidades.IsNullOrEmpty(filtroHoraIni)) {
            dataSourceFiltrado = select(dataSourceFiltrado,
                    having(on(BrechaHoraria.class).getHoraInicioStr(),
                            Matchers.startsWith(filtroHoraIni)));
        }
        if (!Utilidades.IsNullOrEmpty(filtroHoraFin)) {
            dataSourceFiltrado = select(dataSourceFiltrado,
                    having(on(BrechaHoraria.class).getHoraFinStr(),
                            Matchers.startsWith(filtroHoraFin)));
        }
        if (!Utilidades.IsNullOrEmpty(filtroLimite)) {
            if (Utilidades.IsNotANumber(filtroLimite)) {
                throw new Exception(Constantes.compartido_Error_FormatoNumero);
            } else {
                dataSourceFiltrado = select(dataSourceFiltrado,
                        having(on(BrechaHoraria.class).getLimitees(),
                                Matchers.equalTo(Integer.parseInt(filtroLimite))));
            }
        }
        if (!Utilidades.IsNullOrEmpty(filtroNoDisp)) {
            dataSourceFiltrado = select(dataSourceFiltrado,
                    having(on(BrechaHoraria.class).getNoDisponible(),
                            Matchers.equalTo(Boolean.parseBoolean(filtroNoDisp))));
        }
        // </editor-fold>

        Listar(dataSourceFiltrado);
    }

    public void RecargarLista() throws Exception {
        RecargarDataSource();
        Listar(null);
    }

    public void RecargarLista(String filtroHoraIni, String filtroHoraFin, String filtroLimite, String filtroNoDisp) throws Exception {
        RecargarDataSource();
        Filtrar_ProcesoDos(filtroHoraIni, filtroHoraFin, filtroLimite, filtroNoDisp);
    }

    private DefaultTableModel GetModeloTabla(List<BrechaHoraria> lista) {
        if (lista == null) {
            lista = new LinkedList<BrechaHoraria>();
        }
        Object[][] datos = new Object[lista.size()][5];

        for (int i = 0; i < lista.size(); i++) {
            datos[i][0] = lista.get(i).getHoraInicioStr();
            datos[i][1] = lista.get(i).getHoraFinStr();
            datos[i][2] = lista.get(i).getDiasVigencia();
            datos[i][3] = String.valueOf(lista.get(i).getLimitees());
            datos[i][4] = lista.get(i).getNoDisponible();
        }

        //return model
        return new javax.swing.table.DefaultTableModel(datos, Constantes.brechas_titulosColumnas) {
            //Para que no pueda ser editado
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="5 Otros metodos">
    //Si se desea asignar una variable o realizar una accion antes de cargar la 
    //página, agregar código a este método.
    public void ProcesarPrimerCargado() throws Exception {
        padreFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        try {
            RecargarLista();

            //Event when selecting a row            
            //<editor-fold defaultstate="collapsed" desc="3 Manual Events">
            this.tableBrechas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

                @Override
                public void valueChanged(ListSelectionEvent lse) {
                    //Este metodo es el que se dispara cuando hacemos click en una fila.
                    tableBrechas_ValueChanged(lse);
                }
            });
            this.jtxtFiltrarHIni.getDocument().addDocumentListener(new DocumentListener() {

                @Override
                public void insertUpdate(DocumentEvent de) {
                    jtxtFiltrarHIni_textChanged(de);
                }

                @Override
                public void removeUpdate(DocumentEvent de) {
                    jtxtFiltrarHIni_textChanged(de);
                }

                @Override
                public void changedUpdate(DocumentEvent de) {
                    jtxtFiltrarHIni_textChanged(de);
                }

            });
            this.jtxtFiltrarLim.getDocument().addDocumentListener(new DocumentListener() {

                @Override
                public void insertUpdate(DocumentEvent de) {
                    jtxtFiltrarLim_textChanged(de);
                }

                @Override
                public void removeUpdate(DocumentEvent de) {
                    jtxtFiltrarLim_textChanged(de);
                }

                @Override
                public void changedUpdate(DocumentEvent de) {
                    jtxtFiltrarLim_textChanged(de);
                }

            });
            this.jtxtFiltrarHFin.getDocument().addDocumentListener(new DocumentListener() {

                @Override
                public void insertUpdate(DocumentEvent de) {
                    jtxtFiltrarHFin_textChanged(de);
                }

                @Override
                public void removeUpdate(DocumentEvent de) {
                    jtxtFiltrarHFin_textChanged(de);
                }

                @Override
                public void changedUpdate(DocumentEvent de) {
                    jtxtFiltrarHFin_textChanged(de);
                }

            });
//</editor-fold>
        } catch (Exception ex) {
            new JOptionPane("Ocurrió un error inesperado al iniciar el listado de brechas. Por favor, contacte su administrador. ").show();
        }
    }

    // </editor-fold>

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtnFiltrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBrechas = new javax.swing.JTable();
        panelLabels = new javax.swing.JPanel();
        jFiltrarDir = new javax.swing.JLabel();
        jFiltrarRef = new javax.swing.JLabel();
        jFiltrarLim = new javax.swing.JLabel();
        jFiltrarPorDisp = new javax.swing.JLabel();
        panelTextfields = new javax.swing.JPanel();
        jtxtFiltrarHIni = new javax.swing.JTextField();
        jtxtFiltrarHFin = new javax.swing.JTextField();
        jtxtFiltrarLim = new javax.swing.JTextField();
        jcomboDisp = new javax.swing.JComboBox();
        jbtnRefrescar = new javax.swing.JButton();
        jbtnSelectForEditOrDelete = new javax.swing.JButton();
        jbtnEliminarRapido = new javax.swing.JButton();
        lblErrorPanelListado = new javax.swing.JLabel();

        jbtnFiltrar.setText("Filtrar");

        setMinimumSize(new java.awt.Dimension(450, 300));
        setPreferredSize(new java.awt.Dimension(450, 300));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Listado de brechas horarias:");

        tableBrechas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableBrechas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tableBrechas);
        tableBrechas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        panelLabels.setLayout(new java.awt.GridLayout(1, 0, 5, 0));

        jFiltrarDir.setText("Filtrar por H. Ini.:");
        jFiltrarDir.setToolTipText("");
        panelLabels.add(jFiltrarDir);

        jFiltrarRef.setText("Filtrar por H. Fin.:");
        panelLabels.add(jFiltrarRef);

        jFiltrarLim.setText("Filtrar por lim.:");
        panelLabels.add(jFiltrarLim);

        jFiltrarPorDisp.setText("Filtrar por disp.:");
        panelLabels.add(jFiltrarPorDisp);

        panelTextfields.setLayout(new java.awt.GridLayout(1, 2, 5, 0));

        jtxtFiltrarHIni.setMaximumSize(new java.awt.Dimension(200, 200));
        panelTextfields.add(jtxtFiltrarHIni);

        jtxtFiltrarHFin.setMaximumSize(new java.awt.Dimension(200, 200));
        panelTextfields.add(jtxtFiltrarHFin);

        jtxtFiltrarLim.setMaximumSize(new java.awt.Dimension(200, 200));
        panelTextfields.add(jtxtFiltrarLim);

        jcomboDisp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No filtrar", "Disponible", "No disponible" }));
        jcomboDisp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboDispActionPerformed(evt);
            }
        });
        panelTextfields.add(jcomboDisp);

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

        lblErrorPanelListado.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblErrorPanelListado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelLabels, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(panelTextfields, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtnEliminarRapido, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnSelectForEditOrDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelLabels, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTextfields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnRefrescar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnSelectForEditOrDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnEliminarRapido)
                        .addGap(0, 93, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblErrorPanelListado))
        );
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="6 Eventos">
    private void jcomboDispActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboDispActionPerformed
        Thread hilo = new Thread() {
            @Override
            public void run() {
                try {
                    ComboDisponibilidadChanged();
                } catch (NullPointerException npex) {
                    ((MantBrechasHorarias) padreFrame).SetMensajeError("NullPointerException.");
                } catch (Exception ex) {
                    lblErrorPanelListado.setText(Constantes.compartido_ErrorInesperado);
                }
            }
        };
        hilo.start();
    }//GEN-LAST:event_jcomboDispActionPerformed

    private void jbtnEliminarRapidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnEliminarRapidoMouseClicked
        if (jbtnEliminarRapido.isEnabled()) {
            try {
                ((MantBrechasHorarias) padreFrame).Eliminar(this.GetBrecha());
            } catch (NullPointerException npex) {
                ((MantBrechasHorarias) padreFrame).SetMensajeError("NullPointerException.");
            } catch (Exception ex) {
                lblErrorPanelListado.setText(Constantes.Brechaes_Error_BrechaNoCapturadaCorrect);
            }
        }
    }//GEN-LAST:event_jbtnEliminarRapidoMouseClicked

    private void jbtnSelectForEditOrDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnSelectForEditOrDeleteMouseClicked
        if (jbtnSelectForEditOrDelete.isEnabled()) {
            try {
                SeleccionarElementoParaModificar();
            } catch (NullPointerException npex) {
                ((MantBrechasHorarias) padreFrame).SetMensajeError("NullPointerException.");
            } catch (Exception ex) {
                lblErrorPanelListado.setText(ex.getMessage());
            }
        }
    }//GEN-LAST:event_jbtnSelectForEditOrDeleteMouseClicked

    private void jbtnRefrescarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnRefrescarMouseClicked
        if (jbtnRefrescar.isEnabled()) {
            Thread hilo = new Thread() {
                @Override
                public void run() {
                    try {
                        Refrescar();
                    } catch (NullPointerException npex) {
                        ((MantBrechasHorarias) padreFrame).SetMensajeError("NullPointerException.");
                    } catch (Exception ex) {
                        ((MantBrechasHorarias) padreFrame).SetMensajeError(Constantes.compartido_ErrorInesperado);
                    }
                }
            };

            hilo.start();
        }
    }//GEN-LAST:event_jbtnRefrescarMouseClicked

    //Controla que si una fila esta seleccionada se activen los botones
    private void tableBrechas_ValueChanged(ListSelectionEvent lse) {
        try {
            selectedRow = tableBrechas.getSelectedRow();

            if (selectedRow == -1) {
                selectedBrecha_HoraInicio = Constantes.EMPTY;
                selectedBrecha_HoraFin = Constantes.EMPTY;
                HabilitarBotonesListado(false);
            } else {
                selectedBrecha_HoraInicio = tableBrechas.getValueAt(selectedRow, 0).toString();
                selectedBrecha_HoraFin = tableBrechas.getValueAt(selectedRow, 1).toString();
                HabilitarBotonesListado(true);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            selectedBrecha_HoraInicio = Constantes.EMPTY;
            selectedBrecha_HoraFin = Constantes.EMPTY;
            HabilitarBotonesListado(false);
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Eventos asociados a los textbox filtro">
    //Controla lo que ingresa el usuario en jtxtFiltrarDir
    private void jtxtFiltrarHIni_textChanged(DocumentEvent de) {
        try {
            Filtrar(false);
        } catch (Exception ex) {
        }
    }

    private void jtxtFiltrarHFin_textChanged(DocumentEvent de) {
        try {
            Filtrar(false);
        } catch (Exception ex) {
        }
    }

    private void jtxtFiltrarLim_textChanged(DocumentEvent de) {
        try {
            Filtrar(false);
        } catch (Exception ex) {
            ((MantBrechasHorarias) padreFrame).SetMensajeError(Constantes.compartido_ErrorInesperado);
        }
    }
//</editor-fold>
    // </editor-fold>

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jFiltrarDir;
    private javax.swing.JLabel jFiltrarLim;
    private javax.swing.JLabel jFiltrarPorDisp;
    private javax.swing.JLabel jFiltrarRef;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnEliminarRapido;
    private javax.swing.JButton jbtnFiltrar;
    private javax.swing.JButton jbtnRefrescar;
    private javax.swing.JButton jbtnSelectForEditOrDelete;
    private javax.swing.JComboBox jcomboDisp;
    private javax.swing.JTextField jtxtFiltrarHFin;
    private javax.swing.JTextField jtxtFiltrarHIni;
    private javax.swing.JTextField jtxtFiltrarLim;
    private javax.swing.JLabel lblErrorPanelListado;
    private javax.swing.JPanel panelLabels;
    private javax.swing.JPanel panelTextfields;
    private javax.swing.JTable tableBrechas;
    // End of variables declaration//GEN-END:variables
}
