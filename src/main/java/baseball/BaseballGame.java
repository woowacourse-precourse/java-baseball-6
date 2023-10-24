package baseball;

import baseball.target.Computer;
import baseball.target.Moderator;
import baseball.target.User;

import java.util.List;

/*
 * 실제 게임을 진행하는 클래스
 */
public class BaseballGame {
    private final User user = new User();
    private final Computer computer = new Computer();
    private final Moderator moderator = new Moderator();

    private Integer strike;
    private Integer ball;
    private List<Integer> computerNums;

    public BaseballGame() {
        moderator.printStartMsg();
    }

    public void gameStart() {
        int restartNum = 1;
        computerNums = computer.getNumber();

        while(restartNum == 1){
            moderator.printInputMsg();
            String userInput = user.getInputNumber();
            List<Integer> userNums = moderator.getList(userInput);
            moderator.validateUserNum(userNums);
            compareNumber(computerNums,userNums);
            System.out.println(gameResult());
            restartNum = endGame(restartNum);
        }
    }

    public void compareNumber(List<Integer> computerNums, List<Integer> userNums) {
        this.strike = 0;
        this.ball = 0;
        for (int i = 0; i < 3; i++) {
            int computerNum = computerNums.get(i);
            int userNum = userNums.get(i);

            if (computerNum == userNum) {
                strike++;
                continue;
            }
            if (computerNums.contains(userNum)) {
                ball++;
            }
        }
    }

    public String gameResult() {
        if (ball != 0 && strike != 0) {
            return (ball + "볼" + " " + strike + "스트라이크");
        }
        if (ball == 0 && strike != 0) {
            return (strike + "스트라이크");
        }
        if (ball != 0 && strike == 0) {
            return (ball + "볼");
        }
        return ("낫싱");
    }

    public int endGame(int restartInput) {
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하시려면 1, 종료하려면 2를 입력하세요.");
            restartInput = Integer.parseInt(user.getInputNumber());

            if (restartInput == 1) {
                computerNums = computer.getNumber();
                return restartInput;
            }
            else if (restartInput == 2) {
                return restartInput;
            }
            else
                throw new IllegalArgumentException("1 또는 2만 입력할 수 있습니다.");
        }
        return restartInput;
    }

}
