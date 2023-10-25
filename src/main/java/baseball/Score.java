package baseball;

import baseball.number.Answer;
import baseball.number.UserInput;

public class Score {

    Answer answer;
    UserInput userInput;

    Baseball baseball = new Baseball();

    int[] scoreArr = new int[2];

    public Score(Answer answer, UserInput userInput){
        this.answer = answer;
        this.userInput = userInput;
    }

    public int[] checkScore(UserInput userInput){
        scoreArr[0] = userInput.checkStrike(answer.getAnswer());
        scoreArr[1] = userInput.checkBall(answer.getAnswer());
        return scoreArr;
    }

    public boolean printScore(int[] scoreArr) {
        if(scoreArr[0]==3) {
            System.out.print("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! ");
            baseball.gameover();
            return true;
        }
        if(scoreArr[0]==0 && scoreArr[1]==0){
            System.out.print("낫싱");
        }
        if(scoreArr[1]!=0){
            System.out.print(scoreArr[1]+"볼 ");
        }
        if(scoreArr[0]!=0){
            System.out.print(scoreArr[0]+"스트라이크");
        }
        System.out.println();
        return false;
    }
}
