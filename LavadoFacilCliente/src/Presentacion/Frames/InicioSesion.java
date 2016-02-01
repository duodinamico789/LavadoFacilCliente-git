package Presentacion.Frames;

import Entidades.Objetos.Empleado;
import Entidades.Objetos.Cliente;
import Entidades.Objetos.Persona;
import javax.swing.JOptionPane;

public class InicioSesion extends javax.swing.JFrame {

    Persona e = null;

    public InicioSesion() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitInicio = new javax.swing.JLabel();
        lblusuario = new javax.swing.JLabel();
        lblpass = new javax.swing.JLabel();
        txtcedula = new javax.swing.JTextField();
        btnEntrar = new javax.swing.JButton();
        lblerror = new javax.swing.JLabel();
        txtpass = new javax.swing.JPasswordField();
        lblTitInicio1 = new javax.swing.JLabel();
        btnOlvidoPass = new javax.swing.JButton();
        btnPrimeraVez = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 304));

        lblTitInicio.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTitInicio.setText("Inicio de Sesion:");

        lblusuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblusuario.setText("Cedula:");

        lblpass.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblpass.setText("Contraseña:");

        txtcedula.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtcedula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtcedulaFocusGained(evt);
            }
        });
        txtcedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcedulaKeyTyped(evt);
            }
        });

        btnEntrar.setText("Ingresar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        txtpass.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblTitInicio1.setBackground(java.awt.Color.white);
        lblTitInicio1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTitInicio1.setForeground(new java.awt.Color(0, 51, 102));
        lblTitInicio1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitInicio1.setText("Lavadero App");

        btnOlvidoPass.setText("Olvido la contraseña?");
        btnOlvidoPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOlvidoPassMouseClicked(evt);
            }
        });

        btnPrimeraVez.setText("Es la primera vez que iniciará sesión?");
        btnPrimeraVez.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrimeraVezMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitInicio1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitInicio)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblerror)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPrimeraVez)
                            .addComponent(btnOlvidoPass)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnEntrar)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblpass)
                                .addComponent(lblusuario))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtpass)
                                .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitInicio1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTitInicio)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblusuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblpass)
                    .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEntrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblerror, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnOlvidoPass)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrimeraVez)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        try {
            if ("".equals(txtcedula.getText())) {
                throw new Exception("Debe ingresar la cedula");
            }
            String ced = txtcedula.getText();
            e = Logica.Clases.FabricaLogica.getInstancia().getILogicaPersonas().BuscarPersona(ced);

            if(e instanceof Cliente)
            {
              throw new Exception("Cedula perteneciente a un cliente");
            }
            if (e.getPassw().equals("usuario1")) {
                CambioDePass _form = new CambioDePass((Empleado) e);
                _form.setVisible(true);
                this.setVisible(false);
            } else {
                if ("".equals(txtpass.getText())) {
                    throw new Exception("Debe ingresar el password");
                }
                String pass = txtpass.getText().toLowerCase();
                e = Logica.Clases.FabricaLogica.getInstancia().getILogicaPersonas().LoginEmpleado(ced, pass);
                if (e.getCedula() != null) {
                    VentanaPrincipal _form = new VentanaPrincipal((Empleado) e);
                    _form.setVisible(true);
                    this.setVisible(false);
                } else {
                    throw new Exception("Cedula o contraseña incorrecta");
                }
            }
        } catch (Exception ex) {
            lblerror.setText(ex.getMessage());
        }
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void txtcedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaKeyTyped
        char num = evt.getKeyChar();
        if (num < '0' || num > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtcedulaKeyTyped

    private void txtcedulaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcedulaFocusGained
        lblerror.setText("");
    }//GEN-LAST:event_txtcedulaFocusGained

    private void btnOlvidoPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOlvidoPassMouseClicked
        try {
            OlvidoContraseña _form = new OlvidoContraseña();
            _form.setVisible(true);
        } catch (Exception es) {
            JOptionPane.showMessageDialog(null, es.getMessage());
        }
    }//GEN-LAST:event_btnOlvidoPassMouseClicked

    private void btnPrimeraVezMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrimeraVezMouseClicked
        try {
            if ("".equals(txtcedula.getText())) {
                throw new Exception("Debe ingresar la cedula");
            } else {
                e = Logica.Clases.FabricaLogica.getInstancia().getILogicaPersonas().BuscarPersona(txtcedula.getText());
                if(e instanceof Cliente)
                {
                 throw new Exception("Cedula perteneciente a un cliente");
                }
                if (e.getPassw().equals("usuario1")) {
                    CambioDePass _form = new CambioDePass((Empleado) e);
                    _form.setVisible(true);
                    this.setVisible(false);
                } else {
                    throw new Exception("No es su primer inicio de sesion");
                }
            }
        } catch (Exception ex) {
            lblerror.setText(ex.getMessage());
        }
    }//GEN-LAST:event_btnPrimeraVezMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnOlvidoPass;
    private javax.swing.JButton btnPrimeraVez;
    private javax.swing.JLabel lblTitInicio;
    private javax.swing.JLabel lblTitInicio1;
    private javax.swing.JLabel lblerror;
    private javax.swing.JLabel lblpass;
    private javax.swing.JLabel lblusuario;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JPasswordField txtpass;
    // End of variables declaration//GEN-END:variables
}
