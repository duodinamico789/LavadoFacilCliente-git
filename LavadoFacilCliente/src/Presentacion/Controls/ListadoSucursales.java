package Presentacion.Controls;

import Entidades.Objetos.Sucursal;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class ListadoSucursales extends javax.swing.JPanel {

    public ListadoSucursales() {
        initComponents();

    }
    
    public void SetearTabla(LinkedList<Sucursal> suc) {
        try {
            if(suc == null || suc.size() == 0) {
                //cargo tabla vacia
                jTableSucursales.setModel(
                    new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            //{null, null, null, null, null}
                        },
                        new String [] {
                            "Nombre", "Telefono", "Direccion", "Barrio", "Ciudad"
                        }
                    )
                );
            }
            else {
                //cargo tabla con datos
                String [][] datos = new String[suc.size()][5];
                for(int i = 0; i<suc.size(); i++) {
                   
                    datos[i][0] = suc.get(i).getNombreSuc();
                    datos[i][1] = suc.get(i).getTelefono();
                    datos[i][2] = suc.get(i).getUbicacion().getDireccion();
                    datos[i][3] = suc.get(i).getUbicacion().getBarrio();
                    datos[i][4] = suc.get(i).getUbicacion().getCiudad();
                }               
                jTableSucursales.setModel(
                    new javax.swing.table.DefaultTableModel(
                            datos,
                        new String [] {
                             "Nombre", "Telefono","Direccion", "Barrio", "Ciudad"
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSucursales = new javax.swing.JTable();
        lblerror = new javax.swing.JLabel();
        btnListar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Listado de Sucursales:");

        jTableSucursales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableSucursales.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTableSucursales);

        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblerror)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(btnListar)
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblerror)
                .addContainerGap(29, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
    try
    {
      LinkedList<Sucursal> lista = Logica.Clases.FabricaLogica.getInstancia().getILogicaSucursales().ListarSucursales();
      this.SetearTabla(lista);         
    }
    catch(Exception ex)
    {
      lblerror.setText(ex.getMessage());
    }
    }//GEN-LAST:event_btnListarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnListar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSucursales;
    private javax.swing.JLabel lblerror;
    // End of variables declaration//GEN-END:variables
}
