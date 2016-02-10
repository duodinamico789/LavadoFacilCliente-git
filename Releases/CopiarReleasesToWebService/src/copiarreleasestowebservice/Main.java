package copiarreleasestowebservice;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.LinkedList;
import javax.swing.JScrollBar;

public class Main extends javax.swing.JFrame {

    static Thread processThread;
    static boolean ejecucionFallida;
    StringBuilder sb;

    public Main() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();
        jspConsole = new javax.swing.JScrollPane();
        jtaConsole = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setMinimumSize(new java.awt.Dimension(600, 540));

        lblTitulo.setBackground(new java.awt.Color(102, 102, 102));
        lblTitulo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 255, 204));
        lblTitulo.setText("Consola:");

        btnCerrar.setText("Cerrar");
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarMouseClicked(evt);
            }
        });

        jtaConsole.setEditable(false);
        jtaConsole.setBackground(new java.awt.Color(0, 0, 0));
        jtaConsole.setColumns(20);
        jtaConsole.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        jtaConsole.setForeground(new java.awt.Color(0, 255, 204));
        jtaConsole.setLineWrap(true);
        jtaConsole.setRows(5);
        jspConsole.setViewportView(jtaConsole);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(527, Short.MAX_VALUE)
                .addComponent(btnCerrar)
                .addContainerGap())
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jspConsole)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jspConsole, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCerrarMouseClicked

    private void Process() throws InterruptedException {
        ejecucionFallida = false;
        sb = new StringBuilder();
        try {            
            LinkedList<String> folderNames = new LinkedList<>();
            folderNames.add("LavadoFacilEntidades");
            folderNames.add("LavadoFacilLogica");
            folderNames.add("LavadoFacilPersistencia");
            
            //String userDir = System.getProperty("user.dir"); // ==> F:\LavadoFacilCliente-v1.0.4
            String lavadoFacilLocation = System.getProperty("user.dir");
            //updCls("System.getProperty(\"user.dir\") ==> " + userDir + "\n");
            updCls("Ubicación proyectos: "
                    + lavadoFacilLocation
                    + "\n\nCopiando releases a la carpeta web services \"libs\"\n");
            for (String fn : folderNames) {
                String fileName = fn + ".jar";
                Path originPath = Paths.get(lavadoFacilLocation
                        + File.separator
                        + fn
                        + File.separator
                        + "dist"
                        + File.separator
                        + fileName);
                Path destPath = Paths.get(lavadoFacilLocation
                        + "/LavadoFacilWebServices/lib/"
                        + fileName);
                updCls("Copiando JAR "
                        + originPath
                        + " \na \n"
                        + destPath + "\n");

                Files.copy(originPath, destPath, StandardCopyOption.REPLACE_EXISTING);
                updCls("[EXITO]\n");
            }
            updCls("\tEJECUCION CORRECTA!\n");
            updCls("\n");
            //Cerrando
            updCls("\nCerrando en 5 segundos...");
        } catch (IOException e) {
            updCls("[EXCEPTION] ");
            if (e instanceof NoSuchFileException) {
                updCls("Tratando de acceder a un archivo que no existe.\n");
            } else {
                updCls(e.getMessage());
            }
            updCls("\tEJECUCION FALLIDA!");
            ejecucionFallida = true;
        }
    }

    private void updCls(String mensaje) throws InterruptedException {
        sb.append(mensaje);
        jtaConsole.setText(sb.toString());
        JScrollBar sb = jspConsole.getVerticalScrollBar();
        sb.setValue(sb.getMaximum());
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            Main main = new Main();
            main.getContentPane().setBackground(new Color(0, 255, 255, 1));
            main.processThread = new Thread() {
                @Override
                public void run() {
                    try {
                        main.Process();              
                    } catch (Exception ex) {
                        System.out.print(ex.getMessage());
                    }
                }
            };
            processThread.start();
            main.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JScrollPane jspConsole;
    private javax.swing.JTextArea jtaConsole;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
