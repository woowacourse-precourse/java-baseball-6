package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private final List<Integer> generatedAnswers = new ArrayList<>();

    public List<Integer> getGeneratedAnswers() {
        return generatedAnswers;
    }

    public void generateAnswers() {
        // TODO: 각 숫자가 겹치지 않도록 해야 함
        for (int i = 0; i < 3; i++) {
            int candidateNum;
            do {
                candidateNum = Randoms.pickNumberInRange(1, 9);
            } while (checkDuplicateNum(candidateNum));
            generatedAnswers.add(candidateNum);
        }
    }

    // 무작위로 생성한 숫자가 정답 숫자 리스트에 포함되어 있는지 검사
    // 중복: true, 중복되지 않음: false
    private boolean checkDuplicateNum(int candidateNum) {
        if (generatedAnswers.contains(candidateNum)) {
            return true;
        }
        return false;
    }

    // 컴퓨터가 생성한 정답을 문자열로 출력
    public String collectAnswers() {
        String ans = "";
        for (int i = 0; i < generatedAnswers.size(); i++) {
            ans += generatedAnswers.get(i);
        }
        return ans;
    }
}
