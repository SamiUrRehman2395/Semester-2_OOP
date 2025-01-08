package comparator_comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {

//        Comparator<comparator_comparable.Students> com = new Comparator<comparator_comparable.Students>() {
//            public int compare(comparator_comparable.Students s1, comparator_comparable.Students s2) {
//                if(s1.age > s2.age)
//                    return 1;
//                else
//                    return -1;
//            }
//        };

        //or

//        Comparator<comparator_comparable.Students> com = (comparator_comparable.Students s1, comparator_comparable.Students s2) -> {
//                if(s1.age > s2.age)
//                    return 1;
//                else
//                    return -1;
//            };

        //or

        Comparator<Students> com = (Students s1, Students s2) -> s1.age > s2.age ? 1 : -1;


        List<Students> nums = new ArrayList<>();

        nums.add(new Students(20, "Alex"));
        nums.add(new Students(18, "James"));
        nums.add(new Students(24, "Stuart"));

        Collections.sort(nums, com);
        System.out.println(nums);

    }
}

class Students{
    int age;
    String name;

    public Students(int age, String name) {
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
}
