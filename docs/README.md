# 기능 목록

## Application

메시지 파일 경로를 인자로 받아 생성된 뷰 인스턴스와 게임 클래스를 게임 컨트롤러에 인자로 주입해 컨트롤러 인스턴스를 생성하는 팩토리다.

| 메서드            | 기능                                                                                                      |
|----------------|---------------------------------------------------------------------------------------------------------|
| `run` (static) | `Game`, `GameView`, `GameController` 구현체와 메시지 파일 경로를 주입받아 `Application`인스턴스를 생성하는 동시에 `run()`메서드를 실행한다. |
| `run`          | 생성된 `GameController` 인스턴스의 `play()` 메서드를 실행한다.                                                          |

## NumberBaseballGame

게임이 생성될 때 `pickRandomNumber`를 실행한다.

| 메서드                | 기능                                  |
|--------------------|-------------------------------------|
| `pickRandomNumber` | 각 자리 수가 다른 3자리의 랜덤한 수를 뽑는다.         |
| `countStrikes`     | player가 입력한 수의 스트라이크 개수를 구한다.       |
| `countBalls`       | player가 입력한 수의 볼 개수를 구한다.           |
| `validateInput`    | player가 입력한 문자열을 검증한다.              |
| `makeSet`          | player가 입력한 문자열을 집합으로 만든다.          |
| `play`             | player가 입력한 문자열을 검증하고 게임의 결과를 저장한다. |
| `continues`        | 게임의 진행 여부를 boolean으로 반환한다.          |
| `getStrikes`       | Getter of `strikes` variable        |
| `getballs`         | Getter of `balls` variable          |

## NumberBaseballGameView

생성 시 인자로 받은 메시지 파일 경로를 통해 메시지를 Properties로 로드하고 게임 시작 메시지를 출력한다.

| 메서드                        | 기능                                                             |
|----------------------------|----------------------------------------------------------------|
| `showInputRequiredMessage` | 입력이 필요하다고 메시지를 출력한다.                                           |
| `showResultOf`             | 알맞은 게임 인스턴스가 아니면 `IllegalArgumentException`을 던지고 게임의 결과를 출력한다. |
| `showToBeContinueMessage`  | 게임을 계속할 지 묻는 메시지를 출력한다.                                        |
| `showQuitGameMessage`      | 게임 종료 메시지를 출력한다.                                               |

## NumberBaseballGameController

게임 클래스와 뷰 인스턴스를 받아 인스턴스를 생성한다.

| 메서드                  | 기능                                                                 |
|----------------------|--------------------------------------------------------------------|
| `play`               | 매 번 게임 인스턴스를 생성해 숫자를 맞출 때까지 해당 게임을 지속하고 숫자를 맞췄다면 다음 게임을 할 지를 확인한다. |
| `loopMatchingNumber` | player의 입력을 받아 숫자를 맞출 때까지 현재 게임을 반복한다.                             |
| `checkResume`        | 다음 게임을 할 지에 대한 입력을 받아 입력을 검증하고 게임을 지속하거나 종료한다.                     |
| `quitGame`           | 게임 종료 메시지를 출력하고 `playGame` boolean 변수를 false로 변경한다.                |

## messages.properties

게임 내 메시지를 따로 메시지 파일로 분리

## NumberBaseballGameTest

숫자가 아닌 문자와 각 자리 수에 중복된 문자가 입력되는 경우를 테스트한다.

## NumberBaseballGameControllerTest

게임 종료 시 1이나 2 이외의 문자가 입력되는 경우를 테스트한다.