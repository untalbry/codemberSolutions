package CHALLENGE_02;

public class challenge02 {
    public static void main(String[] args) {
        challenge(
                "&###@&*&###@@##@##&######@@#####@#@#@#@##@@@@@@@@@@@@@@@*&&@@@@@@@@@####@@@@@@@@@#########&#&##@@##@@##@@##@@##@@##@@##@@##@@##@@##@@##@@##@@##@@##@@##@@&");
    }

    /**
     * 
     * @param txt
     * @return operations result
     *         # add 1
     * @ subtract 1
     * * Multiply by it self
     * & print the current numeric value
     */
    public static void challenge(String txt) {
        int number = 0;
        for (char c : txt.toCharArray()) {
            switch (c) {
                case '#':
                    number++;
                    break;
                case '@':
                    number--;
                    break;
                case '*':
                    number *= number;
                    break;
                case '&':
                    System.out.print(number);
                    break;
                default:
                    break;
            }
        }
    }
}
