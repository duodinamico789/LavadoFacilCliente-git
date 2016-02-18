package Presentacion.Frames;

import Logica.Clases.FabricaLogica;
import Entidades.Constantes;
import Entidades.Objetos.BrechaHoraria;
import Entidades.Utilidades;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class MantBrechasHorarias extends BaseJFrame {

    //PK para modificar. Son los valores viejos
    //<editor-fold defaultstate="collapsed" desc="Variables">
    private Date horaInicioTemp;
    private Date horaFinTemp;
    //</editor-fold>

    public MantBrechasHorarias() {
        initComponents();
        MostrarLoading(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBuscar = new javax.swing.JButton();
        checkNoDisp = new javax.swing.JCheckBox();
        lblLimSolic1 = new javax.swing.JLabel();
        jTabs = new javax.swing.JTabbedPane();
        jpMant = new javax.swing.JPanel();
        jbtnAlta = new javax.swing.JButton();
        jbtnModificar = new javax.swing.JButton();
        jbtnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtLimites = new javax.swing.JTextField();
        lblLimSolic = new javax.swing.JLabel();
        jpHora241 = new Presentacion.Controls.jpHora24();
        jpHora242 = new Presentacion.Controls.jpHora24();
        lblhorainicio = new javax.swing.JLabel();
        lblhorafin = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lblError = new javax.swing.JTextArea();
        jbtnCancelar = new javax.swing.JButton();
        jSeparator = new javax.swing.JLabel();
        lblDiasAplicar = new javax.swing.JLabel();
        jcheckLunes = new javax.swing.JCheckBox();
        jcheckMar = new javax.swing.JCheckBox();
        jcheckMie = new javax.swing.JCheckBox();
        jcheckJue = new javax.swing.JCheckBox();
        jcheckVie = new javax.swing.JCheckBox();
        jcheckDom = new javax.swing.JCheckBox();
        jcheckSab = new javax.swing.JCheckBox();
        panelListadoBrechas1 = new Presentacion.Controls.PanelListadoBrechas();
        jPanelLoading = new javax.swing.JPanel();
        jLabelLoading1 = new javax.swing.JLabel();
        lblTitulo1 = new javax.swing.JLabel();

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/search-icon24x24.png"))); // NOI18N

        lblLimSolic1.setText("No disponible");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(540, 500));

        jTabs.setMinimumSize(new java.awt.Dimension(530, 483));
        jTabs.setPreferredSize(new java.awt.Dimension(530, 483));

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

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Mantenimiento de brechas");

        txtLimites.setToolTipText("Ingrese un número que será el tope de lavados que se puedan solicitar en esta brecha.");

        lblLimSolic.setText("Lim. Solicitudes");

        jpHora241.setToolTipText("Hora de comienzo de la brecha horaria.");

        jpHora242.setToolTipText("Hora de finalización de la brecha horaria.");

        lblhorainicio.setText("Hora Inicio:");

        lblhorafin.setText("Hora Fin:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("horarias de delivery:");

        lblError.setEditable(false);
        lblError.setColumns(1);
        lblError.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        lblError.setForeground(new java.awt.Color(204, 0, 0));
        lblError.setLineWrap(true);
        lblError.setRows(5);
        lblError.setToolTipText("Consola de errores");
        jScrollPane2.setViewportView(lblError);

        jbtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/cancel-icon24x24.png"))); // NOI18N
        jbtnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnCancelarMouseClicked(evt);
            }
        });

        jSeparator.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/Separator-icon.png"))); // NOI18N
        jSeparator.setPreferredSize(new java.awt.Dimension(6, 24));

        lblDiasAplicar.setText("Aplicar brecha horaria para los siguientes días:");

        jcheckLunes.setText("Lunes");

        jcheckMar.setText("Martes");

        jcheckMie.setText("Miércoles");

        jcheckJue.setText("Jueves");

        jcheckVie.setText("Viernes");

        jcheckDom.setText("Domingo");

        jcheckSab.setText("Sábado");

        javax.swing.GroupLayout jpMantLayout = new javax.swing.GroupLayout(jpMant);
        jpMant.setLayout(jpMantLayout);
        jpMantLayout.setHorizontalGroup(
            jpMantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMantLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpMantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpMantLayout.createSequentialGroup()
                        .addComponent(jbtnAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(lblDiasAplicar)
                    .addGroup(jpMantLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jpMantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jcheckMar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcheckLunes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpMantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpMantLayout.createSequentialGroup()
                                .addComponent(jcheckMie, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcheckVie, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcheckDom, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpMantLayout.createSequentialGroup()
                                .addComponent(jcheckJue, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcheckSab, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jpMantLayout.createSequentialGroup()
                        .addGroup(jpMantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblhorafin)
                            .addComponent(lblhorainicio)
                            .addComponent(lblLimSolic))
                        .addGap(18, 18, 18)
                        .addGroup(jpMantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpMantLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txtLimites, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jpHora242, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpHora241, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(99, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jpMantLayout.setVerticalGroup(
            jpMantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMantLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpMantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtnAlta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jpMantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpHora241, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblhorainicio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpMantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblhorafin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpHora242, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpMantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLimSolic, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLimites))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDiasAplicar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpMantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcheckLunes)
                    .addComponent(jcheckMie)
                    .addComponent(jcheckVie)
                    .addComponent(jcheckDom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpMantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcheckMar)
                    .addComponent(jcheckJue)
                    .addComponent(jcheckSab))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabs.addTab("Mantenimiento", null, jpMant, "Aquí se podrán realizar operaciones de mantenimiento de brechas horarias (altas, bajas, modificaciones).");
        jTabs.addTab("Listado", panelListadoBrechas1);

        jPanelLoading.setMaximumSize(new java.awt.Dimension(1200, 37));
        jPanelLoading.setMinimumSize(new java.awt.Dimension(0, 37));

        jLabelLoading1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLoading1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLoading1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/loading-24x24.GIF"))); // NOI18N
        jLabelLoading1.setToolTipText("Cargando pedido");

        lblTitulo1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTitulo1.setText("Brechas horarias:");

        javax.swing.GroupLayout jPanelLoadingLayout = new javax.swing.GroupLayout(jPanelLoading);
        jPanelLoading.setLayout(jPanelLoadingLayout);
        jPanelLoadingLayout.setHorizontalGroup(
            jPanelLoadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLoadingLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lblTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLoading1)
                .addGap(0, 0, 0))
        );
        jPanelLoadingLayout.setVerticalGroup(
            jPanelLoadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoadingLayout.createSequentialGroup()
                .addGroup(jPanelLoadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblTitulo1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelLoading1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelLoading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelLoading, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabs.getAccessibleContext().setAccessibleName("Listado");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="1 Modos">
    public void ModoSeleccionOpcionParaEditarOElim(BrechaHoraria brecha) {
        try {
            //Guardo valores pk viejos
            horaInicioTemp = brecha.getHoraInicio();
            horaFinTemp = brecha.getHoraFin();

            //Modo update or delete
            String[] hInicio = brecha.getHoraInicioStr().split(":");
            int horaInicio = Integer.parseInt(hInicio[0]);
            int minsInicio = Integer.parseInt(hInicio[1]);

            String[] hFin = brecha.getHoraFinStr().split(":");
            int horaFin = Integer.parseInt(hFin[0]);
            int minsFin = Integer.parseInt(hFin[1]);

            jpHora241.Setear(horaInicio, minsInicio);
            jpHora242.Setear(horaFin, minsFin);
            txtLimites.setText(String.valueOf(brecha.getLimitees()));

            LimpiarCheckboxes();
            for (String dia : brecha.getDiasVigenciaSeparados()) {
                switch (dia) {
                    case "Lunes":
                        jcheckLunes.setSelected(true);
                        break;
                    case "Martes":
                        jcheckMar.setSelected(true);
                        break;
                    case "Miércoles":
                        jcheckMie.setSelected(true);
                        break;
                    case "Jueves":
                        jcheckJue.setSelected(true);
                        break;
                    case "Viernes":
                        jcheckVie.setSelected(true);
                        break;
                    case "Sábado":
                        jcheckSab.setSelected(true);
                        break;
                    case "Domingo":
                        jcheckDom.setSelected(true);
                        break;
                }
            }
            jbtnAlta.setEnabled(false);
            jbtnEliminar.setEnabled(true);
            jbtnModificar.setEnabled(true);
//            //Estas lineas se ejecutan en el panel
//            jbtnSelectForEditOrDelete.setEnabled(false);
//            jbtnEliminarRapido.setEnabled(false);
//            jTableOpciones.setEnabled(false);
            lblError.setText(Constantes.EMPTY);
            SetearTabSeleccionado(0);
        } catch (Exception ex) {
            SetMensajeError(Constantes.Brechaes_Error_BrechaNoCapturadaCorrect);
        }
    }

    public void ModoDefault() {
        //Borro valores pk viejos
        horaInicioTemp = null;
        horaFinTemp = null;

        jbtnAlta.setEnabled(true);
        jbtnModificar.setEnabled(false);
        jbtnEliminar.setEnabled(false);
        jpHora241.Vaciar();
        jpHora242.Vaciar();
        LimpiarCheckboxes();
        txtLimites.setText(Constantes.EMPTY);
        checkNoDisp.setSelected(false);
        lblError.setText(Constantes.EMPTY);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="2 Metodos asignados a eventos">
    public void Alta() throws Exception {
        if (jpHora241.TieneValorVacio()) {
            throw new Exception(Constantes.Brechaes_Error_HoraInicioVacio);
        }
        if (jpHora242.TieneValorVacio()) {
            throw new Exception(Constantes.Brechaes_Error_HoraFinVacio);
        }
        if (!TieneHorasCorrectas()) {
            throw new Exception(Constantes.Brechaes_Error_HorasIncorrectas);
        }
        if (Utilidades.IsNullOrEmpty(txtLimites.getText())) {
            throw new Exception(Constantes.Brechaes_Error_LimiteVacio);
        }

        if (!TieneDiasSeleccionado()) {
            throw new Exception(Constantes.Brechaes_Error_DiasNoSeleccionados);
        }

        BrechaHoraria brecha = new BrechaHoraria();

        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        brecha.setHoraInicio(formatter.parse(jpHora241.GetHoraString()));
        brecha.setHoraFin(formatter.parse(jpHora242.GetHoraString()));
        brecha.setLimitees(Integer.parseInt(txtLimites.getText()));
        brecha.setNoDisponible(checkNoDisp.isSelected());
        brecha.setDiasVigencia(ObtenerDiasStr());

        int res = FabricaLogica.getInstancia().getILogicaBrechasHorarias().AltaBrechaHoraria(brecha);

        switch (res) {
            case 0:
                //Caso exitoso
                ModoDefault();
                panelListadoBrechas1.ModoDefault();
                lblError.setText(Constantes.Brecha_ExitoAlta);
                break;
            case -2:
                lblError.setText(Constantes.Brecha_ErrorAlta_m2);
                break;
            case -1:
            case -3:
            default:
                lblError.setText(Constantes.Brecha_ErrorAlta_m1);
                break;
        }
    }

    public void Eliminar(BrechaHoraria bh) throws Exception {
        int res = FabricaLogica.getInstancia().getILogicaBrechasHorarias().BajaBrechaHoraria(bh.getHoraInicio(), bh.getHoraFin());

        switch (res) {
            case 0:
                //Caso exitoso
                ModoDefault();
                SetMensajeError(Constantes.Brecha_ExitoBaja);
                panelListadoBrechas1.ModoDefault();
                break;
            case -2:
            case -1:
            case -3:
            default:
                SetMensajeError(Constantes.Brecha_ErrorBaja_m1);
                break;
        }
    }

    private void Modificar() throws Exception {
        if (jpHora241.TieneValorVacio()) {
            throw new Exception(Constantes.Brechaes_Error_HoraInicioVacio);
        }
        if (jpHora242.TieneValorVacio()) {
            throw new Exception(Constantes.Brechaes_Error_HoraFinVacio);
        }
        if (!TieneHorasCorrectas()) {
            throw new Exception(Constantes.Brechaes_Error_HorasIncorrectas);
        }
        if (Utilidades.IsNullOrEmpty(txtLimites.getText())) {
            throw new Exception(Constantes.Brechaes_Error_LimiteVacio);
        }

        if (!TieneDiasSeleccionado()) {
            throw new Exception(Constantes.Brechaes_Error_DiasNoSeleccionados);
        }

        BrechaHoraria brecha = new BrechaHoraria();

        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        brecha.setHoraInicio(formatter.parse(jpHora241.GetHoraString()));
        brecha.setHoraFin(formatter.parse(jpHora242.GetHoraString()));
        brecha.setLimitees(Integer.parseInt(txtLimites.getText()));
        brecha.setNoDisponible(checkNoDisp.isSelected());
        brecha.setDiasVigencia(ObtenerDiasStr());

        if (horaInicioTemp == null || horaFinTemp == null) {
            throw new Exception(Constantes.Brechaes_Error_BrechaNoCapturadaCorrect);
        }

        int res = FabricaLogica.getInstancia().getILogicaBrechasHorarias()
                .ModificarBrechaHoraria(horaInicioTemp, horaFinTemp, brecha);

        switch (res) {
            case 0:
                //Caso exitoso
                ModoDefault();
                panelListadoBrechas1.ModoDefault();
                lblError.setText(Constantes.Brecha_ExitoModif);
                break;
            case -2:
                lblError.setText(Constantes.Brecha_ErrorModif_m2);
                break;
            case -1:
            case -3:
            default:
                lblError.setText(Constantes.Brecha_ErrorModif_m1);
                break;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="3 Otros Metodos">
    public void MostrarLoading(boolean mostrar) {
        jLabelLoading1.setVisible(mostrar);
    }

    public void SetearTabSeleccionado(int tabIndice) {
        this.jTabs.setSelectedIndex(tabIndice);
    }

    private void LimpiarCheckboxes() {
        jcheckLunes.setSelected(false);
        jcheckMar.setSelected(false);
        jcheckMie.setSelected(false);
        jcheckJue.setSelected(false);
        jcheckVie.setSelected(false);
        jcheckSab.setSelected(false);
        jcheckDom.setSelected(false);
    }

    public void SetMensajeError(String mensaje) {
        this.lblError.setText(mensaje);
    }

    public String ObtenerDiasStr() {
        String retorno = Constantes.EMPTY;
        if (jcheckLunes.isSelected()) {
            retorno += "Lunes,";
        }
        if (jcheckMar.isSelected()) {
            retorno += "Martes,";
        }
        if (jcheckMie.isSelected()) {
            retorno += "Miércoles,";
        }
        if (jcheckJue.isSelected()) {
            retorno += "Jueves,";
        }
        if (jcheckVie.isSelected()) {
            retorno += "Viernes,";
        }
        if (jcheckSab.isSelected()) {
            retorno += "Sábado,";
        }
        if (jcheckDom.isSelected()) {
            retorno += "Domingo,";
        }

        retorno = retorno.substring(0, retorno.length() - 1);
        return retorno;
    }

    public boolean TieneDiasSeleccionado() {
        return (jcheckLunes.isSelected() || jcheckMar.isSelected() || jcheckMie.isSelected() || jcheckJue.isSelected()
                || jcheckVie.isSelected() || jcheckSab.isSelected() || jcheckDom.isSelected());
    }

    //Metodo para arrancar ventana desde la ventana principal
    public void ProcesarPrimerCargado() {
        new Thread() {
            @Override
            public void run() {
                try {
//                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                        if ("Nimbus".equals(info.getName())) {
//                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                            break;
//                        }
//                    }
                    panelListadoBrechas1.ProcesarPrimerCargado();
                    //setDisposed(false);
                    MostrarLoading(false);
                    setVisible(true);
                } catch (Exception ex) {
                    if (ex instanceof NullPointerException) {
                        JOptionPane.showMessageDialog(null, Constantes.compartido_ErrorInesperadoNullPointer);
                    } else {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            }
        }.run();
    }

    public boolean TieneHorasCorrectas() {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
            return (formatter.parse(jpHora242.GetHoraString()).after(formatter.parse(jpHora241.GetHoraString())));
        } catch (ParseException parseException) {
            return false;
        }
    }

    //Metodo a llamar desde la ventana principal
    public static void CorrerVentana() throws Exception {
        MantBrechasHorarias mbh = new MantBrechasHorarias();
        mbh.ProcesarPrimerCargado();
        mbh.setVisible(true);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="3 Eventos registrados">
    private void jbtnAltaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnAltaMouseClicked
        if (jbtnAlta.isEnabled()) {
            Thread queryThread = new Thread() {
                @Override
                public void run() {
                    try {
                        MostrarLoading(true);
                        Alta();
                    } catch (NullPointerException npex) {
                        SetMensajeError("NullPointerException.");
                    } catch (Exception ex) {
                        lblError.setText(ex.getMessage());
                    }
                    MostrarLoading(false);
                }
            };
            lblError.setText(Constantes.Brecha_ProcesandoAlta);
            queryThread.start();
        }
    }//GEN-LAST:event_jbtnAltaMouseClicked

    private void jbtnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnModificarMouseClicked
        if (jbtnModificar.isEnabled()) {
            Thread hilo = new Thread() {
                @Override
                public void run() {
                    try {
                        MostrarLoading(true);
                        Modificar();
                    } catch (NullPointerException npex) {
                        SetMensajeError("NullPointerException.");
                    } catch (Exception ex) {
                        lblError.setText(ex.getMessage());
                    }
                    MostrarLoading(false);
                }
            };
            lblError.setText(Constantes.Brecha_ProcesandoAlta);
            hilo.start();
        }
    }//GEN-LAST:event_jbtnModificarMouseClicked

    private void jbtnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnEliminarMouseClicked
        if (jbtnEliminar.isEnabled()) {
            Thread hilo = new Thread() {
                @Override
                public void run() {
                    try {
                        MostrarLoading(true);
                        BrechaHoraria bHoraria = panelListadoBrechas1.GetBrecha();
                        Eliminar(bHoraria);
                    } catch (NullPointerException npex) {
                        SetMensajeError("NullPointerException.");
                    } catch (Exception ex) {
                        SetMensajeError(ex.getMessage());
                    }
                    MostrarLoading(false);
                }
            };
            lblError.setText(Constantes.compartido_ProcesandoEliminar);
            hilo.start();
        }
    }//GEN-LAST:event_jbtnEliminarMouseClicked

    private void jbtnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnCancelarMouseClicked
        try {
            ModoDefault();
            this.panelListadoBrechas1.ModoDefault();
        } catch (NullPointerException npex) {
            SetMensajeError("NullPointerException.");
        } catch (Exception ex) {
            lblError.setText(ex.getMessage());
        }
    }//GEN-LAST:event_jbtnCancelarMouseClicked
    // </editor-fold>
        public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MantClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MantClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MantClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MantClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MantBrechasHorarias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JCheckBox checkNoDisp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelLoading1;
    private javax.swing.JPanel jPanelLoading;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jSeparator;
    private javax.swing.JTabbedPane jTabs;
    private javax.swing.JButton jbtnAlta;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnEliminar;
    private javax.swing.JButton jbtnModificar;
    private javax.swing.JCheckBox jcheckDom;
    private javax.swing.JCheckBox jcheckJue;
    private javax.swing.JCheckBox jcheckLunes;
    private javax.swing.JCheckBox jcheckMar;
    private javax.swing.JCheckBox jcheckMie;
    private javax.swing.JCheckBox jcheckSab;
    private javax.swing.JCheckBox jcheckVie;
    private Presentacion.Controls.jpHora24 jpHora241;
    private Presentacion.Controls.jpHora24 jpHora242;
    private javax.swing.JPanel jpMant;
    private javax.swing.JLabel lblDiasAplicar;
    private javax.swing.JTextArea lblError;
    private javax.swing.JLabel lblLimSolic;
    private javax.swing.JLabel lblLimSolic1;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblhorafin;
    private javax.swing.JLabel lblhorainicio;
    private Presentacion.Controls.PanelListadoBrechas panelListadoBrechas1;
    private javax.swing.JTextField txtLimites;
    // End of variables declaration//GEN-END:variables
}
