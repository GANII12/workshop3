import java.util.Scanner;

public class Main {
//    UserInterface userInterface = new UserInterface();
//    UserInterface userInterface = UserInterface.getInstance();
//    BirdRepository birdRepository = new BirdRepository();
//    BirdRepository birdRepository = BirdRepository.getInstance();
    static final int EXIT_VALUE = 8;
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Main main = new Main();
        UserInterface userInterface =UserInterface.getInstance();
        int option = 0;
        while (option != EXIT_VALUE){
            option = userInterface.showMainMenu();
            main.handleUserSelection(option);
        }
    }

    private void handleUserSelection(int option) {
        BirdRepository birdRepository = BirdRepository.getInstance();
        UserInterface userInterface = UserInterface.getInstance();
        switch (option){
            case 1:
                addBird();
                break;
            case 2:
                System.out.println("Enter the bird u want to delete");
                String birdName = sc.next();
                Bird bird = birdRepository.getBird(birdName);
                birdRepository.remove(bird);
                break;
            case 3:
                System.out.println("Enter the bird u want to update :");
                String birdNames = sc.next();
                Bird bird1 = birdRepository.getBird(birdNames);
                updateBird(bird1);
                break;
            case 4:
                userInterface.printAllBirds(birdRepository.getBirdList());
                break;
            case 5:
                userInterface.printSwimmableBirds(birdRepository.getBirdList());
                break;
            case 6:
                userInterface.printFlyableBirds(birdRepository.getBirdList());
                break;
            case 7:
                userInterface.printEatingBehaviour(birdRepository.getBirdList());
                break;
            case EXIT_VALUE:
                System.out.println("Exit");
                break;
            default:
                System.out.println("Invalid Option");
        }
    }

    private void updateBird(Bird bird) {
        System.out.println("Enter your selection \n 1.Name \n 2.Colour \n 3.Gender \n 4.isSwimmable \n" +
                "5.isFlyable");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                System.out.println("Enter the  New Name :");
                bird.name = sc.next();
                break;
            case 2:
                setBirdColour(bird);
                break;
            case 3:
                setBirdGender(bird);
                break;
            case 4:
                System.out.println("Bird is Swimmable");
                bird.isSwimmable = sc.nextBoolean();
                break;
            case 5:
                System.out.println("Bird is Flyable");
                bird.isFlyable =  sc.nextBoolean();
                break;
            default:
                System.out.println("Invalid Input");
        }
    }

    private void addBird() {
        BirdRepository birdRepository = BirdRepository.getInstance();
        Bird bird = new Bird();
        System.out.println("Enter the bird details :");
        bird.name = sc.next();
        System.out.println("Enter the colour of bird ");
        setBirdColour(bird);
        System.out.println("Enter the gender of bird ");
        setBirdGender(bird);
        System.out.println("Enter is Bird Swimmable");
        bird.isSwimmable = sc.nextBoolean();
        System.out.println("Enter is bird Flyable");
        bird.isFlyable = sc.nextBoolean();
        birdRepository.add(bird);
    }

    private void setBirdGender(Bird bird) {
        System.out.println("Enter the choice \n 1.MALE \n 2.FEMALE \n 3.OTHER");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                bird.gender = Bird.Gender.MALE;
                break;
            case 2:
                bird.gender = Bird.Gender.FEMALE;
                break;
            case 3:
                bird.gender = Bird.Gender.OTHER;
                break;
            default:
                System.out.println("Invalid Option");
        }
    }

    private void setBirdColour(Bird bird) {
        System.out.println("Enter the choice \n 1.GREEN \n 2.RED \n 3.BLACK \n 4.BLUE" +
                " \n 5.PURPLE \n 6.WHITE \n 7.PINK");
        int option = sc.nextInt();
        switch (option){
            case 1:
                bird.colour = Bird.Colour.GREEN;
                break;
            case 2:
                bird.colour = Bird.Colour.RED;
                break;
            case 3:
                bird.colour = Bird.Colour.BLACK;
                break;
            case 4:
                bird.colour = Bird.Colour.BLUE;
                break;
            case 5:
                bird.colour = Bird.Colour.PURPLE;
                break;
            case 6:
                bird.colour = Bird.Colour.WHITE;
                break;
            case 7:
                bird.colour = Bird.Colour.PINK;
                break;
            default:
                System.out.println("Invalid Option");
        }
    }
}
