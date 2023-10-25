package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static List<Integer> answer = new ArrayList<>();
    static List<Integer> playerAnswer = new ArrayList<>();
    static int strike = 0;
    static int ball = 0;
    public static void generateAnswer(){
    while (answer.size() < 3) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!answer.contains(randomNumber)) {
            answer.add(randomNumber);
            }
        }
    }
    public static void countBallAndStrike() {
        for (int i = 0; i < 3; i++) {
            if (answer.get(i).equals(playerAnswer.get(i))) {
                ++strike; // 스트라이크
            } else if (answer.contains(playerAnswer.get(i))) {
                ++ball; // 볼
            }
        }
    }
    public static void clearBallAndStrike(){
        strike = 0;
        ball = 0;
    }
    public static void newGameSetting(){
        clearBallAndStrike();
        answer.clear();
        playerAnswer.clear();
    }

    private static List<Integer> convertInputToNumberList(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            numbers.add(Character.getNumericValue(input.charAt(i)));
        }
        return numbers;
    }
    public static void validate(String input) throws IllegalArgumentException {
        //잘못된 입력 예외처리
        try {
            if (!(input.matches("^[1-9][0-9][0-9]$")
                    && input.charAt(0) != input.charAt(1)
                    && input.charAt(0) != input.charAt(2)
                    && input.charAt(1) != input.charAt(2))
                    ) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public static void showResult() {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    public static void gameStart() throws IllegalArgumentException{

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            newGameSetting();
            generateAnswer(); // 랜덤 숫자 생성
            while (true) {
                System.out.print("서로 다른 3자리 숫자를 입력하세요: ");
                String playerInput = Console.readLine();

                validate(playerInput);

                playerAnswer = convertInputToNumberList(playerInput);
                countBallAndStrike();
                showResult();
                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
                clearBallAndStrike();
            }
            String newGame;
            try {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                newGame = Console.readLine();
            } catch (RuntimeException e){
                throw new IllegalArgumentException();
            }
            if(newGame.equals("2"))
                break;
            else if(!newGame.equals("1"))
                throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        try{
            gameStart();
        } catch (IllegalArgumentException e){
            throw e;
        }
     }
}
