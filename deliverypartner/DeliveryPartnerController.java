package deliverypartner;

public class DeliveryPartnerController {
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
	
	public void updateView(){				
		view.printDeliveryPartnerDetails(model.getPartnerName(), model.getPartnerMobileNumber(), model.getPartnerVehicleNumber(),model.getPartnerId(), model.getPartnerEarnings(), model.getPartnerEmail());
	}
}