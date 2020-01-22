import java.util.Scanner;

public class Person {
    public enum MaritalStatus{SINGLE, MARRIED, DIVORCED}
    private int id;
    private String firstName;
    private String lastName;
    private  MaritalStatus status;

    public Person() {
       input();
    }

    public void input(){

        Scanner scn=new Scanner(System.in);

        setId(readInt("ID number", scn));

        setFirstName(readString("First name", scn));

        setLastName(readString("Last name", scn));

        setStatus(readMaritalStatus(scn));

    }

    public static int readInt(String msg, Scanner scn){
        int temp=-1;
        while (temp == -1){
        System.out.println("Enter the "+msg);
            if (scn.hasNextInt()) {
                temp= scn.nextInt();
            } else {
                System.out.println(msg + " must be an integer");
                scn.next();
            }
        }
        return temp;
    }

    public static double readDouble(String msg, Scanner scn){
        double temp=-1;
        while (temp == -1){
            System.out.println("Enter the "+msg);
            if (scn.hasNextDouble()) {
                temp= scn.nextDouble();
            } else {
                System.out.println(msg + " must be a number");
                scn.next();
            }
        }
        return temp;
    }

    public static String readString(String msg, Scanner scn){
        String temp="";
        System.out.println("Enter the " + msg);
        if (scn.hasNext()) {
            temp = scn.next();
            }
        return temp;
    }

    public static MaritalStatus readMaritalStatus(Scanner scn){
        while (true) {
            System.out.println("Choose marital status: (S)ingle, (M)arried, (D)ivorced");
            switch ((scn.next()).toLowerCase()) {
                case "s":
                    return MaritalStatus.SINGLE;
                case "m":
                    return MaritalStatus.MARRIED;
                case "d":
                    return MaritalStatus.DIVORCED;
                default:
                    System.out.println("Wrong choice");
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%-9d|%-15s|%-15s|%-8s|", getId(), getFirstName(), getLastName(), getStatus());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public MaritalStatus getStatus() {
        return status;
    }

    public void setStatus(MaritalStatus status) {
        this.status = status;
    }
}
