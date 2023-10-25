package baseball;

import baseball.io.ErrorHandler;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import baseball.io.Output;
import java.util.Objects;

public class PlayBall {
    private List<Integer> computer;
    private String userNumbers;
    private List<Integer> userNumbersList;
    private boolean gameOver;
    public void run(){
       computer = makeAnswer();
       Output.printAnswer(computer);
       System.out.println("숫자 야구 게임을 시작합니다.");
       while(!gameOver){
           System.out.print("숫자를 입력해주세요 : ");
           userNumbers = Console.readLine();
           System.out.println(userNumbers);
           userNumbersList = checkInput(userNumbers);
           gameResult(userNumbersList, computer);
       }
    }

    private List<Integer> makeAnswer() {
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> checkInput(String userNumbers){
        ErrorHandler.checkNumber(userNumbers);
        ErrorHandler.checkLength(userNumbers);
        ErrorHandler.checkRepeat(userNumbers);
        return Arrays.stream(userNumbers.split("")).mapToInt(Integer::parseInt).boxed().toList();
    }

    public void gameResult(List<Integer> userNumbers, List<Integer> answer) {
        int strike = 0;
        int ball = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <userNumbers.size(); i++) {
            if (Objects.equals(userNumbers.get(i), answer.get(i))){ // don't use == since it's not null-safe
                strike ++;
            } else if (answer.contains(userNumbers.get(i))) {
                ball ++;
            }
        }
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }
        else {
            if (ball>0){
                stringBuilder.append(ball).append("볼 ");
            }
            if (strike>0){
                stringBuilder.append(strike).append("스트라이크");
            }
        }
        System.out.println(stringBuilder);
        if (strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
                    + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int restartInput = Integer.parseInt(Console.readLine());
            ErrorHandler.checkRestart(restartInput);
            if (restartInput == 2){
                gameOver = true;
            }
            else{
                run();
            }
        }
    }
}