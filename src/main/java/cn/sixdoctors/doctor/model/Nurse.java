package cn.sixdoctors.doctor.model;

/**
 * Created by wangpengcheng on 2018/5/19.
 */
public class Nurse {
    private int nurseId;
    private String nurseName;
    private String hospitalName;
    private String departName;

    public int getNurseId() {
        return nurseId;
    }

    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }

    public String getNurseName() {
        return nurseName;
    }

    public void setNurseName(String nurseName) {
        this.nurseName = nurseName;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    @Override
    public String toString() {
        return "Nurse{" +
                "nurseId=" + nurseId +
                ", nurseName='" + nurseName + '\'' +
                ", hospitalName='" + hospitalName + '\'' +
                ", departName='" + departName + '\'' +
                '}';
    }
}
