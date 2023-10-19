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
        while( true ) {
            initializeNum();
            System.out.print("숫자 야구 게임을 시작합니다.");
            List<Integer> answer = setAnswer();

            // 정답 확인용 임시 코드
            System.out.println(answer);

            checkAnswer(answer);

            System.out.println(
                    """
                        \n3개의 숫자를 모두 맞히셨습니다! 게임 종료
                        게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.""");

            if (askWhetherToEnd()) break;
        }
    }

    private static boolean askWhetherToEnd() {
        Scanner sc = new Scanner(System.in);
        if (sc.nextInt() == 2)
            return true;
        return false;
    }

    private void checkAnswer(List<Integer> answer) {
        while ( true ) {
            System.out.print("\n숫자를 입력해주세요 : ");

            List<Integer> input = getInput();

            compareAnswerToInput(answer, input);

            if (getResult()) break;

        }
    }

    private boolean getResult() {
        if (numOfBall + numOfStrike == 0)
            System.out.print("낫싱");
        if (!(numOfBall==0))
            System.out.printf("%d볼 ", numOfBall);
        if (!(numOfStrike==0))
            System.out.printf("%d스트라이크", numOfStrike);
        if (numOfStrike == 3)
            return true;
        return false;
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
}
