# 기능 구현 목록 - 숫자 야구

## 🗂️ Model

### Player

- attributes
    - `suggestedNumber` : 플레이어가 제시한 숫자
- methods
    - `updateSuggestedNumber()` : 플레이어가 제시한 숫자 저장
    - `getSuggestedNumber()` : 저장된 숫자 반환

### Computer

- attributes
    - `secretNumber` : 컴퓨터가 생성한 랜덤 숫자
- methods
    - `generateSecretNumber()` : 랜덤으로 생성한 숫자 저장
    - `getSecretNumber()` : 저장된 숫자 반환

### Game

- attributes
    - `status` : 현재 게임 상태 (대기, 진행 중)
- methods
    - `startGame()` : 게임 상태 진행 중으로 업데이트
    - `endGame()` : 게임 상태 대기로 업데이트
    - `restartGame()` : 게임 상태 진행 중으로 업데이트
    - `getStatus()` : 게임 상태 반환

### Round

- attributes
    - `balls` : 볼 개수
    - `strikes` : 스트라이크 개수
- methods
    - `calculateBallsAndStrikes()` : 두 숫자를 비교해 볼과 스트라이크 계산

## 👩🏻‍💻 View

### InputView

- methods
    - `getSuggestedNumber()` : “숫자를 입력해주세요 : “ 입력
    - `getGameContinueChoice()` : “게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.” 입력

### OutputView

- methods
    - `printGameStart()` : “숫자 야구 게임을 시작합니다.” 출력
    - `printGameEnd()` : “3개의 숫자를 모두 맞히셨습니다! 게임 종료” 출력
    - `printStrikeAndBallHint()` : “[1..3]스트라이크 / [1..3]볼 / [1..3]볼 [1..3] 스트라이크” 출력

## 📡 Controller

### BaseballGameController

- attributes
    - `player` : 플레이어 숫자 관리
    - `computer` : 컴퓨터 숫자 관리
    - `gameStatus` : 게임 상태 관리
    - `round` : 각 라운드의 결과(볼과 스트라이크 수) 관리
- methods (view → model → view)
    - `startGame()` : 게임 시작
        - (v)printGameStart → (m)startGame, (m)generateSecretNumber, (m)getSecretNumber
    - `startRound()` : 라운드 진행
        - (v)getSuggestedNumber → (m)updateSuggestedNumber, (m)getSuggestedNumber, (m)calculateBallsAndStrikes → (v)
          printStrikeAndBallHint
    - `restartOrEndGame()` : 게임 재시작하거나 종료
        - (v)getGameContineuChoice → (m)restartGame, (m)generateSecretNumber, (m)getSecretNumber
        - or (v)getGameContineuChoice → (m)endGame, (m)

### ExceptionHandler

- methods
    - `validateSuggestedNumber()` :  플레이어가 제시한 숫자 유효성 검사
    - `validateGameStatus()` : 플레이어가 제시한 게임 지속 여부 유효성 검사

## 🔑 Enums

### ErrorCode

- 숫자의 길이가 3이 아닙니다.
- 중복된 숫자가 있습니다.
- 1~9 사이의 숫자가 아닙니다.
- 지속 여부를 표시하는 1~2 사이의 숫자가 아닙니다.

### GameStatus

- 진행 중
- 대기

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


