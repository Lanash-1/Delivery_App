package deliverypartner;


import validation.DeliveryPartnerDetailsVerification;
import validation.EmailAndPasswordVerification;
import validation.GenerateOtp;

public class DeliveryPartnerController extends GenerateOtp implements EmailAndPasswordVerification, DeliveryPartnerDetailsVerification {
	private DeliveryPartner model;  
	private DeliveryPartnerView view;  
	 
	public DeliveryPartnerController(DeliveryPartner model, DeliveryPartnerView view) {
		this.model = model;
		this.view = view;
	}
	
	public String getPartnerName() {
		return model.getPartnerName();
	}
	public void setPartnerName(String partnerName) {
		model.setPartnerName(partnerName);
	}
	public String getPartnerMobileNumber() {
		return model.getPartnerMobileNumber();
	}
	public void setPartnerMobileNumber(String partnerMobileNumber) {
		model.setPartnerMobileNumber(partnerMobileNumber);
	}
	public String getPartnerVehicleNumber() {
		return model.getPartnerVehicleNumber();
	}
	public void setPartnerVehicleNumber(String partnerVehicleNumber) {
		model.setPartnerVehicleNumber(partnerVehicleNumber);
	}
	public String getPartnerId() {
		return model.getPartnerId();
	}
	public void setPartnerId(String partnerId) {
		model.setPartnerId(partnerId);
	}
	public int getPartnerEarnings() {
		return model.getPartnerEarnings();
	}
	public void setPartnerEarnings(int partnerEarnings) {
		model.setPartnerEarnings(partnerEarnings);
	}
	
	public String getPartnerPassword() {
		return model.getPartnerPassword();
	}
	public void setPartnerPassword(String partnerPassword) {
		model.setPartnerPassword(partnerPassword);
	}
	public String getPartnerEmail() {
		return model.getPartnerEmail();
	}
	public void setPartnerEmail(String partnerEmail) {
		model.setPartnerEmail(partnerEmail);
	}
	public boolean validate(String email) {
		if(email.endsWith("@gmail.com") && email.length() > 10) {
			return true;
		}
		System.out.println("Enter valid email id");
		return false;
	}

	public boolean validate(int generatedOtp, int enteredOtp) {
		if(generatedOtp == enteredOtp) {
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
	
	public boolean validate(String partnerName, String partnerId, String partnerMobileNumber, String vehicleNumber) {
		if(partnerName.length() > 4 && partnerId.length() > 4 && partnerMobileNumber.length() == 10 && vehicleNumber.length() > 6) {
			return true;
		}
		System.out.println("Enter details properly");
		return false;
	}
	
	
	public void updateView(){				
		try {
			view.printDeliveryPartnerDetails(model.getPartnerName(), model.getPartnerMobileNumber(), model.getPartnerVehicleNumber(),model.getPartnerId(), model.getPartnerEarnings(), model.getPartnerEmail());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}