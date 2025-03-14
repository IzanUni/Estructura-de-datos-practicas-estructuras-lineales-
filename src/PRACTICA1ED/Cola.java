package PRACTICA1ED;

public class Cola<T> {
    private ListaDE<T> milista;

    public Cola() {
        this.milista = new ListaDE<>();
    }
    public void enqueue(T elemento) {
        milista.add(elemento);
    }
    public T dequeue() {
        if(milista.inicio == null){
            return null;
        }
        T dato = milista.inicio.dato;
        milista.delete(dato);
        return dato;
    }
}
