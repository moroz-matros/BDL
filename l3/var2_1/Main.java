package l3.var2_1;

/*  Создать классы, спецификации которых приведены ниже.
    Определить конструкторы и методы setТип(), getТип(), toString().
    Определить дополнительно методы в классе, создающем массив объектов.
    Задать критерий выбора данных и вывести эти данные на консоль.

    3. Patient: id, Фамилия, Имя, Отчество, Адрес, Телефон, Номер медицинской карты, Диагноз.
    Создать массив объектов. Вывести: a) список пациентов, имеющих данный диагноз;
    b) список пациентов, номер медицинской карты у которых находится в заданном интервале.
 */

public class Main {
    public static void main(String[] args) {
        Patient[] patients = {
                new Patient(1, "Smith", "John", "James", "123 Main St", "555-1234", 9, "fever"),
                new Patient(2, "Doe", "Jane", "Marie", "456 Oak St", "555-5678", 12, "cancer"),
                new Patient(3, "Johnson", "Robert", "Lee", "789 Maple St", "555-9012", 14, "fever"),
                new Patient(4, "Williams", "Mary", "Elizabeth", "321 Elm St", "555-3456", 16, "diabetes")
        };

        // List of patients with given diagnosis "fever"
        System.out.println("Patients with diagnosis 'fever':");
        for (Patient patient : patients) {
            if (patient.getDiagnosis().equals("fever")) {
                System.out.println(patient);
            }
        }

        // List of patients with medical card id between 12 and 15
        System.out.println("Patients with medical card ID between 12 and 15:");
        for (Patient patient : patients) {
            if (patient.getMedicalCardId() >= 12 && patient.getMedicalCardId() <= 15) {
                System.out.println(patient);
            }
        }
    }
}
