import java.util.Scanner;

public class ByteStuffing {

    // Sender side: performs byte stuffing
    public static String senderByteStuffing(String data, char flag, char esc) {
        StringBuilder stuffedData = new StringBuilder();
        stuffedData.append(flag); // add start flag

        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == flag || data.charAt(i) == esc) {
                stuffedData.append(esc); // insert escape character
            }
            stuffedData.append(data.charAt(i));
        }

        stuffedData.append(flag); // add end flag
        return stuffedData.toString();
    }

    // Receiver side: performs byte unstuffing
    public static String receiverByteUnstuffing(String stuffedData, char flag, char esc) {
        StringBuilder originalData = new StringBuilder();
        boolean escapeNext = false;

        for (int i = 1; i < stuffedData.length() - 1; i++) { // Ignore the flags
            if (escapeNext) {
                originalData.append(stuffedData.charAt(i));
                escapeNext = false;
            } else if (stuffedData.charAt(i) == esc) {
                escapeNext = true; // Skip the escape character and treat next as data
            } else {
                originalData.append(stuffedData.charAt(i));
            }
        }
        return originalData.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entered data for Byte Stuffing: ");
        String data = "AESCFLAGESCFLAGC";
        System.out.println(data);
        char flag = 'F';  // Flag character
        char esc = 'E';   // Escape character

        String stuffedData = senderByteStuffing(data, flag, esc);
        System.out.println("Sender Side -> ");
        System.out.println("Stuffed Data: " + stuffedData);
        
        String receivedData = receiverByteUnstuffing(stuffedData, flag, esc);
        System.out.println("Receiver Side -> ");
        System.out.println("Unstuffed Data (Received): " + receivedData);
    }
}
