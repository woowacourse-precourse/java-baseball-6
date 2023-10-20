package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        String answer = generateRandomNumbers();
        boolean gameContinue = true;
        System.out.println("answer = " + answer);

        while (gameContinue) {
            System.out.println("숫자를 입력해주세요 : ");
            String guess = Console.readLine();
            String result = checkGuess(answer, guess);

            if(result.equals("")){
                System.out.println("낫싱");
            }
            else{
                System.out.println(result);
            }

            if (result.equals("3스트라이크 ")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                gameContinue = askContinue();
                if(gameContinue) answer = generateRandomNumbers();
            }
        }
    }

    private static boolean askContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String choice = Console.readLine();
        return "1".equals(choice);
    }

    private static String checkGuess(String answer, String guess) {
        int strike = 0, ball = 0;
        for (int i = 0; i < guess.length(); i++) {
            char current = guess.charAt(i);
            if (answer.charAt(i) == current) {
                strike++;
            } else if (answer.contains(String.valueOf(current))) {
                ball++;
            }
        }
        return (ball > 0 ? ball + "볼" : "")+(strike > 0 ? strike + "스트라이크" : "");
    }

    private static String generateRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(""));
    }
}
