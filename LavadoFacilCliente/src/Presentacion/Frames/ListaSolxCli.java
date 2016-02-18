package Presentacion.Frames;

import Entidades.Objetos.Empleado;
import Entidades.Objetos.Solicitud;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class ListaSolxCli extends javax.swing.JFrame {
    LinkedList<Solicitud> listasoli;
    Empleado emp;
    public ListaSolxCli(LinkedList<Solicitud> listasol,Empleado emps) {
        initComponents();
        listasoli = listasol;
        emp = emps;
        SetearTabla(listasol);
    }

    public void SetearTabla(LinkedList<Solicitud> listasolicitudes) {
        try {
            if(listasolicitudes == null || listasolicitudes.size() == 0) {
                //cargo tabla vacia
                jtableSolicitudesXCli.setModel(
                    new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                            
                        },
                        new String [] {
                            "Fecha Ingreso", "Fecha Entrega", "Cliente", "Empleado", "Estado"
                        }
                    )
                );
            }
            else {
                //cargo tabla con datos
                String [][] datos = new String[listasolicitudes.size()][5];
                for(int i = 0; i<listasolicitudes.size(); i++) {
                   
                    datos[i][0] = listasolicitudes.get(i).getFechaIngreso().toString();
                    datos[i][1] = listasolicitudes.get(i).getFechaEntrega().toString();
                    datos[i][2] = listasolicitudes.get(i).getCedulaCli().getNombre();
                    datos[i][3] = listasolicitudes.get(i).getCedulaEmp().getNombre();
                    datos[i][4] = listasolicitudes.get(i).getEstado().toString();
                }               
                jtableSolicitudesXCli.setModel(
                    new javax.swing.table.DefaultTableModel(
                            datos,
                        new String [] {
                             "Fecha Ingreso", "Fecha Entrega", "Cliente", "Empleado", "Estado"
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableSolicitudesXCli = new javax.swing.JTable();
        btnseleccion = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Lista de solicitudes encontradas:");

        jtableSolicitudesXCli.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtableSolicitudesXCli);

        btnseleccion.setText("Editar Solicitud deseada");
        btnseleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnseleccionActionPerformed(evt);
            }
        });

        lblError.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnseleccion)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblError))
                .addContainerGap(121, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnseleccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(lblError))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnseleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnseleccionActionPerformed
           Thread queryThread = new Thread() {
            @Override
            public void run() {
                try {
                    int filaseleccionada = jtableSolicitudesXCli.getSelectedRow();
                    Solicitud s = listasoli.get(filaseleccionada);
                    MantSolicitudesWizard ms = new MantSolicitudesWizard(s, emp);
                    ms.setVisible(true);
                } catch (Exception ex) {
                    lblError.setText(ex.getMessage());
                }
            }
        };
        queryThread.start();
    }//GEN-LAST:event_btnseleccionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnseleccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtableSolicitudesXCli;
    private javax.swing.JLabel lblError;
    // End of variables declaration//GEN-END:variables
}
