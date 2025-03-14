import PRACTICA1ED.Cola;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColaTest {

    @Test
    void enqueue() {
        Cola<Integer> cola = new Cola<>();
        cola.enqueue(1);
        cola.enqueue(2);
        cola.enqueue(3);

        assertEquals(1, cola.dequeue());
        assertEquals(2, cola.dequeue());
        assertEquals(3, cola.dequeue());
    }

    @Test
    void dequeue() {
        Cola<String> cola = new Cola<>();
        cola.enqueue("X");
        cola.enqueue("Y");
        cola.enqueue("Z");

        assertEquals("X", cola.dequeue());
        assertEquals("Y", cola.dequeue());
        assertEquals("Z", cola.dequeue());

        assertNull(cola.dequeue());
    }
}
