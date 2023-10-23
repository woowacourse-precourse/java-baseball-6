package baseball;

import baseball.model.ComputerModel;
import baseball.model.UserModel;
import baseball.util.common.Common;
import baseball.util.dto.Baseball;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballService {

    private ComputerModel computerModel;
    private final UserModel userModel = new UserModel();

    public BaseballService() {
    }

    public void initComputerModel() {
        computerModel = new ComputerModel(createNonDuplicatedNumber());
    }

    public void getUserNumber(String inputUserNumberString) {
        userModel.initUserInputBySplitDigits(inputUserNumberString);
    }

    public Baseball compareUserInputByComputerNumber() {
        Baseball baseballDto = new Baseball();
        int trackIdx = 0;

        for (Integer userDigit : userModel.getSplitDigitsFromUserInput()) {
            if (userDigit.equals(computerModel.getSplitDigitFromRandomNumber(trackIdx))) {
                baseballDto.incrementStrikeCount();
            } else if (computerModel.hasContainNumber(userDigit)) {
                baseballDto.incrementBallCount();
            } else {
                baseballDto.incrementNothingCount();
            }
            trackIdx++;
        }

        return baseballDto;
    }


    private List<Integer> createNonDuplicatedNumber() {
        List<Integer> splitDigitsFromRandomNumber = new ArrayList<>();

        while (splitDigitsFromRandomNumber.size() < Common.NUM_LENGTH) {
            //여기서 IllegalArgumentException 고려해봐야 한다.
            int randomNumber = Randoms.pickNumberInRange(Common.START_INCLUSIVE,
                    Common.END_INCLUSIVE);
            if (!splitDigitsFromRandomNumber.contains(randomNumber)) {
                splitDigitsFromRandomNumber.add(randomNumber);
            }
        }

        return splitDigitsFromRandomNumber;
    }


}
