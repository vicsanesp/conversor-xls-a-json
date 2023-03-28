package pruebas;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class PruebitasChingonas {

	public static void main(String[] args) {
		

        try {
            // Crea un objeto File para leer el archivo Excel
            File file = new File("ficheros/pagricolas2014_web_0.xls");
            FileInputStream inputStream = new FileInputStream(file);

            // Crea un objeto Workbook para representar el archivo Excel
            Workbook workbook = new HSSFWorkbook(inputStream);

            // Obtiene la hoja de trabajo (worksheet) en la posición 0
            Sheet sheet = workbook.getSheetAt(0);

            // Recorre cada fila en la hoja de trabajo
            int i = 1;
            for (int rowIndex = 0; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                // Obtiene la fila actual
                Row row = sheet.getRow(rowIndex);
                if (row != null) {
                	if(row.getCell(0)!=null) {
                		System.out.println(row.getCell(0));
                		i++;
                	}
//                    // Recorre cada celda en la fila
//                    for (int cellIndex = 0; cellIndex < row.getLastCellNum(); cellIndex++) {
//                        // Obtiene el valor de la celda
//                        Cell cell = row.getCell(cellIndex);
//                        if (cell != null) {
//                            System.out.print(cell.toString() + " ");
//                        }
//                    }
//                    System.out.println();
                }
            }
            System.out.println(i);

            // Cierra el archivo de entrada
            inputStream.close();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	

}
