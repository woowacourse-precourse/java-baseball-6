package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean gameOn = true;
        while (gameOn) {
            List<Integer> randomNumber = getRandomNumber();
            loopGame(randomNumber);
            gameOn = restartOrNot();
        }
    }

    private static void loopGame(List<Integer> randomNumber) {
        while (true) {
            List<Integer> userNumber = inputUserNumber();
            int strike = strike(randomNumber, userNumber);
            int ball = ball(randomNumber, userNumber);
            printScore(strike, ball);
            if(strike == 3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return;
            }
        }
    }

    public static void printScore(int strike, int ball) {
        String result = "";
        if (strike == 0 && ball == 0) {
            result = "낫싱";
        }
        if (ball != 0) {
            result += ball + "볼 ";
        }
        if (strike != 0) {
            result += strike + "스트라이크";
        }
        System.out.println(result);
    }

    private static List<Integer> getRandomNumber() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int random = Randoms.pickNumberInRange(1, 9);
            if(!randomNumbers.contains(random)) {
                randomNumbers.add(random);
            }
        }
        return randomNumbers;
    }

    private static List<Integer> inputUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();

        if (userInput.length() != 3) {
            throw new IllegalArgumentException("세 자리의 숫자를 입력해주세요.");
        }
        if (userInput.replaceAll("\\s", "").length() < 3) {
            throw new IllegalArgumentException("공백을 제외한 세 자리 수를 입력해주세요.");
        }

        List<Integer> userNumbers = userInputToInteger(userInput);
        for (int userNumber : userNumbers) {
            if(userNumber < 1 || userNumber > 9) {
                throw new IllegalArgumentException("1부터 9까지의 숫자를 입력해주세요.");
            }
        }

        Set<Integer> deleteDuplicate = new HashSet<>(userNumbers);
        if (deleteDuplicate.size() != userNumbers.size()) {
            throw new IllegalArgumentException("중복 되지 않은 수를 입력해주세요.");
        }

        return userNumbers;
    }

    private static List<Integer> userInputToInteger(String userInput) {
        List<Integer> userNumbers = new ArrayList<>();
        for (String inputStr : userInput.split("")) {
            try {
                int userNumberInt = Integer.parseInt(inputStr);
                userNumbers.add(userNumberInt);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자만 입력 가능합니다.");
            }
        }
        return userNumbers;
    }

    private static int strike(List<Integer> randomNumber, List<Integer> userNumber) {
        int count = 0;
        for(int i =0; i< userNumber.size(); i++) {
            if(randomNumber.get(i).equals(userNumber.get(i))) {
                count++;
            }
        }
        return count;
    }

    private static int ball(List<Integer> randomNumber, List<Integer> userNumber) {
        int ball = 0;
        for(int i =0; i< userNumber.size(); i++) {
            if(randomNumber.contains(userNumber.get(i)) && !randomNumber.get(i).equals(userNumber.get(i))) {
                 ball++;
            }
        }
        return ball;
    }

    public static boolean restartOrNot() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();
        if (userInput.equals("1")) {
            return true;
        }
        if (userInput.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException("1또는 2를 입력해주세요.");
    }
}
