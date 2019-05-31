public class UIDataContext {
    private char[][] board;
    private String completeOutput;
    private String currentCharacter;
    public UIDataContext(){
        completeOutput="";
    }
    public void AddCharacter(GameUnit un){
        completeOutput+=un.toString()+"\n";
    }
    public void update(String add){
        completeOutput+=add+"\n";
    }
    public void update(char[][] board){
        this.board=board;
    }
    public void updateCurrentCharacter(GameUnit un){
        currentCharacter=un.toString();
    }
    public char[][] getBoard() {
        return board;
    }
    public String getCurrentCharacter(){
        return currentCharacter;
    }
    public String getUI() {
        String temp=completeOutput;
        completeOutput="";
        return temp ;
    }

}
