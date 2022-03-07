package sk.uniza.fri;
/**
 * Created by IntelliJ IDEA.
 * User: Michal
 * Date: 28. 2. 2022
 * Time: 12:57
 */
public class Main {

    public static void main(String[] args) {
        //TODO Write your code
        System.out.println("Hello world");
        Student student1 = new Student("12345", "Janko", "Hrasko");
        Student student2 = new Student("12342", "Ferko", "Hrasko");
        Skupina s = new Skupina("5A");
        s.pridajStudenta(student1);
        s.vypisStudentov();
    }

}
