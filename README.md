# [우아한테크코스 프리코스 미션1] 숫자 야구 구현 과정

우테코 프리코스의 첫 미션에 도전한다. 이번 미션은 앞으로 겪게될 미션보다는 쉬운 난이도에 속한다고 한다. 콘솔로 동작하는 간단한 숫자 야구를 구현하면 되는 미션이다.

구현 난이도는 굉장히 쉽다고 할 수 있을 것 같다. 하지만 프리코스를 진행하며 성장하기 위해서 배운 것들을 적용해 보려고 한다. 읽었던
책인 [오브젝트](https://www.yes24.com/Product/Goods/74219491)의 내용을 기반으로 객체지향적인 설계를 해볼 예정이다.

~~즉, 과하게 객체지향 원칙을 적용해 볼 예정이다.~~

미션 내용을 조금 확장해서 인터페이스만 구현하면 게임팩을 갈아 끼듯이 숫자 야구 외에도 다른 같은 게임을 쉽게 구현할 수 있는 일종의 **게임 프레임워크**를 만들어 보려고한다.

## 추상화와 책임의 분리

게임에 대해 생각해보자. 우테코 미션의 숫자 야구 기반 위에서 다른 게임을 구현한다면 어떤 공통된 특성이 있는 게임을 만들 수 있을까? 내가 생각해 본 공통점은 다음과 같다.

- 게임 재시작이 가능하다.
- 게임 클리어만 존재하고 게임 오버는 존재하지 않는다.
- 턴제 게임이다. (사용자는 입력을 하고 입력에 따라 클리어가 결정된다.)

위와 같은 특성을 가질 수 있는 게임은 예를 들어 **목숨이 무한인 행맨 게임** 등을 생각해 볼 수 있을 것이다. 그런데 잘 생각해보면 게임 재시작은 게임 외의 부가 기능이지 게임 자체의 본질이 아니다. 여기서
**게임 자체**와
**게임 시스템** 두 계층으로 추상화 계층을 나누어 보자.

- `GameSystem` : 게임 시스템, 게임을 자신만의 방식으로 진행할 책임
    - `ReplayableGameSystem` : 재시작이 가능한 게임 시스템
- `Game` : 게임, 게임에 공통적으로 적용되는 규칙에 따라 게임을 진행할 책임
    - `TurnBasedGame` : 게임 클리어만 존재하고 오버는 존재하지 않는 턴제 게임

위와 같이 `GameSystem`과 `Game`을 인터페이스로 작성하고 나머지 클래스들을 구현해보자.

### ReplayableGameSystem 클래스

`GameSystem`은 `run()` 인터페이스만을 가지고 있다. 이 인터페이스의 책임은 **게임을 자신만의 방식으로 구동**하는 것이다.

만약 게임을 한번만 진행하고 종료하는 게임 시스템을 구현하려면 다음과 같이 간단히 구현할 수 있다.

```java
public class PlayOnceGameSystem implements GameSystem {

    private final Game game;

    public void run() {
        game.init();
        game.play();
    }
}
```

게임 재시작 을 지원하는 `ReplayableGameSystem`클래스를 구현해보자.

```java
public class ReplayableGameSystem implements GameSystem {

    private final ReplayableGameSystemView systemView;
    private final Game game;

    public ReplayableGameSystem(ReplayableGameSystemView systemView, Game game) {
        this.systemView = systemView;
        this.game = game;
    }

    public void run() {
        boolean replay = true;
        while (replay) {
            game.init();
            game.play();
            replay = systemView.requestReplayInput();
        }
    }

}
```

`run()`메서드를 실행시키면 게임 초기화 및 진행 후 게임 재시작 여부를 `ReplayableGameSystemView`를 통해 받고 이에 따라 게임을 재시작 또는 종료한다.

`ReplayableGameSystemView`로 사용자에게 입력을 받거나 및 필요한 내용을 출력하는 책임을 분리했다. 그 이유는 입력 및 출력의 방법이 달라진다면 해당 클래스만 수정하면 되기 때문이다. (GUI로
입출력을 한다면..?)

만약 책임을
분리하지 않으면 `ReplayableGameSystem`은 입출력 방법 변경 시에도 수정되어야 하고 게임 재시작 방식에 변화가 있을 때에도 수정되어야 한다. 변화의 이유가 1개인 SRP를 지키기 위해 클래스를
분리하였다.

```java
public interface ReplayableGameSystemView {

    boolean requestReplayInput();
}
```

인터페이스는 위와 같고 구현체는 콘솔을 통해 입출력을 받도록 아래와 같이 구현하였다.

```java
public class ReplayableGameSystemConsoleView implements ReplayableGameSystemView {

    private static final String RESTART = "1";
    private static final String EXIT = "2";
    private static final String REQUEST_REPLAY_PROMPT = "게임을 새로 시작하려면 " + RESTART +
            ", 종료하려면 " + EXIT + "를 입력하세요.";

    @Override
    public boolean requestReplayInput() {
        System.out.println(REQUEST_REPLAY_PROMPT);
        String input = Console.readLine();
        validInput(input);
        return parseInput(input);
    }

    private void validInput(String input) {
        if (!input.equals(RESTART) && !input.equals(EXIT)) {
            throw new IllegalArgumentException("입력은 " + RESTART + " 이거나 " + EXIT + " 여야 합니다.");
        }
    }

    private boolean parseInput(String input) {
        if (input.equals(RESTART)) {
            return true;
        }

        return false;
    }
}
```

`ReplayableGameSystemConsoleView`클래스는 게임 본질 외적인 시스템에 관련한 입출력을 콘솔을 통해 진행한다. 만약 GUI를 통해
진행된다면 `ReplayableGameSystemGuiView`를
구현하면 될 것이다.
