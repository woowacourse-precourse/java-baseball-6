package baseball.model;

// 채점 기능
public class UserNumberGrader {
    private int ball;
    private int strike;

    // 스트라이크인 숫자는 필연적으로 볼인 숫자다. 하지만 볼이라고 해서 스트라이크는 아니다.
    // 검증 과정은 볼에 해당하는 숫자 개수를 파악한다. 그리고 그 볼 중에서 스트라이크에 해당하는 숫자 개수를 파악한다.
    // 다만 위의 검증 과정이라면 볼과 스트라이크가 중첩돼서 개수를 세리게 된다.
    // 볼부터 세린다. 그리고 스트라이크에 해당하는 볼을 세린 후, 볼에서 스트라이크를 빼면 볼 따로, 스트라이크 따로 계산될 것

    // 카운트된 볼과 스트라이크를 반환하는 메소드
    public int[] grader(String userNumber, String answer) {
        resetCount();
        countBall(userNumber, answer);
        countStrike(userNumber, answer);
        mediateBallcount();

        return new int[]{ball, strike};
    }

    // 볼을 카운트하는 메소드
    public void countBall(String userNumber, String answer) {
        for (char num : userNumber.toCharArray()) {
            if (answer.contains(String.valueOf(num))) {
                ball++;
            }
        }
    }

    // 스트라이크를 카운트하는 메소드
    public void countStrike(String userNumber, String answer) {
        // 인덱스를 순회하며 인덱스에 일치하는 숫자가 있다 => 스트라이크 ++
        for (int i = 0; i < userNumber.length(); i++) {
            if (userNumber.charAt(i) == answer.charAt(i)) {
                strike++;
//                ball = ball - strike; // 중첩된 볼 카운트 조정
            }
        }
    }

    // 중첩된 볼 카운트 조정
    public void mediateBallcount() {
        ball = ball - strike;
    }

    // 볼과 스트라이크를 초기화하는 메소드
    public void resetCount() {
        ball = 0;
        strike = 0;
    }
}
