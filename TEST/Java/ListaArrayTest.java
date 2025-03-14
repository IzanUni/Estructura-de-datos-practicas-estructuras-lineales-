import PRACTICA1ED.Iterador;
import PRACTICA1ED.ListaArray;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ListaArrayTest {

    @Test
    void add() {
        ListaArray<Integer> lista = new ListaArray<>(2);
        assertTrue(lista.add(1));
        assertTrue(lista.add(2));

        // Verifica que se expanda correctamente el array
        assertTrue(lista.add(3));

        // Verifica que el tamaño de la lista sea correcto después de la expansión
        assertEquals(3, lista.getNumElementos());
    }

    @Test
    void delete() {
        ListaArray<String> lista = new ListaArray<>(3);
        lista.add("A");
        lista.add("B");
        lista.add("C");

        // Elimina un elemento y verifica
        assertTrue(lista.delete("B"));
        assertFalse(lista.delete("X")); // No existe en la lista

        // Verifica que el número de elementos es correcto
        assertEquals(2, lista.getNumElementos());

        // Verifica el contenido de la lista después de eliminar
        assertFalse(lista.delete("B")); // "B" ya no existe
    }

    @Test
    void getIterador() {
        ListaArray<Integer> lista = new ListaArray<>(3);
        lista.add(10);
        lista.add(20);
        lista.add(30);

        // Obtenemos el iterador
        Iterador<Integer> iterador = lista.getIterador();

        assertTrue(iterador.hasNext());
        assertEquals(10, iterador.next());

        assertTrue(iterador.hasNext());
        assertEquals(20, iterador.next());

        assertTrue(iterador.hasNext());
        assertEquals(30, iterador.next());

        assertFalse(iterador.hasNext());
    }

    @Test
    void getNumElementos() {
        ListaArray<Double> lista = new ListaArray<>(2);

        // Verifica el número de elementos antes de agregar
        assertEquals(0, lista.getNumElementos());

        // Agrega algunos elementos
        lista.add(1.1);
        lista.add(2.2);
        lista.add(3.3);

        // Verifica que el número de elementos sea correcto
        assertEquals(3, lista.getNumElementos());

        // Elimina un elemento y verifica
        lista.delete(3.3);
        assertEquals(2, lista.getNumElementos());
    }
}