package uni;


import java.util.ArrayList;

class PresentedCourse {

    public int id;
    public static ArrayList<PresentedCourse> presentedCourseList = new ArrayList<>();
    public int courseID;
    public int professorID;
    public int maxCapacity;
    public ArrayList<Integer> studentIDList = new ArrayList<>();

    public PresentedCourse ( int courseID , int professorID , int maxCapacity ) {

        this.courseID = courseID;
        this.professorID = professorID;
        this.maxCapacity = maxCapacity;
        this.studentIDList = new ArrayList<>();
        presentedCourseList.add(this);
        this.id = presentedCourseList.size();

    }

    public static PresentedCourse findById ( int courseID ) {

        for ( PresentedCourse presentedCourse : presentedCourseList ) {

            if ( presentedCourse.courseID == courseID ) {
                return presentedCourse;
            }

        }
        return null;

    }

    public void addStudent ( int studentID ) {
        studentIDList.add(studentID);
    }

}