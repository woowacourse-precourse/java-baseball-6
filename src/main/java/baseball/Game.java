package baseball;


public class Game {

    private int ball;
    private int strike;

    private RandomNumber randomNumber;
    private AnswerNumber answerNumber;

    public void run(){
        randomNumber = new RandomNumber();
        while(!isAllSameNumber()){
            getAnswerNumber();
            compareNumber();
            printResult();
        }

    }
    public void getAnswerNumber(){
        answerNumber = new AnswerNumber(View.inputNumber());
    }


    public void countBall(String randomNumber, String answerNumber){
        int ball = 0;
        for(int i = 0;i<3;i++){
            if(answerNumber.contains(Character.toString(randomNumber.charAt(i)))) ball++;
        }
        this.ball= ball;
    }
    public void countStrike(String randomNumber, String answerNumber){
        int strike = 0;
        for(int i = 0;i<3;i++){
            if(answerNumber.charAt(i)==randomNumber.charAt(i)) strike++;
        }
        this.strike= strike;
        this.ball-=strike;
    }

    public void compareNumber(){
        countBall(randomNumber.getRandomNumber(), answerNumber.getAnswerNumber());
        countStrike(randomNumber.getRandomNumber(), answerNumber.getAnswerNumber());
    }

    public void printResult(){
        if(ball!=0) System.out.print(ball+View.printBall()+" ");
        if(strike!=0) System.out.print(strike+View.printStrike());
        if(ball==0&&strike==0) System.out.print(View.printNothing());
        System.out.println();

    }

    public boolean isAllSameNumber(){
        if(strike==3) {
            View.printEndMessage();
            return true;
        }
        return false;
    }



}
