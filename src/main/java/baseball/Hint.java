package baseball;
import static camp.nextstep.edu.missionutils.Console.readLine;
public class Hint {
    static final int FINISH = 1;
    int strike = 0;
    int ball = 0;
    int end = 0;
    int[] answer = new int[Game.NUMBER];
    int[] userInput = new int[Game.NUMBER];

    void compareAnswers(int[] answer, int[] userInput){
        for(int i = 0; i < Game.NUMBER; i++){
            for(int j = 0; j < Game.NUMBER; j++){
                if (userInput[i] == answer[j]){
                    if (i == j) strike++;
                    else ball++;
                }
            }
        }
        printHint();
    }

    void printHint(){
        if(ball == 0 && strike == 0) System.out.println("낫싱");
        if(ball == 0 && strike != 0) System.out.println(strike + "스트라이크");
        if(ball != 0 && strike == 0) System.out.println(ball + "볼");
        if(ball != 0 && strike != 0) System.out.println(ball + "볼 " + strike + "스트라이크");

        if(strike == Game.NUMBER) end = FINISH;
    }

    void init(){
        strike = 0;
        ball = 0;
        end = 0;
    }
}
