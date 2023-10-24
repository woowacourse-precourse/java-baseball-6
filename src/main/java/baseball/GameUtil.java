package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;

public class GameUtil {
    String answer;
    String userInput;

    public GameUtil() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void settingGame() {
        this.answer = makeAnswer();
    }

    private String makeAnswer() {
        ArrayList<Integer> numberList = new ArrayList<>();
        while (numberList.size() < 3){
            int randomValue = Randoms.pickNumberInRange(1, 9);
            if (!numberList.contains(randomValue)) numberList.add(randomValue);
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            answer.append(numberList.get(i));
        }
        return answer.toString();
    }

    public void receiveUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        this.userInput = Console.readLine();

        validateInput(this.userInput);
    }

    private void validateInput(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException();
        }
        else {
            HashMap<Character, Integer> countChar = new HashMap<>();
            for (int i = 0; i < 3; i++) {
                if (countChar.containsKey(userInput.charAt(i)) || userInput.charAt(i) == '0') {
                    throw new IllegalArgumentException();
                } else {
                    countChar.put(userInput.charAt(i), 1);
                }
            }
        }
    }

    public Boolean compareUserInputWithAnswer() {
        Integer ballCount = findBall(this.userInput, this.answer);
        Integer strikeCount = findStrike(this.userInput, this.answer);

        String comment = "낫싱";

        if (ballCount == 0 && strikeCount > 0) {
            comment = String.format("%d스트라이크", strikeCount);
        } else if (ballCount > 0 && strikeCount == 0) {
            comment = String.format("%d볼", ballCount);
        } else if (ballCount > 0 && strikeCount > 0){
            comment = String.format("%d볼 %d스트라이크", ballCount, strikeCount);
        }

        System.out.println(comment);
        return strikeCount == 3;
    }

    private Integer findBall(String userInput, String answer) {
        int ballCount = 0;

        for (int i = 0; i < 3; i++) {
            if (userInput.charAt(i) != answer.charAt(i) && answer.indexOf(userInput.charAt(i)) != -1) ballCount += 1;
        }

        return ballCount;
    }

    private Integer findStrike(String userInput, String answer) {
        int strikeCount = 0;

        for (int i = 0; i < 3; i++) {
            if (userInput.charAt(i) == answer.charAt(i)) {
                strikeCount += 1;
            }
        }

        return strikeCount;
    }

    public Boolean checkIsContinue() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String userInput = Console.readLine();
        return (userInput.equals("1"));
    }
}
