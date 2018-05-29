package cn.sixdoctors.doctor.wrapper;

import cn.sixdoctors.doctor.model.DoctorPatient;
import cn.sixdoctors.doctor.model.PassportUser;
import cn.sixdoctors.doctor.model.Patient;
import cn.sixdoctors.doctor.service.PatientService;
import cn.sixdoctors.doctor.util.FileUtils;
import cn.sixdoctors.doctor.vo.VO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Service
public class PatientWrapper {

    @Resource
    private PatientService patientService;

    public VO<List<DoctorPatient>> getPatients(int doctorId) {
        return new VO<>(patientService.getPatients(doctorId));
    }

    public VO<Patient> getPatient(int patientId) {
        return new VO<>(patientService.getPatient(patientId));
    }

    public VO<Patient> createPatient(PassportUser user, MultipartFile photo, String patientName, String gender, String mobPhone,
                                     int age, String identityType, String identityNum, String address, String place) throws IOException {
        StringBuilder builder = new StringBuilder();
        String fileName = FileUtils.randomName(user.getUserId(), photo.getOriginalFilename());
        FileUtils.uploadFile(photo.getBytes(), "/data/doctor/avatar/", fileName);
        builder.append("http://api.6doctors.cn/data/doctor/avatar/").append(fileName);

        Patient patient = new Patient();
        patient.setPatientName(patientName);
        patient.setGender(gender);
        patient.setMobPhone(mobPhone);
        patient.setAge(age);
        patient.setIdentityType(identityType);
        patient.setIdentityNum(identityNum);
        patient.setAddress(address);
        patient.setPlace(place);
        patient.setPhotoPath(builder.toString());
        return new VO<>(patientService.createPatient(user, patient));
    }

    public VO<Patient> updatePatient(PassportUser user, MultipartFile photo,int patientId, String patientName, String gender, String mobPhone, int age,
                                     String identityType, String identityNum, String address, String place) throws IOException {
        StringBuilder builder = new StringBuilder();
        String fileName = FileUtils.randomName(user.getUserId(), photo.getOriginalFilename());
        FileUtils.uploadFile(photo.getBytes(), "/data/doctor/avatar/", fileName);
        builder.append("http://api.6doctors.cn/data/doctor/avatar/").append(fileName);

        Patient patient = new Patient();
        patient.setPatientId(patientId);
        patient.setPatientName(patientName);
        patient.setGender(gender);
        patient.setMobPhone(mobPhone);
        patient.setAge(age);
        patient.setIdentityType(identityType);
        patient.setIdentityNum(identityNum);
        patient.setAddress(address);
        patient.setPlace(place);
        patient.setPhotoPath(builder.toString());
        return new VO<>(patientService.updatePatient(patient));
    }
}
