public class Main {
    public static void main(String[] args) {
        ArbolRojoNegro<Integer> arbol = new ArbolRojoNegro<>();

        // Insertar elementos en el árbol del 1 al 20
        arbol.insertar(1);
        arbol.insertar(2);
        arbol.insertar(3);
        arbol.insertar(4);
        arbol.insertar(5);
        arbol.insertar(6);
        arbol.insertar(7);
        arbol.insertar(8);
        arbol.insertar(9);
        arbol.insertar(10);
        arbol.insertar(11);
        arbol.insertar(12);
        arbol.insertar(13);
        arbol.insertar(14);
        arbol.insertar(15);
        arbol.insertar(16);
        arbol.insertar(17);
        arbol.insertar(18);
        arbol.insertar(19);
        arbol.insertar(20);

        // Mostrar el árbol en postorden
        System.out.println("Arbol en postorden:");
        arbol.mostrarRecorridoPostorden();
    }
}
