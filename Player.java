public abstract class Player extends GameUnit {
    protected int XP;
    protected int level;

    public void move(String command){
        switch (command){
            case "w":
                position.setKey(position.getKey() - 1);
                break;
            case "s":
                position.setKey(position.getKey() + 1);
                break;
            case "a":
                position.setValue(position.getValue() - 1);
                break;
            case "d":
                position.setValue(position.getValue() + 1);
                break;
        }
    }

    abstract void levelUp();

    abstract void ability(List<Enemy> enemyList);
}
