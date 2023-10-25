package baseball;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UsrInput {
    public List<Integer> getUsrInput(){
        System.out.print("숫자를 입력해주세요 :");
        String usrInput = readLine();
        boolean isUsrValueValidate = checkUsrValueValidate(usrInput);
        if (isUsrValueValidate) {
            return utils.convertToIntegerList(usrInput);
        }
        else {
            throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
        }
    }

    public boolean checkUsrValueValidate(String value) {
        if (value.length() == 3) {
            try {
                int number = Integer.parseInt(value);
                return number >= 100 && number <= 999;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }
}
