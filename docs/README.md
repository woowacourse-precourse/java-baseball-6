# 기능 구현 목록 - 숫자 야구

## 📘 용어 정의

- `게임` : 숫자 야구 게임을 시작해서 완전히 종료하기까지의 과정
- `라운드` : 컴퓨터가 랜덤한 숫자를 생성해서 사용자가 맞추기까지의 과정(사용자가 재시작 원하면 여러 번 반복 가능)
- `턴` : 사용자에게 숫자를 입력 받아 해당 라운드의 컴퓨터가 생성한 숫자와 비교 후 결과(볼, 스트라이크 개수)를 반환하기까지의 과정

## 🗂️ Model

### Game

✅ 게임의 전체 상태(진행 중/종료)를 관리할 수 있다.

- attributes
    - `status` : 현재 게임 상태 (초기값은 `진행 중`)
- features
    - `start()` : 게임 상태 `진행 중`으로 초기화
    - `end()` : 게임 상태 `종료`로 업데이트
    - `isEnd()` : 개암 상태 `종료`안자 여부 반환

### Round

✅ 사용자가 게임을 시작/재시작해서 새로운 라운드가 시작를 때마다, 사용자가 맞출 숫자를 랜덤으로 생성할 수 있다.

- attributes
    - `randomNumber` : 생성한 랜덤 숫자
- features
    - `generateRandomNumber()` : 랜덤으로 숫자 생성
    - `getRandomNumber()` : 생성해 둔 숫자 반환

### Turn

✅ 사용자가 입력한 숫자 해당 라운드의 숫자와 비교 후, 볼과 스트라이크의 개수를 계산할 수 있다.

✅ 해당 턴의 결과가 3스트라이크인지 아닌지를 판단할 수 있다.

- attributes
    - `balls` : 볼 개수
    - `strikes` : 스트라이크 개수
- features
    - `calculateBallsAndStrikes()` : 두 숫자를 비교해 볼과 스트라이크 계산

## 👩🏻‍💻 View

### InputView

✅ 턴마다 사용자의 숫자를 입력받을 수 있다.

✅ 라운드 종료 후 게임의 지속 여부를 입력받을 수 있다.

- features
    - `getPlayerNumber()` : “숫자를 입력해주세요 : “ 입력
    - `getGameContinuationInput()` : “게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.” 입력

### OutputView

✅ 게임 시작 메시지를 출력할 수 있다.

✅ 라운드 종료 메시지를 출력할 수 있다.

✅ 각 턴의 결과를 출력할 수 있다.

- features
    - `printGameStart()` : “숫자 야구 게임을 시작합니다.” 출력
    - `printRoundEnd()` : “3개의 숫자를 모두 맞히셨습니다! 게임 종료” 출력
    - `printTurnResult()` : “[1..3]스트라이크 / [1..3]볼 / [1..3]볼 [1..3] 스트라이크” 출력

## 📡 Controller

### BaseballGameController

✅ 숫자 야구 게임을 시작해서 종료하기까지 컨트롤할 수 있다.

- attributes
    - `game` : 숫자 야구 게임 상태 관리 모델
    - `inputView` : 입력용 뷰
    - `outputView` : 출력용 뷰
- features (view → model → view)
    - `startGame()` : 게임 시작해 게임 종료될 때까지 라운드를 여러 번 반복 진행
        - (v)`printGameStart` → (m)`isGameEnd()`
    - `startRound()` : 라운드 시작해 사용자가 정답 마칠 때까지 여러 턴 반복 진행
        - (m)`getRandomNumber`
        - (v)`getPlayerNumber` → (m)`generateResult`→ (v)`printTurnResult`
    - `endRound()` : 라운드 종료 후 게임 재시작/종료 결정
        - (v)`printRoundEnd`, (v)`getGameContinuationInput` → (m)`end`

### InputValidator

✅ 사용자가 입력한 값을 검증할 수 있다.

- features
    - `validatePlayerNumber()` :  플레이어가 제시한 숫자 유효성 검사

## 🔑 Enums

### ErrorCode

✅ 예외 메시지를 한데 모아 관리한다.

- `WRONG_LENGTH` : "숫자의 길이가 3이 아닙니다."
- `DUPLICATE_NUMBER` : "중복된 숫자가 있습니다."
- `OUT_OF_RANGE` : "1~9 사이의 숫자가 아닙니다."
- `INVALID_CONTINUATION_INPUT` : "재시작/종료를 구분하는 1 또는 2의 숫자가 아닙니다."

### GameStatus

✅ 사용자가 게임을 완전히 종료하고 싶은 시점 전까지 게임 상태를 진행 중으로 처리할 수 있게 한다.

- `IN_PROGRESS` : 진행 중
- `END` : 종료

### GameContinuationOption

✅ 사용자가 게임을 완전히 종료하고 싶은지, 재시작하고 싶은지 구분할 수 있게 한다.

- `RESTART` : 재시작
- `END` : 완전히 종료

# 부록

## A. Requirement list

| No. | Use Case | Requirement                                         |
|-----|----------|-----------------------------------------------------|
| 1   | 게임 시작    | 사용자는 `게임을 시작`해 컴퓨터가 `3자리 숫자를 생성`하게 할 수 있다.          |
| 2   | 숫자 제시    | 사용자는 `3자리 숫자를 입력`할 수 있다.                            |
| 3   | 힌트/정답 조회 | 사용자는 3자리 숫자 입력 후 `엔터`를 눌러 `몇 개의 숫자를 맞췄는지 확인`할 수 있다. |
| 4   | 게임 재시작   | 사용자는 `1을 입력`하고 `엔터`를 눌러 `게임을 재시작`할 수 있다.            |
| 5   | 게임 종료    | 사용자는 `2를 입력`하고 `엔터`를 눌러 `게임을 완전히 종료`할 수 있다.         |

## B. Use Case Descriptions

### 1. 게임 시작

| Actor Action        | System Response             |
|---------------------|-----------------------------|
| 1. 사용자가 프로그램을 실행한다. | 2. 숫자 야구 게임을 시작한단 문구를 출력한다. |

### 2. 숫자 제시

| Actor Action          | System Response       |
|-----------------------|-----------------------|
|                       | 1. 숫자를 입력하란 문구를 출력한다. |
| 2. 사용자가 3자리 숫자를 입력한다. |                       |

### 3. 힌트/정답 조회

| Actor Action                 | System Response                                |
|------------------------------|------------------------------------------------|
| 1. 사용자가 3자리 숫자 입력 후 엔터를 누른다. | 2. 몇 개의 숫자를 맞췄는지 출력한다. 정답일 경우엔 축하 문구도 함께 출력한다. |

### 4. 게임 재시작

| Actor Action            | System Response                 |
|-------------------------|---------------------------------|
| 1. 정답을 맞춘 사용자가 1을 입력한다. | 2. 3자리 숫자를 생성하고 숫자 제시 단계로 넘어간다. |

### 5. 게임 종료

| Actor Action            | System Response |
|-------------------------|-----------------|
| 1. 정답을 맞춘 사용자가 2를 입력한다. | 2. 프로그램을 종료한다.  |

## C. Design Patterns

### MVC 도입 (view → controller → model → controller → view)

- mvc 정의
    - model : 모든 view에게 이벤트로 인해 변경된 데이터 알려줌
    - view : 데이터 변경될 때마다 model로부터 데이터 가져옴
    - controller : view에서 일어나는 이벤트 캐치해서 model에게 알려주고, model에서 변경된 데이터를 view에게 전달해줌

- mvc 과정
    - view가 이벤트를 감지

      → (controller가 view에서 감지된 이벤트를 model에게 전달해줌)

      → model이 이벤트에 대한 데이터 처리(변경)

      → (controller가 model에서 변경된 데이터를 view에게 전달해줌)

      → view가 변경된 데이터 받음

- 게임 프로세스에 적용한 mvc 과정
    - 3자리 숫자 틀렸을 때
        - view가 플레이어의 숫자 제시 이벤트 감지

          (→ controller가 숫자를 model에게 전달해줌)

          → model이 플레이어가 제시한 숫자를 보고 검증 후 저장, 결과도 계산해 저장

          (→ controller가 결과를 view에게 전달해줌)

          → view가 model로부터 힌트라는 결과 받아 띄어줌

    - 3자리 숫자 맞았을 때
        - view가 플레이어의 숫자 제시 이벤트 감지

          (→ controller가 숫자를 model에게 전달해줌)

          → model이 플레이어가 제시한 숫자를 보고 검증 후 저장, 결과도 계산해 저장

          (→ controller가 숫자를 view에게 전달해줌)

          → view가 model로부터 정답이라는 결과 받아 띄어줌

        - view가 플레이어가 제시한 게임 지속(중지) 이벤트 감지

          (→ controller가 게임 지속(중지) 상태를 model에게 전달해줌)

          → model이 플레이어가 제시한 게임 지속(중지)이란 상태 보고 검증 후 저장

          (→ controller가 게임 지속(중지) 상태를 view에게 전달해줌)

          → view가 model로부터 게임 지속(중지)이란 결과 받아 띄어줌


