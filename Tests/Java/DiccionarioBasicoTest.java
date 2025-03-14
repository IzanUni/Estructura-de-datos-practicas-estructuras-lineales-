import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DiccionarioBasicoTest {

    @Test
    void testDiccionario() {
        Diccionario<String, Integer> diccionario = new DiccionarioOrdenado<>();
        diccionario.add("a", 1);
        diccionario.add("b", 2);
        diccionario.delete("a");
        Iterador<ElementoDiccionario<String, Integer>> iterador = diccionario.getIterador();
        assertTrue(iterador.hasNext());
        assertEquals("b", iterador.next().getClave());
    }
}