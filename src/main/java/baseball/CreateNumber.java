package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class CreateNumber {
    public List<Integer> getComputer(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    public List<Integer> getPlayerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String s = Console.readLine();
        ValidCheckNumber.validCheckPlayer(s);
        //s를 검사하여 세자리수가 아니면 IllegalStateException 맞다면 반환
        List<Integer> player = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int temp = s.charAt(i)-48;
            player.add(temp);
        }
        ValidCheckNumber.duplicationCheck(player);
        ValidCheckNumber.zeroCheck(player);
        return player;
    }
}
