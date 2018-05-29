package cn.sixdoctors.doctor.wrapper;

import cn.sixdoctors.doctor.model.Therapy;
import cn.sixdoctors.doctor.service.TherapyService;
import cn.sixdoctors.doctor.vo.TherapyVO;
import cn.sixdoctors.doctor.vo.VO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class TherapyWrapper {

    @Resource
    private TherapyService therapyService;

    public VO<List<TherapyVO>> getTherapies(int patientId) {
        return new VO<>(therapyService.getTherapies(patientId));
    }

    public VO<TherapyVO> getTherapy(int therapyId) {
        return new VO<>(therapyService.getTherapy(therapyId));
    }

    public VO<TherapyVO> createTherapy(MultipartFile[] photos, int doctorId, int patientId, String state, Date date, String record) throws IOException {
        Therapy therapy = new Therapy();
        therapy.setDoctorId(doctorId);
        therapy.setPatientId(patientId);
        therapy.setState(state);
        therapy.setDate(date);
        therapy.setRecord(record);
        return new VO<>(therapyService.createTherapy(photos, therapy));
    }

    public VO<TherapyVO> updateTherapy(MultipartFile[] photos, int therapyId, int doctorId, int patientId, String state, Date date, String record) throws IOException {
        Therapy therapy = new Therapy();
        therapy.setTherapyId(therapyId);
        therapy.setDoctorId(doctorId);
        therapy.setPatientId(patientId);
        therapy.setState(state);
        therapy.setDate(date);
        therapy.setRecord(record);
        return new VO<>(therapyService.updateTherapy(photos, therapy));
    }
}
