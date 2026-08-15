public class actividad1 {

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

            this.libro=libro;
            this.next = null;
        }
    }

    static class LinkedList{
        Node head;

        LinkedList() {
            head=null;
        }

        //INSERTAR AL INICIO
         public void insertAtBeginning(Libro libro){
            Node newNode= new Node(libro);
            newNode.next=head;
            head=newNode;
        }
        //MOSTAR LISTA
         public void display(){
            if (head == null) {
                System.out.println("Lista Vacía");
                return;
            }
            
            Node current= head;

            while(current!=null){
                System.out.println(current.libro);
                current=current.next;
            }
         }

         //INSERTAR EN:
        public void insertAt(int index, Libro libro){
            if (index < 0 || index > size()) {
                System.out.println("Error: Posición " + index + " fuera de rango.");
                return;
            }

            if (index == 0) {
                insertAtBeginning(libro);
                return;
            }

            Node newNode= new Node(libro);
            Node current= head;
            

            if(head==null){
                return;
            }


            for (int i = 0; i < index-1; i++) {
                current=current.next;
            }

            newNode.next=current.next;
            current.next=newNode;
        }

        //INSERTAR AL FINAL
        public void insertAtEnd(Libro libro){
            Node newNode= new Node(libro);
            if(head==null){
                head=newNode;
                return;
            }

            Node current=head;

            while(current.next !=null){
                current=current.next;
            }

            current.next=newNode;

        }

        //TAMAÑO
        public int size(){
            Node current =head;
            int cont=0;

            while(current!=null){
                cont++;
                current=current.next;
            }
            return cont;
        }

        //BUSCAR POR SKU
        public void getSKU(int SKU){
            Node current=head;
            while (current !=null) { 
                if (current.libro.SKU==SKU){
                    System.out.println("libro en existencia");
                    return;
                }
                if (current.next==null){
                     System.out.println("no existe este libro en la base de datos");
                }
                current=current.next;
                
            }
            
        }

        //BUSCAR POR INDICE
        public String getIdex(int index){
            
            if (index < 0 || index >= size() || head == null) {
                return null;
            }
            Node current=head;
            for (int i = 0; i < index ; i++) {
                current=current.next;
        
            }
            return current.libro.titulo;
            
        }

        //ELIMINAR POR SKU
        public void delete(int SKU){
            if (head== null){
                System.out.println("No se puede eliminar: Lista vacía.");
                return;
            }

            if(head.libro.SKU==SKU){
                head=head.next;
                System.out.println("Libro con SKU " + SKU + " eliminado.");
                return;
            }
            Node current=head;
            while(current.next!=null){

                if (current.libro.SKU==SKU){
                    current.next=current.next.next;
                    System.out.println("Libro con SKU " + SKU + " eliminado.");
                    return;
                }
                current=current.next;
            }
            System.out.println("No se encontró el SKU " + SKU + " para eliminar.");

        }

        //ELIMINAR POR INDICE
        public void deleteIndex(int index){
            if (head == null || index < 0 || index >= size()) {
                System.out.println("Error: Posición " + index + " inválida para eliminar.");
                return;
            }

            if(index==0){
                head=head.next;
                return;
            }
            Node current=head;
            for (int i = 0; i < index-1; i++) {
                current=current.next;
            }
            current.next=current.next.next;
            System.out.println("Elemento en posición " + index + " eliminado.");

        }
    }

    public static void main(String[] args) {
        Libro libro1 = new Libro("leo", "libro1", 1);
        Libro libro2 = new Libro("leo", "libro2", 2);
        Libro libro3 = new Libro("leo", "libro3", 3);
        Libro libro4 = new Libro("leo", "libro4", 4);
        Libro libro5 = new Libro("leo", "libro5", 5);

        LinkedList list=new LinkedList();

        //list.insertAtBeginning(libro2);
        //list.insertAtEnd(libro1);
        //list.insertAtEnd(libro3);
        //list.insertAt(3, libro4);
    
        //System.out.println("LISTA DE LIBROS");
        //list.display();

        //System.out.println("BUSCAR LIBRO EN INVENTARIO POR SKU");
        //list.getSKU(5);
        //System.out.println("BUSCAR LIBRO EN INVENTARIO POR INDEX");
        //System.out.println(list.getIdex(2));
        //System.out.println(libro1);

        //System.out.println("ELIMINAR LIBRO");
        //list.delete(3);
        //list.deleteIndex(3);
        //list.display();

        System.out.println("--- PRUEBA 1: Lista vacía ---");
        list.display();

        System.out.println("\n--- PRUEBA 2: Obtener tamaño de lista vacía ---");
        System.out.println("Tamaño: " + list.size());

        System.out.println("\n--- PRUEBA 3: Agregar el primer libro (insertAtBeginning) ---");
        list.insertAtBeginning(libro1);
        list.display();

        System.out.println("\n--- PRUEBA 4: Agregar varios libros (insertAtEnd) ---");
        list.insertAtEnd(libro2);
        list.insertAtEnd(libro4);
        list.display();

        System.out.println("\n--- PRUEBA 5: Insertar al inicio ---");
        list.insertAtBeginning(libro3);
        list.display();

        System.out.println("\n--- PRUEBA 6: Insertar en una posición intermedia (Posición 2) ---");
        list.insertAt(2, libro5);
        list.display();

        System.out.println("\n--- PRUEBA 7: Obtener el tamaño de la lista ---");
        System.out.println("Tamaño actual: " + list.size());

        System.out.println("\n--- PRUEBA 8: Buscar un elemento existente (SKU 3) ---");
        list.getSKU(3);

        System.out.println("\n--- PRUEBA 9: Buscar un elemento inexistente (SKU 999) ---");
        list.getSKU(999);

        System.out.println("\n--- PRUEBA 10: Consultar una posición válida (Posición 1) ---");
        System.out.println("Resultado: " + list.getIdex(1));

        System.out.println("\n--- PRUEBA 11: Consultar una posición inválida (Posición 10) ---");
        System.out.println("Resultado: " + list.getIdex(10));

        System.out.println("\n--- PRUEBA 12: Eliminar el primero ---");
        list.deleteIndex(0);
        list.display();

        System.out.println("\n--- PRUEBA 13: Eliminar un elemento intermedio (SKU 5) ---");
        list.delete(5);
        list.display();

        System.out.println("\n--- PRUEBA 14: Eliminar el último ---");
        list.deleteIndex(2);
        list.display();

        System.out.println("\n--- PRUEBA 15: Intentar eliminar un elemento inexistente ---");
        list.delete(888);
        list.deleteIndex(20);
    
    }
}
