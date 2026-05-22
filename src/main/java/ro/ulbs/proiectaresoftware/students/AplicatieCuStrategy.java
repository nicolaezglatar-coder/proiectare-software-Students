package ro.ulbs.proiectaresoftware.students;

import java.util.Arrays;
import java.util.List;

public class AplicatieCuStrategy {
    public static void main(String[] args) {
        List<Student> studenti = Arrays.asList(
                new Student(1025, "Andrei", "Popa", "ISM141/2", 8.70),
                new Student(1024, "Ioan", "Mihalcea", "ISM141/1", 10),
                new Student(1026, "Anamaria", "Prodan", "TI131/1", 8.90),
                new Student(1029, "Bianca", "Popescu", "TI131/1", 10),
                new Student(1029, "Maria", "Pana", "TI131/,", 4.10),
                new Student(1029, "Gabriela", "Mohanu", "TI131/2", 7.33),
                new Student(1029, "Marius", "Nasta", "TI131/2", 3.20),
                new Student(1029, "Marius", "Nasta", "TI131/1", 5.12),
                new Student(1029, "Andrei", "Dobrescu", "TI131/2", 2.22)
        );

        Exporter exporter = new Exporter();

        IStudentiExport strategyConsola = new StudentiInConsola();
        exporter.startExport(strategyConsola, studenti);

        System.out.println("----------------------------------------");

        IStudentiExport strategyFisierText = new StudentiInFisierText("studentiStrategyText.txt");
        exporter.startExport(strategyFisierText, studenti);

        IStudentiExport strategyFisierXlsx = new StudentiInFisierXlsx("studentiStrategyExcel.xlsx");
        exporter.startExport(strategyFisierXlsx, studenti);

        System.out.println("----------------------------------------");

        Importer importer = new Importer();

        IStudentiImport strategyCitireText = new StudentiDinFisierText("studentiStrategyText.txt");
        List<Student> studentiDinText = importer.startImport(strategyCitireText);

        System.out.println("Studenti cititi din TXT:");
        exporter.startExport(strategyConsola, studentiDinText);

        System.out.println("----------------------------------------");

        IStudentiImport strategyCitireXlsx = new StudentiDinFisierXlsx("studentiStrategyExcel.xlsx");
        List<Student> studentiDinXlsx = importer.startImport(strategyCitireXlsx);

        System.out.println("Studenti cititi din XLSX:");
        exporter.startExport(strategyConsola, studentiDinXlsx);
    }
}
