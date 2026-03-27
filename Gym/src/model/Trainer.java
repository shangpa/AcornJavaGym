package model;

import java.util.ArrayList;

import interfaces.DietManageable;
import interfaces.Registerable;

public class Trainer extends Person implements Registerable, DietManageable {

	private TrainerGrade grade;
	private ArrayList<Member> managedMembers;

	// 트레이너 객체 생성 및 기본값 초기화
	public Trainer(String name, String phoneNumber, int age, double height, double weight) {
		super(name, phoneNumber, age, height, weight);
		this.grade = TrainerGrade.INTERN;
		this.managedMembers = new ArrayList<>();
	}

	// 트레이너 등록 기능
	@Override
	public void register() {
		System.out.println(getName() + " 트레이너 등록 완료");
		System.out.println("등급: " + grade);
	}

	// 회원 BMI에 따라 식단을 관리해주는 기능
	@Override
	public void manageDiet(Member member) {
		double bmi = member.getBMI(member.getHeight(), member.getWeight());

		System.out.println("회원 이름: " + member.getName());
		System.out.println("BMI: " + bmi);

		if (bmi < 18.5) {
			System.out.println("저체중 → 고칼로리 및 단백질 식단 추천");
		} else if (bmi < 23.0) {
			System.out.println("정상 → 균형 잡힌 유지 식단 추천");
		} else if (bmi < 25.0) {
			System.out.println("과체중 → 저칼로리 및 고단백 식단 추천");
		} else {
			System.out.println("비만 → 저탄고지 및 유산소 병행 식단 추천");
		}
	}

	// 담당 회원을 추가하고 등급을 재조정하는 기능
	public void addManagedMember(Member member) {
		if (member == null) {
			System.out.println("회원이 존재하지 않습니다.");
			return;
		}
		
		//담당 회
		if (managedMembers.contains(member)) { //담당회원들 들어있는 리스트안에 member가 있으면 true 아니면 false 출력 코드
		    System.out.println(member.getName() + " 회원은 이미 담당 회원입니다.");
		    return;
		}

		managedMembers.add(member);
		updateGradeByMemberCount();

		System.out.println(member.getName() + " 회원이 담당 회원으로 추가되었습니다.");
		System.out.println("현재 담당 회원 수: " + managedMembers.size());
		System.out.println("현재 트레이너 등급: " + grade);
		System.out.println("등록된 담당 회원 목록:");

	    for (int i = 0; i < managedMembers.size(); i++) {
	        System.out.println((i + 1) + ". " + managedMembers.get(i).getName());
	    }
	}
	
	public void printManagedMembers() {
	    System.out.println("=== 담당 회원 목록 ===");
	    if (managedMembers.isEmpty()) {
	        System.out.println("담당 회원이 없습니다.");
	        return;
	    }
	    for (int i = 0; i < managedMembers.size(); i++) {
	        System.out.println((i + 1) + ". " + managedMembers.get(i).getName());
	    }
	}
	
	//회원 BMI 계산해서 해당 운동 추천 해주기 
	public void recommendWorkout(Member member) {
	    double bmi = member.getBMI(member.getHeight(), member.getWeight());

	    System.out.println("회원 이름: " + member.getName());
	    System.out.println("BMI: " + bmi);

	    if (bmi < 18.5) {
	        System.out.println("추천 운동: 가벼운 유산소 + 근력운동 위주");
	    } else if (bmi < 23.0) {
	        System.out.println("추천 운동: 유산소 + 근력운동 균형 루틴");
	    } else if (bmi < 25.0) {
	        System.out.println("추천 운동: 중강도 유산소 + 하체/코어 운동");
	    } else {
	        System.out.println("추천 운동: 유산소 중심 + 전신 순환운동");
	    }
	}

	// 담당 회원 수에 따라 트레이너 등급을 변경하는 기능
	private void updateGradeByMemberCount() {
		int count = managedMembers.size(); // managedMembers를 count를 저장

		if (count >= 10) {
			grade = TrainerGrade.MASTER; //트레이너가 회원이 10명이 넘으면 MASTER로 grade로 저장
		} else if (count >= 7) {
			grade = TrainerGrade.SENIOR; //트레이너가 회원이 7~9명이 넘으면 SENIOR로 grade로 저장
		} else if (count >= 4) {
			grade = TrainerGrade.JUNIOR; //트레이너가 회원이 4~6명이 넘으면 JUNIOR로 grade로 저장
		} else {
			grade = TrainerGrade.INTERN; //트레이너가 0~3까지 등록이 되어있으면 grade로 저장
		}
	}

	// 오늘 출석한 담당 회원을 출력하는 기능
	public void printAttendance() {
		System.out.println("=== 출석한 담당 회원 목록 ===");

		boolean found = false; //해당 트레이너에 회원이 출석이 되어있는지 boolean으로 false로 기본으로  설정

		for (Member member : managedMembers) {
			if (member.isAttendedToday()) {
				System.out.println(member.getName());
				found = true;
			}
		} //여기서 출석이 되어있으면 해당 이름출력하기 

		if (!found) {
			System.out.println("오늘 출석한 담당 회원이 없습니다.");
		}
	}

	// 트레이너의 전체 정보를 출력하는 기능
	@Override
	public void printInfo() {
		System.out.println("===" + getName() + "트레이너 정보" + "==="); //해당 트레이너 이름 getName으로 저장
		System.out.println("이름: " + getName()); //해당 트레이너 정보를 getName 출력
		System.out.println("전화번호: " + getPhoneNumber()); // 해당 트레이너 정보를 전화번호를 저장한거를 불러옴
		System.out.println("나이: " + getAge()); //해당 트레이너 나이 가져옴 getAge로
		System.out.println("키: " + getHeight()); //해당 트레이너 getHieght로 해당 트레이너 키 가져옴
		System.out.println("몸무게: " + getWeight()); // 해당 트레이너 몸무게 가져옴
		System.out.println("등급: " + grade); //해당 트레이너 grade로 인원수의 맞쳐 updateGradeByMemberCount 여기서 결과를 내서 등급을 보여줌 
		System.out.println("담당 회원 수: " + managedMembers.size()); //등록한 회원을 회원 수를 보여줌
	}

	// 현재 트레이너 등급 반환 기능
	public TrainerGrade getGrade() {
		return grade;
	}

	// 담당 회원 목록 반환 기능
	public ArrayList<Member> getManagedMembers() {
		return managedMembers;
	}
}