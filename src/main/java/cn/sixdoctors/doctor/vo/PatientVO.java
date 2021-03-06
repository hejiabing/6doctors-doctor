package cn.sixdoctors.doctor.vo;

import cn.sixdoctors.doctor.model.Label;

import java.util.List;

public class PatientVO {

    private int patientId;
    private String doctorName;
    private String patientName;
    private String status;
    private String patientIntention;
    private String patientAvatar;

    private List<LabelVO> labels;

    public PatientVO() {
    }

    public PatientVO(int patientId, String doctorName, String patientName, String status, String patientIntention,
                     String patientAvatar) {
        this.patientId = patientId;
        this.doctorName = doctorName;
        this.patientName = patientName;
        this.status = status;
        this.patientIntention = patientIntention;
        this.patientAvatar = patientAvatar;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPatientIntention() {
        return patientIntention;
    }

    public void setPatientIntention(String patientIntention) {
        this.patientIntention = patientIntention;
    }

    public String getPatientAvatar() {
        return patientAvatar;
    }

    public void setPatientAvatar(String patientAvatar) {
        this.patientAvatar = patientAvatar;
    }

    public List<LabelVO> getLabels() {
        return labels;
    }

    public void setLabels(List<LabelVO> labels) {
        this.labels = labels;
    }

    @Override
    public String toString() {
        return "PatientVO{" +
                "patientId=" + patientId +
                ", doctorName='" + doctorName + '\'' +
                ", patientName='" + patientName + '\'' +
                ", status='" + status + '\'' +
                ", patientIntention='" + patientIntention + '\'' +
                ", patientAvatar='" + patientAvatar + '\'' +
                ", labels=" + labels +
                '}';
    }
}
