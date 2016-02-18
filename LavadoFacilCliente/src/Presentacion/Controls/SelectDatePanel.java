package Presentacion.Controls;

import Presentacion.Interfaces.OkPressedListener;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class SelectDatePanel extends javax.swing.JPanel implements OkPressedListener {
    private SelectDateDialog dialogCalendar;
    private Calendar fechaDisplay;
    private String defaultValueTextbox;
    
    public SelectDatePanel() { 
        initComponents();   
        
        this.defaultValueTextbox = "[SELECCIONE]";
        dialogCalendar = new SelectDateDialog();        
    }
    
    public Calendar getFecha() {
        return fechaDisplay;
    }   
    public boolean IsEmpty() {
        return fechaDisplay == null;
    }
    
    public void setFecha(Calendar fecha) {
        if(fecha != null) {
            fechaDisplay = fecha;
            String value = new java.text.SimpleDateFormat("yyyy-MM-dd").format(fechaDisplay.getTime());  
            txtFecha.setText(value);
//            int diasel = fecha.getTime().getDay();
//            PanelSelBrecha pan;
//            pan = new PanelSelBrecha();
//            pan.CargarListaComboboxBrechas(true, diasel);
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSelect = new javax.swing.JButton();
        txtFecha = new javax.swing.JTextField();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(160, 20));
        setMinimumSize(new java.awt.Dimension(160, 20));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(160, 20));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        add(btnSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, -1, 20));

        txtFecha.setEditable(false);
        txtFecha.setBackground(new java.awt.Color(255, 255, 255));
        txtFecha.setText("[SELECCIONE]");
        txtFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFechaMouseClicked(evt);
            }
        });
        add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 20));
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JTextField txtFecha;
    // End of variables declaration//GEN-END:variables
}
