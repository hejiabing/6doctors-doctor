package cn.sixdoctors.doctor.wrapper;

import cn.sixdoctors.doctor.model.Therapy;
import cn.sixdoctors.doctor.service.TherapyService;
import cn.sixdoctors.doctor.vo.VO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TherapyWrapper {

    @Resource
    private TherapyService therapyService;

    public VO<List<Therapy>> getTherapies(int patientId) {
        return new VO<>(therapyService.getTherapies(patientId));
    }

    public VO<Therapy> getTherapy(int therapyId) {
        return new VO<>(therapyService.getTherapy(therapyId));
    }

    public VO<Therapy> createTherapy(Therapy therapy) {
        return new VO<>(therapyService.createTherapy(therapy));
    }

    public VO<Therapy> updateTherapy(Therapy therapy) {
        return new VO<>(therapyService.updateTherapy(therapy));
    }
}
