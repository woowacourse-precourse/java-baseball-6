package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final String INTRO_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_REQUEST_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String CONGRATS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_QUEST_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String NOTHING_MESSAGE = "낫싱";
    public static void main(String[] args) {
        boolean isCorrect = false;
        Integer[] statusArray;
        int strikes, balls;
        System.out.println(INTRO_MESSAGE);
        while (true) {
            List<Integer> computer;
            computer = getThreeRandomNumbers();

            while (!isCorrect) {
                List<Integer> user;
                user = getUserNumbers();
                statusArray = checkAnswer(computer, user);
                strikes = statusArray[0];
                balls = statusArray[1];
                printUserTrial(strikes, balls);
                if (strikes == 3) isCorrect = true;
            }

            System.out.println(CONGRATS_MESSAGE);
            System.out.println(RESTART_QUEST_MESSAGE);

            try {
                int restartCommand = Integer.parseInt(Console.readLine());
                if (restartCommand == 1) {
                    isCorrect = false;
                } else if (restartCommand == 2) {
                    break;
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static List<Integer> getThreeRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    private static List<Integer> getUserNumbers() {
        List<Integer> userNumbers = new ArrayList<>();
        while (userNumbers.size() < 3) {
            System.out.print(INPUT_REQUEST_MESSAGE);
            String temporaryString = Console.readLine();

            try {
                Integer.parseInt(temporaryString); // NumberFormatException POSSIBLE.
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }

            int userNumber = Integer.parseInt(temporaryString);
            int expotential = 2;
            if (userNumber < 100 || userNumber > 999) {
                throw new IllegalArgumentException(); // Out of Range Exception.
            }

            while (expotential >= 0) {
                int divisor = (int) Math.pow(10, expotential);
                int partialNumber = userNumber / divisor;
                if (partialNumber == 0) {
                    throw new IllegalArgumentException(); // Zero is inputted.
                }
                if (userNumbers.contains(partialNumber)) {
                    throw new IllegalArgumentException(); // Duplicated Values.
                }
                userNumbers.add(partialNumber);
                userNumber = userNumber % divisor;
                expotential -= 1;
            }

        }
        return userNumbers;
    }

    private static Integer[] checkAnswer(List<Integer> computer, List<Integer> user) {
        Integer[] returnList = {0, 0};
        for (int i = 0; i < computer.size(); i++) {
            int computerNumber = computer.get(i);
            int userNumber = user.get(i);
            if (computerNumber == userNumber) {
                returnList[0] += 1;
            } else if (user.contains(computerNumber)) {
                returnList[1] += 1;
            }
        }
        return returnList;
    }

    private static void printUserTrial(int strikes, int balls) {
        String strikesString = (strikes > 0) ? String.valueOf(strikes).concat("스트라이크") : "";
        String ballsString = (balls > 0) ? String.valueOf(balls).concat("볼 ") : "";
        if (strikesString.isEmpty() && ballsString.isEmpty()) {
            System.out.println(NOTHING_MESSAGE);
        } else {
            System.out.println(ballsString + strikesString);
        }
    }
}
