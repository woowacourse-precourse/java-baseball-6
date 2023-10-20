package baseball;

public class OutputView {
    public void printStart(){
        System.out.print(ConstantView.START.getMessage());
    }

    public void printInputMessage(){
        System.out.print(ConstantView.INPUT.getMessage());
    }

    public void printEnd(){
        System.out.print(ConstantView.END.getMessage());
    }

    public void printResult(int strike, int ball){
        if (strike==3){
            System.out.println(strike+ConstantView.STRIKE.getMessage());
            return;
        }
        if (strike==0 && ball>0){
            System.out.println(ball+ConstantView.BALL.getMessage());
            return;
        }
        if (strike>0 && ball==0){
            System.out.println(strike+ConstantView.STRIKE.getMessage());
            return;
        }
        if (strike>0 && ball>0){
            System.out.println(ball+ConstantView.BALL.getMessage()
                    +" "+strike+ConstantView.STRIKE.getMessage());
            return;
        }
        System.out.println(ConstantView.NOTING.getMessage());
    }
}
