package baseball.common.service;

import org.junit.jupiter.api.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CommonNumberServiceTest{

    private CommonNumberService commonNumberService;
    private Method isValid;

    //@BeforeAll 어노테이션이 붙은 메소드는 반드시 정적 클래스이어야 한다
    //혹은 테스크 클래스의 생명 주기를 인스턴스 생명주기와 맞춰주면 된다
    @BeforeAll
    public void init() throws NoSuchMethodException {
        commonNumberService = new CommonNumberService();
        //reflection
        isValid = commonNumberService.getClass().getDeclaredMethod("isValid", String.class);
        isValid.setAccessible(true);

    }

    @BeforeEach
    public void setAnswerTo123() throws NoSuchFieldException, IllegalAccessException{
        Field computerField = CommonNumberService.class.getDeclaredField("computer");
        computerField.setAccessible(true);
        ArrayList<Integer> answerList = new ArrayList<>(List.of(1, 2, 3));
        computerField.set(commonNumberService,answerList);
    }

    @Test
    @DisplayName("랜덤 3자리 숫자 생성 테스트")
    public void 서로_다른_3자리_숫자_생성(){

        commonNumberService.createRandomNumber();
        List<Integer> computer = commonNumberService.getComputer();
        assertEquals(computer.size(),3);        //3자리 숫자

        HashSet<Integer> set = new HashSet<>(computer);
        assertEquals(set.size(),3);     //서로 다른 숫자
    }



    @Nested
    @DisplayName("입력에 따른 컴퓨터 응답 검사")
    class ResponseTest{

        @Test
        @DisplayName("일치하는 값이 없으면 낫싱이다")
        public void 일치하는_값이_없으면_낫싱이다(){
            assertEquals(commonNumberService.isCorrect("456"),"낫싱");
        }

        @Test
        @DisplayName("하나의 숫자가 자리와 숫자가 일치하면 1 스트라이크이다")
        public void 하나의_숫자가_자리와_숫자가_일치하면_1스트라이크이다(){
            assertEquals(commonNumberService.isCorrect("189"),"1스트라이크");
        }

        @Test
        @DisplayName("3개의 숫자가 자리와 숫자가 일치하면 3 스트라이크이다")
        public void 모든_숫자가_자리와_숫자가_일치하면_3스트라이크이다(){
            assertEquals(commonNumberService.isCorrect("123"),"3스트라이크");
        }

        @Test
        @DisplayName("1개의 숫자가 자리와 숫자가 일치하고 1개는 자리가 일치하지 않으면 1볼 1스트라이크이다")
        public void 하나의_숫자가_자리와_숫자가_일치하고_다른하나는_자리가_일치하지_않으면_1볼_1스트라이크이다(){
            assertEquals(commonNumberService.isCorrect("135"),"1볼 1스트라이크");
        }

        @Test
        @DisplayName("모든 숫자가 자리가 일치하지 않으면 3볼이다")
        public void 모든_숫자가_자리가_일치하지_않으면_3볼이다(){
            assertEquals(commonNumberService.isCorrect("231"),"3볼 ");
        }
    }

    @Nested
    @DisplayName("유효성 검사")
    class ValidTest{

        @Nested
        @DisplayName("성공 테스트")
        class SuccessTest{

            @Test
            @DisplayName("사용자 입력 유효성 검사 - 성공 테스트")
            public void 유효한_사용자_입력() throws InvocationTargetException, IllegalAccessException {
                assertTrue((Boolean) isValid.invoke(commonNumberService,"123"));
                assertTrue((Boolean) isValid.invoke(commonNumberService,"456"));
                assertTrue((Boolean) isValid.invoke(commonNumberService,"789"));
            }
        }

        @Nested
        @DisplayName("실패 테스트")
        class FailureTest{

            @Test
            @DisplayName("사용자 입력 유효성 검사 - 0이 포함된 입력 시 예외")
            public void 입력이_0을_포함하면_예외를_던진다() {

                //0이 포함된 입력은 IllegalArgumentException throw
                //Reflection 메소드에서 예외가 발생 시 InvocationTargetException 예외가 Wrapper 후 발생된다!
                //따라서 예외 catch 후 assert 하는 식으로 작성했다
                try{
                    isValid.invoke(commonNumberService,"120");
                }catch(IllegalAccessException | InvocationTargetException e){
                    assertEquals(e.getCause().getClass(),IllegalArgumentException.class);
                }
            }

            @Test
            @DisplayName("사용자 입력 유효성 검사 - 3자리가 아닌 입력 시 예외")
            public void 입력이_3자리가_아니면_예외를_던진다(){
                try{
                    isValid.invoke(commonNumberService,"1211");
                }catch(IllegalAccessException | InvocationTargetException e){
                    assertEquals(e.getCause().getClass(),IllegalArgumentException.class);
                }
            }

            @Test
            @DisplayName("사용자 입력 유효성 검사 - 숫자가 아닌 입력 시 예외")
            public void 입력이_숫자가_아니면_예외를_던진다(){
                try{
                    isValid.invoke(commonNumberService,"12a");
                }catch(IllegalAccessException | InvocationTargetException e){
                    assertEquals(e.getCause().getClass(),IllegalArgumentException.class);
                }
            }

            @Test
            @DisplayName("사용자 입력 유효성 검사 - 중복된 숫자 입력 시 예외")
            public void 입력이_중복된_숫자라면_예외를_던진다(){
                try{
                    isValid.invoke(commonNumberService,"222");
                }catch(IllegalAccessException | InvocationTargetException e){
                    assertEquals(e.getCause().getClass(),IllegalArgumentException.class);
                }
            }
        }

    }



}