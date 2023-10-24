package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 아구 게임을 시작합니다.");
        String gameStatus = "1";
        String restart = "1";
        List<Integer> computerNumberList = null;
        // 게임 시작
        while (gameStatus.equals("1")) {
            if (restart == "1") {
                computerNumberList = new ArrayList<>();
                restart = "0";
                while (computerNumberList.size() < 3) {
                    int randomNumber = Randoms.pickNumberInRange(1, 9);
                    if (!computerNumberList.contains(randomNumber)) computerNumberList.add(randomNumber);
                }
                //System.out.println("// computerNumber = " + computerNumberList);
            }

            System.out.print("숫자를 입력해주세요 : ");
            char[] userInput = Console.readLine().toCharArray();
            List<Integer> userInputList = new ArrayList<>();

            for (char character : userInput){
                userInputList.add((int)character - '0');
            }

            // length check
            if (userInputList.size() > 3 || userInputList.size() == 0){
                throw new IllegalArgumentException("숫자는 3자리 입력해야 합니다.");
            }

            // unique check
            for (int i = 0; i < userInputList.size() - 1; i++) {
                for (int j = i + 1; j < userInputList.size(); j++) {
                    if (userInputList.get(i).equals(userInputList.get(j))) {
                        throw new IllegalArgumentException("숫자는 중복되지 않아야합니다.");
                    }
                }
            }




            // 사용자 숫자와 컴퓨터 숫자를 비교한다.
            int strikeCount = 0;
            int ballCount = 0;
            for (int i = 0; i < 3; i++) {
                int compareResult = computerNumberList.indexOf(userInputList.get(i));
                if (compareResult == i) {
                    strikeCount += 1;
                } else if (compareResult != -1) {
                    ballCount += 1;
                }
            }

            if (ballCount == 0 & strikeCount == 0) {
                System.out.print("낫싱");
            }
            if (ballCount != 0){
                System.out.print(ballCount + "볼 ");
            }
            if (strikeCount != 0) {
                System.out.print(strikeCount + "스트라이크");
            }

            System.out.println();

            if (strikeCount == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                gameStatus = Console.readLine();
                restart = "1";
            }
        }
    }
}
