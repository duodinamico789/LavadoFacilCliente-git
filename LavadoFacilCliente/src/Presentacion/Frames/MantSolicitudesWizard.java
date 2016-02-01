package Presentacion.Frames;

import Entidades.Constantes;
import Entidades.Datatypes.PrendaExtended;
import Entidades.Enumeraciones;
import Entidades.Exceptions.DataAccessException;
import Entidades.Objetos.Cliente;
import Entidades.Objetos.Empleado;
import Entidades.Objetos.Opcion;
import Entidades.Objetos.Prenda;
import Entidades.Objetos.PrendaEnvio;
import Entidades.Objetos.Solicitud;
import Entidades.Objetos.SolicitudDetalle;
import Entidades.Utilidades;
import Logica.Clases.FabricaLogica;
import Presentacion.Interfaces.ParentFrameSolicAdapter;
import java.awt.CardLayout;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class MantSolicitudesWizard extends BaseJFrame implements ParentFrameSolicAdapter {

    private Empleado logueado;
    private Solicitud solicitud;
    private CardLayout cardLayout;
    private LinkedList<String> steps;
    private int index;
    
    public MantSolicitudesWizard() {
        initComponents();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MantSolicitudesWizard f = new MantSolicitudesWizard();
                try {
                    Empleado e = (Empleado)FabricaLogica.getInstancia().getILogicaPersonas().BuscarPersona("78810941");
                    if(f.ProcesarPrimerCargado(e)) {
                        f.setVisible(true);
                    }
                } catch (Exception ex) {
                    if (ex instanceof NullPointerException)
                        IniciarFrameError(Constantes.compartido_ErrorInesperadoNullPointer);
                    else
                        IniciarFrameError(ex.getMessage());
                }
            }
        });
    }
    
    public static void IniciarFrameError(String mensajeError) {
        ErrorInesperado frame = new ErrorInesperado();
        frame.CorrerVentana(mensajeError);
    }

    @Override
    public void MostrarLoading(boolean mostrar) {
        jLabelLoading.setVisible(mostrar);
    }

    @Override
    public void SetMensajeError(String mensaje) {
        lblError.setText(mensaje);
    }

    //MODIFICAR
    public boolean ProcesarPrimerCargado(Empleado _logueado) {
        boolean exito = false;
        try {
            //Carga del usuario logueado
            logueado = _logueado;
            
            //Set botones step 1
            btnCancelar.setEnabled(true);
            btnAnterior.setEnabled(false);
            btnSiguiente.setEnabled(true);
            btnFinalizar.setEnabled(false);            
            MostrarLoading(false);
            
            //Procesamiento de los controles de pasos
            mantSolicitudesWizardPaso1.ProcesarPrimerCargado();
            mantSolicitudesWizardPaso1.addParentFrameSolicAdapter(this);
            mantSolicitudesWizardPaso2.ProcesarPrimerCargado();
            mantSolicitudesWizardPaso2.addParentFrameSolicAdapter(this);
            mantSolicitudesWizardPaso3.ProcesarPrimerCargado(true);
            mantSolicitudesWizardPaso3.addParentFrameSolicAdapter(this);
            //El procesar primer cargado se reserva para cuando se tenga la solicitud entera
            mantSolicitudesWizardPaso4.addParentFrameSolicAdapter(this);
            
            //CardLayout Steps
            steps = Constantes.getStepsSolicitudLavado();
            index = 0;

            //CardLayout
            cardLayout = (CardLayout) jpContenido.getLayout();
            cardLayout.show(jpContenido, steps.get(index));
            exito = true;
        } catch (Exception e) {
            if(e instanceof DataAccessException) {
                JOptionPane.showMessageDialog(MantSolicitudesWizard.this, Constantes.compartido_ErrorConexion);
            }
            else
                JOptionPane.showMessageDialog(MantSolicitudesWizard.this, e.getMessage().substring(0, 50));
        }
        return exito;
    }
    
    private void InicializarSolicitud(Date fechaActual) throws Exception {
        solicitud = new Solicitud();
        solicitud.setEmpleado(logueado);
        solicitud.setCedulaCli((Cliente)mantSolicitudesWizardPaso1.getCli());
        solicitud.setSuc(logueado.getSucursal());
        solicitud.setFechaIngreso(fechaActual);
        solicitud.setFechaEntrega(mantSolicitudesWizardPaso3.getFechaEntrega().getTime());
        solicitud.setEstado(Enumeraciones.EstadosSolicitud.En_Proceso);
        solicitud.setPrendas(mantSolicitudesWizardPaso2.getListaPrendasSol());
        solicitud.setObservaciones(mantSolicitudesWizardPaso3.getObservaciones());
        solicitud.setOpcionesList(mantSolicitudesWizardPaso3.getListaOpcionesTabla());    
        solicitud.setDelivery(mantSolicitudesWizardPaso3.getIsDelivery());
        solicitud.setBrechaHoraria(mantSolicitudesWizardPaso3.getBrechaHoraria());
        solicitud.setDetalles(getListaComoDetalle());
    }
    
    public LinkedList<SolicitudDetalle> getListaComoDetalle() {
        BigDecimal precioTotal = new BigDecimal(0);
        LinkedList<SolicitudDetalle> detalles = new LinkedList<>();
        int linea = 1;
        LinkedList<PrendaEnvio> preEnvio = mantSolicitudesWizardPaso2.getListaPrendaEnvio();
        for(PrendaExtended pe : mantSolicitudesWizardPaso2.getListaPrendasExtSol()) {
            SolicitudDetalle sd = new SolicitudDetalle();
            sd.setLinea(linea);
            sd.setPrenda(pe.getPrenda());           
            if(pe.getPrenda().getTintoreria())
            {
             BigDecimal precio = new BigDecimal(0);
              for(PrendaEnvio preE : preEnvio)
              {
                if(preE.getIdpren().getIdpda() ==pe.getPrenda().getIdpda())
                {
                  int cant = pe.getCantPrendas();
                  for(int i =0; i<cant;i++)
                  {
                    precio = precio.add(preE.getPrecio());
                  }
                  sd.setCantidad(pe.getCantPrendas());
                  sd.setPrecio(precio);
                  sd.setDescripcion(pe.getPrenda().getTipo() + ", " 
                    + pe.getCantPrendas() +  " unid. - " 
                    + Utilidades.ObtenerExcepcionesStr(pe.getPrenda().getExcepcionesList(), 100)
                    + "$" + precio); 
                  precioTotal = precioTotal.add(precio);
                }
              }
            }
            else
            {
                sd.setPrecio(0);
                sd.setDescripcion(pe.getPrenda().getTipo() + ", " 
                        + pe.getCantPrendas() +  " unid. - " 
                        + Utilidades.ObtenerExcepcionesStr(pe.getPrenda().getExcepcionesList(), 100));
                sd.setCantidad(pe.getCantPrendas());
            }
            detalles.add(sd);
            linea++;
        }
        
        for(Opcion p : mantSolicitudesWizardPaso3.getListaOpcionesTabla()) {
            Prenda pre = new Prenda();
            pre.setIdpda(1);
            SolicitudDetalle sd = new SolicitudDetalle();
            sd.setLinea(linea);
            sd.setCantidad(0);
            sd.setPrenda(pre);
            precioTotal = precioTotal.add(p.getPrecio());
            sd.setPrecio(precioTotal);
            sd.setDescripcion(p.getNombre());
            detalles.add(sd);
            linea++;
        }       
        return detalles;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpContenido = new javax.swing.JPanel();
        mantSolicitudesWizardPaso1 = new Presentacion.Controls.MantSolicitudesWizardPaso1();
        mantSolicitudesWizardPaso2 = new Presentacion.Controls.MantSolicitudesWizardPaso2();
        mantSolicitudesWizardPaso3 = new Presentacion.Controls.MantSolicitudesWizardPaso3();
        mantSolicitudesWizardPaso4 = new Presentacion.Controls.MantSolicitudesWizardPaso4();
        jpErrores = new javax.swing.JPanel();
        lblError = new javax.swing.JLabel();
        jLabelLoading = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        jpPasos = new javax.swing.JPanel();
        btnSiguiente = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        jSeparator = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JLabel();
        lblPaso = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(730, 680));

        jpContenido.setLayout(new java.awt.CardLayout());

        mantSolicitudesWizardPaso1.setPreferredSize(new java.awt.Dimension(438, 450));
        jpContenido.add(mantSolicitudesWizardPaso1, "mantSolicitudesWizardPaso1");
        jpContenido.add(mantSolicitudesWizardPaso2, "card3");
        jpContenido.add(mantSolicitudesWizardPaso3, "card4");
        jpContenido.add(mantSolicitudesWizardPaso4, "card5");

        jpErrores.setLayout(new java.awt.BorderLayout());

        lblError.setForeground(new java.awt.Color(255, 0, 0));
        lblError.setToolTipText("");
        jpErrores.add(lblError, java.awt.BorderLayout.CENTER);

        jLabelLoading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLoading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/loading-24x24.GIF"))); // NOI18N
        jLabelLoading.setToolTipText("Cargando pedido");

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTitulo.setText("Crear solicitud de lavado:");

        jpPasos.setBackground(new java.awt.Color(240, 220, 220));
        jpPasos.setMinimumSize(new java.awt.Dimension(418, 55));

        btnSiguiente.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnSiguiente.setText("Siguiente >");
        btnSiguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSiguienteMouseClicked(evt);
            }
        });

        btnAnterior.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnAnterior.setText("< Anterior");
        btnAnterior.setEnabled(false);
        btnAnterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAnteriorMouseClicked(evt);
            }
        });

        jSeparator.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/Separator-icon.png"))); // NOI18N
        jSeparator.setPreferredSize(new java.awt.Dimension(6, 24));

        btnCancelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });

        btnFinalizar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnFinalizar.setText("Finalizar");
        btnFinalizar.setEnabled(false);
        btnFinalizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFinalizarMouseClicked(evt);
            }
        });
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        jSeparator1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/Separator-icon.png"))); // NOI18N
        jSeparator1.setPreferredSize(new java.awt.Dimension(6, 24));

        javax.swing.GroupLayout jpPasosLayout = new javax.swing.GroupLayout(jpPasos);
        jpPasos.setLayout(jpPasosLayout);
        jpPasosLayout.setHorizontalGroup(
            jpPasosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPasosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAnterior)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSiguiente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFinalizar)
                .addContainerGap())
        );
        jpPasosLayout.setVerticalGroup(
            jpPasosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPasosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPasosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpPasosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnAnterior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSiguiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addComponent(btnFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        lblPaso.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblPaso.setText("Paso 1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpErrores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpPasos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPaso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLoading, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jpContenido, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPaso))
                    .addComponent(jLabelLoading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpContenido, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpErrores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpPasos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        if(btnCancelar.isEnabled()){
            int opcionElegida = JOptionPane.showConfirmDialog(null, "Está seguro de cancelar esta solicitud?", "Está seguro?", JOptionPane.YES_NO_OPTION);
            if (opcionElegida == JOptionPane.YES_OPTION) {
                this.dispose();
            }
        }
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnSiguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSiguienteMouseClicked
        if(btnSiguiente.isEnabled()) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    try {
                        String error = Constantes.EMPTY;
                        switch(index) {
                            case 0:
                                //Validar, si esta todo bien seguimos
                                if(mantSolicitudesWizardPaso1.getCli() == null) {
                                    error = "Busque un cliente para poder continuar. ";
                                } 
                                break;
                            case 1:
                                if(mantSolicitudesWizardPaso2.getListaPrendasExtSol().size() == 0) {
                                    error = "Ingrese al menos una prenda para poder continuar. ";
                                } 
                                break;
                            case 2:
                                String msjError = mantSolicitudesWizardPaso3.ValidacionCorrecta();
                                if(!msjError.equals(Constantes.EMPTY)) {
                                    error = msjError;
                                } else {
                                    //Paso final... obtenemos objeto solicitud y cargamos resumen
                                    InicializarSolicitud(Calendar.getInstance().getTime());
                                    mantSolicitudesWizardPaso4.ProcesarPrimerCargado(solicitud);
                                }
                                break;                                
                        }
                        
                        if(error != Constantes.EMPTY) {
                            SetMensajeError(error);
                        } else {
                            //Todo ok
                            //Deshabilitar este boton y Habilitar el boton finalizar si el sig paso es el final
                            if (index == steps.size() - 1) {
                                btnSiguiente.setEnabled(false);
                                btnFinalizar.setEnabled(true);
                            } else {
                                //Cambiar valor textbox txtPasos
                                lblPaso.setText("Paso " + (index + 2));
                                //Cambiar de panel
                                cardLayout.next(MantSolicitudesWizard.this.jpContenido);
                            }

                            index++;
                            //Habilitar boton anterior
                            btnAnterior.setEnabled(true);
                        }                        
                        
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(MantSolicitudesWizard.this, e.getMessage());
                    }
                    MostrarLoading(false);
                }
            };
            MostrarLoading(true);
            thread.start();
        }
    }//GEN-LAST:event_btnSiguienteMouseClicked

    private void btnAnteriorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnteriorMouseClicked
        if(btnAnterior.isEnabled()) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    try {
                        //Validar, si todo esta bien seguimos
                        //Cambiar al panel anterior
                        cardLayout.previous(MantSolicitudesWizard.this.jpContenido);

                        if (index == steps.size() - 1) {
                            //Dejamos null la solicitud
                            solicitud = null;
                            
                            //Si estamos en el paso final deshabilitamos ese boton
                            btnFinalizar.setEnabled(false);
                        }
                        index--;
                        //Cambiamos texto txtPasos
                        lblPaso.setText("Paso " + (index + 1));
                        //Deshabilitar este boton si estamos al primer paso
                        if (index == 0) {
                            btnAnterior.setEnabled(false);
                            btnSiguiente.setEnabled(true);
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(MantSolicitudesWizard.this, e.getMessage().substring(0, 50));
                    }
                    MostrarLoading(false);
                }
            };
            MostrarLoading(true);
            thread.start();
        }
    }//GEN-LAST:event_btnAnteriorMouseClicked

    private void btnFinalizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFinalizarMouseClicked
        if(btnFinalizar.isEnabled()) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    try {
                        
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(MantSolicitudesWizard.this, e.getMessage().substring(0, 50));
                    }
                    MostrarLoading(false);
                }
            };
            MostrarLoading(true);
            thread.start();
        }
    }//GEN-LAST:event_btnFinalizarMouseClicked

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFinalizarActionPerformed

    //<editor-fold defaultstate="collapsed" desc="Codigo autogenerado Netbeans">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel jLabelLoading;
    private javax.swing.JLabel jSeparator;
    private javax.swing.JLabel jSeparator1;
    private javax.swing.JPanel jpContenido;
    private javax.swing.JPanel jpErrores;
    private javax.swing.JPanel jpPasos;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblPaso;
    private javax.swing.JLabel lblTitulo;
    private Presentacion.Controls.MantSolicitudesWizardPaso1 mantSolicitudesWizardPaso1;
    private Presentacion.Controls.MantSolicitudesWizardPaso2 mantSolicitudesWizardPaso2;
    private Presentacion.Controls.MantSolicitudesWizardPaso3 mantSolicitudesWizardPaso3;
    private Presentacion.Controls.MantSolicitudesWizardPaso4 mantSolicitudesWizardPaso4;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
   private Presentacion.Controls.MantSolicitudesWizardPaso2Dialog mantSolicitudesWizardPaso2Dialog;
   
}
