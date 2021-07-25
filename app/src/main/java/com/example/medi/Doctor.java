package com.example.medi;

public class Doctor {
    String DoctorName,DoctorPhoto;

    public Doctor() {
    }


    public Doctor(String doctorName, String doctorPhoto) {
        DoctorName = doctorName;
        DoctorPhoto = doctorPhoto;
    }

    public String getDoctorPhoto() {
        return DoctorPhoto;
    }

    public void setDoctorPhoto(String doctorPhoto) {
        DoctorPhoto = doctorPhoto;
    }

    public String getDoctorName() {
        return DoctorName;
    }

    public void setDoctorName(String doctorName) {
        DoctorName = doctorName;
    }
}
