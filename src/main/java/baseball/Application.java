package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        boolean gameChoice = true;
        List<Integer> computerNum = new ArrayList<>();
        String gameString = "";
        // 컴퓨터 숫자를 생성함. 차후 메소드로 분리
        while (computerNum.size() < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(num)) {
                computerNum.add(num);
            }
        }
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (gameChoice) {
            System.out.println("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();
            gameString = check(userInput, computerNum);

            System.out.println(gameString); // 진행상황 표시

            if (gameString.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                String gameChoiceNum = Console.readLine();

                if (gameChoiceNum.equals("1"))
                    gameChoice = true;
                else if (gameChoiceNum.equals("2"))
                    gameChoice = false;
                //else를 사용하지않고 잘못 섰을시 예외처리 하기
            }
        }

    }

    static String check(String userInput, List<Integer> ComputerNum) {
        int totalCount = 0;
        int strikeCount = 0;
        int ballCount = 0;
        String returnString = "";

        for (int i = 0; i < 3; i++) {
            if (userInput.contains(ComputerNum.get(i).toString())) {
                totalCount++;
            }
            if (userInput.charAt(i) - 48 == ComputerNum.get(i)) {
                strikeCount++;
            }
        }

        ballCount = totalCount - strikeCount;

        switch (totalCount) {
            case 0:
                returnString = "낫싱";
                break;
            case 1:
            case 2:
                returnString = ballCount + "볼 " + strikeCount + "스트라이크";
                break;
            case 3:
                if (strikeCount == 3)
                    returnString = strikeCount + "스트라이크";
                else if (strikeCount == 0 || strikeCount == 1 || strikeCount == 2)
                    returnString = ballCount + "볼 " + strikeCount + "스트라이크";
                break;
            default:
                break;
        }
        return returnString;
    }
}