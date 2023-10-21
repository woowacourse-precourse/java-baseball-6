package baseball;

import java.util.List;

public class Game {
    private final GameNumberMaker gameNumberMaker;

    public Game() {
        this.gameNumberMaker = new GameNumberMaker();
    }

    public void startGame() {

        // 게임 번호 생성
        List<Integer> gameNumber = gameNumberMaker.makeGameNumber();

        // while
        // 정답 입력 객체
        // 채점 객체
        // 힌트 생성 객체
        // 3 스트라이크 시 게임 종료
    }
}
