import java.util.ArrayList;
import java.util.List;

public class BirdRepository {
    private List<Bird> birdList = new ArrayList<>();
    static BirdRepository instance;

    private BirdRepository() {
    }

    public static synchronized BirdRepository getInstance(){
        if (instance == null)
            instance = new BirdRepository();
        return instance;
    }

    public List<Bird> getBirdList(){
        List<Bird>birdList = this.birdList;
        return birdList;
    }

    public void add(Bird bird){
        birdList.add(bird);
    }

    public Bird getBird(String birdName){
//        for (int i =0; i< birdList.size(); i++){
//            if (birdName.equals(birdList.get(i).name))
//                return birdList.get(i);
//        }
//        return null;
       return birdList.stream().filter(bird -> bird.name.equals(birdName)).findFirst().orElse(null);
    }

    public void remove(Bird bird){
        birdList.remove(bird);
    }
}
