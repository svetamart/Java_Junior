public class Fish extends Animal{

    String color;
    public Fish(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    public void swim() {
        System.out.println("Fish is swimming.");
    }

    @Override
    public void displayInfo() {
        System.out.println("Fish Info:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Color: " + color);
        System.out.println();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
