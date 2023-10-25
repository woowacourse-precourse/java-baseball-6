package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    private record Data(boolean result, String message) {
    }
    public static void main(String[] args) {

        List<Integer> randomGameNumbers = getRandomGameNumber();


        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true) {
            //게임 준비
            List<Integer> inputNumbers;

            try {
                inputNumbers = inputNum();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("잘못된 입력으로 프로그램을 종료합니다.");
                throw new IllegalArgumentException();
            }

            Data win = checkGameResult(randomGameNumbers, inputNumbers);
            System.out.println(win.message);

            //게임에서 이겼을 때 통과하는 로직
            if (win.result()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                try {
                    boolean restart = inputAndRestart(randomGameNumbers);

                    if (!restart)
                        break;

                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    System.out.println("잘못된 입력으로 프로그램을 종료합니다.");
                    throw new IllegalArgumentException();
                }
            }

        }

    }

    /**
     * 3자리 게임 난수 생성기
     * @return List<Integer>
     */
    private static List<Integer> getRandomGameNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    /**
     * 3자리 입력 검사, 0~9까지의 자연수 입력 검사 진행, 검사 통과 시 3자리 자연수 리턴
     * @return readStr
     * @throws IllegalArgumentException
     */
    private static List<Integer> inputNum() throws IllegalArgumentException{
        System.out.print("숫자를 입력해주세요 : ");

        String readStr = readLine();

        if (readStr.length() != 3)
            throw new IllegalArgumentException("3자리를 입력해주세요");

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < readStr.length(); i++) {
            char c = readStr.charAt(i);
            if (c < '1' || c > '9')
                throw new IllegalArgumentException("1~9까지의 자연수를 입력해주세요");

            int digit = Character.getNumericValue(c);
            numbers.add(digit);
        }

        return numbers;
    }

    private static Data checkGameResult(List<Integer> sysNum, List<Integer> userGuess) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            if (sysNum.get(i).equals(userGuess.get(i))) {
                strike++;
            } else if (sysNum.contains(userGuess.get(i))) {
                ball++;
            }
        }

        return createGameData(ball, strike);
    }

    private static Data createGameData(int ball, int strike) {

        if (strike == 3) {
            return new Data(true, "3스트라이크");
        }
        if (ball == 0 && strike == 0) {
            return new Data(false, "낫싱");
        }

        List<String> resultMessages = new ArrayList<>();
        if (ball > 0) {
            resultMessages.add(ball + "볼");
        }

        if (strike > 0) {
            resultMessages.add(strike + "스트라이크");
        }


        return new Data(false, String.join(" ", resultMessages));
    }


    private static boolean inputAndRestart(List<Integer> randomGameNumbers) throws IllegalArgumentException{
        String userInput = readLine();

        if (!(userInput.equals("1") || userInput.equals("2"))) {
            throw new IllegalArgumentException("숫자 1과 2를 입력하셔야 합니다.");
        }

        if (userInput.equals("2")) {
            return false;
        }

        randomGameNumbers.clear();
        randomGameNumbers.addAll(getRandomGameNumber());

        return true;
    }
}
