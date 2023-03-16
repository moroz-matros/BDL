package l3.var4_2;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

public class EntranceExams {
    private List<Applicant> applicants;
    private List<Teacher> teachers;

    private Dictionary<String, Double> averageScores;

    public EntranceExams() {
        applicants = new ArrayList<>();
        teachers = new ArrayList<>();
        averageScores = new Hashtable<>();
    }

    public void registerApplicant(Applicant applicant) {
        applicants.add(applicant);
        averageScores.put(applicant.getFaculty(), 0.0);
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void giveAssessment(Applicant applicant, Teacher teacher, int score) {
        teacher.addAssessment(applicant, score);
    }

    public List<Applicant> getEnrolledApplicants() {
        this.countAverages();
        List<Applicant> enrolledApplicants = new ArrayList<>();
        for (Applicant applicant : applicants) {
            if (applicant.getAverageScore() >= this.averageScores.get(applicant.getFaculty())) {
                enrolledApplicants.add(applicant);
            }
        }
        return enrolledApplicants;
    }

    public void countAverages() {
        Enumeration<String> keys = this.averageScores.keys();
        while (keys.hasMoreElements()) {
            String faculty = keys.nextElement();
            Double sum = 0.0;
            Integer n = 0;
            for (Applicant applicant : applicants) {
                if (applicant.getFaculty() == faculty) {
                    sum += applicant.getAverageScore();
                    n += 1;
                }
            }
            if (n != 0) {
                this.averageScores.put(faculty, sum / n);
            }
        }
    }
}
