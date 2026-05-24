package ro.ulbs.proiectaresoftware.students.decorator;

import ro.ulbs.proiectaresoftware.students.IStudentiExport;
import ro.ulbs.proiectaresoftware.students.Student;

import java.util.List;

public class TimeExecution implements ITimeExecution {
    protected IStudentiExport exporter;

    public TimeExecution(IStudentiExport exporter) {
        this.exporter = exporter;
    }

    @Override
    public long executionTime(List<Student> studenti) {
        long startTime = System.currentTimeMillis();

        exporter.doExport(studenti);

        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }
}