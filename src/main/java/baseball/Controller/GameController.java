package baseball.Controller;


import baseball.Dto.GameResultDto;
import baseball.Service.GameService;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {
    private final Scanner scanner;
    private final GameService gameService;

    public GameController() {
        scanner = new Scanner(System.in);
        gameService = new GameService();
    }

    public void run() throws IllegalArgumentException {
        gameService.startNewGame();

        boolean isGameOver = false;
        while (!isGameOver) {
            System.out.print("숫자를 입력해주세요: ");
            String inputString = scanner.nextLine();

            List<Integer> userNumbers;
            try {
                userNumbers = parseInput(inputString);

                if (userNumbers.size() != 3) {
                    throw new IllegalArgumentException("세 자리의 숫자만 입력 가능합니다.");
                } else {
                    GameResultDto resultDto = gameService.checkGuess(userNumbers);

                    printResult(resultDto);

                    if (resultDto.getStrikes() == 3) {
                        isGameOver = true;
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        break;
                    }
                }
            } catch (IllegalArgumentException e) {
                throw e; // 상위로 예외 전파
            }
        }

        handleRestartOrExit();
    }

    private List<Integer> parseInput(String inputString) throws IllegalArgumentException {
        try {
            String[] splitInputs = inputString.split("");
            List<Integer> parsedInputs = new ArrayList<>();
            for (String input : splitInputs) {
                parsedInputs.add(Integer.parseInt(input));
            }
            return parsedInputs;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 형식의 숫자가 아닙니다.");
        }
    }


    private void printResult(GameResultDto resultDto) {
        String message = "";
        if (resultDto.getBalls() == 0 && resultDto.getStrikes() == 0) {
            message = "낫싱";
        } else {
            StringBuilder sb = new StringBuilder();
            if (resultDto.getBalls() > 0) {
                sb.append(resultDto.getBalls()).append("볼 ");
            }
            if (resultDto.getStrikes() > 0) {
                sb.append(resultDto.getStrikes()).append("스트라이크");
            }
            message = sb.toString().trim();
        }
        System.out.println(message);
    }


    private void handleRestartOrExit() {
        boolean isValidChoice = false;
        while (!isValidChoice) {
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2 를 입력하세요: ");

            String choice = scanner.nextLine();

            switch (choice.trim()) {
                case "1":
                    isValidChoice = true;
                    run();
                    break;
                case "2":
                    isValidChoice = true;
                    break;
                default:
                    System.out.println("잘못된 선택입니다.");
            }
        }
    }
}