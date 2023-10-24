package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    static boolean onOff = true;

    public String setRandomDistinctNumbers() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        StringBuilder number = new StringBuilder();

        for (int num : computer) {
            number.append(num);
        }

        return number.toString();
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public List<Character> convertToList(String str) {
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < str.length(); i++){
            list.add(str.charAt(i));
        }

        return list;
    }

    public int countStrike(String answer, String input) {
        int strikeCnt = 0;
        List<Character> answerList = convertToList(answer);
        List<Character> inputList = convertToList(input);

        for (int i = 0; i < 3; i++) {
            if (answerList.get(i).equals(inputList.get(i))) {
                strikeCnt++;
            }
        }

        return strikeCnt;
    }

    public int countBall(String answer, String input) {
        int ballCnt = 0;
        List<Character> answerList = convertToList(answer);
        List<Character> inputList = convertToList(input);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (answerList.get(i).equals(inputList.get(j))) {
                    ballCnt++;
                }
            }
        }

        return ballCnt;
    }

    public void checkInputValidation(String input) {

        if (input == null || input.length() != 3 || !input.matches("\\d+")) {
            throw new IllegalArgumentException();
        }

        char[] digits = input.toCharArray();

        for (int i = 0; i < digits.length - 1; i++) {
            for (int j = i + 1; j < digits.length; j++) {
                if (digits[i] == digits[j]) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    public void showBaseballOutcome(String answer, String input) {
        checkInputValidation(input);
        int strikeCnt = countStrike(answer, input);
        int ballCnt = countBall(answer, input) - strikeCnt;

        if (strikeCnt == 0 && ballCnt == 0) {
            System.out.println("낫싱");
        } else if (strikeCnt == 0) {
            System.out.println(ballCnt + "볼");
        } else if (ballCnt == 0) {
            if (strikeCnt == 3){
                onOff = false;
                System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            } else{
                System.out.println(strikeCnt + "스트라이크");
            }
        } else {
            System.out.println(ballCnt + "볼 " + strikeCnt + "스트라이크");
        }
    }

    public void checkExitChoiceValidation(String input) {
        if(!input.equals("1") && !input.equals("2") ) {
            throw new IllegalArgumentException();
        }
    }

    public void confirmGameEnd(String choice) {
        switch (choice) {
            case "1" -> onOff = true;
            case "2" -> onOff = false;
            default -> checkExitChoiceValidation(choice);
        }
    }

    public void playNumberBaseballGame() {
        while (onOff) {
            String answer = setRandomDistinctNumbers();

            while (onOff) {
                System.out.println("숫자를 입력해주세요 : ");
                String input = Console.readLine();
                showBaseballOutcome(answer, input);
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String choice = Console.readLine();
            confirmGameEnd(choice);
        }
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.startGame();
        application.playNumberBaseballGame();
    }
}