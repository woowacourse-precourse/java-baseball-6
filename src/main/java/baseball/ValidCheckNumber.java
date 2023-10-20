package baseball;

import java.util.Collections;
import java.util.List;

public class ValidCheckNumber {
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
    public static void validCheckPlayer(String s){
        try{
            int i = Integer.parseInt(s);
            if (i>987 || i<123){
                throw new IllegalArgumentException();
            }
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
    public static int validCheckRestart(String s){
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
