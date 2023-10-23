package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.internal.IntArrays;

public class Application {
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

        System.out.print("숫자를 입력해주세요 : ");

        int[] ask = new int[3];
        String readLine = Console.readLine();
        for(int i=0; i<3; i++){
            ask[i] = readLine.charAt(i)-'0';
        }


    }
}
