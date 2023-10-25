package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    private static final String RESTART_COMMAND = "1";
    private static final String QUIT_COMMAND = "2";
    private static final int STRIKE_NUM = 3;
    private static final int SIZE = 3;
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String ANSWER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final Computer computer;
    private final Player player;
    private int strike;
    private int ball;
    private boolean EXIT = false;

    public Game() {
        computer = new Computer();
        player = new Player();
    }

    public void run() {
        System.out.println(START_MESSAGE);
        computer.createComputerNum();
        System.out.println(computer.getComputerNum());
        while (!EXIT) {
            resetResult();
            player.createUserNum();
            checkPlayerNumber();

            printResult();
            isAnswer();
        }
    }

    public void isAnswer() {
        if (strike == STRIKE_NUM) {
            System.out.println(ANSWER_MESSAGE);
            checkRestart();
        }
    }

    public void checkRestart() {
        System.out.println(RESTART_MESSAGE);
        String input = Console.readLine();
        if (!input.equals(RESTART_COMMAND) && !input.equals(QUIT_COMMAND)) {
            throw new IllegalArgumentException("1이나 2만 입력할 수 있습니다.");
        }
        if (input.equals(RESTART_COMMAND)) {
            computer.createComputerNum();
        }
        if (input.equals(QUIT_COMMAND)) {
            EXIT = true;
        }
    }

    public void resetResult() {
        ball = 0;
        strike = 0;
    }

    public void checkPlayerNumber() {
        for (int i = 0; i < SIZE; i++) {
            if (checkIfStrike(i)) {
                strike++;
            }
            if (checkIfBall(i)) {
                ball++;
            }
        }
    }

    private boolean checkIfStrike(int numIdx) {
        return computer.getComputerNum().get(numIdx).equals(player.getUserNum().get(numIdx));
    }

    private boolean checkIfBall(int numIdx) {
        return !checkIfStrike(numIdx) && computer.getComputerNum().contains(player.getUserNum().get(numIdx));
    }

    private boolean checkNothing() {
        return ball == 0 && strike == 0;
    }

    public void printResult() {
        StringBuilder sb = new StringBuilder();
        if (ball != 0) {
            sb.append(ball).append("볼 ");
        }
        if (strike != 0) {
            sb.append(strike).append("스트라이크");
        }
        if (checkNothing()) {
            sb.append("낫싱");
        }
        System.out.println(sb);
    }
}
