
package com.mycompany.campustracker;
import java.io.*;
import java.util.*;
public class CampusTracker {
  static class VE extends Exception {
    public VE(String msg) {
      super(msg);
    }
  }
  static class SE extends RuntimeException {
    public SE(String msg, Throwable err) {
      super(msg, err);
    }
  }
  static class St {
    private final String id;
    private String nm,em,dept;
    private int sem;
    public St(String id,String nm,String em,String dept,int sem) {
      this.id=id;
      this.nm=nm;
      this.em=em;
      this.dept=dept;
      this.sem=sem;
    }
    public String getId(){return id;}
    public String getName(){return nm;}
    public String getEmail(){return em;}
    public String getDepartment(){return dept;}
    public int getSemester(){return sem;}
    public void setName(String nm){this.nm=nm;}
    public void setEmail(String em){this.em=em;}
    public void setDepartment(String dept){this.dept=dept;}
    public void setSemester(int sem){this.sem=sem;}
    public String toString(){return id+" | "+nm+" | "+em+" | "+dept+" | Sem "+sem;}
    public String toFileLine(){return String.join("|",id,nm,em,dept,String.valueOf(sem));}
    public static St fromFileLine(String ln){
      String[] p=ln.split("\\|",-1);
      if(p.length!=5) throw new IllegalArgumentException("Invalid student record: "+ln);
      return new St(p[0],p[1],p[2],p[3],Integer.parseInt(p[4]));
    }
  }
  static class Cr {
    private final String code;
    private String ttl,fac;
    private int cr;
    public Cr(String code,String ttl,int cr,String fac){
      this.code=code;
      this.ttl=ttl;
      this.cr=cr;
      this.fac=fac;
    }
    public String getCode(){return code;}
    public String getTitle(){return ttl;}
    public int getCredits(){return cr;}
    public String getFaculty(){return fac;}
    public void setTitle(String ttl){this.ttl=ttl;}
    public void setCredits(int cr){this.cr=cr;}
    public void setFaculty(String fac){this.fac=fac;}
    public String toString(){return code+" | "+ttl+" | "+cr+" credit(s) | Faculty: "+fac;}
    public String toFileLine(){return String.join("|",code,ttl,String.valueOf(cr),fac);}
    public static Cr fromFileLine(String ln){
      String[] p=ln.split("\\|",-1);
      if(p.length!=4) throw new IllegalArgumentException("Invalid course record: "+ln);
      return new Cr(p[0],p[1],Integer.parseInt(p[2]),p[3]);
    }
  }
  static class En {
    private final String sid,cc;
    public En(String sid,String cc){this.sid=sid;this.cc=cc;}
    public String getStudentId(){return sid;}
    public String getCourseCode(){return cc;}
    public String toString(){return sid+" -> "+cc;}
    public String toFileLine(){return sid+"|"+cc;}
    public static En fromFileLine(String ln){
      String[] p=ln.split("\\|",-1);
      if(p.length!=2) throw new IllegalArgumentException("Invalid enrollment record: "+ln);
      return new En(p[0],p[1]);
    }
  }
  static class At {
    private final String sid,cc;
    private final int att,tot;
    public At(String sid,String cc,int att,int tot){
      this.sid=sid;
      this.cc=cc;
      this.att=att;
      this.tot=tot;
    }
    public String getStudentId(){return sid;}
    public String getCourseCode(){return cc;}
    public int getAttended(){return att;}
    public int getTotal(){return tot;}
    public double percentage(){return tot==0?0.0:(att*100.0)/tot;}
    public String status(){return percentage()>=75.0?"ELIGIBLE":"SHORT ATTENDANCE";}
    public String toString(){return sid+" | "+cc+" | "+att+"/"+tot+" | "+String.format("%.2f",percentage())+"% | "+status();}
    public String toFileLine(){return String.join("|",sid,cc,String.valueOf(att),String.valueOf(tot));}
    public static At fromFileLine(String ln){
      String[] p=ln.split("\\|",-1);
      if(p.length!=4) throw new IllegalArgumentException("Invalid attendance record: "+ln);
      return new At(p[0],p[1],Integer.parseInt(p[2]),Integer.parseInt(p[3]));
    }
  }
  static class Ss {
    private final List<St> sts=new ArrayList<>();
    public void addStudent(St st)throws VE{
      validate(st);
      if(findById(st.getId())!=null) throw new VE("Student ID already exists.");
      sts.add(st);
    }
    public St findById(String id){
      for(St s:sts) if(s.getId().equalsIgnoreCase(id)) return s;
      return null;
    }
    public List<St> getAll(){return new ArrayList<>(sts);}
    public void updateStudent(St st)throws VE{
      validate(st);
      St ex=findById(st.getId());
      if(ex==null) throw new VE("Student not found.");
      ex.setName(st.getName());
      ex.setEmail(st.getEmail());
      ex.setDepartment(st.getDepartment());
      ex.setSemester(st.getSemester());
    }
    public void deleteStudent(String id)throws VE{
      St ex=findById(id);
      if(ex==null) throw new VE("Student not found.");
      sts.remove(ex);
    }
    public void replaceAll(List<St> d){sts.clear();sts.addAll(d);}
    private void validate(St s)throws VE{
      if(s==null) throw new VE("Student cannot be null.");
      if(blank(s.getId())||blank(s.getName())||blank(s.getEmail())||blank(s.getDepartment())) throw new VE("All student fields are required.");
      if(!s.getEmail().matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) throw new VE("Enter a valid email address.");
      if(s.getSemester()<1||s.getSemester()>8) throw new VE("Semester must be between 1 and 8.");
    }
    private boolean blank(String val){return val==null||val.trim().isEmpty();}
  }
  static class Cs {
    private final List<Cr> cos=new ArrayList<>();
    public void addCourse(Cr co)throws VE{
      validate(co);
      if(findByCode(co.getCode())!=null) throw new VE("Course code already exists.");
      cos.add(co);
    }
    public Cr findByCode(String code){
      for(Cr c:cos) if(c.getCode().equalsIgnoreCase(code)) return c;
      return null;
    }
    public List<Cr> getAll(){return new ArrayList<>(cos);}
    public void updateCourse(Cr co)throws VE{
      validate(co);
      Cr ex=findByCode(co.getCode());
      if(ex==null) throw new VE("Course not found.");
      ex.setTitle(co.getTitle());
      ex.setCredits(co.getCredits());
      ex.setFaculty(co.getFaculty());
    }
    public void deleteCourse(String code)throws VE{
      Cr c=findByCode(code);
      if(c==null) throw new VE("Course not found.");
      cos.remove(c);
    }
    public void replaceAll(List<Cr> d){cos.clear();cos.addAll(d);}
    private void validate(Cr c)throws VE{
      if(c==null) throw new VE("Course cannot be null.");
      if(blank(c.getCode())||blank(c.getTitle())||blank(c.getFaculty())) throw new VE("All course fields are required.");
      if(c.getCredits()<1||c.getCredits()>6) throw new VE("Credits must be between 1 and 6.");
    }
    private boolean blank(String val){return val==null||val.trim().isEmpty();}
  }
  static class Es {
    private final List<En> ens=new ArrayList<>();
    private final Ss ss;
    private final Cs cs;
    public Es(Ss ss,Cs cs){this.ss=ss;this.cs=cs;}
    public void enroll(String sid,String cc)throws VE{
      St st=ss.findById(sid);
      Cr co=cs.findByCode(cc);
      if(st==null) throw new VE("Student not found.");
      if(co==null) throw new VE("Course not found.");
      if(isEnrolled(sid,cc)) throw new VE("Student is already enrolled in this course.");
      ens.add(new En(sid,cc));
    }
    public boolean isEnrolled(String sid,String cc){
      for(En e:ens) if(e.getStudentId().equalsIgnoreCase(sid)&&e.getCourseCode().equalsIgnoreCase(cc)) return true;
      return false;
    }
    public List<En> getAll(){return new ArrayList<>(ens);}
    public List<En> byStudent(String sid){
      List<En> res=new ArrayList<>();
      for(En e:ens) if(e.getStudentId().equalsIgnoreCase(sid)) res.add(e);
      return res;
    }
    public void replaceAll(List<En> d){ens.clear();ens.addAll(d);}
  }
  static class As {
    private final List<At> recs=new ArrayList<>();
    private final Es es;
    public As(Es es){this.es=es;}
    public void saveRecord(At rec)throws VE{
      if(rec==null) throw new VE("Attendance record cannot be null.");
      if(rec.getAttended()<0||rec.getTotal()<=0||rec.getAttended()>rec.getTotal()) throw new VE("Attendance values are invalid.");
      if(!es.isEnrolled(rec.getStudentId(),rec.getCourseCode())) throw new VE("Student must be enrolled in the course before attendance is recorded.");
      At ex=find(rec.getStudentId(),rec.getCourseCode());
      if(ex==null) recs.add(rec); else {recs.remove(ex);recs.add(rec);}
    }
    public At find(String sid,String cc){
      for(At r:recs) if(r.getStudentId().equalsIgnoreCase(sid)&&r.getCourseCode().equalsIgnoreCase(cc)) return r;
      return null;
    }
    public List<At> getAll(){return new ArrayList<>(recs);}
    public List<At> byStudent(String sid){
      List<At> res=new ArrayList<>();
      for(At r:recs) if(r.getStudentId().equalsIgnoreCase(sid)) res.add(r);
      return res;
    }
    public void replaceAll(List<At> d){recs.clear();recs.addAll(d);}
  }
  static class Rs {
    public String buildStudentReport(St st,List<En> ens,List<Cr> cos,List<At> atts){
      StringBuilder out=new StringBuilder();
      out.append("==== STUDENT REPORT ====\n");
      out.append("Student: ").append(st.getName()).append(" (").append(st.getId()).append(")\n");
      out.append("Department: ").append(st.getDepartment()).append(" | Semester: ").append(st.getSemester()).append("\n\n");
      out.append("Course Enrollments:\n");
      int cnt=0;
      for(En e:ens){
        if(!e.getStudentId().equalsIgnoreCase(st.getId())) continue;
        cnt++;
        Cr co=findCourse(cos,e.getCourseCode());
        out.append("- ").append(e.getCourseCode());
        if(co!=null) out.append(" : ").append(co.getTitle());
        At ar=findAttendance(atts,st.getId(),e.getCourseCode());
        if(ar!=null) out.append(" | Attendance: ").append(String.format("%.2f",ar.percentage())).append("%");
        else out.append(" | Attendance: Not recorded");
        out.append('\n');
      }
      if(cnt==0) out.append("- No courses enrolled.\n");
      return out.toString();
    }
    public String buildDashboard(List<St> sts,List<Cr> cos,List<En> ens,List<At> atts){
      Map<String,Integer> dc=new HashMap<>();
      for(St s:sts) dc.put(s.getDepartment(),dc.getOrDefault(s.getDepartment(),0)+1);
      int el=0;
      for(At r:atts) if(r.percentage()>=75.0) el++;
      StringBuilder out=new StringBuilder();
      out.append("==== ACADEMIC DASHBOARD ====\n");
      out.append("Students       : ").append(sts.size()).append('\n');
      out.append("Courses        : ").append(cos.size()).append('\n');
      out.append("Enrollments    : ").append(ens.size()).append('\n');
      out.append("Attendance rows: ").append(atts.size()).append('\n');
      out.append("Eligible rows  : ").append(el).append('\n');
      out.append("Departments    : ").append(dc).append('\n');
      return out.toString();
    }
    private Cr findCourse(List<Cr> cos,String code){
      for(Cr c:cos) if(c.getCode().equalsIgnoreCase(code)) return c;
      return null;
    }
    private At findAttendance(List<At> atts,String sid,String code){
      for(At r:atts) if(r.getStudentId().equalsIgnoreCase(sid)&&r.getCourseCode().equalsIgnoreCase(code)) return r;
      return null;
    }
  }
  static class Ds {
    private final File dir;
    public Ds(String dn){
      dir=new File(dn);
      if(!dir.exists()&&!dir.mkdirs()) throw new IllegalStateException("Unable to create data directory: "+dir.getAbsolutePath());
    }
    public List<St> loadStudents()throws SE{
      List<St> res=new ArrayList<>();
      readLines("students.txt",ln->res.add(St.fromFileLine(ln)));
      return res;
    }
    public List<Cr> loadCourses()throws SE{
      List<Cr> res=new ArrayList<>();
      readLines("courses.txt",ln->res.add(Cr.fromFileLine(ln)));
      return res;
    }
    public List<En> loadEnrollments()throws SE{
      List<En> res=new ArrayList<>();
      readLines("enrollments.txt",ln->res.add(En.fromFileLine(ln)));
      return res;
    }
    public List<At> loadAttendance()throws SE{
      List<At> res=new ArrayList<>();
      readLines("attendance.txt",ln->res.add(At.fromFileLine(ln)));
      return res;
    }
    public synchronized void saveAll(List<St> sts,List<Cr> cos,List<En> ens,List<At> atts)throws SE{
      writeLines("students.txt",sts,St::toFileLine);
      writeLines("courses.txt",cos,Cr::toFileLine);
      writeLines("enrollments.txt",ens,En::toFileLine);
      writeLines("attendance.txt",atts,At::toFileLine);
    }
    interface LineConsumer{void accept(String ln)throws Exception;}
    interface LineProducer<T>{String produce(T item);}
    private void readLines(String fn,LineConsumer con)throws SE{
      File f=new File(dir,fn);
      if(!f.exists()) return;
      try(BufferedReader br=new BufferedReader(new FileReader(f))){
        String ln;
        while((ln=br.readLine())!=null) if(!ln.trim().isEmpty()) con.accept(ln);
      }catch(Exception e){
        throw new SE("Could not read "+fn,e);
      }
    }
    private <T> void writeLines(String fn,List<T> its,LineProducer<T> prod)throws SE{
      File f=new File(dir,fn);
      try(BufferedWriter bw=new BufferedWriter(new FileWriter(f))){
        for(T item:its){
          bw.write(prod.produce(item));
          bw.newLine();
        }
      }catch(IOException e){
        throw new SE("Could not write "+fn,e);
      }
    }
  }
  static class Ast extends Thread {
    private final Ds ds;
    private final Ss ss;
    private final Cs cs;
    private final Es es;
    private final As ats;
    private volatile boolean run=true;
    public Ast(Ds ds,Ss ss,Cs cs,Es es,As ats){
      super("CampusTracker-AutoSave");
      this.ds=ds;
      this.ss=ss;
      this.cs=cs;
      this.es=es;
      this.ats=ats;
      setDaemon(true);
    }
    public void stopTask(){
      run=false;
      interrupt();
    }
    public void run(){
      while(run){
        try{
          Thread.sleep(30000);
          if(run) saveNow();
        }catch(InterruptedException ignored){}catch(SE e){
          System.err.println("Auto-save warning: "+e.getMessage());
        }
      }
    }
    public void saveNow()throws SE{
      ds.saveAll(ss.getAll(),cs.getAll(),es.getAll(),ats.getAll());
    }
  }
  private final Scanner scn=new Scanner(System.in);
  private final Ss ss=new Ss();
  private final Cs cs=new Cs();
  private final Es es=new Es(ss,cs);
  private final As ats=new As(es);
  private final Rs rs=new Rs();
  private final Ds ds=new Ds("data");
  private Ast ast;
  public static void main(String[] args){new CampusTracker().start();}
  private void start(){
    loadData();
    ast=new Ast(ds,ss,cs,es,ats);
    ast.start();
    System.out.println("      Student Academic Management");
    boolean run=true;
    while(run){
      printMenu();
      String ch=in("Enter choice: ");
      try{
        switch(ch){
          case "1": addStudent(); break;
          case "2": listStudents(); break;
          case "3": updateStudent(); break;
          case "4": deleteStudent(); break;
          case "5": addCourse(); break;
          case "6": listCourses(); break;
          case "7": updateCourse(); break;
          case "8": deleteCourse(); break;
          case "9": enrollStudent(); break;
          case "10": listEnrollments(); break;
          case "11": recordAttendance(); break;
          case "12": showStudentReport(); break;
          case "13": showDashboard(); break;
          case "14": manualSave(); break;
          case "0": run=false; break;
          default: System.out.println("Invalid option.");
        }
      }catch(VE|SE e){
        System.out.println("ERROR: "+e.getMessage());
      }catch(NumberFormatException e){
        System.out.println("ERROR: Please enter a valid number.");
      }
    }
    try{
      manualSave();
    }catch(SE e){
      System.out.println("Final save failed: "+e.getMessage());
    }
    if(ast!=null) ast.stopTask();
    scn.close();
    System.out.println("Thank you for using CampusTrack.");
  }
  private void printMenu(){
    System.out.println("\n----------- MAIN MENU -----------");
    System.out.println("1. Add Student");
    System.out.println("2. List Students");
    System.out.println("3. Update Student");
    System.out.println("4. Delete Student");
    System.out.println("5. Add Course");
    System.out.println("6. List Courses");
    System.out.println("7. Update Course");
    System.out.println("8. Delete Course");
    System.out.println("9. Enroll Student in Course");
    System.out.println("10. List Enrollments");
    System.out.println("11. Record / Update Attendance");
    System.out.println("12. Student Academic Report");
    System.out.println("13. Dashboard");
    System.out.println("14. Save Data Now");
    System.out.println("0. Exit");
  }
  private void addStudent()throws VE{
    String id=in("Student ID: ");
    String nm=in("Name: ");
    String em=in("Email: ");
    String dept=in("Department: ");
    int sem=Integer.parseInt(in("Semester (1-8): "));
    ss.addStudent(new St(id,nm,em,dept,sem));
    System.out.println("Student added successfully.");
  }
  private void listStudents(){
    List<St> d=ss.getAll();
    System.out.println("\n===== STUDENTS =====");
    if(d.isEmpty()) System.out.println("No students found.");
    for(St s:d) System.out.println(s);
  }
  private void updateStudent()throws VE{
    String id=in("Student ID to update: ");
    St ex=ss.findById(id);
    if(ex==null) throw new VE("Student not found.");
    String nm=in("New name: ");
    String em=in("New email: ");
    String dept=in("New department: ");
    int sem=Integer.parseInt(in("New semester (1-8): "));
    ss.updateStudent(new St(id,nm,em,dept,sem));
    System.out.println("Student updated successfully.");
  }
  private void deleteStudent()throws VE{
    String id=in("Student ID to delete: ");
    ss.deleteStudent(id);
    System.out.println("Student deleted.");
  }
  private void addCourse()throws VE{
    String code=in("Course code: ");
    String ttl=in("Course title: ");
    int cr=Integer.parseInt(in("Credits (1-6): "));
    String fac=in("Faculty name: ");
    cs.addCourse(new Cr(code,ttl,cr,fac));
    System.out.println("Course added successfully.");
  }
  private void listCourses(){
    List<Cr> d=cs.getAll();
    System.out.println("\n===== COURSES =====");
    if(d.isEmpty()) System.out.println("No courses found.");
    for(Cr c:d) System.out.println(c);
  }
  private void updateCourse()throws VE{
    String code=in("Course code to update: ");
    Cr ex=cs.findByCode(code);
    if(ex==null) throw new VE("Course not found.");
    String ttl=in("New course title: ");
    int cr=Integer.parseInt(in("New credits (1-6): "));
    String fac=in("New faculty name: ");
    cs.updateCourse(new Cr(code,ttl,cr,fac));
    System.out.println("Course updated successfully.");
  }
  private void deleteCourse()throws VE{
    String code=in("Course code to delete: ");
    cs.deleteCourse(code);
    System.out.println("Course deleted.");
  }
  private void enrollStudent()throws VE{
    String sid=in("Student ID: ");
    String cc=in("Course code: ");
    es.enroll(sid,cc);
    System.out.println("Enrollment completed.");
  }
  private void listEnrollments(){
    List<En> d=es.getAll();
    System.out.println("\n===== ENROLLMENTS =====");
    if(d.isEmpty()) System.out.println("No enrollments found.");
    for(En e:d) System.out.println(e);
  }
  private void recordAttendance()throws VE{
    String sid=in("Student ID: ");
    String cc=in("Course code: ");
    int att=Integer.parseInt(in("Classes attended: "));
    int tot=Integer.parseInt(in("Total classes: "));
    ats.saveRecord(new At(sid,cc,att,tot));
    System.out.println("Attendance saved.");
  }
  private void showStudentReport()throws VE{
    String sid=in("Student ID: ");
    St st=ss.findById(sid);
    if(st==null) throw new VE("Student not found.");
    String rep=rs.buildStudentReport(st,es.getAll(),cs.getAll(),ats.getAll());
    System.out.println(rep);
  }
  private void showDashboard(){
    System.out.println(rs.buildDashboard(ss.getAll(),cs.getAll(),es.getAll(),ats.getAll()));
  }
  private void manualSave()throws SE{
    if(ast!=null) ast.saveNow();
    else ds.saveAll(ss.getAll(),cs.getAll(),es.getAll(),ats.getAll());
    System.out.println("Data saved successfully.");
  }
  private void loadData(){
    try{
      ss.replaceAll(ds.loadStudents());
      cs.replaceAll(ds.loadCourses());
      es.replaceAll(ds.loadEnrollments());
      ats.replaceAll(ds.loadAttendance());
    }catch(SE|IllegalArgumentException e){
      System.out.println("Could not load some saved data: "+e.getMessage());
    }
  }
  private String in(String pr){
    System.out.print(pr);
    return scn.nextLine().trim();
  }
}
