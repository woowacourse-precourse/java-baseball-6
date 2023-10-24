package baseball.view;

import baseball.constant.message.OutputMessage;

public class OutputView {
    public void printInitialMessage(){
        System.out.println(OutputMessage.INITIAL_MESSAGE);
    }

    public void printInputNumberInfoMessage(){
        System.out.print(OutputMessage.INPUT_NUMBER_INFO_MESSAGE);
    }

    public void printResultMessage(int strike, int ball){
        if(strike==0 && ball==0){
            System.out.println(OutputMessage.NOTHING_RESULT_MESSAGE);
        } else if (strike == 0) {
            System.out.println(ball+OutputMessage.BALL_RESULT_MESSAGE);

        } else if (ball ==0) {
            System.out.println(strike+OutputMessage.STRIKE_RESULT_MESSAGE);
        }
        else{
            System.out.println(ball+OutputMessage.BALL_RESULT_MESSAGE+" "+strike+OutputMessage.STRIKE_RESULT_MESSAGE);
        }

    }

    public void printClosingMessage(){
        System.out.println(OutputMessage.CLOSING_MESSAGE);
    }

    public void printChoiceNumberInfoMessage(){
        System.out.println(OutputMessage.CHOICE_NUMBER_INFO_MESSAGE);
    }
}
