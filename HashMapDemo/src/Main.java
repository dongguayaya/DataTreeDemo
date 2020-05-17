import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        int a=42;
        System.out.println(((Integer)a).hashCode());
        int b=-42;
        System.out.println(((Integer)b).hashCode());

        double c=3.1415926;
        System.out.println(((Double)c).hashCode());

        String d="test";
        System.out.println(d.hashCode());

        Student stu=new Student(3,2,"Dong","Dong");
        System.out.println(stu.hashCode());

        HashSet<Student> set=new HashSet<>();
        set.add(stu);

        HashMap<Student,Integer> scores=new HashMap<>();
        scores.put(stu,100);

        Student stu2=new Student(3,2,"Dong","Dong");
        System.out.println(stu2.hashCode());
    }
}
