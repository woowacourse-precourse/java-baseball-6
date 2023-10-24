package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Integer> answerList = new ArrayList<>();

    private void init() {
        answerList.clear();
        while (answerList.size() < 3) {
            // 랜덤한 1부터 9의 서로 다른 3자리의 수 생성
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerList.contains(randomNumber)) {
                answerList.add(randomNumber);
            }
        }
    }

    public void run() {
        boolean isRun = true;
        while (isRun) {
            // 게임 초기화
            init();

            playingGame();

            isRun = checkPlayAgain();
        }
    }

    private void playingGame() {
        while (true) {
            if (checkAnswer())
                break;
        }
    }

    private String inputNumbers() {
        // 정답 추측 입력을 요구하는 문구 출력
        System.out.print("숫자를 입력해 주세요 : ");

        // 사용자에게 추측되는 정답을 입력 받음
        String input = Console.readLine();
        if (input.length() > 3) throw new IllegalArgumentException();

        return input;
    }

    private boolean checkAnswer() {

    }

    private boolean checkPlayAgain() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals("1"))
            return true;
        else if (input.equals("2"))
            return false;
        else throw new IllegalArgumentException();
    }
}
