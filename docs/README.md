# 프리코스 1주차 미션 - 숫자 야구 기능 명세서

---

## InputValueChecker


  - 사용자로부터 입력 받은 값의 유효성을 파악하는 클래스


  - checkNumberValidation()
    - 사용자가 게임 과정에서 입력하는 값이 3글자이며, 중복되는 숫자가 없고, 0으로 시작하지 않는지 확인
    - 유효하지 않는 값을 입력하는 경우, IllegalArgumentException 발생
  

  - checkSignalValidation()
    - 게임이 모두 끝난 뒤, 사용자의 게임 진행 여부를 입력받아 입력의 유효성을 확인
    - 1 혹은 2를 제외한 나머지의 값을 입력하는 경우, IllegalArgumentException 발생
    

  - checkDuplication()
    - 사용자가 중복된 숫자를 입력하였는지 확인
    - 중복된 값이라고 판단되는 경우, false 반환
    

## BaseBallChecker

- 사용자가 입력한 숫자의 결과값을 출력하는 클래스


- checkGameResult()
  - 사용자가 입력한 값에 대한 결과값을 정수의 형태로 반환
  - 1볼 -> 10, 2볼 -> 20, 3볼 -> 30
  - 1스트라이크 -> 1, 2스트라이크 -> 2, 3스트라이크 -> 3
  - 1볼 1스트라이크인 경우, 10 + 1 = 11의 값을 반환


## GameResultMessage

- 게임 결과 메세지를 관리하는 열겨형 클래스


- getMessageByCode()
    - BaseBallChecker의 결과값으로 반환된 정수값을 토대로 출력 메세지를 결정
  

## GameDefaultMessage

- 게임 과정에서 로그에 출력되는 메세지를 관리하는 열거형 클래스

## NumberFactory

- 숫자 야구에서 정답으로 사용할 임의의 3자리 수를 생성하는 클래스


- getRandomNumber()
  - 기본적으로 제공되는 Randoms 클래스의 API를 활용
  - 임의의 3자리의 수를 반환
  - 중복되는 숫자가 반환될 경우, 다시 임의의 수를 반환

## Game

- 숫자 야구 게임을 관리하는 클래스

- startGame()
  - 숫자 야구 게임 시작
  - 사용자가 3자리의 수를 모두 맞힐때까지 진행
  - 사용자가 정답을 맞힐 경우, 1을 입력하여 계속 게임을 진행하거나, 2를 입력하여 종료할 수 있음


# Git Convention

---

```
- feat : 기능추가
- fix : 버그 수정
- refactor : 리팩토링, 기능은 그대로 두고 코드를 수정
- style : formatting, 세미콜론 추가 / 코드 변경은 없음
- chore : 라이브러리 설치, 빌드 작업 업데이트
- docs : 주석 추가 삭제, 문서 변경
```

