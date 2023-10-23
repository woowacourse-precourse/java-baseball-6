package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public String setRandomDistinctNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        StringBuilder number = new StringBuilder();
        for(int num : computer) {
            number.append(num);
        }
        return number.toString();
    }

    public String startGame() {
        return "숫자 야구 게임을 시작합니다.";
    }

    public List<Character> convertToList(String str) {
        List<Character> list = new ArrayList<>();
        for(int i = 0; i<str.length(); i++){
            list.add(str.charAt(i));
        }
        return list;
    }
    public int countStrike(String answer, String input) {
        int strikeCnt = 0;

        List<Character> answerList = convertToList(answer);
        List<Character> inputList = convertToList(input);

        for(int i = 0; i<3; i++) {
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

        for(int i = 0; i<3; i++) {
            for(int j = 0; j<3; j++) {
                if(answerList.get(i).equals(inputList.get(j))) {
                    ballCnt++;
                }
            }
        }

        return ballCnt;
    }

    public String showBaseballOutcome(String answer, String input) {
        System.out.println("숫자를 입력해주세요 : ");
        checkInputValidation(input);
        int strikeCnt = countStrike(answer, input);
        int ballCnt = countBall(answer, input);

        if (strikeCnt == 0) {
            if(ballCnt == 0){
                return "낫싱";
            }
            return ballCnt + "볼";
        }
        ballCnt -= strikeCnt;
        if (ballCnt == 0) {
            if(strikeCnt == 3){
                return "3스트라이크"+"3개의 숫자를 모두 맞히셨습니다! 게임 종료";
            }else{
                return strikeCnt + "스트라이크";
            }
        } else {
            return ballCnt + "볼 " + strikeCnt + "스트라이크";
        }
    }

    public void confirmGameEnd(String choice, String answer, String input) {

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        switch (choice){
            case "1" ->{showBaseballOutcome(answer,input); }
            case "2" ->{break;}
            default -> {checkExitChoiceValidation();}
        }
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
    public void checkExitChoiceValidation() {
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.startGame();
        String answer = application.setRandomDistinctNumbers();
        String input = Console.readLine();
        application.showBaseballOutcome(answer, input);

    }
}
