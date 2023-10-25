# 숫자 야구 개발 기획

```mermaid
graph TB
    Start("어플리케이션 시작") --> PrintStart("게임 시작 문구 출력")
    PrintStart --> GenerateRandom("컴퓨터: 임의의 수 3개 선택")
    GenerateRandom --> PlayerInput("플레이어: 서로 다른 3개의 숫자 입력")
    PlayerInput --> Validation{"플레이어 입력값 검증"}
    Validation -- " 실패 " --> Exception("IllegalArgumentException: 종료")
    Validation -- " 성공 " --> CheckLogic("컴퓨터: 입력 결과 채점")
    CheckLogic --> isSuccess{"정답 처리"}
    isSuccess -- " 성공 " --> PrintSuccess("정답 문구 출력, 게임 재시작?")
    PrintSuccess --> Continue{"게임 재시작 ?"}
    Continue -- " 종료 " --> End("어플리케이션 종료")
    Continue -- " 재시작 " --> PrintStart
    isSuccess -- " 실패 " --> PrintHint("힌트 문구 출력, 다시 서로 다른 3개의 숫자 입력 요청")
    PrintHint --> PlayerInput
    Exception --> End
```

# Todos

- [x] 컴퓨터가 임의의 수를 생성하는 기능
    - [x] 수를 저장하는 Numbers 클래스 생성
    - [x] 사용되는 상수를 저장하는 Enum 클래스 생성
- [x] 사용자가 입력을 받는 기능
    - [x] 사용자 입력을 검증하는 기능
    - [x] 검증기의 테스트 코드 작성
- [ ] 컴퓨터가 사용자 입력을 채점하는 기능
    - [ ] 사용자 입력을 채점하는 채점기 클래스 생성
    - [ ] 채점기의 테스트 코드 작성
- [ ] 게임을 관장하는 기능
    - [ ] 게임을 관장하는 클래스 생성
    - [ ] 문구를 출력하는 기능
    - [ ] 게임을 관장하는 클래스의 테스트 코드 작성