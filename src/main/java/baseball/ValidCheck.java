package baseball;

import java.util.Collections;
import java.util.List;

public class ValidCheck {
    public static void validCheckPlayer(List<Integer> player){
        sizeCheck(player);
        zeroCheck(player);
        duplicationCheck(player);
    }
    public static void zeroCheck(List<Integer> player){
        if (player.contains(0)){
            throw new IllegalArgumentException();
        }
    }
    public static void duplicationCheck(List<Integer> player){
        if (Collections.frequency(player, player.get(0))>1
                || Collections.frequency(player, player.get(1))>1){
            throw new IllegalArgumentException();
        }
    }
    public static void sizeCheck(List<Integer> player){
        if (player.size() != 3){
            throw new IllegalArgumentException();
        }
    }
    public static void typeCheck(String s){
        try{
            Integer.parseInt(s);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
    public static int restartNumCheck(String s){
        try{
            int i = Integer.parseInt(s);
            if (i!=1 && i!=2){
                throw new IllegalArgumentException();
            }
            return i;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
}
