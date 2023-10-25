package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class CreateNumber {
    //computer의 랜덤 수 생성
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
    //player의 수를 입력받아 유효성 체크후 입력받은 수를 리스트 형태로 반환
    public List<Integer> getPlayerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String s = Console.readLine();
        ValidCheck.typeCheck(s);
        List<Integer> player = stringToList(s);
        ValidCheck.validCheckPlayer(player);
        return player;
    }
    //문자열을 List<Interger> 형태로 반환
    public List<Integer> stringToList(String s){
        List<Integer> player = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int playerNumber = s.charAt(i)-48;
            player.add(playerNumber);
        }
        return player;
    }
}