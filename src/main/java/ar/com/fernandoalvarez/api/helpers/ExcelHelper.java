package ar.com.fernandoalvarez.api.helpers;

import ar.com.fernandoalvarez.api.model.Usuario;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;

public class ExcelHelper {

    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    public static ByteArrayInputStream exportarUsuarios(List<Usuario> usuarios) {

        String[] HEADERs = {"ID", "NOMBRE", "APELLIDO", "DNI", "EDAD", "TELEFONO",
                "MAIL", "DIRECCION", "PAIS", "PROVINCIA", "LOCALIDAD", "FECHA_NACIMIENTO", "FECHA_INSCRIPCION"};
        String SHEET = "Usuarios";

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            Sheet sheet = workbook.createSheet(SHEET);
            // Header
            Row headerRow = sheet.createRow(0);
            for (int col = 0; col < HEADERs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(HEADERs[col]);
            }
            DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            int rowIdx = 1;
            for (Usuario usuario : usuarios) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(usuario.getId());
                row.createCell(1).setCellValue(usuario.getNombre());
                row.createCell(2).setCellValue(usuario.getApellido());
                row.createCell(3).setCellValue(usuario.getDni());
                row.createCell(4).setCellValue(usuario.getEdad());
                row.createCell(5).setCellValue(usuario.getTelefono());
                row.createCell(6).setCellValue(usuario.getMail());
                row.createCell(7).setCellValue(usuario.getDireccion());
                row.createCell(8).setCellValue(usuario.getPais());
                row.createCell(9).setCellValue(usuario.getProvincia());
                row.createCell(10).setCellValue(usuario.getLocalidad());
                row.createCell(11).setCellValue(usuario.getFechaNacimiento().format(formatoFecha));
                row.createCell(12).setCellValue(usuario.getFechaInscripcion().format(formatoFecha));
            }
            for (int i = 0; i <= sheet.getRow(0).getLastCellNum(); i++) {
                sheet.autoSizeColumn(i);
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("Error al crear Excel: " + e.getMessage());
        }

    }

}
