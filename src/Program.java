import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.String.format;

/**
 * This program shows menu for user to: add teacher/student, print people, print teachers/students,
 * find teacher/student by ID, edit students scores.
 */
public class Program {
    public static void main(String[] args) {
        ArrayList<Person> people=new ArrayList<Person>(); //List of people: teachers and students
        boolean flag=true;
        while (flag){
            Scanner scn = new Scanner(System.in);
            mainMenu(); //Show main menu on the screen
            int option;
            if (scn.hasNextInt()) { //check if the user has entered integer or ask him again
                option= scn.nextInt(); //Choose an option (0-8)
                switch (option)
                {
                    case 1: //Add new teacher
                        people.add(new Teacher());
                        break;
                    case 2: //Add new student
                        people.add(new Student());
                        break;
                    case 3: //Print all people
                        if (people.size() !=0) { //if the list of people isn't empty
                            printPersonsArray(people);
                        }
                        else{
                            System.out.println("The list of people is empty ");
                        }
                        break;
                    case 4: //Print all teachers
                        ArrayList <Teacher> teachersArray = new ArrayList<Teacher>();
                        for (Person p:people){
                            if (p instanceof Teacher){ //if this person is a teacher, add him to the teachers list
                                teachersArray.add((Teacher)p);
                            }
                        }
                        if (teachersArray.size()==0){
                            System.out.println("No teachers found");
                        }
                        else{
                            printTeachersArray(teachersArray);
                        }
                        break;
                    case 5: //Print all students
                        ArrayList <Student> studentsArray = new ArrayList<Student>();
                        for (Person p:people){
                            if (p instanceof Student){ //if this person is a student, add him to the students list
                                studentsArray.add((Student)p);
                            }
                        }
                        if (studentsArray.size()==0){
                            System.out.println("No students found");
                        }
                        else{
                            printStudentsArray(studentsArray);
                        }
                        break;
                    case 6: //Find teacher by ID
                        int teacherId = Person.readInt("ID number", scn); //read ID number from the user
                       ArrayList <Teacher> teacher=new ArrayList<Teacher>();
                       //go throw the people list and check every person: if he is a teacher and if he has the ID that user gave
                        for (Person p: people){
                            if ((p instanceof Teacher) && (p.getId()==teacherId)){
                                teacher.add((Teacher) p);
                            }
                        }
                        if (teacher.size()==0){
                            System.out.println("No teacher with this ID number");
                        }
                        else {
                            printTeachersArray(teacher);
                        }
                        break;
                    case 7: //Find student by ID
                        int studentId = Person.readInt("ID number", scn);
                        ArrayList <Student> student=new ArrayList<Student>();
                        //go throw the people list and check every person: if he is a student and if he has the ID that user gave
                        for (Person p: people){
                            if ((p instanceof Student) && (p.getId()==studentId)){
                                student.add((Student)p);
                            }
                        }
                        if (student.size()==0){ //If there is no student with given ID
                            System.out.println("No student with this ID number");
                        }
                        else { //If there is a student with given ID, than you can edit his scores
                            printStudentsArray(student);
                            editStudent(student, scn);
                        }
                        break;
                    case 8: //Find students with average score between minimum and maximum
                        ArrayList <Student> studentsList=new ArrayList<Student>();
                        double minimum;
                        double maximum;
                        minimum=Person.readDouble("Minimum score", scn);//read minimum score from user
                        maximum=Person.readDouble("Maximum score",scn);//read maximum score from user
                        //go throw the people list and check every person: if he is a student and if his average score
                        //between minimum and maximum scores
                        for (Person p: people){
                            if (p instanceof Student){
                                double avgScore=((Student) p).getAverageScore();
                                if (avgScore>=minimum && avgScore<=maximum) {
                                    studentsList.add((Student) p);
                                }
                                }
                            }
                        if (studentsList.size()>0){
                            printStudentsArray(studentsList);
                        }
                        else {
                            System.out.println("No students match the conditions");
                        }
                        break;
                    case 0: //Quit
                        flag=false;
                        break;
                    default: //Error - wrong option
                        System.out.println("Wrong option");
                }
            } else {
                System.out.println("Choose a number");
                scn.next();
            }

        }
    }

    /**
     * This function shows the Main menu on the screen
     */
    public static void mainMenu(){
        System.out.println("Main Menu: Choose one option please:");
        System.out.println("(1) Add Teacher");
        System.out.println("(2) Add Student");
        System.out.println("(3) Show All People");
        System.out.println("(4) Show All Teachers");
        System.out.println("(5) Show All Students");
        System.out.println("(6) Show Teacher By ID");
        System.out.println("(7) Show Student By ID");
        System.out.println("(8) Show Students By Score Range");
        System.out.println("(0) Quit");
    }

    /**
     * This function shows the Edit Student menu on the screen
     */
     public static void editStudentMenu(){
         System.out.println("Student Menu: Choose one option please:");
         System.out.println("(1) Show All Scores");
         System.out.println("(2) Insert a New Score");
         System.out.println("(3) Show Average Score");
         System.out.println("(0) Return to the Main menu");
     }

    /**
     * This function prints array of Person objects in a table with:
     * Ind)  Position|ID       |First name     |Last name      |M.status|Score\Wage
     * @param persons
     */
    public static void printPersonsArray(ArrayList<Person> persons){
        System.out.println("Ind )Position|ID       |First name     |Last name      |M.status|Avg.score\\Wage");
        for (int i=0; i<persons.size();i++){
            Person temp=persons.get(i);
            if (temp instanceof Student){
                System.out.println(format("%-4d)%-8s|",i+1," Student")+temp);
            }else {
                if (temp instanceof Teacher) {
                    System.out.println(format("%-4d)%-8s|", i + 1, " Teacher") + temp);
                }
                else{
                    System.out.println(format("%-4d)%-8s|", i + 1, " Person") + temp);
                }
            }
        }
        System.out.println();
    }

    /**
     * This function prints array of Teacher objects in a table with:
     * Ind) ID       |First name     |Last name      |M.status|Wage
     * @param teachers
     */
    public static void printTeachersArray(ArrayList<Teacher> teachers){
        System.out.println("Ind )ID       |First name     |Last name      |M.status|Wage");
        for (int i=0; i<teachers.size();i++){
            Person temp=teachers.get(i);
                System.out.println(format("%-4d)",i+1)+temp);
        }
        System.out.println();
    }

    /**
     * This function prints array of Teacher objects in a table with:
     * Ind) ID       |First name     |Last name      |M.status|Avg.score
     * @param students
     */
    public static void printStudentsArray(ArrayList<Student> students){
        System.out.println("Ind )ID       |First name     |Last name      |M.status|Avg.Score");
        for (int i=0; i<students.size();i++){
            Person temp=students.get(i);
            System.out.println(format("%-4d)",i+1)+temp);
        }
        System.out.println();
    }

    /**
     * This function shows the menu for a specific student to: show scores, add score, show average score.
     * @param student
     * @param scn
     */
    public static void editStudent(ArrayList<Student> student, Scanner scn){
        boolean flag = true;
        while (flag) {
            editStudentMenu(); //print the menu on the screen
            int option;
            if (scn.hasNextInt()) { //check if the user has entered integer or ask him again
                option = scn.nextInt();
                switch (option) {
                    case 1: //show scores
                        for (Student s: student){
                            s.showScores();
                        };
                        break;
                    case 2: //add new score
                        String courseName=Person.readString("Course name", scn); //get course name from the user
                        double score=Person.readDouble("Score", scn); //get score from the user
                        for (Student s: student){
                            s.addScore(courseName, score);
                        };
                        break;
                    case 3: //show average score
                        System.out.println(format("%-15s|%-15s|%s","First name","Last name","Avg. Score"));
                        for (Student s: student){
                            System.out.println(format("%-15s|%-15s|%f",s.getFirstName(),s.getLastName(),s.getAverageScore()));
                        };
                        break;
                    case 0: //quit
                        flag = false;
                        break;
                    default:
                        System.out.println("Wrong option");
                }
            } else {
                System.out.println("Choose a number");
                scn.next();
            }
        }

    }
}