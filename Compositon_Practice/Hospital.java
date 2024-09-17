class Patient{

    private String patientName;
    private String assignedDr;

    public void setPatientName(String n){
        patientName = n;
    }
    public String getPatientName(){
        return patientName;
    }
    public void setDr(String d){
        assignedDr = d;
    }
    public String getAssignedDr(){
        return assignedDr;
    }

    public void display(){
        System.out.println( "Patient Name: " +patientName);
        System.out.println("Assigned Doctor: " +assignedDr);
    }
}

class Ward{

    private String wardName;
    private Patient patient1;
    private Patient patient2;

    public void setWardName(String w){
        wardName = w;
    }
    public void setPatient1(Patient n1){
        patient1 = n1;
    }
    public void setPatient2(Patient n2){
        patient2 = n2;
    }
    public String getWardName(){
        return wardName;
    }
    public Patient getPatient1Name(){
        return patient1;
    }
    public Patient getPatient2Name(){
        return patient2;
    }

    public void displayInfo(){
        System.out.println( "Ward Name: " +wardName);
        patient1.display();
        patient2.display();
    }



}

public class Hospital {
    public static void main(String[] args) {

        Ward ward = new Ward();
        ward.setWardName("Surgical Ward");

        Patient p1 = new Patient();

        p1.setDr("Dr. James Franklin");
        p1.setPatientName("Mr. Adam");

        Patient p2 = new Patient();

        p2.setDr("Dr. John Smith");
        p2.setPatientName("Mr. Robert");

        ward.setPatient1(p1);
        ward.setPatient2(p2);

        ward.displayInfo();

    }
}
