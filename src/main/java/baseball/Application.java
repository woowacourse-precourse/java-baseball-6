package baseball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        boolean gameStatus = true;
        while (!gameStatus) {

            Baseballgame game = new Baseballgame();

            // 0 : 게임 시작시 정답을 생성한다.
            List<Integer> answer = game.createAnswer();
            System.out.println(answer);

            // 1 : 게임 시작 문구 출력
            System.out.print("숫자 야구 게임을 시작합니다.");

        }

    }
}

class Baseballgame {
    public List<Integer> createAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }
}