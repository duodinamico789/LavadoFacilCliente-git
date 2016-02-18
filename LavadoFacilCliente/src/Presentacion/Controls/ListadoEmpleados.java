
package Presentacion.Controls;
import Entidades.Enumeraciones;
import Entidades.Objetos.Empleado;
import Entidades.Objetos.Sucursal;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import Entidades.Enumeraciones.TipoEmpleado;

public class ListadoEmpleados extends javax.swing.JPanel {

    private LinkedList<Empleado> listaEmpleadoAMostrar = null;
    private LinkedList<Empleado> listaEmpleados = null;
    private LinkedList<Sucursal> listasuc = null;
    public ListadoEmpleados() {
        initComponents();
        try
        {
         listaEmpleados = Logica.Clases.FabricaLogica.getInstancia().getILogicaPersonas().ListadoEmpleados();
         jcomboempleados.setSelectedIndex(0);
         jcombosucursales.setSelectedIndex(0);
         listasuc = Logica.Clases.FabricaLogica.getInstancia().getILogicaSucursales().ListarSucursales();
         String[] sucus = new String[listasuc.size()+1];
         Sucursal suc = null;
         sucus[0]= "Todas";
          for(int i=0;i<listasuc.size();i++)
          {
           suc = listasuc.get(i);
           sucus[i+1]= suc.getNombreSuc();
          }
         jcombosucursales.setModel(new DefaultComboBoxModel(sucus));
        }
        catch(Exception ex)
        {
         lblerror.setText(ex.getMessage());
        }
    }                                      

    public void SetearTabla(LinkedList<Empleado> emp) {
        try {
            if(emp == null || emp.size() == 0) {
                //cargo tabla vacia
                jTableEmpleados.setModel(
                    new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                           // {null, null, null, null, null, null, null, null, null}
                        },
                        new String [] {
                            "Cedula", "Nombre", "Telefono","Celular", "Sueldo", "Fecha De Ingreso",
                            "Direccion", "Tipo De Empleado", "Sucursal"
                        }
                    ));
            }
            else {
                //cargo tabla con datos
                String [][] datos = new String[emp.size()][9];
                for(int i = 0; i<emp.size(); i++) {
                   
                    datos[i][0] = emp.get(i).getCedula();
                    datos[i][1] = emp.get(i).getNombre();
                    datos[i][2] = emp.get(i).getTelefono();
                    datos[i][3] = emp.get(i).getCelular();                   
                    datos[i][4] = emp.get(i).getSueldo().toString();
                    datos[i][5] = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(emp.get(i).getFechaIngreso());
                    datos[i][6] = emp.get(i).getUbicacion().getDireccion();
                    datos[i][7] = emp.get(i).getTipoEmpleado().toString();
                    datos[i][8] = emp.get(i).getSucursal().getNombreSuc();
                }
                
                jTableEmpleados.setModel(
                    new javax.swing.table.DefaultTableModel(
                            datos,
                        new String [] {
                             "Cedula", "Nombre", "Telefono","Celular", "Sueldo", "Fecha De Ingreso",
                             "Direccion", "Tipo De Empleado", "Sucursal"
                        }
                    ) {
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
        jcomboempleados = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jcombosucursales = new javax.swing.JComboBox();
        btnListar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEmpleados = new javax.swing.JTable();
        lbllistado = new javax.swing.JLabel();
        lblerror = new javax.swing.JLabel();

        jcomboempleados.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Mostrador", "Interno", "Supervisor", "Delivery" }));

        jLabel1.setText("Sucursal:");

        jcombosucursales.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todas" }));

        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Listado de Empleados:");

        jTableEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableEmpleados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTableEmpleados);

        lbllistado.setText("Listado de Empleados:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbllistado)
                        .addGap(30, 30, 30)
                        .addComponent(jcomboempleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addComponent(jcombosucursales, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblerror))
                .addGap(0, 226, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbllistado)
                    .addComponent(jcomboempleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jcombosucursales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblerror)
                .addGap(0, 23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        try
        {
            listaEmpleadoAMostrar= new LinkedList<Empleado>();
            if(jcomboempleados.getSelectedIndex()==0&& jcombosucursales.getSelectedIndex()==0)
            {
                listaEmpleadoAMostrar=listaEmpleados;
            }
            else if(jcomboempleados.getSelectedIndex()!=0&& jcombosucursales.getSelectedIndex()==0)
            {
               String tipo = jcomboempleados.getSelectedItem().toString();
               for(int k=0; k<listaEmpleados.size(); k++)
               {
                 if(listaEmpleados.get(k).getTipoEmpleado().toString().equals(tipo))
                 {
                  listaEmpleadoAMostrar.add(listaEmpleados.get(k));
                 }
               }
            }
           else if(jcomboempleados.getSelectedIndex()==0&& jcombosucursales.getSelectedIndex()!=0)
            {
                String s = jcombosucursales.getSelectedItem().toString();
                for(int i=0; i < listaEmpleados.size();i++)
                {
                  if(listaEmpleados.get(i).getSucursal().getNombreSuc().equals(s))
                  {
                    listaEmpleadoAMostrar.add(listaEmpleados.get(i));
                  }
                }
            }
            else
            {
                String s = jcombosucursales.getSelectedItem().toString();
                String tipo = jcomboempleados.getSelectedItem().toString();
                for(int i=0; i < listaEmpleados.size();i++)
                {
                    Sucursal su = listasuc.get(i);
                    if(listaEmpleados.get(i).getSucursal().getNombreSuc().equals(s))
                    {
                        for(int j=0; i< listaEmpleados.size(); j++)
                        {
                            Empleado e = listaEmpleados.get(i);
                            if(e.getTipoEmpleado().toString().equals(tipo))
                            {
                                listaEmpleadoAMostrar.add(e);
                            }
                        }
                    }
                }
            }
            SetearTabla(listaEmpleadoAMostrar);

        }
        catch(Exception ex)
        {
            lblerror.setText(ex.getMessage());
        }
    }//GEN-LAST:event_btnListarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnListar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableEmpleados;
    private javax.swing.JComboBox jcomboempleados;
    private javax.swing.JComboBox jcombosucursales;
    private javax.swing.JLabel lblerror;
    private javax.swing.JLabel lbllistado;
    // End of variables declaration//GEN-END:variables
}
