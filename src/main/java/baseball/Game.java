package baseball;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Game {
    Integer ball;
    Integer strike;

    public Game(){
        this.ball = 0;
        this.strike = 0;
    }

    public void countBallAndStrike(List<Integer> user, List<Integer> computer){
        for(int i = 0; i < 3; i++){
            Integer number = user.get(i);
            if(computer.contains(number) && computer.indexOf(number) == i) {
                this.strike += 1;
            }
            if(computer.contains(number) && computer.indexOf(number) != i) {
                this.ball += 1;
            }
        }
    }

    public void printBallAndStrike(){
        if(ball == 0 && strike == 0){
            Print.printString("낫싱");
        }
        if (ball != 0 && strike == 0) {
            Print.printString(ball + "볼");
        }
        if (ball == 0 && strike != 0){
            Print.printString(strike + "스트라이크");
        }
        if (ball != 0 && strike != 0){
            Print.printString(ball + "볼" + " " + strike + "스트라이크");

        }
    }

    public void printGameOver(){
        Print.printString("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        Print.printString("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
    public String gameRestartInput() throws IllegalArgumentException{
        try{
            String input = Console.readLine();
            validateInput(input);
            return input;
        } catch (IllegalArgumentException e){
            throw e;
        }

    }
    public void validateInput(String input) throws IllegalArgumentException{
        if(!input.equals("1") && !input.equals("2")){
            throw new IllegalArgumentException();
        }
    }
}
