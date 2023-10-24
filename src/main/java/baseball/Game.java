package baseball;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    private final Player player;
    private final Rule rule;
    private Computer computer;
    private List<Integer> computerNums;
    private boolean isFirst = false;

    public Game(){
        player = new Player();
        rule = new Rule();
        computer = new Computer();
    }

    public void init(){
        computerNums = computer.load();
        isFirst = true;
    }

    public void run() {
        startMessage();
        while(true){
            init();

            while(!play()){
                inputMessage();
            }

            if(!isRetry()){
                break;
            }
        }
    }

    public boolean play(){
        if(isFirst){
            isFirst = false;
            return false;
        }

        rule.checkPlayerGuess(computerNums, player.parseNumbers(readLine()));
        int ball = rule.getBall();
        int strike = rule.getStrike();

        boolean isGameEnded = (strike == 3);
        if(isGameEnded){
            finishMessage();
            return true;
        }

        printScoreMessage(ball, strike);
        return false;
    }

    private void printScoreMessage(int ball, int strike){
        if(ball != 0 && strike == 0){
            System.out.println(ball + "볼");
        }

        if(ball == 0 && strike != 0){
            System.out.println(strike + "스트라이크");
        }

        if(ball != 0 && strike != 0){
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }

        if(ball == 0 && strike == 0){
            System.out.println("낫싱");
        }
    }

    private void startMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void inputMessage(){
        System.out.print("숫자를 입력해주세요 : ");
    }

    private void finishMessage(){
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private void retryMessage(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private boolean isRetry(){
        retryMessage();
        String isRestartGame = readLine();
        return isRestartGame.equals("1") ? true : false;
    }

}
