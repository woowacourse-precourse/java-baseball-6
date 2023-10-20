package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class PlayGame {
    public List<Integer> computer_num(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    public List<Integer> getPlayerNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        String s = Console.readLine();
        //s를 검사하여 세자리수가 아니면 IllegalStateException 맞다면 반환
        int player_number = ValidCheckNumber.validCheckPlayer(s);
        ValidCheckNumber.duplicationAndZeroCheck(player_number);
        List<Integer> player_list = new ArrayList<>();
        player_list.add(player_number/100);
        player_list.add(player_number/10%10);
        player_list.add(player_number%10);
        return player_list;
    }

    public void play(){
        //computer를 123보다 크거나 같고 987보다 작거나 같은 랜덤수로 초기화
        List<Integer> computer = computer_num();
        boolean restart = true;
        while (restart){
            List<Integer> player = getPlayerNumber();
            //computer와 player의 수를 비교하여 [strike,ball]이 저장된 배열을 array에 넣기
            int[] strike_ball = CompareNumber.checkNumber(computer, player);
            String result = PrintResult.print(strike_ball);
            if (strike_ball[0]==3 || result.contains("3스")){
                restart=false;
            }
            System.out.println(result);
        }
    }
}
