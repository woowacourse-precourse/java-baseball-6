package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import service.Play;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            List<Integer> computer = generateComputerNumbers();
            Play game;
            boolean gameContinues;

            do {
                String inputValue;

                while (true) {
                    System.out.print("숫자를 입력해주세요 : ");
                    inputValue = Console.readLine();

                    if (isCheckNumber(inputValue) && isCheckLength(inputValue)) {
                        break;
                    }

                    if (!isCheckNumber(inputValue)) {
                        System.out.println("숫자만 입력해주세요");
                    }
                    if (!isCheckLength(inputValue)) {
                        System.out.println("숫자 3개만 입력해주세요");
                    }
                }

                List<Integer> human = stringToNumberArray(inputValue);
                game = new Play(computer, human);
                game.startGame();
                gameContinues = game.isContinue();
            } while (gameContinues);


            System.out.println("게임을 다시 시작하려면 1, 종료하려면 2를 입력하세요.");
            int choice = Integer.parseInt(Console.readLine());

            if (choice != 1 && choice != 2) {
                throw new IllegalArgumentException("잘못된 선택입니다. 1 또는 2만 입력할 수 있습니다.");
            }

            if (choice == 2) {
                break;
            }

        }
    }

    private static List<Integer> generateComputerNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }


        return computer;
    }

    private static List<Integer> stringToNumberArray(String inputValue) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < inputValue.length(); i++) {
            char c = inputValue.charAt(i);
            result.add(c - '0');
        }
        return result;
    }

    private static boolean isCheckLength(String inputValue) {
        if (inputValue.length()!=3){
            throw new IllegalArgumentException();
        }
        return true;
    }

    public static boolean isCheckNumber(String inputValue) {
        try {
            Integer.parseInt(inputValue);
            return true;
        }catch (NumberFormatException e){
            throw new NumberFormatException();
        }
    }
}
