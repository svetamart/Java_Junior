/*
    Создайте базу данных (например, SchoolDB).
    В этой базе данных создайте таблицу Courses с полями id (ключ), title, и duration.
    Настройте Hibernate для работы с вашей базой данных.
    Создайте Java-класс models.Course, соответствующий таблице Courses, с необходимыми аннотациями Hibernate.
    Используя Hibernate, напишите код для вставки, чтения, обновления и удаления данных в таблице Courses.
    Убедитесь, что каждая операция выполняется в отдельной транзакции.
 */

import models.Course;
import models.CourseRepository;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try(SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .buildSessionFactory()){

            CourseRepository courseRepository = new CourseRepository(sessionFactory);

            // Очистить таблицу
            courseRepository.deleteAll();

            // Добавление курсов
            Course course1 = new Course("Введение в базы данных", 3);
            Course course2 = new Course("Java программирование", 10);
            Course course3 = new Course("Java Junior", 4);
            courseRepository.addCourse(course1);
            courseRepository.addCourse(course2);
            courseRepository.addCourse(course3);

            // Получение списка всех курсов
            List<Course> allCourses = courseRepository.getAllCourses();
            System.out.println("All Courses: " + allCourses);

            // Получение курса по идентификатору и вывод
            Course retrievedCourse = courseRepository.getCourseById(course1.getId());
            System.out.println("Retrieved Course by ID: " + retrievedCourse);

            // Обновление информации о курсе
            retrievedCourse.setDuration(5);
            courseRepository.updateCourse(retrievedCourse);

            // Получение списка всех курсов после обновления
            allCourses = courseRepository.getAllCourses();
            System.out.println("All Courses after update: " + allCourses);

            // Удаление курса
            courseRepository.deleteCourse(course2.getId());

            // Получение списка всех курсов после удаления
            allCourses = courseRepository.getAllCourses();
            System.out.println("All Courses after deletion: " + allCourses);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
