# 기능 구현

### 게임 흐름에 따른 기능 구현 정리

- [x] 게임 시작
    - [x] 3자리의 난수생성 -> computer
    - [x] 문자열 입력 (정답이 아닌 동안 반복) -> input
        - [x] 입력 변환 -> convert
        - [x] GameNumber 클래스
            - [x] 클래스 추가
            - [x] 입력 검증 -> validate
        - [x] 숫자의 일치여부와 볼, 스트라이크 개수 판별
        - [x] 정보 출력
        - [x] (정답인 경우)게임 종료
    - [x] 재시작 또는 종료 입력
        - [x] 입력 값에 따른 반복 또는 종료

---

### 역할에 맞는 분리를 위한 리팩토링 정리

- [ ] 역할에 맞는 로직 분리
    - [ ] model
        - [x] GameNumber 분리
            - [x] ComputerNumbers
            - [x] UserNumbers
        - [ ] GuessResult
            - [ ] GuessResult를 Round로 변경
            - [ ] RoundResult 추가
    - [x] view
        - [x] InputView
        - [x] OutPutView
    - [x] controller
        - [x] GameController
