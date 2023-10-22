package baseball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameNumber {
    private String computerNumber;
    private String userNumber;

    public GameNumber() {
        inputUserNumber();
        createComputerNumber();
    }

    public void inputUserNumber(){
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumber = sc.nextLine();
        this.userNumber = inputNumber;
    }
    public void createComputerNumber(){
        String number = "";
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
                number += Integer.toString(randomNumber);
            }
            this.computerNumber = number;
        }
    }

    public String getComputerNumber() {
        return computerNumber;
    }

    public String getUserNumber() {
        return userNumber;
    }
}
