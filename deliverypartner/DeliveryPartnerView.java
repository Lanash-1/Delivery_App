package deliverypartner;

public class DeliveryPartnerView {
	public void printDeliveryPartnerDetails(String partnerName, String partnerMobileNumber, String partnerVehicleNumber, String partnerId, int partnerEarnings, String partnerEmail) {
		System.out.println("Partner ID: "+ partnerId);
		System.out.println("Name: " + partnerName);
		System.out.println("Email ID: " + partnerEmail);
		System.out.println("Mobile number: " + partnerMobileNumber);
		System.out.println("Vehicle No: " + partnerVehicleNumber);
		System.out.println("Partner Earnings: " + partnerEarnings);
	}
}
