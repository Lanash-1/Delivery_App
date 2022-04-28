package validation;

public final class ValidationUtility {
	public static boolean emailVerification(String email) {
		if(email.endsWith("@gmail.com") && email.length() > 10) {
			return true;
		}
		System.out.println("Email ID should end with @gmail.com");
		return false;
	}
	
	public static boolean otpVerification(int generatedOtp, int enteredOtp) {
		if(generatedOtp == enteredOtp) {
			System.out.println("Verified");
			return true;
		}
		System.out.println("Entered otp is not matching. Try again");
		return false;
	}
	
	public static boolean passwordVerification(String password, String rePassword) {
		if(password.length() < 4){
			System.out.println("Password too short. Should atleast 4 characters");
			return false;
		}
		if(password.equals(rePassword)) {
			System.out.println("Password Matching. Continue signup.");
			return true;
		}
		System.out.println("Password not matching. Try again");
		return false;
	}
	
	public static boolean customerVerification(String name, String mobileNumber, String location) {
		if(location.length() < 1 || mobileNumber.length()!=10 || name.length() < 1) {
			System.out.println("Enter details properly");
			return false;
		}
		return true;
	}
	
	public static boolean restaurantVerification(String restaurantName, String mobileNumber, String location) {
		if(location.length() < 1 || mobileNumber.length()!=10 || restaurantName.length() < 1) {
			System.out.println("Enter details properly");
			return false;
		}
		return true;
	}
	
	public static boolean deliveryPartnerVerification(String partnerName, String partnerId, String partnerMobileNumber, String vehicleNumber) {
		if(partnerName.length() > 4 && partnerId.length() > 3 && partnerMobileNumber.length() == 10 && vehicleNumber.length() > 6) {
			return true;
		}
		System.out.println("Enter details properly");
		return false;
	}
}
