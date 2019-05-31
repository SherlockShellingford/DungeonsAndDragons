public class RandomDCode implements GameRandom {
    DeterministicNumber num;
    public RandomDCode(int[] arr){
        num=new DeterministicNumber(arr);
    }
    public int nextInt(int n){
        return num.next();
    }
}
