package baseball.controller;

import java.util.List;

/* 게임을 컨트롤하는 객체 */
public class GameController {
    private static List<Integer> programNumbers; // 컴퓨터가 생성한 숫자
    private static boolean gameState; // 게임 상태

    public void run() {
        // TODO : 게임을 컨트롤하는 메소드 구현
        while(gameState){
            initGame();
            playGame();
        }
        endGame();
    }

    /* 게임을 초기화하는 메소드 */
    public void initGame() {
        // TODO : 게임을 초기화하는 메소드 구현
    }

    /* 게임을 진행하는 메소드 */
    public void playGame() {
        // TODO : 게임을 진행하는 메소드 구현
    }

    /* 게임을 종료하는 메소드 */
    public boolean endGame() {
        // TODO : 게임을 종료하는 메소드 구현
        return true;
    }
}
