package ro.ulbs.proiectaresoftware.students;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ApplicationLab9Students {
    public static void main(String[] args) {
        List<Student> studentiCuNote = Arrays.asList(
                new Student(1025, "Andrei", "Popa", "ISM141/2", 8.70),
                new Student(1024, "Ioan", "Mihalcea", "ISM141/1", 10),
                new Student(1026, "Anamaria", "Prodan", "TI131/1", 8.90),
                new Student(1029, "Bianca", "Popescu", "TI131/1,", 10),
                new Student(1029, "Maria", "Pana", "TI131/2,", 4.10),
                new Student(1029, "Gabriela", "Mohanu", "TI131/2,", 7.33),
                new Student(1029, "Marius", "Nasta", "TI131/2,", 3.20),
                new Student(1029, "Marius", "Nasta", "TI131/1,", 5.12),
                new Student(1029, "Andrei", "Dobrescu", "TI131/2,", 2.22)
        );

        System.out.println("a) Studentii cu nota 10:");
        studentiCuNote.stream()
                .filter(student -> student.getNota() == 10)
                .forEach(System.out::println);

        System.out.println();

        System.out.println("b) Studentii cu nota sub 5:");
        studentiCuNote.stream()
                .filter(student -> student.getNota() < 5)
                .forEach(System.out::println);

        System.out.println();

        System.out.println("c) Lista transformata, studentii cu nota < 4 devin studenti cu nota 4:");
        List<Student> studentiCorectati = studentiCuNote.stream()
                .map(student -> {
                    if (student.getNota() < 4) {
                        return new Student(
                                student.getNumarMatricol(),
                                student.getPrenume(),
                                student.getNume(),
                                student.getFormatieDeStudiu(),
                                4
                        );
                    }

                    return student;
                })
                .collect(Collectors.toList());

        studentiCorectati.forEach(System.out::println);

        System.out.println();

        double sumaNotelor = studentiCuNote.stream()
                .map(Student::getNota)
                .reduce(0.0, Double::sum);

        System.out.println("d) Suma notelor: " + sumaNotelor);

        double mediaNotelor = sumaNotelor / studentiCuNote.size();

        System.out.println("e) Media notelor: " + mediaNotelor);
    }
}