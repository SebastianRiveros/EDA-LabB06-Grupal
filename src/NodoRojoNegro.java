

public class NodoRojoNegro<T extends Comparable<T>> {
    private T dato;  //dato almacenado en el nodo
    private NodoRojoNegro<T> izquierda, derecha, padre;  //nodos hijos y padre
    private boolean esRojo;  //confirmar si es rojo o no(es negro)

    // Constructor
    public NodoRojoNegro(T dato) {
        this.dato = dato;
        this.izquierda = null;
        this.derecha = null;
        this.padre = null;
        this.esRojo = true;  // el nuevo nodo siempre es rojo inicialmente
    }

    //Getters y setters:
    public T getDato(){return this.dato;}
    public void setDato(T dato){this.dato = dato;}
    public NodoRojoNegro<T> getIzquierda(){return this.izquierda;} 
    public void setIzquierda(NodoRojoNegro<T> izquierda){this.izquierda = izquierda;}
    public NodoRojoNegro<T> getDerecha(){return this.derecha;} 
    public void setDerecha(NodoRojoNegro<T> derecha){this.derecha = derecha;}
    public NodoRojoNegro<T> getPadre(){return this.padre;} 
    public void setPadre(NodoRojoNegro<T> padre){this.padre = padre;}
    public boolean getEsRojo(){return this.esRojo;}
    public void setEsRojo(boolean esRojo){this.esRojo = esRojo;}
}