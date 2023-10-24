package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int INPUT_LENGTH = 3;

    public static void main(String[] args) {

        List<Integer> computer = makeRandomNumber();
        int strikeCnt = 0;
        int ballCnt = 0;

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String inputNumStr = Console.readLine();

            validateInputLength(inputNumStr);

            List<Integer> users = parseAndAddInputsToList(inputNumStr);

            if (!computer.equals(users)) {
                strikeCnt = getStrikeCount(computer, users);
                ballCnt = getBallCount(computer, users);

                printBallCountAndStrikeCount(ballCnt, strikeCnt);
            } else {
                print3Strike();
                int start = isRestart();
                if(start == 1) {
                    computer = makeRandomNumber();
                } else if(start == 2) {
                    System.out.println("게임 종료");
                    Console.close();
                    break;
                }
            }
        }
    }

    private static List<Integer> makeRandomNumber() {
        List<Integer> randomList = new ArrayList<>();
        while (randomList.size() < INPUT_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomList.contains(randomNumber)) {
                randomList.add(randomNumber);
            }
        }
        return randomList;
    }

    private static void validateInputLength(String inputNumber) {
        if(inputNumber.length() != INPUT_LENGTH) {
            throw new IllegalArgumentException(INPUT_LENGTH + "자리를 입력해야 합니다.");
        } else if (!isNumeric(inputNumber)) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }

    private static boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static List<Integer> parseAndAddInputsToList(String inputNumber) {
        int inputNum = Integer.parseInt(inputNumber);

        List<Integer> user = new ArrayList<>();
        user.add(inputNum / 100);
        user.add((inputNum % 100) / 10);
        user.add(inputNum % 10);

        return user;
    }

    private static int getStrikeCount(List<Integer> computer, List<Integer> user) {
        int strikeCount = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i).equals(user.get(i))) {
                ++strikeCount;
            }
        }
        return strikeCount;
    }

    private static int getBallCount(List<Integer> computer, List<Integer> user) {
        int ballCount = 0;
        for (int i = 0; i < computer.size(); i++) {
            for (int j = 0; j < user.size(); j++) {
                if (computer.get(i).equals(user.get(j))) {
                    ++ballCount;
                    if (computer.get(i).equals(user.get(i))) {
                        --ballCount;
                    }
                }
            }
        }
        return ballCount;
    }

    private static void printBallCountAndStrikeCount(int ballCount, int strikeCount) {
        if (ballCount > 0 && strikeCount > 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        } else if (strikeCount > 0) {
            System.out.println(strikeCount + "스트라이크");
        } else if (ballCount > 0) {
            System.out.println(ballCount + "볼");
        } else {
            System.out.println("낫싱");
        }
    }

    private static void print3Strike() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static int isRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int start = Integer.parseInt(Console.readLine());
        return start;
    }
}
