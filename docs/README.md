# 구현 기능 목록 정리
## 생성
- 1~9까지의 3자리의 중복되지 않는 랜덤 숫자 생성(상대방 역할)

## 입력
- 1~9까지의 3자리의 중복되지 않는 숫자(게임플레이어)
- 게임 재시작/종료를 구분하는 수
  - 1 : 게임 재시작
  - 2 : 종료
  - 그 외 : `IllegalArgumentException` 에러 발생

## 출력
- 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시
#### 규칙
- 자리와 숫자가 일치 : 스트라이크
- 숫자만 일치 : 볼
- 같은 수 없음 : 낫싱

### 게임 종료
- 3개의 숫자를 모두 맞힌 경우 
```
 3스트라이크
 3개의 숫자를 모두 맞히셨습니다! 게임 종료
 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
```  
### 그 외
- 게임 시작 문구 출력
```
  숫자 야구 게임을 시작합니다.
```

## 라이브러리

- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.