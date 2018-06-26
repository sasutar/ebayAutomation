package Automation;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataAccess {
	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static String value;

	public static String getCelldata(String sheetname, int rownum, int colnum) throws IOException {
		try {

			if (rownum <= 0)
				return "";

			int index = wb.getSheetIndex(sheetname);

			if (index == -1)
				return "";

			sheet = wb.getSheetAt(index);
			row = sheet.getRow(rownum - 1);
			if (row == null)
				return "";

			cell = row.getCell(colnum);
			if (cell == null)
				return "";

			if (cell.getCellType() == Cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {

				String cellText = String.valueOf(cell.getNumericCellValue());
				return cellText;

			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		} catch (Exception e) {

			e.printStackTrace();
			return "row " + rownum + " or column " + colnum + " does not exist in xls";
		}

	}

	public static String setCelldata(int rownum, int col, String str) throws IOException {
		fis = new FileInputStream("C:\\Projects\\sasutarRepository\\ebay\\src\\TestData.xlsx");

		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet("eBay");
		row = sheet.getRow(2);
		cell = row.getCell(2);
		cell.setCellValue(str);
		return cell.getStringCellValue();

	}

	@DataProvider
	public Object[][] getData() throws IOException {

		fis = new FileInputStream("C:\\Projects\\sasutarRepository\\ebay\\src\\TestData.xlsx");

		wb = new XSSFWorkbook(fis);
		// Read sheet inside the workbook by its name
		sheet = wb.getSheet("eBay");
		// Find number of rows in excel file
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum() + 1;
		int colCount = sheet.getRow(0).getLastCellNum();
		System.out.println("Row Count is: " + rowCount + "*** Columsn count is: " + colCount);

		Object data[][] = new Object[rowCount - 1][colCount - 1];

		for (int rNum = 2; rNum <= rowCount; rNum++) {
			for (int cNum = 0; cNum < colCount; cNum++) {
				System.out.println(getCelldata("eBay", cNum, rNum) + " ");
				data[rNum - 2][cNum] = getCelldata("eBay", cNum, rNum);
			}

		}

		return data;
	}

}
