package Presentacion.Frames;

import Entidades.Objetos.Solicitud;
import Entidades.Enumeraciones.EstadosSolicitud;

public class CambioEstadoSol extends javax.swing.JFrame {
    EstadosSolicitud es;
    Solicitud s;
    public CambioEstadoSol() {
        initComponents();
        MostrarLoading(false);      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelLoading = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelLoading1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        txtestado = new javax.swing.JTextField();
        btnFinalizarSol = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();

        jLabelLoading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLoading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/loading-24x24.GIF"))); // NOI18N
        jLabelLoading.setToolTipText("Cargando pedido");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Cambio de estado Solicitud:");

        jLabelLoading1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLoading1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/loading-24x24.GIF"))); // NOI18N
        jLabelLoading1.setToolTipText("Cargando pedido");

        jLabel2.setText("Id Solicitud:");

        jLabel3.setText("Estado:");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Resources/search-icon24x24.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnFinalizarSol.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnFinalizarSol.setForeground(new java.awt.Color(0, 0, 204));
        btnFinalizarSol.setText("Finalizar Solicitud");
        btnFinalizarSol.setContentAreaFilled(false);
        btnFinalizarSol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarSolActionPerformed(evt);
            }
        });

        lblError.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtestado, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFinalizarSol)))
                .addContainerGap(62, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblError)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBuscar)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFinalizarSol))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(lblError))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelLoading1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelLoading1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MostrarLoading(boolean mostrar) {
        jLabelLoading1.setVisible(mostrar);
    }
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        Thread queryThread = new Thread() {
            @Override
            public void run() {
                EstadosSolicitud estado;
                try
                {
                    MostrarLoading(true);
                    if ("".equals(txtId.getText()))
                    {
                        throw new Exception("Debe ingresar id de Solicitud");
                    }
                    s = Logica.Clases.FabricaLogica.getInstancia().getILogicaSolicitud().BuscarSolicitudXId(Integer.valueOf(txtId.getText()));
                    if(s == null)
                    {
                        throw new Exception("No se encontro solicitud buscada, compruebe");
                    }
                    else
                    {
                        estado = s.getEstado();
                        String estadoaux = estado.toString();
                        if(estadoaux.equals("Finalizada"))
                        {
                            txtestado.setText(s.getEstado().toString());
                            throw new Exception("No se puede cambiar estado de solicitud, la misma esta finalizada");
                        }
                        else
                        {
                            txtestado.setText(s.getEstado().toString());
                        }
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
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnFinalizarSolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarSolActionPerformed
        Thread queryThread = new Thread() {
        @Override
        public void run() {
        try
        {
            es = EstadosSolicitud.valueOf("Finalizada");
            Logica.Clases.FabricaLogica.getInstancia().getILogicaSolicitud().CambiarEstadoSol(s.getId(),es );
            txtestado.setText("Finalizada");
            }catch(Exception ex)
            {
              lblError.setText(ex.getMessage());
            }
          }
        };
        queryThread.start();
    }//GEN-LAST:event_btnFinalizarSolActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnFinalizarSol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelLoading;
    private javax.swing.JLabel jLabelLoading1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblError;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtestado;
    // End of variables declaration//GEN-END:variables
}
