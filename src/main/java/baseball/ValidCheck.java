package baseball;

import java.util.Collections;
import java.util.List;

public class ValidCheck {
    //사용자 수에 대한 유효성 검사 루틴 실행
    public static void validCheckPlayer(List<Integer> player){
        sizeCheck(player);
        zeroCheck(player);
        duplicationCheck(player);
    }
    //사용자의 입력 수에 0이 있는지 확인
    public static void zeroCheck(List<Integer> player){
        if (player.contains(0)){
            throw new IllegalArgumentException();
        }
    }
    //사용자의 입력 수 중 중복이 있는지 확인
    public static void duplicationCheck(List<Integer> player){
        if (Collections.frequency(player, player.get(0))>1
                || Collections.frequency(player, player.get(1))>1){
            throw new IllegalArgumentException();
        }
    }
    //사용자의 입력 수가 3자리 수인지 확인
    public static void sizeCheck(List<Integer> player){
        if (player.size() != 3){
            throw new IllegalArgumentException();
        }
    }
    //사용자의 입력 수가 int 타입인지 확인
    public static void typeCheck(String s){
        try{
            Integer.parseInt(s);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
    //사용자의 입력수가 int인지 그리고 1과 2인지 확인
    public static void restartCheck(String s){
        try{
            if (!s.equals("1") && !s.equals("2")){
                throw new IllegalArgumentException();
            }
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
}
