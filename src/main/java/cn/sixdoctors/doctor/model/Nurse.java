package cn.sixdoctors.doctor.model;

/**
 * Created by wangpengcheng on 2018/5/19.
 */
public class Nurse {
    private int nurseId;
    private String nurseName;
    private String hospitaName;
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

    public String getHospitaName() {
        return hospitaName;
    }

    public void setHospitaName(String hospitaName) {
        this.hospitaName = hospitaName;
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
                ", hospitaName='" + hospitaName + '\'' +
                ", departName='" + departName + '\'' +
                '}';
    }
}
