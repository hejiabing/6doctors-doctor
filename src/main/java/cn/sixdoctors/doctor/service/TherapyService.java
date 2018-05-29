package cn.sixdoctors.doctor.service;

import cn.sixdoctors.doctor.dao.CaseDAO;
import cn.sixdoctors.doctor.dao.TherapyDAO;
import cn.sixdoctors.doctor.model.Case;
import cn.sixdoctors.doctor.model.Therapy;
import cn.sixdoctors.doctor.util.FileUtils;
import cn.sixdoctors.doctor.vo.TherapyVO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TherapyService {

    @Resource
    private TherapyDAO therapyDAO;

    @Resource
    private CaseDAO caseDAO;

    public List<TherapyVO> getTherapies(int patientId) {
        List<Therapy> therapies = therapyDAO.findByPatientId(patientId);
        List<TherapyVO> therapyVOS = new ArrayList<>();
        for (Therapy t : therapies) {
            therapyVOS.add(new TherapyVO(t, caseDAO.selectByTherapyId(t.getTherapyId())));
        }
        return therapyVOS;
    }

    public TherapyVO getTherapy(int therapyId) {
        Therapy therapy = therapyDAO.findById(therapyId);
        return new TherapyVO(therapy, caseDAO.selectByTherapyId(therapyId));
    }

    public TherapyVO createTherapy(MultipartFile[] photos, Therapy therapy) throws IOException {
        therapyDAO.insert(therapy);
        return new TherapyVO(therapy, insertCases(photos, therapy));
    }

    public TherapyVO updateTherapy(MultipartFile[] photos, Therapy therapy) throws IOException {
        therapyDAO.update(therapy);
        List<Case> cases = caseDAO.selectByTherapyId(therapy.getTherapyId());
        return new TherapyVO(therapy, updateCases(photos, therapy));
    }

    private List<Case> insertCases(MultipartFile[] photos, Therapy therapy) throws IOException {
        List<Case> cases = new ArrayList<>();
        for (MultipartFile photo : photos) {
            Case c = new Case();
            c.setTherapyId(therapy.getTherapyId());
            String fileName = FileUtils.randomName(therapy.getTherapyId(), photo.getOriginalFilename());
            FileUtils.uploadFile(photo.getBytes(), "/data/doctor/cases/", fileName);
            c.setCasePath("http://api.6doctors.cn/data/doctor/cases/" + fileName);
            cases.add(c);
            caseDAO.insert(c);
        }
        return cases;
    }

    private List<Case> updateCases(MultipartFile[] photos, Therapy therapy) throws IOException {
        List<Case> cases = new ArrayList<>();
        for (MultipartFile photo : photos) {
            Case c = new Case();
            int caseId = Integer.parseInt(FileUtils.getFileName(photo.getOriginalFilename()));
            c.setCaseId(caseId);
            c.setTherapyId(therapy.getTherapyId());
            String fileName = FileUtils.randomName(therapy.getTherapyId(), photo.getOriginalFilename());
            FileUtils.uploadFile(photo.getBytes(), "/data/doctor/cases/", fileName);
            c.setCasePath("http://api.6doctors.cn/data/doctor/cases/" + fileName);
            cases.add(c);
            caseDAO.update(c);
        }
        return cases;
    }
}
