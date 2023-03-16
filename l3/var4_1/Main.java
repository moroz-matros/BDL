package l3.var4_1;

/*
 * Построить модель программной системы.
 *
 * 3. Система Больница. Пациенту назначается лечащий Врач.
 * Врач может сделать назначение Пациенту (процедуры, лекарства, операции).
 * Медсестра или другой Врач выполняют назначение. Пациент может быть выписан из
 * Больницы по окончании лечения, при нарушении режима или при иных обстоятельствах.
 */

public class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();

        Doctor doctor1 = new Doctor("John");
        Doctor doctor2 = new Doctor("Jane");

        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);

        Patient patient1 = new Patient("Alice");
        Patient patient2 = new Patient("Bob");

        hospital.addPatient(patient1);
        hospital.addPatient(patient2);

        hospital.setAttendingDoctor(patient1, doctor1);
        hospital.setAttendingDoctor(patient2, doctor2);

        hospital.makeAppointment(patient1, doctor1, "Checkup");
        hospital.makeAppointment(patient1, doctor2, "Surgery");
        hospital.makeAppointment(patient2, doctor2, "Surgery");

        hospital.performAppointment(patient1, doctor2, "Checkup");
        hospital.performAppointment(patient2, doctor1, "Checkup");

        hospital.dischargePatient(patient1);
        hospital.dischargePatient(patient2);

        System.out.printf("Patient %s discharged: %b\n", patient1.getName(), patient1.isDischarged());
        System.out.printf("Patient %s discharged: %b\n", patient2.getName(), patient2.isDischarged());
    }
}
