import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	private final CarParser carParser;

	public Main(CarParser carParser) {
		this.carParser = carParser;
	}

	public void run(String input, int attemptCount) {
		List<Car> cars = inputCar(input);
	}

	private List<Car> inputCar(String input) {
		return Arrays.stream(input.split(",")).map(car -> new Car(car, 0)).collect(Collectors.toList());
	}

}
