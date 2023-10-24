package baseball.game;

public interface Game {

    //게임 시작함수
    void runGame() ;

    //게임기에 출력을 넘기는 함수
    void forwardText(String text);

    //게임기에서 input을 받는 함수
    String askForInput();

}
