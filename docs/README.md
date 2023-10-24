*Controller
    
  .GamePlayController
    전반적인 게임 실행 관리를 담당하는 기능
    유저의 입력을 View로부터 받고, 컴퓨터와의 값을 비교해주는 기능
    게임 종료 후 다음 게임의 여부를 담당하는 기능

*Service

  .GameNumberCalculatorService
    컴퓨터와 유저의 게임 넘버를 비교해주는 기능
    게임 넘버 비교를 하기 위해, 스트라이크 및 볼을 카운트 해주는 기능

  .GameStatusService
    게임의 흐름 및 다음 게임을 관리해주는 기능
    다음 게임을 진행할 것인지 여부를 묻고, 상태를 관리한다.

*Domain

   .Computer
     게임 넘버를 설정해주는 기능
   
   .User
     게임 넘버를 설정해주는 기능

*Exception

   .InputNumbersException
     유저가 게임을 위해 입력한 값의 예외를 확인해주는 기능
     3개 이상의 수를 입력했는지 확인 해주는 기능
     유효한 수의 범위를 입력했는지 확인해주는 기능
     중복되지 않았는지 확인해주는 기능

   .AfterGamePlayException
     게임 종료 후 다음 게임의 상태를 위해 유저가 입력하는 값에 대해 예외를 확인해주는 기능
     하나의 숫자만 입력했는지 확인해주는 기능 
     1~2의 숫자 중 골랐는지 확인해주는 기능

*Util

   .StringNumToIntegerNumListParser
     문자열로 들어오는 숫자를 List 타입으로 파싱해주는 기능
   .GenerateComputerGameNumber
     컴퓨터의 랜덤 넘버를 생성해주는 기능

*View

   .UserInputView
     유저의 입력 값을 받고, 예외처리를 진행 한 후 유저의 입력을 저장해주는 기능
   
   .GameResultView
     게임의 결과를 바탕으로 유저에게 적절한 출력을 내려주는 기능

   .UserInputView
     게임 종료 후 다음 게임을 위해 유저가 입력하는 값을 받고 저장해주는 기능