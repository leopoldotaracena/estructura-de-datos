import java.util.InputMismatchException;
import java.util.Scanner;

public class prueba {

    static class Libro {
        String autor;
        String titulo;
        int SKU;

        Libro(String autor, String titulo, int SKU) {
            this.autor = autor;
            this.titulo = titulo;
            this.SKU = SKU;
        }

        @Override
        public String toString() {
            return "Libro { Título: '" + titulo + "', Autor: '" + autor + "', SKU: " + SKU + " }";
        }
    }

    static class Node {
        Libro libro;
        Node next;

        Node(Libro libro) {
            this.libro = libro;
            this.next = null;
        }
    }

    static class LinkedList {
        Node head;

        LinkedList() {
            head = null;
        }

        // INSERTAR AL INICIO
        public void insertAtBeginning(Libro libro) {
            Node newNode = new Node(libro);
            newNode.next = head;
            head = newNode;
            System.out.println("Libro insertado al inicio con éxito.");
        }

        // MOSTRAR LISTA
        public void display() {
            if (head == null) {
                System.out.println("[Lista Vacía]");
                return;
            }
            System.out.println("\n--- INVENTARIO DE LIBROS ---");
            Node current = head;
            int pos = 0;
            while (current != null) {
                System.out.println("[" + pos + "] " + current.libro);
                current = current.next;
                pos++;
            }
        }

        // INSERTAR EN POSICIÓN
        public void insertAt(int index, Libro libro) {
            if (index < 0 || index > size()) {
                System.out.println("Error: Posición " + index + " fuera de rango.");
                return;
            }

            if (index == 0) {
                insertAtBeginning(libro);
                return;
            }

            Node newNode = new Node(libro);
            Node current = head;

            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;
            System.out.println("Libro insertado en la posición " + index + " con éxito.");
        }

        // INSERTAR AL FINAL
        public void insertAtEnd(Libro libro) {
            Node newNode = new Node(libro);
            if (head == null) {
                head = newNode;
                System.out.println("Libro insertado al final con éxito.");
                return;
            }

            Node current = head;
            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
            System.out.println("Libro insertado al final con éxito.");
        }

        // TAMAÑO
        public int size() {
            Node current = head;
            int cont = 0;

            while (current != null) {
                cont++;
                current = current.next;
            }
            return cont;
        }

        // BUSCAR POR SKU
        public void getSKU(int SKU) {
            Node current = head;
            while (current != null) {
                if (current.libro.SKU == SKU) {
                    System.out.println("Encontrado: " + current.libro);
                    return;
                }
                current = current.next;
            }
            System.out.println("No existe un libro con SKU: " + SKU);
        }

        // BUSCAR POR ÍNDICE
        public String getIdex(int index) {
            if (index < 0 || index >= size() || head == null) {
                return null;
            }
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.libro.titulo;
        }

        // ELIMINAR POR SKU
        public void delete(int SKU) {
            if (head == null) {
                System.out.println("No se puede eliminar: Lista vacía.");
                return;
            }

            if (head.libro.SKU == SKU) {
                head = head.next;
                System.out.println("Libro con SKU " + SKU + " eliminado.");
                return;
            }

            Node current = head;
            while (current.next != null) {
                if (current.next.libro.SKU == SKU) {
                    current.next = current.next.next;
                    System.out.println("Libro con SKU " + SKU + " eliminado.");
                    return;
                }
                current = current.next;
            }
            System.out.println("No se encontró el SKU " + SKU + " para eliminar.");
        }

        // ELIMINAR POR ÍNDICE
        public void deleteIndex(int index) {
            if (head == null || index < 0 || index >= size()) {
                System.out.println("Error: Posición " + index + " inválida para eliminar.");
                return;
            }

            if (index == 0) {
                head = head.next;
                System.out.println("Elemento en posición 0 eliminado.");
                return;
            }

            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            System.out.println("Elemento en posición " + index + " eliminado.");
        }
    }

    // MÉTODO PARA LEER ENTEROS SIN CRASHEAR EL PROGRAMA
    private static int leerEntero(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                int valor = scanner.nextInt();
                scanner.nextLine(); 
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Error: Entrada inválida. Por favor, ingresa un número entero.");
                scanner.nextLine(); 
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList list = new LinkedList();
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=================================");
            System.out.println("  SISTEMA DE GESTIÓN DE LIBROS   ");
            System.out.println("=================================");
            System.out.println("1. Insertar libro al inicio");
            System.out.println("2. Insertar libro al final");
            System.out.println("3. Insertar libro en posición específica");
            System.out.println("4. Mostrar inventario");
            System.out.println("5. Consultar tamaño de la lista");
            System.out.println("6. Buscar libro por SKU");
            System.out.println("7. Buscar libro por índice");
            System.out.println("8. Eliminar libro por SKU");
            System.out.println("9. Eliminar libro por índice");
            System.out.println("10. Salir");
            
            int opcion = leerEntero(scanner, "Selecciona una opción (1-10): ");

            switch (opcion) {
                case 1: {
                    System.out.print("Ingrese el autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ingrese el título: ");
                    String titulo = scanner.nextLine();
                    int sku = leerEntero(scanner, "Ingrese el SKU: ");
                    list.insertAtBeginning(new Libro(autor, titulo, sku));
                    break;
                }
                case 2: {
                    System.out.print("Ingrese el autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ingrese el título: ");
                    String titulo = scanner.nextLine();
                    int sku = leerEntero(scanner, "Ingrese el SKU: ");
                    list.insertAtEnd(new Libro(autor, titulo, sku));
                    break;
                }
                case 3: {
                    int pos = leerEntero(scanner, "Ingrese la posición de inserción: ");
                    System.out.print("Ingrese el autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ingrese el título: ");
                    String titulo = scanner.nextLine();
                    int sku = leerEntero(scanner, "Ingrese el SKU: ");
                    list.insertAt(pos, new Libro(autor, titulo, sku));
                    break;
                }
                case 4:
                    list.display();
                    break;
                case 5:
                    System.out.println("Tamaño actual de la lista: " + list.size());
                    break;
                case 6: {
                    int sku = leerEntero(scanner, "Ingrese el SKU a buscar: ");
                    list.getSKU(sku);
                    break;
                }
                case 7: {
                    int pos = leerEntero(scanner, "Ingrese la posición a consultar: ");
                    String resultado = list.getIdex(pos);
                    if (resultado != null) {
                        System.out.println("Resultado en posición " + pos + ": " + resultado);
                    } else {
                        System.out.println("Resultado: null (Posición inválida o lista vacía)");
                    }
                    break;
                }
                case 8: {
                    int sku = leerEntero(scanner, "Ingrese el SKU del libro a eliminar: ");
                    list.delete(sku);
                    break;
                }
                case 9: {
                    int pos = leerEntero(scanner, "Ingrese la posición a eliminar: ");
                    list.deleteIndex(pos);
                    break;
                }
                case 10:
                    System.out.println("Saliendo del sistema...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción fuera de rango (1-10). Intenta de nuevo.");
                    break;
            }
        }
        scanner.close();
    }
}