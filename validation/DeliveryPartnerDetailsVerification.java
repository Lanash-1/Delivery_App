package validation;

public interface DeliveryPartnerDetailsVerification {
	boolean validate(String partnerName, String partnerId, String partnerMobileNumber, String vehicleNumber);
}
