import java.util.Random;

public class Car {

	private String name;
	private int state;

	public Car(String name, int state) {
		this.name = name;
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public int getState() {
		return state;
	}

	public void attempt(int number){
		if(number > 4){
			this.state++;
		}
	}
}
