package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Game {

    private Constant constant;
    private Messages messages;

    public void run(){
        while(true){
            play();
            System.out.println(messages.EXIT_MESSAGE);
            int input = Integer.parseInt(Console.readLine());
            if(input == constant.RESTART_NUM) continue;
            else if(input == constant.EXIT_NUM) break;
        }
    }

    private void play(){
        Computer computer = new Computer();
        Player player = new Player();

        List<Integer> answer = computer.Computer();
        List<Integer> user = player.input();
        while(true){
            BallCount ballCount = computer.calBallCount(answer, user);
            System.out.println(Messages.hintMessage(ballCount));

            int strike = ballCount.getStrike();
            if(strike==3) {
                System.out.println(Messages.CORRECT_MESSAGE);
                break;
            }
            user = player.input();
        }
    }

}
