import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	public static void main(String[] args) throws IOException {

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("empdata");

		Object data[][] = { { "empid", "name", "job" }, { 101, "abhi", "testing" }, { 102, "lava", "mobiletesting" },
				{ 103, "mava", "maragebroker" }

		};

		int rows = data.length;
		int cols = data[0].length;

		for (int r = 0; r < rows; r++) {

			XSSFRow row = sheet.createRow(r);

			for (int c = 0; c < cols; c++) {

				XSSFCell cell = row.createCell(c);
				Object value = data[r][c];

				if (value instanceof String)
					cell.setCellValue((String) value);
				if (value instanceof Integer)
					cell.setCellValue((Integer) value);
				if (value instanceof Boolean)
					cell.setCellValue((Boolean) value);

			}
		}

		String filepath = ".\\DataFi\\deep.xlsx";

		FileOutputStream stream = new FileOutputStream(filepath);
		workbook.write(stream);

		stream.close();

		System.out.println("employe file added sucessfully");
	}

}
