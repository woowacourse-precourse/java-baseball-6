package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

// 세 개의 랜덤 숫자 생성
public class RandomNumberCreator {

    private String answer = ""; // 정답 저장 스트링

    public String getAnswer() {
        return answer;
    } // private 접근 제어하는 answer의 값을 들여다보지 않고 다른 패키지 혹은 클래스에서 갖고 오기 위한 getter

    public void setRandomNumber() {
        StringBuilder generatedNumbers = new StringBuilder(); // 중복 체크를 위해 StringBuilder 사용
        int index = 0; // index = 2가 될 때까지 반복문 적용

        while (index < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9); // 1부터 9까지의 랜덤한 숫자를 픽해서 randomNumber 변수에 저장

            boolean isDuplicate = false; // 중복 여부 판별을 위한 boolean 타입 변수
            for (int i = 0; i < generatedNumbers.length(); i++) {
                if (generatedNumbers.charAt(i) == Character.forDigit(randomNumber, 10)) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                generatedNumbers.append(randomNumber);
                index++;
            } // 중복이 아니면 해당 숫자 인덱스에 추가
        }

        this.answer = generatedNumbers.toString();
    }
}

// 고려사항 : 이중반복문이면 시간복잡도가 크지 않을까...? 효율성 챙길 방법이 없을까
