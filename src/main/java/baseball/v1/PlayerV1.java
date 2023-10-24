package baseball.v1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerV1 {
    /**
     * 게임 플레이어의 역할
     * 1. 서로 다른 3자리의 수 입력
     */
    public List<Integer> setNums() {
        List<Integer> playerNums = new ArrayList<>();
        Set<Integer> addNums = new HashSet<>();
        // TODO: 플레이어 입력
        // TODO: 입력값 에러 처리.
        // 스트링으로 입력 받기 123
        // 각 자리수별로 인티저로 변환해서 리스트에 저장하기.
        // 중복 있으면 에러.
        // size가 3이 아니면 에러
//        while (true) {
//            String input = Console.readLine();
//            boolean isValidInput = true;
//
//            for (String str : input.split("")) {
//                try {
//                    int number = Integer.parseInt(str);
//                    if (addNums.contains(number)) {
//                        isValidInput = false;
//                    }
//                } catch (IllegalArgumentException e) {
//                    Host.gameStop();
//                }
//            }
//        }
        //임시로 return
        return playerNums;
    }
}



