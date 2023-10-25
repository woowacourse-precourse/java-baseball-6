package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Counterpart {

    private Answer correctAnswer;  // 정답

    Counterpart() {
        generateCorrectAnswer();
    }

    /**
     * 9개의 숫자(1~9) 중 서로 다른 3가지를 선택하여 임의의 순서로 나열 했을 때 만들어지는
     * 3자리 수를 정답으로 설정한다.
     *
     * @throws IllegalArgumentException 내부적으로 정답 생성에 실패한 경우
     */
    public void generateCorrectAnswer() {

        List<Integer> picked = new ArrayList<>();
        while (picked.size() < 3) {
            Integer randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!picked.contains(randomNumber)) {
                picked.add(randomNumber);
            }
        }

        this.correctAnswer = new Answer(
                picked.get(0) * 100
                        + picked.get(1) * 10
                        + picked.get(2)
        );
    }

    /**
     * 주어진 답안이 정답과 일치하는 지 판단합나다.
     *
     * @param answer 야구 게임 답안
     * @return 정답 여부
     * @throws IllegalArgumentException answer가 야구 게임의 정답일 수 없는 경우
     */
    public Boolean isCorrect(Answer answer) {

        // 답안(answer)과 정답(this.correctAnswer)을 비교
        int strike = correctAnswer.countStrike(answer);
        int ball = correctAnswer.countBall(answer);

        // 힌트 출력
        System.out.println(getHint(ball, strike));

        // 정답에 따른 반응 출력 후 반환
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else {
            return false;
        }
    }

    /**
     * 볼과 스트라이크 수에 따른 힌트 메시지를 반환합니다.
     * @param ball 볼 수
     * @param strike 스트라이크 수
     * @return 힌트 메시지
     */
    private String getHint(int ball, int strike) {
        String hint = "";

        if (ball > 0) {
            hint += ball + "볼";
            if (strike > 0) {
                hint += " ";
            }
        }

        if (strike > 0) {
            hint += strike + "스트라이크";
        }

        if (ball + strike == 0) {
            hint = "낫싱";
        }

        return hint;
    }
}
