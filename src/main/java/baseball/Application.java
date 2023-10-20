package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private final static int MIN_RANDOM_NUMBER = 1;
    private final static int MAX_RANDOM_NUMBER = 9;
    private final static int COMPUTER_NUM_SIZE = 3;

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        String flag;
        do {
            startGame();
            flag = askReplayOrExit();
        }while (flag.equals("1"));  // 1을 입력하면 게임 새로 시작
    }

    private static void startGame() {
        List<Integer> computerNum = createComputerNumber();
        String result = null;
        do{
            System.out.print("숫자를 입력해주세요 : ");
            String playerNum = Console.readLine();

        }while (!result.equals("3스트라이크"));
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static List<Integer> createComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < COMPUTER_NUM_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static String askReplayOrExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String choice = Console.readLine();
        isValidUserChoice(choice);

        return choice;
    }

    public static void isValidUserChoice(String choice){
        // 1과 2가 아닌 다른 수를 입력할 경우
        if (!choice.equals("1") && !choice.equals("2")){
            throw new IllegalArgumentException("1 또는 2를 입력하지 않았습니다. 게임이 종료됩니다.");
        }
    }
}