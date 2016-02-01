package Presentacion.Controls;

import Entidades.Constantes;
import Entidades.Objetos.Excepcion;
import Entidades.Objetos.Opcion;
import Entidades.Objetos.Prenda;
import Entidades.Objetos.Solicitud;
import Entidades.Objetos.SolicitudDetalle;
import Presentacion.Interfaces.ParentFrameSolicAdapter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MantSolicitudesWizardPaso4 extends javax.swing.JPanel {
    private Solicitud sol;
    
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
    
    public MantSolicitudesWizardPaso4() {
        initComponents();
    }

    public void ProcesarPrimerCargado(Solicitud solicitud) throws Exception {
        sol = solicitud;
        CargarResumen();
    }
    
    private void CargarResumen() {        String e = "\n";
        StringBuilder sb = new StringBuilder();
        sb.append(" - - - Confirmación de datos: - - - ")
            .append(e)
            .append(" - - Cliente:")
            .append(e)
            .append("  Cedula: ")
            .append(sol.getCedulaCli().getCedula())
            .append(e)
            .append("  Nombre y apellido: ")
            .append(sol.getCedulaCli().getNombre())
            .append(e)
            .append("  Teléfono: ")
            .append(sol.getCedulaCli().getTelefono())
            .append(e)
            .append("  Celular: ")
            .append(sol.getCedulaCli().getCelular())
            .append(e)
            .append(" - - Prendas: ")
            .append(e);
       
        BigDecimal precio = new BigDecimal(0);        
        for(Prenda p : sol.getPrendas()) {
            BigDecimal pp = new BigDecimal(0);    
            sb.append("  Tipo prenda: ")
            .append(p.getTipo())
            .append("  Aplica envío a tintorería: ");
            
            String valor = (p.getTintoreria()) ? "Sí" : "No";
            if(valor.equals("Sí"))
            {
             for(SolicitudDetalle sd : sol.getDetalles())
             {
               if(sd.getPrenda().getIdpda() == p.getIdpda())
               {
                 precio = precio.add(sd.getPrecio());
                 pp = pp.add(sd.getPrecio());
                 break;
               }
             }
            }
            else{
            pp = new BigDecimal(0);
            }
            sb.append(valor)
            .append("  Precio: $ ")
            .append(pp)
            .append("  Excepciones: ");
            valor = (p.getExcepcionesList() == null || p.getExcepcionesList().size() == 0) 
                    ? "Ninguna" : ObtenerExcepcionesStr(p.getExcepcionesList());
            sb.append(e);
        }
        
        sb.append(e)
            .append(" - - Empleado:")
            .append(e)
            .append("  Cedula: ")   
            .append(sol.getCedulaEmp().getCedula())
            .append(e)
            .append("  Sucursal: ")  
            .append(sol.getNomSucursal().getNombreSuc())
            .append(e)
            .append("  Observaciones: ")  
            .append(sol.getObservaciones())
            .append(e)
            .append(" - - Opciones: ")
                .append(e);
        
        
        for(Opcion op : sol.getOpcionesList()) {
            sb.append("  Nom. Opción: ")
            .append(op.getNombre() + ", $ " + op.getPrecio())
            .append(e);
            precio = precio.add(op.getPrecio());
        }
        
        if(sol.getBrechaHoraria() != null) {
            sb.append(" - - Entrega:")
                .append("Desde: " + sol.getBrechaHoraria().getHoraInicioStr()+ "Hasta: " + sol.getBrechaHoraria().getHoraFinStr()
                    + "del dia: " + (new java.text.SimpleDateFormat("yyyy-MM-dd").format(sol.getFechaEntrega())))
                 .append(e);
        }
        sb.append(" - - Precio Total: $ ")
                .append(precio);
        
        jepConfirm.setText(sb.toString());
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jspConfirm = new javax.swing.JScrollPane();
        jepConfirm = new javax.swing.JEditorPane();
        btnConfirmar = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(567, 476));

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTitulo.setText("Confirme datos:");

        jepConfirm.setEditable(false);
        jspConfirm.setViewportView(jepConfirm);

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        lblError.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jspConfirm)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 357, Short.MAX_VALUE)
                        .addComponent(btnConfirmar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblError)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo)
                    .addComponent(btnConfirmar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jspConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblError)
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        try
        {
          Logica.Clases.FabricaLogica.getInstancia().getILogicaSolicitud().AltaSolicitud(sol);
        }
        catch(Exception ex)
        {
          lblError.setText(ex.getMessage());
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JEditorPane jepConfirm;
    private javax.swing.JScrollPane jspConfirm;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables

    

    
}