# 숫자 야구 게임

## 유저플로우

### BaseballGameApplication

1. 유저는 `BaseballGameApplication`에서 각 `Round`를 반복한다.
2. `BallsFactory`가 3자리 숫자로 이뤄진 정답 숫자인 `Balls`객체를 생성한다.
3. 정답 숫자를 가지고 심판 역할(비교 연산, 결과 출력)을 하는 `Referee` 객체를 생성한다.
4. 한 `Round`가 끝나면 다음 `Round` 실행 여부를 입력받는다.

   ex: (”1” → 반복, “2” → 종료)


### RoundApplication

1. `Referee` 객체에 저장된 스트라이크와 볼을 초기화한다.
2. 유저에게 중복이 없는 1 ~ 9까지의 세 자리 숫자를 입력받는다.
3. 입력받은 세 자리 숫자로 `Balls` 객체를 생성한다.
4. `Referee` 객체는 유저에게 입력받은 숫자와 정답 숫자를 비교 결과를 담은 `Pitching` 객체를 생성한다.
5. 결과를 출력한다.
6. 3 스트라이크가 아니면 다시 반복한다.

## 구현 기능 목록

### game

- BaseballGameApplication
  - [x]  게임 종료 후 다시 시작 / 종료 여부 입력받기

- RoundApplication
  - [x]  사용자가 추측한 숫자 입력받기

- Referee
  - [x]  정답 숫자와 사용자의 숫자를 비교해 결과 반환


### domain

- Balls
  - [x]  길이가 3인 List<Integer> balls 저장
  - [x]  전달받은 숫자가 balls에 포함되는지 여부 반환
  - [x]  balls에서 전달받은 인덱스 위치에 있는 숫자 반환
  - [x]  사용자가 입력한 숫자 검증
- BallsFactory
  - [x]  1~9의 랜덤 숫자로 구성된 중복이 없는 세 자리 List<Integer> 생성
- Pitching

  라운드에서 사용자가 값을 추측하는 한 번의 시도 결과를 저장하는 레코드 클래스


### view

- ApplicationConsole
  - [x]  안내 메시지 출력하기
  - [x]  사용자로부터 값 입력받기