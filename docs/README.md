## ✏️ 구현할 기능 목록

### 객체

1. computer : 'camp.nextstep.edu.missionutils.Randoms'을 이용한 랜덤 값

- 랜덤 값을 저장할 변수

2. user : 사용자가 입력한 값

- 사용자가 입력한 값을 저장 할 변수
- 점수 저장하는 변수 (strike, ball)

### Service (클래스 별 테스트 코드 추가)

```
1. MakeComputerRandom : createRandom()
2. MakeUserAnswer : input()
3. UserValidation : validation(), restartValid()
4. Play : playBaseballGame()
5. PrintResult : result()
6. Restart : restartOrExit()
```

### 메서드 정의

```
1. createRandom() : 컴퓨터 랜덤 값 만들기
2. input() : 사용자의 입력 받기
3. validation() : 사용자의 잘못된 값을 입력했는지 validate
4. playBaseballGame() : 야구 게임 로직 (볼, 스트라이크, 낫싱)
5. result() : 결과 출력
6. restartOrExit() : 게임 종료 후 다시 시작하거나 완전히 완료 시킬지 결정 (1: 새로 시작, 2: 종료)
7. restartValid() : 게임 재시작을 위해 입력한 값(1 or 2) 검증
```

### 메서드 로직 설명

- createRandom() : 'Randoms()'을 이용해 컴퓨터의 랜덤 값 생성
- input() : 사용자 입력 받기 + 검증 로직 실행
- validation() :
  1.입력된 값이 서로 다른 값인지 검증
  2.숫자가 입력됐는지 검증
  3.100~999 사이 숫자인지 검증
- playBaseballGame() :
    1. 유저가 입력한 값이 컴퓨터의 값에 포함되어 있다. && 두 인덱스까지 똑같다. -- strike
    2. 유저가 입력한 값이 컴퓨터의 값에 포함되어 있다. && 두 인덱스는 다르다. -- ball
    3. strike와 ball값을 User 객체에 저장
        - 이유 : User가 입력한 값에 의한 결과 값이므로 User 객체에 묶는게 좋다고 판단
- result() : User에 저장된 strike & ball 변수를 이용해 결과 출력
- restartOrExit() : '3 스트라이크' 인 경우 재시작 or 종료를 위해 사용자 입력 받기 + 검증 로직 실행
- restartValid() :
    1. 입력된 값이 숫자인지 검증
    2. 입력된 값이 1 or 2인지 검증