package l3.var4_2;

public class Teacher {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher(String name) {
        this.name = name;
    }

    public void addAssessment(Applicant applicant, int score) {
        applicant.addExamScore(score);
        System.out.println("Assessment added for applicant " + applicant.getName() + ": " + score);
    }
}
