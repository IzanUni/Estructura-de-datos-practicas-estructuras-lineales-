public interface Diccionario<K, V> {
    boolean add(K clave, V valor);

    boolean delete(K clave);

    IteradorDiccionario<K, V> getIterador();

    boolean exists(K clave);

    V get(K clave);

    int getNumElementos();

    void add(ElementoDiccionario<K,V> b);
}
