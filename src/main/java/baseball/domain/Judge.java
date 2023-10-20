package baseball.domain;

import baseball.string.MyConstants;
import baseball.utill.Utill;

import java.util.List;

public class Judge {
    public final static int NOT_THING_RESULT = 0;
    GameStandard gameStandard;

    public Judge() {
        gameStandard = new GameStandard();
    }

    private static int getCntBall(int cntTotalSameUserAndComputer, int cntStrike) {
        return cntTotalSameUserAndComputer - cntStrike;
    }

    /**
     * computerList와 userList을
     *
     * @param computerList
     * @param userList
     * @return
     */
    public String baseballGameInspection(List<Integer> computerList, List<Integer> userList) {
        int cntTotalSameUserAndComputer = 0; // computerList 중에 userList와 같은 것이 몇개인가.
        int cntStrike = 0; // strike의 갯수
        int cntBall = 0; // ball의 갯수

        // 1. 숫자가 같은 갯수 - computerList 중에 userList와 같은 것이 몇개인지 구한다.
        cntTotalSameUserAndComputer = getSameTotalNumberAndComputer(computerList, userList);

        // 2. 스트라이크 갯수 - userList의 각각의 숫자와 computerList 중에 같은 것이 몇개인지 구한다
        cntStrike = getCntStrike(computerList, userList);

        // 3. 볼의 갯수 - 숫자가 같은 갯수 - 스트라이크 갯수 는 볼의 갯수이다.
        cntBall = getCntBall(cntTotalSameUserAndComputer, cntStrike);

        // 4. 숫자가 같은 갯수가 없다면 "낫싱"
        if (Utill.isSameInteger(cntTotalSameUserAndComputer, NOT_THING_RESULT)) {
            return MyConstants.MSG_NOT_THING();
        }

        // 5. 볼이 없다면 "3스트라이크"
        if (Utill.isSameInteger(cntBall, NOT_THING_RESULT)) {
            return MyConstants.MSG_ONLY_STRIKE(cntStrike);
        }

        // 6. 볼만 있다면
        if (Utill.isSameInteger(cntStrike, NOT_THING_RESULT)) {
            return MyConstants.MSG_ONLY_BALL(cntBall);
        }

        // 7. 볼과 스트라이크이 있다면 "1볼 1스트라이크"
        return MyConstants.MSG_BALL_STRIKE(cntBall, cntStrike);
    }

    private int getSameTotalNumberAndComputer(List<Integer> computerList, List<Integer> userList) {
        return gameStandard.getSameNumber2Computer(computerList, userList);
    }

    /**
     * 스트라이크의 갯수를 얻는다.
     *
     * @param computerList
     * @param userList
     * @return
     */
    private int getCntStrike(List<Integer> computerList, List<Integer> userList) {
        int cntStrike = 0;
        int valueIndexOfUserList;
        boolean isSamePlaceIndexUserAndCom;
        int sizeUserList = userList.size();
        for (int indexUserList = 0; indexUserList < sizeUserList; indexUserList++) {
            valueIndexOfUserList = userList.get(indexUserList); // index의 UserList의 값
            isSamePlaceIndexUserAndCom = isSamePlaceNumUserAndComputer(computerList, valueIndexOfUserList, indexUserList); // user의 특정 index의 값과 computer의 특정 index의 값이 같은가.

            if (isSamePlaceIndexUserAndCom) { // user의 특정 index의 값과 computer의 특정 index의 값이 같으면.
                cntStrike = cntStrike + 1; // 스트라이크의 갯수 증가.
            }
        }
        return cntStrike;
    }

    /**
     * 유저의 특정한 index의 값과 컴퓨터리스트의 특정한 index의 값이 같은지 확인한다.
     *
     * @param computerList         컴퓨터 3개의 랜덤 숫자가 있는 LIST
     * @param valueIndexOfUserList 유저의 특정한 값의 index
     * @param indexUserList        유저의 특정한 값이 있는 index
     * @return
     */
    private boolean isSamePlaceNumUserAndComputer(List<Integer> computerList, int valueIndexOfUserList, int indexUserList) {
        return gameStandard.isSamePlaceNumUserAndComputer(computerList, indexUserList, valueIndexOfUserList);
    }
}
