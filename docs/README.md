# 구현할 기능 목록

## Domain

- Ball
  - [x] `Ball` 생성 기능
    - 숫자를 입력받아 `Ball`을 생성한다.
    - 숫자는 1이상 9이하여야 한다.
- Balls
  - [x] `Balls` 생성 기능
    - 세 자리 숫자를 입력받아 `Balls`를 생성한다.
  - [x] 볼 개수를 판단하는 기능
    - `Balls` 를 입력받아 볼 개수를 반환한다.
  - [x] 스트라이크 개수를 판단하는 기능
    - `Balls` 를 입력받아 스트라이크 개수를 반환한다.
- GameStatus
  - [x] 게임 결과를 반환하는 기능
    - 볼, 스트라이크 개수를 입력받아 `GameResult`를 반환한다.
    - `GameCommand`를 입력받아 `GameResult`를 반환한다.
- GameCommand
  - [x] 재시작/종료를 반환하는 기능
    - 숫자를 입력받아 `GameCommand`를 반환한다.

## Input

- [x] 플레이어 숫자를 입력받는 기능
- [x] 재시작/종료를 입력받는 기능

## Output

- [x] 볼, 스트라이크 개수를 출력하는 기능
- [x] 게임 시작 메세지 출력 기능
- [x] 게임 종료 메세지 출력 기능

## Utils

- Converter
  - [x] int를 List<Integer>로 변환하는 기능

- NumberGenerator
  - [x] 중복되지 않는 랜덤한 숫자를 생성하는 기능
    - 숫자의 범위와 자릿수를 입력받아 랜덤한 숫자를 반환한다.
