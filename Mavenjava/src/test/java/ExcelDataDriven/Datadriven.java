package ExcelDataDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datadriven {
	public ArrayList Login(String testcase) throws IOException {
		ArrayList al = new ArrayList();
		int k = 0;
		int column = 0;
		FileInputStream input = new FileInputStream("C:\\Users\\User\\Data.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(input);
		int sheets = wb.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			if (wb.getSheetName(i).equalsIgnoreCase("Logindata")) {
				XSSFSheet sheet = wb.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
				Row cells = rows.next();
				Iterator<Cell> cell = cells.cellIterator();
				while (cell.hasNext()) {
					Cell v = cell.next();
					if (v.getStringCellValue().equalsIgnoreCase("testcaseid")) {
						column = k;
					}
					k++;
				}
				System.out.println(column);
				while (rows.hasNext()) {
					Row r = rows.next();
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testcase)) {
						Iterator<Cell> c = r.cellIterator();
						while (c.hasNext()) {
							al.add(c.next().getStringCellValue());
						}
					}
				}
			}
		}
		return al;
	}

	public static void main(String[] args) throws IOException {
		Datadriven dd = new Datadriven();
		ArrayList arr = dd.Login("TestCaseID");
		System.out.println(arr.get(0));
		System.out.println(arr.get(1));

	}

}
