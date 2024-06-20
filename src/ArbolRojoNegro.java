public class ArbolRojoNegro<T extends Comparable<T>> {
    private NodoRojoNegro<T> raiz;

    public ArbolRojoNegro() {
        this.raiz = null;
    }

    public NodoRojoNegro<T> getRaiz(){return this.raiz;}
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
        if (aux.getDerecha()!= null)
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
        if (aux.getIzquierda()!= null) 
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

    //metodo para balancear el arbol ante una elminacion o insercion
    private NodoRojoNegro<T> balancear(NodoRojoNegro<T> nodo) {
        // Casos de rotación según las reglas del árbol rojo-negro:

        //si el hijo derecho es rojo y el izquierdo es negro
        if (esRojo(nodo.getDerecha()) &&!esRojo(nodo.getIzquierda())) 
            nodo = rotarIzquierda(nodo);

        //si dos nodos consecutivos son rojos en la rama izquierda
        if (esRojo(nodo.getIzquierda()) && esRojo(nodo.getIzquierda().getIzquierda())) 
            nodo = rotarDerecha(nodo); 

        //si ambos hijos son rojos
        if(esRojo(nodo.getIzquierda()) && esRojo(nodo.getDerecha())) {
            cambiarColores(nodo);
        }
        return nodo;  // Retorna el nodo después de las rotaciones y ajustes
    }

    public void insertar(T dato) {
        if (raiz == null) {
            raiz = new NodoRojoNegro<>(dato);
            raiz.setEsRojo(false);
        } else {
            raiz = insertar(raiz, dato);
        }
    }

    // Método recursivo para insertar un dato en el árbol
    private NodoRojoNegro<T> insertar(NodoRojoNegro<T> nodo, T dato) {
        // Caso base: si el nodo es null, se crea un nuevo nodo con el dato
        if (nodo == null) {
            return new NodoRojoNegro<>(dato);
        }

        // Insertar recursivamente según el valor del dato
        if (dato.compareTo(nodo.getDato()) <= 0) {
            nodo.setIzquierda(insertar(nodo.getIzquierda(), dato));
            nodo.getIzquierda().setPadre(nodo);
        } else if (dato.compareTo(nodo.getDato()) > 0) {
            nodo.setDerecha(insertar(nodo.getDerecha(), dato));
            nodo.getDerecha().setPadre(nodo);
        }

        // Realizar las rotaciones y ajustes necesarios para mantener las propiedades del árbol rojo-negro
        return balancear(nodo);
    }

    public void buscar(T dato) {
        buscar(raiz, dato, 0);
    }

    // Método privado recursivo para buscar un dato en el árbol y calcular el nivel
    private void buscar(NodoRojoNegro<T> nodo, T dato, int nivel) {
        if (nodo == null) {
            System.out.println("Dato no encontrado en el árbol.");
            return;
        }

        if (dato.compareTo(nodo.getDato()) == 0) {
            String color = nodo.getEsRojo() ? "Rojo" : "Negro";
            System.out.println("Dato encontrado en el nivel " + nivel + " y es de color " + color + ".");
            return;
        }

        if (dato.compareTo(nodo.getDato()) < 0) {
            buscar(nodo.getIzquierda(), dato, nivel + 1);  // Busca en el subárbol izquierdo e incrementa el nivel
        } else {
            buscar(nodo.getDerecha(), dato, nivel + 1);  // Busca en el subárbol derecho e incrementa el nivel
        }
    }

    public void eliminar(T dato) {
        raiz = eliminar(raiz, dato);
    }

    private NodoRojoNegro<T> eliminar(NodoRojoNegro<T> nodo, T dato) {
        if (nodo == null) {
            return null;
        }

        if (dato.compareTo(nodo.getDato()) < 0) {
            nodo.setIzquierda(eliminar(nodo.getIzquierda(), dato));
        } else if (dato.compareTo(nodo.getDato()) > 0) {
            nodo.setDerecha(eliminar(nodo.getDerecha(), dato));
        } else {
            // Nodo encontrado, eliminarlo
            if (nodo.getIzquierda()== null && nodo.getDerecha() == null) {
                // Nodo hoja, eliminarlo directamente
                return null;
            } else if (nodo.getIzquierda() == null) {
                // Nodo con un hijo derecho, reemplazar con el hijo derecho
                return nodo.getDerecha();
            } else if (nodo.getDerecha() == null) {
                // Nodo con un hijo izquierdo, reemplazar con el hijo izquierdo
                return nodo.getIzquierda();
            } else {
                // Nodo con dos hijos, encontrar el nodo de reemplazo
                NodoRojoNegro<T> reemplazo = encontrarReemplazo(nodo);
                nodo.setDato(reemplazo.getDato());
                nodo.setIzquierda(eliminar(nodo.getIzquierda(), reemplazo.getDato()));
            }
        }

        return balancear(nodo);
    }

    private NodoRojoNegro<T> encontrarReemplazo(NodoRojoNegro<T> nodo) {
        // Encontrar el nodo de reemplazo en el subárbol derecho
        NodoRojoNegro<T> reemplazo = nodo.getDerecha();
        while (reemplazo.getIzquierda()!= null) {
            reemplazo = reemplazo.getIzquierda();
        }
        return reemplazo;
    }

    public void mostrarRecorridoInorden() {
        recorridoInorden(raiz);
    }

    private void recorridoInorden(NodoRojoNegro<T> nodo) {
        if (nodo!= null) {
            recorridoInorden(nodo.getIzquierda());
            System.out.print(nodo.getDato());
            if (nodo.getEsRojo()) {
                System.out.print(" (Rojo) ");
            } else {
                System.out.print(" (Negro) ");
            }
            System.out.println();
            recorridoInorden(nodo.getDerecha());
        }
    }

    public void mostrarRecorridoPostorden() {
        recorridoPostorden(raiz);
    }

    private void recorridoPostorden(NodoRojoNegro<T> nodo) {
        if (nodo!= null) {
            recorridoPostorden(nodo.getIzquierda());
            recorridoPostorden(nodo.getDerecha());
            System.out.print(nodo.getDato());
            if (nodo.getEsRojo()) {
                System.out.print(" (Rojo) ");
            } else {
                System.out.print(" (Negro) ");
            }
            System.out.println();
        }
    }

    public void mostrarRecorridoPreorden() {
        recorridoPreorden(raiz);
    }

    private void recorridoPreorden(NodoRojoNegro<T> nodo) {
        if (nodo!= null) {
            System.out.print(nodo.getDato());
            if (nodo.getEsRojo()) {
                System.out.print(" (Rojo) ");
            } else {
                System.out.print(" (Negro) ");
            }
            System.out.println();
            recorridoPreorden(nodo.getIzquierda());
            recorridoPreorden(nodo.getDerecha());
        }
    }
}