package PRACTICA1ED;

public class ListaArray<T> implements Lista<T> {
    private T[] elementos;
    private int size;


    public ListaArray(int longitud) {
        elementos = (T[]) new Object[longitud];
        size = longitud;
    }
    @Override
    public boolean add(T elemento) {
        // Verificar si el array está lleno (comprobamos la última posición del array)
        if (elementos[elementos.length - 1] != null) {
            // Si el array está lleno, redimensionarlo
            T[] nuevoArray = (T[]) new Object[elementos.length * 2];
            System.arraycopy(elementos, 0, nuevoArray, 0, elementos.length);
            elementos = nuevoArray; // Asignamos el nuevo array
        }

        // Buscar el primer lugar vacío para agregar el elemento
        for (int i = 0; i < elementos.length; i++) {
            if (elementos[i] == null) {
                elementos[i] = elemento; // Agregar el elemento
                return true;
            }
        }
        return false; // No se pudo agregar
    }

    @Override
    public boolean delete(T elemento) {
        for (int i = 0; i < elementos.length; i++) {
            if (elementos[i] != null && elementos[i].equals(elemento)) {
                // Desplazamos los elementos a la izquierda
                for (int j = i; j < elementos.length - 1; j++) {
                    elementos[j] = elementos[j + 1];
                }
                elementos[elementos.length - 1] = null; // Limpiar la última posición
                return true; // Elemento eliminado
            }
        }
        return false; // No se encontró el elemento
    }

    @Override
    public Iterador<T> getIterador() {
        return new IteradorBasico<>(elementos);
    }
    @Override
    public int getNumElementos() {
        int count = 0;
        for (T elemento : elementos) {
            if (elemento != null) {
                count++;
            }
        }
        return count;
    }
}