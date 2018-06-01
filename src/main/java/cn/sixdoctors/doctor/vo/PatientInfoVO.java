package cn.sixdoctors.doctor.vo;

import cn.sixdoctors.doctor.model.Patient;

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
                '}';
    }
}
