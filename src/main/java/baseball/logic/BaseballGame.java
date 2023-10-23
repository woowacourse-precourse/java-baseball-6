package baseball.logic;

import baseball.domain.Player;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private List<Integer> computerNumbers;
    private int countStrike;
    private int countBall;
    public static String RESTART = "1";
    public static String EXIT = "2";

    public BaseballGame() {
        this.computerNumbers = new ArrayList<>();
        this.countStrike = 0;
        this.countBall = 0;
    }

    public String play() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        randomlyExtractNumber();

        Player player = new Player();
        while (true) {
            player.guess();
            markNumber(player.getGuessNumbers()); // 채점
            printScores(); // 점수 출력
            if (isThreeStrike()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                String playerAnswer = player.replayOrExit();
                if (playerAnswer.equals(RESTART)) {
                    return RESTART;
                } else if (playerAnswer.equals(EXIT)) {
                    return EXIT;
                } else {
                    // 예외 출력
                }
            }
        }
    }

    private List<Integer> randomlyExtractNumber() {
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
//        System.out.println("컴퓨터 숫자: "+ computerNumbers);
        return computerNumbers;
    }

    private void markNumber(List<Integer> guessNumbers) {
        resetCount();
        for (int i = 0; i < 3; i++) {
            // 스트라이크 검사
            int guessNumber = guessNumbers.get(i);
            if (guessNumber == computerNumbers.get(i)) {
                countStrike++;
            }
            // 볼 검사
            if (guessNumber == computerNumbers.get((i + 1) % 3)) {
                countBall++;
            }
            if (guessNumber == computerNumbers.get((i + 2) % 3)) {
                countBall++;
            }
        }
    }

    private void resetCount() {
        this.countStrike = 0;
        this.countBall = 0;
    }
    private void printScores() {
        if (countBall == 0 && countStrike == 0){
            System.out.println("낫싱");
            return;
        } else if(countBall != 0 && countStrike != 0){
            System.out.println(countBall + "볼" + " " + countStrike + "스트라이크");
            return;
        } else if (countBall != 0) {
            System.out.println(countBall + "볼");
        } else if (countStrike != 0) {
            System.out.println(countStrike + "스트라이크");
        }
    }
    private boolean isThreeStrike() {
        if (countStrike == 3) {
            return true;
        }else {
            return false;
        }
    }
}
