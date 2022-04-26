package validation;

public interface EmailAndPasswordVerification {
	boolean validate(String email);
    boolean validate(int generatedOtp, int enteredOtp);
    boolean validate(String password, String rePassword);
}
