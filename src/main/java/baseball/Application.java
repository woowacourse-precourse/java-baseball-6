package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {

            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = pickNumberInRange(1, 9); // 1~9 랜덤 수 출력
                if (!computer.contains(randomNumber)) { // 서로 다른 수
                    computer.add(randomNumber);
                }
            }
            System.out.println(computer);
            
            System.out.println(pickNumberInRange(1, 9));
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String userInput = readLine();
            if (userInput.equals("1")) {
                continue;
            } else if (userInput.equals("2")) {
                break;
            }
        }
    }
}
