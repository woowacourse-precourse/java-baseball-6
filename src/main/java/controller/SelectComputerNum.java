package controller;
import camp.nextstep.edu.missionutils.Randoms;
import model.Computer;

public class SelectComputerNum {
    private char[] selectComputers = new char[3];
    private Computer computer;

    public Computer randomlySelectComputerNum() {
            selectComputers[0] = (char)(Randoms.pickNumberInRange(1, 9) + '0');

            for (int i = 0 ; i < selectComputers.length ; i++) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);

                if(checkDuplication((char)(randomNumber + '0'))) {
                    i--;
                    continue;
                }
                selectComputers[i] = (char)(randomNumber + '0');
            }
            computer = new Computer(selectComputers);//model object 생성
            return computer;

    }

    private boolean checkDuplication(char randomNumber) {
        int i = 0;
        for (; i < selectComputers.length ; i++ ) {
            if (selectComputers[i] == randomNumber) {
                return true;
            }
        }
        return false;
    }
}