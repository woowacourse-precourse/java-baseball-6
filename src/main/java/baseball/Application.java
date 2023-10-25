package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.internal.IntArrays;

public class Application {
    static boolean judge(int[] answer, int[] ask){

        int strike=0;
        int ball=0;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++) {
                if (answer[j] == ask[i]) {
                    if(i==j) strike++;
                    else ball++;
                }
            }
        }

        if(ball==0 && strike==0) System.out.print("낫싱");
        if(ball!=0) System.out.print(ball + "볼 ");
        if(strike!=0) System.out.print(strike + "스트라이크");
        System.out.println();
        if(strike==3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        //정답이 될 3개의 숫자를 만들기
        int[] answer = new int[3];
        for(int i=0;i<3;i++){
            answer[i] = Randoms.pickNumberInRange(1, 9);
            for(int j=0; j < i && answer[j] == answer[i]; j++){
                answer[i] = Randoms.pickNumberInRange(1, 9);
                j=0;
            }
        }

        int[] ask = new int[3];
        do{
            System.out.print("숫자를 입력해주세요 : ");

            //사용자로부터 3개의 숫자 입력받기
            String readLine = Console.readLine();
            for(int i=0; i<3; i++){
                ask[i] = readLine.charAt(i)-'0';
            }
        }
        while(!judge(answer, ask));

    }
}
