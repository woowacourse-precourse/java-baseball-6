package baseball;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Game {
    private static final int CODE_LENGTH = 3;
    private static final String NEW_GAME = "1";
    private static final String END_GAME = "2";

    public boolean PlayGame(List<Integer> numbers) {
            while(true) {
                int strike = 0;
                int ball = 0;
                System.out.print("숫자를 입력해주세요 : ");
                String chooseNumbers = Console.readLine();

                ValidationNumbers(chooseNumbers);

                Result result = calculateStrikeAndBall(numbers, chooseNumbers, strike, ball);

                countStrikesAndBalls(result.strike(), result.ball());

                if(result.strike() == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    String choose = Console.readLine();
                    if(choose.equals(NEW_GAME)){
                        return true;
                    }
                    else if (choose.equals(END_GAME)) {
                        return false;
                    }
                }
            }
    }

    private static Result calculateStrikeAndBall(List<Integer> numbers, String chooseNumbers, int strike, int ball) {
        for (int i = 0; i < numbers.size(); i++) {
            int userNumber = Integer.parseInt(String.valueOf(chooseNumbers.charAt(i)));
            int targetNumber = numbers.get(i);

            if (userNumber == targetNumber) {
                strike += 1;
            } else if (numbers.contains(userNumber)) {
                ball += 1;
            }
        }
        return new Result(strike, ball);
    }

    private record Result(int strike, int ball) {
    }

    private static void countStrikesAndBalls(int strike, int ball) {
        if(strike == 0 && ball == 0){
            System.out.println("낫싱");
        }
        if(ball > 0 && strike == 0){
            System.out.println(ball +"볼");
        }
        if(strike > 0 && ball == 0){
            System.out.println(strike +"스트라이크");
        }
        if(ball > 0 && strike > 0) {
            System.out.println(ball +"볼 "+ strike +"스트라이크");
        }
    }

    private void ValidationNumbers(String chooseNumbers) {
        if(chooseNumbers.length() != CODE_LENGTH) {
            throw new IllegalArgumentException("세가지 숫자가 아님!");
        }
    }
}
