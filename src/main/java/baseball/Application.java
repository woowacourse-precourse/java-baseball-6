package baseball;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PlayGame playGame=new PlayGame();
        System.out.println("숫자 야구 게임을 시작합니다.");
        playGame.startGame();
        while(true){
            if(PlayGame.reStart()){
                playGame.startGame();
            }
            else{
                break;
            }
        }
    }
}
