package cn.sixdoctors.doctor.model;

/**
 * Created by wangpengcheng on 2018/5/19.
 */
public class Case {

    private int caseId;
    private int therapyId;
    private String casePath;

    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public int getTherapyId() {
        return therapyId;
    }

    public void setTherapyId(int therapyId) {
        this.therapyId = therapyId;
    }

    public String getCasePath() {
        return casePath;
    }

    public void setCasePath(String casePath) {
        this.casePath = casePath;
    }

    @Override
    public String toString() {
        return "Case{" +
                "caseId=" + caseId +
                ", therapyId=" + therapyId +
                ", casePath='" + casePath + '\'' +
                '}';
    }
}
