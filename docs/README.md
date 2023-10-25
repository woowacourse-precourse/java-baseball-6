## 구현할 기능 목록

### 입력

- 서로 다른 3자리의 수 입력 받기
- 잘못된 값 입력시 IllegalArgumentException 발생 후 애플리케이션 종료
- 게임 종료 및 지속 여부 입력 판단

### 정답 결과

- 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼 (종합)
- 같은 수가 전혀 없으면 낫싱

### 출력

- 정답 (3스트라이크) 일경우 게임 종료 및 재시작 여부 문구 출력
- 종료
- 재시작

### 컴퓨터

- 1~9까지 서로 다른 임의의 수 3개를 선택후 세자리 수 생성
- 입력 값에 대한 정답 결과 주기

---

## 구현 제한 사항

- 프로그램 종료시 System.exit() 호출 금지
- 모든 Test 통과
- 지정된 라이브러리 사용
    - camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현
    - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용
    - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용.