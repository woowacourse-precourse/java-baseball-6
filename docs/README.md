# 기능 목록

---

## GamePlay

- `baseballGamePlay()` 는 야구 게임이 시작되면서 랜덤한 숫자를 지정하고, 사용자가 해당 숫자를 맞추는 과정을 진행합니다. 이 과정에서 3 스트라이크가 발생하면 게임을 종료합니다.

---

## RamdomNumber

- `ramdomBaseballNumber()` 는 세 개의 숫자를 랜덤하게 생성하여 저장합니다.

---

## GameHint

- `baseballGameHint()` 는 랜덤 숫자 3개와 사용자 입력 숫자 3개를 `comparePositionsNumber()` 함수에 넘겨줍니다. `comparePositionsNumber()` 함수의
  결과가 3스트라이크면 `baseballGameHint()` 함수는 3을 반환합니다.

---

## ComparePositions

- `comparePositionsNumber()` 는 스트라이크와 볼을 구하고, 그 결과를 변수에 저장하는 함수입니다.
- `getStrikes()` 는 스트라이크 개수를 구하는 함수입니다.
- `getBalls()` 는 사용자 입력 숫자와 지정된 랜덤 숫자가 일치하면 개수를 증가시키는 함수입니다.

---

## InputMessage

- `inputMessageNumber()` 는 사용자로부터 숫자를 입력받는 함수입니다.
- `getGameStatusInput()` 는 게임이 종료된 후 게임을 다시 시작할 것인지, 종료할 것인지 사용자의 입력을 받는 함수입니다.

---

## OutputMessage

- `printMessageStartBaseballGame()` 는 "숫자 야구 게임을 시작합니다" 라는 문장을 출력하는 함수입니다.
- `printEnterNumber()`는 "숫자를 입력해주세요" 라는 문장를 출력하는 함수입니다.
- `outputStrikeBallConsoleMessage()` 는 스트라이크 개수와 볼 개수를 입력받아, 스트라이크와 볼이 있으면 내용을 출력하고, 없으면 "낫싱"을 출력하는 함수입니다.

## Validation

- `validationCheck()`는 사용자가 입력한 3개의 숫자가 유효한지 검증하는 함수입니다.
    - 검증 내용
    - 3자리 이상 입력할 경우 `IllegalArgumentException`을 발생
    - 1~9 까지의 숫자를 입력 하지 않았을 경우 `IllegalArgumentException`을 발생
    - 동일한 숫자를 2개 이상 입력했을 경우 `IllegalArgumentException`을 발생