package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseballGame {
    Computer computer = new Computer();
    User user = new User();

    //게임 시작
    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean continueGame = true;
        while (continueGame) {
            playOneRound();
            continueGame = askForReplay();
        }

        System.out.println("게임을 완전히 종료합니다.");
    }

    //게임 진행하기
    private void playOneRound() {
        boolean isUserWin = false;
        computer.setComputerNumber();
        while (!isUserWin) {
            user.setUserNumbers();
            int strikes = countStrikes(computer.getAnswerNumbers(), user.getUserNumbers());
            int balls = countBalls(computer.getAnswerNumbers(), user.getUserNumbers());
            isUserWin = printAndCheckResult(strikes, balls);
        }
    }

    //스트라이크 계산
    private int countStrikes(List<Integer> answerNumbers, List<Integer> userNumbers) {
        int strikes = 0;
        for (int i = 0; i < 3; i++) {
            if (answerNumbers.get(i).equals(userNumbers.get(i))) {
                strikes++;
            }
        }
        return strikes;
    }

    //볼 계산
    private int countBalls(List<Integer> answerNumbers, List<Integer> userNumbers) {
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            if (answerNumbers.contains(userNumbers.get(i)) && !answerNumbers.get(i).equals(userNumbers.get(i))) {
                balls++;
            }
        }
        return balls;
    }

    //정답 확인
    private boolean printAndCheckResult(int strikes, int balls) {
        if (strikes == 3) {
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else if (strikes > 0 || balls > 0) {
            System.out.println(balls + "볼 " + strikes + "스트라이크");
        } else {
            System.out.println("낫싱");
        }
        return false;
    }

    //재시작 확가
    private boolean askForReplay() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int replayInput = Console.readLine().charAt(0) - '0';
        return (replayInput == 1);
    }
}
