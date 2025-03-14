import PRACTICA1ED.Pila;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PilaTest {

    @Test
    void push() {
        Pila<Integer> pila = new Pila<>();
        pila.push(10);
        pila.push(20);

        // Verificamos que el último elemento añadido sea 20
        assertEquals(20, pila.pop());
        assertEquals(10, pila.pop());
    }

    @Test
    void pop() {
        Pila<String> pila = new Pila<>();
        pila.push("A");
        pila.push("B");
        pila.push("C");

        assertEquals("C", pila.pop());
        assertEquals("B", pila.pop());
        assertEquals("A", pila.pop());

        assertNull(pila.pop());
    }
}
