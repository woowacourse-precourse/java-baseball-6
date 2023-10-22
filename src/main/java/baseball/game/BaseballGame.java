package baseball.game;

import static baseball.console.Input.chooseRestart;
import static baseball.console.Input.getNumbers;
import static baseball.console.Output.showResult;
import static baseball.console.Output.startGame;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class BaseballGame {

    private Integer strike;
    private Integer ball;
    private List<Integer> answer;
    private Boolean isKeepPlaying;

    public BaseballGame() {
        this.strike = 0;
        this.ball = 0;
        this.isKeepPlaying = Boolean.TRUE;
        answer = new ArrayList<>();
    }

    public void start() {
        while (isKeepPlaying) {
            // 개임 시작, 재시작
            initGame();

            while (true) {
                // 정답을 맞출 때 까지 계속 입력 받기
                String inputData = getNumbers();
                calcInfo(inputData);

                // System.out.println("B: " + ball + ", S: " + strike );

                if (strike == 3) {
                    break;
                }

                clearData();
            }

            String stopOrGo = chooseRestart();
            Integer restartFlag = Integer.parseInt(stopOrGo);
            if (restartFlag == 2) {
                isKeepPlaying = Boolean.FALSE;
            }
        }
    }

    private void initGame() {
        this.strike = 0;
        this.ball = 0;
        this.isKeepPlaying = Boolean.TRUE;
        // answer = Randoms.pickUniqueNumbersInRange(0, 9, 3);
        answer = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int tmp = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(tmp)) {
                answer.add(tmp);
            }
        }

//        System.out.print("ans: ");
//        for (int i = 0; i < 3; i++) {
//            System.out.print(answer.get(i) + ", ");
//        }
//        System.out.println();
    }


    private void calcInfo(String info) {
        Integer numData = Integer.parseInt(info);
        List<Integer> parsedData = new ArrayList<>();

        while (numData > 0) {
            parsedData.add(numData % 10);
            numData /= 10;
        }

        Collections.reverse(parsedData);

//        System.out.print("input data : ");
//        for (int i = 0; i < 3; i++) {
//            System.out.print(parsedData.get(i) + ", ");
//        }
//        System.out.println();

        increaseBall(parsedData);
        increaseStrike(parsedData);
        showResult(ball, strike);
    }

    private void increaseBall(List<Integer> data) {
        for (int i = 0; i < 3; i++) {
            if (answer.contains(data.get(i))) {
                this.ball++;
            }
        }
    }

    private void increaseStrike(List<Integer> data) {
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(answer.get(i), data.get(i))) {
                this.ball--;
                this.strike++;
            }
        }
    }

    private void clearData() {
        this.strike = 0;
        this.ball = 0;
    }
}
