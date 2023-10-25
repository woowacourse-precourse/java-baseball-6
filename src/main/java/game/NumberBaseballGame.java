package game;

import java.util.Scanner;
import camp.nextstep.edu.missionutils.Console;

public class NumberBaseballGame {
    private static final int NUMBER_LENGTH = 3;
    private String computerGeneratedNumber;
    private final NumberGenerator generator;
    private final Scanner scanner;

    public NumberBaseballGame() {
        this.generator = new NumberGenerator();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        generateComputerNumber();
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            try {
                System.out.print("숫자를 입력해주세요 : ");
                String userInput = Console.readLine();

                if (InputValidator.isValid(userInput)) {
                    Result result = Judgment.judge(userInput, computerGeneratedNumber);
                    result.print();
                    if (result.isComplete()) {
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        if (!askToContinue()) {
                            break;
                        } else {
                            generateComputerNumber();
                        }
                    }
                }
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }
    }

    private boolean askToContinue() {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String response = Console.readLine();
            if(InputValidator.isContinueValid(response) && response.equals("1")) {
                return true;
            }
            return false;

    }

    private void generateComputerNumber() {
        this.computerGeneratedNumber = generator.generate();
    }

    public static void main(String[] args) {
        NumberBaseballGame game = new NumberBaseballGame();
        game.start();
    }

    public static int getNumberLength() {
        return NUMBER_LENGTH;
    }
}