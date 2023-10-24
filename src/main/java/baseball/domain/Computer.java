package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> answer;

    public Computer() {
        generateAnswer();
    }

    public void generateAnswer() {
        answer = createNumber();
    }

    public List<Integer> getAnswer() {
        return answer;
    }


    // 컴퓨터가 임의의 랜덤한 숫자 3개를 생성해낸다.
    public List<Integer> createNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

//    // 게임 결과 계산 메서드
//    public GameResult calculateResult(List<Integer> guess) {
//        int strikes = 0;
//        int balls = 0;
//
//        for (int i = 0; i < 3; i++) {
//            if (guess.get(i).equals(answer.get(i))) {
//                strikes++;
//            } else if (answer.contains(guess.get(i))) {
//                balls++;
//            }
//        }
//        return new GameResult(strikes, balls);
//    }



}
