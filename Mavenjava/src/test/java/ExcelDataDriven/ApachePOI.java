package ExcelDataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ApachePOI {

	
		public ArrayList getData(String testcasename) throws IOException
		{
			ArrayList al=new ArrayList();
			int k=0;
			int column=0;
	        FileInputStream input=new FileInputStream("C:\\Users\\User\\testcasedata.xlsx");
			XSSFWorkbook wb=new XSSFWorkbook(input);
			int sheets=wb.getNumberOfSheets();
			for(int i=0;i<sheets;i++)
			{
				if(wb.getSheetName(i).equalsIgnoreCase("sheet1"))
				{
					XSSFSheet sheet=wb.getSheetAt(i);
					Iterator<Row> rows=sheet.iterator();
					Row firstrow=rows.next();
					Iterator<Cell>cells=firstrow.cellIterator();
					while(cells.hasNext())
					{
						Cell value=cells.next();
						if(value.getStringCellValue().equalsIgnoreCase("testcases"))
						{
							column=k;
						}k++;
					}
					System.out.println(column);
					
					while(rows.hasNext())
					{
						Row r=rows.next();
						if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcasename))
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

		public static void main(String[] args)  {

		}
	}
	