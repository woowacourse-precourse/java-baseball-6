package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        boolean running = true;
        Computer computer = new Computer();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (running) {
            boolean isCorrect = computer.makeGuess();
            if (isCorrect) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                char in = Console.readLine().charAt(0);
                switch (in) {
                    case '1' -> computer.initializeAnswer();
                    case '2' -> running = false;
                    default -> throw new IllegalArgumentException();
                }
            }
        }
    }
}
