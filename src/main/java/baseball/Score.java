package baseball;

import baseball.number.Answer;
import baseball.number.UserInput;

import java.util.List;

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
        scoreArr[0] = checkStrike(userInput, answer);
        scoreArr[1] = checkBall(userInput, answer);
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

    private int checkStrike(UserInput userInput, Answer answer){
        int strikeNum = 0;
        if (userInput.get(0) == answer.get(0)) strikeNum++;
        if (userInput.get(1) == answer.get(1)) strikeNum++;
        if (userInput.get(2) == answer.get(2)) strikeNum++;
        return strikeNum;
    }

    private int checkBall(UserInput userInput, Answer answer) {
        int ballNum = 0;
        if (userInput.get(0) == answer.get(1) || answer.get(0) == userInput.get(2)) ballNum++;
        if (userInput.get(1) == answer.get(0) || answer.get(1) == userInput.get(2)) ballNum++;
        if (userInput.get(2) == answer.get(0) || answer.get(2) == userInput.get(1)) ballNum++;
        return ballNum;
    }
}
