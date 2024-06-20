public class ArbolRojoNegro<T extends Comparable<T>> {
    private NodoRojoNegro<T> raiz;

    public ArbolRojoNegro() {
        this.raiz = null;
    }

    //metodo auxiliar para conocer el estado rojo o negro del nodo
    private boolean esRojo(NodoRojoNegro<T> nodo) {
        if (nodo == null) {
            return false;  //si el nodo es null, se considera negro (false)
        }
        return nodo.getEsRojo();  //devuelve el estado de color del nodo (true si es rojo, false si es negro)
    }

    //metodo auxiliar para cambiar colores 
    private void cambiarColores(NodoRojoNegro<T> nodo) {
        nodo.setEsRojo(true);  // El nodo actual se convierte en rojo
        nodo.getIzquierda().setEsRojo(false);  // El hijo izquierdo se convierte en negro
        nodo.getDerecha().setEsRojo(false);  // El hijo derecho se convierte en negro
    }

    //metodo auxiliar para aplicar rotaciones a la derecha
    private NodoRojoNegro<T> rotarDerecha(NodoRojoNegro<T> nodo) {
        NodoRojoNegro<T> aux = nodo.getIzquierda();
        nodo.setIzquierda(aux.getDerecha());  // El hijo derecho del hijo izquierdo pasa a ser el nuevo hijo izquierdo del nodo
        if (aux.getDerecha() != null)
            aux.getDerecha().setPadre(nodo);  // Establece al nodo como padre del nuevo hijo izquierdo del nodo
        aux.setPadre(nodo.getPadre());  // El padre del nodo temporal se convierte en el padre del nodo actual
        if (nodo.getPadre() == null) 
            raiz = aux;  // Si el nodo es la raíz, actualiza la raíz del árbol
        else if (nodo == nodo.getPadre().getDerecha()) 
            nodo.getPadre().setDerecha(aux);  // Si el nodo es el hijo derecho de su padre, actualiza el hijo derecho del padre
        else 
            nodo.getPadre().setIzquierda(aux);  // Si el nodo es el hijo izquierdo de su padre, actualiza el hijo izquierdo del padre
        aux.setDerecha(nodo);  // El nodo actual pasa a ser el hijo derecho del nodo temporal
        nodo.setPadre(aux);  // El padre del nodo actual se convierte en el nodo temporal
        return aux;  // Retorna el nodo temporal, que ahora es la nueva raíz
    }
 
    // metodo auxiliar para aplicar rotaciones a la izquierda
    private NodoRojoNegro<T> rotarIzquierda(NodoRojoNegro<T> nodo) {
        NodoRojoNegro<T> aux = nodo.getDerecha();  
        nodo.setDerecha(aux.getIzquierda());  
        if (aux.getIzquierda() != null) 
            aux.getIzquierda().setPadre(nodo);  
        aux.setPadre(nodo.getPadre());  
        if (nodo.getPadre() == null) 
            raiz = aux;  
        else if (nodo == nodo.getPadre().getIzquierda()) 
            nodo.getPadre().setIzquierda(aux);  
        else 
            nodo.getPadre().setDerecha(aux);  
        aux.setIzquierda(nodo); 
        nodo.setPadre(aux);  
        return aux; 
    }
}