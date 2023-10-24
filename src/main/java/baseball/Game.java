package baseball;

import java.util.List;

public class Game {

    private List<Integer> computer;
    private List<Integer> player;

    public boolean playBaseball() {
        startGame();
        if(!onGame()){
            return false;
        }
        if(!quitGame()) {
            return false;
        }
        return true;
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer = RandomUtil.createRandomNumbers();
    }

    public boolean onGame() {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            try {
                player = InputDevice.readPlayerNumbers();
            } catch (IllegalArgumentException e) {
                return false;
            }
            if (Score.calculateScore(computer, player) == 3) {
                break;
            }
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        return true;
    }

    public boolean quitGame() {
        int answer = 0;
        System.out.println("게임을 새로 시작혀려면 1, 종료하려면 2를 입력하세요.");
        try {
            answer = InputDevice.readNumber();
        } catch (IllegalArgumentException e) {
            return false;
        }
        if (answer == 1) {
            return true;
        }
        return false;
    }
}
