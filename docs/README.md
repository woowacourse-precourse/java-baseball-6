## 숫자 야구 기능 요구 사항

## System
### MainController
- 사용자의 입력에 따라 게임을 진행하거나 멈춘다

## Domain
### Ball
- 서로 다른 3자리 수 중 **하나의 숫자**를 갖는 객체
- Integer와 String 두 가지의 생성 방법을 제공한다
    - `예외` 숫자가 아닌 문자가 입력되는 경우
    - `예외` 1-9의 범위를 벗어난 수가 입력되는 경우

### <Interface> Balls
- List<Ball> 의 일급컬렉션, 3개의 숫자(Ball)을 가지고 있는다

### AbstractBalls
- Balls 구체 클래스들의 공통 코드를 갖는다
- List<Ball>를 유일한 인스턴스 필드로 갖는다

### UserBalls
- 문자열을 받아 파싱하여 인스턴스를 생성한다
    - `예외` 중복된 문자가 입력되는 경우
    - `예외` 3자리가 아닌 수가 입력되는 경우

### ComputerBalls
- BallNumbersGenerateStrategy를 통해 인스턴스를 생성한다
- 인자로 주어진 Balls와 비교를 수행하고 GuessResult를 생성한다

### <Interface> BallNumbersGenerateStrategy
- 어떻게 공 번호를 생성할지 결정하는 함수형 인터페이스
- 시작 값, 종료 값, 개수를 인자로 받는다

### RandomUniqueBallNumbersGenerateStrategy
- 랜덤하고 중복없이 공 번호를 생성하는 BallNumbersGenerateStrategy의 기본 구현체

### BaseballGame
- 게임 시작 시 ComputerBalls를 생성한다
- 유저에게 숫자를 입력받고 이를 ComputerBalls와 비교해 GuessResult를 생성한다

### BallStatus
- 하나의 공에 대한 guess 결과를 나타낸다

### GuessResult
- 매 게임 결과로 몇 개의 스트라이크, 볼이 나왔는지를 갖는다

## View
### InputView
- 입력받은 수를 trim 하는 책임은 InputView가 가진다
- 서로 다른 3자리의 수 입력받기
- 게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수 입력받기

### MainCommand
- 사용자가 입력한 값과 게임 재시작 여부의 매핑을 가지고 있는다
- 게임 종료 시 입력된 값을 기반으로 게임을 다시 시작할지 여부를 반환한다
- `예외` 잘못된 값을 입력하면 IllegalArgumentException 발생
    - 숫자가 아닌 문자가 입력되는 경우
    - 1과 2가 아닌 다른 숫자가 입력되는 경우

### OutputView
- 게임 시작, 종료 문구를 출력한다
- 숫자를 입력하라는 문구를 출력한다
- 매 게임의 결과 GameResult를 받아 출력한다
- 한 게임이 종료되면 다음 게임을 계속 진행할지 묻는다
