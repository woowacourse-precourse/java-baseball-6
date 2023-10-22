package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameMethod {

    //컴퓨터 랜덤수 만들기
    public static void uniqueRandomNumber(List<Integer> computer) {
        for (int i = 0; i < 3; i++) {
            int num = Randoms.pickNumberInRange(1, 9);
            while (computer.contains(num)) {
                num = Randoms.pickNumberInRange(1, 9);
            }
            computer.add(num);
        }
    }

    /**
     * String 형태 숫자를 int 형태로 바꿔서 한자리씩 ArrayList에 저장
     * @param input
     * @return ArrayList size of 3
     */
    public static List<Integer> stringToIntArrayList(String input) {
        List<Integer> output = new ArrayList<>();
        for (char x : input.toCharArray()) {
            output.add(Character.getNumericValue(x));
        }
        return output;
    }


    /**
     * 스트라이크, 볼 판별
     * @param player
     * @param computer
     * @return [number of strikes, number of balls]
     */
    public static int[] strikeAndBall(List<Integer> player, List<Integer> computer) {
        int[] strikeAndBall = new int[2];
        for (int i = 0; i < 3; i++) {
            int cnum = computer.get(i);
            int pnum = player.get(i);
            if (cnum == pnum) {
                strikeAndBall[0]++; //strike
            } else if (computer.contains(pnum)) {
                strikeAndBall[1]++; //ball
            }
        }
        return strikeAndBall;
    }

}
