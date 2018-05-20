package cn.sixdoctors.doctor.model;

import java.util.Date;

/**
 * Created by wangpengcheng on 2018/5/20.
 */
public class Therapy {
    private int therapyId;
    private int doctorId;
    private int patientId;
    private String state;
    private Date date;
    private String recode;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRecode() {
        return recode;
    }

    public void setRecode(String recode) {
        this.recode = recode;
    }

    @Override
    public String toString() {
        return "Therapy{" +
                "therapyId=" + therapyId +
                ", doctorId=" + doctorId +
                ", patientId=" + patientId +
                ", state='" + state + '\'' +
                ", date=" + date +
                ", recode='" + recode + '\'' +
                '}';
    }
}
