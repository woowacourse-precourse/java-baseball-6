package baseball.controller;

import baseball.model.Computer;
import baseball.model.Score;
import baseball.model.User;
import baseball.utils.ValidationCheckUtils;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseballGame {

    private Computer computer;
    private Score score;
    private User user;
    private View view;
    private ValidationCheckUtils validationCheckUtils;


    public BaseballGame(){
        this.score = new Score();
        this.view = new View();
        this.validationCheckUtils = new ValidationCheckUtils();
    }


    public void start(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true){
            this.computer = new Computer();
            play();
            if (replay()==2){
                break;
            }
        }
    }

    public void play(){
        while (true){
            System.out.print("숫자를 입력해주세요 : ");
            String inputUserNumbers = Console.readLine();
            System.out.println(inputUserNumbers);
            this.user =new User(inputUserNumbers);

            try {

                isValidInput(inputUserNumbers);

                List<Integer> userNumbers = user.getUserNumbers();
                List<Integer> computerNumbers = computer.getComputerNumbers();
                int[] resultScore = score.getResultScore(userNumbers, computerNumbers);
                int strike = resultScore[0];
                int ball = resultScore[1];

                if (strike==3){
                    view.displayOnlyStrikeResult(resultScore);
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
                if (strike >0 && ball > 0){
                    view.displayBothResult(resultScore);
                }
                if (strike==0 && ball>0){
                    view.displayOnlyBallResult(resultScore);
                }
                if (strike ==0 && ball==0){
                    view.displayNothingResult();
                }
            }
            catch (IllegalArgumentException e){

                throw e;

            }


        }


    }

    private void isValidInput(String inputUserNumbers) {
        if (!validationCheckUtils.validateNumericFormat(inputUserNumbers)|| !validationCheckUtils.validateUserNumber(inputUserNumbers)
                ||!validationCheckUtils.validateValidValue(inputUserNumbers) || !validationCheckUtils.validateDuplicate(inputUserNumbers)){
            throw new IllegalArgumentException();
        }
    }


    public int replay(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        String st = Console.readLine();
        System.out.println(st);
        return validationCheckUtils.validateReplayCheck(st);
    }
}
