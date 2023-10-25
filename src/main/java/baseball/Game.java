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

            // 게임을 진행 하는 메서드
            playingGame();

            // 게임 재시작을 물어봄
            isRun = checkPlayAgain();
        }
    }

    private void playingGame() {
        while (true) {

            String input = inputNumbers();
            validateInputNumbers(input);

            if (checkAnswer(input)) {
                // 정답을 맞춰 게임 종료 문구 출력
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private String inputNumbers() {
        // 정답 추측 입력을 요구하는 문구 출력
        System.out.print("숫자를 입력해 주세요 : ");

        // 사용자에게 추측되는 정답을 입력 받음
        String input = Console.readLine();

        return input;
    }

    private void validateInputNumbers(String input) {
        if (input.length() != 3) throw new IllegalArgumentException();
        if (!input.chars().allMatch(Character::isDigit)) throw new IllegalArgumentException();
        if (input.chars().distinct().count() != 3) throw new IllegalArgumentException();
    }

    private boolean checkAnswer(String input) {
        List<Integer> submittedNumList = Arrays.stream(input.split(""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();

        PlayResult result = judge(submittedNumList);

        showResult(result);

        // 판단 결과에서 strike의 개수가 3이면 true 반환
        if (result.getStrikeNum() == 3)
            return true;

        return false;
    }

    private PlayResult judge(List<Integer> submittedList) {
        int strikeNum = 0;
        int ballNum = 0;
        // 제출 된 숫자가 요구 사항에 따라 어떤 결과를 갖는지 판단
        for (int i = 0; i < submittedList.size(); i++) {
            if (answerList.get(i).equals(submittedList.get(i)))
                strikeNum++;
            else if (answerList.contains(submittedList.get(i)))
                ballNum++;
        }

        return new PlayResult(strikeNum, ballNum);
    }

    private void showResult(PlayResult result) {
        int strikeNum = result.getStrikeNum();
        int ballNum = result.getBallNum();

        if (strikeNum == 0 && ballNum == 0) {
            System.out.print("낫싱");
        }
        if (ballNum > 0) {
            System.out.print(ballNum + "볼");
        }
        if (strikeNum > 0) {
            if (ballNum > 0) System.out.print(" ");
            System.out.print(strikeNum + "스트라이크");
        }
        System.out.println();
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

    private class PlayResult {
        private final int strikeNum;
        private final int ballNum;

        public PlayResult(int strikeNum, int ballNum) {
            this.strikeNum = strikeNum;
            this.ballNum = ballNum;
        }

        public int getStrikeNum() {
            return strikeNum;
        }

        public int getBallNum() {
            return ballNum;
        }
    }
}
