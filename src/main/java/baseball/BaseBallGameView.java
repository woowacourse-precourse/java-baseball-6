package baseball;

public class BaseBallGameView implements View{

    private final GameComponent component = GameComponent.getInstance();


    public void gameView(){
        this.startGameView();
        while(this.component.isRun){
            this.displayGameStateView();
        }
        this.endGameView();
    }
    private void startGameView(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void displayGameStateView(){
        System.out.printf("숫자를 입력해주세요 : %s\n", this.component.console());
        System.out.printf("");
    }

    private void endGameView(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }


}
