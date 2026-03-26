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

		managedMembers.add(member);
		updateGradeByMemberCount();

		System.out.println(member.getName() + " 회원이 담당 회원으로 추가되었습니다.");
		System.out.println("현재 담당 회원 수: " + managedMembers.size());
		System.out.println("현재 트레이너 등급: " + grade);
	}

	// 담당 회원 수에 따라 트레이너 등급을 변경하는 기능
	private void updateGradeByMemberCount() {
		int count = managedMembers.size();

		if (count >= 10) {
			grade = TrainerGrade.MASTER;
		} else if (count >= 7) {
			grade = TrainerGrade.SENIOR;
		} else if (count >= 4) {
			grade = TrainerGrade.JUNIOR;
		} else {
			grade = TrainerGrade.INTERN;
		}
	}

	// 오늘 출석한 담당 회원을 출력하는 기능
	public void printAttendance() {
		System.out.println("=== 출석한 담당 회원 목록 ===");

		boolean found = false;

		for (Member member : managedMembers) {
			if (member.isAttendedToday()) {
				System.out.println(member.getName());
				found = true;
			}
		}

		if (!found) {
			System.out.println("오늘 출석한 담당 회원이 없습니다.");
		}
	}

	// 트레이너의 전체 정보를 출력하는 기능
	@Override
	public void printInfo() {
		System.out.println("===" + getName() + "트레이너 정보" + "===");
		System.out.println("이름: " + getName());
		System.out.println("전화번호: " + getPhoneNumber());
		System.out.println("나이: " + getAge());
		System.out.println("키: " + getHeight());
		System.out.println("몸무게: " + getWeight());
		System.out.println("등급: " + grade);
		System.out.println("담당 회원 수: " + managedMembers.size());
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