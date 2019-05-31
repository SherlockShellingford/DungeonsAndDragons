import java.util.Random;
public class RandomND implements GameRandom {

    private Random rand;
    public RandomND(){
        rand=new Random();
    }
    public int nextInt(int n){
        return rand.nextInt(n);
    }

}
