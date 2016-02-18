package Presentacion.Frames;

import Entidades.Objetos.Empleado;
import Entidades.Objetos.Solicitud;
import java.util.LinkedList;

public class MantSolicitudBusqueda extends javax.swing.JFrame {

    Empleado emp;
    public MantSolicitudBusqueda(Empleado e) {
        initComponents();
        MostrarLoading(false);
        emp = e;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        rbCi = new javax.swing.JRadioButton();
        rbTi = new javax.swing.JRadioButton();
        txtTexto = new javax.swing.JTextField();
        btnBuscarSolicitud = new javax.swing.JButton();
        jLabelLoading = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTitulo.setText("Buscar solicitud de lavado:");

        rbCi.setText("Buscar por cedula");
        rbCi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rbCiFocusGained(evt);
            }
        });

        rbTi.setText("Buscar por ID de ticket");
        rbTi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rbTiFocusGained(evt);
            }
        });

        txtTexto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTextoKeyTyped(evt);
            }
        });

        btnBuscarSolicitud.setText("Buscar Solicitud");
        btnBuscarSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarSolicitudActionPerformed(evt);
            }
        });

        jLabelLoading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLoading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/loading-24x24.GIF"))); // NOI18N
        jLabelLoading.setToolTipText("Cargando pedido");

        lblError.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addGap(137, 137, 137)
                        .addComponent(jLabelLoading, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbTi)
                            .addComponent(rbCi))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarSolicitud)
                            .addComponent(txtTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblError))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitulo)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(rbCi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbTi))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(txtTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabelLoading, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnBuscarSolicitud)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(lblError))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTextoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTextoKeyTyped
        char num = evt.getKeyChar();
        if (num < '0' || num > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtTextoKeyTyped

    private void rbCiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rbCiFocusGained
        rbTi.setSelected(false);
    }//GEN-LAST:event_rbCiFocusGained

    private void rbTiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rbTiFocusGained
        rbCi.setSelected(false);
    }//GEN-LAST:event_rbTiFocusGained

    private void btnBuscarSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarSolicitudActionPerformed
        Thread queryThread = new Thread() {
        @Override
        public void run() {
            Solicitud s = new Solicitud();
            LinkedList<Solicitud> listasol = new LinkedList<>();
            LinkedList<Solicitud> listasolaux = new LinkedList<>();
            try
            {
                if("".equals(txtTexto.getText())){
                  throw new Exception("texto vacio");  
                }
                if(rbCi.isSelected())
                {
                  listasol = Logica.Clases.FabricaLogica.getInstancia().getILogicaSolicitud().BuscarSolicitudXCli(txtTexto.getText());
                  for(Solicitud sol : listasol)
                  {
                    if("En_Proceso".equals(sol.getEstado().toString()))
                    {
                      listasolaux.add(sol);
                    }
                  }
                  if(listasolaux.isEmpty())
                  {
                    throw new Exception("No existe ninguna solicitud en proceso para el cliente buscado");
                  }
                }
                else if(rbTi.isSelected())
                {
                  s = Logica.Clases.FabricaLogica.getInstancia().getILogicaSolicitud().BuscarSolicitudXId(Integer.valueOf(txtTexto.getText()));
                  if("Finalizada".equals(s.getEstado().toString()))
                  {
                    throw new Exception("La soliciitud buscada se encunetra finalizada y no se puede editar");
                }
                }
                else
                {
                  throw new Exception("Debe seleccionar una opcion");
                } 
                if(s == null && listasol.isEmpty())
                {
                  throw new Exception("No se encontro solicitud buscada, compruebe datos");
                }
                else if(s.getId() !=null)
                {
                  MantSolicitudesWizard ms = new MantSolicitudesWizard(s,emp);
                  ms.setVisible(true);
            }
                else
                {
                  ListaSolxCli lsc = new ListaSolxCli(listasolaux,emp);
                  lsc.setVisible(true);
                }
            }           
            catch(Exception ex)
            {
               lblError.setText(ex.getMessage());
            }
            MostrarLoading(false);    
            }
            };
             queryThread.start();     
//             if("".equals(lblError.getText()))
//             {
//               this.dispose();
//             }
    }//GEN-LAST:event_btnBuscarSolicitudActionPerformed
    private void MostrarLoading(boolean mostrar) {
        jLabelLoading.setVisible(mostrar);
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarSolicitud;
    private javax.swing.JLabel jLabelLoading;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JRadioButton rbCi;
    private javax.swing.JRadioButton rbTi;
    private javax.swing.JTextField txtTexto;
    // End of variables declaration//GEN-END:variables
}
