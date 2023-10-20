package baseball.domain;

import java.util.List;

public class GameStandard {


    /**
     * 유저의 입력 숫자중에 컴퓨터와 같은 숫자가 몇개 인지 cnt을 반환
     *
     * @param computerList 컴퓨터의 3개의 랜덤 LIST [1, 2, 3]
     * @param userList     유저의 3개의 랜덤 LIST [2, 3, 4]
     * @return
     */
    public int getSameNumber2Computer(List<Integer> computerList, List<Integer> userList) {
        int cntSameNum = 0; // 유저의 숫자가 computerList에 포함한 갯수

        for (Integer numOfUser : userList) {
            if (isContainList(computerList, numOfUser)) { // computerList에 유저가 입력한 값이 포함되어 있으면
                cntSameNum = cntSameNum + 1; // 같은 숫자가 있을때 conunter + 1
            }
        }

        return cntSameNum;
    }

    /**
     * List 숫자중 해당 index의 숫자와 numIndexPlaceOfUser의 숫자가 동일한지 확인한다.
     *
     * @param computerList        컴퓨터의 3개의 랜덤 숫자 리스트 [ 1, 2, 3]
     * @param placeIndexOfUser    유저가 확인을 원하는 숫자의 index
     * @param numIndexPlaceOfUser 유저가 확인을 원하는 index의 num값
     * @return 만약에 List의 index의 숫자가 numIndexPlaceOfUser와 동일하다면 true
     */
    public boolean isSamePlaceNumUserAndComputer(List<Integer> computerList, int placeIndexOfUser, int numIndexPlaceOfUser) {
        int numPlaceIndexOfComputer = computerList.get(placeIndexOfUser);
        return numPlaceIndexOfComputer == numIndexPlaceOfUser;
    }


    /**
     * List에 Target 숫자가 포함되어있는지 확인
     *
     * @param computerList
     * @param numOfUser
     * @return
     */
    private boolean isContainList(List<Integer> computerList, Integer numOfUser) {
        return computerList.contains(numOfUser);
    }
}
