package cn.sixdoctors.doctor.model;

/**
 * Created by wangpengcheng on 2018/5/19.
 */
public class DoctorPatient {
    private int doctorPatientId;
    private int doctorId;
    private int patientId;
    private String doctorName;
    private String patientName;
    private String status;

    public int getDoctorPatientId() {
        return doctorPatientId;
    }

    public void setDoctorPatientId(int doctorPatientId) {
        this.doctorPatientId = doctorPatientId;
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

    @Override
    public String toString() {
        return "DoctorPatient{" +
                "doctorPatientId=" + doctorPatientId +
                ", doctorId=" + doctorId +
                ", patientId=" + patientId +
                ", doctorName='" + doctorName + '\'' +
                ", patientName='" + patientName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
