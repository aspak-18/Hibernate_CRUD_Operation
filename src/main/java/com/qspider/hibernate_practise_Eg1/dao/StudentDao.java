package com.qspider.hibernate_practise_Eg1.dao;

import com.qspider.hibernate_practise_Eg1.dto.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class StudentDao {
    EntityManagerFactory emf =Persistence.createEntityManagerFactory("hibernate-practise");
    EntityManager em =emf.createEntityManager();
    EntityTransaction et =em.getTransaction();

    public Student saveStudentDao(Student s){
        et.begin();
        em.persist(s);
        et.commit();
        return s;
    }

    public Student displayStudentByIdDao(int id){
        Student stud=em.find(Student.class,id);
        return stud;
    }

    public boolean deleteStudentDao(int id){
        Student student=displayStudentByIdDao(id);
        if (student!=null){
            et.begin();
            em.remove(student);
            et.commit();
            return true;
        }
        else
            return false;
    }

    public Student updateStudentById(int id, String name){
        Student student=displayStudentByIdDao(id);
        if (student!=null){
            student.setName(name);
            et.begin();
            em.merge(student);
            et.commit();
            return student;
        }
        else
            return null;
    }

    public List<Student> displayAllStudentDao(){
        return em.createQuery("FROM Student").getResultList();
    }
}
