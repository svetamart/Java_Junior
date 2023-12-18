import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/* Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).
Обеспечьте поддержку сериализации для этого класса.
Создайте объект класса Student и инициализируйте его данными.
Сериализуйте этот объект в файл. Десериализуйте объект обратно в программу из файла.
Выведите все поля объекта, включая GPA, и обсудите, почему значение GPA не было сохранено/восстановлено.
 */

public class Student implements Serializable {
    private String name;
    private int age;

    @JsonIgnore
    private transient double GPA;

    @JsonCreator
    public Student(@JsonProperty("name") String name, @JsonProperty("age") int age, @JsonProperty("gpa") double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @JsonIgnore
    public double getGPA() {
        return GPA;
    }
}
