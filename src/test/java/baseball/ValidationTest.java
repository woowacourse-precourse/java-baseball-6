package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.util.Validation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationTest {

    Validation validation;

    public Validation validation() {
        validation = new Validation();
        return validation;
    }

    @DisplayName("입력값의 범위 중 1 ~ 9 내 에서만 허용한다. 0은 허용하지 않는다.")
    @Test
    void 세자리의_입력값_중_0은_범위밖이다() {

        //given
        String input = "120";

        //then
        assertThat(validation().validateInputType(input)).isFalse();
    }

    @DisplayName("입력값은 중복되지 않은 세 자리의 1~9 숫자 내 의 결과만 true 를 리턴 한다. 그 외의 값은 False 가 리턴된다.")
    @Test
    void 세자리의_입력값_중_1에서_9까지는_범위안이다() {

        //given
        String input = "125";

        //then
        assertThat(validation().validateInputType(input)).isTrue();
    }

    @DisplayName("중복값 내 중복 요소가 있을 경우 false를 리턴한다.")
    @Test
    void 중복된_입력값_내_중복된_요소가_있을경우_실패한다() {
        //given
        String input = "111";

        //then
        assertThat(validation().validationEachDifferentElement(input)).isFalse();
    }

    @DisplayName("중복값 내 중복 요소가 없을 경우 true를 리턴한다.")
    @Test
    void 중복된_입력값_내_중복된_요소가_없을경우_성공한다() {

        //given
        String input = "456";

        //then
        assertThat(validation().validationEachDifferentElement(input)).isTrue();
    }

    @DisplayName("검증 값(0)이 입력값과 같을 경우 false를 리턴한다.")
    @Test
    void 검증값과_입력값이_값이_같으면_실패한다() {
        //given
        char input = '0';

        //then
        assertThat(validation().validateEqualInput(input, '0')).isFalse();
    }

    @DisplayName("검증 값(0)이 입력값과 다를 경우 true를 리턴한다.")
    @Test
    void 검증값과_입력값이_다르면_성공한다() {

        //given
        char input = '2';

        //then
        assertThat(validation().validateEqualInput(input, '0')).isTrue();
    }

    @DisplayName("입력값의 길이는 예상한 길이의 입력값과 같아야 한다. 같을 경우 true 를 리턴한다.")
    @Test
    void 입력값의_길이_3과_설정한_길이값의_3은_같다() {

        //given
        String input = "456";

        //then
        assertThat(validation().validateInputLength(input, 3)).isTrue();
    }

    @DisplayName("입력값의 길이는 예상한 길이의 입력값과 같아야 한다. 다를 경우 false 를 리턴한다.")
    @Test
    void 입력값의_길이_3과_설정한_길이값의_4은_다르다() {

        //given
        String input = "23";

        //then
        assertThat(validation().validateInputLength(input, 4)).isFalse();
    }

    @DisplayName("게임 재 시작시 정상 입력값 1은 : true 를 리턴한다.")
    @Test
    void 입력값_1은_게임이_재실행된다() {
        //given
        String retryInput = "1";

        //then
        assertThat(validation().validationReplayInput(retryInput)).isEqualTo(true);
    }

    @DisplayName("게임 재 시작시 정상 입력값 2는 : true 를 리턴하고 종료된다.")
    @Test
    void 입력값_2는_게임이_종료된다() {
        //given
        String retryInput = "2";

        //then
        assertThat(validation().validationReplayInput(retryInput)).isEqualTo(true);
    }

    @DisplayName("게임 재 시작시 1, 2 외의 입력값은 예외가 발생한다.")
    @Test
    void 그_외_입력은_예외가_발생된다() {
        //given
        String str = "3";

        //then
        assertThatThrownBy(() -> validation().validationReplayInput(str)).isInstanceOf(
                IllegalArgumentException.class
        );
    }

    @DisplayName("입력된 값에 숫자 외의 포함될 경우, "
            + "검증 값인 (0)문자가 포함되어 있을 경우,"
            + " 예상한 길이값(3)과 같을 경우,"
            + "입력값 각각의 요소가 다를 경우 통과한다.")

    @Test
    void 종합_입력값_성공_테스트() {
        //given
        String str = "123";

        //then
        assertThat(validation().combinedValidation(str)).isTrue();
    }

    @DisplayName("입력된 값에 숫자 외의 포함될 경우, "
            + "검증 값인 (0)문자가 포함되어 있을 경우,"
            + " 예상한 길이값(3)과 같을 경우,"
            + "입력값 각각의 요소가 다를 경우 통과한다."
            + "그 외의 입력값은 IllegalArgumentException 가 발생한다.")
    @Test
    void 종합_입력값_실패_테스트_입력값_숫자외_문자포함() {
        //given
        String str = "ㄱ23";

        //then
        assertThatThrownBy(() -> validation().combinedValidation(str)).isInstanceOf(
                IllegalArgumentException.class
        );
    }


    @DisplayName("입력된 값에 숫자 외의 포함될 경우, "
            + "검증 값인 (0)문자가 포함되어 있을 경우,"
            + " 예상한 길이값(3)과 같을 경우,"
            + "입력값 각각의 요소가 다를 경우 통과한다."
            + "그 외의 입력값은 IllegalArgumentException 가 발생한다.")
    @Test
    void 종합_입력값_실패_테스트_검증값_포함() {

        //given
        String str = "120";

        //then
        assertThatThrownBy(() -> validation().combinedValidation(str)).isInstanceOf(
                IllegalArgumentException.class
        );
    }


    @DisplayName("입력된 값에 숫자 외의 포함될 경우, "
            + "검증 값인 (0)문자가 포함되어 있을 경우,"
            + " 예상한 길이값(3)과 같을 경우,"
            + "입력값 각각의 요소가 다를 경우 통과한다."
            + "그 외의 입력값은 IllegalArgumentException 가 발생한다.")
    @Test
    void 종합_입력값_실패_테스트_예상한_길이값과_다를_경우() {

        //given
        String str = "1234";

        //then
        assertThatThrownBy(() -> validation().combinedValidation(str)).isInstanceOf(
                IllegalArgumentException.class
        );
    }

    @DisplayName("입력된 값에 숫자 외의 포함될 경우, "
            + "검증 값인 (0)문자가 포함되어 있을 경우,"
            + " 예상한 길이값(3)과 같을 경우,"
            + "입력값 각각의 요소가 다를 경우 통과한다."
            + "그 외의 입력값은 IllegalArgumentException 가 발생한다.")
    @Test
    void 종합_입력값_실패_테스트_입력값_각각의_요소가_같을_경우() {

        //given
        String str = "122";

        //then
        assertThatThrownBy(() -> validation().combinedValidation(str)).isInstanceOf(
                IllegalArgumentException.class
        );
    }
}