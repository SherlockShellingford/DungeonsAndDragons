public class Empty extends Terrain {

    public Empty(){
        tile='.';
    }
    @Override
    public boolean canStepOn() {
        return true;
    }
}
