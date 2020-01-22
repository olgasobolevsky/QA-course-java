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
