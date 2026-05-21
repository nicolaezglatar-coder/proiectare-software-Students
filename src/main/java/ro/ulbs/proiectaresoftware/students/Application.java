package ro.ulbs.proiectaresoftware.students;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        HashMap<Integer, Student> studenti = citesteStudenti("studenti_in.txt");

        citesteNote("note_anon.txt", studenti);

        System.out.println("Studenti cu note:");

        for (Map.Entry<Integer, Student> entry : studenti.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public static HashMap<Integer, Student> citesteStudenti(String numeFisier) {
        HashMap<Integer, Student> studenti = new HashMap<>();

        try {
            List<String> linii = Files.readAllLines(Path.of(numeFisier));

            for (String linie : linii) {
                String[] campuri = linie.split(",");

                int numarMatricol = Integer.parseInt(campuri[0]);
                String prenume = campuri[1];
                String nume = campuri[2];
                String formatieDeStudiu = campuri[3];

                Student student = new Student(numarMatricol, prenume, nume, formatieDeStudiu);

                studenti.put(numarMatricol, student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return studenti;
    }

    public static void citesteNote(String numeFisier, HashMap<Integer, Student> studenti) {
        try {
            List<String> linii = Files.readAllLines(Path.of(numeFisier));

            for (String linie : linii) {
                String[] campuri = linie.split(",");

                int numarMatricol = Integer.parseInt(campuri[0]);
                double nota = Double.parseDouble(campuri[1]);

                Student student = studenti.get(numarMatricol);

                if (student != null) {
                    student.setNota(nota);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}