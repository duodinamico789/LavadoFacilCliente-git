package Presentacion.Controls;

import Entidades.Constantes;
import Entidades.Objetos.Cliente;
import Entidades.Objetos.Empleado;
import Entidades.Objetos.Persona;
import Presentacion.Frames.MantClientes;
import Presentacion.Interfaces.OpenFrameListener;
import Presentacion.Interfaces.ParentFrameMethodListener;
import Presentacion.Interfaces.ParentFrameSolicAdapter;
import java.util.ArrayList;
import java.util.List;

public class MantSolicitudesWizardPaso1 extends javax.swing.JPanel {
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
    
    //<editor-fold defaultstate="collapsed" desc="OpenFrameListener">
    private final List<OpenFrameListener> ofListeners = new ArrayList<>();
    
    public void addOpenFrameListener(OpenFrameListener toAdd) {
        ofListeners.add(toAdd);
    }
    
    // An interface to be implemented by everyone interested in events
    public void OpenFrameListener_Event(String formName) {
        // Notify everybody that may be interested.
        for (OpenFrameListener hl : ofListeners)
            hl.OpenFrameListener_Event(formName);
    }
    //</editor-fold>
    
    private Persona cli;

    public Persona getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }
    
    public MantSolicitudesWizardPaso1() {
        initComponents();
    }
    
    private void MostrarCliente() {
        txtcedula.setEnabled(false);
        txtcedula.setText(cli.getCedula());
        txtnombrecli.setText(cli.getNombre());
        txttelefono.setText(cli.getTelefono());
        txtcelular.setText(cli.getCelular());
        panelUbicacion1.MostrarDatos(cli.getUbicacion());
        panelUbicacion1.SetearEstilos();
        //btnBuscarCliente.setEnabled(false);
        SetMensajeErrorEvent(Constantes.EMPTY);
    }   
    
    private void ModoDefault() {
        txtcedula.setEnabled(true);
        btnBuscarCliente.setEnabled(true);
//        txtnombrecli.setEnabled(false);
//        txttelefono.setEnabled(false);
//        txtcelular.setEnabled(false);      
        txtcedula.setText(Constantes.EMPTY);
        txtnombrecli.setText(Constantes.EMPTY);
        txttelefono.setText(Constantes.EMPTY);
        txtcelular.setText(Constantes.EMPTY);
        panelUbicacion1.ModoDefault();
        panelUbicacion1.RevertirEstilos();
        SetMensajeErrorEvent(Constantes.EMPTY);
        btnModificarCli.setEnabled(false);
        cli = null;
    }
    
    public void ProcesarPrimerCargado() {
        panelUbicacion1.SetearEstilos();
        btnModificarCli.setEnabled(false);
    }
    
    private void BuscarCliente() {
        try {  
            if ("".equals(txtcedula.getText())) {
                throw new Exception("Por favor, ingrese la cedula del cliente. ");
            } else {
                cli = (Cliente) Logica.Clases.FabricaLogica.getInstancia().getILogicaPersonas().BuscarPersona(txtcedula.getText());
            }
            if (cli instanceof Empleado || cli == null) {
                throw new Exception("El cliente no existe. ");
            } else {
                MostrarCliente();
                btnModificarCli.setEnabled(true);
            }
        } catch (Exception es) {
            cli = null;
            SetMensajeErrorEvent(es.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtcedula = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtnombrecli = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        txtcelular = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        panelUbicacion1 = new Presentacion.Controls.PanelUbicacion();
        btnModificarCli = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jSeparator = new javax.swing.JLabel();

        jLabel2.setText("Cedula del cliente:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Cliente:");

        btnBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/search-icon24x24.png"))); // NOI18N
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre del cliente:");

        txtnombrecli.setEditable(false);
        txtnombrecli.setBackground(new java.awt.Color(204, 255, 204));

        jLabel4.setText("Telefono:");

        txttelefono.setEditable(false);
        txttelefono.setBackground(new java.awt.Color(204, 255, 204));

        txtcelular.setEditable(false);
        txtcelular.setBackground(new java.awt.Color(204, 255, 204));

        jLabel6.setText("Celular:");

        panelUbicacion1.setEnabled(false);

        btnModificarCli.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificarCli.setText("Los datos no están correctos! Abrir mant. clientes");
        btnModificarCli.setEnabled(false);
        btnModificarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarCliActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Recuerde preguntarle al cliente si sus datos son correctos:");

        jLabel1.setText("En caso contrario presione el botón inferior para modificar los datos del cliente.");

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/cancel-icon24x24.png"))); // NOI18N
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
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
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8)
                    .addComponent(panelUbicacion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarCli)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtnombrecli, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txttelefono, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtcedula, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnBuscarCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnombrecli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelUbicacion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificarCli))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        if(btnBuscarCliente.isEnabled()) {
            Thread queryThread = new Thread() {
                @Override
                public void run() {
                    BuscarCliente();
                    MostrarLoadingEvent(false);
                }
            };
            MostrarLoadingEvent(true);
            queryThread.start();
        }
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnModificarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarCliActionPerformed
        if(btnModificarCli.isEnabled()) {
            Thread queryThread = new Thread() {
                @Override
                public void run() {
                    try {
                    MantClientes _form = new MantClientes();
                    _form.setVisible(true);
                    } catch (Exception ex) {
                        SetMensajeErrorEvent(ex.getMessage());
                    }
                    MostrarLoadingEvent(false);
                }
            };
            MostrarLoadingEvent(true);
            queryThread.start();
        }
    }//GEN-LAST:event_btnModificarCliActionPerformed

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        if(btnCancelar.isEnabled()) {
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
        }
    }//GEN-LAST:event_btnCancelarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnModificarCli;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jSeparator;
    private Presentacion.Controls.PanelUbicacion panelUbicacion1;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtcelular;
    private javax.swing.JTextField txtnombrecli;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables

    
}
