import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class DeterministicNumber{
    int[] arr;
    int index;
    public DeterministicNumber(int[] arr){
        this.arr=arr;
        index=0;
    }

    public DeterministicNumber(String path){
        File file = new File(path);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
        }
        for (int i = 0; sc.hasNextLine(); i++) {
            arr[i] = Integer.parseInt(sc.nextLine());
        }
    }

    public int next(){
        int tmp=index;
        index=index+1;
        return arr[tmp];
    }

    public int nextInt(int x){
        int tmp=index;
        index=index+1;
        return arr[tmp];
    }
}
