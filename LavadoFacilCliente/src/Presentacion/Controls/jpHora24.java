package Presentacion.Controls;

import Entidades.Utilidades;

public class jpHora24 extends javax.swing.JPanel {

    public jpHora24() {
        initComponents();
    }

    public void Setear(int hora, int min) throws Exception {
        if(hora > 23 || hora < 0) {
            throw new Exception("hora incorrecta");
        }
        if(min > 59 || min < 0) {
            throw new Exception("hora incorrecta");
        }
        //seteo
        if(hora < 10)
            txtHora.setText("0" + String.valueOf(hora));
        else
            txtHora.setText(String.valueOf(hora));
        if(min < 10)
            txtMin.setText("0" + String.valueOf(min));
        else
            txtMin.setText(String.valueOf(min));
    }
    public void Vaciar() {
        txtHora.setText("");
        txtMin.setText("");
    }
    //gets
    public int getHora() {
        return Integer.parseInt(txtHora.getText());
    }
    public int getMins() {
        return Integer.parseInt(txtMin.getText());
    }
    
    public String GetHoraString() {
        return txtHora.getText() + ":" + txtMin.getText();
    }
        
    public boolean TieneValorVacio() {
        return (Utilidades.IsNullOrEmpty(txtHora.getText()) || Utilidades.IsNullOrEmpty(txtMin.getText()));
    }
    
    //Eventos y codigo generado
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtHora = new javax.swing.JTextField();
        txtMin = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        txtHora.setMinimumSize(new java.awt.Dimension(30, 25));
        txtHora.setPreferredSize(new java.awt.Dimension(30, 25));
        txtHora.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtHoraFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtHoraFocusLost(evt);
            }
        });
        txtHora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHoraKeyTyped(evt);
            }
        });

        txtMin.setMinimumSize(new java.awt.Dimension(30, 25));
        txtMin.setPreferredSize(new java.awt.Dimension(30, 25));
        txtMin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMinFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMinFocusLost(evt);
            }
        });
        txtMin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMinKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText(":");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(txtMin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    private void txtHoraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoraKeyTyped
        char num = evt.getKeyChar();
        if(num < '0' || num > '9') {
            evt.consume();
        }
        if(txtHora.getText().length() > 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txtHoraKeyTyped
    private void txtMinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMinKeyTyped
        char num = evt.getKeyChar();
        if(num < '0' || num > '9') {
            evt.consume();
        }
        if(txtMin.getText().length() > 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txtMinKeyTyped
    private void txtHoraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHoraFocusLost
        if(txtHora.getText().isEmpty()) {
            txtHora.setText("00");
        } else {
            int hra = Integer.parseInt(txtHora.getText());
            if(hra > 23) {
                txtHora.setText("23");
            }
        }
    }//GEN-LAST:event_txtHoraFocusLost
    private void txtMinFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMinFocusLost
        if(txtMin.getText().isEmpty()) {
            txtMin.setText("00");
        } else {
            int min = Integer.parseInt(txtMin.getText());
            if(min > 59) {
                txtMin.setText("59");
            }
        }
    }//GEN-LAST:event_txtMinFocusLost
    private void txtHoraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHoraFocusGained
        txtHora.setText("");
    }//GEN-LAST:event_txtHoraFocusGained
    private void txtMinFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMinFocusGained
        txtMin.setText("");
    }//GEN-LAST:event_txtMinFocusGained
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtMin;
    // End of variables declaration//GEN-END:variables
}
