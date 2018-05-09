/**
 * @Author: 杨佳畅
 * @Description: 自定义的学生类
 * @Date: Created in 2018/5/3 上午9:55
 */
public class Student {
    private String name;
    private int score;

    public Student(String name , int score){
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString(){
        return String.format("Student(name : %s , score : %d )" , name , score);
    }

    public static void main(String[] args) {
        Array<Student> student = new Array();
        student.addLast(new Student("小明",19));
        student.addLast(new Student("王思聪",31));
        student.addLast(new Student("王八",30));
        System.out.println(student);

    }
}
