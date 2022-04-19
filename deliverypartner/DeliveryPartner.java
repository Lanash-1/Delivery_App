package deliverypartner;

public class DeliveryPartner {
	private String partnerName;
	private String partnerMobileNumber;
	private String partnerVehicleNumber;
	private String partnerId;
	private int partnerEarnings = 0;
	
	public String getPartnerName() {
		return partnerName;
	}
	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}
	public String getPartnerMobileNumber() {
		return partnerMobileNumber;
	}
	public void setPartnerMobileNumber(String partnerMobileNumber) {
		this.partnerMobileNumber = partnerMobileNumber;
	}
	public String getPartnerVehicleNumber() {
		return partnerVehicleNumber;
	}
	public void setPartnerVehicleNumber(String partnerVehicleNumber) {
		this.partnerVehicleNumber = partnerVehicleNumber;
	}
	public String getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}
	public int getPartnerEarnings() {
		return partnerEarnings;
	}
	public void setPartnerEarnings(int partnerEarnings) {
		this.partnerEarnings = partnerEarnings;
	}
}
