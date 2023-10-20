package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        Computer computer = new Computer();
        Player player = new Player();
        int reStartFlag;   // 1이면 게속, 2면 프로그램 종료

        do {
            // 1. 랜덤하게 숫자 1~9 로 이루어진 3자리 숫자 생성
            computer.setRandomNums();

            boolean gameOver = false;
            while (!gameOver) {
                // 2. 숫자 입력
                player.inputNums();

                // 3. 숫자 비교
                gameOver = computer.compareNums(player);
            }
            reStartFlag = reStart();
        } while(reStartFlag == 1);
    }

    private static int reStart(){
        int result;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        try {
            result = Integer.parseInt(input);
            if (result != 1 && result != 2){  // 숫자가 1, 2 가 아닌 경우
                throw new IllegalArgumentException("not 1 or 2");
            }
        } catch (NumberFormatException e){  // 숫자가 아닌 이상한 값일 경우
            throw new IllegalArgumentException("not number");
        }
        return result;
    }
}
