// public class main {
//   public static void main(String[] args) {
//     System.out.println("Hello World");
//   }
// }


public class main{
  // public static void main(String[] args){

  //   String[] cars = { "c1", "c2", "c3", "c4" };
  
  //   System.out.println(cars[1]);

  // }


  // public static void main(String[] args){
  //   int[] numbers = {1,2,3,4,5,6};
  //   System.out.println(numbers[0]);
  // }

  // public static void main(String[] args){
  //     int s = 10;
  //     for(int i = 0; i < s; i++){
  //       for(int j = 0; j <= i; j++){
  //         System.out.println("*");
  //       }
  //     }
  // }

  // public static void mymethod(){
  //     int rows = 5;
  //     for(int i = 1; i < rows; i++){
  //       for(int j = 1; j <= i; j++){
  //         System.out.print("*");
  //       }
  //       System.out.println();
  //     }
  // }

  // public static void main(String[] args){
  //     mymethod();
  // }


//     public static void main(String[] args) {
//         int rows = 5;
//         for (int i = 1; i <= rows; i++) { // Outer loop for rows
//             for (int j = 1; j <= i; j++) { // Inner loop for stars
//                 System.out.print("*");
//             }
//             System.out.println(); // Moves to the next line
//         }
//     }
// static String myMethod(String fname, int age){
//    return "the name of person is " + fname + " " + "and age of this person is " + age;
// }

static void fac(int n){
   if (n > 1) {
      return n * fac(n - 1);
    } else {
      return 1;
    }
}

public static void main(String[] args){
  // System.out.println(myMethod("sam", 5));
  
   System.out.println( fac(5));



}



}