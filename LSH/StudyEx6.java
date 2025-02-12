package java09;

public class InherStudy {
	public static void main(String[] args) {		
		// Car 클래스를 상속 받은 Truck, Bus, Bike 클래스를 구현한다. 
		Truck truck = new Truck( "포터", "경유", 1 );
		System.out.println( "차종 : " + truck.getName() );
		System.out.println( "연료 : " + truck.getFuel() );
		System.out.println( "적재 : " + truck.getCarry() + "ton" );
		
		Bus bus = new Bus( "현대", "가스", 407 );
		System.out.println( "차종 : " + bus.getName() );
		System.out.println( "연료 : " + bus.getFuel() );
		System.out.println( "노선 : " + bus.getNumber() );
		
		Bike bike = new Bike( "대림", "경유" );
		System.out.println( "차종 : " + bike.getName() );
		System.out.println( "연료 : " + bike.getFuel() );
	}
}
