package cn.sixdoctors.doctor.vo;

/**
 * Created by wangpengcheng on 2018/7/6.
 */
public class LabelVO {
    private int labelId;
    private String name;
    private int doctorId;
    private int labelPatientId;

    public int getLabelId() {
        return labelId;
    }

    public void setLabelId(int labelId) {
        this.labelId = labelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getLabelPatientId() {
        return labelPatientId;
    }

    public void setLabelPatientId(int labelPatientId) {
        this.labelPatientId = labelPatientId;
    }

    @Override
    public String toString() {
        return "LabelVO{" +
                "labelId=" + labelId +
                ", name='" + name + '\'' +
                ", doctorId=" + doctorId +
                ", labelPatientId=" + labelPatientId +
                '}';
    }
}
