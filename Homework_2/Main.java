/* Создайте абстрактный класс "Animal" с полями "name" и "age".
   Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.
   Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:
   Выведите на экран информацию о каждом объекте.
   Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.
 */

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[3];
        animals[0] = new Dog("Buddy", 3, "Golden Retriever");
        animals[1] = new Cat("Fluffy", 5, true);
        animals[2] = new Fish("Nemo", 1, "Red and White");

        for (Animal animal : animals) {
                Class<?> clazz = animal.getClass();
                System.out.println("Information about " + clazz.getSimpleName() + ":");

                while (clazz != null) {
                    Field[] fields = clazz.getDeclaredFields();

                    for (Field field : fields) {
                        field.setAccessible(true);
                        try {
                            System.out.println(field.getName() + ": " + field.get(animal));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                    clazz = clazz.getSuperclass();
                }

            try {
                Method makeSoundMethod = animal.getClass().getMethod("makeSound");
                makeSoundMethod.invoke(animal);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                System.out.println("This animal doesn't make any sound.");
            }
            System.out.println();
        }
    }
}

