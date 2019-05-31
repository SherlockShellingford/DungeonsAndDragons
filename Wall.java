public class Wall extends Terrain {
    public Wall(){
        tile='#';
    }
    @Override
    public boolean canStepOn() {
        return false;
    }

}
