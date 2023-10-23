package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        Baseballgame game = new Baseballgame();

        // 0 : 게임 시작시 정답을 생성한다.
        List<Integer> answer = game.createAnswer();
        System.out.println(answer);

        // 반복문 제어를 위한 변수 선언 - 조건이 달성 된다면 false 로 전환
        boolean gameStatus = true;
        while (gameStatus) {

            // 1 : 게임 시작 문구 출력
            System.out.print("숫자 야구 게임을 시작합니다.");

            // 2 : 플레이어의 정답을 입력받는다.
            System.out.print("숫자를 입력해주세요 : ");
            // 플레이어의 입력 데이터를 검증해서 리스트에 저장해서 반환한다.
            List<Integer> s = game.enterCorrectAnswer(Console.readLine());
            System.out.println(s);

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

    public List<Integer> enterCorrectAnswer(String var) {
        List<Integer> input = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int num = var.charAt(i) - 48;
            if (!input.contains(num)) {
                input.add(num);
            }
            else throw new IllegalArgumentException();
        }
        return input;
    }
}