public class Main {
    public static void main(String[] args) {
        ArbolRojoNegro<Integer> arbol = new ArbolRojoNegro<>();

        // Insertar elementos en el árbol del 1 al 20
        for (int k = 1; k < 21; k++) {
            arbol.insertar(k);
        }

        System.out.println("Buscando el nodo : ");
        arbol.buscar(20);

        // Mostrar el árbol en postorden
        System.out.println("Arbol en postorden:");
        arbol.mostrarRecorridoPostorden();
        System.out.println("\nArbol en preorden:");
        arbol.mostrarRecorridoPreorden();
        System.out.println("\nArbol en inorden:");
        arbol.mostrarRecorridoInorden();

        // Eliminar elementos del 1 al 9
        for (int k = 1; k < 10; k++) {
            arbol.eliminar(k);
        }

        System.out.println("Arbol después de eliminar elementos del 1 al 9:");
        arbol.mostrarRecorridoInorden();
    }
}