package baseball.view;

import baseball.action.BaseBallGame;

import java.util.ArrayList;


public class Result {
    private static UserInput inputView;
    private static ToArray toArray;
    private static BaseBallGame baseBallGame;
    private static ComputerInput computerInput;
    public static void result(){
        ArrayList<Integer> computer=computerInput.computer();

        while(true){
            int myNum=inputView.insert();
            ArrayList<Integer> problem=toArray.toArray(myNum);

            int[] result=baseBallGame.game(computer,problem);

            if(result[2]==1){
                System.out.println("낫싱");
            }else if(result[0]==3){
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }else if(result[0]==0){
                System.out.println(result[1]+"볼");
            }else if(result[1]==0) {
                System.out.println(result[0] + "스트라이크");
            }else{
                System.out.println(result[1]+"볼 "+result[0]+"스트라이크" );
            }

        }
    }
}
