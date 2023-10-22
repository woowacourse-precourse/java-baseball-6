package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameController {
    private static final int NUM_LENGTH = 3;
    private int strikeCnt = 0;
    private int ballCnt = 0;
    private RandomNumbers computer;

    public GameController() {
        computer = new RandomNumbers();
    }

    // 초기화
    public void resetCnt() {
        strikeCnt = 0;
        ballCnt = 0;
    }

    public void addStrike() {
        strikeCnt++;
    }

    public void addBall() {
        ballCnt++;
    }

    public void startGame() {

        System.out.println(computer.getAllNumbers());

        while (true) {
            resetCnt();
            String player = getPlayerInput();
            calculateResult(player);
            printResult(strikeCnt, ballCnt);

            if (strikeCnt == 3) {
                break;
            }
        }
    }

    public String getPlayerInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        if (input.length() != NUM_LENGTH) {
            throw new IllegalArgumentException("입력 값 오류");
        }
        return input;
    }

    public void calculateResult(String input) {
        String[] player = input.split("");

        for (int i = 0; i < NUM_LENGTH; i++) {
            if (computer.getNumber(i) == Integer.parseInt(player[i])) {
                addStrike();
            } else if (computer.contains(Integer.parseInt(player[i]))) {
                addBall();
            }
        }
    }

    public void printResult(int strikeCnt, int ballCnt) {
        if (strikeCnt + ballCnt == 0) {
            System.out.println("낫싱");
        } else if (strikeCnt == 0) {
            System.out.println(ballCnt + "볼 ");
        } else if (ballCnt == 0) {
            System.out.println(strikeCnt + "스트라이크");
        } else if (ballCnt > 0 & strikeCnt > 0) {
            System.out.println(ballCnt + "볼 " + strikeCnt + "스트라이크");
        }
    }

}
