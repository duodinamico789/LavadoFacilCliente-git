package Presentacion.Controls;
import Entidades.Objetos.Sucursal;
import java.util.LinkedList;
import Entidades.Objetos.Tintoreria;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class ListadoTintorerias extends javax.swing.JPanel {
    private LinkedList<Tintoreria> lista = null;
    private LinkedList<Sucursal> listasuc;
public ListadoTintorerias() {
        initComponents();
         try
        {
         jcombosucursales.setSelectedIndex(0);
         listasuc = Logica.Clases.FabricaLogica.getInstancia().getILogicaSucursales().ListarSucursales();
         String[] sucus = new String[100];
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
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableTintorerias = new javax.swing.JTable();
        jcombosucursales = new javax.swing.JComboBox();
        btnListar = new javax.swing.JButton();
        lblerror = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Listado Tintorerias:");

        jtableTintorerias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtableTintorerias.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jtableTintorerias);

        jcombosucursales.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todas" }));
        jcombosucursales.setToolTipText("");

        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        jLabel2.setText("Sucursales:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jcombosucursales, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnListar))
                            .addComponent(lblerror)
                            .addComponent(jLabel1))
                        .addGap(0, 215, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcombosucursales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(lblerror))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
       try
       {
        lista= Logica.Clases.FabricaLogica.getInstancia().getILogicaTintoreria().ListarTintorerias();   
        if(jcombosucursales.getSelectedIndex()==0)
        {
            SetearTabla(lista);
        }
        else
        {
          LinkedList<Tintoreria>listaAux = new LinkedList<Tintoreria>();  
          String s = jcombosucursales.getSelectedItem().toString();
          for(int k=0; k< lista.size(); k++)
          {
            Tintoreria t = lista.get(k);
            for(int j = 0; j<t.getSucursalCercana().size();j++)
            {
              Sucursal scus = t.getSucursalCercana().get(j);
              if(scus.getNombreSuc().equals(s))
              {
                 listaAux.add(t);
              }
            }
          }
          SetearTabla(lista);
        }
           
       }
       catch(Exception ex)
       {
        lblerror.setText(ex.getMessage());
       }
    }//GEN-LAST:event_btnListarActionPerformed

     public void SetearTabla(LinkedList<Tintoreria> tin) {
        try {
            if(tin == null || tin.size() == 0) {
                //cargo tabla vacia
                jtableTintorerias.setModel(
                    new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                           // {null, null, null, null, null}
                        },
                        new String [] {
                            "Nombre", "Telefono", "Direccion","Barrio", "Ciudad"
                        }
                    ));
            }
            else {
                //cargo tabla con datos
                String [][] datos = new String[tin.size()][5];
                for(int i = 0; i<tin.size(); i++) {
                   
                    datos[i][0] = tin.get(i).getNombre();
                    datos[i][1] = tin.get(i).getTelefono();
                    datos[i][2] = tin.get(i).getUbicacion().getDireccion();
                    datos[i][3] = tin.get(i).getUbicacion().getBarrio();
                    datos[i][4] = tin.get(i).getUbicacion().getCiudad();
                }
                jtableTintorerias.setModel(
                    new javax.swing.table.DefaultTableModel(
                            datos,
                        new String [] {
                             "Nombre", "Telefono", "Direccion","Barrio", "Ciudad"
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnListar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jcombosucursales;
    private javax.swing.JTable jtableTintorerias;
    private javax.swing.JLabel lblerror;
    // End of variables declaration//GEN-END:variables
}
