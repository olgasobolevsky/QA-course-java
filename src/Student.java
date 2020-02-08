import java.util.ArrayList;

/**
 * This class represents a student and it extends class Person.
 * Student is represented by persons properties (id number, first name, last name, marital status)
 * and list of scores.
 */
public class Student extends Person {
    private ArrayList<Score> scores;

    public Student() {
        super();
        scores=new ArrayList<Score>();
    }

    public ArrayList<Score> getScores() {
        return scores;
    }

    public void setScores(ArrayList<Score> scores) {
        this.scores = scores;
    }

    public void addScore(Score s){
        this.scores.add(s);
    }

    public void addScore(String course, double score){
        this.scores.add(new Score(course,score));
    }

    public double getAverageScore(){
        if (this.scores.size()==0){ return 0 ;}
        else {
            double sumOfScores = 0;
            for (Score s : this.scores) {
                sumOfScores += s.getValue();
            }
            return sumOfScores / this.scores.size();
        }
    }

    public void showScores(){
        if (scores.size()==0){
            System.out.println("No scores to show");
        }
        else {
            int i=1;
            System.out.println(String.format("%3s)%-10s|%-10s","Ind","Course","Score"));
            for (Score s : scores) {
                System.out.println(String.format("%03d)%-10s|%-10f",i,s.getCourse(),s.getValue()));
                i++;
            }
        }
    }

    @Override
    public String toString() {
        return super.toString()+String.format("%8f",getAverageScore());
    }
}
