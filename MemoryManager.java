import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MemoryManager {
    private static String path;
    public static void setPath(String path2){
        path=path2;
    }
    public static String getPath(){
        return path;
    }
    public static char[][] getBoard(String level){
        char[][] board;
        if(path.charAt(path.indexOf(path.length()-1))!='\\'||path.charAt(path.indexOf(path.length()-1))=='/'){
            path=path+"/";
        }
        File file = new File(path + level + ".txt");
        Scanner sc;
        try {
             sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            return  null;
        }
        int w = 0;  //width
        int h = 0;  //height
        if (sc.hasNextLine()){
            w = sc.nextLine().length();
            h++;
        }
        else{
            return null;
        }
        while (sc.hasNextLine()){
            sc.nextLine();
            h++;
        }
        board = new char[h][w];
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            return  null;
        }
        for (int i = 0; i < h; i++) {
            String s = "";
            if (sc.hasNextLine()) {
                s = sc.nextLine();
            }
            for (int j = 0; j < w; j++) {
                board[i][j] = s.charAt(j);
            }
        }
        return board;
    }
}
