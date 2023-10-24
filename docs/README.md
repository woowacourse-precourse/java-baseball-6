# 숫자 야구 게임 구현 기능 목록

## 컴퓨터 숫자 선택 기능

- `createRandomNumberList` 메서드 구현
    - 각 자릿수가 다른 random한 세 자리 숫자 리스트를 반환
        - `Randoms.pickNumberInRange()`를 활용하여 random number 생성
        - 생성된 random number와 중복인 숫자가 리스트 내 존재하는지 검사 후 추가

## 스트라이크 및 볼 개수 확인 기능

- `evaluatePlayerGuess` 메서드 구현
    - 컴퓨터의 숫자 리스트와 플레이어의 입력값 리스트를 매개변수로 받아, 스트라이크와 볼의 개수를 객체로 묶어 반환
    - `countStrikes`와 `countBalls` 메서드를 활용
        - `countStrikes` 메서드: 동일한 위치의 숫자를 비교하여 스트라이크 개수를 반환
        - `countBalls` 메서드: 서로 다른 위치의 숫자를 비교하여 볼 개수를 반환

## 게임 종료 판별 기능

- `isGameEnded` 메서드 구현
    - 스트라이크 개수를 매개변수로 받아, 스트라이크 개수가 3개이면 true를 반환, 아니면 false를 반환

## 게임 재시작/프로그램 종료 선택 기능

- `promptRestartOrExit` 메서드 구현
    - 사용자에게 재시작 또는 종료 선택을 입력 받아 반환
        - 잘못된 입력값에 대한 예외 처리 포함

## 플레이어의 예측 정답값 입력 기능

- `promptPlayerGuess` 메서드 구현
    - 사용자에게 예측 정답값을 입력 받아 반환
        - 잘못된 입력값에 대한 예외 처리 포함

## 게임 시작 문구 출력 기능

- `displayGameStartMessage` 메서드 구현

## 플레이 결과 출력 기능

- `displayGameResult` 메서드 구현
    - 스트라이크와 볼의 개수를 매개변수로 받아, 결과를 출력

## 예외 상황 처리 기능

- `validateInput` 메서드 구현
    - 입력값과 검증 규칙을 매개변수로 받아, 유효하지 않은 입력에 대해 예외를 발생
