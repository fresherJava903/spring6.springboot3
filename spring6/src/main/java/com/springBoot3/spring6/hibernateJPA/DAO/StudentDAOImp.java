package com.springBoot3.spring6.hibernateJPA.DAO;

import com.springBoot3.spring6.hibernateJPA.entity.Student;
import com.springBoot3.spring6.hibernateJPA.repository.StudentDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImp implements StudentDAO {

    // EntityManager is auto initiated by Spring Boot
    private EntityManager entityManager;
    @Autowired
    public StudentDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public List<Student> getAllStudents() {
        TypedQuery<Student> sql = entityManager.createQuery("From Student", Student.class);
        return sql.getResultList();
    }

    @Override
    public Student findById(Integer id) {
        try {
            return entityManager.find(Student.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Integer id, String value) {
        Student student = entityManager.find(Student.class, id);
        student.setEmail(value);
        entityManager.merge(student);
    }

    @Override
    public void deleteStudent(Integer id) {
        try {
            Student student = entityManager.find(Student.class, id);
            entityManager.remove(student);

//            //delete all students
//            int rowAffected = entityManager.createQuery("Delete From Student").executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //using hibernate/jpa projection
    @Override
    public List<Object[]> names() {
//        Query sql = entityManager.createQuery("select firstName from Student");
//        return sql.getResultList();

        Query sql = entityManager.createQuery("select s.firstName, b.value from Student s join BankAccount b on s.id = b.studentId");
        return sql.getResultList();

//        //jpa projection on many columns on 1 table
//        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
//        Root<Student> product = query.from(Student.class);
//        query.multiselect(product.get("firstName"), product.get("lastName"));
//        List<Object[]> resultList = entityManager.createQuery(query).getResultList();

//        //jpa projection on 1 column
//        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<String> query = builder.createQuery(String.class);
//        Root<Student> product = query.from(Student.class);
//        query.select(product.get("firstName"));
//        List<String> resultList = entityManager.createQuery(query).getResultList();
//        return resultList;
    }
}
