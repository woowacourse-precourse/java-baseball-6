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
        String flag = "";
        do {
            try{
                startGame();
            }catch (IllegalArgumentException e){
                flag = askReplayOrExit();
            }
        }while(flag.equals("1"));  // 1을 입력하면 게임 새로 시작
    }

    private static void startGame() {
        List<String> computerNum = createComputerNumber();
        String result = null;
        String playerNum;
        do{
            System.out.print("숫자를 입력해주세요 : ");
            try {
                playerNum = Console.readLine();
                isNonDigit(playerNum);
                isThreeDigitNumber(playerNum);
                hasRepeatedDigitNumber(playerNum);
            }catch (IllegalArgumentException e){
                return;
            }
            result = matchPlayerNum(computerNum, playerNum);

        }while (!result.equals("3스트라이크"));
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static List<String> createComputerNumber() {
        List<String> computer = new ArrayList<>();
        while (computer.size() < COMPUTER_NUM_SIZE) {
            int randNum = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            String randomNumber = String.valueOf(randNum);

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    // 사용자가 입력한 값이 숫자인지 확인한다.
    private static void isNonDigit(String playerNum){
        try {
            Integer.parseInt(playerNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력하신 값이 숫자가 아닙니다. 게임이 종료됩니다.");
        }
    }

    // 사용자가 입력한 값이 3자리 숫자인지 확인한다.
    private static void isThreeDigitNumber(String playerNum){
        if (playerNum.length() != 3){
            throw new IllegalArgumentException("숫자가 3자리가 아닙니다. 게임이 종료됩니다.");
        }
    }

    // 사용자가 입력한 값에서 2개 이상 중복되는 숫자가 있는 경우
    private static void hasRepeatedDigitNumber(String playerNum){
        List<String> player = new ArrayList<>();
        for(int i = 0; i < COMPUTER_NUM_SIZE; i++){
            String playerIndex = String.valueOf(playerNum.charAt(i));

            if (player.contains(playerIndex)) {
                throw new IllegalArgumentException("서로 다른 3자리의 수가 아닙니다. 게임이 종료됩니다.");
            }
            player.add(playerIndex);
        }
    }

    private static String matchPlayerNum(List<String> computerNum, String playerNum) {
        String result = "";
        int strikeCount = 0;
        int ballCount = 0;

        for(int i = 0; i < COMPUTER_NUM_SIZE; i++){
            String computerIndex = computerNum.get(i);
            String playerIndex = String.valueOf(playerNum.charAt(i));

            if(computerIndex.equals(playerIndex)){    // 스트라이크
                strikeCount += 1;
            }
            else if (computerNum.contains(playerIndex)) {    // 볼
                ballCount += 1;
            }
        }

        if (ballCount > 0){
            result += (result + ballCount + "볼 ");
        }
        if (strikeCount > 0){
            result += (result + strikeCount + "스트라이크");
        }
        if (ballCount == 0 && strikeCount == 0){
            result = "낫싱";
        }

        return result.trim();
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