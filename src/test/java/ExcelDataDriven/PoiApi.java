package ExcelDataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PoiApi {
public ArrayList Data(String testcase) throws IOException
{
	ArrayList al=new ArrayList();
	int k=0;
	int column=0;
	FileInputStream input=new FileInputStream("C:\\Users\\User\\testdata.xlsx");
	XSSFWorkbook wb=new XSSFWorkbook(input);
	int sheets=wb.getNumberOfSheets();
	for(int i=0;i<sheets;i++)
	{
		if(wb.getSheetName(i).equalsIgnoreCase("data1"))
		{
			XSSFSheet sheet=wb.getSheetAt(i);
			Iterator<Row> rows=sheet.iterator();
			Row cells=rows.next();
			Iterator<Cell>cell=cells.cellIterator();
			while(cell.hasNext())
			{
				Cell value=cell.next();
				if(value.getStringCellValue().equalsIgnoreCase("testcaseid"))
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
						Cell ce=c.next();
						if(ce.getCellType()==CellType.STRING)
						{
							al.add(ce.getStringCellValue());
						}
						else
						{
							al.add(NumberToTextConverter.toText(ce.getNumericCellValue()));
						}
				}
				}
				
			}
			}
	}
	return al;
}
	public static void main(String[] args) throws IOException {
		PoiApi poi=new PoiApi();
		ArrayList array=poi.Data("TC_001");
		System.out.println(array.get(0));
		System.out.println(array.get(1));
		System.out.println(array.get(2));
	}

}
