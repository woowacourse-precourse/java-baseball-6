package repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static constant.BaseConst.BALL;
import static constant.BaseConst.STRIKE;

public class BaseRepository {

    /**
     * 사용자가 입력한 번호를 List<Integer>로 반환
     * @param myNumber
     * @return List<Integer> myNumber
     */
    public List<Integer> getMyNumber(String myNumber) {
        return Arrays.stream(myNumber.split("")).mapToInt(x -> Integer.parseInt(x)).boxed().collect(Collectors.toList());
    }

    /**
     * 스트라이크, 볼 집계
     * @param baseNumber
     * @param myNumber
     * @return result
     */
    public int[] confirmNumber(List<Integer> baseNumber, List<Integer> myNumber) {
        int[] result = new int[2]; // result[0] : 스트라이크, result[1] : 볼

        for (int i = 0; i < baseNumber.size(); i++) {

            if (myNumber.get(i) == baseNumber.get(i)) { // 같은 위치이면 스트라이크++
                result[STRIKE]++;
            } else if (baseNumber.contains(myNumber.get(i))){ // 같은 위치가 아니지만 존재하면 볼++;
                result[BALL]++;
            }

        }
        return result;
    }

    /**
     * 메세지 출력
     * @param result
     */
    public void printMessage(int[] result) {
        if (result[STRIKE] + result[BALL] == 0) {
            System.out.println("낫싱");
            return;
        }
        String message = "";
        if (result[BALL] != 0) message += result[BALL] + "볼 ";
        if (result[STRIKE] != 0) message += result[STRIKE] + "스트라이크";
        System.out.println(message.trim());

    }
}
