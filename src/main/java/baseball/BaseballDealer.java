package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseballDealer {
    public static final String STRIKE = "strike";
    public static final String BALL = "ball";
    public static final String NOTHING = "nothing";
    private static final int rangeStart = 1;
    private static final int rangeEnd = 9;
    private static final int baseballLength = 3;

    public void runGame() {
        List<Integer> answer = this.createNewBaseball();
        boolean isCorrect = false;
        while (!isCorrect) {
            System.out.println("숫자를 입력해주세요");
            String userInput = Console.readLine();
            this.checkIsValidInput(userInput);
            Map<String, Integer> judged = this.judgeInput(userInput, answer);
            System.out.println(this.generateJudgeComment(judged));
            if (judged.get(BaseballDealer.STRIKE) == baseballLength) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                isCorrect = true;
            }
        }
    }

    private List<Integer> createNewBaseball() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < baseballLength) {
            int randomNumber = Randoms.pickNumberInRange(rangeStart, rangeEnd);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private void checkIsValidInput(String userInput) {
        char[] userInputs = userInput.toCharArray();
        if (userInputs.length != baseballLength || userInputs[0] == userInputs[1] || userInputs[0] == userInputs[2] || userInputs[1] == userInputs[2]) {
            throw new IllegalArgumentException();
        }
    }

    private Map<String, Integer> judgeInput(String userInput, List<Integer> answer) {
        Map<String, Integer> result = new HashMap<>();
        result.put(STRIKE, 0);
        result.put(BALL, 0);
        result.put(NOTHING, 0);

        char[] userInputs = userInput.toCharArray();
        for (int i = 0; i < userInputs.length; i++) {
            int num = Integer.parseInt(String.valueOf(userInputs[i]));
            int idx = answer.indexOf(num);
            if (idx == i) {
                result.replace(STRIKE, result.get(STRIKE) + 1);
            } else if (idx != -1) {
                result.replace(BALL, result.get(BALL) + 1);
            } else {
                result.replace(NOTHING, result.get(NOTHING) + 1);
            }
        }

        return result;
    }

    private String generateJudgeComment(Map<String, Integer> judged) {
        StringBuilder comment = new StringBuilder();
        if (judged.get(BALL) > 0) {
            comment.append(judged.get(BALL));
            comment.append("볼 ");
        }
        if (judged.get(STRIKE) > 0) {
            comment.append(judged.get(STRIKE));
            comment.append("스트라이크 ");
        }
        if (judged.get(NOTHING) == baseballLength) {
            comment.append("낫싱");
        }
        return comment.toString();
    }

}
