package uni;

import java.util.ArrayList;

class Student {

    public int id;
    public static ArrayList<Student> studentList = new ArrayList<>();
    public int personID;
    public final int entranceYear;
    public int majorID;
    public String studentCode;

    public Student ( int personID , int entranceYear , int majorID ) {

        this.personID = personID;
        this.entranceYear = entranceYear;
        this.majorID = majorID;

        Major major = Major.findById(majorID);

        if ( major == null ) {
            studentList.add(this);
        }

        setStudentCode();

        this.id = studentList.size();

    }

    public static Student findById ( int id ) {

        for ( Student student : studentList )  {
            if ( student.id == id)
            {
                return student;
            }
        }
        return null;

    }

    public void setStudentCode() {

        Major major = Major.findById(majorID);

        if (major != null) {

            major.addStudent();
            String code = String.valueOf(entranceYear % 1000) + major.id + major.numberOfStudents;
            this.studentCode = code;

        }
    }

}