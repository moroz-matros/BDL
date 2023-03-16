package l3.var4_1;

import java.util.HashSet;
import java.util.Set;

public class Patient {
    private String name;

    private Doctor attendingDoctor;
    private boolean discharged;

    private Set<String> appointments;

    public Patient(String name) {
        this.name = name;
        this.discharged = false;
        this.appointments = new HashSet<>();
    }

    public void setAttendingDoctor(Doctor doctor) {
        attendingDoctor = doctor;
    }

    public void discharge() {
        if (appointments.isEmpty()) {
            discharged = true;
            return;
        }

        System.out.printf("Can't discharge, %s has appointments %s\n", this.getName(), this.appointments.toString());
    }

    public boolean isDischarged() {
        return discharged;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addAppointment(Doctor doctor, String appointment) {
        if (doctor == attendingDoctor) {
            appointments.add(appointment);
            System.out.printf("Appointment %s added to %s by %s\n", appointment, this.getName(), doctor.getName());
            return;
        }

        System.out.println("Not attending doctor, need " + doctor.getName());
    }

    public boolean performAppointment(String appointment) {
        return appointments.remove(appointment);
    }
}
