package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> randomComputerList = NumberGenerator.getRandomNumberList(); // 서로 다른 3자리 숫자 임의 생성
        while (true) {

            String inputNumberString = UserInput.getUserInput(); // 사용자 입력 값 - 예외처리 까지 여기서 진행

            // 사용자가 입력한 숫자 3자리와, 컴퓨터가 임의로 만든 3자리 숫자 비교하기
            // 볼, 스트라이크 수 체크 및 출력
            int strikeCount = GameManager.getStrikeCount(inputNumberString, randomComputerList);
            int ballCount = GameManager.getBallCount(inputNumberString, randomComputerList);

            // 볼, 스트라이크 수 count 출력
            if (strikeCount > 0 && ballCount > 0) {
                System.out.println(ballCount+"볼 " + strikeCount+"스트라이크");
            } else if (strikeCount > 0 && ballCount == 0) {
                System.out.println(strikeCount+"스트라이크");
            } else if (strikeCount == 0 && ballCount > 0) {
                System.out.println(ballCount+"볼");
            } else if (strikeCount == 0 && ballCount == 0) {
                System.out.println("낫싱");
            }

            // 3스트라이크로 모든 숫자 정답일 경우 > 종료할지, 게임을 새로 시작할지 결정한다
            if (strikeCount == 3 && ballCount == 0) {

                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                String isRestart = Console.readLine();
                int endNum = Integer.parseInt(isRestart); // 1 - 새로시작, 2 - 종료
                if (endNum == 1) {
                    randomComputerList = NumberGenerator.getRandomNumberList(); // 새로운 랜덤한 숫자 3개를 불러와 다시 저장한다
                } else if (endNum == 2) {
                    Console.close();
                    break;
                }
            }

        }

    }

}