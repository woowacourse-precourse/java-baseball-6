package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구게임을 시작합니다.");
        List<Integer> computer = new ArrayList<>();
        while(computer.size() < 3){
            int computerNumber = Randoms.pickNumberInRange(1,9);
            if(!computer.contains(computerNumber)){
                computer.add(computerNumber);
            }
        }

        List<Integer> player = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String playerNumber = Console.readLine();
        if(playerNumber.length() != 3){
            throw new IllegalArgumentException("세자리 수보다 크거나 작음");
        }
        if(Integer.parseInt(playerNumber) < 0){
            throw new IllegalArgumentException("음수를 사용할 수 없음");
        }
        for(int i = 0; i < 3; i++){
            int eachNumber = playerNumber.charAt(i) - '0';
            if(eachNumber == 0){
                throw new IllegalArgumentException("0을 포함할 수 없음");
            }
            if(!player.contains(eachNumber)){
                player.add(eachNumber);
            }
        }
        if(player.size() != 3){
            throw new IllegalArgumentException("중복 숫자가 존재함");
        }
        System.out.println(player.toString());
    }
}
