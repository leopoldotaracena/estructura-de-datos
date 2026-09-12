public class main {
    public static void main(String[] args) {
        ArbolBinario a = new ArbolBinario();

        // 1. Verificación de estado inicial y métodos auxiliares
        System.out.println("¿Está vacío el árbol recién creado?: " + a.estaVacio());
        System.out.println("Raíz inicial: " + a.getRaiz());

        // 2. Construcción e Inserción del Árbol Binario de Búsqueda
        int[] datos = { 26, 60, 65, 51, 59, 13, 73, 7, 5, 1, 9, 32, 54, 25, 49, 24, 99, 83, 48, 93, 35 };
        for (int d : datos) {
            a.insertar(d);
        }

        System.out.println("\n--- ESTADO INICIAL DEL ÁRBOL ---");
        System.out.println("¿Está vacío?: " + a.estaVacio());
        System.out.println("Valor de la raíz: " + a.getRaiz().getDato());
        System.out.println("INORDEN:   " + a.inorden());
        System.out.println("PREORDEN:  " + a.preorden());
        System.out.println("POSTORDEN: " + a.postorden());

        // 3. Prueba del método de Búsqueda (buscar)
        System.out.println("\n--- BÚSQUEDA ---");
        System.out.println("¿Existe el 26?: " + a.buscar(26));
        System.out.println("¿Existe el 100?: " + a.buscar(100));

        // 4. Prueba del método de Clasificación de Nodos (claseNodo)
        System.out.println("\n--- CLASIFICACIÓN DE NODOS ---");
        System.out.println("Clase del 26 (Raíz):     " + a.claseNodo(26));
        System.out.println("Clase del 1 (Hoja):       " + a.claseNodo(1));
        System.out.println("Clase del 25 (1 Hijo):    " + a.claseNodo(25));
        System.out.println("Clase del 13 (2 Hijos):   " + a.claseNodo(13));
        System.out.println("Clase del 999 (Inexist): " + a.claseNodo(999));

        // 5. Secuencia de Eliminaciones acumulativas mostrando el PREORDEN resultante
        System.out.println("\n--- ELIMINACIONES PROGRESIVAS ---");

        // Caso 1: Eliminar un nodo HOJA (1)
        boolean el1 = a.eliminar(1);
        System.out.println("Eliminar 1 (HOJA) -> Exitoso: " + el1);
        System.out.println("PREORDEN: " + a.preorden());

        // Caso 2: Eliminar un nodo con UN HIJO (25)
        boolean el25 = a.eliminar(25);
        System.out.println("\nEliminar 25 (UN HIJO) -> Exitoso: " + el25);
        System.out.println("PREORDEN: " + a.preorden());

        // Caso 3: Eliminar un nodo interno con DOS HIJOS (13)
        boolean el13 = a.eliminar(13);
        System.out.println("\nEliminar 13 (DOS HIJOS) -> Exitoso: " + el13);
        System.out.println("PREORDEN: " + a.preorden());

        // Caso 4: Eliminar el nodo RAÍZ con DOS HIJOS (26)
        boolean el26 = a.eliminar(26);
        System.out.println("\nEliminar 26 (RAÍZ) -> Exitoso: " + el26);
        System.out.println("PREORDEN: " + a.preorden());

        System.out.println("\n--- ESTADO FINAL ---");
        System.out.println("Nueva Raíz: " + a.getRaiz().getDato());
        System.out.println("INORDEN FINAL: " + a.inorden());
    }
}