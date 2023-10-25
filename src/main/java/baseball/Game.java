package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    private final Computer computer;
    private final Player player;
    int strike;
    int ball;
    boolean EXIT = false;

    public Game(){
        computer = new Computer();
        player = new Player();
    }

    public void run(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer.createComputerNum();
        while(!EXIT){
            resetResult();
            player.createUserNum();
            checkPlayerNumber();

            printResult();
            isAnswer();
        }
    }

    public void isAnswer(){
        if(strike == 3){
            System.out.println("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            checkRestart();
        }
    }

    public void checkRestart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if(!input.equals("1") && !input.equals("2")){
            throw new IllegalArgumentException("1이나 2만 입력할 수 있습니다.");
        }
        if(input.equals("1")){
            computer.createComputerNum();
        }
        if(input.equals("2")){
            EXIT = true;
        }
    }
    public void resetResult(){
        ball = 0;
        strike = 0;
    }

    public void checkPlayerNumber(){
        for(int i = 0; i < 3; i++){
            if(checkIfStrike(i)){
                strike++;
            }
            if(checkIfBall(i)){
                ball++;
            }
        }
    }

    private boolean checkIfStrike(int numIdx){
        return computer.getComputerNum().get(numIdx).equals(player.getUserNum().get(numIdx));
    }

    private boolean checkIfBall(int numIdx){
        return !checkIfStrike(numIdx) && computer.getComputerNum().contains(player.getUserNum().get(numIdx));
    }

    public void printResult(){
        StringBuilder sb = new StringBuilder();
        if (ball != 0) {
            sb.append(ball).append("볼 ");
        }
        if (strike != 0) {
            sb.append(strike).append("스트라이크");
        }
        if(ball == 0 && strike == 0){
            sb.append("낫싱");
        }
        System.out.println(sb);
    }
}
