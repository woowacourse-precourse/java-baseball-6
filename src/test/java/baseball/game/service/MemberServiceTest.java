package baseball.game.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import baseball.game.entity.Member;
import baseball.game.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    MemberRepository memberRepository = MemberRepository.getInstance();
    MemberService memberService = MemberService.getInstance(memberRepository);

    @Test
    @DisplayName("서로 다른 3자리 숫자를 입력하면 회원 저장소에 입력값을 List<Integer> 타입으로 저장한다.")
    void readUserNumber() {
        // given
        String input = "123";

        // when
        Member member = memberService.readUserNumber(input);

        // then
        assertAll(
                () -> assertThat(member).isNotNull(),
                () -> assertThat(member.getNumbers()).hasSize(3)
                        .containsSequence(1, 2, 3)
        );
    }

    @Test
    @DisplayName("서로 다른 4자리 이상의 숫자를 입력하면 예외가 발생한다.")
    void readUserNumberExceptionInputMoreThan4() {
        // given
        String input = "1234";

        // when // then
        assertThatThrownBy(() -> memberService.readUserNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자를 잘못 입력했습니다. 중복되지 않은 3자리 숫자를 입력해주세요.");
    }

    @Test
    @DisplayName("서로 다른 2자리 이하의 숫자를 입력하면 예외가 발생한다.")
    void readUserNumberExceptionInputLessThan2() {
        // given
        String input = "12";

        // when // then
        assertThatThrownBy(() -> memberService.readUserNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자를 잘못 입력했습니다. 중복되지 않은 3자리 숫자를 입력해주세요.");
    }
}