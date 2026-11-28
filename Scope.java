class Scope{
    String name = "abdul";
    int age = 15;
    static String course = "Java";
    public static void main(String[] args){
        Scope s = new Scope();
        System.out.println("Nem " + s.name);
        System.out.println(s.age);
        System.out.println(course);

    }
}