package deliverypartner;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class DeliveryPartnerView {
	public void printDeliveryPartnerDetails(String partnerName, String partnerMobileNumber, String partnerVehicleNumber, String partnerId, int partnerEarnings, String partnerEmail) throws Exception {
//		System.out.println("Partner ID: "+ partnerId);
//		System.out.println("Name: " + partnerName);
//		System.out.println("Email ID: " + partnerEmail);
//		System.out.println("Mobile number: " + partnerMobileNumber);
//		System.out.println("Vehicle No: " + partnerVehicleNumber);
//		System.out.println("Partner Earnings: " + partnerEarnings);
		File file = new File("deliveryPartnerProfile.txt");
		
		if(!file.createNewFile()) {	
			file.delete();
			file.createNewFile();
		}
		FileWriter writer = new FileWriter(file);
		writer.write("Partner ID: " + partnerId + "\nName: " + partnerName);
		writer.write("\nEmail ID: " + partnerEmail);
		writer.write("\nMobile number: " + partnerMobileNumber);
		writer.write("\nVehicle No: " + partnerVehicleNumber);
		writer.write("\nPartner Earnings: " + partnerEarnings);
		writer.close();
		
		Scanner sc = new Scanner(file);
		while(sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		}
	}
}
