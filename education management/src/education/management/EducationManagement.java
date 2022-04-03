
package education.management;

import static education.management.Student.scan;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;


public class EducationManagement {
    static Scanner scan=new Scanner(System.in);
    private static final String CSV_SEPARATOR = ",";
    public static void StudentManagement() 
    {
        
        System.out.println("Veuillez choisir votre option :");
         System.out.println("1.Ajouter un étudiant");
          System.out.println("2.Liste des étudiants par ordre alphabétiquer");
           System.out.println("3.Lister les étudiants par promotion, puis par ordre alphabétique");
            System.out.println("4.Modifier un étudiant ");
             System.out.println("5.Supprimer un étudiant ");
           System.out.println("Veuillez choisir votre option:");
           int choice=scan.nextInt();
           switch(choice)
           {
               case 1:
                   
                   addstudent();
                   break;
               case 2:
        {
            try {
                displaystudents();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(EducationManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                   break;
               case 3:
                   displaystudentpromotion();
                   break;
               case 4:
                   editstudent();
                   break;
               case 5:
                   deletestudent();
                   break;
               default:
                   System.out.println("Veuillez choisir la bonne option");
           
           }
           
    }
      public static void CourseManagement() 
    {
        
        System.out.println("Veuillez choisir votre option :");
         System.out.println("1.Ajouter un cours");
          System.out.println("2. lister les cours");
         
            System.out.println("3.Modifier un cours ");
             System.out.println("4.Supprimer un cours ");
           System.out.println("Veuillez choisir votre option:");
           int choice=scan.nextInt();
           switch(choice)
           {
               case 1:
                   
                   addcourse();
                   break;
               case 2:
        
           
                displaycourses();
           
                   break;
               case 3:
                   editcourse();
                   break;
               case 4:
                   deletecourse();
                   break;
               default:
                   System.out.println("Veuillez choisir la bonne option");
           
           }
           
    }
    public static void main(String[] args){
      
           System.out.println("Veuillez choisir une option");
         System.out.println("1.Gestion des étudiants");
          System.out.println("2.Gestion des cours ");
         
            System.out.println("3.Gestion des inscriptions  ");
              
            System.out.println("4.Gestion des examens  ");
              System.out.println("5.Fermer ");
           System.out.println("Veuillez choisir une option:");
           int choice=scan.nextInt();
           switch(choice)
           {
               case 1:
                   
                   StudentManagement();
                   main(null);
                   break;
               case 2:
        
           
                   CourseManagement();
                   main(null);
                   break;
               case 3:
                   RegistrationManagement();
                   main(null);
                   break;
               case 4:
                   MarksManagement();
                   main(null);
                   break;
             
               case 5:
                   break;
               default:
                   System.out.println("Veuillez choisir la bonne option");
                   main(null);
           
           }
           
           
            
    }

    private static void addstudent() {
        int  Student_id;
         String name;
         int stu_sn;
         String surname;
         String first_name;
          String place;
         String dob;
          int  promoting;
        String personal_email;
        String university_email; 
        
        System.out.println("Entrez l'identifiant de l'étudiant :");
        Student_id=scan.nextInt();
        System.out.println("Entrez le nom de l'étudiant :");
        scan.nextLine();
        name=scan.nextLine();
        System.out.println("Saisissez le N° social étudiant :");
        stu_sn=scan.nextInt();
        System.out.println("Entrez le nom de famille de l'étudiant :");
        scan.nextLine();
        surname=scan.nextLine();
        System.out.println("Entrez le prénom de l'étudiant :");
        first_name=scan.nextLine();
        System.out.println("Entrez le lieu de naissance de l'étudiant");
        place=scan.nextLine();
        System.out.println("Saisissez la date de naissance de l'étudiant :");
        dob=scan.nextLine();
        System.out.println("Entrez la promotion étudiante :");
        promoting=scan.nextInt();
        System.out.println("Entrez l'adresse e-mail personnelle de l'étudiant :");
        scan.nextLine();
        personal_email=scan.nextLine();
        System.out.println("Entrez l'adresse e-mail universitaire de l'étudiant :");
        university_email=scan.nextLine();
        Student student=new Student(Student_id,name,stu_sn,surname,first_name,place,dob,promoting,personal_email,university_email);
        
        try
        {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("students.csv",true), "UTF-8"));
            
                StringBuilder oneLine = new StringBuilder();
                oneLine.append(student.getStudent_id() <=0 ? "" : student.getStudent_id());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(student.getName().trim().length() == 0? "" : student.getName());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(student.getStu_sn() < 0 ? "" : student.getStu_sn());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(student.getFirst_name().trim().length() == 0? "" : student.getFirst_name());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(student.getSurname().trim().length() == 0? "" : student.getSurname());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(student.getPlace().trim().length() == 0? "" : student.getPlace());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(student.getDob().trim().length() == 0? "" : student.getDob());
                oneLine.append(CSV_SEPARATOR);
                 oneLine.append(student.getPersonal_email().trim().length() == 0? "" : student.getPersonal_email());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(student.getUser_email().trim().length() == 0? "" : student.getUser_email());
                 oneLine.append(CSV_SEPARATOR);
                  oneLine.append(student.isPromoting() <=0 ? "" : student.isPromoting());
                bw.append(oneLine.toString());
                bw.newLine();
            
            bw.flush();
            bw.close();
            
            System.out.println("L'étudiant est enregistré avec succès");
        }
        catch (UnsupportedEncodingException e) {}
        catch (FileNotFoundException e){}
        catch (IOException e){}
    

    }

    private static void displaystudents() throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File("students.csv"));) {
    while (scanner.hasNextLine()) {
       
       Student.readstudent(scanner.nextLine());
    }
}       catch (FileNotFoundException ex) {
            System.out.println("FICHIER VIDE");
        }
        Collections.sort(Student.students);
        for (int i = 0; i < Student.students.size(); i++) {
            System.out.println(Student.students.get(i).toString());
        }
        Student.students.clear();
        
    }

    private static void displaystudentpromotion() {
        try (Scanner scanner = new Scanner(new File("students.csv"));) {
    while (scanner.hasNextLine()) {
       Student.readstudent(scanner.nextLine());
    }
}       catch (FileNotFoundException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        Comparator<Student> compareBypromotion = Comparator
                        .comparing(Student::isPromoting)
                        .thenComparing(Student::getName);
        List<Student> sortedStudents = Student.students.stream()
                    .sorted(compareBypromotion)
                    .collect(Collectors.toList());
        for (int i = 0; i < sortedStudents.size(); i++) {
            System.out.println(sortedStudents.get(i).toString());
        }
        Student.students.clear();
        
    }

    private static void deletestudent() {
         try (Scanner scanner = new Scanner(new File("students.csv"));) {
    while (scanner.hasNextLine()) {
       Student.readstudent(scanner.nextLine());
    }
    }       catch (FileNotFoundException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        String studentid;
       System.out.println("Entrez l'identifiant de l'étudiant à supprimer:");
       scan.nextLine();
       studentid=scan.nextLine();
       
       Optional<Student> matchingObject =Student.students.stream().
    filter(p -> String.valueOf(p.getStudent_id()).equals(studentid)).
    findFirst();
      Student student = matchingObject.get();

      Student.students.remove(student);
      clearfile();
      addlist();
      Student.students.clear();
       
    }
    private static void addlist()
    {
        Student.students.forEach((student) -> {
            try
            {
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("students.csv",true), "UTF-8"));
                
                StringBuilder oneLine = new StringBuilder();
                oneLine.append(student.getStudent_id() <=0 ? "" : student.getStudent_id());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(student.getName().trim().length() == 0? "" : student.getName());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(student.getStu_sn() < 0 ? "" : student.getStu_sn());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(student.getFirst_name().trim().length() == 0? "" : student.getFirst_name());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(student.getSurname().trim().length() == 0? "" : student.getSurname());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(student.getPlace().trim().length() == 0? "" : student.getPlace());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(student.getDob().trim().length() == 0? "" : student.getDob());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(student.getPersonal_email().trim().length() == 0? "" : student.getPersonal_email());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(student.getUser_email().trim().length() == 0? "" : student.getUser_email());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(student.isPromoting() <=0 ? "" : student.isPromoting());
                bw.append(oneLine.toString());
                bw.newLine();
                
                bw.flush();
                bw.close();
                
                System.out.println("Student is saved sucessfully!!!");
            }
            
            catch (UnsupportedEncodingException e) {}
            catch (FileNotFoundException e){}
            catch (IOException e){}
        });
    }
    private static void clearfile()
    {
         File f;
            f = new File("students.csv"); 
             f.delete();  
    }
     private static void clearcoursefile()
    {
         File f;
            f = new File("course.csv"); 
             f.delete();  
    }
    private static void editstudent() {
        try (Scanner scanner = new Scanner(new File("students.csv"));) {
    while (scanner.hasNextLine()) {
       Student.readstudent(scanner.nextLine());
    }
    }       catch (FileNotFoundException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        String studentid;
       System.out.println("Saisissez l'identifiant étudiant à modifier :");
       studentid=scan.nextLine();
        Optional<Student> matchingObject =Student.students.stream().
    filter(p -> String.valueOf(p.getStudent_id()).equals(studentid)).
    findFirst();
      Student student = matchingObject.get();
      int index= Student.students.indexOf(student);
         Student.students.remove(student);
 
        System.out.println("Entrez l'identifiant de l'étudiant :");
        int Student_id=scan.nextInt();
        System.out.println("Entrez le nom de l'étudiant :");
        scan.nextLine();
        String name=scan.nextLine();
        System.out.println("Saisissez le N° social étudiant :");
        int stu_sn=scan.nextInt();
        System.out.println("Entrez le nom de famille de l'étudiant :");
        scan.nextLine();
        String surname=scan.nextLine();
        System.out.println("Entrez le prénom de l'étudiant :");
        String first_name=scan.nextLine();
        System.out.println("Entrez le lieu de naissance de l'étudiant :");
        String place=scan.nextLine();
        System.out.println("Saisissez la date de naissance de l'étudiant :");
        String dob=scan.nextLine();
        System.out.println("Entrez la promotion étudiante :");
        int promoting=scan.nextInt();
        System.out.println("Entrez l'adresse e-mail personnelle de l'étudiant :");
        scan.nextLine();
        String personal_email=scan.nextLine();
        System.out.println(" Entrez l'adresse e-mail universitaire de l'étudiant:");
        String university_email=scan.nextLine();      
     Student st= new Student(Student_id,name, stu_sn , surname,first_name,place,dob,promoting,personal_email,university_email);
     Student.students.add(index,st);
     clearfile();
      addlist();
      Student.students.clear();
    }

    private static void addcourse() {
         String  course_id;
         String course_name;
         String teacher_surname;
         String teacher_firstname;
          String teacher_email;
       
        
        System.out.println("Saisissez l'identifiant du cours :");
         scan.nextLine();
        course_id=scan.nextLine();
        System.out.println("Entrez le nom du cours :");
       
        course_name=scan.nextLine();
        System.out.println("Entrez le nom de famille de l'enseignant :");
        teacher_surname=scan.nextLine();
        System.out.println("Entrez le prénom de l'enseignant:");
        teacher_firstname=scan.nextLine();
        System.out.println("Saisissez l'adresse e-mail de l'enseignant: :");
        teacher_email=scan.nextLine();
        
        Course course=new Course(course_id,course_name,teacher_surname,teacher_firstname,teacher_email);
        
        try
        {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("course.csv",true), "UTF-8"));
            
                StringBuilder oneLine = new StringBuilder();
                oneLine.append(course.getCourse_id().trim().length() == 0?  "" : course.getCourse_id());
                oneLine.append(CSV_SEPARATOR);
                 oneLine.append(course.getCourse_name().trim().length() == 0?  "" : course.getCourse_name());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(course.getTeacher_surname().trim().length() == 0?  "" : course.getTeacher_surname());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(course.getTeacher_firstname().trim().length() == 0?  "" : course.getTeacher_firstname());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(course.getTeacher_email().trim().length() == 0?  "" : course.getTeacher_email());
                bw.append(oneLine.toString());
                bw.newLine();
        
            bw.flush();
            bw.close();
            
            System.out.println("Le cours est enregistré avec succès");
        }
         catch (UnsupportedEncodingException e) {}
            catch (FileNotFoundException e){}
            catch (IOException e){}
        
    }

    private static void displaycourses() {
       try (Scanner scanner = new Scanner(new File("course.csv"));) {
    while (scanner.hasNextLine()) {
       
       Course.readcourse(scanner.nextLine());
    }
}       catch (FileNotFoundException ex) {
            System.out.println("FICHIER VIDE");
        }
        
        for (int i = 0; i < Course.courses.size(); i++) {
            System.out.println(Course.courses.get(i).toString());
        }
      
        Course.courses.clear();
    }

    private static void editcourse() {
        Course fcs;
       try (Scanner scanner = new Scanner(new File("course.csv"));) {
    while (scanner.hasNextLine()) {
       
       Course.readcourse(scanner.nextLine());
    }
}       catch (FileNotFoundException ex) {
            System.out.println("FICHIER VIDE");
        }
        String courseid;
       System.out.println("Saisissez l'identifiant du cours à modifier :");
        scan.nextLine();
       courseid=scan.nextLine();
        Optional<Course> matchingObject =Course.courses.stream().
    filter(p -> String.valueOf(p.getCourse_id()).equals(courseid)).
    findFirst();
        if(matchingObject==null)
            System.out.println("ID introuvable");
        else{
       fcs = matchingObject.get();
       Course.courses.remove(fcs);
      int index=Course.courses.indexOf(fcs);
        System.out.println("Entrez l'identifiant du cours :");
        String course_id=scan.nextLine();
        System.out.println("Entrez le nom du cours :");
        String name=scan.nextLine();
        System.out.println("Entrez le nom de famille de l'enseignant :");
        String teacher_surname=scan.nextLine();
        System.out.println("Saisissez le prénom de l'enseignant :");
        String teacher_firstname=scan.nextLine();
        System.out.println("Saisissez l'adresse e-mail de l'enseignant :");
        String teacher_email=scan.nextLine();
        
     Course cs= new Course(course_id,name,teacher_surname,teacher_firstname,teacher_email);
     Course.courses.add(index, cs);
     clearcoursefile();
      addcourselist();}
      Course.courses.clear();
       
    }

    private static void deletecourse() {
           try (Scanner scanner = new Scanner(new File("course.csv"));) {
    while (scanner.hasNextLine()) {
       
       Course.readcourse(scanner.nextLine());
    }
}       catch (FileNotFoundException ex) {
            System.out.println("FICHIER VIDE");
        }
        String courseid;
       System.out.println("Saisissez l'identifiant du cours à supprimer :");
       courseid=scan.nextLine();
        Optional<Course> matchingObject =Course.courses.stream().
    filter(p -> String.valueOf(p.getCourse_id()).equals(courseid)).
    findFirst();
      Course fcs = matchingObject.get();
      Course.courses.remove(fcs);
      clearcoursefile();
      addcourselist();
      Student.students.clear();
    }
    private static void addcourselist() {
        Course.courses.forEach((course) -> {
            try
            {
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("course.csv",true), "UTF-8"));
                
                StringBuilder oneLine = new StringBuilder();
                oneLine.append(course.getCourse_id().trim().length() == 0?  "" : course.getCourse_id());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(course.getCourse_name().trim().length() == 0?  "" : course.getCourse_name());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(course.getTeacher_surname().trim().length() == 0?  "" : course.getTeacher_surname());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(course.getTeacher_firstname().trim().length() == 0?  "" : course.getTeacher_firstname());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(course.getTeacher_email().trim().length() == 0?  "" : course.getTeacher_email());
                bw.append(oneLine.toString());
                bw.newLine();
                
                bw.flush();
                bw.close();
                
                System.out.println("cours enregistre");
            }
            catch (UnsupportedEncodingException e) {}
            catch (FileNotFoundException e){}
            catch (IOException e){}
        });
        
    }

    private static void RegistrationManagement() {
        
         System.out.println("Saisissez l'identifiant du cours à supprimer :");
         System.out.println("1.Ajouter un étudiant au cours");
          System.out.println("2.Supprimer une entrée");
            System.out.println("3.Pour un cours, lister les étudiants inscrits ");
             System.out.println("4.Pour un étudiant, énumérer les cours auxquels il est inscrit");
           System.out.println("	Veuillez choisir votre option :");
           int choice=scan.nextInt();
           switch(choice)
           {
               case 1:
                   
                   addstudenttocourse();
                   break;
               case 2:
        
           
                deleteentry();
           
                   break;
               case 3:
                   listregisteredstudents();
                   break;
               case 4:
                   listregisteredcourses();
                   break;
               default:
                   System.out.println("Veuillez choisir la bonne option");
           
           }
           
    }

    private static void MarksManagement() {
         System.out.println("1.Créer un examen");
          System.out.println("2.Supprimer un examen");
            System.out.println("3.Ajouter la note d'un étudiant à un examen ");
           System.out.println("Veuillez choisir votre option :");
           int choice=scan.nextInt();
           switch(choice)
           {
               case 1:
                   
                   create_Exam();
                   break;
               case 2:
        
           
                   Delete_Exam();
           
                   break;
               case 3:
                   addstudentgrade();
                   break;
               default:
                   System.out.println("Veuillez choisir la bonne option");
           
           }
        
    }

    private static void addstudenttocourse() {
         Course fcs;
         Student st;
         String reg_no;
          try (Scanner scanner = new Scanner(new File("students.csv"));) {
    while (scanner.hasNextLine()) {
       
       Student.readstudent(scanner.nextLine());
    }
}       catch (FileNotFoundException ex) {
            System.out.println("FICHIER VIDE");
        }
         try (Scanner scanner = new Scanner(new File("course.csv"));) {
    while (scanner.hasNextLine()) {
       
       Course.readcourse(scanner.nextLine());
    }
}       catch (FileNotFoundException ex) {
            System.out.println("FICHIER VIDE ");
        }
        String courseid;
        String studentid;
         System.out.println("Entrez l'identifiant du cours pour y ajouter des étudiants :");
         scan.nextLine();
         courseid=scan.nextLine();
          System.out.println("Entrez le numéro d'enregistrement :");
          reg_no=scan.nextLine();
          Optional<Course> matchingObject =Course.courses.stream().
    filter(p -> String.valueOf(p.getCourse_id()).equals(courseid)).
    findFirst();
        if(matchingObject==null)
            System.out.println("Cours introuvable");
        else{
       fcs = matchingObject.get();
       System.out.println("Entrez l'identifiant du cours pour y ajouter des étudiants :");
         studentid=scan.nextLine();
         Optional<Student> matchingstuObject =Student.students.stream().
    filter(p -> String.valueOf(p.getStudent_id()).equals(studentid)).
    findFirst();
        if(matchingstuObject==null)
            System.out.println("Etudiant introuvable");
        else{
           st=matchingstuObject.get();
            
        try
        {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("registration.csv",true), "UTF-8"));
            
                StringBuilder oneLine = new StringBuilder();
                oneLine.append(reg_no.trim().length() == 0?  "" : reg_no);
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(fcs.getCourse_id().trim().length() == 0?  "" : fcs.getCourse_id());
                oneLine.append(CSV_SEPARATOR);
                 oneLine.append(fcs.getCourse_name().trim().length() == 0?  "" : fcs.getCourse_name());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(st.getStudent_id() == 0?  "" : st.getStudent_id());
                bw.append(oneLine.toString());
                bw.newLine();
        
            bw.flush();
            bw.close();
            
            System.out.println("L'inscription est enregistrée avec succès");
        }
         catch (UnsupportedEncodingException e) {}
            catch (FileNotFoundException e){}
            catch (IOException e){}
        }
        }
         
         
         
    }

    private static void deleteentry() {
                try (Scanner scanner = new Scanner(new File("registration.csv"));) {
    while (scanner.hasNextLine()) {
       
       readregistration(scanner.nextLine());
    }
}       catch (FileNotFoundException ex) {
            System.out.println("FICHIER VIDE");
        }
        String courseid;
       System.out.println("Saisissez l'identifiant du cours à supprimer :");
       courseid=scan.nextLine();
        Optional<Course> matchingObject =Course.courses.stream().
    filter(p -> String.valueOf(p.getCourse_id()).equals(courseid)).
    findFirst();
      Course fcs = matchingObject.get();
      Course.courses.remove(fcs);
      clearcoursefile();
      addcourselist();
      Student.students.clear();
         
    }

    private static void listregisteredstudents() {
          try (Scanner scanner = new Scanner(new File("registration.csv"));) {
    while (scanner.hasNextLine()) {
       
       readregistration(scanner.nextLine());
    }
}       catch (FileNotFoundException ex) {
            System.out.println("FICHIER  VIDE");
        }
        for (registration reg : registration.reg) {
            reg.toString();
        }
       
    }

    private static void listregisteredcourses() {
             try (Scanner scanner = new Scanner(new File("registration.csv"));) {
    while (scanner.hasNextLine()) {
       
       readregistration(scanner.nextLine());
    }
}       catch (FileNotFoundException ex) {
            System.out.println("FICHIER VIDE");
        }
        for (registration reg : registration.reg) {
            reg.toString();
        }
    }

    private static void readregistration(String s)
    {
         String[] r=s.split(",");
       
    
        
         String regno=r[0];
         String course_id=r[1];
          String course_name=r[2];
         String student_id=r[3];
         
        
 Optional<Course> matchingObject =Course.courses.stream().
    filter(p -> String.valueOf(p.getCourse_id()).equals(r[1])).
    findFirst();
      Course course=matchingObject.get();
        Optional<Student> matchingstuObject =Student.students.stream().
    filter(p -> String.valueOf(p.getStudent_id()).equals(r[3])).
    findFirst();
        Student student=matchingstuObject.get();
        List<Student> stl=new ArrayList<>();
        List<Course> courses=new ArrayList<>();
        stl.add(student);
        courses.add(course);
      registration.reg.add(new registration(regno,course_id,student_id,course_name,courses,stl));
    }

    private static void create_Exam() {
     String control_date;
     String control_duration;
     String control_coefficient;
     String Finalcontrol_date;
     String Finalcontrol_duration;
     String Finalcontrol_coefficient;
     String Practicalcontrol_date;
    String Practicalcontrol_duration;
     String Practicalcontrol_coefficient;
       
        
        System.out.println("Entrez la date d'examen :");
         scan.nextLine();
        control_date=scan.nextLine();
        System.out.println("Saisissez la duree de l'examen :");
        control_duration=scan.nextLine();
        System.out.println("Saisissez le coefficient :");
        control_coefficient=scan.nextLine();
        System.out.println("Entrez la date d'examen final");
        Finalcontrol_date=scan.nextLine();
        System.out.println("Entez la duree d'examen final");
        Finalcontrol_duration=scan.nextLine();
        System.out.println("Saisissez le coefficient :");
        Finalcontrol_coefficient=scan.nextLine();
        Finalcontrol_date=scan.nextLine();
        System.out.println("Entez la date du TP");
        Practicalcontrol_date=scan.nextLine();
        System.out.println("Entrez la duree du TP");
        Practicalcontrol_duration=scan.nextLine();
        System.out.println("Entez le coefficient:");
        Practicalcontrol_coefficient=scan.nextLine();
        Marks mark=new Marks(control_date,control_duration,control_coefficient,Finalcontrol_date,Finalcontrol_duration,Finalcontrol_coefficient,Practicalcontrol_date,Practicalcontrol_duration,Practicalcontrol_coefficient);
        
        try
        {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("examen.csv",true), "UTF-8"));
            
                StringBuilder oneLine = new StringBuilder();
                oneLine.append(mark.getControl_date().trim().length() == 0?  "" : mark.getControl_date());
                oneLine.append(CSV_SEPARATOR);
                 oneLine.append(mark.getControl_duration().trim().length() == 0?  "" : mark.getControl_duration());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(mark.getControl_coefficient().trim().length() == 0?  "" : mark.getControl_coefficient());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(mark.getFinalcontrol_date().trim().length() == 0?  "" : mark.getFinalcontrol_date());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(mark.getFinalcontrol_duration().trim().length() == 0?  "" : mark.getFinalcontrol_duration());
                  oneLine.append(CSV_SEPARATOR);
                oneLine.append(mark.getFinalcontrol_coefficient().trim().length() == 0?  "" : mark.getFinalcontrol_coefficient());
                 oneLine.append(CSV_SEPARATOR);
                oneLine.append(mark.getPracticalcontrol_date().trim().length() == 0?  "" : mark.getPracticalcontrol_date());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(mark.getPracticalcontrol_duration().trim().length() == 0?  "" : mark.getPracticalcontrol_duration());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(mark.getPracticalcontrol_coefficient().trim().length() == 0?  "" :mark.getPracticalcontrol_coefficient());
               
                bw.append(oneLine.toString());
                bw.newLine();
        
            bw.flush();
            bw.close();
            
            System.out.println("L'examen est enregistré avec succès");
        }
         catch (UnsupportedEncodingException e) {}
            catch (FileNotFoundException e){}
            catch (IOException e){}
    }

    private static void Delete_Exam() {
       File f;
            f = new File("examen.csv");
             f.delete();
             System.out.println("Supprimé avec succès");
                    
    }
    private static void addstudentgrade() {
       System.out.println("En cours..........");
    }
    
}
