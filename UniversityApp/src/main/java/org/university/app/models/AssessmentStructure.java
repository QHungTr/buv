package org.university.app.models;

public class AssessmentStructure {
    private int assessmentID; // Khóa chính, tự động tăng
    private int moduleID; // Khóa ngoại tham chiếu đến Module
    private String assessmentType; // Loại đánh giá, chỉ nhận giá trị 'Report', 'Presentation', 'Exam'
    private double weighting; // Trọng số, phải nằm trong khoảng 0 đến 100

    // Constructor
    public AssessmentStructure() {}

    public AssessmentStructure(int moduleID, String assessmentType, double weighting) {
        this.moduleID = moduleID;
        this.assessmentType = assessmentType;
        this.weighting = weighting;
    }

    // Getter và Setter
    public int getAssessmentID() {
        return assessmentID;
    }

    public void setAssessmentID(int assessmentID) {
        this.assessmentID = assessmentID;
    }

    public int getModuleID() {
        return moduleID;
    }

    public void setModuleID(int moduleID) {
        this.moduleID = moduleID;
    }

    public String getAssessmentType() {
        return assessmentType;
    }

    public void setAssessmentType(String assessmentType) {
        // Kiểm tra giá trị hợp lệ
        if (assessmentType.equals("Report") || assessmentType.equals("Presentation") || assessmentType.equals("Exam")) {
            this.assessmentType = assessmentType;
        } else {
            throw new IllegalArgumentException("AssessmentType must be 'Report', 'Presentation', or 'Exam'");
        }
    }

    public double getWeighting() {
        return weighting;
    }

    public void setWeighting(double weighting) {
        // Kiểm tra giá trị hợp lệ
        if (weighting >= 0 && weighting <= 100) {
            this.weighting = weighting;
        } else {
            throw new IllegalArgumentException("Weighting must be between 0 and 100");
        }
    }

    // Phương thức toString để in thông tin
    @Override
    public String toString() {
        return "AssessmentStructure{" +
                "assessmentID=" + assessmentID +
                ", moduleID=" + moduleID +
                ", assessmentType='" + assessmentType + '\'' +
                ", weighting=" + weighting +
                '}';
    }
}