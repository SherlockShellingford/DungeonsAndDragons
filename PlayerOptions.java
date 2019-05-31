import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;

public class PlayerOptions {
    private List<Player> playerList;
    public PlayerOptions(UIDataContext DT){
        playerList=new LinkedList<>();
        playerList.add(new Warrior("Hanamaru Kunikuda",DT,400,15, 15 ,3,null));
        playerList.add(new Mage("Nico Yazawa", DT, 150,10, 5, null, 18, 300,20,5,4));
        playerList.add(new Rogue("Rin Hoshizora", DT, 150,40,5,null,10));
    }

    public List<Player> getPlayerList() {
        return playerList;
    }
}
