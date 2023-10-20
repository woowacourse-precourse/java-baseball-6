package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {

        String input;   // 사용자 입력값
        List<Integer> inputNumArr = new ArrayList<>();  // 사용자 입력값을 리스트에 옮긴 것

        System.out.println("숫자 야구 게임을 시작합니다.");
        NumberBaseballGame game = new NumberBaseballGame();

        boolean isContinue = true;
        while (isContinue) {
            // 사용자 숫자 입력 받기
            System.out.print("숫자를 입력해주세요 : ");
            input = Console.readLine();
            if (input.length() != 3) {
                throw new IllegalArgumentException();
            }

            // 입력값을 리스트로 옮기기
            inputNumArr.clear();
            for (int i = 0; i < input.length(); i++) {
                char numChar = input.charAt(i);
                inputNumArr.add(Character.getNumericValue(numChar));
            }

            // 게임 시작 함수 호출
            int[] gameResult = game.startGame(inputNumArr);

            // 게임 결과 출력
            if (gameResult[0] != 0) {
                System.out.print(gameResult[0] + "볼 ");
            }
            if (gameResult[1] != 0) {
                System.out.print(gameResult[1] + "스트라이크");
            }
            if (gameResult[0] == 0 && gameResult[1] == 0) {
                System.out.print("낫싱");
            }

            System.out.println();

            // 게임 성공 판단
            if (gameResult[1] == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                // 게임 종료 판단
                String exitNum = Console.readLine();
                if (Objects.equals(exitNum, "1")) {
                    // 게임 재생성
                    game = null;
                    game = new NumberBaseballGame();
                } else if (Objects.equals(exitNum, "2")) {
                    // 게임 종료
                    isContinue = false;
                }
            }
        }
    }
}
