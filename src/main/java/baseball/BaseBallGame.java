package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseBallGame {

    private static BaseBallGame baseBallGame;
    public int numOfBall = 0;
    public int numOfStrike = 0;

    public static BaseBallGame getInstance() {
        if (baseBallGame == null) {
            baseBallGame = new BaseBallGame();
        }
        return baseBallGame;
    }

    public void initializeNum() {
        this.numOfBall = 0;
        this.numOfStrike = 0;
    }

    //TODO 1. 예외처리
    //TODO 2. 테스트코드 > Scanner로 입력값 받지 못함
    public void run() {
        do {
            initializeNum();
            System.out.print(OutputMessage.START_GAME);
            List<Integer> answer = setAnswer();

            // 정답 확인용 임시 코드
            System.out.println(answer);

            checkAnswer(answer);

            System.out.println(OutputMessage.END_OR_NOT);

        } while (!askWhetherToEnd());
    }

    private static List<Integer> setAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }

    private void checkAnswer(List<Integer> answer) {
        do {
            System.out.print(OutputMessage.ENTER_NUMBER);
            List<Integer> input = getInput();
            compareAnswerToInput(answer, input);
        } while (!getResult());
    }

    private static List<Integer> getInput() {
        Scanner sc = new Scanner(System.in);
        String st = sc.next();
        String[] arr = st.split("");

        List<Integer> input = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            input.add(Integer.parseInt(arr[i]));
        }
        return input;
    }

    private void compareAnswerToInput(List<Integer> answer, List<Integer> input) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(answer.get(i).equals(input.get(j)))
                    if(i==j) {
                        numOfStrike++;
                        break;
                    } else {
                        numOfBall++;
                        break;
                    }
            }
        }
    }

    private boolean getResult() {
        if (numOfBall + numOfStrike == 0)
            System.out.print("낫싱");
        if (!(numOfBall==0))
            System.out.printf("%d볼 ", numOfBall);
        if (!(numOfStrike==0))
            System.out.printf("%d스트라이크", numOfStrike);
        return numOfStrike == 3;
    }

    private static boolean askWhetherToEnd() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt() == 2;
    }
}
