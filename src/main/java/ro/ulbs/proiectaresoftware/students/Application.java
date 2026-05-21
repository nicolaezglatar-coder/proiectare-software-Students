package ro.ulbs.proiectaresoftware.students;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Student> studenti = new ArrayList<>();

        studenti.add(new Student(112, "Ioan", "Popa", "TI21/1"));
        studenti.add(new Student(112, "Maria", "Oprea", "TI21/1"));
        studenti.add(new Student(120, "Alis", "Popa", "TI21/2"));
        studenti.add(new Student(122, "Mihai", "Vecerdea", "TI22/1"));
        studenti.add(new Student(122, "Eugen", "Uritescu", "TI22/2"));

        System.out.println("Lista studenti:");

        for (Student student : studenti) {
            System.out.println(student);
        }

        Student studentCautat1 = new Student(120, "Alis", "Popa", "TI21/2");
        Student studentCautat2 = new Student(112, "Maria", "Popa", "TI21/1");

        System.out.println();
        System.out.println("Exista studentul Alis Popa TI21/2? "
                + existaStudent(studenti, studentCautat1));

        System.out.println("Exista studentul Maria Popa TI21/1? "
                + existaStudent(studenti, studentCautat2));
    }

    public static boolean existaStudent(List<Student> studenti, Student studentCautat) {
        for (Student student : studenti) {
            if (student.getPrenume().equals(studentCautat.getPrenume())
                    && student.getNume().equals(studentCautat.getNume())
                    && student.getFormatieDeStudiu().equals(studentCautat.getFormatieDeStudiu())) {
                return true;
            }
        }

        return false;
    }
}