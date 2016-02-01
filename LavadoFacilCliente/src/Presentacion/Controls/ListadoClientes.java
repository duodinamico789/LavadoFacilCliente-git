package Presentacion.Controls;

import Entidades.Objetos.Cliente;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class ListadoClientes extends javax.swing.JPanel {
    private LinkedList<Cliente> lista;
    public ListadoClientes() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblerror = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rbFechaIngreso = new javax.swing.JRadioButton();
        rbUltimaEntrada = new javax.swing.JRadioButton();
        btnListar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableClientes = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Listado de Clientes:");

        jLabel2.setText("Ordenar por:");

        rbFechaIngreso.setText("Fecha de registro");
        rbFechaIngreso.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rbFechaIngresoFocusGained(evt);
            }
        });

        rbUltimaEntrada.setText("Ultima entrada");
        rbUltimaEntrada.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rbUltimaEntradaFocusGained(evt);
            }
        });

        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        jtableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtableClientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jtableClientes);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbUltimaEntrada)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rbFechaIngreso)
                                .addGap(18, 18, 18)
                                .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(333, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbFechaIngreso)
                        .addComponent(btnListar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbUltimaEntrada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(lblerror, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblerror)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void SetearTabla(LinkedList<Cliente> cli) {
        try {
            if(cli == null || cli.size() == 0) {
                //cargo tabla vacia
                jtableClientes.setModel(
                    new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                        },
                        new String [] {
                            "Cedula", "Nombre", "Telefono","Celular" ,"Direccion" ,"Registrado","Fecha Ingreso", "Ultima Entrada"
                        }
                    ));
            }
            else {
                //cargo tabla con datos
                String [][] datos = new String[cli.size()][7];
                for(int i = 0; i<cli.size(); i++) {
                   
                    datos[i][0] = cli.get(i).getCedula();
                    datos[i][1] = cli.get(i).getNombre();
                    datos[i][2] = cli.get(i).getTelefono();
                    datos[i][3] = cli.get(i).getCelular();
                    datos[i][4] = cli.get(i).getUbicacion().getDireccion();
                    datos[i][5] = new java.text.SimpleDateFormat("yyyy-MM-dd").format(cli.get(i).getfechareg());
                    if(cli.get(i).getfechaUltimaEntrada() != null)
                    {
                      datos[i][6] = new java.text.SimpleDateFormat("yyyy-MM-dd").format(cli.get(i).getfechaUltimaEntrada());
                    }
                }               
                jtableClientes.setModel(
                    new javax.swing.table.DefaultTableModel(
                            datos,
                        new String [] {
                             "Cedula", "Nombre", "Telefono","Celular" ,"Direccion" ,"Fecha Ingreso", "Ultima Entrada"
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
            if(rbFechaIngreso.isSelected())
            {
                lista = Logica.Clases.LogicaPersonas.getInstancia().ListarClientesXFechareg();
                
            }
            if(rbUltimaEntrada.isSelected())
            {
                lista = Logica.Clases.FabricaLogica.getInstancia().getILogicaPersonas().ListarClientesXfechaUltimaEntrada();
            }
            this.SetearTabla(lista);
        }
        catch(Exception ex)
        {
            lblerror.setText(ex.getMessage());
        }
    }//GEN-LAST:event_btnListarActionPerformed

    private void rbFechaIngresoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rbFechaIngresoFocusGained
        rbUltimaEntrada.setSelected(false);
    }//GEN-LAST:event_rbFechaIngresoFocusGained

    private void rbUltimaEntradaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rbUltimaEntradaFocusGained
        rbFechaIngreso.setSelected(false);
    }//GEN-LAST:event_rbUltimaEntradaFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnListar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtableClientes;
    private javax.swing.JLabel lblerror;
    private javax.swing.JRadioButton rbFechaIngreso;
    private javax.swing.JRadioButton rbUltimaEntrada;
    // End of variables declaration//GEN-END:variables
}
