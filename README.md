# 미션 - 숫자 야구

## 기능 목록
- CONSTANT
  - 필요한 숫자 , 문자열 모두 상수로 구현
- GAME
  - 난수생성
    - CreateRandomNumber
  - 메인 루프
    - 전체 게임에 대한 시작 루프
    - Start
      
  - 사용자 입력
    - UserInput
      
  - String to List<Integet> 변환기능
    - StringToIntegetList

  - 사용자 입력값에 대한 검증
    - 볼이면 볼 , 스트라이크면 스트라이크 , 낫씽이면 낫씽
    - 잘못된 값이면 IllegalArgumentException
    - InputValidation
      - Ball
      - Strike
      - Nothing
        
  - 검증 결과에 대한 Print
    - BallPrint
    - StrikePrint
    - NothingPrint
    
  - 정답시 게임 종료
    - GameEndPrint
      
  - 재시작 질문
    - 1 - 재시작 , 2 - 종료
    - RestartPrint

## Game 시나리오
- (1) 게임시작
- (2) 난수생성
- (3) 사용자 입력
- (4) 사용자 입력 값 검증
- (5) 검증 결과 Print
- (6) 정답시 게임 종료
- (7) 재시작 질문
  - 재시작시 (1)로 돌아감
  - (8) 종료














