package cn.sixdoctors.doctor.vo;

import cn.sixdoctors.doctor.model.Patient;
import cn.sixdoctors.doctor.util.DateUtils;

import java.util.List;

public class PatientInfoVO {

    private int patientId;
    private String patientName;
    private String gender;
    private String mobPhone;
    private int age;
    private String identityType;
    private String identityNum;
    private String address;
    private String place;
    private String avatar;
    private List<TherapyVO> therapies;
    private String firstTherapyDate;
    private String firstTherapyDoctor;
    private String lastTherapyDate;
    private String lastTherapyDoctor;
    private String lastState;
    private int therapyCount;

    public PatientInfoVO() {
    }

    public PatientInfoVO(Patient patient, List<TherapyVO> therapies) {
        this.patientId = patient.getPatientId();
        this.patientName = patient.getPatientName();
        this.gender = patient.getGender();
        this.mobPhone = patient.getMobPhone();
        this.age = patient.getAge();
        this.identityType = patient.getIdentityType();
        this.identityNum = patient.getIdentityNum();
        this.address = patient.getAddress();
        this.place = patient.getPlace();
        this.avatar = patient.getPhotoPath();
        this.therapies = therapies;
        initPatientInfo();
    }

    public void initPatientInfo() {
        therapyCount = therapies.size();
        for (TherapyVO t: therapies) {
            t.setDate(DateUtils.getDateString(t.getDate()));
        }
        if (therapyCount > 0) {
            firstTherapyDate = therapies.get(0).getDate();
            firstTherapyDoctor = therapies.get(0).getDoctorName();
            lastTherapyDate = therapies.get(therapyCount - 1).getDate();
            lastTherapyDoctor = therapies.get(therapyCount - 1).getDoctorName();
            lastState = therapies.get(therapyCount - 1).getState();
        }
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobPhone() {
        return mobPhone;
    }

    public void setMobPhone(String mobPhone) {
        this.mobPhone = mobPhone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIdentityType() {
        return identityType;
    }

    public void setIdentityType(String identityType) {
        this.identityType = identityType;
    }

    public String getIdentityNum() {
        return identityNum;
    }

    public void setIdentityNum(String identityNum) {
        this.identityNum = identityNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<TherapyVO> getTherapies() {
        return therapies;
    }

    public void setTherapies(List<TherapyVO> therapies) {
        this.therapies = therapies;
    }

    public String getFirstTherapyDate() {
        return firstTherapyDate;
    }

    public void setFirstTherapyDate(String firstTherapyDate) {
        this.firstTherapyDate = firstTherapyDate;
    }

    public String getFirstTherapyDoctor() {
        return firstTherapyDoctor;
    }

    public void setFirstTherapyDoctor(String firstTherapyDoctor) {
        this.firstTherapyDoctor = firstTherapyDoctor;
    }

    public String getLastTherapyDate() {
        return lastTherapyDate;
    }

    public void setLastTherapyDate(String lastTherapyDate) {
        this.lastTherapyDate = lastTherapyDate;
    }

    public String getLastTherapyDoctor() {
        return lastTherapyDoctor;
    }

    public void setLastTherapyDoctor(String lastTherapyDoctor) {
        this.lastTherapyDoctor = lastTherapyDoctor;
    }

    public int getTherapyCount() {
        return therapyCount;
    }

    public void setTherapyCount(int therapyCount) {
        this.therapyCount = therapyCount;
    }

    public String getLastState() {
        return lastState;
    }

    public void setLastState(String lastState) {
        this.lastState = lastState;
    }

    @Override
    public String toString() {
        return "PatientInfoVO{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", gender='" + gender + '\'' +
                ", mobPhone='" + mobPhone + '\'' +
                ", age=" + age +
                ", identityType='" + identityType + '\'' +
                ", identityNum='" + identityNum + '\'' +
                ", address='" + address + '\'' +
                ", place='" + place + '\'' +
                ", avatar='" + avatar + '\'' +
                ", therapies=" + therapies +
                ", firstTherapyDate='" + firstTherapyDate + '\'' +
                ", firstTherapyDoctor='" + firstTherapyDoctor + '\'' +
                ", lastTherapyDate='" + lastTherapyDate + '\'' +
                ", lastTherapyDoctor='" + lastTherapyDoctor + '\'' +
                ", lastState='" + lastState + '\'' +
                ", therapyCount=" + therapyCount +
                '}';
    }
}
