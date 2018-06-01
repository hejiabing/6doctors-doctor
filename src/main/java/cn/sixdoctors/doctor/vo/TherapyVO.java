package cn.sixdoctors.doctor.vo;

import cn.sixdoctors.doctor.model.Case;
import cn.sixdoctors.doctor.model.Therapy;
import cn.sixdoctors.doctor.util.DateUtils;

import java.util.Date;
import java.util.List;

public class TherapyVO {
    private int therapyId;
    private int doctorId;
    private String doctorName;
    private int patientId;
    private String patientName;
    private String state;
    private String date;
    private String record;
    private List<Case> photos;

    public TherapyVO() {
    }

    public TherapyVO(Therapy therapy, List<Case> photos, String doctorName, String patientName) {
        this.therapyId = therapy.getTherapyId();
        this.doctorId = therapy.getDoctorId();
        this.patientId = therapy.getPatientId();
        this.state = therapy.getState();
        this.date = DateUtils.getDateString(therapy.getDate());
        this.record = therapy.getRecord();
        this.photos = photos;
        this.doctorName = doctorName;
        this.patientName = patientName;
    }

    public int getTherapyId() {
        return therapyId;
    }

    public void setTherapyId(int therapyId) {
        this.therapyId = therapyId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public List<Case> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Case> photos) {
        this.photos = photos;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    @Override
    public String toString() {
        return "TherapyVO{" +
                "therapyId=" + therapyId +
                ", doctorId=" + doctorId +
                ", doctorName='" + doctorName + '\'' +
                ", patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", state='" + state + '\'' +
                ", date='" + date + '\'' +
                ", record='" + record + '\'' +
                ", photos=" + photos +
                '}';
    }
}
