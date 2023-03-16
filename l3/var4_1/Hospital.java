package l3.var4_1;

import java.util.ArrayList;
import java.util.List;

class Hospital {
    private List<Patient> patients;
    private List<Doctor> doctors;

    public Hospital() {
        patients = new ArrayList<>();
        doctors = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void makeAppointment(Patient patient, Doctor doctor, String appointment) {
        doctor.addAppointment(patient, appointment);
    }

    public void performAppointment(Patient patient, Doctor doctor, String appointment) {
        doctor.performAppointment(patient, appointment);
    }

    public void dischargePatient(Patient patient) {
        patient.discharge();
    }

    public void setAttendingDoctor(Patient patient, Doctor doctor) {
        patient.setAttendingDoctor(doctor);
    }
}
