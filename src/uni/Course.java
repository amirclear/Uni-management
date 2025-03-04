package uni;

import java.util.ArrayList;


class Course {

    public int id;
    public static ArrayList<Course> courseList = new ArrayList<>();
    public String title;
    public int units;

    public Course ( String title , int units ) {

        this.title = title;
        this.units = units;

        courseList.add(this);
        this.id = courseList.size();

    }

    public static Course findById ( int id ) {

        for ( Course course : courseList ) {

            if ( course.id == id ) {
                return course;
            }

        }

        return null;

    }

}