package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {

        List<Integer> computer = new ArrayList<>();
        List<Integer> user = new ArrayList<>();

        while(computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        System.out.println("숫자 야구 게임을 시작합니다.");


        while(true) {
            System.out.print("숫자를 입력해주세요 : ");

            String userInput = Console.readLine();
            String[] userInputs = userInput.split("");

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            int endGame = Integer.parseInt(Console.readLine());

            if(endGame == 1) {
                continue;
            } else if (endGame == 2) {
                break;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }
}

