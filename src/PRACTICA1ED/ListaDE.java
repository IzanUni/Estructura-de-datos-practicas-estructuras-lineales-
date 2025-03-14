package PRACTICA1ED;

public class ListaDE<T> implements Lista<T> {
    ElementoDoble<T> inicio;
    ElementoDoble<T> fin;


    public ListaDE(){
        inicio = null;
        fin = null;
    }

    @Override
    public boolean add(T dato) {
        ElementoDoble<T> elemento = new ElementoDoble<>(dato);
        if (inicio == null) {
            this.inicio = elemento;
            this.fin = elemento;
        }else{
            fin.siguiente = elemento;
            elemento.anterior = fin;
            this.fin=elemento;
        }
        return true;
    }

    @Override
    public boolean delete(T elemento) {
        ElementoDoble<T> actual = inicio;
        if (actual == null) return false;

        while (actual != null && !(actual.dato.equals(elemento))) {
            actual = actual.siguiente;
        }

        if (actual == null) return false; // No se encuentra el elemento

        if (actual.anterior != null) {
            actual.anterior.siguiente = actual.siguiente;
        } else {
            inicio = actual.siguiente; // Eliminar el primer elemento
        }

        if (actual.siguiente != null) {
            actual.siguiente.anterior = actual.anterior;
        } else {
            fin = actual.anterior; // Eliminar el último elemento
        }

        return true;
    }

    @Override
    public Iterador<T> getIterador() {
        return new IteradorListaDE<>(this);
    }

    @Override
    public int getNumElementos() {
        int size = 0;
        ElementoDoble<T> actual = inicio;
        while (actual != null) {
            size++;
            actual = actual.siguiente;
        }
        return size;
    }
}
