
package Presentacion.Frames;

import Entidades.Objetos.Solicitud;
import Entidades.Objetos.Sucursal;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class ListadoSolicitud extends javax.swing.JFrame {

    private LinkedList<Solicitud>listaSolAMostrar;
    private LinkedList<Solicitud> listasol;
    LinkedList<Sucursal> listasuc; 
    public ListadoSolicitud() {
        initComponents();
        try
        {
          listasol = Logica.Clases.FabricaLogica.getInstancia().getILogicaSolicitud().ListarSolicitudes();
          if(listasol.isEmpty())
          {
            throw new Exception("No hay solicitudes en el sistema");
          }
          listasuc = Logica.Clases.FabricaLogica.getInstancia().getILogicaSucursales().ListarSucursales();
          cbSucursal.setSelectedIndex(0);
          String[] sucus = new String[listasuc.size()+1];
          Sucursal suc = null;
          sucus[0]= "Todas";
          for(int i=0;i<listasuc.size();i++)
          {
           suc = listasuc.get(i);
           sucus[i+1]= suc.getNombreSuc();
          }
         cbSucursal.setModel(new DefaultComboBoxModel(sucus));
            SetearTabla(listasol);
        }
        catch(Exception ex)
        {
          lblerror.setText(ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cbSucursal = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        txtCiCli = new javax.swing.JTextField();
        btnListar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSolicitudes = new javax.swing.JTable();
        lblerror = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Listado Solicitudes:");

        jLabel2.setText("Estado:");

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todas", "En Proceso", "Finalizadas" }));

        jLabel3.setText("Sucursal:");

        cbSucursal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todas" }));

        jLabel4.setText("Por CI cliente:");

        txtCiCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCiCliKeyTyped(evt);
            }
        });

        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        jTableSolicitudes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableSolicitudes);

        lblerror.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblerror.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCiCli, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnListar))
                            .addComponent(lblerror))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cbSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtCiCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(lblerror)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCiCliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCiCliKeyTyped
        char num = evt.getKeyChar();
        if (num < '0' || num > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtCiCliKeyTyped

    public void SetearTabla(LinkedList<Solicitud> listasolicitudes) {
        try {
            if(listasolicitudes == null || listasolicitudes.size() == 0) {
                //cargo tabla vacia
                jTableSolicitudes.setModel(
                    new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            
                        },
                        new String [] {
                            "Fecha Ingreso", "Fecha Entrega", "Cliente", "Empleado", "Sucursal", "Estado"
                        }
                    )
                );
            }
            else {
                //cargo tabla con datos
                String [][] datos = new String[listasolicitudes.size()][6];
                for(int i = 0; i<listasolicitudes.size(); i++) {
                   
                    datos[i][0] = listasolicitudes.get(i).getFechaIngreso().toString();
                    datos[i][1] = listasolicitudes.get(i).getFechaEntrega().toString();
                    datos[i][2] = listasolicitudes.get(i).getCedulaCli().getNombre();
                    datos[i][3] = listasolicitudes.get(i).getCedulaEmp().getNombre();
                    datos[i][4] = listasolicitudes.get(i).getEstado().toString();
                    datos[i][5] = listasolicitudes.get(i).getNomSucursal().getNombreSuc();
                }               
                jTableSolicitudes.setModel(
                    new javax.swing.table.DefaultTableModel(
                            datos,
                        new String [] {
                             "Fecha Ingreso", "Fecha Entrega", "Cliente", "Empleado", "Estado", "Sucursal"
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
    
    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        try
        {
            listaSolAMostrar= new LinkedList<Solicitud>();
            if(cbSucursal.getSelectedIndex()==0 && cbEstado.getSelectedIndex()==0)
            {
                listaSolAMostrar=listasol;
            }
            else if(cbEstado.getSelectedIndex()!=0&& cbSucursal.getSelectedIndex()==0)
            {
                String estado = cbEstado.getSelectedItem().toString();
                if(estado.equals("En Proceso"))
                {
                  estado = "En_Proceso";
                }
                for(int k=0; k<listasol.size(); k++)
                {
                    if(listasol.get(k).getEstado().toString().equals(estado))
                    {
                        listaSolAMostrar.add(listasol.get(k));
                    }
                }
            }
            else if(cbEstado.getSelectedIndex()==0&& cbSucursal.getSelectedIndex()!=0)
            {
                String s = cbSucursal.getSelectedItem().toString();
                for(int i=0; i < listasol.size();i++)
                {
                    if(listasol.get(i).getNomSucursal().getNombreSuc().equals(s))
                    {
                        listaSolAMostrar.add(listasol.get(i));
                    }
                }
            }
            else
            {
                String s = cbSucursal.getSelectedItem().toString();
                String estado = cbEstado.getSelectedItem().toString();
                for(int i=0; i < listasol.size();i++)
                {
                    Sucursal su = listasuc.get(i);
                    if(listasol.get(i).getNomSucursal().getNombreSuc().equals(s))
                    {
                        for(int j=0; i< listasol.size(); j++)
                        {
                            Solicitud so = listasol.get(i);
                            if(so.getEstado().toString().equals(estado))
                            {
                                listaSolAMostrar.add(so);
                            }
                        }
                    }
                }
            }
            //ARREGLAR ESTO
            if(!"".equals(txtCiCli.getText()))
            {
                LinkedList<Solicitud>listaAux = listaSolAMostrar;
                for(Solicitud soli : listaAux)
                {
                    if(soli.getCedulaCli().getCedula() != txtCiCli.getText())
                    {
                        listaSolAMostrar.remove(soli);
                    }
                }
            }
            SetearTabla(listaSolAMostrar);
        }
        catch(Exception ex)
        {
            lblerror.setText(ex.getMessage());
        }
    }//GEN-LAST:event_btnListarActionPerformed

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
            java.util.logging.Logger.getLogger(ListadoSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListadoSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListadoSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListadoSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListadoSolicitud().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnListar;
    private javax.swing.JComboBox cbEstado;
    private javax.swing.JComboBox cbSucursal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSolicitudes;
    private javax.swing.JLabel lblerror;
    private javax.swing.JTextField txtCiCli;
    // End of variables declaration//GEN-END:variables
}
