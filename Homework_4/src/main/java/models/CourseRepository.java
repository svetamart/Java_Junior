package models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Collections;
import java.util.List;

public class CourseRepository {

    private final SessionFactory sessionFactory;

    public CourseRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addCourse(Course course) {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(course);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Course> getAllCourses() {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            List<Course> courses = session.createQuery("FROM Course", Course.class).list();
            transaction.commit();
            return courses;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public Course getCourseById(int courseId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Course course = session.get(Course.class, courseId);
            transaction.commit();
            return course;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateCourse(Course updatedCourse) {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(updatedCourse);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCourse(int courseId) {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            Course courseToDelete = session.get(Course.class, courseId);
            if (courseToDelete != null) {
                session.delete(courseToDelete);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAll() {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            session.createQuery("DELETE FROM Course").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
