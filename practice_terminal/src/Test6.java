package comparator_comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test6 {
    public static void main(String[] args) {



        List<Student> nums = new ArrayList<>();

        nums.add(new Student(20, "Alex"));
        nums.add(new Student(18, "James"));
        nums.add(new Student(24, "Stuart"));

        Collections.sort(nums);
        System.out.println(nums);

    }
}

class Student implements Comparable<T> {
    int age;
    String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "comparator_comparable.Students{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

//    @Override
//    public int compareTo(Student that) {
//        if (this.age > that.age) {
//            return 1;
//        }
//        else{
//            return -1;
//        }
//
//    }

    @Override
    public <T> int compareTo(T that) {
        if (this.age > that.age) {
//            return 1;
//        }
//        else{
//            return -1;
//        }
        }
    }
}
