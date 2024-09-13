package com.qspider.hibernate_practise_Eg1.Controller;

import com.qspider.hibernate_practise_Eg1.dao.StudentDao;
import com.qspider.hibernate_practise_Eg1.dto.Student;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class StudentInsertController {
    public static void main(String[] args) {
        StudentDao dao=new StudentDao();
        Scanner sc=new Scanner(System.in);
        char ch;
        do {
            System.out.println("1.Insert\n2.Delete\n3.DisplayById\n4.Update\n5.DiaplayAll");
            int choice =sc.nextInt();
            switch (choice){
                case 1: {
                    System.out.println("Enter Student id:");
                    int id=sc.nextInt();
                    System.out.println("Enter Student name:");
                    String name =sc.next();
                    System.out.println("Enter Student address:");
                    String address=sc.next();
                    System.out.println("Enter Student dob:");
                    String dob=sc.next();
                    LocalDate dob1=LocalDate.parse(dob);
                    Student student=dao.saveStudentDao(new Student(id,name,address,dob1));
                    System.out.println(student);
                    System.out.println("Data Inserted");
                }break;

                case 2:{
                    System.out.println("Enter the id to delete:");
                    int id=sc.nextInt();
                    boolean b=dao.deleteStudentDao(id);
                    if (b)
                        System.out.println("Data Deleted");
                    else
                        System.out.println("Something went wrong!!! Try again");
                }break;

                case 3: {
                    System.out.println("Enter id to display");
                    int id= sc.nextInt();
                    Student student=dao.displayStudentByIdDao(id);
                    if (student!=null)
                        System.out.println(student);
                    else
                        System.out.println("Something went wrong!!!Try again");
                }break;

                case 4: {
                    System.out.println("Enter the id :");
                    int id=sc.nextInt();
                    System.out.println("Enter the name to update:");
                    String name=sc.next();
                    Student stud=dao.updateStudentById(id,name);
                    if (stud!=null){
                        System.out.println("Data Updated");
                        System.out.println(stud);
                    }
                    else
                        System.out.println("Something went wrong!!!!");
                }break;

                case 5: {
                    List<Student> student=dao.displayAllStudentDao();
                    student.forEach(s-> System.out.println(s));
                }break;

                default:
                    System.out.println("Invalid Option!!!!! Try again");
            }
            System.out.println("Press y/Y to try again!");
            ch=sc.next().charAt(0);
        }while (ch=='y'|| ch=='Y');
        System.out.println("Invalid Option!!!");
    }
}
