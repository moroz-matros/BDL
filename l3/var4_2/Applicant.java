package l3.var4_2;

import java.util.ArrayList;
import java.util.List;

public class Applicant {
    private String name;
    private String faculty;

    private List<Integer> examScores;

    public Applicant(String name, String faculty) {
        this.name = name;
        this.faculty = faculty;
        examScores = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void addExamScore(int score) {
        examScores.add(score);
    }

    public double getAverageScore() {
        double sum = 0;
        for (int score : examScores) {
            sum += score;
        }
        return sum / examScores.size();
    }

}
