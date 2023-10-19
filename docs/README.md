## ✏️ 구현할 기능 목록

### 메서드 정의

```
1. input() : 사용자의 입력 받기
2. playBaseballGame() : 야구 게임 로직 (볼, 스트라이크, 낫싱) // 볼, 스트라이크, 낫싱 로직 분리 필요 할 수도... 
3. result() : 결과 출력
4. restartOrExit() : 게임 종료 후 다시 시작하거나 완전히 완료 시킬지 결정 (1: 새로 시작, 2: 종료)
5. validate() : 사용자의 잘못된 값을 입력했는지 validation
```

#### 객체

1. computer : 'camp.nextstep.edu.missionutils.Randoms'을 이용한 랜덤 값

- 랜덤 값을 저장할 변수

2. user : 사용자가 입력한 값

- 사용자가 입력한 값을 저장 할 변수
- 게임 종료 후 restart Or exit 결정할 변수