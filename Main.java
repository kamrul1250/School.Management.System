package School.Management.System;

import java.util.ArrayList;
import java.util.List;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class Student extends Person {
    private int studentId;
    private int grade;

    public Student(String name, int age, int studentId, int grade) {
        super(name, age);
        this.studentId = studentId;
        this.grade = grade;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Student ID: " + studentId);
        System.out.println("Grade: " + grade);
    }
}

class Teacher extends Person {
    private int teacherId;
    private String subject;

    public Teacher(String name, int age, int teacherId, String subject) {
        super(name, age);
        this.teacherId = teacherId;
        this.subject = subject;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Teacher ID: " + teacherId);
        System.out.println("Subject: " + subject);
    }
}

interface Management {
    void admitStudent(Student student);
    void expelStudent(Student student);
    void assignTeacher(Teacher teacher);
}

class School implements Management {
    private List<Student> students;
    private Teacher teacher;

    public School() {
        students = new ArrayList<>();
    }

    @Override
    public void admitStudent(Student student) {
        students.add(student);
        System.out.println("Student " + student.getName() + " admitted successfully.");
    }

    @Override
    public void expelStudent(Student student) {
        if (students.remove(student)) {
            System.out.println("Student " + student.getName() + " expelled successfully.");
        } else {
            System.out.println("Student " + student.getName() + " not found.");
        }
    }

    @Override
    public void assignTeacher(Teacher teacher) {
        if (this.teacher == null) {
            this.teacher = teacher;
            System.out.println("Teacher " + teacher.getName() + " assigned successfully.");
        } else {
            System.out.println("Teacher already assigned.");
        }
    }

    public void displayStudents() {
        for (Student student : students) {
            student.displayInfo();
            System.out.println("---------------------");
        }
    }

    public void displayTeacher() {
        if (teacher != null) {
            teacher.displayInfo();
        } else {
            System.out.println("No teacher assigned yet.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        School school = new School();

        Student student1 = new Student("Selim", 15, 1, 9);
        Student student2 = new Student("Jasim ", 16, 2, 10);
        Student student3 = new Student("Daud", 14, 3, 8);

        Teacher teacher1 = new Teacher("Mr. Atik", 35, 1, "Mathematics");
        Teacher teacher2 = new Teacher("Mrs. Jibon", 40, 2, "Science");

        school.admitStudent(student1);
        school.admitStudent(student2);
        school.admitStudent(student3);

        school.assignTeacher(teacher1);
        school.assignTeacher(teacher2);

        school.displayStudents();
        school.displayTeacher();

        school.expelStudent(student2);

        school.displayStudents();
    }
}
