import java.util.InputMismatchException;
import java.util.Scanner;


public class menu{
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
        boolean salir = false;
        main.Stack stack = new main.Stack();
        queue.Queue queue=new queue.Queue();


        while (!salir) {
            System.out.println("\n=================================");
            System.out.println("  CENTRO DE OPERACIONES ");
            System.out.println("=================================");

            System.out.println("1. Insertar accion");
            System.out.println("2. Eliminar accion");
            System.out.println("3. Ver ultima accion");
            System.out.println("4. Mostrar Historial");


            System.out.println("5. Ingresar tarea");
            System.out.println("6. Procesar tarea");
            System.out.println("7. Ver siguiente tarea");
            System.out.println("8. Mostrar tareas pendientes");

            System.out.println("9. Estado del sistema");
            System.out.println("10. Salir");
            
            int opcion = leerEntero(scanner, "Selecciona una opción (1-10): ");
//REGISTRAR ACCION
            switch (opcion) {
                case 1: {
                    System.out.println("registra la accion ");
                    String accion2 = scanner.nextLine();
                    stack.push(accion2);
                
                    break;
                }
// Deshacer última acción 
                case 2: {
                    System.out.println("Ultima accion");
                    System.out.println(stack.pop());

                    System.out.println("eliminada con exito");
                
                    break;
                }

//ver ultima opcion             
                case 3: {
                    System.out.println("Ultima accion");
                    System.out.println(stack.peek());

                    break;
                    
                }
//HISTORIAL
                case 4:{
                    System.out.println("historial");
                    System.out.println(stack.Historial());
                    break;
                }
//crear tarea
                case 5:{
                    System.out.println("ingrese la tarea");
                    String accion6 = scanner.nextLine();
                    queue.enqueue(accion6);
                    System.out.println("Agregado");
                    break;
                }
//eliminar tarea
                case 6: {
                    System.out.println("procesando...");
                    System.out.println(queue.dequeue());
                    break;
                }
//ver siguiente tarea
                case 7: {
                    System.out.println("procesando...");
                     System.out.println(queue.peek());
                     break;
                }
//Tareas pendientes
                case 8: {
                    System.out.println("Tareas pendientes:");
                    System.out.println(queue.Pendientes());
                    break;
                }
//Mostrar estado del sistema
                case 9: {
                    System.out.println("ACCIONES");
                    System.out.println("PILA:"+ stack.Historial());
                    System.out.println("TAMAÑO:"+ stack.size());
                    System.out.println("ESTA VACIA?:"+ stack.isEmpty());

                    System.out.println("TAREAS");
                    System.out.println("COLA:"+ queue.Pendientes());
                    System.out.println("TAMAÑO:"+ queue.size());
                    System.out.println("ESTA VACIA?:"+ queue.isEmpty());

                    break;
                }
//SALIR
                case 10:{
                     System.out.println("Saliendo del sistema...");
                    salir = true;
                    break;

                }
                default:
                    System.out.println("Opción fuera de rango (1-10). Intenta de nuevo.");
                    break;
            }
        }
        scanner.close();
    }
   

}
