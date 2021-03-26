package ExcelDataDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Apache {
	
	int k=0;
	int column=0;
	public ArrayList demo(String testcase) throws IOException {
		ArrayList al=new ArrayList();
		FileInputStream input = new FileInputStream("C:\\Users\\User\\DemoData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(input);
		int sheets = wb.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			if (wb.getSheetName(i).equalsIgnoreCase("sheet1")) {
				XSSFSheet sheet = wb.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
				Row cells = rows.next();
				Iterator<Cell> cell = cells.cellIterator();
				while (cell.hasNext()) {
					Cell value = cell.next();
					if (value.getStringCellValue().equalsIgnoreCase("testcase"))
					{
                         column=k;
					}
					k++;
				}
				while(rows.hasNext())
				{
					Row r=rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcase))
					{
						Iterator<Cell>c=r.cellIterator();
						while(c.hasNext())
						{
							al.add(c.next().getStringCellValue());
						}
					}
				}
			}

		}
		return al;
	}

	public static void main(String[] args) throws IOException {
        Apache apach=new Apache();
        ArrayList arr=apach.demo("Payment");
        System.out.println(arr.get(0));
        System.out.println(arr.get(1));
        System.out.println(arr.get(2));
        
	}

}
