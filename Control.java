public class Control{
    // public static void main(String[] args){
    //     int a = 9;
    //     // if(a==5){
    //     //     System.out.println("Hello World!");
    //     // }
    //     if(a>10){
    //         System.out.println("Hello World!");
    //     }else{
    //         System.out.println("HI World!");
    //         if(a>8){
    //             System.out.println("World!");
    //         }
    //     }
    // }

//switch case
// dealing with no with days according
    public static void main(String[] args){
        int n = 2;
        switch(n)
        {
            case 1:  
            System.out.println("Monday");
                break;
            case 3:  
            System.out.println("Wednesday");
                break;
            case 5:  
            System.out.println("Friday");
                break;
            default:
            System.out.println("No week days");
        }
       
    }
}