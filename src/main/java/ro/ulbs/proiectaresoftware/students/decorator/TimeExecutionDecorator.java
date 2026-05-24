package ro.ulbs.proiectaresoftware.students.decorator;

import ro.ulbs.proiectaresoftware.students.IStudentiExport;
import ro.ulbs.proiectaresoftware.students.Student;

import java.util.List;

public class TimeExecutionDecorator extends TimeExecution {

    public TimeExecutionDecorator(IStudentiExport exporter) {
        super(exporter);
    }

    @Override
    public long executionTime(List<Student> studenti) {
        long time = super.executionTime(studenti);

        System.out.println("Timp executie pentru "
                + exporter.getClass().getSimpleName()
                + ": " + time + " ms");

        return time;
    }
}