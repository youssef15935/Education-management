
package education.management;

import java.util.ArrayList;
import java.util.List;


public class registration {
    private String registration_no;
    private String courseid;
    private String studentid;
    private String coursename;
   private List<Course> courses;
   
    private List<Student> studentsenrolled;
  public static List<registration> reg=new ArrayList<>();
    public registration(String reg,String courseid, String studentid, String coursename, List<Course> courses, List<Student> studentsenrolled) {
        this.courseid = courseid;
        this.registration_no=reg;
        this.studentid = studentid;
        this.coursename = coursename;
        this.courses = courses;
        this.studentsenrolled = studentsenrolled;
    }

    public String getRegistration_no() {
        return registration_no;
    }

    public void setRegistration_no(String registration_no) {
        this.registration_no = registration_no;
    }

    @Override
    public String toString() {
        return "registration{" + "courseid=" + courseid + ", studentid=" + studentid + ", coursename=" + coursename + ", courses=" + courses + ", studentsenrolled=" + studentsenrolled + '}';
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Student> getStudentsenrolled() {
        return studentsenrolled;
    }

    public void setStudentsenrolled(List<Student> studentsenrolled) {
        this.studentsenrolled = studentsenrolled;
    }
    
}
