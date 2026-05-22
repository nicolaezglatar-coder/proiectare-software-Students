package ro.ulbs.proiectaresoftware.students;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<StudentBursier> bursieri = new ArrayList<>();

        bursieri.add(new StudentBursier(1025, "Andrei", "Popa", "ISM141/2", 8.70, 725.50));
        bursieri.add(new StudentBursier(1024, "Ioan", "Mihalcea", "ISM141/1", 9.80, 801.10));
        bursieri.add(new StudentBursier(1026, "Anamaria", "Prodan", "TI131/1", 8.90, 745.50));
        bursieri.add(new StudentBursier(1029, "Bianca", "Popescu", "TI131/1,", 9.10, 780.80));

        salveazaBursieri("bursieri_out.txt", bursieri);

        System.out.println("Lista de bursieri a fost salvata in bursieri_out.txt");
    }

    public static void salveazaBursieri(String numeFisier, List<StudentBursier> bursieri) {
        List<String> linii = new ArrayList<>();

        for (StudentBursier bursier : bursieri) {
            linii.add(bursier.toString());
        }

        try {
            Files.write(Path.of(numeFisier), linii);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}