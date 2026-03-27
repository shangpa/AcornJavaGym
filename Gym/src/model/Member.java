package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import interfaces.FitnessEquipmentGuide;
import interfaces.Payable;
import interfaces.Registerable;

public class Member extends Person implements Registerable, Payable, FitnessEquipmentGuide {
	private LocalDate registrationDate;						//등록일
	private LocalDate expirationDate;						//만료일
	private LocalDate expirationDate_after_extension;		//연장 후 만료일
	private boolean attendedToday;							//오늘 출석 여부
	private MembershipType membership;						//선택한 회원권
	
	//날짜 출력 형태
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
	
	public Member(String name, String phoneNumber, int age, double height, double weight) {
		super(name, phoneNumber, age, height, weight);
		
	}
	
	@Override
	public void explainEquipment(String bodyPart) {
		int upperNum;		//상체 리스트 번호 입력받는 변수
		int lowerNum;		//하체 리스트 번호 입력받는 변수
		int cardioNum;	   //유산소 리스트 번호 입력받는 변수
	
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			switch(bodyPart) {
				case "상체":
					System.out.println("┌──────────────────────────────────────────┐");
					System.out.println("│          [ 상체 운동 부위 선택 ]         	   │");
					System.out.println("├──────────────────────────────────────────┤");
					System.out.println("│  1) 가슴    2) 등    3) 어깨    4) 팔    	   │");
					System.out.println("│  5) 뒤로가기		    	   	   │");
					System.out.println("└──────────────────────────────────────────┘");
					System.out.print("▶ 선택: ");
					
					upperNum = sc.nextInt();
					
					// %-15s  =>  왼쪽 정렬로 15칸 확보
					
					switch(upperNum) {
						
						case 1:
							
							
							System.out.println("┌───────────────────────────────────────────────────────────────────────────────────────────────┐");
							System.out.println("│          	        		[ 추천 가슴 운동 ]         	   		                │");
							System.out.println("├───────────────────────────────────────────────────────────────────────────────────────────────┤");
							System.out.println("│  1) 벤치프레스      	   								        │");
							System.out.println("│    => 바벨을 가슴 중앙 위치로 내렸다가 수직으로 밀어 올리며 가슴 근육을 수축합니다.			        │");
							System.out.println("├───────────────────────────────────────────────────────────────────────────────────────────────┤");
							System.out.println("│  2) 펙덱플라이											│");
							System.out.println("│    => 양팔을 큰 나무를 안듯이 둥글게 모아 가슴 안쪽 근육을 쥐어짜 줍니다.					│");
							System.out.println("├───────────────────────────────────────────────────────────────────────────────────────────────┤");
							System.out.println("│  3) 인클라인 벤치프레스 										│");
							System.out.println("│    => 벤치 각도를 30도 정도로 세팅한 후 쇄골 아래쪽(윗가슴)을 타겟으로 바벨을 밀어 올립니다. 			│");
							System.out.println("└───────────────────────────────────────────────────────────────────────────────────────────────┘");
							System.out.println();
							break;
							
						case 2:
							System.out.println("┌───────────────────────────────────────────────────────────────────────────────────────────────┐");
							System.out.println("│          	        		[ 추천 등 운동 ]         	   		                │");
							System.out.println("├───────────────────────────────────────────────────────────────────────────────────────────────┤");
							System.out.println("│  1) 랫풀다운      	   								        │");
							System.out.println("│    => 어깨를 내린 상태에서 바를 쇄골 쪽으로 당겨 광배근(옆구리 쪽 등 근육)을 수축합니다.			        │");
							System.out.println("├───────────────────────────────────────────────────────────────────────────────────────────────┤");
							System.out.println("│  2) 시티드로우											│");
							System.out.println("│    => 양팔을 큰 나무를 안듯이 둥글게 모아 가슴 안쪽 근육을 쥐어짜 줍니다.					│");
							System.out.println("├───────────────────────────────────────────────────────────────────────────────────────────────┤");
							System.out.println("│  3) 바벨로우 										        │");
							System.out.println("│    => 상체를 숙인 상태에서 바벨을 하복부 쪽으로 당겨 등 전체의 두께감을 키웁니다. 			        │");
							System.out.println("└───────────────────────────────────────────────────────────────────────────────────────────────┘");
							System.out.println();
							
							break;
							
						case 3:
							System.out.println("┌───────────────────────────────────────────────────────────────────────────────────────────────┐");
							System.out.println("│          	        		[ 추천 어깨 운동 ]         	   		                │");
							System.out.println("├───────────────────────────────────────────────────────────────────────────────────────────────┤");
							System.out.println("│  1) 숄더프레스 머신      	   								        │");
							System.out.println("│    => 허리를 등받이에 붙이고 손잡이를 머리 위로 수직으로 밀어 전면삼각근을 자극합니다.			        │");
							System.out.println("├───────────────────────────────────────────────────────────────────────────────────────────────┤");
							System.out.println("│  2) 사이드 레터럴 레이즈								 		│");
							System.out.println("│    => 덤벨을 든 손을 옆으로 멀리 던지듯 어깨높이까지 들어 올려 측면삼각근을 자극합니다.			        │");
							System.out.println("├───────────────────────────────────────────────────────────────────────────────────────────────┤");
							System.out.println("│  3) 리버스 펙덱플라이 									        │");
							System.out.println("│    => 머신을 마주 보고 앉아 팔을 뒤로 넓게 벌려 어깨의 후면삼각근을 자극합니다.			                │");
							System.out.println("└───────────────────────────────────────────────────────────────────────────────────────────────┘");
							System.out.println();
							
							break;
							
						case 4:
							System.out.println("┌───────────────────────────────────────────────────────────────────────────────────────────────┐");
							System.out.println("│          	        		[ 추천 팔 운동 ]         	   		                │");
							System.out.println("├───────────────────────────────────────────────────────────────────────────────────────────────┤");
							System.out.println("│  1) 바벨컬     	   								                │");
							System.out.println("│    => 어깨가 움직이지 않게 고정하고 이두근의 힘으로 바벨을 들어 올린 후 천천히 이완시킵니다.			│");
							System.out.println("├───────────────────────────────────────────────────────────────────────────────────────────────┤");
							System.out.println("│  2) 덤벨컬								 		        │");
							System.out.println("│    => 손목을 살짝 바깥으로 돌리며 덤벨을 올려 이두근을 더 강하게 수축합니다.			                │");
							System.out.println("├───────────────────────────────────────────────────────────────────────────────────────────────┤");
							System.out.println("│  3) 라잉 트라이셉스 익스텐션 									│");
							System.out.println("│    => 누운 상태에서 팔꿈치를 고정하고 이마 쪽으로 바벨을 내렸다가 펴며 삼두근의 장두를 자극합니다.			│");
							System.out.println("├───────────────────────────────────────────────────────────────────────────────────────────────┤");
							System.out.println("│  4) 케이블 푸쉬다운							 		        │");
							System.out.println("│    => 누운 상태에서 팔꿈치를 고정하고 이마 쪽으로 바벨을 내렸다가 펴며 삼두근의 장두를 자극합니다.		        │");
							System.out.println("└───────────────────────────────────────────────────────────────────────────────────────────────┘");
							System.out.println();
							
							break;
							
						case 5:
							System.out.println("메뉴 선택으로 돌아갑니다.");
							return;
							
						default:
							System.out.println("1 ~ 5 사이의 숫자만 입력해주세요.");
							break;
							
							
						}
						break;
					
					
					
				case "하체":
					
					System.out.println("┌──────────────────────────────────────────┐");
					System.out.println("│          [ 하체 운동 부위 선택 ]         	   │");
					System.out.println("├──────────────────────────────────────────┤");
					System.out.println("│  1) 대퇴사두 (다리 전면)                 	   │");
					System.out.println("│  2) 햄스트링 및 둔근 (다리 후면)         	   │");
					System.out.println("│  3) 돌아가기         	   		   │");
					System.out.println("└──────────────────────────────────────────┘");
					System.out.print("▶ 선택: ");
	
					lowerNum = sc.nextInt();
					switch(lowerNum) {						
						case 1:
							System.out.println("┌───────────────────────────────────────────────────────────────────────────────────────────────┐");
							System.out.println("│          	        	[ 추천 대퇴사두(다리 전면) 운동 ]         	   		        │");
							System.out.println("├───────────────────────────────────────────────────────────────────────────────────────────────┤");
							System.out.println("│  1) 레그 익스텐션      	   								        │");
							System.out.println("│    => 의자에 앉아 발목을 패드에 걸고, 무릎을 끝까지 펴며 허벅지 앞쪽 근육을 고립시켜 수축합니다.			│");
							System.out.println("├───────────────────────────────────────────────────────────────────────────────────────────────┤");
							System.out.println("│  2) 스쿼트								 		        │");
							System.out.println("│    => 바벨을 메고 의자에 앉듯 내려가며, 발바닥 전체로 지면을 강하게 밀어내며 하체 전체의 힘으로 일어납니다.          	│");
							System.out.println("├───────────────────────────────────────────────────────────────────────────────────────────────┤");
							System.out.println("│  3) 레그 프레스 									                │");
							System.out.println("│    => 발판에 발을 올리고 무릎이 가슴 쪽으로 충분히 내려오게 한 뒤, 발꿈치에 힘을 주어 밀어냅니다.		        │");
							System.out.println("└───────────────────────────────────────────────────────────────────────────────────────────────┘");
							System.out.println();
							
							break;
							
						case 2:
							System.out.println("┌───────────────────────────────────────────────────────────────────────────────────────────────┐");
							System.out.println("│          	        	[ 추천 햄스트링 및 둔근(다리 후면) 운동 ]         	   		│");
							System.out.println("├───────────────────────────────────────────────────────────────────────────────────────────────┤");
							System.out.println("│  1) 레그 컬      	   								        │");
							System.out.println("│    => 엎드리거나 앉은 상태에서 발꿈치를 엉덩이 쪽으로 당겨 허벅지 뒷근육(햄스트링)을 수축합니다.			│");
							System.out.println("├───────────────────────────────────────────────────────────────────────────────────────────────┤");
							System.out.println("│  2) 데드리프트								 		        │");
							System.out.println("│    => 등을 곧게 펴고 바벨을 몸에 밀착시킨 채, 힙을 뒤로 빼며 내려갔다가 엉덩이를 앞으로 밀어넣으며 일어납니다.      	│");
							System.out.println("├───────────────────────────────────────────────────────────────────────────────────────────────┤");
							System.out.println("│  3) 힙 쓰러스트									                │");
							System.out.println("│    => 등의 위쪽을 벤치에 기대고 골반에 무게를 올린 뒤, 발꿈치로 바닥을 밀어 엉덩이를 하늘 위로 높게 들어 올립니다.   	│");
							System.out.println("└───────────────────────────────────────────────────────────────────────────────────────────────┘");
							System.out.println();
							
							break;
							
						case 3:
							System.out.println("메뉴 선택으로 돌아갑니다.");
							return;
							
						default:
							System.out.println("1 ~ 3 사이의 숫자만 입력해주세요.");
							break;
					}
					
					break;
					
				case "유산소":
					
					System.out.println("┌──────────────────────────────────────────┐");
					System.out.println("│         [ 유산소 운동 기구 선택 ]        	   │");
					System.out.println("├──────────────────────────────────────────┤");
					System.out.println("│  1) 런닝머신    2) 사이클    3) 스텝밀   	   │");
					System.out.println("│  4) 돌아가기         	   		   │");
					System.out.println("└──────────────────────────────────────────┘");
					System.out.print("▶ 선택: ");
					
					cardioNum = sc.nextInt();
					switch(cardioNum) {
						case 1:
							System.out.println("┌───────────────────────────────────────────────────────────────────────────────────────────────┐");
							System.out.println("│          	        		[ 추천 유산소 운동 ]         	   			│");
							System.out.println("├───────────────────────────────────────────────────────────────────────────────────────────────┤");
							System.out.println("│  1) 런닝머신     	   								        │");
							System.out.println("│    => 자신의 체력에 맞춰 속도와 경사도(Incline)를 조절하며 걷거나 뛰어 심폐지구력을 강화합니다.			│");
							System.out.println("└───────────────────────────────────────────────────────────────────────────────────────────────┘");
							System.out.println();
							
							break;
							
						case 2:
							System.out.println("┌───────────────────────────────────────────────────────────────────────────────────────────────┐");
							System.out.println("│          	        		[ 추천 유산소 운동 ]         	   			│");
							System.out.println("├───────────────────────────────────────────────────────────────────────────────────────────────┤");
							System.out.println("│ 2) 사이클     	   								        	│");
							System.out.println("│    => 안장 높이를 골반에 맞춘 뒤, 발바닥 전체로 페달을 굴려 무릎 부담 없이 하체 근력을 키우고 칼로리를 소모합니다.    	│");
							System.out.println("└───────────────────────────────────────────────────────────────────────────────────────────────┘");
							System.out.println();
							
							break;
						case 3:
							System.out.println("┌───────────────────────────────────────────────────────────────────────────────────────────────┐");
							System.out.println("│          	        		[ 추천 유산소 운동 ]         	   			│");
							System.out.println("├───────────────────────────────────────────────────────────────────────────────────────────────┤");
							System.out.println("│ 3) 스텝밀	   								        	│");
							System.out.println("│    => 끊임없이 나오는 계단을 오르며 하체 근육 전체와 엉덩이(둔근)를 강하게 자극하는 고강도 유산소 운동입니다.    			│");
							System.out.println("└───────────────────────────────────────────────────────────────────────────────────────────────┘");
							System.out.println();
							
							break;
							
						case 4:
							System.out.println("메뉴 선택으로 돌아갑니다.");
							return;
							
						default:
							System.out.println("1 ~ 4 사이의 숫자만 입력해주세요.");
							break;
							
					}
					break;
				default:
					System.out.println("잘못된 입력입니다.");
					break;
			}
		}
		
	}
	
	@Override
	public void pay(int months) {	//회원권 결제
		
		LocalDate today = LocalDate.now();
		
		int selectedMonth = months;
		int price = membership.getPrice();
		
		//첫 결제이거나 남은 기간이 없는 경우
		if(this.expirationDate == null || this.expirationDate.isBefore(today)) {		
				System.out.println(selectedMonth + "개월 회원권을 선택하셨습니다!");
				System.out.println(price + "원 결제 완료되었습니다!");
				this.expirationDate = registrationDate.plusMonths(selectedMonth);
				System.out.println("회원님의 만료일은 " + expirationDate.format(formatter) + "입니다.");
			
		}else {
			
			if(selectedMonth != 1 && selectedMonth != 3 && selectedMonth != 6 && selectedMonth != 12) {
				System.out.println("1, 3, 6, 12개월 중 하나를 선택해주세요.");
				return;
			}
			else {
				this.expirationDate_after_extension = this.expirationDate.plusMonths(selectedMonth);
				
				System.out.println("\n기존 만료일인 " + expirationDate.format(formatter) + "에서 " + selectedMonth + "개월 추가 결제하여");
				System.out.println("만료일이 " + expirationDate_after_extension.format(formatter) + "로 변경되었습니다.");
				
				//기존 만료일을 연장된 만료일로 변경하여 저장
				this.expirationDate = this.expirationDate_after_extension;
			}
		}
		
	}
	
	
	
	@Override
	public void register() {	//회원권 등록날짜를 당일로 저장
		this.registrationDate = LocalDate.now();
	}
	
	//출석확인
	public void checkIn() {
		if(attendedToday == false) {
			attendedToday = true;
			System.out.println("출석이 완료되었습니다!");
		}else {
			System.out.println("이미 출석하셨습니다.");
		}
	}
	
	public void printInfo() {}
	
	public void setMembership(MembershipType membership) {
		this.membership = membership;
	}

	public MembershipType getMembership() {
		return this.membership;
	}

	public LocalDate getExpirationDate() {
		return this.expirationDate;
	}
	
	public boolean isAttendedToday() {
		return this.attendedToday;
	}
}
