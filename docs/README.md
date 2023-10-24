Controller
	GameFunction
		- inputUserNum
			- 사용자 숫자 입력 기능
		- compareString
			- 사용자 입력 숫자 와 난수 비교 기능
		- compareStrick
			- 비교한 결과에서 Strick 개수 반환 기능
		- compareBall
			- 비교한 결과에서 Ball 개수 반환 기능
		- branchChoice
			- 게임 재시작 or 게임 종료 선택 기능
			
	GameStart		
		- randomNum
			- 세자리수 난수 생성 기능
	ImportFunction
		- init
			- 게임 시작 및 종료 기능 
	Vaildation		
		- exption
			- 입력 데이터 유효성 검사 기능
				- 3자리 수인가?
				- 숫자인가?

				-check
					- 각 자리 수가 모두 다른가?
	
Model
	DataOfGame		
		- setCom
			- 세자리의 난수 모델에 저장 기능
		- setUser
			- 사용자 입력값 모델에 저장 기능 
		- getCom
			- 저장된 난수 호출 기능
		- getUser
			- 저장된 입력값 호출 기능
					
View
	InputView		
		- InputMsg
			- 사용자 입력 안내문 출력 기능
		- branchMsg
			- 분기에 대한 사용자 입력 안내문 출력 기능
	OutputView		
		- StartMsg
			- 게임 시작 안내문 출력 기능
		- resultMsg
			- 스트라이크와 볼 개수에 따른 안내문 출력 기능
		- endMsg
			- 정답인 경우 스트라이크 개수와 게임 종료 안내문 출력 기능
