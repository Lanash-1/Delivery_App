package validation;
import java.util.Random; 

public class GenerateOtp {
	public int generateOtp() {
		Random random = new Random();
		return random.nextInt(1000,10000);
		
	}
}
