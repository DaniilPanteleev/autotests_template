package autotests.template.taskOop.seven;

public class Animal {
    private String food;
    private String location;

    public Animal(String food, String location) {
        this.food = food;
        this.location = location;
    }

    public void makeNoise() {
        System.out.println("животное шумит");
    }

    public void eat() {
        System.out.println("животное ест");
    }

    public void sleep() {
        System.out.println("животное спит");
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public static void main(String[] args) {
        Animal animal = new Cat("молоко", "Дом");
        Animal animal1 = new Dog("мясо", "Дом");
        Animal animal2 = new Horse("Морковь", "Конюшня");
        Animal animal3 = new Animal("овес", "клетка");
        Animal[] animals = new Animal[]{animal, animal1, animal2, animal3};
        Vet vet = new Vet();
        for (int i = 0; i < animals.length; i++){
            vet.treatAnimal(animals[i]);
        }

    }
}
