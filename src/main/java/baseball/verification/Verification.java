package baseball.verification;

import baseball.logic.Logic;

public class Verification {

    private Logic logic = new Logic();

    public boolean checkRandomValid(int splitNums[]) {

        try {
            if (splitNums[0] != splitNums[1] && splitNums[0] != splitNums[2] && splitNums[1] != splitNums[2]) {
                return true;
            }
            else {
                return false;
            }
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public boolean checkInputValid(int num) {
        int[] splitNums = logic.splitNumber(num);

        if (num >= 100 && num <= 999 && splitNums[0] != splitNums[1] && splitNums[0] != splitNums[2] && splitNums[1] != splitNums[2]) {
            return true;
        } else {
            throw new IllegalArgumentException("올바른 입력이 아닙니다.");
        }
    }

    public boolean checkInputOpinion(int num) {
        try {
            if(num == 1 && num == 2)
                return false;
            else
                return true;
        } catch (IllegalArgumentException e) {
            System.out.println("올바른 입력이 아닙니다.");
            return true;
        }
    }
}
