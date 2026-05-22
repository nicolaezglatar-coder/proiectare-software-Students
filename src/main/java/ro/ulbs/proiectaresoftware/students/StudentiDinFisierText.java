package ro.ulbs.proiectaresoftware.students;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StudentiDinFisierText implements IStudentiImport {
    private String fileName;

    public StudentiDinFisierText(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Student> doImport() {
        List<Student> studenti = new ArrayList<>();

        try {
            List<String> linii = Files.readAllLines(Path.of(fileName));

            for (String linie : linii) {
                String[] campuri = linie.split(";");

                int numarMatricol = Integer.parseInt(campuri[0]);
                String prenume = campuri[1];
                String nume = campuri[2];
                String formatie = campuri[3];
                double nota = Double.parseDouble(campuri[4]);

                studenti.add(new Student(numarMatricol, prenume, nume, formatie, nota));
            }

            System.out.println("Studentii au fost cititi din fisierul text: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return studenti;
    }
}