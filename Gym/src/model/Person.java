package model;

public abstract class Person {

	private String name;
	private String phoneNumber;
	private int age;
	private double height;
	private double weight;

		public Person(String name, String phoneNumber, int age, double height, double weight) {
			this.name = name;
			this.phoneNumber = phoneNumber;
			this.age = age;
			this.height = height;
			this.weight = weight;
		}

		public abstract void printInfo();
		
		public double getBMI(double height, double weight) {
			double h=height/100; //cm를 m로 변경
			return weight/(h*h);
		}
		
		public void getBMICategory() {
			double bmi=getBMI(height, weight);
			String category="";
			String dietPlan="";
			
			if(bmi<18.5) {
				 category = "저체중";
				 dietPlan = "고칼로리 + 단백질 식단";
			}else if(bmi<22.9) {
				 category = "정상";
				 dietPlan = "균형 잡힌 식단 유지 식단";
			}else if(bmi<24.9) {
				 category = "과체중";
				 dietPlan = "저칼로리 + 고단백 식단";
			}else if(bmi > 25.0){
				 category = "비만";
				 dietPlan = "저탄고지 + 유산소 병행 식단";
			}
			
			System.out.println("BMI지수: " + bmi);
			System.out.println("결과: " + category);
			System.out.println("추천 식단: " + dietPlan);
		}
		

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public double getHeight() {
			return height;
		}

		public void setHeight(double height) {
			this.height = height;
		}

		public double getWeight() {
			return weight;
		}

		public void setWeight(double weight) {
			this.weight = weight;
		}
		
		
		
		
		
		
		
}
