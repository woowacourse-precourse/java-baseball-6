package baseball.domain;

import baseball.string.MyConstants;
import baseball.utill.Utill;

import java.util.List;

public class Judge {
    public final static int NOT_THING_SAME_RESULT = 0;
    GameStandard gameStandard;
    String resultHintOfJudge;
    List<Integer> computerList;
    List<Integer> userList;

    public Judge() {
        gameStandard = new GameStandard();
        resultHintOfJudge = "";
    }


    /**
     * computerList와 userList을
     *
     * @param computerList
     * @param userList
     * @return
     */
    public String CheckProgressBaseballGame(List<Integer> computerList, List<Integer> userList) {
        this.computerList = computerList;
        this.userList = userList;

        // 1. 숫자가 같은 갯수가 없다면 "낫싱"
        if (isHintNotThing()) {
            return resultHintOfJudge;
        }

        // 2. 볼이 없다면 "3스트라이크"
        if (isHintNotBallOnlyStrike()) {
            return resultHintOfJudge;
        }

        // 3. 볼만 있다면
        if (isHintNotStrikeOnlyBall()) {
            return resultHintOfJudge;
        }

        // 4. 볼과 스트라이크이 있다면 "1볼 1스트라이크"
        if (isHintBallStrike()) {
            return resultHintOfJudge;
        }

        return "";
    }

    /**
     * 볼과 스트라이크가 존제하지 않는다면 (0이다.)
     * "낫싱";
     *
     * @return
     */
    private boolean isHintNotThing() {
        int cntSameAllNumUserAndComputer = getSameAllNumberAndComputer();
        if (Utill.isSameInteger(cntSameAllNumUserAndComputer, NOT_THING_SAME_RESULT)) {
            resultHintOfJudge = MyConstants.MSG_NOT_THING();
            return true;
        }
        return false;
    }

    /**
     * 볼이 0이고 스트라이크가 존제한다면
     * cntStrike + "스트라이크";
     *
     * @return
     */
    private boolean isHintNotBallOnlyStrike() {
        int cntStrike = getCntStrike();
        int cntBall = getCntBall();

        if (Utill.isSameInteger(cntBall, NOT_THING_SAME_RESULT)) {
            resultHintOfJudge = MyConstants.MSG_ONLY_STRIKE(cntStrike);
            return true;
        }
        return false;
    }

    /**
     * 스트라이크가 0이고 볼이 존제한다면
     * cntBall + "볼"; 을 반환
     *
     * @return
     */
    private boolean isHintNotStrikeOnlyBall() {
        int cntStrike = getCntStrike();
        int cntBall = getCntBall();

        if (Utill.isSameInteger(cntStrike, NOT_THING_SAME_RESULT)) {
            resultHintOfJudge = MyConstants.MSG_ONLY_BALL(cntBall);
            return true;
        }
        return false;
    }

    /**
     * 스트라이크와 볼이 0이 아니면
     * 심판의 cntBall + "볼 " + cntStrike + "스트라이크"; 을 반환
     *
     * @return
     */
    private boolean isHintBallStrike() {
        int cntStrike = getCntStrike();
        int cntBall = getCntBall();

        if (isExistStrikeBall(cntStrike, cntBall)) {
            resultHintOfJudge = MyConstants.MSG_BALL_STRIKE(cntBall, cntStrike);
            return true;
        }
        return false;
    }

    /**
     * 스트라이크 와 볼이 0이 아니면 true을 리턴.
     *
     * @param cntStrike
     * @param cntBall
     * @return
     */
    private boolean isExistStrikeBall(int cntStrike, int cntBall) {
        return !Utill.isSameInteger(cntStrike, NOT_THING_SAME_RESULT) &&
                !Utill.isSameInteger(cntBall, NOT_THING_SAME_RESULT);
    }

    /**
     * 유저의 숫자와 컴퓨터의 숫자중 같은 숫자가 몇개인가 확인한다.
     * 만약 user = (1, 2, 3) com = (1, 2, 4) 이면 결과는 2이다.
     *
     * @return
     */
    private int getSameAllNumberAndComputer() {
        return gameStandard.getSameUserNumber2Computer(computerList, userList);
    }

    /**
     * Ball의 갯수를 얻는다.
     *
     * @return ball의 갯수를 반환한다.
     */
    private int getCntBall() {
        int cntSameAllNumUserAndComputer = 0; // computerList 중에 userList와 같은 것이 몇개인가.
        int cntStrike = getCntStrike();

        cntSameAllNumUserAndComputer = getSameAllNumberAndComputer();

        return cntSameAllNumUserAndComputer - cntStrike;
    }

    /**
     * 스트라이크의 갯수를 얻는다.
     *
     * @return
     */
    private int getCntStrike() {
        int cntStrike = 0;
        int valueIndexOfUserList;
        boolean isSamePlaceIndexUserAndCom;

        int sizeUserList = userList.size();
        for (int indexUserList = 0; indexUserList < sizeUserList; indexUserList++) {
            valueIndexOfUserList = userList.get(indexUserList); // index의 UserList의 값
            isSamePlaceIndexUserAndCom = isSamePlaceNumUserAndComputer(valueIndexOfUserList, indexUserList); // user의 특정 index의 값과 computer의 특정 index의 값이 같은가.

            if (isSamePlaceIndexUserAndCom) { // user의 특정 index의 값과 computer의 특정 index의 값이 같으면.
                cntStrike = cntStrike + 1; // 스트라이크의 갯수 증가.
            }
        }
        return cntStrike;
    }

    /**
     * 유저의 특정한 index의 값과 컴퓨터리스트의 특정한 index의 값이 같은지 확인한다.
     *
     * @param valueIndexOfUserList 유저의 특정한 값의 index
     * @param indexUserList        유저의 특정한 값이 있는 index
     * @return
     */
    private boolean isSamePlaceNumUserAndComputer(int valueIndexOfUserList, int indexUserList) {
        return gameStandard.isSamePlaceIndexNumUser2ComNumList(computerList, indexUserList, valueIndexOfUserList);
    }
}
