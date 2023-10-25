package baseball;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;

public class PlayerNumber {
    private static final String NUMBER_INPUT = "숫자를 입력해주세요 : ";

    private List<Integer> player;

    private PlayerNumber(List<Integer> player){
        this.player = player;
    }

    public static PlayerNumber inputPlayer(){
        System.out.print(NUMBER_INPUT);
        String inputNumber = Console.readLine();

        //숫자인지 확인
        ValidationNumber.checkNumber(inputNumber);
        //숫자 배열로 변환
        List<Integer> player = StringToList(inputNumber);
        //3자리 수인지 확인
        ValidationNumber.checkLength(player);
        //1~9 숫자인지 확인
        ValidationNumber.checkZero(player);
        //3자리 수 중에 같은 수가 있는지 확인
        ValidationNumber.duplicateNumber(player);

        return new PlayerNumber(player);
    }

    public static List<Integer> StringToList(String inputNumber){
        List<Integer> player = new ArrayList<>();
        for (int i = 0; i < inputNumber.length(); i++){
            player.add(inputNumber.charAt(i) - '0');
        }

        return player;
    }
    public List<Integer> getPlayer() {return player;}


}
