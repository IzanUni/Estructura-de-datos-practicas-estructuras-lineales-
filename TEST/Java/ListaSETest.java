import PRACTICA1ED.IteradorSE;
import PRACTICA1ED.ListaSE;

import static org.junit.jupiter.api.Assertions.*;

class ListaSETest {

    @org.junit.jupiter.api.Test
    void add() {
        ListaSE<Integer> lista = new ListaSE<>();
        assertTrue(lista.add(1));
        assertTrue(lista.add(2));
        assertTrue(lista.add(3));
        assertEquals(3, lista.getNumElementos());
    }

    @org.junit.jupiter.api.Test
    void delete() {
        ListaSE<String> lista = new ListaSE<>();
        lista.add("A");
        lista.add("B");
        lista.add("C");

        assertTrue(lista.delete("B"));
        assertFalse(lista.delete("X"));
        assertEquals(2, lista.getNumElementos());
    }

    @org.junit.jupiter.api.Test
    void getIterador() {
        ListaSE<Integer> lista = new ListaSE<>();
        lista.add(10);
        lista.add(20);
        lista.add(30);

        IteradorSE<Integer> iterador = lista.getIterador();
        assertTrue(iterador.hasNext());
        assertEquals(10, iterador.next());
        assertTrue(iterador.hasNext());
        assertEquals(20, iterador.next());
        assertTrue(iterador.hasNext());
        assertEquals(30, iterador.next());
        assertFalse(iterador.hasNext());
    }

    @org.junit.jupiter.api.Test
    void getNumElementos() {
        ListaSE<Double> lista = new ListaSE<>();
        assertEquals(0, lista.getNumElementos());

        lista.add(1.1);
        lista.add(2.2);
        lista.add(3.3);
        assertEquals(3, lista.getNumElementos());

        lista.delete(2.2);
        assertEquals(2, lista.getNumElementos());
    }
}
