package baseball;

import camp.nextstep.edu.missionutils.Console;

/**
 * 게임의 로직을 제어하고 상태를 관리
 */
public class GameController {
    private static final int NUM_LENGTH = 3;
    private final RandomNumbers computer;
    private int strikeCnt = 0;
    private int ballCnt = 0;

    public GameController() {
        computer = new RandomNumbers();
    }

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
        // 임시 출력용
        System.out.println(computer.getAllNumbers());
        while (strikeCnt != 3) {
            resetCnt();
            String player = getPlayerInput();
            calculateResult(player);
            printResult(strikeCnt, ballCnt);
        }
    }

    public String getPlayerInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        if (input.length() != NUM_LENGTH) {
            throw new IllegalArgumentException("입력 값 오류");      /* 입력 값의 길이가 3이 아닌경우*/
        }
        return input;
    }

    public void calculateResult(String input) {
        String[] player = input.split("");

        for (int i = 0; i < NUM_LENGTH; i++) {
            if (computer.getNumber(i) == Integer.parseInt(player[i])) {
                addStrike();        /* 같은 위치에 같은 숫자인 경우 */
            } else if (computer.contains(Integer.parseInt(player[i]))) {
                addBall();          /* 다른 위치에 같은 숫자인 경우 */
            }
        }
    }

    public void printResult(int strikeCnt, int ballCnt) {
        if (strikeCnt == 0 && ballCnt == 0) {
            System.out.println("낫싱");
        } else if (strikeCnt == 0) {
            System.out.println(ballCnt + "볼 ");
        } else if (ballCnt == 0) {
            System.out.println(strikeCnt + "스트라이크");
        } else if (ballCnt > 0 && strikeCnt > 0) {
            System.out.println(ballCnt + "볼 " + strikeCnt + "스트라이크");
        }
    }
}
