package baseball.view;


public class OutputView {
    public void printStartMessage(){
        System.out.print(GameMessage.GAME_START_MESSAGE.getMessage());
    }

    public void printInputMessage(){
        System.out.print(GameMessage.PROMPT_FOR_NUMBER.getMessage());
    }

    public void printEndMessage(){
        System.out.print(GameMessage.GAME_SUCCESS_MESSAGE.getMessage());
    }

    public void printRestartMessage(){
        System.out.print(GameMessage.RESTART_CHOICE_MESSAGE.getMessage());
    }

    public void printResultMessage(int strike, int ball){
        if (strike==3){
            System.out.println(strike+ GameMessage.STRIKE.getMessage());
            return;
        }
        if (strike==0 && ball>0){
            System.out.println(ball+ GameMessage.BALL.getMessage());
            return;
        }
        if (strike>0 && ball==0){
            System.out.println(strike+ GameMessage.STRIKE.getMessage());
            return;
        }
        if (strike>0 && ball>0){
            System.out.println(ball+ GameMessage.BALL.getMessage()
                    +" "+strike+ GameMessage.STRIKE.getMessage());
            return;
        }
        System.out.println(GameMessage.NOTING.getMessage());
    }
}
