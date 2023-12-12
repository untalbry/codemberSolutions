package CHALLENGE_04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.management.RuntimeErrorException;

public class Challenge04 {
    public static void main(String[] args) {
        final String FILE_DIR = "CHALLENGE_04/files_quarantine.txt";
        try {
            System.out.println(getRealFile(FILE_DIR, 33));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getRealFile(String FILE_DIR, int positionFile) throws IOException, RuntimeErrorException {
        List<String> lines = Files.readAllLines(Paths.get(FILE_DIR));
        int validFileCount = 1;
        for (String fileKey : lines) {
            String[] fileKeySplit = fileKey.split("-");
            System.out.print(validFileCount + ":");
            String validKey = checkSum(fileKeySplit[0]);

            if (fileKeySplit[1].equals(validKey)) {
                if (validFileCount == positionFile) {
                    return validKey;
                }
                validFileCount++;
            }
        }
        throw new RuntimeException("No se encontró el archivo real numero :" + positionFile);
    }

    public static String checkSum(String nameFile) {
        StringBuilder key = new StringBuilder();
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : nameFile.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        for (char c : nameFile.toCharArray()) {
            if (charCount.get(c) == 1) {
                key.append(c);
            }
        }
        System.out.println(nameFile + "-" + key.toString());
        return key.toString();
    }
}
