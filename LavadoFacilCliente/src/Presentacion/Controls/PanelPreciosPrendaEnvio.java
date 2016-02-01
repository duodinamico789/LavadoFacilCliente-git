package Presentacion.Controls;
import java.util.LinkedList;
import Entidades.Objetos.Prenda;
import Entidades.Objetos.Tintoreria;
import Entidades.Objetos.PrendaEnvio;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PanelPreciosPrendaEnvio extends javax.swing.JPanel {


    public PanelPreciosPrendaEnvio() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtPantalonV = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPantalonP = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtSaco = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTraje = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTapado = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtAcolchadoP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAcolchadoW = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFrazada = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtGabanes = new javax.swing.JTextField();
        txtGabardinas = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(247, 232, 232));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(247, 232, 232), 3, true));

        jPanel1.setLayout(new java.awt.GridLayout(1, 2, 2, 2));

        jLabel9.setText("Pantalon de vestir:");

        txtPantalonV.setEnabled(false);
        txtPantalonV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPantalonVKeyTyped(evt);
            }
        });

        jLabel7.setText("Pantalon de pana:");

        txtPantalonP.setEnabled(false);
        txtPantalonP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPantalonPKeyTyped(evt);
            }
        });

        jLabel12.setText("Saco:");

        txtSaco.setEnabled(false);
        txtSaco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSacoKeyTyped(evt);
            }
        });

        jLabel10.setText("Traje:");

        txtTraje.setEnabled(false);
        txtTraje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTrajeKeyTyped(evt);
            }
        });

        jLabel11.setText("Tapado:");

        txtTapado.setEnabled(false);
        txtTapado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTapadoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTapado, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(txtTraje)
                    .addComponent(txtSaco)
                    .addComponent(txtPantalonP)
                    .addComponent(txtPantalonV))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtPantalonV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPantalonP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSaco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTraje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTapado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);

        jLabel2.setText("Acolchado de plumas:");

        txtAcolchadoP.setEnabled(false);
        txtAcolchadoP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAcolchadoPKeyTyped(evt);
            }
        });

        jLabel3.setText("Acolchado de Wata:");

        txtAcolchadoW.setEnabled(false);
        txtAcolchadoW.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAcolchadoWKeyTyped(evt);
            }
        });

        jLabel4.setText("Frazada:");

        txtFrazada.setEnabled(false);
        txtFrazada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFrazadaKeyTyped(evt);
            }
        });

        jLabel1.setText("Gabanes:");

        jLabel5.setText("Gabardinas:");

        txtGabanes.setEnabled(false);
        txtGabanes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGabanesKeyTyped(evt);
            }
        });

        txtGabardinas.setEnabled(false);
        txtGabardinas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGabardinasKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAcolchadoP, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(txtAcolchadoW)
                    .addComponent(txtFrazada)
                    .addComponent(txtGabanes)
                    .addComponent(txtGabardinas))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAcolchadoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAcolchadoW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFrazada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGabanes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGabardinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setText("Precios prendas de envío a tintorerías:");
        jLabel16.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel16)))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtGabardinasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGabardinasKeyTyped
        char num = evt.getKeyChar();
        if (num < '0' || num > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtGabardinasKeyTyped

    private void txtSacoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSacoKeyTyped
        char num = evt.getKeyChar();
        if (num < '0' || num > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtSacoKeyTyped

    private void txtAcolchadoPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAcolchadoPKeyTyped
        char num = evt.getKeyChar();
        if (num < '0' || num > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtAcolchadoPKeyTyped

    private void txtTapadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTapadoKeyTyped
        char num = evt.getKeyChar();
        if (num < '0' || num > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtTapadoKeyTyped

    private void txtFrazadaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFrazadaKeyTyped
        char num = evt.getKeyChar();
        if (num < '0' || num > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtFrazadaKeyTyped

    private void txtPantalonPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPantalonPKeyTyped
        char num = evt.getKeyChar();
        if (num < '0' || num > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtPantalonPKeyTyped

    private void txtTrajeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTrajeKeyTyped
        char num = evt.getKeyChar();
        if (num < '0' || num > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtTrajeKeyTyped

    private void txtAcolchadoWKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAcolchadoWKeyTyped
        char num = evt.getKeyChar();
        if (num < '0' || num > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtAcolchadoWKeyTyped

    private void txtGabanesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGabanesKeyTyped
        char num = evt.getKeyChar();
        if (num < '0' || num > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtGabanesKeyTyped

    private void txtPantalonVKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPantalonVKeyTyped
        char num = evt.getKeyChar();
        if (num < '0' || num > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtPantalonVKeyTyped

    public void EliminarDatos(Tintoreria tin)throws Exception{
    
        try
        {
         PrendaEnvio preE = new PrendaEnvio();  
         LinkedList<PrendaEnvio> listaPreEnvio = Logica.Clases.FabricaLogica.getInstancia().getILogicaPrenda().ListarPrendasEnvio();
          for(int i = 0; i<listaPreEnvio.size(); i++)
          {         
           preE = listaPreEnvio.get(i);
           if(preE.getIdtint().getIdTint()==tin.getIdTint())
           {
             Logica.Clases.FabricaLogica.getInstancia().getILogicaPrenda().BajaPrendasEnvio(preE.getId());
           }
          }
          
        }
        catch(Exception ex)
        {
         throw new Exception();
        }
    }
    public void ObtenerDatos(Tintoreria tin) throws Exception{
        try
        {  
          Prenda pre;
          PrendaEnvio preE;
          PrendaEnvio preE2;
          LinkedList<Prenda> listapre = Logica.Clases.FabricaLogica.getInstancia().getILogicaPrenda().ListarPrendas(true);
          LinkedList<PrendaEnvio> listaPreEnvio = new LinkedList<PrendaEnvio>();
          for(int i = 0; i<listapre.size(); i++)
          {
            pre = listapre.get(i);
            preE = new PrendaEnvio();;
            if(pre.getTipo().equals("AcolchadoPlumas")&&!txtAcolchadoP.getText().isEmpty())
            {
              Double AcolchadoP = Double.valueOf (txtAcolchadoP.getText());
              BigDecimal bd = new BigDecimal(AcolchadoP);
              preE.setIdtint(tin);
              preE.setPrecio(bd);
              preE.setIdpren(pre);
            }
            else if(pre.getTipo().equals("AcolchadoWata")&&!txtAcolchadoW.getText().isEmpty())
            {
              Double AcolchadoW = Double.valueOf(txtAcolchadoW.getText());
              BigDecimal bd = new BigDecimal(AcolchadoW);
              preE.setIdtint(tin);
              preE.setPrecio(bd);
              preE.setIdpren(pre);
            }
            else if(pre.getTipo().equals("Frazada")&&!txtFrazada.getText().isEmpty())
            {
              Double Frazada = Double.valueOf(txtFrazada.getText());
              BigDecimal bd = new BigDecimal(Frazada);
              preE.setIdtint(tin);
              preE.setPrecio(bd);
              preE.setIdpren(pre);
            }
            else if(pre.getTipo().equals("Gabanes")&&!txtGabanes.getText().isEmpty())
            {
              Double Gabanes = Double.valueOf(txtGabanes.getText());
              BigDecimal bd = new BigDecimal(Gabanes);
              preE.setIdtint(tin);
              preE.setPrecio(bd);
              preE.setIdpren(pre);
            }
            else if(pre.getTipo().equals("Gabardinas")&&!txtGabardinas.getText().isEmpty())
            {
              Double Gabardinas = Double.valueOf(txtGabardinas.getText());
              BigDecimal bd = new BigDecimal(Gabardinas);
              preE.setIdtint(tin);
              preE.setPrecio(bd);
              preE.setIdpren(pre);
            }
            else if(pre.getTipo().equals("PantalonVestir")&&!txtPantalonV.getText().isEmpty())
            {
              Double PantalonV = Double.valueOf(txtPantalonV.getText());
              BigDecimal bd = new BigDecimal(PantalonV);
              preE.setIdtint(tin);
              preE.setPrecio(bd);
              preE.setIdpren(pre);
            }
            else if(pre.getTipo().equals("PantalonPana")&&!txtPantalonP.getText().isEmpty())
            {
              Double PantalonP = Double.valueOf(txtPantalonP.getText());
              BigDecimal bd = new BigDecimal(PantalonP);
              preE.setIdtint(tin);
              preE.setPrecio(bd);
              preE.setIdpren(pre);
            }
            else if(pre.getTipo().equals("Saco")&&!txtSaco.getText().isEmpty())
            {
              Double Saco = Double.valueOf(txtSaco.getText());
              BigDecimal bd = new BigDecimal(Saco);
              preE.setIdtint(tin);
              preE.setPrecio(bd);
              preE.setIdpren(pre);
            }
            else if(pre.getTipo().equals("Traje")&&!txtTraje.getText().isEmpty())
            {
              Double Traje = Double.valueOf(txtTraje.getText());
              BigDecimal bd = new BigDecimal(Traje);
              preE.setIdtint(tin);
              preE.setPrecio(bd);
              preE.setIdpren(pre);
            }
            else if(pre.getTipo().equals("Tapado")&&!txtTapado.getText().isEmpty())
            {
              Double Tapado = Double.valueOf(txtTapado.getText());
              BigDecimal bd = new BigDecimal(Tapado);
              preE.setIdtint(tin);
              preE.setPrecio(bd);
              preE.setIdpren(pre);
            }
            if(preE.getIdpren()!=null)
            {
            listaPreEnvio.add(preE);
            }
          }
          for(int k = 0; k<listaPreEnvio.size();k++)
          {
            preE2 = listaPreEnvio.get(k);
            Logica.Clases.FabricaLogica.getInstancia().getILogicaPrenda().AltaPrendasEnvio(preE2);
          }
        }
        catch(Exception ex)
        {
         throw new Exception();
        }   
    }

    public void reinicio() {
        txtAcolchadoP.setText("");
        txtPantalonP.setText("");
        txtAcolchadoW.setText("");
        txtGabanes.setText("");
        txtTraje.setText("");
        txtFrazada.setText("");
        txtPantalonV.setText("");
        txtSaco.setText("");
        txtGabardinas.setText("");
        txtTapado.setText("");
        txtAcolchadoP.setEnabled(false);
        txtPantalonP.setEnabled(false);
        txtAcolchadoW.setEnabled(false);
        txtGabanes.setEnabled(false);
        txtTraje.setEnabled(false);
        txtFrazada.setEnabled(false);
        txtPantalonV.setEnabled(false);
        txtSaco.setEnabled(false);
        txtGabardinas.setEnabled(false);
        txtTapado.setEnabled(false);
    }

    public void ActivoParaAlta() {
        txtAcolchadoP.setEnabled(true);
        txtPantalonP.setEnabled(true);
        txtAcolchadoW.setEnabled(true);
        txtGabanes.setEnabled(true);
        txtTraje.setEnabled(true);
        txtFrazada.setEnabled(true);
        txtPantalonV.setEnabled(true);
        txtSaco.setEnabled(true);
        txtGabardinas.setEnabled(true);
        txtTapado.setEnabled(true);
    }

    public void MostrarDatos(Tintoreria t) throws Exception{

        try
        {
         LinkedList<PrendaEnvio> listaPreEnvio = new LinkedList<PrendaEnvio>();
         listaPreEnvio = Logica.Clases.FabricaLogica.getInstancia().getILogicaPrenda().ListarPrendasEnvio();
         PrendaEnvio preE = new PrendaEnvio();
         for(int k = 0;k<listaPreEnvio.size();k++)
         {
            preE = listaPreEnvio.get(k);
            if(preE.getIdtint().getIdTint() == t.getIdTint())
            {
              if(preE.getIdpren().getTipo().equals("AcolchadoPlumas"))
              {
               txtAcolchadoP.setText(String.valueOf(preE.getPrecio()));
              }
              else if(preE.getIdpren().getTipo().equals("AcolchadoWata"))
              {
               txtAcolchadoW.setText(String.valueOf(preE.getPrecio()));
              }
              else if(preE.getIdpren().getTipo().equals("Frazada"))
              {
               txtFrazada.setText(String.valueOf(preE.getPrecio()));
              }
              else if(preE.getIdpren().getTipo().equals("Gabanes"))
              {
               txtGabanes.setText(String.valueOf(preE.getPrecio()));
              }
              else if(preE.getIdpren().getTipo().equals("Gabardinas"))
              {
               txtGabardinas.setText(String.valueOf(preE.getPrecio()));
              }
              else if(preE.getIdpren().getTipo().equals("PantalonVestir"))
              {
               txtPantalonV.setText(String.valueOf(preE.getPrecio()));
              }
              else if(preE.getIdpren().getTipo().equals("PantalonPana"))
              {
               txtPantalonP.setText(String.valueOf(preE.getPrecio()));
              }
              else if(preE.getIdpren().getTipo().equals("Saco"))
              {
               txtSaco.setText(String.valueOf(preE.getPrecio()));
              }
              else if(preE.getIdpren().getTipo().equals("Traje"))
              {
               txtTraje.setText(String.valueOf(preE.getPrecio()));
              }
              else if(preE.getIdpren().getTipo().equals("Tapado"))
              {
               txtTapado.setText(String.valueOf(preE.getPrecio()));
              }
            }
         }
        }
        catch(Exception ex)
        {
         throw new Exception(ex.getMessage());
        }
        
        txtAcolchadoP.setEnabled(true);
        txtPantalonP.setEnabled(true);
        txtAcolchadoW.setEnabled(true);
        txtGabanes.setEnabled(true);
        txtTraje.setEnabled(true);
        txtFrazada.setEnabled(true);
        txtPantalonV.setEnabled(true);
        txtSaco.setEnabled(true);
        txtGabardinas.setEnabled(true);
        txtTapado.setEnabled(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtAcolchadoP;
    private javax.swing.JTextField txtAcolchadoW;
    private javax.swing.JTextField txtFrazada;
    private javax.swing.JTextField txtGabanes;
    private javax.swing.JTextField txtGabardinas;
    private javax.swing.JTextField txtPantalonP;
    private javax.swing.JTextField txtPantalonV;
    private javax.swing.JTextField txtSaco;
    private javax.swing.JTextField txtTapado;
    private javax.swing.JTextField txtTraje;
    // End of variables declaration//GEN-END:variables
}
