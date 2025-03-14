package PRACTICA1ED;

public class Pila<T> {
    private ListaDE<T> milista;

    public Pila(){
        this.milista = new ListaDE<>();
    }
    public void push(T elemento){
        milista.add(elemento);
    }
    public T pop(){
        if(milista.fin == null){
            System.out.println("PRACTICA1ED.Lista vacia");
            return null;
        }
        T dato = milista.fin.dato;
        milista.delete(dato);
        return dato;
    }
}
