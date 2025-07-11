package CollectionGenericLambda;
import java.util.*;

class Student<T extends Number>{
    private String name;
    private T score;

    public Student(String name, T score){
        this.name = name;
        this.score = score;
    }

    public String getName(){
        return name;
    }

    public T getScore(){
        return score;
    }

    @Override
    public String toString(){
        return name + "-" + score;
    }
}
public class CollectionGenericLambdaDemo{
    public static void main(String[] args) {
        //Danh sach hoc sinh 
        List<Student<Double>> students = new ArrayList<>();
        students.add(new Student<>("An", 7.5));
        students.add(new Student<>("Binh", 8.2));
        students.add(new Student<>("Cuong", 6.0));
        students.add(new Student<>("Dung", 9.0));

        //Sap xep tang dan
        students.sort((s1,s2) -> Double.compare(s1.getScore(), s2.getScore()));

        System.out.println("Danh sach sau khi sap xep theo diem:");
        students.forEach(s -> System.out.println(s));

        //Loc ra hoc sinh tren 8 diem (Dung filter)
        System.out.println("\nHoc sinh gioi(>=8) :");
        students.stream()
            .filter(s -> s.getScore() >=8)
            .forEach(System.out::println);
    }
}
