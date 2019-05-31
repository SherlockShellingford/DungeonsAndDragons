import javafx.util.Pair;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Game {
    List<Enemy> enemies;
    List<Player> players;
    Terrain[][] board;
    UIDataContext DT;
    public Game(List<Player> players, UIDataContext DT){
        this.enemies=new LinkedList<Enemy>();
        this.players=players;
        this.DT=DT;
    }
    public boolean areAllPlayersDead(){
        return !(players.get(0).currentHealth >0);
    }

    public void enemyTurn(){
        Iterator<Enemy> enemyIterator=enemies.iterator();
        while(enemyIterator.hasNext()) {
            Enemy enemy = enemyIterator.next();



            boolean OkPosition = true;
            do {
                if (players.isEmpty()) {
                    break;
                }
                if(!OkPosition){
                    enemy.returnToFormerLocation();
                }
                enemy.move(players.get(0));
                OkPosition=true;
                Pair<Integer, Integer> cord = enemy.getPosition();
                Iterator<Enemy> EnemyStepOnIt = enemies.iterator();
                while (EnemyStepOnIt.hasNext()) {
                    Enemy StepOn = EnemyStepOnIt.next();
                    if (enemy.getPosition().equals(StepOn.getPosition()) && StepOn != enemy) {
                        OkPosition = false;
                    }
                }
                if (!players.isEmpty() && enemy.getPosition().equals(players.get(0).getPosition())) {
                    boolean dead = players.get(0).combat(enemy);
                    OkPosition = false;
                    if (dead) {
                        players.remove(players.get(0));
                    }
                }

                if (((cord.getKey() >= board.length||cord.getKey()<0) || cord.getValue() >= board[cord.getKey()].length) || (cord.getValue()<0) || (!board[cord.getKey()][cord.getValue()].canStepOn())) {
                    OkPosition = false;
                }
            } while (!OkPosition);
        }

    }

    public void playerTurn(String command){
        players.get(0).move(command);
        Iterator<Enemy> EnemyStepOnIt=enemies.iterator();
        while(EnemyStepOnIt.hasNext()) {
            Enemy StepOn=EnemyStepOnIt.next();
            while(players.get(0).getPosition().equals(StepOn.getPosition())){
                boolean dead=StepOn.combat(players.get(0));
                players.get(0).returnToFormerLocation();
                if(dead){
                     EnemyStepOnIt.remove();
                     players.get(0).gainExperience(StepOn);
                     while(players.get(0).getXP()>=players.get(0).getLevel()*50){
                         players.get(0).levelUp();
                     }
                }
            }
        }
        if(!board[players.get(0).getPosition().getKey()][players.get(0).getPosition().getValue()].canStepOn()){
            players.get(0).returnToFormerLocation();
        }
    }
    public char[][] createGameBoard() {
        Iterator<Enemy> EnemyIt = enemies.iterator();
        char[][] ret= new char[board.length][];
        for(int i=0;i<board.length;++i){
            ret[i]=new char[board[i].length];
            for(int j=0;j<ret[i].length;++j){
                ret[i][j]=board[i][j].tile;
            }
        }
        while (EnemyIt.hasNext()) {
            Enemy enemy=EnemyIt.next();
            ret[enemy.getPosition().getKey()][enemy.getPosition().getValue()]=enemy.tile;
        }
        return ret;
    }
    public void load(String level){
        char[][] Charboard=MemoryManager.getBoard(level);
        board=new Terrain[Charboard.length][];
        for(int i=0;i<Charboard.length;++i){
            board[i]=new Terrain[Charboard[i].length];
            for(int j=0;j<Charboard[i].length;++j){
                    if(Charboard[i][j]=='@'){
                        players.get(0).setPosition(new Pair<>(i,j));
                    }
                    Terrain t=TerrainFactory.create(Charboard[i][j]);
                    if(t==null){
                        board[i][j]=new Empty();
                        Enemy e=EnemyFactory.create(Charboard[i][j],DT, new Pair<Integer, Integer>(i,j));
                        if(e!=null){
                            enemies.add(e);
                        }

                    }
                    else{
                        board[i][j]=t;
                    }
            }
        }
        DT.update(Charboard);
        DT.updateCurrentCharacter(players.get(0));

    }
    public void specialAbillity(){
        players.get(0).ability(enemies);
        Iterator<Enemy> EnemyIt = enemies.iterator();
        while(EnemyIt.hasNext()){
            Enemy enemy=EnemyIt.next();
            if(enemy.getCurrentHealth()<=0){
                EnemyIt.remove();
                players.get(0).gainExperience(enemy);
                while(players.get(0).getXP()>=players.get(0).getLevel()*50){
                    players.get(0).levelUp();
                }
            }
        }
    }
    public void gameTick(){
        players.get(0).onGameTick();
    }
    public void loadCurrentBoard(){
        char[][] ret=new char[board.length][board[0].length];
        for(int i=0;i<board.length;++i){
            for(int j=0;j<board[0].length;++j){
                ret[i][j]=board[i][j].tile;
            }
        }
        Iterator<Enemy> EnemyIt=enemies.iterator();
        while (EnemyIt.hasNext()) {
            Enemy enemy=EnemyIt.next();
            ret[enemy.getPosition().getKey()][enemy.getPosition().getValue()]=enemy.tile;
        }
        if(!players.isEmpty()){
            ret[players.get(0).getPosition().getKey()][players.get(0).getPosition().getValue()]='@';
        }

        DT.update(ret);
    }
    public void updatePlayer(){
        if(!players.isEmpty()) {
            DT.updateCurrentCharacter(players.get(0));
        }
    }
    public boolean areAllEnemiesDead(){
        return enemies.isEmpty();
    }



}
