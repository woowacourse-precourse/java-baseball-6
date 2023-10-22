package baseball;

import java.util.Objects;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean isTerminate = false;
        String choice = "-1";

        while (!isTerminate){
            BullsAndCowsComputer bullsAndCowsComputer = new BullsAndCowsComputer();
            bullsAndCowsComputer.PlayGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            while (!Objects.equals(choice, "2")) {
                choice = readLine();
                if (Objects.equals(choice, "1")) {
                    break;
                } else if (Objects.equals(choice, "2")){
                    isTerminate = true;
                    break;
                } else {
                    System.out.println("올바르지 않은 입력값입니다. 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                }
            }
        }

    }
}
