public class queue{
    static class Node{
        String data;
        Node next;

        Node(String data){
            this.data=data;
            this.next=null;
        }
        

    }
    static class Queue{
        Node front;
        Node rear;

        Queue(){
            front=null;
            rear=null;
        }
//AGREGAR
         public void enqueue(String data){
            Node newNode=new Node(data);
            if(front==null ){
                front=newNode;
                rear=newNode;
                return;
            }

            rear.next=newNode;
            rear=newNode;
        }
//ELIMINAR Y RETORNARLO
        public String dequeue(){
            if (front==null){

               return"la cola esta vacia";

            }

            String value=front.data; 
            front=front.next; 

            
            if (front==null){
                rear=null;
            }

            
            return value;
        }
// VER ELEMENTO SIN MODIFICAR NADA
        public String peek(){
            if (front==null){
               return  "la cola esta vacia";
               
            }
            return front.data;
        }
//VERIFICAR SI ESTA VACIA 
         public boolean isEmpty(){
            return front==null;
        }
// TAMAÑO
        public int size(){
            Node current;
            int cont=0;
            current=front;
            while (current != null) { 
                cont++;
                current=current.next;
            }
            return cont;
        }
//HISTORIAL DE REGISTRO
       public String Pendientes() {
        if (isEmpty()) {
            return "La cola está vacía";
        }
        StringBuilder sb = new StringBuilder();
        Node current = front;
    
        while (current != null) {
            sb.append(current.data);
            if (current == front) {
                sb.append(" <- FRONT");
            }
            if (current == rear) {
                sb.append(" <- REAR");
            }
            sb.append("\n");
            current = current.next;
        }
        return sb.toString();
        }


    }

    public static void main(String[] args) {
            Queue queue =new Queue();
            //System.out.println("AGREGANDO A,B,C,D");
            //queue.enqueue("A");
            //queue.enqueue("B");
            //queue.enqueue("C");
            //queue.enqueue("D");
            //System.out.println(queue.Pendientes());
            


            //System.out.println("ELIMINANDO A,B,C,D");
            //System.out.println(queue.dequeue());
            //System.out.println(queue.dequeue());
            //System.out.println(queue.dequeue());
            //System.out.println(queue.dequeue());



        
            //COLA VACIA
            System.out.println(queue.dequeue());
            System.out.println(queue.size());
            System.out.println(queue.peek());
            System.out.println(queue.isEmpty());
            //PRUEBA
            queue.enqueue("tarea 1");
            queue.enqueue("tarea 2");
            queue.enqueue("tarea 3");

            System.out.println(queue.peek());
            
            System.out.println(queue.dequeue());
            System.out.println(queue.peek());
            System.out.println(queue.size());
            System.out.println(queue.isEmpty());

            System.out.println(queue.Pendientes());
    }
}    
