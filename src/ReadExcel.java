import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException {
		String excelFilepath = ".\\DataFi\\deep.xlsx";

		FileInputStream file = new FileInputStream(excelFilepath);

		XSSFWorkbook workbook = new XSSFWorkbook(file);

		// XSSFSheet sheet = workbook.getSheet("Sheet1");

		XSSFSheet sheet = workbook.getSheetAt(0);

		/// USING FOR LOOP

		int rows = sheet.getLastRowNum(); // 2

		int cols = sheet.getRow(1).getLastCellNum(); // 2

		for (int r = 0; r <= rows; r++) {

			XSSFRow row = sheet.getRow(r);

			for (int c = 0; c < cols; c++) {
				XSSFCell cell = row.getCell(c);

				switch (cell.getCellType()) {
				case STRING:
					System.out.println(cell.getStringCellValue());
					break;
				case NUMERIC:
					System.out.println(cell.getNumericCellValue());
					break;
				case BOOLEAN:
					System.out.println(cell.getBooleanCellValue());
					break;
				}
			}
			System.out.println();
		}

	}

}
