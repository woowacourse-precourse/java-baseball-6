package baseball.domain;

import java.util.List;

public class GameStandard {
    /**
     *
     * @param computerList 컴퓨터의 3개의 랜덤 LIST [1, 2, 3]
     * @param userList 유저의 3개의 랜덤 LIST [2, 3, 4]
     * @return
     */
    public int getSameNumber2Computer(List<Integer> computerList, List<Integer> userList){

        return 0;
    }

    /**
     * List 숫자중 해당 index의 숫자와 numIndexPlaceOfUser의 숫자가 동일한지 확인한다.
     * @param computerList 컴퓨터의 3개의 랜덤 숫자 리스트 [ 1, 2, 3]
     * @param placeIndexOfUser 유저가 확인을 원하는 숫자의 index
     * @param numIndexPlaceOfUser 유저가 확인을 원하는 index의 num값
     * @return 만약에 List의 index의 숫자가 numIndexPlaceOfUser와 동일하다면 true
     */
    public boolean isSamePlaceNumUserAndComputer(List<Integer> computerList, int placeIndexOfUser, int numIndexPlaceOfUser){

        return true;
    }
}
