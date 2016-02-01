package Presentacion.Controls;

import Entidades.Objetos.Prenda;
import Entidades.Objetos.PrendaEnvio;
import Presentacion.Interfaces.NotificarResultListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

public class MantSolicitudesWizardpaso2Dialog2 extends javax.swing.JDialog {

    LinkedList<PrendaEnvio>ListaPE;
    public MantSolicitudesWizardpaso2Dialog2(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }  
    private final List<NotificarResultListener> listeners = new ArrayList<>();
    
    public void addNotificarResultListener(NotificarResultListener toAdd) {
        listeners.add(toAdd);
    }   
    // An interface to be implemented by everyone interested in events
    public void NotificarResultEvent(Object resultado) {
        // Notify everybody that may be interested.
        for (NotificarResultListener hl : listeners)
            hl.NotificarResult_Event(resultado);    
    }
   
    public void nombreprenda(String nom)
    {
     lblNomPren.setText(nom);
    }
    public int llenarTabla(Prenda p)
    {
      int result = 0;
      try
      {   
          ListaPE = Logica.Clases.FabricaLogica.getInstancia().getILogicaPrenda().ListarPrendasEnvioXIdPren(p.getIdpda());
          if (ListaPE.isEmpty()) {
             result = -1;           
          }
          else
          {
            SetearTabla(ListaPE);
            result = 1;
          }      
      }
      catch(Exception ex)
      {
        JOptionPane.showMessageDialog(null, ex.getMessage());
      }
      return result;
    }
     public void SetearTabla(LinkedList<PrendaEnvio> preE) {
        try {
            if(preE == null || preE.size() == 0) {
                //cargo tabla vacia
                jTablePrendaEnvio.setModel(
                    new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                        },
                        new String [] {
                            "Nombre Tintoreria", "Precio"
                        }
                    ));
            }
            else {
                //cargo tabla con datos
                String [][] datos = new String[preE.size()][3];
                for(int i = 0; i<preE.size(); i++) {
                    datos[i][0] = preE.get(i).getIdtint().getNombre();
                    datos[i][1] = preE.get(i).getPrecio().toString();;
                }               
                jTablePrendaEnvio.setModel(
                    new javax.swing.table.DefaultTableModel(
                            datos,
                        new String [] {
                             "Nombre Tintoreria", "Precio"
                        }
                    )
                {
                    //Para que no pueda ser editado
                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return false;
                    }
                });
            }
        } catch(Exception es) {
            JOptionPane.showMessageDialog(null,es.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNomPren = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePrendaEnvio = new javax.swing.JTable();
        btnSeleccionar = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNomPren.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblNomPren.setText("NombreDePrenda");

        jTablePrendaEnvio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTablePrendaEnvio);

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        lblError.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNomPren)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSeleccionar))
                    .addComponent(lblError))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNomPren)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSeleccionar)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(lblError)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
    try {
        int filaseleccionada = jTablePrendaEnvio.getSelectedRow();
        if(filaseleccionada >=0)
        {
          PrendaEnvio PE = ListaPE.get(filaseleccionada); 
          NotificarResultEvent(PE);
          this.dispose();
        }
        else
        {
          throw new Exception("Debe seleccionar una tintoreria");
        }
        
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null,ex.getMessage());
    }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

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
            java.util.logging.Logger.getLogger(MantSolicitudesWizardpaso2Dialog2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantSolicitudesWizardpaso2Dialog2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantSolicitudesWizardpaso2Dialog2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantSolicitudesWizardpaso2Dialog2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MantSolicitudesWizardpaso2Dialog2 dialog = new MantSolicitudesWizardpaso2Dialog2(new javax.swing.JDialog(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePrendaEnvio;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblNomPren;
    // End of variables declaration//GEN-END:variables
}
