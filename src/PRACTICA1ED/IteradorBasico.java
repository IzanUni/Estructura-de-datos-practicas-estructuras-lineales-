package PRACTICA1ED;

import java.util.NoSuchElementException;

class IteradorBasico<T> implements Iterador<T> {
    private T[] miLista;
    private int actual;

    public IteradorBasico(T[] miLista) {
        this.miLista = miLista;
        this.actual = 0;
    }

    @Override
    public boolean hasNext() {
        // Buscamos el siguiente elemento no nulo
        for (int i = actual; i < miLista.length; i++) {
            if (miLista[i] != null) {
                return true; // Hay un siguiente elemento
            }
        }
        return false; // No hay más elementos no nulos
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No hay más elementos");
        }

        // Buscamos el siguiente elemento no nulo
        while (miLista[actual] == null) {
            actual++;
        }

        return miLista[actual++]; // Retorna el elemento actual y avanza el índice
    }

    @Override
    public void delete() {
        if (actual == 0 || miLista[actual - 1] == null) {
            System.out.println("No hay elementos para eliminar.");
            return;
        }

        // Desplazar los elementos a la izquierda
        for (int i = actual - 1; i < miLista.length - 1; i++) {
            miLista[i] = miLista[i + 1];
        }

        miLista[miLista.length - 1] = null; // Limpiar la última posición
    }
}