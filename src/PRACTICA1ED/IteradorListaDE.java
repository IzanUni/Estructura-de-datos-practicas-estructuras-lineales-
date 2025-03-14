package PRACTICA1ED;

import java.util.NoSuchElementException;

public class IteradorListaDE<T> implements Iterador<T> {
    private ElementoDoble<T> actual;
    private ListaDE<T> milista;

    public IteradorListaDE(ListaDE<T> milista) {
        this.milista = milista;
        this.actual = milista.inicio;
    }

    @Override
    public boolean hasNext() {
        return actual != null;
    }

    @Override
    public T next() {

        if (actual == null) {
            throw new NoSuchElementException("No hay más elementos");
        }

        T dato = actual.dato;
        actual = actual.siguiente;
        return dato;
    }

    public boolean hasPrevious() {
        return actual != null && actual.anterior != null;
    }

    public T previous() {
        if (!hasPrevious()) {
            return null;
        }
        actual = actual.anterior;
        return actual.dato;
    }

    @Override
    public void delete() {
        if (actual == null) {
            return;
        }


        if (actual.anterior != null) {
            actual.anterior.siguiente = actual.siguiente;
        } else {
            milista.inicio = actual.siguiente;
        }

        if (actual.siguiente != null) {
            actual.siguiente.anterior = actual.anterior;
        } else {
            milista.fin = actual.anterior;
        }

        actual = actual.siguiente;
    }
}