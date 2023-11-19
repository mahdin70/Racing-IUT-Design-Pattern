package RaceComponents;

public class Player {
    public String name;
    private static final Player player= new Player();
    private Player(){}
    public static Player getInstance(){
        return player;
    }
}
