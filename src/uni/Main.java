package uni;

import base.Person;


public class Main {

    public static void main(String[] args) {
        Major major1 = new Major("Cs",60);
        Major major2 = new Major("Math",60);

        Person person1 = new Person("Amir","1");
        Person person2 = new Person("Sadra","2");
        Person person3 = new Person("Matin","3");
        Person person4 = new Person("Mahdi","4");
        Person person5 = new Person("Radin","5");

        Student student1 = new Student(1,1403,1);
        Student student2 = new Student(2,1403,1);
        Student student3 = new Student(3,1403,2);

        System.out.println("Student\n");

        System.out.print(person1.findById(1).name + " ");
        if ( major1.numberOfStudents < 10) {
            int num = Integer.decode(student1.studentCode)%10;
            System.out.print( String.valueOf(Integer.decode(student1.studentCode)/ 10) + "0" + num + "\n");
        }
        else {
            System.out.print(student1.studentCode + "\n");
        }

        System.out.print(person2.findById(2).name + " ");
        if ( major1.numberOfStudents < 10) {
            int num = Integer.decode(student2.studentCode)%10;
            System.out.print( String.valueOf(Integer.decode(student2.studentCode)/ 10) + "0" + num + "\n");
        }
        else {
            System.out.print(student2.studentCode + "\n");
        }

        System.out.print(person3.findById(3).name + " ");
        if ( major2.numberOfStudents < 10) {
            int num = Integer.decode(student3.studentCode)%10;
            System.out.print( String.valueOf(Integer.decode(student3.studentCode)/ 10) + "0" + num + "\n");
        }
        else {
            System.out.print(student3.studentCode + "\n");
        }

        Professor professor1 = new Professor(4,1);
        Professor professor2 = new Professor(5,2);

        System.out.print("\nProfessor\n\n");
        System.out.println(person4.findById(4).name + " " + professor1.id);
        System.out.println(person5.findById(5).name + " " + professor2.id);

        Course course1 = new Course("Data Structure", 4 );
        Course course2 = new Course("Network", 3);
        Course course3 = new Course("Math", 3);

        PresentedCourse p_PresentedCourse1 = new PresentedCourse(course1.id , professor1.id , 5 );
        PresentedCourse p_PresentedCourse2 = new PresentedCourse(course2.id , professor1.id , 5);
        PresentedCourse p_PresentedCourse3 = new PresentedCourse(course3.id , professor2.id , 5);

        p_PresentedCourse1.addStudent(student1.id);
        p_PresentedCourse1.addStudent(student2.id);

        p_PresentedCourse2.addStudent(student1.id);
        p_PresentedCourse2.addStudent(student2.id);
        p_PresentedCourse2.addStudent(student3.id);

        p_PresentedCourse3.addStudent(student3.id);

        Transcript transcript1 = new Transcript(student1.id);
        Transcript transcript2 = new Transcript(student2.id);
        Transcript transcript3 = new Transcript(student3.id);

        transcript1.setGrade(p_PresentedCourse1.courseID, 20);
        transcript1.setGrade(p_PresentedCourse2.courseID, 20);
        transcript2.setGrade(p_PresentedCourse1.courseID, 18);
        transcript2.setGrade(p_PresentedCourse2.courseID, 18);
        transcript3.setGrade(p_PresentedCourse2.courseID, 19.5);
        transcript3.setGrade(p_PresentedCourse3.courseID , 20);

        System.out.println("\nAmir Transcript");
        transcript1.printTranscript();
        System.out.println("");
        System.out.println("Sadra Transcript");
        transcript2.printTranscript();
        System.out.println("");
        System.out.println("Matin Transcript");
        transcript3.printTranscript();
        System.out.println("");

        System.out.println(person1.findById(1).name + "'s GPA " + transcript1.getGPA());
        System.out.println(person2.findById(2).name + "'s GPA " + transcript2.getGPA());
        System.out.println(person3.findById(3).name + "'s GPA " + transcript3.getGPA());


    }
}