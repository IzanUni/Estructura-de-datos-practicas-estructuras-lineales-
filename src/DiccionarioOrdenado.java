public class DiccionarioOrdenado<K extends Comparable<K>, V> extends DiccionarioBasico<K, V> {
    public boolean add(K clave, V valor) {
        ElementoDiccionario<K, V> nuevo = new ElementoDiccionario<>(clave, valor);
        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            ElementoDiccionario<K, V> actual = cabeza;
            while (actual != null && actual.clave.compareTo(clave) < 0) {
                actual = actual.siguiente;
            }
            if (actual == null) {
                cola.siguiente = nuevo;
                nuevo.anterior = cola;
                cola = nuevo;
            } else {
                nuevo.siguiente = actual;
                nuevo.anterior = actual.anterior;
                if (actual.anterior != null) {
                    actual.anterior.siguiente = nuevo;
                } else {
                    cabeza = nuevo;
                }
                actual.anterior = nuevo;
            }
        }
        numElementos++;
        return true;
    }
}