
package education.management;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Student implements Comparable<Student> {
    private int  Student_id;
    private String name;
    private int stu_sn;
    private String surname;
    private String first_name;
    private String place;
    private String dob;
    private int  promoting;
    private String personal_email;
    private String university_email;
    
    static Scanner scan=new Scanner(System.in);
    public static List<Student> students=new ArrayList<>();
    public Student(int Student_id, String name, int stu_sn, String surname, String first_name, String place, String dob, int  promoting, String personal_email, String user_email) {
        this.Student_id = Student_id;
        this.name = name;
        this.stu_sn = stu_sn;
        this.surname = surname;
        this.first_name = first_name;
        this.place = place;
        this.dob = dob;
        this.promoting = promoting;
        this.personal_email = personal_email;
        this.university_email = user_email;
        
    }

  

    public int getStudent_id() {
        return Student_id;
    }

    public void setStudent_id(int Student_id) {
        this.Student_id = Student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStu_sn() {
        return stu_sn;
    }

    public void setStu_sn(int stu_sn) {
        this.stu_sn = stu_sn;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int isPromoting() {
        return promoting;
    }

    public void setPromoting(int  promoting) {
        this.promoting = promoting;
    }

    public String getPersonal_email() {
        return personal_email;
    }

    public void setPersonal_email(String personal_email) {
        this.personal_email = personal_email;
    }

    public String getUser_email() {
        return university_email;
    }

    public void setUser_email(String user_email) {
        this.university_email = user_email;
    }
    public static void readstudent(String s) 
    {
        String[] student=s.split(",");
        System.out.println(student.length);
        int  Student_id=Integer.parseInt(student[0]);
         String name=student[1];
         int stu_sn=Integer.parseInt(student[2]);
         String surname=student[3];
         String first_name=student[4];
          String place=student[5];
         String dob=student[6];
          int  promoting=Integer.parseInt(student[9]);
        String personal_email=student[7];
        String university_email=student[8]; 
        

        
      students.add(new Student(Student_id,name,stu_sn,surname,first_name,place,dob,promoting,personal_email,university_email));
    }
    @Override
    public String toString() {
        return "Student{" + "Student_id=" + Student_id + ", name=" + name + ", stu_sn=" + stu_sn + ", surname=" + surname + ", first_name=" + first_name + ", place=" + place + ", dob=" + dob + ", promoting=" + promoting + ", personal_email=" + personal_email + ", university_email=" + university_email + '}';
    }

    @Override
    public int compareTo(Student o) {
        if (getName() == null || o.getName() == null) {
      return 0;
    }
    return getName().compareTo(o.getName());
    }
    
    
}
