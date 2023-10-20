package baseball.controller;

import baseball.domain.BaseballGame;
import baseball.domain.Computer;
import baseball.service.BaseballGameService;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;
import java.util.StringTokenizer;

public class BaseballGameController {

    private BaseballGameService baseballGameService;
    private Boolean RestartFlag=true;

    public BaseballGameController(){
        OutputView.printGameInitMessage();
    }


    public void gameStart(){
        String userNumber;
        baseballGameService = new BaseballGameService();

        do{
            InputView.printInputNumberMessage();
            userNumber = InputView.readUserNumberInput();
            validateUserNumber(userNumber);
            String [] results = baseballGameService.run(userNumber);

            if(!results[0].equals("0") && results[1].equals("0")){
                OutputView.printOnlyBallCountMessage(results[0]);
            }

            if(results[0].equals("0") && !results[1].equals("0")){
                OutputView.printOnlyStrikeCountMessage(results[1]);
            }

            if(!results[0].equals("0") && !results[1].equals("0")){
                OutputView.printBallAndStrikeCountMessage(results[0],results[1]);
            }

            if(results[0].equals("0") && results[1].equals("0")){
                OutputView.printNothingMessage();
            }

            if(results[1].equals("3")){
                OutputView.printAnswerMessage();
                OutputView.printRestartGameMessage();

                String Input = InputView.readRestartNumberInput();

                if(Input.equals("1")){
                    baseballGameService = new BaseballGameService();
                }
                if(Input.equals("2")){
                    RestartFlag = false;
                }
            }

        }while(RestartFlag);

    }
    public void validateUserNumber(String userNumber){
        if(userNumber.length()!=3) throw new IllegalArgumentException();

        for(int i = 0 ; i < userNumber.length(); i++){
            if(userNumber.charAt(i)-'0'<1||userNumber.charAt(i)-'0'>9){
                throw new IllegalArgumentException();
            }
        }

    }










}
