# 📌 기능 요구 사항

## 숫자 랜덤 생성 기능

랜덤한 숫자를 생성하는 기능을 구현한다. - [GameNumbers](#GameNumbers)#generateRandomNumbers()

- [x] 3자리의 숫자여야 한다. - [GameNumbers](#GameNumbers)#validateSize()
- [x] 숫자는 1~9 범위의 자연수다. - [GameNumbers](#GameNumbers)#validateRange()
- [x] 3자리의 숫자는 서로 다른 숫자여야 한다. (중복이 없어야 한다.) - [GameNumbers](#GameNumbers)#validateDuplicate()

## 사용자 숫자 입력 기능

### 사용자 야구 게임 숫자 입력 기능

사용자로부터 야구 게임의 숫자를 입력받는 기능을 구현한다. - [InputView](#InputView)#inputPositiveNumber()

- [x] ❗️ 빈 문자열 입력일 경우 예외처리 한다. - [InputView](#InputView)#validateBlankString()
- [x] ❗️ 문자, 특수기호 등의 입력이 있을 경우 예외처리 한다. - [InputView](#InputView)#validateNumber()
- [x] ❗️ 음수의 입력이 감지될 경우 예외처리 한다. - [InputView](#InputView)#validatePositiveNumber()
- [x] ❗️ 3자리의 숫자가 아닐 경우 예외처리 한다. - [GameNumbers](#GameNumbers)#validateSize()
- [x] ❗️ 숫자는 1~9 범위의 자연수가 아닐 경우 예외처리 한다. - [GameNumbers](#GameNumbers)#validateRange()
- [x] ❗️ 3자리의 숫자 중 중복 숫자가 있을 경우 예외처리 한다. - [GameNumbers](#GameNumbers)#validateDuplicate()
- [x] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 사용자 재시작 여부 입력 기능

게임을 시작할 지, 끝낼 지 여부를 사용자로부터 입력받는 기능을 구현한다. - [InputView](#InputView)#inputPositiveNumber()

- [x] ❗️ 1, 2 숫자 외의 다른 입력을 받을 경우 예외처리 한다. - [Status](#Status)#from()
- [x] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 숫자 비교 및 판단 기능

사용자의 입력과 랜덤 생성 숫자를 비교하는 기능을 구현한다. - [Game](#Game)#judgeNumberAt()

- [x] 동일한 자리에 동일한 숫자가 있다면 `스트라이크`로 판단한다.
    - ex) XX1 - XX1 : 스트라이크
- [x] 다른 자리에 동일한 숫자가 있다면 `볼`로 판단한다.
    - ex) X1X - XX1 : 볼
- [x] 결과적으로, 동일한 숫자가 하나도 없다면 `낫싱`으로 판단한다.
    - ex) 123 - 456 : 낫싱
    - [Result](#Result)#toString()에서 `ball`과 `strike`점수가 0일 경우, `낫싱`으로 판단

## 출력 기능

숫자 야구 게임의 가이드를 출력하는 기능을 구현한다.

- [x] 초기 시작 안내 문구를 출력한다. - [OutputView](#OutputView)#printStartMessage()
- [x] 매 턴 숫자 입력 안내 문구를 출력한다. - [OutputView](#OutputView)#printInputGuideMessage()

숫자 야구 게임의 결과를 출력하는 기능을 구현한다.

- [x] 결과를 출력한다. - [OutputView](#OutputView)#printResult()
    - 출력 양식은 `{볼 횟수}볼 {스트라이크 횟수}스트라이크`를 따른다.
    - 볼과 스트라이크 횟수 중 하나가 0일 경우, 각각 `{스트라이크 횟수}스트라이크`, `{볼 횟수}볼`로 출력한다.
    - 낫싱의 경우, `낫싱`으로 출력한다.
- [x] 게임 종료 문구를 출력한다. - [OutputView](#OutputView)#printDoneMessage()
    - 게임 종료 문구로 `3개의 숫자를 모두 맞히셨습니다! 게임 종료`를 출력한다.

## 게임 흐름 제어 기능

- [x] 스트라이크 횟수가 3회가 아닐 경우, [사용자 야구 게임 숫자 입력 기능](#사용자-야구-게임-숫자-입력-기능)으로 넘어간다.
- [x] 스트라이크 횟수가 3회일 경우, [사용자 재시작 여부 입력 기능](#사용자-재시작-여부-입력-기능)으로 넘어간다.
    - [x] 1을 입력 받았다면 게임은 재시작된다.
    - [x] 2를 입력 받았다면 애플리케이션은 [출력 기능](#출력-기능)의 게임 종료 문구를 출력한 뒤 종료되어야 한다.

# 🌐 필요한 객체와 책임

## [GameController](../src/main/java/baseball/controller/GameController.java)

- 게임의 실행, 재실행, 종료를 판단한다.
- `InputView`로부터 입력을 받는다.
- `Game`을 생성한다.
- `OutputView`로 결과를 전달한다.

## [Game](../src/main/java/baseball/model/Game.java)

- Computer의 `GameNumbers`와, User의 `GameNumbers`를 저장한다.
- 게임의 결과인 `Result`를 저장한다.
- 야구 게임의 로직을 수행한다.
    - 숫자 비교 한 뒤 결과를 도출한다.
    - 도출한 결과를 `Result`에 저장한다.

## [GameNumbers](../src/main/java/baseball/model/GameNumbers.java)

- 야구 게임의 숫자를 저장한다.
- 랜덤 숫자를 생성한다.
- 사용자의 입력 숫자가 유효한 숫자인지 검증한다.

## [Result](../src/main/java/baseball/model/Result.java)

- 야구 게임의 결과를 저장한다.

## [Status](../src/main/java/baseball/model/Status.java)

- 야구 게임 재시작/종료 상태를 저장한다.

## [InputView](../src/main/java/baseball/view/InputView.java)

- 사용자로부터 입력을 받는다.
- 유효하지 않은 입력에 대한 기본 예외 처리를 한다.
    - ex) 빈 문자열 입력
- 받은 입력을 `GameController`에게 전달한다.

## [OutputView](../src/main/java/baseball/view/OutputView.java)

- `Result`를 `GameController`로부터 전달받는다.
- `Result`를 사용자에게 출력하여 알린다.
