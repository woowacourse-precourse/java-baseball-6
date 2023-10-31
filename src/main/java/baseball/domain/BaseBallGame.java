package baseball.domain;

import baseball.dto.StrikeBallCnt;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {
    private List<Integer> answer;

    public BaseBallGame(){
        answer = new ArrayList<>();
    }

    public StrikeBallCnt getResult(String input) {
        int strikeCnt = 0;
        int ballCnt = 0;

        char[] chars = input.toCharArray();
        for (int i = 0; i < 3; i++) {
            if(chars[i] - '0' == answer.get(i)){
                strikeCnt += 1;
            }else if(answer.contains(chars[i] - '0')){
                ballCnt += 1;
            }
        }

        return new StrikeBallCnt(strikeCnt, ballCnt);

    }

    public boolean isValidNumber(String input) {
        if(input.length() != 3){
            return false;
        }
        try {
            Integer.parseInt(input);
        }catch (IllegalArgumentException illegalArgumentException){
            return false;
        }
        return true;
    }

    public void createAnswerNumber() {
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

}
