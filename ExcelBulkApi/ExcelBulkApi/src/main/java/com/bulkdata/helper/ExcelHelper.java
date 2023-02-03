package com.bulkdata.helper;

import com.bulkdata.entity.Employee;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {

    //it checks is in xl format or not
    public static boolean checkExcelFormat(MultipartFile file) {

        String contentType = file.getContentType();

        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return true;
        } else {
            return false;
        }
    }

    //convert excel to list
    public static List<Employee> convertExcelToListOfProduct(InputStream


                                                                     is) {
        List<Employee> list = new ArrayList<>();
        try {

          XSSFWorkbook workbook =  new XSSFWorkbook(is);

          XSSFSheet sheet = workbook.getSheet("data");

          int rowNumber=0;
        Iterator<Row>  iterator = sheet.iterator();
        while (iterator.hasNext())
        {
            Row row = iterator.next();
            if(rowNumber==0){
                rowNumber++;
                continue;
            }
            Iterator<Cell> cells = row.iterator();

            int cid=0;

            Employee emp =    new Employee();
            while (cells.hasNext())
            {
                Cell cell = cells.next();

                switch (cid)
                {
                    case 0:
                        emp.setEmployeid((int)cell.getNumericCellValue());
                        break;
                    case 1:
                        emp.setEmployeeName(cell.getStringCellValue());
                        break;
                    case 2:
                        emp.setEmployeeCabin(cell.getStringCellValue());
                        break;
                    case 3:
                        emp.setDesignation(cell.getStringCellValue());
                        break;
                    case 4:
                        emp.setPhoneNumber((long) cell.getNumericCellValue());
                        break;
                    case 5:
                        emp.setBranch(cell.getStringCellValue());
                    default:
                        break;
                }
                cid++;

            }
                list.add(emp);
        }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

