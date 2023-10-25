package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
public class generatePlayer {


    static List<Integer> PlayerNumber(String tempNum) {
        List<Integer> Player = new ArrayList<Integer>();

        try {
            int num = Integer.parseInt(tempNum);
            while (num > 0) {
                Player.add(num % 10);
                num /= 10;

                }

            }catch(NumberFormatException e){
                throw new IllegalArgumentException("입력값이 숫자가 아닙니다.");
            }

        if (Player.size() != 3) {
            throw new IllegalArgumentException("입력값이 세 자릿수가 아닙니다.");
        }

        if (Player.contains(0)) {
            throw new IllegalArgumentException("0은 입력할 수 없습니다.");
        }
        Set<Integer> tempSet = new HashSet<>(Player);
        if(tempSet.size() != 3) {
            throw new IllegalArgumentException("중복된 값이 존재합니다.");
        }

            return Player;
        }
    }



