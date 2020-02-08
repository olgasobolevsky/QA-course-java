/**
 * This class represents a students score.
 * It has two variables: course - course name and value - the score.
 * The score must be a number between 0 and 100
 */

public class Score {
    private String course;
    private double value;

    public Score(String course, double value) {
        setCourse(course);
        setValue(value);
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        if (value <0){
            this.value=0;
        }
        else {
        if (value>100){
            this.value=100;
        }
        else {
            this.value = value;
        }
        }
    }
}
