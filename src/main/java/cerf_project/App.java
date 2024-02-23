package cerf_project;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Hello world!
 *
 */
public class App {

    private static Cell event;
    private static Workbook wbCopy;
    private static OutputStream fileOut;

    public static void main(String[] args) throws FileNotFoundException, IOException {
        GUI gui = new GUI();
        /*
         * Workbook wb = new XSSFWorkbook();
         * Sheet sh = wb.createSheet("hi");
         * try (OutputStream fileOut = new FileOutputStream("workbook.xlsx")) {
         * wb.write(fileOut);
         * }
         * wb.close();
         */

        // Creates a copy of the CERF template
        Workbook wb = new XSSFWorkbook("CERFTemplate.xlsx");
        fileOut = new FileOutputStream("workbook.xlsx");
        wb.write(fileOut);
        wb.close();

        System.out.println("reached");
        wbCopy = new XSSFWorkbook("workbook.xlsx");
        //Row row = eventInfo.getRow(23);
        //event = row.getCell(1);
        //System.out.println("At this cell " + event.getStringCellValue());
        //event.setCellValue("testing!");

        // Event Name
        editCell(2, 23, 1, "editCell test");

        wbCopy.write(fileOut);
        //wbCopy.close();
        System.out.println("does it reach this");
    }

    // public static boolean changeEvent(String nameEvent) {
    //     event.setCellValue(nameEvent);
    //     return true;
    // }

    public static boolean saveWb() throws IOException {
        // MAKE SURE THE FORMULAS WORK !!!!!!!!!!!!!!!!! ****
        XSSFFormulaEvaluator.evaluateAllFormulaCells(wbCopy);
        wbCopy.write(fileOut);
        return true;
    }

    // public static void getEvent() {
    //     System.out.println(event.getStringCellValue());
    // }

    public static void closeWb() throws IOException {
        wbCopy.close();
    }

    public static void editCell(int sheet, int row, int col, String value) {
        Sheet tempSheet = wbCopy.getSheetAt(sheet);
        Row tempRow = tempSheet.getRow(row);
        Cell tempEvent = tempRow.getCell(col);
        tempEvent.setCellValue(value);
    }

}
