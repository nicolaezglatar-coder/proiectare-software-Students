package ro.ulbs.proiectaresoftware.students;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AplicatieCuBursaTest {

    @Test
    public void testSorteaza() {
        AplicatieCuBursa aplicatie = new AplicatieCuBursa();

        List<StudentBursier> lista = aplicatie.genereaza();

        List<StudentBursier> sortata = aplicatie.sorteaza(lista);

        assertEquals("ISM141/1", sortata.get(0).getFormatieDeStudiu());
        assertEquals("Mihalcea", sortata.get(0).getNume());
        assertEquals("Ioan", sortata.get(0).getPrenume());
        assertEquals(9.80, sortata.get(0).getNota(), 0.0001);
        assertEquals(801.10, sortata.get(0).getCuantumBursa(), 0.0001);

        assertEquals("ISM141/2", sortata.get(1).getFormatieDeStudiu());
        assertEquals("Popa", sortata.get(1).getNume());
        assertEquals("Andrei", sortata.get(1).getPrenume());
        assertEquals(8.70, sortata.get(1).getNota(), 0.0001);
        assertEquals(725.50, sortata.get(1).getCuantumBursa(), 0.0001);

        assertEquals("TI131/1", sortata.get(2).getFormatieDeStudiu());
        assertEquals("Prodan", sortata.get(2).getNume());
        assertEquals("Anamaria", sortata.get(2).getPrenume());
        assertEquals(8.90, sortata.get(2).getNota(), 0.0001);
        assertEquals(745.50, sortata.get(2).getCuantumBursa(), 0.0001);

        assertEquals("TI131/1,", sortata.get(3).getFormatieDeStudiu());
        assertEquals("Popescu", sortata.get(3).getNume());
        assertEquals("Bianca", sortata.get(3).getPrenume());
        assertEquals(9.10, sortata.get(3).getNota(), 0.0001);
        assertEquals(100.00, sortata.get(3).getCuantumBursa(), 0.0001);

        assertEquals("TI131/1,", sortata.get(4).getFormatieDeStudiu());
        assertEquals("Popescu", sortata.get(4).getNume());
        assertEquals("Bianca", sortata.get(4).getPrenume());
        assertEquals(9.10, sortata.get(4).getNota(), 0.0001);
        assertEquals(780.80, sortata.get(4).getCuantumBursa(), 0.0001);
    }
}