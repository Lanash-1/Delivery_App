package validation;

public class Validation {	

	public boolean validate(String partnerName, String partnerId, String partnerMobileNumber, String vehicleNumber) {
		if(partnerName.length() > 4 && partnerId.length() > 4 && partnerMobileNumber.length() == 10 && vehicleNumber.length() > 6) {
			return true;
		}
		System.out.println("Enter details properly");
		return false;
	}
	
	public boolean validate(String emailId) {
		if(emailId.endsWith("@gmail.com") && emailId.length() > 10) {
			return true;
		}
		System.out.println("Enter valid email id");
		return false;
	}
	
	public boolean validate(int generated, int entered) {
		if(generated == entered) {
			System.out.println("Verified");
			return true;
		}
		System.out.println("Entered otp is not matching. Try again");
		return false;
	}
	
	public boolean validate(String password, String rePassword) {
		if(password.length() < 4){
			System.out.println("Password is too short. Try again");
			return false;
		}
		if(password.equals(rePassword)) {
			System.out.println("Password Matching. Continue signup.");
			return true;
		}
		System.out.println("Password not matching. Try again");
		return false;
	}
	
	public boolean validate(String name, String mobileNumber, String location) {
		if(location.length() < 1 || mobileNumber.length()!=10 || name.length() < 1) {
			System.out.println("Enter details properly");
			return false;
		}
		return true;
	}
}