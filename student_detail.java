class student_detail{
    String name;
    int class_no;

    student_detail(){
        name = "Anuj";
        class_no = 9;
    }
    public static void main(String[] args){
        System.out.println("hello");
        student_detail x = new student_detail();
        System.out.println("your name is " + " " + x.name + " and you study in class " + x.class_no);
    }
}