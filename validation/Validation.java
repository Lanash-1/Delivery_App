package validation;

public class Validation {	
	public boolean validate(String username, String password, String address, String mobileNumber) {
		if(username.length() > 4 && password.length() > 4 && address.length() > 0 && mobileNumber.length() == 10) {
			return true;
		}
		System.out.println("Enter details properly");
		return false;
	}
	
	public boolean validate(String partnerName, String partnerPassword, String partnerId, String partnerMobileNumber, String vehicleNumber) {
		if(partnerName.length() > 4 && partnerPassword.length() > 4 && partnerId.length() > 4 && partnerMobileNumber.length() == 10 && vehicleNumber.length() > 6) {
			return true;
		}
		System.out.println("Enter details properly");
		return false;
	}
}