package baseball.verification;

import baseball.logic.Logic;

public class Verification {

    private Logic logic = new Logic();

    public boolean checkRandomValid(int num) {
        int[] splitNums = logic.splitNumber(num);

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

        try {
            if (num >= 100 && num <= 999 && splitNums[0] != splitNums[1] && splitNums[0] != splitNums[2] && splitNums[1] != splitNums[2]) {
                return true;
            }
            else {
                System.out.println("올바른 숫자 형식이 아닙니다.");
                System.out.println("현재 나누어진 수: " + splitNums[0] + " " + splitNums[1] + " " + splitNums[2]);
                return false;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("올바른 입력이 아닙니다.");
            return false;
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
