package Presentacion.Controls;

import Entidades.Constantes;
import Entidades.Enumeraciones.TipoMov;
import Entidades.Objetos.Movimiento;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JTable;

public class PagedJTableMovimientos extends javax.swing.JPanel {
    private int rowCount;
    private int totalRows;
    private int pages;
    private int currentPage;
    private List<Movimiento> movs;
    private List<Movimiento> tableView;
    private String[] columnTitles;

    public PagedJTableMovimientos() {
        initComponents();        
    }
    
    public JTable getTable() {
        return tableMovs;
    }
    
    public Movimiento getSelectedMov() {
        int row = tableMovs.getSelectedRow();
        if(row >= 0) {
            return tableView.get(row);
        }
        return null;
    }
    
    public int getSelectedIdMov() {
        int row = tableMovs.getSelectedRow();
        if(row >= 0) {
            return tableView.get(row).getIdMov();
        }
        return -1;
    }
    
    public void SetupJTableMovimientos(int _rowCount, List<Movimiento> _movs, TipoMov tipo) {
        
        switch(tipo) {
            case Gasto: columnTitles = Constantes.gastos_titulosColumnas; break;
            case Ingreso: columnTitles = Constantes.ingresos_titulosColumnas; break;               
        }
        
        movs = _movs;
        rowCount = _rowCount;
        totalRows = movs.size();
        double resPages = (double)totalRows / (double)rowCount;
        pages = (int) Math.ceil(resPages);
        currentPage = 1;
        SetModel(currentPage);
        SetPagination();
        SetEvents();
    }
    
    public void SetModel(int currentPage) {
        if (movs == null) {
            movs = new LinkedList<>();
        }
        
        tableView = new LinkedList<>();
        
        int fromIndex = 0;
        int toIndex = 0;
        if(movs.isEmpty()) {
            tableView = movs;
        } else {
            fromIndex = (rowCount * (currentPage - 1));
            toIndex   = fromIndex + rowCount;
            if (toIndex > movs.size()) toIndex = movs.size();
            tableView = movs.subList(fromIndex, toIndex);
        }        
        
        Object[][] datos = new Object[tableView.size()][4];
        
        for (int i = 0; i < tableView.size(); i++) {
            datos[i][0] = tableView.get(i).getFechaMovStr();
            datos[i][1] = tableView.get(i).getNombreMov();
            datos[i][2] = String.valueOf(tableView.get(i).getMonto());
            datos[i][3] = tableView.get(i).getDescripcion();
            //TODO: Get sucursal para mostrar en la tabla
        }
        
        //Set data to the model
        tableMovs.setModel(new javax.swing.table.DefaultTableModel(datos, columnTitles) {
            //Para que no pueda ser editado
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        
        tableMovs.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableMovs.setColumnSelectionAllowed(false);
        tableMovs.setCellSelectionEnabled(false);
        tableMovs.setRowSelectionAllowed(true);
    }
    
    public void SetPagination() {  
        boolean mustEnable = (pages > 1);
        panelPages.setEnabled(mustEnable);
    }
    
    private void SetEvents() {
        btnAnterior.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Anterior_Click(evt);
            }
        });
        btnSiguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Siguiente_Click(evt);
            }
        });
    }
    
    private void Siguiente_Click(MouseEvent ae) {
        if (currentPage < pages) {
            currentPage++;
            SetModel(currentPage);
            lblPage.setText(String.valueOf(currentPage));
        }
    }
        
    private void Anterior_Click(MouseEvent ae) {
        if (currentPage > 1) {
            currentPage--;
            SetModel(currentPage);
            lblPage.setText(String.valueOf(currentPage));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollGastos = new javax.swing.JScrollPane();
        tableMovs = new javax.swing.JTable();
        panelPages = new javax.swing.JPanel();
        btnAnterior = new javax.swing.JButton();
        lblPage = new javax.swing.JLabel();
        btnSiguiente = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        scrollGastos.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollGastos.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tableMovs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableMovs.setRowSelectionAllowed(false);
        scrollGastos.setViewportView(tableMovs);

        panelPages.setBackground(new java.awt.Color(204, 204, 255));

        btnAnterior.setText("< Anterior");
        btnAnterior.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnAnterior.setContentAreaFilled(false);
        btnAnterior.setMaximumSize(new java.awt.Dimension(80, 20));
        btnAnterior.setMinimumSize(new java.awt.Dimension(80, 20));
        btnAnterior.setPreferredSize(new java.awt.Dimension(80, 20));
        panelPages.add(btnAnterior);

        lblPage.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblPage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPage.setText("1");
        lblPage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblPage.setMaximumSize(new java.awt.Dimension(25, 25));
        lblPage.setMinimumSize(new java.awt.Dimension(20, 20));
        lblPage.setPreferredSize(new java.awt.Dimension(20, 20));
        panelPages.add(lblPage);

        btnSiguiente.setText("Siguiente >");
        btnSiguiente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnSiguiente.setContentAreaFilled(false);
        btnSiguiente.setMaximumSize(new java.awt.Dimension(80, 20));
        btnSiguiente.setMinimumSize(new java.awt.Dimension(80, 20));
        btnSiguiente.setPreferredSize(new java.awt.Dimension(80, 20));
        panelPages.add(btnSiguiente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollGastos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(panelPages, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollGastos, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelPages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel lblPage;
    private javax.swing.JPanel panelPages;
    private javax.swing.JScrollPane scrollGastos;
    private javax.swing.JTable tableMovs;
    // End of variables declaration//GEN-END:variables


}
