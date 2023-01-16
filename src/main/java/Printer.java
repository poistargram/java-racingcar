import java.util.Collection;
import java.util.List;

public class Printer {


	public static void initInfo(){
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
	}

	public static void playInfo(){
		System.out.println("실행 결과");
	}

	public static void printCars(Collection<Car> cars){
		cars.forEach(Printer::printCar);
		System.out.println();
	}

	public static void printResult(List<Car> cars){
		System.out.println(getCarString(cars)+"가 최종 우승했습니다.");
	}

	private static void printCar(Car car){
		if(car.getState() == 0){
			System.out.println(car.getName()+" : ");
			return;
		}
		System.out.println(car.getName()+" : "+"-".repeat(car.getState()));
	}

	private static String getCarString(List<Car> cars){
		String result = "";
		for(int i = 0; i < cars.size(); i++){
			Car car = cars.get(i);
			result += car.getName();
			result += getMiddle(cars.size(), i);
		}

		return result;
	}

	private static String getMiddle(int size, int cur){
		if(size != cur+1){
			return ", ";
		}
		return "";
	}

}
