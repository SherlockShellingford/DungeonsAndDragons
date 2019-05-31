import java.util.List;

public class DeterministicNumber {
    int[] arr;
    int index;
    public DeterministicNumber(int[] arr){
        this.arr=arr;
        index=0;
    }
    public int next(){
        int tmp=index;
        index=index+1;
        return arr[tmp];
    }


}
