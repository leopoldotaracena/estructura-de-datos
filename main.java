
public class main{
   static class Node{
        String data;
        Node next;

        Node(String data){
            this.data=data;
            this.next=null;
        }
    }
    static class Stack{
        Node top;

        Stack(){
            top=null;
        }
    //AGREGAR
        public void push(String data){

            Node newNode=new Node(data);
            newNode.next=top;
            top=newNode;
        }
    //ELIMINAR Y RETORNAR
        public String pop(){
            if(top==null){
                return "la pila esta vacia";
            }

            String value=top.data;
            top=top.next;
            return value;

        }
    //VER SIN MODIFICAR
        public String peek(){
            if(top==null){
                return "la pila esta vacia";
            }

            return top.data;
        }
    //VERIFICAR SI ESTA VACIA 
        public boolean isEmpty(){ 
            return top== null;
        }
    //TAMAÑO        
        public int size(){
            int cont=0;
            Node current=top;
            while(current !=null){
                cont ++;
                current=current.next;
            }
            return cont;
            
        }
    //HISTORIAL
       public String Historial() {
        if (isEmpty()) {
            return "La pila está vacía";
        }
        StringBuilder sb = new StringBuilder();
        Node current = top;
    
        while (current != null) {
            sb.append(current.data);
            if (current == top) {
                sb.append(" <- TOP");
            }
            sb.append("\n");
            current = current.next;
        }
        return sb.toString();
        }
    }
    

    public static void main(String[] args) {
        Stack stack=new Stack();
        //System.out.println("AGREGANDO A,B,C,D");
        //stack.push("A");
        //System.out.println(stack.peek());
        //stack.push("B");
        //System.out.println(stack.peek());
        //stack.push("C");
        //System.out.println(stack.peek());
        //stack.push("D");
        //System.out.println(stack.peek());


        //System.out.println("ELIMINANDO D,C,B,A");

        //System.out.println(stack.pop());
        //System.out.println(stack.pop());
        //System.out.println(stack.pop());
        //System.out.println(stack.pop());


        //STACK VACIO
        System.out.println(stack.peek());
        System.out.println(stack.size());
        System.out.println(stack.pop());

        //PRUEBA
        stack.push("crear documento");
        stack.push("editar documento");
        stack.push("renombrar documento");
        

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        

    }
}
