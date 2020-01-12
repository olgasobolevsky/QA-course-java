import com.sun.jdi.InvalidTypeException;

import java.util.Scanner;

public class Person {
    public enum MaritalStatus{SINGLE, MARRIED, DEVORCED}
    private int id;
    private String firstName;
    private String lastName;
    private  MaritalStatus status;

    public Person(int id, String firstName, String lastName, MaritalStatus status) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setStatus(status);
    }

    public void input(){
        int id;
        String firstName;
        String lastName;
        MaritalStatus status;
        Scanner scn=new Scanner(System.in);
        System.out.println("Enter the id number");
        while (!scn.hasNextInt()){
            System.out.println("Id number must be an integer");
            System.out.println("Enter the id number: ");
            }
        id=scn.nextInt();
        System.out.println("Enter the first name");
        while (!scn.hasNext()){
            System.out.println("Enter the first name");
        }
        firstName=scn.next();
        System.out.println("Enter the last name");
        while (!scn.hasNext()){
            System.out.println("Enter the last name");
        }
       lastName=scn.next();
        System.out.println("Choose marital status: (S)ingle, (M)arried, (D)evorced");
        switch ((scn.next()).toLowerCase()){
            case "s": status=MaritalStatus.SINGLE;
            break;
            case "m": status=MaritalStatus.MARRIED;
            break;
            case "d": status=MaritalStatus.DEVORCED;
            break;
            default
        }
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
