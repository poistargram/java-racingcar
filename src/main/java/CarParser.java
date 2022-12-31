import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarParser {

	public List<Car> parse(String input){
		return Arrays.stream(input.split(",")).map(car -> new Car(car, 0)).collect(Collectors.toList());
	}

}
