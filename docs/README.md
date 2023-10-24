# 숫자 야구 게임 프로그램 구현 목록

## 1. 사용자 입력 및 출력 처리 (View)

### InputView

- 사용자로부터 문자열 입력을 받아 숫자로 변환하고 Controller에 전달한다.

#### 유저 숫자 입력

- 문자열 조건:
    1. **3자리 문자열이 아닌 경우**: `SizeNotMatchException` 발생
    2. **1 ~ 9까지의 숫자 이외의 값이 포함된 경우**: `CharacterNotNumberException`, `NumberContainsZeroException` 발생
    3. **중복된 숫자가 있는 경우**: `DuplicatedNumberException` 발생

#### 유저 메뉴 입력

- "1" 또는 "2" 이외의 값을 입력한 경우: `NotMenuOptionException` 발생

### OutputView

- 게임 결과를 컨트롤러에서 전달받아 적절한 형태로 출력하는 역할을 한다.
    - 라운드 결과 출력: Controller에서 DTO를 전달받아 각 라운드의 결과를 출력한다.
- 게임 종료 메시지를 출력합니다.

## 2. 게임 로직 처리 (Model)

### GameModel

- 중복되지 않는 랜덤한 정답을 생성한다.
- 사용자의 입력과 정답을 비교해 결과를 계산하여 DTO로 Controller에 전달한다.

## 3. 컨트롤러 (Controller)

### BaseballGameController

- Model과 View를 연결하여 실제 게임 진행을 담당한다.
- 사용하는 Model과 View는 메인 메서드에서 주입해 준다.

## Main 메서드

- 게임에 사용되는 Model, View, Controller를 생성하고 게임을 실행한다.
- 게임 로직에서 올라오는 예외를 `IllegalArgumentException`로 변환하여 던진다.
    - 가장 하위 클래스에서 던지는 예외는 테스트 실패 발생!
