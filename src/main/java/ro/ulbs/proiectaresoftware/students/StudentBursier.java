package ro.ulbs.proiectaresoftware.students;

import java.util.Objects;

public class StudentBursier extends Student {
    private double cuantumBursa;

    public StudentBursier(int numarMatricol, String prenume, String nume,
                          String formatieDeStudiu, double nota, double cuantumBursa) {
        super(numarMatricol, prenume, nume, formatieDeStudiu);
        setNota(nota);
        this.cuantumBursa = cuantumBursa;
    }

    public double getCuantumBursa() {
        return cuantumBursa;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" %.2f", cuantumBursa);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof StudentBursier)) {
            return false;
        }

        if (!super.equals(obj)) {
            return false;
        }

        StudentBursier that = (StudentBursier) obj;

        return Double.compare(that.cuantumBursa, cuantumBursa) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cuantumBursa);
    }
}