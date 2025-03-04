package uni;


import java.util.ArrayList;

class Professor {

    public int id;
    public static ArrayList<Professor> professorList = new ArrayList<>();
    public int personID;
    public int majorID;

    public Professor ( int personID , int majorID ) {

        this.personID = personID;
        this.majorID = majorID;
        professorList.add(this);
        this.id = professorList.size();

    }

    public static Professor findById ( int id ) {

        for ( Professor professor : professorList ) {
            if ( professor.id == id ) {
                return professor;
            }
        }
        return null;
    }

}