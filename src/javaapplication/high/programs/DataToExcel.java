/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication.high.programs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hpsf.HPSFException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author nagendrababu.g
 */
public class DataToExcel {
 
    public static void main(String[] args) throws HPSFException {
        try {
            System.out.println("start");
//            DataToExcel dt = new DataToExcel();
//            dt.readBooksFromExcelFile("D://delete/sample.xls");
            
        ArrayList data = new ArrayList();
        ArrayList headers = new ArrayList();

        File file123 = new File("D:\\delete\\sample.xls");
//row headers
        headers.add("Name");
        headers.add("Email");
        headers.add("EN0");
//row values
        for (int i = 0; i <= 5; i++) {
            ArrayList cells = new ArrayList();
            cells.add("NAME" + i);
            cells.add("test_" + i + "@yahoo.com");
            cells.add("ENO" + i);
            data.add(cells);
        }
        
 //row totals       
         ArrayList headTotal = new ArrayList();
        headTotal.add("totals");
        headTotal.add("totals profit");
        headTotal.add("totals share");
        data.add(headTotal);
        
        
        
        
        
        
        ArrayList list = new ArrayList();
        list.add("total");
        list.add("total profit");
        list.add("total share");
        data.add(list);
//
        exportToExcel("Test", headers, data, file123);
        } catch (Exception ex) {
            Logger.getLogger(DataToExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void exportToExcel(String sheetName, ArrayList headers,
            ArrayList data, File outputFile) throws HPSFException {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet(sheetName);

        int rowIdx = 0;
        short cellIdx = 0;

        // Header
        HSSFRow hssfHeader = sheet.createRow(rowIdx);
        HSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
      // row headers iteration
        for (Iterator cells = headers.iterator(); cells.hasNext();) {
            HSSFCell hssfCell = hssfHeader.createCell(cellIdx++);
            hssfCell.setCellStyle(cellStyle);
            hssfCell.setCellValue((String) cells.next());
        }
        // Data values iteration 
        rowIdx = 1;
        for (Iterator rows = data.iterator(); rows.hasNext();) {
            ArrayList row = (ArrayList) rows.next();
            HSSFRow hssfRow = sheet.createRow(rowIdx++);
            cellIdx = 0;
            for (Iterator cells = row.iterator(); cells.hasNext();) {
                HSSFCell hssfCell = hssfRow.createCell(cellIdx++);
                hssfCell.setCellValue((String) cells.next());
            }
        }
        
        
        wb.setSheetName(0, sheetName);
        try {
            FileOutputStream outs = new FileOutputStream(outputFile);
            wb.write(outs);
            outs.close();
        } catch (IOException e) {
            throw new HPSFException(e.getMessage());
        }
System.out.println("end");
    }
    
    
    
    public List<Book> readBooksFromExcelFile(String excelFilePath) throws IOException {
        List<Book> listBooks = null;
        try {
            listBooks = new ArrayList<>();
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = firstSheet.iterator();
            
            while (iterator.hasNext()) {
                Row nextRow = iterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();
                Book aBook = new Book();
                
                while (cellIterator.hasNext()) {
                    Cell nextCell = cellIterator.next();
                    int columnIndex = nextCell.getColumnIndex();
                    switch (columnIndex) {
                        case 1:
                            aBook.setTitle((String) getCellValue(nextCell));
                            break;
                        case 2:
                            aBook.setAuthor((String) getCellValue(nextCell));
                            break;
                        case 3:
                            aBook.setPrice((float) getCellValue(nextCell));
                            break;
                    }
                    
                    
                }
                listBooks.add(aBook);
            }
            
            for (Book book : listBooks) {
                System.out.println(book.getTitle() +"  "+book.getPrice()+"  "+book.getAuthor());
            }
            
            
            inputStream.close();
            
        } catch (InvalidFormatException ex) {
            Logger.getLogger(DataToExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
            return listBooks;
        
}
    
    private Object getCellValue(Cell cell) {
    switch (cell.getCellType()) {
    case Cell.CELL_TYPE_STRING:
        return cell.getStringCellValue();
 
    case Cell.CELL_TYPE_BOOLEAN:
        return cell.getBooleanCellValue();
 
    case Cell.CELL_TYPE_NUMERIC:
        return cell.getNumericCellValue();
    }
 
    return null;
}
    
}

class Book {
    private String title;
    private String author;
    private float price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
 
    public Book() {
    }
 
    public String toString() {
        return String.format("%s - %s - %f", title, author, price);
    }
 
    // getters and setters
}

//poi-3.9.jar poi-ooxml-3.7-20101029.jar xmlbeans-xmlpublic-2.4.0.jar  poi-ooxml-schemas-3.6-20100309.jar dom4j.jar