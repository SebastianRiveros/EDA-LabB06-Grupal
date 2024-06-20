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
}