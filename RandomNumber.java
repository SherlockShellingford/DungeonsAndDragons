public class RandomNumber {
    private static GameRandom ourInstance;

    public static GameRandom getInstance() {
        return ourInstance;
    }
    public static void setRandom(char c){
        if(c=='d'){
            //ourInstance=new RandomD();
        }
        if(c=='n'){
            ourInstance=new RandomND();
        }
    }
    private RandomNumber() {
    }
}
