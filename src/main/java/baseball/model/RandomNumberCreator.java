package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashSet;
import java.util.Set;

// 세 개의 랜덤 숫자 생성
public class RandomNumberCreator {

    private String answer = ""; // 정답 저장 스트링

    public String getAnswer() {
        return answer;
    } // private 접근 제어하는 answer의 값을 들여다보지 않고 다른 패키지 혹은 클래스에서 갖고 오기 위한 getter

    public void setRandomNumber() {
        Set<Integer> generatedNumbers = new LinkedHashSet<>(); // 중복을 허용하지 않는 LinkedHashSet 사용
        int index = 0; // index = 2가 될 때까지 반복문 적용

        while (index < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9); // 1부터 9까지의 랜덤한 숫자를 픽해서 randomNumber 변수에 저장

            if (!generatedNumbers.contains(randomNumber)) {
                generatedNumbers.add(randomNumber);
                index++;
            }
        }

        StringBuilder generatedNumbersString = new StringBuilder();
        for (int num : generatedNumbers) {
            generatedNumbersString.append(num);
        }

        this.answer = generatedNumbersString.toString();
    }
}

// 고려사항 : 이중반복문이면 시간복잡도가 크지 않을까...? 효율성 챙길 방법이 없을까
