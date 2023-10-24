package controller;
import camp.nextstep.edu.missionutils.Randoms;
import model.Computer;

public class SelectComputerNum {
    private StringBuilder selectComputers = new StringBuilder();
    private Computer computer;

    public Computer randomlySelectComputerNum() {
            selectComputers.append((char)(Randoms.pickNumberInRange(1, 9) + '0'));

            while(selectComputers.length() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);

                if(!(checkDuplication((char)(randomNumber + '0')))) {
                    selectComputers.append((char)(randomNumber + '0'));
                }
            }
            computer = new Computer(selectComputers);//model object 생성
            return computer;

    }

    private boolean checkDuplication(char randomNumber) {
        int i = 0;
        for (; i < selectComputers.length() ; i++ ) {
            if (selectComputers.charAt(i) == randomNumber) {
                return true;
            }
        }
        return false;
    }
}