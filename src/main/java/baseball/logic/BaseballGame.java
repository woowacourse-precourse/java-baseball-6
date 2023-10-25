package baseball.logic;

import baseball.domain.Player;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private List<Integer> computerNumbers;
    private int strikeCount;
    private int ballCount;
    private Player player;
    public static String RESTART = "1";
    public static String EXIT = "2";

    public BaseballGame() {
        this.computerNumbers = new ArrayList<>();
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public String play() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        ExtractComputerRandomNumber();

        player = new Player();
        String playerAnswer;
        while (true) {
            player.guess();
            giveScore(player.getGuessNumbers());
            printScores();
            if (isThreeStrike()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                playerAnswer = player.replayOrExit();
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

    private List<Integer> ExtractComputerRandomNumber() {
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
//        System.out.println("컴퓨터 숫자: "+ computerNumbers);
        return computerNumbers;
    }

    private void giveScore(List<Integer> guessNumbers) {
        resetCount();
        for (int i = 0; i < 3; i++) {
            // 스트라이크 검사
            int guessNumber = guessNumbers.get(i);
            if (guessNumber == computerNumbers.get(i)) {
                strikeCount++;
            }
            // 볼 검사
            if (guessNumber == computerNumbers.get((i + 1) % 3)) {
                ballCount++;
            }
            if (guessNumber == computerNumbers.get((i + 2) % 3)) {
                ballCount++;
            }
        }
    }

    private void resetCount() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }
    private void printScores() {
        if (ballCount == 0 && strikeCount == 0){
            System.out.println("낫싱");
            return;
        } else if(ballCount != 0 && strikeCount != 0){
            System.out.println(ballCount + "볼" + " " + strikeCount + "스트라이크");
            return;
        } else if (ballCount != 0) {
            System.out.println(ballCount + "볼");
        } else if (strikeCount != 0) {
            System.out.println(strikeCount + "스트라이크");
        }
    }
    private boolean isThreeStrike() {
        if (strikeCount == 3) {
            return true;
        }else {
            return false;
        }
    }
}
