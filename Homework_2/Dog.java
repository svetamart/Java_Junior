public class Dog extends Animal implements MakingSounds{

    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }

    public void gnaw() {
        System.out.println("Dog is gnawing shoes and furniture!");
    }

    public void play() {
        System.out.println("Dog is playing with the ball.");
    }

    @Override
    public void displayInfo() {
        System.out.println("Dog Info:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Breed: " + breed);
        System.out.println();
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
