package baseball;

import baseball.model.ComputerModel;
import baseball.model.UserModel;
import baseball.util.dto.Baseball;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BaseballServiceTest {

    private ComputerModel computerModel;
    private UserModel userModel;


    interface StubBaseball {
        public Baseball compareUserInputByComputerNumber();
    }

    class DefaultBaseballService implements StubBaseball {
        @Override
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
    }

    @Test
    void 숫자가_완전히_일치할_경우_3스트라이크_dto_반환() {
        //given
        computerModel = new ComputerModel(Arrays.asList(1, 2, 3));
        userModel = new UserModel(Arrays.asList(1, 2, 3));
        StubBaseball stubBaseball = new DefaultBaseballService();

        //when
        Baseball baseball = stubBaseball.compareUserInputByComputerNumber();

        //then
        Assertions.assertEquals(3, baseball.getStrikeNumber());
        Assertions.assertEquals(0, baseball.getBallNumber());
        Assertions.assertEquals(0, baseball.getNothingNumber());

    }

    @Test
    void 숫자가_1스트라이크_1볼일_경우() {
        //given
        computerModel = new ComputerModel(Arrays.asList(1, 2, 3));
        userModel = new UserModel(Arrays.asList(1, 3, 6));
        StubBaseball stubBaseball = new DefaultBaseballService();

        //when
        Baseball baseball = stubBaseball.compareUserInputByComputerNumber();

        //then
        Assertions.assertEquals(1, baseball.getStrikeNumber());
        Assertions.assertEquals(1, baseball.getBallNumber());
        Assertions.assertEquals(1, baseball.getNothingNumber());

    }

    @Test
    void 숫자가_다_아니여서_3Nothing_반환할_경우() {
        //given
        computerModel = new ComputerModel(Arrays.asList(1, 2, 3));
        userModel = new UserModel(Arrays.asList(4, 5, 6));
        StubBaseball stubBaseball = new DefaultBaseballService();

        //when
        Baseball baseball = stubBaseball.compareUserInputByComputerNumber();

        //then
        Assertions.assertEquals(0, baseball.getStrikeNumber());
        Assertions.assertEquals(0, baseball.getBallNumber());
        Assertions.assertEquals(3, baseball.getNothingNumber());

    }


}