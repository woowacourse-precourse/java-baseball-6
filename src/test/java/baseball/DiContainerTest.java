package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.config.DiContainer;
import baseball.controller.Controller;
import baseball.controller.UserController;
import baseball.service.GameService;
import baseball.util.Validation;
import baseball.view.ComputerView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DiContainerTest {

    @DisplayName("DiContainer 를 활용한 객체 생성은 null 값이 아닐 것이다.")
    @Test
    void diContainerNullTest() {

        //given
        DiContainer diContainer = new DiContainer();

        //when
        Controller computerController = diContainer.userController();

        //then
        assertThat(computerController).isNotNull();
    }

    @DisplayName("DiContainer 로 생성한 객체는 new 예약어로 생성한 객체와 동일한 클래스의 인스턴스다.")
    @Test
    void computerControllerCreatTest() {

        //given
        DiContainer diContainer = new DiContainer();

        //when
        Controller userControllerGenerateByDI = diContainer.userController();
        Controller userControllerGenerateByNew = new UserController(new ComputerView(),
                new GameService(new Validation()));

        //then
        assertThat(userControllerGenerateByDI).isInstanceOf(userControllerGenerateByNew.getClass());
        assertThat(userControllerGenerateByNew).isInstanceOf(userControllerGenerateByDI.getClass());
    }
}