package baseball;

public class BaseBallGame {

    private final View view = new BaseBallGameView();

    private final GameComponent component = GameComponent.getInstance();
    public void run(){
        try{
            this.view.gameView();
        }catch(IllegalArgumentException exception){
            exception.printStackTrace();
            this.component.isRun = false;
        }
    }
}
