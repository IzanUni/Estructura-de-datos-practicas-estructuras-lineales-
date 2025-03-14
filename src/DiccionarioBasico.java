public class DiccionarioBasico<K, V> implements Diccionario<K, V> {
    protected ElementoDiccionario<K, V> cabeza;
    protected ElementoDiccionario<K, V> cola;
    protected int numElementos;

    public DiccionarioBasico() {
        this.cabeza = null;
        this.cola = null;
        this.numElementos = 0;
    }

    public boolean add(K clave, V valor) {
        ElementoDiccionario<K, V> nuevo = new ElementoDiccionario<>(clave, valor);
        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
        numElementos++;
        return true;
    }

    public boolean delete(K clave) {
        ElementoDiccionario<K, V> actual = cabeza;
        while (actual != null) {
            if (actual.clave.equals(clave)) {
                if (actual.anterior != null) {
                    actual.anterior.siguiente = actual.siguiente;
                } else {
                    cabeza = actual.siguiente;
                }
                if (actual.siguiente != null) {
                    actual.siguiente.anterior = actual.anterior;
                } else {
                    cola = actual.anterior;
                }
                numElementos--;
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    public IteradorDiccionario<K, V> getIterador() {
        return new IteradorDiccionario<>(cabeza);
    }

    public boolean exists(K clave) {
        ElementoDiccionario<K, V> actual = cabeza;
        while (actual != null) {
            if (actual.clave.equals(clave)) return true;
            actual = actual.siguiente;
        }
        return false;
    }

    public V get(K clave) {
        ElementoDiccionario<K, V> actual = cabeza;
        while (actual != null) {
            if (actual.clave.equals(clave)) return actual.valor;
            actual = actual.siguiente;
        }
        return null;
    }

    public int getNumElementos() {
        return numElementos;
    }

    @Override
    public void add(ElementoDiccionario<K, V> b) {

    }
}