public class practical4 {
    static public String transmitBit(String bitStr, String generator) {
        System.out.println("sender side : ");
        System.out.println("data bit : " + bitStr);
        System.out.println("generator bit : " + generator);

        String curr = bitStr.substring(0, 4);
        String result = "";
        for (int i = 0; i < generator.length(); i++) {
            result = (curr.charAt(generator.length() - i - 1) ^ generator.charAt(generator.length() - i - 1)) + result;
        }

        for (int i = 4; i < bitStr.length(); i++) {
            result = removeLeadingZeros(result);
            result += bitStr.charAt(i);
            if (result.length() < generator.length()) {
                continue;
            }
            String temp = "";
            for (int j = 0; j < generator.length(); j++) {
                temp = (result.charAt(generator.length() - j - 1) ^ generator.charAt(generator.length() - j - 1)) + temp;
            }
            result = temp;
        }

        return removeLeadingZeros(result);
    }

    public static String receive(String bitStr, String generator) {
        System.out.println("receiver side : ");
        System.out.println("data bit : " + bitStr);
        System.out.println("generator bit : " + generator);
        String curr = bitStr.substring(0, 4);
        String result = "";
        for (int i = 0; i < generator.length(); i++) {
            result = (curr.charAt(generator.length() - i - 1) ^ generator.charAt(generator.length() - i - 1)) + result;
        }
        for (int i = 4; i < bitStr.length(); i++) {
            result = removeLeadingZeros(result);
            result += bitStr.charAt(i);
            if (result.length() < generator.length()) {
                continue;
            }
            String temp = "";
            for (int j = 0; j < generator.length(); j++) {
                temp = (result.charAt(generator.length() - j - 1) ^ generator.charAt(generator.length() - j - 1)) + temp;
            }
            result = temp;
        }
        return removeLeadingZeros(result);
    }

    static String removeLeadingZeros(String str) {
        int i = 0;
        for (i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '1'){
                break;
            }
        }
        return str.substring(i);
    }
    public static void main(String[] args) {
        String bitStr = "10011101";
        String generator = "1001";
        String offset = "";
        for (int i = 0; i < generator.length() - 1; i++) {
            offset += '0';
        }
        String remainder = transmitBit(bitStr + offset, generator);
        if(remainder.length() < (generator.length() - 1)){
            while (remainder.length() < (generator.length() - 1)) {
                    remainder = '0' + remainder;
            }
        }
        System.out.print("remainer : ");
        System.err.println(remainder);
        System.err.println();
        // bitStr = "10011001";
        remainder = receive(bitStr + remainder, generator);
        System.out.print("remainer : ");
        System.err.println(remainder == "" ? "0" : remainder);
        System.err.println();
        if (remainder.equals("")) {
            System.out.println("data receive is correct");
        }else  {
            System.out.println("data receive is incorrect");
        }
    }
}
