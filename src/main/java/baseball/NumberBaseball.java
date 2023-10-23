package baseball;

public class NumberBaseball {
    public void play(){
        new PlayerPartner().startGame();

        if(isContinue()){
            new PlayerPartner().startGame();
        }
    }

    // 구현 필요
    private boolean isContinue() {
        return false;
    }
}