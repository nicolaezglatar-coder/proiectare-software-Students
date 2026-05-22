package ro.ulbs.proiectaresoftware.students;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class StudentiInFisierText implements IStudentiExport {
    private String fileName;

    public StudentiInFisierText(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void doExport(List<Student> studenti) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Student student : studenti) {
                writer.println(student.getNumarMatricol() + ";"
                        + student.getPrenume() + ";"
                        + student.getNume() + ";"
                        + student.getFormatieDeStudiu() + ";"
                        + student.getNota());
            }

            System.out.println("Studentii au fost exportati in fisierul text: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}