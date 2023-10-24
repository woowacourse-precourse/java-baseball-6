package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private int checkFinishNum = 1;

    private static final int BALL_MIN_NUM = 1;

    private static final int BALL_MAX_NUM = 9;

    private static final int RESTART_NUM = 1;

    private static final int FINISH_NUM = 2;

    private static final int THREE_NUM = 3;

    private boolean restart = true;

    private List<Integer> computer = new ArrayList<>();

    public void play() {

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (checkFinishNum == RESTART_NUM) {

            makeComputerBall();

            Balls comBalls = new Balls(computer);

            System.out.print("숫자를 입력해주세요 : ");
            String user = Console.readLine();

            List<Integer> userList = getInputUserBallList(user);

            Balls userBalls = new Balls(userList);

            PlayResult playResult = comBalls.play(userBalls);

            int ball = playResult.getBall();
            int strike = playResult.getStrike();

            if (playResult.isNothing()) {
                System.out.println("낫싱");
            } else if (playResult.isBallAndStrike()) {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            } else if (playResult.isStrike()) {
                System.out.println(strike + "스트라이크");
            } else if (playResult.isBall()) {
                System.out.println(ball + "볼");
            }

            restartOrFinish(playResult);
        }
    }

    private void restartOrFinish(PlayResult playResult) {
        if (playResult.getStrike() == THREE_NUM) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다!");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String finishCheck = Console.readLine();

            checkFinishNumData(finishCheck);

            if (finishCheck.equals(String.valueOf(RESTART_NUM))) {
                restart = true;
                computer.clear();
            } else {
                checkFinishNum = FINISH_NUM;
                System.out.println("게임 종료");
            }
        }
    }

    private void checkFinishNumData(String finishCheck) {
        if (!finishCheck.equals("1") && !finishCheck.equals("2")) {
            throw new IllegalArgumentException("1 또는 2를 입력해 주세요.");
        }
    }

    private static List<Integer> getInputUserBallList(String user) {

        char[] chars = user.toCharArray();

        List<Integer> userList = new ArrayList<>();

        for (char c : chars) {
            if (Character.isDigit(c)) {
                userList.add(Character.getNumericValue(c));
            }
        }

        return userList;
    }

    private void makeComputerBall() {
        while (computer.size() < THREE_NUM && restart) {
            int randomNumber = Randoms.pickNumberInRange(BALL_MIN_NUM, BALL_MAX_NUM);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        restart = false;
    }
}
