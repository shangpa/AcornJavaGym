package model;

public class MembershipType{
	
	public static final MembershipType ONE_MONTH = new MembershipType(1, 100000);
	public static final MembershipType THREE_MONTH = new MembershipType(3, 270000);
	public static final MembershipType SIX_MONTH = new MembershipType(6, 500000);
	public static final MembershipType TWELVE_MONTHS = new MembershipType(12, 900000);

	
	private final int months;
	private final int price;

	public MembershipType(int months, int price) {
		super();
		this.months = months;
		this.price = price;
	}

	public int getMonths() {
		return months;
	}

	public int getPrice() {
		return price;
	}
	
	
	}

		

