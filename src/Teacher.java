import java.util.Scanner;

/**
 * This class represents a teacher and it extends class Person.
 * Teacher is represented by persons properties (id number, first name, last name, marital status)
 * and by wage.
 */
public class Teacher extends Person{
    private int wage;

    public Teacher() {
        super();
    }

    @Override
    public void input() {
        super.input();
        Scanner scn = new Scanner(System.in);
        setWage(readInt("Wage",scn));
    }

    @Override
    public String toString() {
        return super.toString()+String.format("%8d",getWage());
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }


}
