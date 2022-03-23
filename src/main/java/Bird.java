public class Bird {
    enum Colour{
        GREEN, RED, BLACK, BLUE, PURPLE, WHITE, PINK
    }

    enum Gender{
        MALE, FEMALE, OTHER
    }

    String name;
    Colour colour;
    Gender gender;
    boolean isSwimmable;
    boolean isFlyable;

    @Override
    public String toString() {
        return "Bird{" +
                "name='" + name + '\'' +
                ", colour=" + colour +
                ", gender=" + gender +
                ", isSwimmable=" + isSwimmable +
                ", isFlyable=" + isFlyable +
                '}';
    }

    void eat(){
        System.out.println(name + " " + "can eat");
    }
}
