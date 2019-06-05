import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class UI {
private UIDataContext DT;
private int currentLevel;
private String[] levels={"Level1","Level2","Level3","Level4"};
public UI(){
    DT=new UIDataContext();
    currentLevel=0;

}
private void printEntireUI(){
    System.out.println(DT.getUI());
    char[][] print=DT.getBoard();
    for(int i=0;i<print.length;++i){
        System.out.println();
        for(int j=0;j<print[i].length;++j){
            System.out.print(print[i][j]);
        }
    }
    System.out.println(DT.getCurrentCharacter());
}
public void startGame(String mode){
    Scanner sc=new Scanner(System.in);
    PlayerOptions playerOptions=new PlayerOptions(DT);
    List<Player> playerList=playerOptions.getPlayerList();
    for(int i=0;i<playerList.size();++i){
        System.out.println(""+(i+1)+"   "+playerList.get(i).name+"      Health: "+playerList.get(i).health+"     Attack: "+playerList.get(i).attack+"      Defense: "+playerList.get(i).defense+"\n");
    }
    System.out.println(DT.getUI());
    if (mode.equals("D")){
        File file  = new File(MemoryManager.getPath() + "/user_actions.txt");
        try {
            Scanner scan = new Scanner(file);
            Player player=playerList.get(scan.nextInt()-1);
            GameManager.setGame(player,DT, levels[currentLevel]);
            printEntireUI();
            while(scan.hasNextLine()){
                Dcycle(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("no such file");;
        }
        return;
    }
    System.out.println("Select player: ");
    int playernum=sc.nextInt();
    while(playerList.size()<playernum){
        System.out.println("This is not a valid input");
        System.out.println("Select player: ");
        playernum=sc.nextInt();
    }
    Player player=playerList.get(playernum-1);
    System.out.println("Use w/s/a/d to move.");
    System.out.println("Use e for special ability or q to pass.");
    GameManager.setGame(player,DT, levels[currentLevel]);
    printEntireUI();
}


public void cycle(){

    Scanner sc=new Scanner(System.in);
    String input=sc.nextLine();
    int end=GameManager.GameTick(input);
    printEntireUI();
    if(end==1){
        System.out.println("You lost!");
        System.exit(0);
    }
    if(end==2){
        currentLevel=currentLevel+1;
        GameManager.setGame(GameManager.getPlayer().get(0),DT,levels[currentLevel]);
    }
    if(end==3){
        System.out.println("Invalid command");
    }

}

public void Dcycle(String command){
    int end=GameManager.GameTick(command);
    printEntireUI();
    if(end==1){
        System.out.println("You lost!");
        System.exit(0);
    }
    if(end==2){
        currentLevel=currentLevel+1;
        GameManager.setGame(GameManager.getPlayer().get(0),DT,levels[currentLevel]);
    }
    if(end==3){
        System.out.println("Invalid command");
    }

}
public static class GameManager{
    private static Game g;
    public static List<Player> getPlayer(){
        return g.players;
    }
    public static void setGame(Player p, UIDataContext DT, String level){
        List<Player> PlayerList=new LinkedList<Player>();
        PlayerList.add(p);
        g=new Game(PlayerList, DT);
        g.load(level);
    }
    public static int GameTick(String command){
        g.gameTick();
        if(!command.equals("q")&&!command.equals("e")&&!command.equals("w")&&!command.equals("q")&&!command.equals("a")&&!command.equals("s")&&!command.equals("d")){
            return 3;
        }
        if(!command.equals("q")){
            if(command.equals("e")){
                g.specialAbillity();
            }
            else {
                g.playerTurn(command);
            }
        }
        g.enemyTurn();
        g.loadCurrentBoard();;
        g.updatePlayer();
        int ret=0;
        if(g.areAllPlayersDead()){
            ret=1;
        }
        if(g.areAllEnemiesDead()){
            ret=2;
        }
        return ret;

    }
}





}
