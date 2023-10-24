package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Guess guess = new Guess();
        boolean isGame = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        //TODO: 반복문 간결하게 줄이기
        while (isGame) {
            guess.setComputerGuessByRandom();
            boolean isAnswer = false;
            while (!isAnswer) {
                System.out.print("숫자를 입력해주세요 : ");
                try {
                    guess.setUserGuessByInput();
                } catch (IllegalArgumentException e) {
                    System.out.println("정상적인 입력이 아닙니다. 프로그램을 종료");
                    return;
                }
                int ball = guess.calculateBall();
                int strike = guess.calculateStrike();
                if (ball > 0) {
                    System.out.print(ball + "볼");
                }
                if (strike > 0) {
                    if (ball > 0) {
                        System.out.print(" ");
                    }
                    System.out.print(strike + "스트라이크");
                }
                if (ball == 0 && strike == 0) {
                    System.out.print("낫싱");
                }
                if (strike == 3) {
                    System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    isAnswer = true;
                }
                System.out.println();
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String userInput = Console.readLine();
            if (userInput.equals("2")) {
                isGame = false;
            }
        }
    }
}
