public class mainFun {
    public static void countdown(int n) {

        if (n == 0) {
            // System.out.println("Blast off!");
            return;
        }
        
        // Action
        System.out.print(n + " ");
        
        countdown(n-1);
       
    }

    public static void main(String[] args) {
        countdown(6); 
        System.out.println("completed");
    }


}
