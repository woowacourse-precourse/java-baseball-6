package baseball;

import baseball.logic.Compare;
import baseball.logic.ComputerCreateRandomNumber;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
//    public static void main(String[] args) {
//        ComputerCreateRandomNumber createRandomNumber = new ComputerCreateRandomNumber();
//        Compare compare = new Compare();
//
//        boolean restartGame = true;
//
//        while (restartGame) {
//            int computerInput = createRandomNumber.createRandomNumber();
//            boolean correctGuess = false;
//
//            System.out.println("숫자 야구 게임을 시작합니다.");
//
//            while (!correctGuess) {
//                try {
//                    System.out.print("숫자를 입력해주세요 : ");
//                    int userInput = Integer.parseInt(Console.readLine());
//
//                    String result = compare.getGameResult(computerInput, userInput);
//                    System.out.println(result);
//
//                    if (result.equals("3스트라이크")) {
//                        System.out.println("3개의 숫자를 모두 맞혔습니다! 게임 종료");
//                        correctGuess = true;
//                    } else if (result.equals("게임 종료")) {  // 추가: 게임 종료 메시지에 대한 처리
//                        correctGuess = true;
//                    }
//                } catch (NumberFormatException e) {
//                    System.out.println("숫자를 입력해주세요.");
//                }
//            }
//
//            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
//            int againGame = Integer.parseInt(Console.readLine());
//
//            if (againGame == 2) {
//                restartGame = false;
//            }
//        }
//    }

    private final ComputerCreateRandomNumber createRandomNumber;
    private final Compare compare;

    public Application() {
        this.createRandomNumber = new ComputerCreateRandomNumber();
        this.compare = new Compare();
    }

    public void run(String... inputs) {
        int inputIndex = 0;
        boolean restartGame = true;

        while (restartGame) {
            List<Integer> computerInput = createRandomNumber.createRandomNumber();
            boolean correctGuess = false;

            System.out.println("숫자 야구 게임을 시작합니다.");

            while (!correctGuess) {
                try {
                    System.out.print("숫자를 입력해주세요 : ");
                    String userInput = Console.readLine();

                    String result = compare.getGameResult(computerInput, userInput);
                    System.out.println(result);

                    if (result.equals("3스트라이크")) {
                        System.out.println("3개의 숫자를 모두 맞혔습니다! 게임 종료");
                        correctGuess = true;
                    }
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("숫자를 입력해주세요.");
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
            int againGame = Integer.parseInt(Console.readLine());

            if (againGame == 2) {
                restartGame = false;
            }
        }
    }

    public static void main(String[] args) { // main method will be used in actual application run
        new Application().run(args);
    }
}
