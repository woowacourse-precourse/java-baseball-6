package model;

import java.util.List;

/**
 * ModelCompareAnsInput.java
 * <p>
 * 입력받은 숫자, 정답 비교 모델
 *
 * @author Lee NaYeon
 * @since 2023-10-25
 */

public class ModelCompareAnsInput {

    /**
     * input값과 정답값을 비교해서 볼, 스트라이크 개수 계산
     *
     * @param ans   게임의 정답
     * @param input 사용자가 입력한 숫자
     * @return int[] 타입의 비교 결과 (index 0 : 볼, 1 : 스트라이크)
     */
    public static int[] compareAnsInput(List<Integer> ans, List<Integer> input) {

        int[] result = {0, 0};

        for (int i = 0; i < ans.size(); i++) {
            if (ans.get(i).equals(input.get(i))) {
                result[1]++;
            } else if (ans.contains(input.get(i))) {
                result[0]++;
            }
        }

        return result;

    }

}
