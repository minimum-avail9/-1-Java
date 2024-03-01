public class PasswordValidator {
    private static final String specialSymbols = ",.;:+-*/'\"&<>$€£¥=№";

    public static boolean validatePassword(String passwordToValidate) {
        if (passwordToValidate.length() < 8) {
            return false;
        }
        int[] data = new int[]{0, 0, 0, 0};
        for (int i = 0; i < passwordToValidate.length(); i++) { // ch = @ char
            ch = passwordToValidate.charAt(i);
            if (Character.isUpperCase(ch)) data[0]++;
            if (Character.isLowerCase(ch)) data[1]++;
            if (Character.isDigit(ch)) data[2]++;
            if (specialSymbols.contains(ch + "")) data[3]++;
        }
        for (int info : data) {
            if (info < 1) return false;
        }
        return true;
    }
}