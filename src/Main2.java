public class Main2 {
    public static void main(String[] args) {
        // Crear un árbol Rojo-Negro de tipo Integer
        ArbolRojoNegro<Integer> arbol = new ArbolRojoNegro<>();

        // Insertar elementos en el árbol del 20 al 1
        for (int k = 20; k >= 1; k--) {
            arbol.insertar(k);
        }

        // Buscar un nodo específico (por ejemplo, el nodo con valor 20)
        System.out.println("Buscando el nodo con valor 20:");
        arbol.buscar(20);

        // Mostrar el árbol en postorden, preorden e inorden
        System.out.println("\nArbol en postorden:");
        arbol.mostrarRecorridoPostorden();

        System.out.println("\nArbol en preorden:");
        arbol.mostrarRecorridoPreorden();

        System.out.println("\nArbol en inorden:");
        arbol.mostrarRecorridoInorden();

        // Eliminar elementos del 1 al 9
        for (int k = 1; k <= 9; k++) {
            arbol.eliminar(k);
        }

        System.out.println("\nArbol después de eliminar elementos del 1 al 9:");
        arbol.mostrarRecorridoInorden();
    }
}
