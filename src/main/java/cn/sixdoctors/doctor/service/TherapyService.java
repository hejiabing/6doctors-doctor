package cn.sixdoctors.doctor.service;

import cn.sixdoctors.doctor.dao.TherapyDAO;
import cn.sixdoctors.doctor.model.Therapy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TherapyService {

    @Resource
    private TherapyDAO therapyDAO;

    public List<Therapy> getTherapies(int patientId) {
        return therapyDAO.findByPatientId(patientId);
    }

    public Therapy getTherapy(int therapyId) {
        return therapyDAO.findById(therapyId);
    }

    public Therapy createTherapy(Therapy therapy) {
        therapyDAO.insert(therapy);
        return therapy;
    }

    public Therapy updateTherapy(Therapy therapy) {
        therapyDAO.update(therapy);
        return therapy;
    }
}
