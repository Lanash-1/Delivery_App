package validation;
import java.util.Random; 

public class GenerateOtp {
	public static int generateOtp() {
		Random random = new Random();
		return random.nextInt(1000,10000);
	}
}
