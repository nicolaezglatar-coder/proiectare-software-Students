package ro.ulbs.proiectaresoftware.students;

import ro.ulbs.proiectaresoftware.students.decorator.TimeExecutionDecorator;

import java.util.Arrays;
import java.util.List;

public class AplicatieCuDecorator {
    public static void main(String[] args) {

        List<Student> studentiCuNote = Arrays.asList(
                new Student(1025, "Andrei", "Popa", "ISM141/2", 8.70),
                new Student(1024, "Ioan", "Mihalcea", "ISM141/1", 10.00),
                new Student(1026, "Anamaria", "Prodan", "TI131/1", 8.90),
                new Student(1029, "Bianca", "Popescu", "TI131/1", 10.00),
                new Student(1029, "Maria", "Pana", "TI131/1", 4.10),
                new Student(1029, "Gabriela", "Mohanu", "TI131/2", 7.33),
                new Student(1029, "Marius", "Nasta", "TI131/2", 3.20),
                new Student(1029, "Marius", "Nasta", "TI131/1", 5.12),
                new Student(1029, "Andrei", "Dobrescu", "TI131/2", 2.22)
        );

        List<IStudentiExport> strategii = Arrays.asList(
                new StudentiInConsola(),
                new StudentiInFisierText("studentiStrategyText.txt"),
                new StudentiInFisierXlsx("studentiStrategyExcel.xlsx")
        );

        for (IStudentiExport strategie : strategii) {
            TimeExecutionDecorator decorator = new TimeExecutionDecorator(strategie);
            decorator.executionTime(studentiCuNote);
        }
    }
}