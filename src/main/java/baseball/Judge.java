package baseball;

import java.util.ArrayList;
import java.util.Objects;

public class Judge {
    Judge(){ }
    public static int[] BallAndStrike(ArrayList<Integer> user, ArrayList<Integer> answer){
        int[] result = new int[2];

        for (int i=0; i<answer.size(); i++){
            if (Objects.equals(answer.get(i), user.get(i))){ //strike라면
                result[0] += 1;
            }
            else if (answer.contains(user.get(i))) { //ball이라면
                result[1] += 1;
            }
        }
        return result;
    }
    public static void printResult(int[] result){
        //1스트라이크 1볼 식으로 표현
        if (result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
        } else if (result[0] == 0) {
            System.out.println(result[1] + "볼");
        } else if (result[1] == 0) {
            System.out.println(result[0]+ "스트라이크");
        }else {
            System.out.println(+result[1]+"볼 " + result[0]+"스트라이크");
        }
    }
    public static boolean correct(int[] result){
        if(result[0]==3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        else{
            return false;
        }
    }

}
