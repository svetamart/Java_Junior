public class Cat extends Animal implements MakingSounds{

    private boolean isLazy;

    public Cat(String name, int age, boolean isLazy) {
        super(name, age);
        this.isLazy = isLazy;
    }

    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }

    public void sleep() {
        System.out.println("Cat is sleeping.");
    }

    public void purr() {
        System.out.println("Cat is purring.");
    }

    @Override
    public void displayInfo() {
        System.out.println("Cat Info:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Is Lazy: " + isLazy);
        System.out.println();
    }

    public boolean isLazy() {
        return isLazy;
    }

    public void setLazy(boolean lazy) {
        isLazy = lazy;
    }
}
