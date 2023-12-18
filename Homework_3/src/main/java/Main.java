import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("John Smith", 16, 3.7));
        students.add(new Student("Jane Smith", 17, 4.1));
        students.add(new Student("Mary Jones", 16, 4.8));
        students.add(new Student("Andy Brown", 15, 3.0));
        students.add(new Student("James White", 18, 4.3));
        students.add(new Student("Ann Green", 16, 4.5));

        serialize(students, "students.json");
        serialize(students, "students.bin");
        serialize(students, "students.xml");

        for (Student student : students) {
            System.out.println("Name: " + student.getName());
            System.out.println("Age: " + student.getAge());
            System.out.println("GPA: " + student.getGPA());
        }
        System.out.println("Serialization completed.");
        System.out.println();

        List<Student> deserializedStudentListJSON = deserialize("students.json");
        List<Student> deserializedStudentListXML = deserialize("students.xml");
        List<Student> deserializedStudentListBIN = deserialize("students.bin");
        System.out.println("Deserialization completed.");
        System.out.println();

        for (Student student : deserializedStudentListXML) {
            System.out.println("Name: " + student.getName());
            System.out.println("Age: " + student.getAge());
            System.out.println("GPA: " + student.getGPA());
        }
    }

    public static void serialize(List<Student> students, String fileName) {
        try {
            if (fileName.endsWith(".json")) {
                objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                objectMapper.writeValue(new File(fileName), students);
            } else if (fileName.endsWith(".bin")) {
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
                    oos.writeObject(students);
                }
            } else if (fileName.endsWith(".xml")) {
                xmlMapper.writeValue(new File(fileName), students);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> deserialize(String fileName) {
        List<Student> students = new ArrayList<>();

        File file = new File(fileName);
        if (file.exists()) {
            try {
                if (fileName.endsWith(".json")) {
                    students = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Student.class));
                } else if (fileName.endsWith(".bin")) {
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                        students = (List<Student>) ois.readObject();
                    }
                } else if (fileName.endsWith(".xml")) {
                    students = xmlMapper.readValue(file, xmlMapper.getTypeFactory().constructCollectionType(List.class, Student.class));
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return students;
    }
}
