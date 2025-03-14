public class IteradorDiccionario<K, V> implements Iterador<ElementoDiccionario<K, V>> {
    private ElementoDiccionario<K, V> actual;

    public IteradorDiccionario(ElementoDiccionario<K, V> inicio) {
        this.actual = inicio;
    }

    public boolean hasNext() {
        return actual != null;
    }

    public ElementoDiccionario<K, V> next() {
        ElementoDiccionario<K, V> temp = actual;
        actual = actual.siguiente;
        return temp;
    }

    public void delete() {

    }
}
