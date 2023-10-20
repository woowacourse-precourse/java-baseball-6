package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameController {
    private int strikeCnt = 0;
    private int ballCnt = 0;

    public GameController() {
    }

    // 초기화
    public void resetCnt() {
        strikeCnt = 0;
        ballCnt = 0;
    }

    public void startGame() {

        //랜덤 값 생성
        RandomNumbers computer = new RandomNumbers();
        computer.setRandomNumbers();

        while (true) {
            resetCnt();

            // 사용자 값 입력
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            if (input.length() != 3) {
                throw new IllegalArgumentException("입력 값 오류");
            }

            String[] inputArr = input.split("");
            for (int i = 0; i < 3; i++) {
                if (computer.getNumber(i) == Integer.parseInt(inputArr[i])) {
                    strikeCnt++;
                } else if (computer.contains(Integer.parseInt(inputArr[i]))) {
                    ballCnt++;
                }
            }
            // 출력
            if (strikeCnt + ballCnt == 0) {
                System.out.println("낫싱");
            } else if (strikeCnt == 0) {
                System.out.println(ballCnt + "볼 ");
            } else if (ballCnt == 0) {
                System.out.println(strikeCnt + "스트라이크");
            } else {
                System.out.println(ballCnt + "볼 " + strikeCnt + "스트라이크");
            }

            if (strikeCnt == 3) {
                break;
            }
        }
    }

}
