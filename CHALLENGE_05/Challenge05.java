package CHALLENGE_05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Challenge05 {
    public static void main(String[] args) {
        final String FILE_DIR = "CHALLENGE_05/database_attacked.txt";

        System.out.println(invalidUsersString(FILE_DIR));
    }

    public static String invalidUsersString(String FILE_DIR) {
        StringBuilder secret = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_DIR))) {
            String data;
            while ((data = reader.readLine()) != null) {
                if (!data.trim().isEmpty() && !isValidUser(data)) {
                    char firstChar = data.split(",")[1].charAt(0);
                    if (Character.isLetterOrDigit(firstChar)) {
                        secret.append(firstChar);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return secret.toString();
    }

    public static boolean isValidUser(String userData) {
        String[] fields = userData.split(",");
        String id = fields[0].trim();
        String userName = fields[1].trim();
        String mail = fields[2].trim();
        String age = (fields.length > 3 && fields[3].equals("")) ? fields[3] . trim():"";
        String location = (fields.length > 4 && fields[4].equals("")) ? fields[4].trim() : "";
        if (id.equals("") || userName.equals("") || mail.equals(""))
            return false;

        return isValidEntry(id, userName, mail, age, location);
    }

    public static boolean isValidEntry(String id, String name, String mail, String age, String location) {
        String idPattern = "^[a-zA-Z0-9]*$";
        String usernamePattern = "^[a-zA-Z0-9]*$";
        String emailPattern = "^" + "(" + name + "|" + name.toLowerCase() + ")" + "@[a-zA-Z]+\\.com$";
        return id.matches(idPattern) && name.matches(usernamePattern) && mail.matches(emailPattern)
                && (age.isEmpty() || isNumeric(age)) && (location.isEmpty() || isAlphabetic(location));
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isAlphabetic(String str) {
        return str.matches("^[a-zA-Z]*$");
    }

}