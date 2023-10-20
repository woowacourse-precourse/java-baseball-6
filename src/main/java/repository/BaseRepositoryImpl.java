package repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static constant.BaseConst.BALL;
import static constant.BaseConst.STRIKE;

public class BaseRepositoryImpl implements BaseRepository {

    /**
     * 사용자가 입력한 번호를 List<Integer>로 반환
     * @param myNumber
     * @return List<Integer> myNumber
     */
    @Override
    public List<Integer> getMyNumber(String myNumber) {
        String[] split = myNumber.split("");
        return Arrays.stream(split).map(Integer::parseInt).collect(Collectors.toList());
    }

    /**
     * 스트라이크, 볼 집계
     * @param baseNumber
     * @param myNumber
     * @return int[] result
     */
    @Override
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
     */
    @Override
    public void printMessage(int[] result) {
        if (result[STRIKE] + result[BALL] == 0) {
            System.out.println("낫싱");
            return;
        }

        StringBuffer sb = new StringBuffer();
        if (result[BALL] != 0) {
            sb.append(result[BALL]).append("볼 ");
        }
        if (result[STRIKE] != 0) {
            sb.append(result[STRIKE]).append("스트라이크");
        }

        System.out.println(sb.toString().trim());

    }
}
