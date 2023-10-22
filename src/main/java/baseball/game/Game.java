package baseball.game;

import java.util.List;
import static baseball.constvalue.ConstValue.*;

public class Game {
    private Computer computer = new Computer();
    private User user = new User();
    private InputValue input = new InputValue();
    private Score score = new Score();

    public Game(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void play(){
        computer.generateNewNumbers();
        boolean againGame = true;

        while (againGame) {
            getUserAnswer();
            compareAnswer();
            if (score.isThreeStrike()){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                againGame = restart();
            }
            score.resetScore();
        }
    }

    public void getUserAnswer(){
        System.out.print("숫자를 입력해주세요 : ");
        user.setNumbers(input.getUserNumbers());
        System.out.println();
    }

    public void compareAnswer(){
        List<Integer> com = computer.getNumbers();
        List<Integer> usr = user.getNumbers();

        for (int i=0;i<NUMBER_LENGTH;i++){
            if(usr.get(i).equals(com.get(i))) {
                score.addStrike();
            } else if(com.contains(usr.get(i))){
                score.addBall();
            }
        }

        score.printResult();
    }

    public boolean restart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        boolean userRestart = input.isGameRestart();

        if (userRestart){
            computer.generateNewNumbers();
        }

        return userRestart;
    }


}
