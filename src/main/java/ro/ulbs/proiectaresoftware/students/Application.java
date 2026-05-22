package ro.ulbs.proiectaresoftware.students;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Student> studenti = new ArrayList<>();

        studenti.add(new Student(1027, "Paul", "Mohanu", "TI132/1"));
        studenti.add(new Student(1028, "Mihai", "Ionescu", "TI132/1"));
        studenti.add(new Student(1025, "Andrei", "Popa", "ISM141/2"));
        studenti.add(new Student(1024, "Ioan", "Mihalcea", "ISM141/1"));
        studenti.add(new Student(1026, "Anamaria", "Prodan", "TI131/1"));
        studenti.add(new Student(1029, "Bianca", "Popescu", "TI131/1"));

        studenti.get(0).setNota(5.40);
        studenti.get(1).setNota(6.20);
        studenti.get(2).setNota(8.70);
        studenti.get(3).setNota(9.80);
        studenti.get(4).setNota(8.90);
        studenti.get(5).setNota(9.10);

        exportaStudenti("laborator8_students.xls", studenti);

        List<Student> studentiCititi = citesteStudentiDinExcel("laborator8_students.xls");

        System.out.println("Studenti cititi din Excel:");
        for (Student student : studentiCititi) {
            System.out.println(student);
        }
    }

    public static void exportaStudenti(String numeFisier, List<Student> studenti) {
        try (Workbook workbook = new HSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Studenti");

            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Numar matricol");
            header.createCell(1).setCellValue("Prenume");
            header.createCell(2).setCellValue("Nume");
            header.createCell(3).setCellValue("Formatie");
            header.createCell(4).setCellValue("Nota");

            int rowIndex = 1;

            for (Student student : studenti) {
                Row row = sheet.createRow(rowIndex);

                row.createCell(0).setCellValue(student.getNumarMatricol());
                row.createCell(1).setCellValue(student.getPrenume());
                row.createCell(2).setCellValue(student.getNume());
                row.createCell(3).setCellValue(student.getFormatieDeStudiu());
                row.createCell(4).setCellValue(student.getNota());

                rowIndex++;
            }

            for (int i = 0; i < 5; i++) {
                sheet.autoSizeColumn(i);
            }

            try (FileOutputStream outputStream = new FileOutputStream(numeFisier)) {
                workbook.write(outputStream);
            }

            System.out.println("Fisierul " + numeFisier + " a fost creat.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> citesteStudentiDinExcel(String numeFisier) {
        List<Student> studenti = new ArrayList<>();

        try (
                FileInputStream inputStream = new FileInputStream(numeFisier);
                Workbook workbook = new HSSFWorkbook(inputStream)
        ) {
            Sheet sheet = workbook.getSheetAt(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                if (row != null) {
                    int numarMatricol = (int) row.getCell(0).getNumericCellValue();
                    String prenume = row.getCell(1).getStringCellValue();
                    String nume = row.getCell(2).getStringCellValue();
                    String formatie = row.getCell(3).getStringCellValue();
                    double nota = row.getCell(4).getNumericCellValue();

                    Student student = new Student(numarMatricol, prenume, nume, formatie);
                    student.setNota(nota);

                    studenti.add(student);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return studenti;
    }
}