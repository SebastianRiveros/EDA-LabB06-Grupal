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
}