package baseball.model;

import java.util.List;

public class BaseballGame {
    private List<Integer> computer; // 컴퓨터가 지정한 숫자를 저장할 리스트

    public void setComputer(List<Integer> computer) {
        this.computer = computer; // 컴퓨터가 지정한 숫자를 설정하는 메서드
    }

    public List<Integer> getComputer() {
        return computer; // 컴퓨터가 지정한 숫자를 반환하는 메서드
    }

    public List<Integer> calculateResult(List<Integer> userGuess) {
        int strike = 0; // 스트라이크 개수 초기화
        int ball = 0; // 볼 개수 초기화

        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i).equals(userGuess.get(i))) {
                strike++; // 숫자와 위치가 일치하는 경우 스트라이크 증가
            } else if (computer.contains(userGuess.get(i))) {
                ball++; // 숫자는 일치하지만 위치가 다른 경우 볼 증가
            }
        }
        return List.of(strike, ball); // 스트라이크와 볼 개수를 리스트로 반환
    }
}

