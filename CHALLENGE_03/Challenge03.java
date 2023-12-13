package CHALLENGE_03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Challenge03 {
    public static void main(String[] args) {
        final String FILE_DIR = "CHALLENGE_03/encryption_policies.txt";
        try {
            System.out.println(getInvalidKey(FILE_DIR, 13));
        } catch (IOException | NotKeyNumberFoundException e) {
            e.printStackTrace();
        }

    }

    public static String getInvalidKey(String FILE_DIR, int positionKey)
            throws IOException, NotKeyNumberFoundException {
        List<String> lines = Files.readAllLines(Paths.get(FILE_DIR));
        int clavesInvalidas = 0;
        for (String line : lines) {
            String[] parts = line.split(": ");

            String[] restriction = parts[0].split(" ");
            String[] resParts = restriction[0].split("-");

            int min = Integer.parseInt(resParts[0]);
            int max = Integer.parseInt(resParts[1]);
            char target = restriction[1].charAt(0);
            int concurrence = validKey(parts[1], target);

            boolean isValid = concurrence >= min && concurrence <= max;

            if (!isValid)
                clavesInvalidas++;

            if (clavesInvalidas == positionKey)
                return parts[1];

        }
        throw new NotKeyNumberFoundException("No hay " + positionKey + " numero de claves invalidas\nSolo hay " + clavesInvalidas);

    }

    public static int validKey(String key, char target) {
        int cont = 0;
        for (char c : key.toCharArray()) {
            if (c == target)
                cont++;
        }
        return cont;
    }

}
