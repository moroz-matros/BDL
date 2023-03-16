package l3.var4_2;

import java.util.List;

// 4. Система Вступительные экзамены.
// Абитуриент регистрируется на Факультет, сдает Экзамены.
// Преподаватель выставляет Оценку. Система подсчитывает средний балл и определяет Абитуриентов,
// зачисленных в учебное заведение.

public class Main {
    public static void main(String[] args) {
        EntranceExams system = new EntranceExams();

        Teacher teacher1 = new Teacher("John");
        Teacher teacher2 = new Teacher("Jane");

        system.addTeacher(teacher1);
        system.addTeacher(teacher2);

        Applicant applicant1 = new Applicant("Alice", "Computer Science");
        Applicant applicant2 = new Applicant("Bob", "Mathematics");
        Applicant applicant3 = new Applicant("John", "Mathematics");

        system.registerApplicant(applicant1);
        system.registerApplicant(applicant2);
        system.registerApplicant(applicant3);

        system.giveAssessment(applicant1, teacher1, 4);
        system.giveAssessment(applicant1, teacher2, 5);
        system.giveAssessment(applicant1, teacher1, 5);
        system.giveAssessment(applicant1, teacher2, 3);
        system.giveAssessment(applicant2, teacher1, 2);
        system.giveAssessment(applicant2, teacher2, 2);
        system.giveAssessment(applicant3, teacher1, 5);
        system.giveAssessment(applicant3, teacher2, 3);

        List<Applicant> enrolledApplicants = system.getEnrolledApplicants();

        System.out.println("Enrolled applicants:");
        for (Applicant applicant : enrolledApplicants) {
            System.out.println(applicant.getName() + " - " + applicant.getAverageScore());
        }
    }
}
