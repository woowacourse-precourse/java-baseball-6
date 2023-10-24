package model;

import static constant.Constants.NUMBER_LENGTH;

import java.util.List;
import java.util.Objects;
import vo.Balls;
import vo.Result;

/**
 * ModelCompareAnswerInput.java
 * <p>
 * 입력받은 숫자, 정답 비교 모델
 *
 * @author Lee NaYeon
 * @since 2023-10-25
 */

public class ModelCompareAnswerInput {

    /**
     * input값과 정답값을 비교해서 볼, 스트라이크 개수 계산
     *
     * @param computer 게임의 정답
     * @param user     사용자가 입력한 숫자
     * @return Result 타입의 비교 결과
     */
    public static Result compareAnswerInput(Balls computer, Balls user) {

        int ball = 0;
        int strike = 0;

        List<Integer> answer = computer.ball();
        List<Integer> input = user.ball();

        for (int i = 0; i < answer.size(); i++) {
            if (Objects.equals(answer.get(i), input.get(i))) {
                strike++;
            } else if (answer.contains(input.get(i))) {
                ball++;
            }
        }

        return new Result(ball, strike);

    }

    /**
     * 비교 결과를 통해 정답 여부 확인
     *
     * @param result 입력과 정답 비교 결과
     * @return 정답 : true, 오답 : false
     */
    public static boolean isAnswer(Result result) {

        return result.strike() == NUMBER_LENGTH;
    }

}