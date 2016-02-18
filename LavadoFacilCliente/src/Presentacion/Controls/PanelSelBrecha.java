
package Presentacion.Controls;

import Entidades.Objetos.BrechaHoraria;
import Presentacion.Interfaces.OkPressedListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class PanelSelBrecha extends javax.swing.JPanel implements OkPressedListener  {

    private final String firstValueBrechasCbo = "[Seleccione brecha horaria]";
    private LinkedList<BrechaHoraria> dataSourceBrechas;
    private SelectDateDialog dialogCalendar;
    private Calendar fechaDisplay;
    private String defaultValueTextbox;
    int largo = 0;
    public PanelSelBrecha() {
        initComponents();
        this.defaultValueTextbox = "[SELECCIONE]";
        dialogCalendar = new SelectDateDialog();
        cbBrechas.setVisible(false);
        lblbrecha.setVisible(false);
    }
        public Calendar getFecha() {
        return fechaDisplay;
    }   
    public void setdelivery(boolean delivery)
    {
        if (delivery == true) {
            cbDelivery.setSelected(true);
            cbBrechas.setVisible(true);
        }else{
            cbDelivery.setSelected(false);
            cbBrechas.setVisible(false);
        }
    }
    public boolean IsEmpty() {
        return fechaDisplay == null;
    }

    public void setFecha(Calendar fecha) throws Exception {
        if(fecha != null) {
            fechaDisplay = fecha;
            String value = new java.text.SimpleDateFormat("yyyy-MM-dd").format(fechaDisplay.getTime());  
            txtFecha.setText(value);
            int diasel = fecha.getTime().getDay();
            CargarListaComboboxBrechas(true, diasel);
        } else {
            fechaDisplay = null;
            txtFecha.setText(defaultValueTextbox);
        }      
    }
    
    public void Reset() {
        fechaDisplay = null;
        dialogCalendar = null;
        txtFecha.setText(defaultValueTextbox);
    }
    
    @Override
    public void OkPressedListener_Event(Calendar fechaSeleccionada) {
        try {
            setFecha(fechaSeleccionada);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    
    private void MostrarFrame() {
        if (dialogCalendar == null)
           dialogCalendar = new SelectDateDialog();
        
        if(dialogCalendar.getListenersCount() == 0)
            dialogCalendar.addOkPressedListener(this);
        
        dialogCalendar.setLocationRelativeTo(null);
        
        if(fechaDisplay != null)
            dialogCalendar.setCalendarControl(fechaDisplay.getTime());
        
        //Mostrarjframe en un jdialog
        dialogCalendar.setModal(true);
        //dialogCalendar.setAlwaysOnTop(true);
        dialogCalendar.setVisible(true);
    }
    public BrechaHoraria getBrechaHoraria() throws Exception {
        if(getIsDelivery()) {
            BrechaHoraria bhFinal = null;
            String inicio = "";
            String fin = "";
            String brechaSelec = (String) cbBrechas.getSelectedItem();
            if(brechaSelec.equals("[Seleccione brecha horaria]"))
            {
              throw new Exception("Debe seleccionar una brecha horaria si desea delivery");
            }
            List<String> array = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(brechaSelec,"-", false);
            while (st.hasMoreTokens()) 
            {     
               array.add(st.nextToken());
            }

             inicio = array.get(0);
             fin = array.get(1);
            for (BrechaHoraria bh : dataSourceBrechas)
            {
              if(bh.getHoraInicioStr().equals(inicio)&&bh.getHoraFinStr().equals(fin))
              {
                bhFinal = bh;  
                break;
              }
            }
            return bhFinal;
        } else {
            return null;
        }
    }
    public boolean getIsDelivery()throws Exception {
        return cbDelivery.isSelected();
    }
    public void CargarListaComboboxBrechas(boolean recargarDataSource, int diasel) throws Exception {      
        if(diasel ==0){
            vaciarComboBrecha();
        }
        else
        {
            if(recargarDataSource) {
                dataSourceBrechas = Logica.Clases.FabricaLogica.getInstancia().getILogicaBrechasHorarias().ListarBrechasHorarias();
            }       
            int haybrechas = dataSourceBrechas.size();
            if(getIsDelivery() && haybrechas ==0 )
            {
             throw new Exception("NO existen brechas horarias");
            }
            List<String> array = new ArrayList<>();
            array.add(firstValueBrechasCbo);
            for(BrechaHoraria bh : dataSourceBrechas) {
                if(bh.getNoDisponible() == false)
                {
                List<String> dias = new ArrayList<>();
                StringTokenizer st = new StringTokenizer(bh.getDiasVigencia(),",", false);
                while (st.hasMoreTokens()) 
                {     
                 dias.add(st.nextToken());
                }           
                String dia = PasarDia(diasel);
                for(int j = 0; j < dias.size(); j++)
                {
                 if(dias.get(j).equals(dia))
                 {
                  String horarios = bh.getHoraInicioStr() + "-" + bh.getHoraFinStr();
                  array.add(horarios);
                 }
                }
               }
            }
            largo = array.size();
            cbBrechas.setModel(new DefaultComboBoxModel(array.toArray()));
            if(getIsDelivery()&& largo == 1)
            {
              throw new Exception("NO existe brecha horaria para el dia seleccionado");
            }
        }
    }
    public void vaciarComboBrecha()
    {
     for(int i=cbBrechas.getItemCount()-1;i>=0;i--){
       cbBrechas.removeItemAt(i);
     }
    }
    
   private String PasarDia(int dia)
    {
     String d = "";
     if(dia == 1)
     {
      d = "Lunes";
     }
     else if(dia == 2)
     {
      d = "Martes";
     }
     else if(dia == 3)
     {
      d = "Miercoles";
     }
     else if(dia == 4)
     {
      d = "Jueves";
     }
     else if(dia == 5)
     {
      d = "Viernes";
     }
     else if(dia == 6)
     {
      d = "Sábado";
     }
     else
     {
      d = "Domingo";
     }
     return d;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpDelivery = new javax.swing.JPanel();
        cbDelivery = new javax.swing.JCheckBox();
        lblbrecha = new javax.swing.JLabel();
        cbBrechas = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        txtFecha = new javax.swing.JTextField();
        btnSelect = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        cbDelivery.setText("Incluir delivery");
        cbDelivery.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbDeliveryItemStateChanged(evt);
            }
        });

        lblbrecha.setText("Brecha horaria:");

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setMaximumSize(new java.awt.Dimension(160, 20));
        jPanel1.setName(""); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtFecha.setEditable(false);
        txtFecha.setBackground(new java.awt.Color(255, 255, 255));
        txtFecha.setText("[SELECCIONE]");
        txtFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFechaMouseClicked(evt);
            }
        });

        btnSelect.setBackground(new java.awt.Color(255, 255, 255));
        btnSelect.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnSelect.setText("...");
        btnSelect.setToolTipText("");
        btnSelect.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSelect.setContentAreaFilled(false);
        btnSelect.setMaximumSize(new java.awt.Dimension(20, 30));
        btnSelect.setMinimumSize(new java.awt.Dimension(20, 30));
        btnSelect.setPreferredSize(new java.awt.Dimension(20, 30));
        btnSelect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSelectMouseClicked(evt);
            }
        });

        jLabel2.setText("Fecha De Entrega:");

        javax.swing.GroupLayout jpDeliveryLayout = new javax.swing.GroupLayout(jpDelivery);
        jpDelivery.setLayout(jpDeliveryLayout);
        jpDeliveryLayout.setHorizontalGroup(
            jpDeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDeliveryLayout.createSequentialGroup()
                .addGroup(jpDeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDeliveryLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpDeliveryLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(cbDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblbrecha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(cbBrechas, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jpDeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpDeliveryLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jpDeliveryLayout.setVerticalGroup(
            jpDeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDeliveryLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jpDeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpDeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jpDeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbDelivery)
                    .addComponent(lblbrecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbBrechas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(jpDeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpDeliveryLayout.createSequentialGroup()
                    .addGap(0, 40, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 54, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpDelivery, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpDelivery, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbDeliveryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbDeliveryItemStateChanged
        //Habilitar panel para seleccionar brecha
        cbBrechas.setVisible(cbDelivery.isSelected());
        try {
            if(getIsDelivery()&& largo == 1)
            {
                throw new Exception("NO existe brecha horaria para el dia seleccionado");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_cbDeliveryItemStateChanged

    private void btnSelectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSelectMouseClicked
        try {
            MostrarFrame();
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnSelectMouseClicked

    private void txtFechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFechaMouseClicked
        try {
            MostrarFrame();
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_txtFechaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelect;
    private javax.swing.JComboBox cbBrechas;
    private javax.swing.JCheckBox cbDelivery;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jpDelivery;
    private javax.swing.JLabel lblbrecha;
    private javax.swing.JTextField txtFecha;
    // End of variables declaration//GEN-END:variables
}
