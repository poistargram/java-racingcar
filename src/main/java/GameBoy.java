import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GameBoy {

	public final static int pivotNumber = 4;

	private List<Car> cars = new ArrayList<>();
	private int playCount;


	private GameBoy(){}

	public static GameBoy init(){
		GameBoy gameBoy = new GameBoy();
		Scanner scan = new Scanner(System.in);
		initCars(gameBoy, scan);
		initPlayCount(gameBoy, scan);
		return gameBoy;
	}

	private static void initPlayCount(GameBoy gameBoy, Scanner scan) {
		gameBoy.playCount = Integer.parseInt(scan.nextLine());
	}

	public static void initCars(GameBoy gameBoy, Scanner scan){
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		String carLine = scan.nextLine();
		String[] carNames = carLine.split(",");

		gameBoy.cars = Arrays.stream(carNames).map(name -> new Car(name, 0)).collect(Collectors.toList());
	}

	public static int getRandomNumberLessThanInput(){
		return ((int) (Math.random() * 10000)) % pivotNumber;
	}


}
