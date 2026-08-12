public class mainFun {
    public static void countdown(int n) {
        // Base Case: Stop when n hits 0
        if (n <= 0) {
            System.out.println("Blast off!");
            return;
        }
        
        // Action
        System.out.print(n + " ");
        
        // Recursive Call: Call itself with a decremented value
        countdown(n - 1);
    }

    public static void main(String[] args) {
        countdown(5); 
    }
}
