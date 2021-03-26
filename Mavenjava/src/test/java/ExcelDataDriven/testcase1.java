package ExcelDataDriven;

import java.io.IOException;
import java.util.ArrayList;

public class testcase1 {

	public static void main(String[] args) throws IOException {
            ApachePOI data=new ApachePOI();
          ArrayList array=  data.getData("Login username");
          System.out.println(array.get(0));
          System.out.println(array.get(1));
          System.out.println(array.get(2));
          System.out.println(array.get(3));
	}

}
