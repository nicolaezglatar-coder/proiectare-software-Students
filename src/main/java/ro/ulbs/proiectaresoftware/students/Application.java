package ro.ulbs.proiectaresoftware.students;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Student> studenti = citesteStudenti("studenti_in.txt");

        System.out.println("Studenti cititi:");
        for (Student student : studenti) {
            System.out.println(student);
        }

        List<Student> studentiSortatiDupaNume = new ArrayList<>(studenti);
        studentiSortatiDupaNume.sort(Comparator.comparing(Student::getNume));
        scrieStudenti("studenti_out.txt", studentiSortatiDupaNume);

        List<Student> studentiSortatiDupaFormatieSiNume = new ArrayList<>(studenti);
        studentiSortatiDupaFormatieSiNume.sort(
                Comparator.comparing(Student::getFormatieDeStudiu)
                        .thenComparing(Student::getNume)
        );
        scrieStudenti("studenti_out_sorted.txt", studentiSortatiDupaFormatieSiNume);

        System.out.println("Studentii sortati dupa nume au fost salvati in studenti_out.txt");
        System.out.println("Studentii sortati dupa formatie si nume au fost salvati in studenti_out_sorted.txt");
    }

    public static List<Student> citesteStudenti(String numeFisier) {
        List<Student> studenti = new ArrayList<>();

        try {
            List<String> linii = Files.readAllLines(Path.of(numeFisier));

            for (String linie : linii) {
                String[] campuri = linie.split(",");

                int numarMatricol = Integer.parseInt(campuri[0]);
                String prenume = campuri[1];
                String nume = campuri[2];
                String formatieDeStudiu = campuri[3];

                studenti.add(new Student(numarMatricol, prenume, nume, formatieDeStudiu));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return studenti;
    }

    public static void scrieStudenti(String numeFisier, List<Student> studenti) {
        List<String> linii = new ArrayList<>();

        for (Student student : studenti) {
            String linie = student.getNumarMatricol() + ","
                    + student.getPrenume() + ","
                    + student.getNume() + ","
                    + student.getFormatieDeStudiu();

            linii.add(linie);
        }

        try {
            Files.write(Path.of(numeFisier), linii);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}