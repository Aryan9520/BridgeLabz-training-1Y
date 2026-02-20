public class OTPGenerator {

    public static int generateOTP() {
        return (int)(Math.random() * 900000) + 100000; // 6-digit OTP (100000–999999)
    }

    public static boolean areOTPsUnique(int[] otps) {
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] otpArray = new int[10];

        for (int i = 0; i < otpArray.length; i++) {
            otpArray[i] = generateOTP();
        }

        System.out.println("Generated OTPs:");
        for (int i = 0; i < otpArray.length; i++) {
            System.out.println("OTP " + (i + 1) + ": " + otpArray[i]);
        }

        boolean unique = areOTPsUnique(otpArray);

        if (unique) {
            System.out.println("\nAll 10 OTPs are unique.");
        } else {
            System.out.println("\nOTPs are not unique (duplicates found).");
        }
    }
}
