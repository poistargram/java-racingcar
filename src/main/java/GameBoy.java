import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GameBoy {

	public static void main(String[] args) {
		GameBoy.init().play();
	}

	public final static int PIVOT_NUMBER = 4;
	public final static int BOUND_NUMBER = 10;

	private List<Car> cars = new ArrayList<>();
	private int playCount;

	private GameBoy() {}

	public static GameBoy init() {
		GameBoy gameBoy = new GameBoy();
		Scanner scan = new Scanner(System.in);
		initCars(gameBoy, scan);
		initPlayCount(gameBoy, scan);
		return gameBoy;
	}

	private static void initPlayCount(GameBoy gameBoy, Scanner scan) {
		gameBoy.playCount = Integer.parseInt(scan.nextLine());
	}

	public static void initCars(GameBoy gameBoy, Scanner scan) {
		Printer.initInfo();
		String carLine = scan.nextLine();
		String[] carNames = carLine.split(",");

		gameBoy.cars = Arrays.stream(carNames).map(name -> new Car(name, 0)).collect(Collectors.toList());
	}

	public static int getRandomNumberLessThanInput() {
		return ((int) (Math.random() * 10000)) % BOUND_NUMBER;
	}

	public void play() {
		Printer.playInfo();
		for (int i = 0; i < playCount; i++) {
			playCars();
			Printer.printCars(cars);
		}

		Printer.printResult(getWinners());
	}

	private void playCars() {
		cars.forEach(this::playCar);
	}

	private void playCar(Car car){
		int randomNumber = getRandomNumberLessThanInput();
		if(randomNumber >= PIVOT_NUMBER){
			car.go();
		}
	}

	private List<Car> getWinners() {
		int max = cars.stream().mapToInt(Car::getState).max().getAsInt();

		return cars.stream().filter(car -> car.getState() == max).map(car -> new Car(car.getName(), car.getState())).collect(Collectors.toList());
	}

}
