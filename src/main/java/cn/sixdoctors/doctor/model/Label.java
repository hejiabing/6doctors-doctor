package cn.sixdoctors.doctor.model;

/**
 * Created by wangpengcheng on 2018/7/5.
 */
public class Label {
    private int labelId;
    private String name;
    private int doctorId;

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

    @Override
    public String toString() {
        return "Label{" +
                "labelId=" + labelId +
                ", name='" + name + '\'' +
                ", doctorId=" + doctorId +
                '}';
    }
}
