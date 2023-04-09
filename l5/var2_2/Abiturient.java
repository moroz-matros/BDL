package l5.var2_2;

import java.util.Arrays;

public class Abiturient {
    private int id;
    private String surname;
    private String name;
    private String patronimyc;
    private String address;
    private String phoneNumber;
    private float[] scores;

    public Abiturient(int id, String surname, String name, String patronimyc,
            String address, String phoneNumber, float[] scores) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronimyc = patronimyc;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.scores = scores;
    }

    public Abiturient() {
        this.id = 0;
        this.surname = "";
        this.name = "";
        this.patronimyc = "";
        this.address = "";
        this.phoneNumber = "";
        this.scores = new float[0];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronimyc() {
        return patronimyc;
    }

    public void setPatronimyc(String patronimyc) {
        this.patronimyc = patronimyc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws InvalidPhoneException {
        if (phoneNumber.length() != 11) {
            throw new InvalidPhoneException("invalid number");
        }
        this.phoneNumber = phoneNumber;
    }

    public float[] getScores() {
        return scores;
    }

    public void setScores(float[] scores) {
        this.scores = scores;
    }

    public float getAverageScore() {
        float sum = 0;
        for (float score : scores) {
            sum += score;
        }
        return sum / scores.length;
    }

    @Override
    public String toString() {
        return "Abiturient{" +
                "id=" + id + ", surname=" + surname + ", name=" + name + ", patronimyc="
                + patronimyc + ", address=" + address + ", phoneNumber=" + phoneNumber +
                ", scores=" + Arrays.toString(scores) + '}';
    }
}
