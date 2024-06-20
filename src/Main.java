public class Main {
    public static void main(String[] args) {
        ArbolRojoNegro<Integer> arbol = new ArbolRojoNegro<>();

        // Insertar elementos en el árbol
        arbol.insertar(10);
        arbol.insertar(5);
        arbol.insertar(15);
        arbol.insertar(3);
        arbol.insertar(7);
        arbol.insertar(13);
        arbol.insertar(18);

        // Mostrar el árbol en postorden
        System.out.println("Arbol en postorden:");
        arbol.mostrarRecorridoPostorden();
    }
}
