package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Application {
    static int strikeCnt = 0;
    static int ballCnt = 0;
    static String choice = "1";

    public String setRandomDistinctNumbers() {
        int number = Randoms.pickNumberInRange(1, 9);
        return String.valueOf(number);
    }

    public String startGame() {
        return "숫자 야구 게임을 시작합니다.";
    }
    //TODO : 리팩토링 메소드 명 변경
    //TODO : convertToList 메소드 만들기
    public int compareDigitsNumbers(String answer, String input) {
        int strikeCnt = 0;
        checkInputValidation(input);

        List<String> answerList = new ArrayList<>();
        List<String> inputList = new ArrayList<>();

        for(int i = 0; i<3; i++){
            answerList.add(Arrays.toString(answer.split("")));
            inputList.add(Arrays.toString(input.split("")));
        }

        for(int i = 0; i<3; i++) {
            if (answerList.get(i).equals(inputList.get(i))) {
                strikeCnt++;
            }
        }
        return strikeCnt;
    }
    public int countCommonNumbers(String answer, String input) {
        int ballCnt = 0;
        checkInputValidation(input);

        List<String> answerList = new ArrayList<>();
        List<String> inputList = new ArrayList<>();

        for(int i = 0; i<3; i++){
            answerList.add(Arrays.toString(answer.split("")));
            inputList.add(Arrays.toString(input.split("")));
        }

        List<String> matchList = inputList.stream().filter(n -> answerList.stream()
                .anyMatch(Predicate.isEqual(n))).collect(Collectors.toList());
        if (matchList.isEmpty()) {
            ballCnt = 0;
        } else {
            ballCnt = matchList.size();
        }
        return ballCnt;
    }

    public String showBaseballOutcome(String answer, String input) {
        strikeCnt = compareDigitsNumbers(answer, input);
        ballCnt = countCommonNumbers(answer, input);

        if (strikeCnt == 0) {
            if(ballCnt == 0){
                return "낫싱";
            }
            return ballCnt + "볼";
        }
        ballCnt -= strikeCnt;
        if (ballCnt == 0) {
            return strikeCnt + "스트라이크";
        } else {
            return ballCnt + "볼 " + strikeCnt + "스트라이크";
        }
    }

    public  String confirmGameEnd() {
        String choice = Console.readLine();
        checkExitChoiceValidation(choice);

        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        return choice;
    }
    public void checkInputValidation(String input) {
        if (input == null || input.isEmpty() || !input.matches("\\d{3}")) {
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
    public void checkExitChoiceValidation(String input) {
        if(input != "1" || input != "2") {
            throw new IllegalArgumentException();
        }
    }
    public static void main(String[] args) {
        Application application = new Application();
        application.startGame();

        while (choice.equals("1")) {
            String answer = application.setRandomDistinctNumbers();
            String input = Console.readLine();

            while(!input.equals(answer)) {
                System.out.println("숫자를 입력해주세요 : ");
                input = Console.readLine();
                application.showBaseballOutcome(answer, input);
            }
            application.confirmGameEnd();
            choice = Console.readLine();
        }

    }
}
