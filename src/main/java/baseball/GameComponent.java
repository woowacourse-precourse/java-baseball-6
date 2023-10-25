package baseball;



public class GameComponent {
    private static final GameComponent component = new GameComponent();

    public boolean isRun;
    private GameComponent(){
        isRun = Boolean.TRUE;
    }

    public static GameComponent getInstance(){
        return component;
    }
    public String console(){
        return "";
    }


}
