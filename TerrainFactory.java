public class TerrainFactory {
    public static Terrain create(char terrain){
        if(terrain=='.'){
            return new Empty();
        }
        if(terrain=='#'){
            return new Wall();
        }
        return null;
    }

}
