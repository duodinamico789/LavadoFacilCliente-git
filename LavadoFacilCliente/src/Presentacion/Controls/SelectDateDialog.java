package Presentacion.Controls;

import Presentacion.Interfaces.OkPressedListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SelectDateDialog extends javax.swing.JDialog {
    private final List<OkPressedListener> listeners = new ArrayList<>();
    
    public void addOkPressedListener(OkPressedListener toAdd) {
        listeners.add(toAdd);
    }
    
    public int getListenersCount() {
        if(listeners != null && !listeners.isEmpty())
            return listeners.size();
        return 0;
    }
    
    public SelectDateDialog() {
        initComponents();
    }
    
    public void setCalendarControl(Date fecha) {
        this.jCalendar.setDate(fecha);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSeleccione = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();
        jCalendar = new com.toedter.calendar.JCalendar();
        btnSelect = new javax.swing.JButton();
        btnSelect1 = new javax.swing.JButton();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(350, 300));
        setName(""); // NOI18N

        lblSeleccione.setText("Seleccione una fecha:");

        lblError.setForeground(new java.awt.Color(255, 0, 0));

        btnSelect.setText("OK");
        btnSelect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSelectMouseClicked(evt);
            }
        });
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });

        btnSelect1.setText("Borrar");
        btnSelect1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBorrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblSeleccione, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSelect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSelect1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblSeleccione, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelect1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSelectMouseClicked
        try {            
            lblError.setText("");
            Calendar date = jCalendar.getCalendar();
            int dia = date.get(Calendar.DAY_OF_WEEK);
            if(dia == 1)
            {
              throw new Exception("No es posible asignar dia domingo");
            }
            ejecutarAfterOkPressedEvent(date);
            this.dispose();
            
            int diasel = date.getTime().getDay();
            PanelSelBrecha pan;
            pan = new PanelSelBrecha();
            pan.CargarListaComboboxBrechas(true, diasel);
            
        } catch(Exception ex) {
            lblError.setText(ex.getMessage());
        }
    }//GEN-LAST:event_btnSelectMouseClicked

    private void btnBorrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBorrarMouseClicked
        try {
            Calendar date = jCalendar.getCalendar();
            
            //Al final notificar al PanelSelectDate
            ejecutarAfterOkPressedEvent(null);
            this.dispose();
        } catch(Exception ex) {
            lblError.setText(ex.getMessage().substring(0, 40) + "...");
        }
    }//GEN-LAST:event_btnBorrarMouseClicked

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSelectActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelect;
    private javax.swing.JButton btnSelect1;
    private com.toedter.calendar.JCalendar jCalendar;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblSeleccione;
    // End of variables declaration//GEN-END:variables

    // An interface to be implemented by everyone interested in events
    public void ejecutarAfterOkPressedEvent(Calendar fechaSeleccionada) {
        // Notify everybody that may be interested.
        for (OkPressedListener hl : listeners)
            hl.OkPressedListener_Event(fechaSeleccionada);
    }
}
