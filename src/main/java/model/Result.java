/*
 * <pre>
 * Class : Result
 * Comment: 제시된 난수와 사용자가 입력한 수를 비교
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2023-10-22       손준형           최초 생성
 * </pre>
 *
 * @author 손준형
 * @version 1.0.0
 * @see
 */

package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Result {
    public static List<Integer> getResult(List<Integer> answer, List<Integer> userInput) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        res.add(0);
        for (int i = 0; i < answer.size(); i++) {
            if (Objects.equals(answer.get(i), userInput.get(i))) {
                res.set(0, res.get(0) + 1);
            } else if (userInput.contains(answer.get(i))) {
                res.set(1, res.get(1) + 1);
            }
        }

        return res;
    }
}
