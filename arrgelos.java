public class Arreglos{
    public static void main(String[] args) {
        

 

int[] a = { 8, 3, 10, 22, 1, 9};
  for(int i = 0; i < a.length; i++ ){
   System.out.println("a["+ i +"]=" +a[i]);


  }

 int tam=10;
  int[] b = new int[tam];
  
for(int i = 0; i< b.length;i++){
b[i]= (int)  (Math.random()  *( 30 + 10)) - 10;




System.out.println("b["+ i +"]=" +b[i]);
}
}
}