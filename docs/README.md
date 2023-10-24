### 정리

프로그램을 시작하면 컴퓨터가 1~9 범위의 서로 다른 3가지 숫자를 정답으로 만든다.<br>
`"숫자 야구 게임을 시작합니다."`<br>
`"숫자를 입력해주세요 : "`<br>
을 출력하고 사용자의 입력을 받는다.<br>
사용자의 입력은 1~9의 서로 다른 숫자 3개를 받는다.<br>
사용자의 입력값이 정확히 3자리 숫자인지, 1~9 범위의 숫자를 입력했는지 검증한다.<br>

사용자가 입력한 세 가지 숫자가 컴퓨터가 만든 정답과 일치하는지 확인한다.<br>
같은 숫자지만 다른 자리에 있다면 `"n볼"` 카운트를 올린다.<br>
같은 숫자가 같은 자리에 있다면 `"n스트라이크"` 카운트를 올린다.<br>
정답과 일치하는 수가 전혀 없다면 `"낫싱"`을 출력한다.<br>
볼, 스트라이크 순서로 출력한다.<br>

만약 3가지 숫자와 자리까지 정답과 일치하면<br>
`"3스트라이크"`
`"3개의 숫자를 모두 맞히셨습니다! 게임종료"`를 출력하고<br>
`"게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."`를 출력한다.<br>
사용자에게 `1` 또는 `2`의 입력값을 받는다.<br>
사용자의 입력값이 `1` 또는 `2`인지 검증한다.<br>
`1`이면 `"숫자를 입력해주세요 : "`와 함께 새로운 게임을 시작하고 입력을 받는다.<br>
`2`이면 숫자 야구 게임 애플리케이션을 종료한다.

### View

- `InputView`: 사용자의 입력을 받는 인터페이스.
- `OutputView`: 사용자의 입력에 따른 응답 메세지를 출력하는 인터페이스.
- `BaseballInputView`: 숫자 야구게임 사용자의 입력을 받는 메세지 출력하는 클래스.
- `BaseballOutputView`: 숫자 야구게임 사용자의 입력에 따른 응답 메세지 출력하는 클래스.
- `InputValidator`: 사용자가 입력한 숫자가 `InputView`의 조건에 맞게 입력했는지 검증.

### 도메인

- `BaseballNumbersGenerator`: 3자리 수를 반환하는 메서드가 정의된 인터페이스.
- `RandomBaseballNumbersGenerator`: 1~9 범위의 서로다른 3자리의 무작위 숫자를 정답으로 생성하여 반환.
- `FixedBaseballNumbersGenerator`: 무작위가 아닌 고정된 값으로 테스트하기 위해 만든 숫자 생성기.
- `BaseballNumbers`: 컴퓨터가 만든 1~9 범위의 서로다른 3자리 수를 가지는 일급 컬렉션.
- `BaseballNumber`: 컴퓨터가 만든 1~9 범위의 숫자를 저장.
- `Score`: `"볼"`, `"스트라이크"`를 저장하는 enum.
- `Ball`: `"볼"`을 저장하는 enum.
- `Strike`: `"스트라이크"`를 저장하는 enum.
- `ContinueOrExit`: 게임 종료 후 사용자가 입력한 `1`, `2` 값을 받는 enum.

### 기능 목록

- `BaseballInputView`
    - [x] `inputBaseballNumber()`: `"숫자를 입력해주세요 : "`를 출력하고 `Console.readLine()`으로 3자리 숫자를 입력 받음.
    - [x] `continueOrExit()`: `"게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."`를 출력하고 `1` 또는 `2` 숫자를 입력 받아서 `true`, `false` 반환.
- `BaseballOutputView`
    - [x] `startGame()`: 최초 시작시 `"숫자 야구 게임을 시작합니다."`를 출력.
    - [x] `endGame()`: 매 게임시 3자리 숫자를 모두 맞추면 `"3개의 숫자를 모두 맞히셨습니다! 게임종료"`를 출력.
    - [x] `matchResult()`: `Computer`의 `match()` 메서드에서 `"볼"`, `"스트라이크"`를 넘겨받아서 `Score` 출력.
- `InputValidator`: 사용자가 잘못된 값을 입력시 `IllegalArgumentException` 발생시킨 후 애플리케이션 종료.
    - [x] `validateBaseballNumber()`: `InputView`의 `baseballNumber()`에서 입력받은 숫자가 1~9 범위의 서로다른 3자리 숫자인지 검증.
    - [x] `validateContinueOrExitNumber()`: `InputView`의 `continueOrExit()`에서 입력받은 숫자가 1 또는 2의 한자리 숫자인지 검증.
- `BaseballNumbersGenerator`
    - [x] `BaseballNumbers` 타입을 반환하는 `generate()` 메서드 정의
- `RandomBaseballNumbersGenerator`: `NumbersGenerator` 구현
    - [x] `Randoms.pickNumberInRange()` 메서드를 사용하여 `BaseballNumbers` 타입 반환.
- `FixedBaseballNumbersGenerator`: `NumbersGenerator` 구현
    - [x] `generate()` 메서드를 구현하고, 오버라이딩하여 `String` 타입을 매개변수로 3자리 숫자를 생성하여 `BaseballNumbers` 타입 반환.
- `BaseballNumbers`
    - [x] `calculateScore()`: 숫자 리스트를 사용자의 입력과 비교하여 볼 스트라이크를 계산하여 `Score`객체 반환.
    - [x] `contains()`: `BaseballNumbers`의 리스트에 같은 값이 있는지 반환.
- `BaseballNumber`
    - [x] `isSameValue()`: `BaseballNumber`의 값을 비교하여 같은지 반환.
- `Score`
    - [x] `toString()` 메서드를 오버라이딩하여 `"낫싱"`, `"n볼"`, `"n스트라이크"`, `"n볼 m스트라이크"` 출력.
    - [x] `isStrikeOut()`: 정답과 입력값을 비교하여 `"3스트라이크"`인지 `boolean` 반환.
- `Ball`
    - [x] `isEmpty()`: 볼이 비어있는지 확인.
    - [ ] `toString()` 메서드를 오버라이딩 하여 `isEmpty()`가 `true`인 경우 공백, 아닌 경우 `"n볼"` 출력.
- `Strike`
    - [x] `isEmpty()`: 스트라이크가 비어있는지 확인.
    - [x] `isFullCount()`: 3스트라이크인지 확인.
    - [ ] `toString()` 메서드를 오버라이딩 하여 `isEmpty()`가 `true`인 경우 공백, 아닌 경우 `"n스트라이크"` 출력.
