## 구현할 기능 목록


### Model

---

- GameNumber
    - 정답 조건에 맞는 숫자 도메인
        - 세 자리의 서로 다른 숫자
        - 이때 숫자는 1-9 사이

### View

---

- InputView
    - 정답 시도
    - 게임 재시작
- OutputView
    - 게임 시작
    - 게임 종료
    - 힌트

### Controller

---

- GameController
    - 전체적인 게임 진행
- ComputerController
    - 컴퓨터 수행 역할
        - 정답 결정
        - 힌트 결정
            - 스트라이크, 볼 개수 세기
            - 낫싱 판단
- RamdomNumberController
    - 난수 생성 역할
        - 숫자
        - 3자리
        - 서로 다른 수
- InputNumberController
    - 사용자의 입력 검사
        - 숫자
        - 재시작 : 1,2인지
        - 시도 : 3자리, 서로 다른 숫자인지
    - 사용자의 입력 적절하면 타입 변환
        - String → GameNumber