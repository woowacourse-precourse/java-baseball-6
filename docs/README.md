## 기능 목록

---

### 명칭 정의

1. 상대방 (opponent)는 컴퓨터이다.
2. 플레이어 (player)는 사용자이다.

<br>

### feature

-[x] 게임 시작 시 상대방의 서로 겹치지 않는 무작위 숫자 3개를 생성한다.

```
camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange() 사용
```

-[x] 플레이어가 예상 숫자를 입력할 수 있다.

```
camp.nextstep.edu.missionutils.Console의 readLine() 사용
```

-[x] 상대방의 숫자를 맞추지 못했다면 힌트를 보여주고 재입력을 요구한다.
-[x] 힌트는 플레이어의 입력값과 상대방 숫자를 비교해 strike / ball / nothing 을 출력한다.
-[x] 상대방의 숫자를 맞췄다면, 플레이어는 게임을 1번을 누르면 재시작, 2번을 누르면 실행 종료할 수 있다.

```
상대방이 생성한 숫자 [1, 3, 5]

- 숫자를 입력해주세요 : 플레이어 입력값 [2,4,6] : 힌트 [낫싱]                  
- 숫자를 입력해주세요 : 플레이어 입력값 [1,3,5] : 힌트 [3스트라이크]

3개의 숫자를 모두 맞히셨습니다! 게임 종료
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.

- 플레이어 입력값 [1]
숫자를 입력해주세요 :

- 플레이어 입력값 [2]
게임 종료
```

<br>

### subfeature

-[x] 플레이어의 입력값을 validation을 통해 검증한다.

<br>

##### 검증 예외 목록

-[x] 3자리를 초과한 입력값 ``IllegalArgumentException``
-[x] 1~9가 아닌 입력값 ``IllegalArgumentException``
-[x] 중복된 입력값 ``IllegalArgumentException``
-[x] 1과 2가 아닌 입력값 (재시작 관련 예외) ``IllegalArgumentException``

<br>
---

