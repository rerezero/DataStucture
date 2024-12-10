package bd1;
import dataStructures.*;
import java.io.FileNotFoundException;
import java.io.*;
import java.util.*;

public class Registration {
    public ArrayLinearList studentList;
    public ArrayLinearList subjectList;
    public ArrayLinearList majorList;

    public Registration() {
        studentList = new ArrayLinearList();
        subjectList = new ArrayLinearList();
        majorList = new ArrayLinearList();
    }


    public void readSubjectList() {
        try {
            File file = new File("Subjects.txt");
            Scanner sc = new Scanner(file);
            int k = 0;
            while (sc.hasNext()) {
                Subject sj = new Subject(sc.nextLine());
                subjectList.add(k++, sj);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
            System.exit(1);
        }
    }

    public void printSubjects() {
        Subject.displayHead();
        for (int i = 0; i < subjectList.size(); i++)
            ((Subject) subjectList.get(i)).display();
    }

    public void readMajorList() {
        try {
            File file = new File("Professions.txt");
            Scanner sc = new Scanner(file);
            int k = 0;
            while (sc.hasNext()) {
                Major mj = new Major(sc.nextLine());
                majorList.add(k++, mj);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
            System.exit(1);
        }
    }

    public void printMajors() {
        Major.displayHead();
        for (int i = 0; i < majorList.size(); i++)
            ((Major) majorList.get(i)).display();
    }

    public void readStudentList() {
        studentList = new ArrayLinearList();
        try {
            File file = new File("Exams.txt");
            Scanner sc = new Scanner(file);
            int k = 0;
            while (sc.hasNext()) {
                String ss = sc.nextLine();
                String[] strArr = ss.split("/");
                if (this.checkStudent(strArr[1]) == -1) {
                    Student stdnt = new Student(strArr[1], this.findMajor(strArr[0]));
                    if (this.findSubject(strArr[2]) != -1) {
                        stdnt.addLesson((Subject) this.subjectList.get(this.findSubject(strArr[2])),
                                Integer.parseInt(strArr[3]));
                    }
                    studentList.add(k++, stdnt);
                } else {
                    ((Student) this.studentList.get(this.checkStudent(strArr[1]))).addLesson((Subject)
                                    this.subjectList.get(this.findSubject(strArr[2])),
                            Integer.parseInt(strArr[3]));
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public void displayStudentGPA() {
        Student.displayHeader();
        for (int i = 0; i < studentList.size(); i++) {
            ((Student) studentList.get(i)).displayGPA();
        }
    }

    public void displayAverageGPA() {
        float totalGPA = 0;
        int studentCount = studentList.size();
        for (int i = 0; i < studentList.size(); i++) {
            totalGPA += ((Student) studentList.get(i)).getGPA();
        }
        float averageGPA = studentCount > 0 ? totalGPA / studentCount : 0;
        System.out.printf("\nBuh suragchdiin golch dun: %.2f\n", averageGPA);
    }

    public void displayGradesPerSubject() {
        System.out.println("\n**** Hicheel bolgon deerh dun ****");
        for (int i = 0; i < subjectList.size(); i++) {
            Subject subject = (Subject) subjectList.get(i);
            System.out.printf("\nHicheel: %s (%s)\n", subject.getSubjectName(), subject.getSubjectCode());
            String titleTemplate = "%-20s %10s\n";
            System.out.printf(titleTemplate, "Student Code", "Score");
            for (int j = 0; j < studentList.size(); j++) {
                Student student = (Student) studentList.get(j);
                for (int k = 0; k < student.getLessons().size(); k++) {
                    Lesson lesson = (Lesson) student.getLessons().get(k);
                    if (lesson.learned != null && lesson.learned.getSubjectCode().equals(subject.getSubjectCode())) {
                        System.out.printf(titleTemplate, student.getCode(), lesson.score);
                    }
                }
            }
        }
    }

    public void displayGradesPerMajor() {
        System.out.println("\n**** Mergejil bolgon deerh dun****");
        for (int i = 0; i < majorList.size(); i++) {
            Major major = (Major) majorList.get(i);
            System.out.printf("\nMergejil: %s (%s)\n", major.getName(), major.getCode());
            String titleTemplate = "%-20s %10s\n";
            System.out.printf(titleTemplate, "Student Code", "GPA");
            for (int j = 0; j < studentList.size(); j++) {
                Student student = (Student) studentList.get(j);
                if (student.getMajor().getCode().equals(major.getCode())) {
                    System.out.printf(titleTemplate, student.getCode(), student.getGPA());
                }
            }
        }
    }

    public int checkStudent(String studentCode) {
        for (int i = 0; i < studentList.size(); i++) {
            Student student = (Student) studentList.get(i);
            if (student.getCode().equals(studentCode)) {
                return i;
            }
        }
        return -1;
    }

    public int findSubject(String subjectCode) {
        for (int i = 0; i < subjectList.size(); i++) {
            Subject subject = (Subject) subjectList.get(i);
            if (subject.getSubjectCode().equals(subjectCode)) {
                return i;
            }
        }
        return -1;
    }

    public Major findMajor(String majorCode) {
        for (int i = 0; i < majorList.size(); i++) {
            Major major = (Major) majorList.get(i);
            if (major.getCode().equals(majorCode)) {
                return major;
            }
        }
        return null;
    }
    

    public void displayFailingStudents() {
        System.out.println("\n**** 3 bolon tuunees deesh F awsan oyutnuud ****");
        String titleTemplate = "%-20s %10s\n";
        System.out.printf(titleTemplate, "Student Code", "Fiin Too");
        for (int i = 0; i < studentList.size(); i++) {
            Student student = (Student) studentList.get(i);
            int failDun = 0;
            for (int j = 0; j < student.getLessons().size(); j++) {
                Lesson lesson = (Lesson) student.getLessons().get(j);
                if (lesson.unelgeeOnoo() == 0.0f) {
                    failDun++;
                }
            }
            if (failDun >= 3) {
                System.out.printf(titleTemplate, student.getCode(), failDun);
            }
        }
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Buh hicheeliig haruulah");
            System.out.println("2. Buh mergejliig haruulah");
            System.out.println("3. 3 bolon tuunees deesh F awsan oyutang haruulah");
            System.out.println("4. Oyutang code oorn hain medeelliig harah");
            System.out.println("5. Hicheeliin code oor hicheel deer oyutnuud ymar dun awsang harah");
            System.out.println("6. Garah");
            System.out.print("Songoltoo oruulna uu: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    printSubjects();
                    break;
                case 2:
                    printMajors();
                    break;
                case 3:
                    displayFailingStudents();
                    break;
                case 4:
                    System.out.print("Oyutnii code iig oruul: ");
                    String studentCode = scanner.nextLine();
                    int index = checkStudent(studentCode);
                    if (index != -1) {
                        Student student = (Student) studentList.get(index);
                        
                        student.displayGPA();

                        System.out.println("\n**** Oyutnii uzsen hicheel bolon dun ****");
                        String titleTemplate = "%-20s %-15s %-10s %-10s\n";
                        System.out.printf(titleTemplate, "Hicheeliin Ner", "Hicheeliin Code", "Credit", "Dun");
                        for (int i = 0; i < student.getLessons().size(); i++) {
                            Lesson lesson = (Lesson) student.getLessons().get(i);
                            System.out.printf(
                                titleTemplate, 
                                lesson.learned.getSubjectName(), 
                                lesson.learned.getSubjectCode(), 
                                lesson.learned.getCredit(),     
                                lesson.score                     
                            );
                        }
                    } else {
                        System.out.println("Oyutan oldsongue");
                    }
                    break;

                case 5:
                    System.out.print("Hicheeliin codeiig oruulna uu: ");
                    String subjectCode = scanner.nextLine();
                    int subjectIndex = findSubject(subjectCode);
                    if (subjectIndex != -1) {
                        Subject subject = (Subject) subjectList.get(subjectIndex);
                        System.out.printf("\nHicheel: %s (%s)\n", subject.getSubjectName(), subject.getSubjectCode());
                        String titleTemplate = "%-20s %10s\n";
                        System.out.printf(titleTemplate, "Student Code", "Score");
                        for (int j = 0; j < studentList.size(); j++) {
                            Student student = (Student) studentList.get(j);
                            for (int k = 0; k < student.getLessons().size(); k++) {
                                Lesson lesson = (Lesson) student.getLessons().get(k);
                                if (lesson.learned != null && lesson.learned.getSubjectCode().equals(subject.getSubjectCode())) {
                                    System.out.printf(titleTemplate, student.getCode(), lesson.score);
                                }
                            }
                        }
                    } else {
                        System.out.println("Hicheel oldsongue.");
                    }
                    break;
                case 6:
                    System.out.println("Garah");
                    return;
                default:
                    System.out.println("");
            }
        }
    }

    public static void main(String[] args) {
        Registration rr = new Registration();
        rr.readSubjectList();
        rr.readMajorList();
        rr.readStudentList();
        rr.menu();
    }
}

