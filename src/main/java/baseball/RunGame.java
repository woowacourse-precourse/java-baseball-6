package baseball;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import baseball.StaticValue;
import baseball.Calculate;

public class RunGame {
    // 시작지점 inputNumbers, returnResult 두개 실행
    public static void run() {
        RunGame runningGame = new RunGame();
        runningGame.runningGame();
    }

    // 게임시작 문구 출력 => IsMatch > accurateTest 실행
    public void startGame() {
        System.out.println(StaticValue.GAME_START);
    }

    // 난수생성
    public void createRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        int idx = 0;
        for (int a: computer) {
            StaticValue.answer[idx] = a;
            idx += 1;
        }
    }

    // run()에서 게임 시작하는 부분 분리함
    public void runningGame() {
        RunGame startGame = new RunGame();
        RunGame finishGame = new RunGame();
        RunGame inputNumbers = new RunGame();
        RunGame returnResult = new RunGame();
        RunGame createRandomNumbers = new RunGame();

        startGame.startGame();
        createRandomNumbers.createRandomNumbers();
        while(true){
            inputNumbers.inputNumbers();
            boolean isEnd = returnResult.returnResult();
            if (isEnd) {
                finishGame.finishGame();
                break;
            }
        }
    }

    // 숫자 입력받아 int 배열으로 전환하는 과정
    public void inputNumbers() {
        Calculate divideNumber = new Calculate();
        Calculate multiplyNumber = new Calculate();

        System.out.println(StaticValue.INPUT_NUMBERS);
        String numStr = Console.readLine();

        if (numStr.length() > 3)
            throw new IllegalArgumentException();

        int num = Integer.parseInt(numStr);
        int digit = 100;

        for (int i = 0; i < 3; i++) {
            if (i == 0 && num/digit == 0)
                throw new IllegalArgumentException();
            int dNum = divideNumber.divideNumber(num, digit);
            StaticValue.keyNum[i] = dNum;

            int mNum = multiplyNumber.multiplyNumber(dNum, digit);
            digit = divideNumber.divideNumber(digit, 10);
            num -= mNum;
        }
    }

    // 숫자를 판단해서 결과 출력
    public boolean returnResult() {
        int ballCnt = 0;
        int stCnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int l = 0; l < 3; l++) {
                if ((int) StaticValue.answer[i] == (int) StaticValue.keyNum[l]) {
                    if (i == l) {
                        stCnt += 1;
                        break;
                    } else {
                        ballCnt += 1;
                    }
                }
            }
        }

        if (ballCnt > 0) {
            System.out.print(ballCnt+StaticValue.COUNT_BALL);
        }
        if (stCnt > 0) {
            System.out.println(stCnt+StaticValue.COUNT_STRIKE);
        }
        if (stCnt+ballCnt == 0) {
            System.out.println(StaticValue.COUNT_NOTHING);
        }
        if (stCnt == 3) return true;
        return false;
    }

    // 종료지점
    public void finishGame() {
        RunGame runningGame = new RunGame();
        System.out.println(StaticValue.GAME_FINISHED);
        System.out.println(StaticValue.RESTART_OR_OVER);
        String oneTwo = Console.readLine();
        if (oneTwo.equals(StaticValue.RESTART_NUMBER)) {
            runningGame.runningGame();
        }
    }
}
