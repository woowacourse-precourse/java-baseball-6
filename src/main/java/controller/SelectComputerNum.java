package controller;
import camp.nextstep.edu.missionutils.Randoms;

public final class SelectComputerNum {
    private final char[] selectComputers = new char[3];

    public void randomlySelectComputerNum() {
        for (int i = 0 ; i < selectComputers.length ; i++) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if((i > 0) && checkDuplication((char)(randomNumber + '0'))) {
                i--;
                continue;
            }
            selectComputers[i] = (char)(randomNumber + '0');
        }
    }

    private boolean checkDuplication(char randomNumber) {
        int i = 0;
        for (; i < selectComputers.length ; i++ ) {
            if (selectComputers[i] == randomNumber) {
                break;
            }
        }
        if(i == selectComputers.length) {//duplication false
            return false;
        }
        return true;//duplication true
    }

    public char[] getterSelectComputerNum() {
        return selectComputers.clone();
    }
}
