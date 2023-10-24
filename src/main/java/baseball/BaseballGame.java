package baseball;


import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class BaseballGame {
    private boolean isExitFlag = false;
    private static final int DIGIT = 3;
    private static final String BALL_PRINT = "볼 ";
    private static final String STRIKE_PRINT = "스트라이크 ";
    private static final String NOTHING_PRINT = "낫싱";

    private static final String RESTART_OR_EXIT_PRINT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static final String RESTART_PRINT = "1";
    private static final String THREE_STRIKE_PRINT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private List<Integer> computerNumber = new ArrayList<>();
    private List<Integer> userNumber = new ArrayList<>();

    SetNumber number = new SetNumber();


    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computerNumber = number.setRandomNumbers();
        while (!isExitFlag) {
            userNumber = number.setUserNumber();
            printHint(computerNumber, userNumber);
        }
    }


    private void setRestartOrExit(){
        String input = inputRestartOrExit();
        if(input.equals(RESTART_PRINT)){
            computerNumber = number.setRandomNumbers();
            return;
        }
        isExitFlag = true;
    }

    private String inputRestartOrExit(){
        System.out.println(RESTART_OR_EXIT_PRINT);
        String input = Console.readLine();
        if(!isCorrectAnswer(input)){
            throw new IllegalArgumentException();
        }
        return input;
    }

    // 문자열이 1인지 2인지를 나타내는 패턴
    private boolean isCorrectAnswer(String input){
        Pattern pattern = Pattern.compile(("[1-2]"));
        return pattern.matcher(input).matches(); // 입력된 문자열이 정규 표현식과 일치하는지 결과 반환
    }

    private void printHint(List<Integer> answer, List<Integer> input) {
        int strike = countStrike(answer, input);
        int ball = countBall(answer, input);

        System.out.println(determineHint(strike, ball));
        if (strike == DIGIT) {
            System.out.println(THREE_STRIKE_PRINT);
            setRestartOrExit();

        }
    }

    private String determineHint(int strike, int ball){
        StringBuilder sb = new StringBuilder();
        if(strike != 0){
            if(ball != 0){
                sb.append(ball).append(BALL_PRINT).append(strike).append(STRIKE_PRINT).append("\n");
                return sb.toString();
            }
            sb.append(strike).append(STRIKE_PRINT);
            return sb.toString();
        }

        if(ball != 0){
            sb.append(ball).append(BALL_PRINT);
            return sb.toString();
        }
        sb.append(NOTHING_PRINT);
        return sb.toString();
    }

    private int countStrike(List<Integer> answer, List<Integer> input) {
        int count = 0;
        for (int index = 0; index < answer.size(); index++) {
            if (answer.get(index).equals(input.get(index))) {
                count++;
            }
        }
        return count;
    }

    private int countBall(List<Integer> answer, List<Integer> input) {
        int count = 0;
        for (int index = 0; index < answer.size(); index++) {
            if (!answer.get(index).equals(input.get(index)) && input.contains(answer.get(index))) {
                count++;
            }
        }
        return count;
    }


}

