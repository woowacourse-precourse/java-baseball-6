package baseball;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Player {

    public List<Integer> playerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input=Console.readLine();
        exceptionFormat(input);

        List<Integer> player = new ArrayList<>();
        Set<Integer> numberSet = new HashSet<>();


        for(String number: input.split("")) {
            int num = Integer.parseInt(number);
            exceptionPlayer(num);
            if (numberSet.contains(num)) {
                throw new IllegalArgumentException("중복된 숫자를 입력했습니다. 다시 확인해주세요.");
            }
            numberSet.add(num);
            player.add(num);
        }
//        System.out.println(player);
        return player;
    }

    public void exceptionPlayer(int input) {
        if (input < 1 || input > 9) {
            throw new IllegalArgumentException("1부터 9 사이의 숫자만 입력해주세요");
        }
    }

    public void exceptionFormat(String input) {
        if(!input.matches("[0-9]+") || input.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요");
        }
    }
}
