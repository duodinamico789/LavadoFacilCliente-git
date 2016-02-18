
package Presentacion.Controls;
import Entidades.Objetos.Ubicacion;
import java.awt.Color;
import javax.swing.JOptionPane;
public class PanelUbicacion extends javax.swing.JPanel {
    private Ubicacion ubic;
    public PanelUbicacion() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jPanelCont = new javax.swing.JPanel();
        lbldireccion = new javax.swing.JLabel();
        lblbarrio = new javax.swing.JLabel();
        lblciudad = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtBarrio = new javax.swing.JTextField();
        txtCiudad = new javax.swing.JTextField();

        setBackground(new java.awt.Color(232, 247, 237));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(232, 247, 237), 3, true));
        setMinimumSize(new java.awt.Dimension(305, 156));

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTitulo.setText("Ubicación:");
        lblTitulo.setToolTipText("");

        lbldireccion.setText("Direccion:");

        lblbarrio.setText("Barrio:");

        lblciudad.setText("Ciudad:");

        txtDireccion.setEnabled(false);
        txtDireccion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDireccionFocusLost(evt);
            }
        });

        txtBarrio.setEnabled(false);

        txtCiudad.setEnabled(false);

        javax.swing.GroupLayout jPanelContLayout = new javax.swing.GroupLayout(jPanelCont);
        jPanelCont.setLayout(jPanelContLayout);
        jPanelContLayout.setHorizontalGroup(
            jPanelContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbldireccion)
                    .addComponent(lblbarrio)
                    .addComponent(lblciudad))
                .addGap(18, 18, 18)
                .addGroup(jPanelContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtCiudad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                        .addComponent(txtBarrio, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(160, Short.MAX_VALUE))
        );
        jPanelContLayout.setVerticalGroup(
            jPanelContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbldireccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBarrio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblbarrio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblciudad))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCont, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelCont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtDireccionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDireccionFocusLost
       try
       {
         if(!"".equals(txtDireccion.getText()))
         {
           ubic = Logica.Clases.FabricaLogica.getInstancia().getILogicaUbicacion().BuscarUbicacion(txtDireccion.getText());
           if(ubic !=null)
           {
            txtBarrio.setText(ubic.getBarrio());
            txtCiudad.setText(ubic.getCiudad());
           }
         }
       }
       catch(Exception ex)
       {
         JOptionPane.showMessageDialog(null, ex.getMessage());
       
       }
    }//GEN-LAST:event_txtDireccionFocusLost
    
    public void ModoDefault()
    {
     txtBarrio.setText("");
     txtCiudad.setText("");
     txtDireccion.setText("");
     txtBarrio.setEnabled(false);
     txtCiudad.setEnabled(false);
     txtDireccion.setEnabled(false);
    }
    
    public void HabilitarTextboxs(boolean habilitar)
    {
     txtBarrio.setEnabled(habilitar);
     txtCiudad.setEnabled(habilitar);
     txtDireccion.setEnabled(habilitar);
    }
    public void MostrarDatos(Ubicacion ub)
    {
      HabilitarTextboxs(true);
      txtBarrio.setText(ub.getBarrio());
      txtCiudad.setText(ub.getCiudad());
      txtDireccion.setText(ub.getDireccion());
    }
    public void ActivoParaAlta()
    {
     HabilitarTextboxs(true);
    }
    
    public Ubicacion AltaUbicacion()
    {
       try
       {
         ubic = new Ubicacion();  
         if("".equals(txtDireccion.getText())|| "".equals(txtBarrio.getText())|| "".equals(txtCiudad.getText()))
         {
           throw new Exception("Los campos de ubicacion son obligatorios");
         }
         
         ubic.setDireccion(txtDireccion.getText());
         ubic.setBarrio(txtBarrio.getText());
         ubic.setCiudad(txtCiudad.getText());
         
         Logica.Clases.FabricaLogica.getInstancia().getILogicaUbicacion().AltaUbicacion(ubic);
       }
       catch(Exception es) 
       {
           ubic =null;
           JOptionPane.showMessageDialog(null, es.getMessage());
       }
       return ubic;
    }
    public Ubicacion ModificarUbicacion()
    {
      try
      {
          if("".equals(txtDireccion.getText())|| "".equals(txtBarrio.getText())|| "".equals(txtCiudad.getText()))
         {
           throw new Exception("Los campos de ubicacion son obligatorios");
         }
         
         ubic = new Ubicacion();   
         ubic = BuscarUbicacion(txtDireccion.getText());
         if(ubic == null)
         {
           ubic = AltaUbicacion();
         }
         else
         {
         ubic.setBarrio(txtBarrio.getText());
         ubic.setCiudad(txtCiudad.getText());
         Logica.Clases.FabricaLogica.getInstancia().getILogicaUbicacion().ModificarUbicacion(ubic);
         }
      }
      catch(Exception ex)
      {
       JOptionPane.showMessageDialog(null, ex.getMessage());
      }
      return ubic;
    }

    public Ubicacion BuscarUbicacion(String Direccion) throws Exception
    {
     Ubicacion ubica;
     ubica = Logica.Clases.FabricaLogica.getInstancia().getILogicaUbicacion().BuscarUbicacion(Direccion);
     return ubica; 
    }
     
    //Metodos que se utilizaran desde MantSolicitudes
    public void SetearEstilos() {
        txtBarrio.setEditable(false);
        txtBarrio.setEnabled(true);
        txtBarrio.setBackground(new Color(204,255,204));
        txtCiudad.setEditable(false);
        txtCiudad.setEnabled(true);
        txtCiudad.setBackground(new Color(204,255,204));
        txtDireccion.setEditable(false);
        txtDireccion.setEnabled(true);
        txtDireccion.setBackground(new Color(204,255,204));
    }
    public void RevertirEstilos() {
        txtBarrio.setEditable(true);
        txtBarrio.setBackground(new Color(240,240,240));
        txtCiudad.setEditable(true);
        txtCiudad.setBackground(new Color(240,240,240));
        txtDireccion.setEditable(true);
        txtDireccion.setBackground(new Color(240,240,240));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelCont;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblbarrio;
    private javax.swing.JLabel lblciudad;
    private javax.swing.JLabel lbldireccion;
    private javax.swing.JTextField txtBarrio;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtDireccion;
    // End of variables declaration//GEN-END:variables
}
