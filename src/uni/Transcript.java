package uni;

import java.util.HashMap;

class Transcript {

    public int studentID;
    public HashMap<Integer, Double> transcript = new HashMap<>();

    public Transcript(int studentID) {
        this.studentID = studentID;
    }

    public void setGrade(int presentedCourseID, double grade) {
        PresentedCourse course = PresentedCourse.findById(presentedCourseID);
        if (course != null && course.studentIDList.contains(studentID)) {
            transcript.put(presentedCourseID, grade);
        }
    }

    public void printTranscript() {
        for (Integer presentedCourseID : transcript.keySet()) {
            PresentedCourse presentedCourse = PresentedCourse.findById(presentedCourseID);
            if (presentedCourse != null) {
                Course course = Course.findById(presentedCourse.courseID);
                if (course != null) {
                    System.out.println(course.title + " : " + transcript.get(presentedCourseID));
                } else {
                    System.out.println("not found.");
                }
            } else {
                System.out.println("not found.");
            }
        }
    }


    public double getGPA() {
        int unitsSum = 0;
        double gradeSum = 0;

        for (Integer presentedCourseID : transcript.keySet()) {

            PresentedCourse course = PresentedCourse.findById(presentedCourseID);
            Course studentCourse = (course != null) ? Course.findById(course.courseID) : null;

            if (studentCourse != null) {
                int unit = studentCourse.units;
                unitsSum += unit;
                gradeSum += unit * transcript.get(presentedCourseID);
            }
        }

        if (unitsSum == 0) {
            return 0;
        }
        return gradeSum / unitsSum;

    }
}

