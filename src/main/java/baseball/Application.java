package baseball;

import camp.nextstep.edu.missionutils.Console; // 입력 값 사용

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int remainGame;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true) {
            boolean gameOver = false;
            Comparison computerNumber = new Comparison(); //숫자 생성 인스턴스
            try {
                while (true) {
                    System.out.print("숫자를 입력해주세요 : ");
                    String input = Console.readLine();
                    Input inputNumber = new Input(input);
                    Comparison.compare(inputNumber.getNumber());
                    gameOver = Comparison.isOver();
                    if (gameOver) {
                        break;
                    }
                }
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException();
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String endInput = Console.readLine();
            remainGame = Input.isEnd(endInput);
            if (remainGame == 0) {
                break;
            }
        }
    }
}