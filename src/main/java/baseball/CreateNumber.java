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
        ValidCheckNumber.validCheckInt(s);
        List<Integer> player = stringToList(s);
        ValidCheckNumber.validCheckPlayer(player);
        return player;
    }
    public List<Integer> stringToList(String s){
        List<Integer> player = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int temp = s.charAt(i)-48;
            player.add(temp);
        }
        return player;
    }
}