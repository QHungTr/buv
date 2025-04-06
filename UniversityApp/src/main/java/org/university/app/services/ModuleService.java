    package org.university.app.services;

    import org.university.app.database.DatabaseHelper;

    import java.sql.*;

    public class ModuleService {
        public static void getWeightedAverage(int studentID, int moduleID) {
            String sql = """
                SELECT a.AwardedMarks, a.MaximumMarks, s.Weighting
                FROM Assessment a
                JOIN AssessmentStructure s ON a.AssessmentID = s.AssessmentID
                WHERE a.StudentID = ? AND s.ModuleID = ?
                """;
            //SELECT a.AwardedMarks, a.MaximumMarks, s.ModuleID FROM Assessment a JOIN AssessmentStructure s ON a.AssessmentID = s.AssessmentID WHERE a.StudentID = 201;
            try (Connection conn = DatabaseHelper.connect()) {
                assert conn != null;
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setInt(1, studentID);
                    preparedStatement.setInt(2, moduleID);

                    ResultSet rs = preparedStatement.executeQuery();
                    double totalWeightedMarks = 0, totalWeight = 0;
                    boolean hasRecord = false;

                    while (rs.next()) {
                        hasRecord = true;

                        // Lấy giá trị từ ResultSet
                        double awardedMarks = rs.getDouble("AwardedMarks");
                        double maxMarks = rs.getDouble("MaximumMarks");
                        double weighting = rs.getDouble("Weighting");

                        // Kiểm tra xem có giá trị null hoặc trống không
                        if (!rs.wasNull() && maxMarks > 0) {
                            // Tính toán điểm trọng số
                            double normalizedMarks = (awardedMarks / maxMarks) * weighting;
                            totalWeightedMarks += normalizedMarks;
                            totalWeight += weighting;
                        }
                    }

                    if (!hasRecord) {
                        System.out.println("No record found for student " + studentID + " in module " + moduleID);
                    } else {
                        // Tính điểm trung bình trọng số
                        double finalGrade = (totalWeight > 0) ? (totalWeightedMarks / totalWeight) * 100 : 0;
                        System.out.println("Weighted grade for student " + studentID + " in module " + moduleID + ": " + finalGrade + "%");
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
