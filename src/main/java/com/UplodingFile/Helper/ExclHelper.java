package com.UplodingFile.Helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.UplodingFile.Entity.Employee;

public class ExclHelper {

		public static boolean checkExcelFormat(MultipartFile file) {
			
			
			String contentType=file.getContentType();
			if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		public static List<Employee> ConvertExcelToListOfEmployee(InputStream is)
		{
			List <Employee> li=new ArrayList<>();
			
			try {
				
				XSSFWorkbook  workbook=	new XSSFWorkbook(is);
				
				XSSFSheet sheet=workbook.getSheet("data");
				
				int rowNum=0;
				Iterator<Row> i=sheet.iterator();
				
				while(i.hasNext()) {
					Row r=i.next();
					
					if(rowNum==0) {
						rowNum++;
						continue;
					}
					
					Iterator<Cell> cell=r.iterator();
					
					int cid=0;
					Employee e=new Employee();
					
					while(cell.hasNext()) {
						Cell c=cell.next();
						
						switch(cid) {
						
						case 0:
							e.setInvoiceNo((int) c.getNumericCellValue());
							break;
						case 1:
							e.setEmpname(c.getStringCellValue());
							break;
						case 2:
							e.setEmpaddress(c.getStringCellValue());
							break;
						case 3:
							e.setEmprole( c.getStringCellValue());
							break;
						default:
							break;
						}
						
						cid++;
					}
					li.add(e);
				}
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			return li;
		}
	
}
