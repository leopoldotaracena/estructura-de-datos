public class actividad3 {
    
        //desafio 1
    static int count(int n){
        if(n<10){
            return n;
        }
        int suma=(n%10)+count(n/10);
        return count(suma);
        
    }
   
    //desafio 2
    static int max(int[] array, int start, int end){
    if(start == end){
      return array[start];
    }
    int middle = (start + end) / 2;  
    
    int leftMax = max(array, start, middle);
    int rightMax = max(array, middle + 1, end);

    return Math.max(leftMax, rightMax);
   }



     public static void main(String[] args){

        //System.out.println(sum(12345));

        int[] numbers={418, 732, 156, 894, 327, 641, 285, 519,
        763, 204, 947, 386, 675, 128, 856, 493};

        System.out.println(count(84729));
        System.out.println(count(56318));
        System.out.println(count(92746));

        System.out.println(max(numbers,0,numbers.length-1));
     }
}


