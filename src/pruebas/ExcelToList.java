package pruebas;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelToList {

    public static void main(String[] args) {

        List<Fila> listaFilas = new ArrayList<>();

        try {
            File archivoExcel = new File("ficheros/pagricolas2014_web_0.xls");
            FileInputStream inputStream = new FileInputStream(archivoExcel);

            Workbook workbook = new HSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);

            Iterator<Row> iterator = sheet.iterator();
            while (iterator.hasNext()) {
                Row fila = iterator.next();
                Iterator<Cell> cellIterator = fila.cellIterator();

                Fila objFila = new Fila();

                while (cellIterator.hasNext()) {
                    Cell celda = cellIterator.next();

                    // Dependiendo del tipo de celda, se agrega el valor correspondiente al objeto Fila
                    switch (celda.getCellTypeEnum()) {
                    case STRING:
                        objFila.agregarCelda(celda.getStringCellValue());
                        break;
                    case NUMERIC:
                        objFila.agregarCelda(String.valueOf(celda.getNumericCellValue()));
                        break;
                    case BOOLEAN:
                        objFila.agregarCelda(String.valueOf(celda.getBooleanCellValue()));
                        break;
                    case BLANK:
                        objFila.agregarCelda("");
                        break;
                    default:
                        objFila.agregarCelda("");
                    }
                }
                listaFilas.add(objFila);
            }

            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println(listaFilas.get(3).getCeldas());

        // Ahora, la lista de filas está almacenada en la variable "listaFilas"
    }
}

class Fila {

    private List<String> celdas;

    public Fila() {
        celdas = new ArrayList<>();
    }

    public void agregarCelda(String valor) {
        celdas.add(valor);
    }

    public List<String> getCeldas() {
        return celdas;
    }
}
