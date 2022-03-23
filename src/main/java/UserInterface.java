import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private static UserInterface instance;
    private UserInterface() {
    }
    public static synchronized UserInterface getInstance(){
        if (instance == null)
            instance = new UserInterface();
        return instance;
    }

    public int showMainMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose an option : \n 1. Add Bird \n 2. Remove Bird \n" +
                " 3. Update the Bird  \n 4. Print all Birds \n 5. Print Swimmable Birds \n " +
                "6. Print Flyable Birds  \n 7. print eating birds \n " + Main.EXIT_VALUE + ". exit  ");
        return sc.nextInt();
    }

    public void printAllBirds(List<Bird> list) {
        list.stream().forEach(bird -> System.out.println(bird));
    }

    public void printSwimmableBirds(List<Bird> list) {
        list.stream().filter(bird -> bird.isSwimmable).forEach(System.out::println);
    }

    public void printFlyableBirds(List<Bird> list) {
        list.stream().filter(bird -> bird.isFlyable).forEach(System.out::println);
    }

    public void printEatingBehaviour(List<Bird> list){
        list.stream().forEach(bird -> bird.eat());
    }
}
