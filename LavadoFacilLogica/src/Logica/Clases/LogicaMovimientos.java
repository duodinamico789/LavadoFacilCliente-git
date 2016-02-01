package Logica.Clases;

import Entidades.Enumeraciones.TipoMov;
import Entidades.Objetos.Movimiento;
import Logica.Interface.ILogicaMovimientos;
import java.util.LinkedList;

public class LogicaMovimientos implements ILogicaMovimientos {    
    private static LogicaMovimientos _instancia = null;
//    private static String titleDocuments = "Contabilidad generada el día ";
//    private static int separation_1 = 4;
//    private static int separation_2 = 2;
    
    private LogicaMovimientos() { }
    
    public static LogicaMovimientos getInstancia() 
    {
        if(_instancia == null)
            _instancia = new LogicaMovimientos();
        return _instancia;
    }
     
    //<editor-fold defaultstate="collapsed" desc="Movimientos">
     @Override
     public int AltaMovimiento(Movimiento mov) throws Exception
     {
         Persistencia.Interfaces.IPersistenciaMovimientos pgto = Persistencia.Clases.FabricaPersistencia.getInstancia().getIpersistenciaMovimientos();
         return pgto.AltaMovimiento(mov);
     }
     
     @Override
     public int ModificarMovimiento(Movimiento mov) throws Exception
     {
         Persistencia.Interfaces.IPersistenciaMovimientos pgto = Persistencia.Clases.FabricaPersistencia.getInstancia().getIpersistenciaMovimientos();
         return pgto.ModificarMovimiento(mov);
     }
     
     @Override
     public int BajaMovimiento(int idMov) throws Exception
     {
         Persistencia.Interfaces.IPersistenciaMovimientos pgto = Persistencia.Clases.FabricaPersistencia.getInstancia().getIpersistenciaMovimientos();
         return pgto.BajaMovimiento(idMov);
     }
     
     @Override
     public Movimiento BuscarMovimiento(int idMov) throws Exception {
         Persistencia.Interfaces.IPersistenciaMovimientos pgto = Persistencia.Clases.FabricaPersistencia.getInstancia().getIpersistenciaMovimientos();
         return pgto.BuscarMovimiento(idMov);
     }
     
     @Override
     public LinkedList<Movimiento> ListarMovimientosPorSucursal(TipoMov tipoMovs, int idSuc) throws Exception {
         Persistencia.Interfaces.IPersistenciaMovimientos pgto = Persistencia.Clases.FabricaPersistencia.getInstancia().getIpersistenciaMovimientos();
         return pgto.ListarMovimientosPorSucursal(tipoMovs, idSuc);
     }
//</editor-fold>
        
    /*@Override
    public Movimiento ConsultarContabAuto(boolean incluirGastosIngresos, Empleado empLogueado) throws Exception {
        //Apartar la funcionalidad
        //Primero buscar la contabilidad del mes actual
        Persistencia.Interfaces.IPersistenciaContabilidades_old ping = Persistencia.Clases.FabricaPersistencia.getInstancia().getIpersistenciaContabilidades();
        return ping.ConsultarContabAuto(incluirGastosIngresos, empLogueado);
    }
    
    @Override
    public HSSFWorkbook GenerarExcelDocumentOldFormat(Movimiento contab) throws IOException {
        //Tener la ruta actual
        String currentDir = System.getProperty("user.dir");
        
        //Traer el template
        POIFSFileSystem fs = new POIFSFileSystem(
    	        new FileInputStream(currentDir + "//src//Presentacion//Templates//template_excel_old.xls"));
        HSSFWorkbook wb = new  HSSFWorkbook(fs, true);
        
        //Obtenemos hoja
        HSSFSheet sheetContab = wb.getSheet("Contab");
                
        HSSFRow row = sheetContab.getRow(0);
        if (row == null) row = sheetContab.createRow(0);
        HSSFCell titleCell = row.getCell(1);
        if(titleCell == null) titleCell = row.createCell(1);
        titleCell.setCellValue(titleDocuments);
        
        HSSFRow row2 = sheetContab.getRow(2);
        if (row2 == null) row2 = sheetContab.createRow(2);
        HSSFCell fechaContab = row2.getCell(2);
        if(fechaContab == null) fechaContab = row2.createCell(2);
        fechaContab.setCellValue(contab.getFechaStr());
                
        HSSFRow row3 = sheetContab.getRow(3);
        if (row3 == null) row3 = sheetContab.createRow(3);
        HSSFCell sucursalContab = row3.getCell(2);
        if(sucursalContab == null) sucursalContab = row3.createCell(2);
        sucursalContab.setCellValue(contab.getSucursal().getNombreSuc());
        
        //8 num fila para ingresos
        int rowNumber = 7;
        int index = 0;
        HSSFRow currentRow;
        HSSFCell rowCell;
        
        while(index < contab.getIngresosList().size()) {
            Ingreso ingreso = contab.getIngresosList().get(index);
            currentRow = sheetContab.getRow(rowNumber);
            
            rowCell = currentRow.getCell(1);
            if (rowCell == null) rowCell = currentRow.createCell(1);
            rowCell.setCellValue(ingreso.getReferencia());
            rowCell = currentRow.getCell(2);
            if (rowCell == null) rowCell = currentRow.createCell(2);
            rowCell.setCellValue(ingreso.getNombreIng());
            rowCell = currentRow.getCell(3);
            if (rowCell == null) rowCell = currentRow.createCell(3);
            rowCell.setCellValue(String.valueOf(ingreso.getMonto()));
            
            //No duplicar la ultima fila
            if(index != contab.getIngresosList().size() - 1)
                copyRow(wb, sheetContab, rowNumber, rowNumber + 1);
            
            rowNumber++;            
            index++;
        }
        
        //Total ingresos
        currentRow = sheetContab.getRow(rowNumber);
        rowCell = currentRow.getCell(3);
        if (rowCell == null) rowCell = currentRow.createCell(3);
        rowCell.setCellValue(String.valueOf(contab.GetTotalIngresos()));
        
        rowNumber += separation_1;
        
        //Gastos
        index = 0;
        while(index < contab.getGastosList().size()) {
            Gasto gasto = contab.getGastosList().get(index);
            currentRow = sheetContab.getRow(rowNumber);
            
            rowCell = currentRow.getCell(1);
            if (rowCell == null) rowCell = currentRow.createCell(1);
            rowCell.setCellValue(gasto.getReferencia());
            rowCell = currentRow.getCell(2);
            if (rowCell == null) rowCell = currentRow.createCell(2);
            rowCell.setCellValue(gasto.getNombreGto());
            rowCell = currentRow.getCell(3);
            if (rowCell == null) rowCell = currentRow.createCell(3);
            rowCell.setCellValue(String.valueOf(gasto.getMonto()));
            
            //No duplicar la ultima fila
            if(index != contab.getGastosList().size() - 1)
                copyRow(wb, sheetContab, rowNumber, rowNumber + 1);
            
            rowNumber++;            
            index++;
        }
        
        currentRow = sheetContab.getRow(rowNumber);
        rowCell = currentRow.getCell(3);
        if (rowCell == null) rowCell = currentRow.createCell(3);
        rowCell.setCellValue(String.valueOf(contab.GetTotalGastos()));        
        
        rowNumber += separation_2;
        
        currentRow = sheetContab.getRow(rowNumber);
        rowCell = currentRow.getCell(3);
        if (rowCell == null) rowCell = currentRow.createCell(3);
        rowCell.setCellValue(String.valueOf(contab.CalcularMargen()));
        
        //13 num fila para gastos
        //TODO: Probar ingresos y hacer lo mismo con gastos
        
//        FileOutputStream fileOut = new FileOutputStream("c://PRUEBA_EXCEL.xls");
		
//        write this workbook to an Outputstream.
//        wb.write(fileOut);
//        fileOut.flush();
//        fileOut.close();
        return wb;
    }
    
    @Override
    public ByteArrayOutputStream GenerarPdfDocumentFormat(Movimiento contab) throws GenerationException {
        try {
        //Tener la ruta actual
        String currentDir = System.getProperty("user.dir");
        
        //Traer el doc en excel
        HSSFWorkbook workbook = GenerarExcelDocumentOldFormat(contab);

        //Hacer la magia... convertir el xls to pdf
        ByteArrayOutputStream pdfDocumentInMemory = GeneratePDF(contab);

        return pdfDocumentInMemory;
        } catch (Exception ex) {
            throw new GenerationException(ex.getMessage());
        }
    }
    
    @Override
    public LinkedList<Movimiento> ListarUltimasDoceContabs() throws SQLException {
        Persistencia.Interfaces.IPersistenciaContabilidades_old ping = Persistencia.Clases.FabricaPersistencia.getInstancia().getIpersistenciaContabilidades();
        return ping.ListarUltimasDoceContabs();
    }
    
    public ByteArrayOutputStream GeneratePDF(Movimiento contab) throws GenerationException {
        try {
            //Empty cell
            PdfPCell emptyCell = new PdfPCell(new Phrase(Constantes.EMPTY));            
            emptyCell.setBorder(Rectangle.NO_BORDER);
            
            //Filename and variables
            //We will create output PDF document objects at this point
            Document iText_pdf = new Document(PageSize.A4);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfWriter.getInstance(iText_pdf, baos);
            iText_pdf.open();
            
            //First row
            PdfPTable headerTable = new PdfPTable(1);
            PdfPCell titleCell = new PdfPCell( GetPhrase("Calibri", 20f, 
                    Font.BOLD, "Contabilidad Generada:"));
            titleCell.setBorder(Rectangle.BOTTOM);
            titleCell.setBorderColorBottom(BaseColor.BLACK);
            titleCell.setBorderWidthBottom(0.5f);
            titleCell.setVerticalAlignment(Element.ALIGN_MIDDLE);            
            titleCell.setPaddingBottom(5f);
            //PdfPRow titleRow = new PdfPRow(new PdfPCell[] { titleCell });            
            headerTable.addCell(titleCell);  
            headerTable.addCell(emptyCell);
            
            iText_pdf.add(headerTable);
            
            PdfPTable basicDataTable = new PdfPTable(2);
            PdfPCell cell_1_1 = new PdfPCell( GetPhrase("Calibri", 12f, 
                    Font.BOLD, "Fecha contabilidad:"));
            basicDataTable.addCell(cell_1_1);
            PdfPCell cell_1_2 = new PdfPCell( GetPhrase("Calibri", 12f, 
                    Font.BOLD, contab.getFechaStr()));
            basicDataTable.addCell(cell_1_2);
            PdfPCell cell_2_1 = new PdfPCell( GetPhrase("Calibri", 12f, 
                    Font.BOLD, "Sucursal:"));
            basicDataTable.addCell(cell_2_1);
            PdfPCell cell_2_2 = new PdfPCell( GetPhrase("Calibri", 12f, 
                    Font.BOLD, contab.getSucursal().getNombreSuc()));
            basicDataTable.addCell(cell_2_2);
            
            iText_pdf.add(basicDataTable);
            
            //we have two columns in the Excel sheet, so we create a PDF table with two columns
            //Note: There are ways to make this dynamic in nature, if you want to.
            //PdfPTable my_table = new PdfPTable(5);
            //We will use the object below to dynamically add new data to the table
            PdfPCell table_cell;
            //Loop through rows.
//            while(rowIterator.hasNext()) {
//                    Row row = rowIterator.next();
//                    //CellStyle cellStyle = CellStyle.class.newInstance();
//                    //cellStyle.setFillBackgroundColor();
//                    //row.setRowStyle(cellStyle.);
//                    Iterator<Cell> cellIterator = row.cellIterator();
//                            while(cellIterator.hasNext()) {
//                                    Cell cell = cellIterator.next(); //Fetch CELL
//                                    switch(cell.getCellType()) { //Identify CELL type
//                                            //you need to add more code here based on
//                                            //your requirement / transformations
//                                        case Cell.CELL_TYPE_BLANK:
//                                            //Push the data from Excel to PDF Cell
//                                            table_cell = new PdfPCell(new Phrase(Constantes.EMPTY));
//                                             //feel free to move the code below to suit to your needs
//                                            my_table.addCell(table_cell);
//                                        case Cell.CELL_TYPE_STRING:
//                                            //Push the data from Excel to PDF Cell
//                                            table_cell = new PdfPCell(new Phrase(cell.getStringCellValue()));
//                                             //feel free to move the code below to suit to your needs
//                                            my_table.addCell(table_cell);
//                                            break;
//                                    }
//                                    //next line
//                            }
//
//            }
            //Finally add the table to PDF document
            //iText_pdf.add(my_table);                       
            iText_pdf.close(); 
            return baos;
        }
        catch (Exception ex) {
            throw new GenerationException(ex.getMessage());
        }
    }
    
    private static void copyRow(HSSFWorkbook workbook, HSSFSheet worksheet, int sourceRowNum, int destinationRowNum) {
        // Get the source / new row
        HSSFRow newRow = worksheet.getRow(destinationRowNum);
        HSSFRow sourceRow = worksheet.getRow(sourceRowNum);

        // If the row exist in destination, push down all rows by 1 else create a new row
        if (newRow != null) {
            worksheet.shiftRows(destinationRowNum, worksheet.getLastRowNum(), 1);
        } else {
            newRow = worksheet.createRow(destinationRowNum);
        }

        // Loop through source columns to add to new row
        for (int i = 0; i < sourceRow.getLastCellNum(); i++) {
            // Grab a copy of the old/new cell
            HSSFCell oldCell = sourceRow.getCell(i);
            HSSFCell newCell = newRow.createCell(i);

            // If the old cell is null jump to next cell
            if (oldCell == null) {
                newCell = null;
                continue;
            }

            // Copy style from old cell and apply to new cell
            HSSFCellStyle newCellStyle = workbook.createCellStyle();
            newCellStyle.cloneStyleFrom(oldCell.getCellStyle());
            ;
            newCell.setCellStyle(newCellStyle);

            // If there is a cell comment, copy
            if (oldCell.getCellComment() != null) {
                newCell.setCellComment(oldCell.getCellComment());
            }

            // If there is a cell hyperlink, copy
            if (oldCell.getHyperlink() != null) {
                newCell.setHyperlink(oldCell.getHyperlink());
            }

            // Set the cell data type
            newCell.setCellType(oldCell.getCellType());

            // Set the cell data value
            switch (oldCell.getCellType()) {
                case Cell.CELL_TYPE_BLANK:
                    newCell.setCellValue(oldCell.getStringCellValue());
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                    newCell.setCellValue(oldCell.getBooleanCellValue());
                    break;
                case Cell.CELL_TYPE_ERROR:
                    newCell.setCellErrorValue(oldCell.getErrorCellValue());
                    break;
                case Cell.CELL_TYPE_FORMULA:
                    newCell.setCellFormula(oldCell.getCellFormula());
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    newCell.setCellValue(oldCell.getNumericCellValue());
                    break;
                case Cell.CELL_TYPE_STRING:
                    newCell.setCellValue(oldCell.getRichStringCellValue());
                    break;
            }
        }

        // If there are are any merged regions in the source row, copy to new row
        for (int i = 0; i < worksheet.getNumMergedRegions(); i++) {
            CellRangeAddress cellRangeAddress = worksheet.getMergedRegion(i);
            if (cellRangeAddress.getFirstRow() == sourceRow.getRowNum()) {
                CellRangeAddress newCellRangeAddress = new CellRangeAddress(newRow.getRowNum(),
                        (newRow.getRowNum() +
                                (cellRangeAddress.getLastRow() - cellRangeAddress.getFirstRow()
                                        )),
                        cellRangeAddress.getFirstColumn(),
                        cellRangeAddress.getLastColumn());
                worksheet.addMergedRegion(newCellRangeAddress);
            }
        }
    }

    private Phrase GetPhrase(String fontFamily, float fontSize, int fontStyle, String value) {
        Phrase p = new Phrase(value);
        Font f = new Font();
        f.setFamily(fontFamily);
        f.setSize(fontSize);
        f.setStyle(fontStyle);
        p.setFont(f);
        return p;
    }*/
}
