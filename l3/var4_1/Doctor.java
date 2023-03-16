package l3.var4_1;

public class Doctor {
    private String name;

    public Doctor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPatient(Patient patient) {
        patient.setAttendingDoctor(this);
    }

    public void addAppointment(Patient patient, String appointment) {
        patient.addAppointment(this, appointment);
    }

    public void performAppointment(Patient patient, String appointment) {
        if (patient.performAppointment(appointment)) {
            System.out.println("Performing appointment for patient " + patient.getName() + ": " + appointment);
            return;
        }
        System.out.println("No such appointment for patient " + patient.getName() + ": " + appointment);
    }
}
