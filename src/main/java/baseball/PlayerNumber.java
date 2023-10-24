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
        checkNumber(inputNumber);
        //숫자 배열로 변환
        List<Integer> player = StringToList(inputNumber);
        //3자리 수인지 확인
        checkLength(player);
        //1~9 숫자인지 확인
        checkZero(player);
        //3자리 수 중에 같은 수가 있는지 확인
        duplicateNumber(player);

        return new PlayerNumber(player);
    }

    private static void checkNumber(String inputNumber){
        try{
            Integer.parseInt(inputNumber);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    private static void checkLength(List<Integer> player){
        if (player.size() != 3){
            throw new IllegalArgumentException();
        }
    }

    private static void checkZero(List<Integer> player){
        if (player.contains(0)){
            throw new IllegalArgumentException();
        }
    }

    private static void duplicateNumber(List<Integer> player){
        Set<Integer> set = new HashSet<Integer>(player);
        if (set.size() != 3){
            throw new IllegalArgumentException();
        }
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
