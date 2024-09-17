public class Mydetails {

    public static void main(String[] args) {

        String name = "Sami Ur Rehman";
        String reg  = "SP24-BSE-086";
        char section = 'B';
        float cgpa = 3.1f;

        // Define a fixed width for the labels to align the colons
        System.out.printf("%-15s : %s\n", "Registration No", reg);
        System.out.printf("%-15s : %s\n", "Name", name);
        System.out.printf("%-15s : %c\n", "Section", section);
        System.out.printf("%-15s : %.2f\n", "CGPA", cgpa);

    }
}
