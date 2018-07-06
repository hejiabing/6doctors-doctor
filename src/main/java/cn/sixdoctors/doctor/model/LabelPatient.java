package cn.sixdoctors.doctor.model;

/**
 * Created by wangpengcheng on 2018/7/5.
 */
public class LabelPatient {

    private int labelPatientId;
    private int labelId;
    private int patientId;

    public LabelPatient() {
    }

    public LabelPatient(int labelId, int patientId) {
        this.labelId = labelId;
        this.patientId = patientId;
    }

    public int getLabelPatientId() {
        return labelPatientId;
    }

    public void setLabelPatientId(int labelPatientId) {
        this.labelPatientId = labelPatientId;
    }

    public int getLabelId() {
        return labelId;
    }

    public void setLabelId(int labelId) {
        this.labelId = labelId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    @Override
    public String toString() {
        return "LabelPatient{" +
                "labelPatientId=" + labelPatientId +
                ", labelId=" + labelId +
                ", patientId=" + patientId +
                '}';
    }
}
