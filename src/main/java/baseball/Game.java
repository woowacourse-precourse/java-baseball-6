package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
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

            String input = inputNumbers();

            if (!checkAnswer(input))
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

    private boolean checkAnswer(String input) {
        List<Integer> submittedNumList = Arrays.stream(input.split(""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();

        int[] result = judge(submittedNumList);

        // 판단 결과에서 strike의 개수가 3이면 true 반환
        if (result[0] == 3)
            return true;

        return false;
    }

    private int[] judge(List<Integer> submittedList) {
        int strikeNum = 0;
        int ballNum = 0;
        // 제출 된 숫자가 요구 사항에 따라 어떤 결과를 갖는지 판단
        for (int i = 0; i < submittedList.size(); i++) {
            if (submittedList.get(i).equals(submittedList.get(i)))
                strikeNum++;
            else if (submittedList.contains(submittedList.get(i)))
                ballNum++;
        }

        int[] result = new int[]{ strikeNum, ballNum };
        return result;
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
