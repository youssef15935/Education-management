
package education.management;

import java.util.ArrayList;
import java.util.List;


public class Course {
    private String course_id;
    private String course_name;
    private String teacher_surname;
    private String teacher_firstname;
    private String teacher_email;
    
    public static List< Course>  courses=new ArrayList<>();
    public Course(String course_id, String course_name, String teacher_surname, String teacher_firstname, String teacher_email) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.teacher_surname = teacher_surname;
        this.teacher_firstname = teacher_firstname;
        this.teacher_email = teacher_email;
      
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getTeacher_surname() {
        return teacher_surname;
    }

    public void setTeacher_surname(String teacher_surname) {
        this.teacher_surname = teacher_surname;
    }

    public String getTeacher_firstname() {
        return teacher_firstname;
    }

    public void setTeacher_firstname(String teacher_firstname) {
        this.teacher_firstname = teacher_firstname;
    }

    public String getTeacher_email() {
        return teacher_email;
    }

    public void setTeacher_email(String teacher_email) {
        this.teacher_email = teacher_email;
    }
     public static void readcourse(String c) 
    {
        String[] course=c.split(",");

        String course_id=course[0];
         String course_name=course[1];
         String teacher_surname=course[2];
         String teacher_firstname=course[3];
          String teacher_email=course[4];
       

        
      courses.add(new Course(course_id,course_name,teacher_surname,teacher_firstname,teacher_email));
    }

   
     
    @Override
    public String toString() {
        return "Course{" + "course_id=" + course_id + ", course_name=" + course_name + ", teacher_surname=" + teacher_surname + ", teacher_firstname=" + teacher_firstname + ", teacher_email=" + teacher_email + '}';
    }
    
}
