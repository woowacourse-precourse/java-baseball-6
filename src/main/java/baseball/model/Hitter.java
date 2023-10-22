package baseball.model;

import java.util.ArrayList;
import java.util.List;

// 사용자 입력한 수를 저장하는 모델
public class Hitter {
    private List<Integer> hitterNum;

    public Hitter(){}

    public Hitter(String hitterString){
        hitterNum = new ArrayList<>();

        for (int i = 0; i < hitterString.length(); i++) {
            char digitChar = hitterString.charAt(i); // 문자열에서 한 자릿수를 가져옴
            int digit = Character.getNumericValue(digitChar); // 문자를 정수로 변환
            hitterNum.add(digit); // List에 추가
        }
    }

    public List<Integer> getHitterNum() {
        return hitterNum;
    }

    public void setHitterNum(List<Integer> hitterNum) {
        this.hitterNum = hitterNum;
    }
}
