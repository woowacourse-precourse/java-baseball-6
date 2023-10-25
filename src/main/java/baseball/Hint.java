package baseball;
import static camp.nextstep.edu.missionutils.Console.readLine;
public class Hint {
    int strike = 0;
    int ball = 0;
    int end = 0;
    int[] answer = new int[3];
    int[] userInput = new int[3];

    void compareAnswers(int[] answer, int[] userInput){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if (userInput[i] == answer[j]){
                    if (i == j) strike++;
                    else ball++;
                }
            }
        }
        printHint();
    }

    void printHint(){
        if(ball==0){
            if(strike==0) System.out.println("낫싱");
            else System.out.println(strike + "스트라이크");
        }
        else{
            if(strike==0) System.out.println(ball + "볼");
            else System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        if(strike == 3) end = 1;
    }

    void init(){
        strike = 0;
        ball = 0;
        end = 0;
    }
}
