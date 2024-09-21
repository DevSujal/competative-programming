
import java.util.*;
public class BitStuffing {

    // Sender side: performs bit stuffing
    public static String senderBitStuffing(String data) {
        StringBuilder stuffedData = new StringBuilder();
        int count = 0;

        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == '1') {
                count++;
                stuffedData.append('1');
            } else {
                count = 0;
                stuffedData.append('0');
            }
            // Stuff a '0' after five consecutive '1's
            if (count == 5) {
                stuffedData.append('0');
                count = 0;
            }
        }
        return stuffedData.toString();
    }

    // Receiver side: performs bit unstuffing
    public static String receiverBitUnstuffing(String stuffedData) {
        StringBuilder originalData = new StringBuilder();
        int count = 0;

        for (int i = 0; i < stuffedData.length(); i++) {
            if (stuffedData.charAt(i) == '1') {
                count++;
                originalData.append('1');
            } else {
                originalData.append('0');
                count = 0;
            }
            // Skip the stuffed '0' after five consecutive '1's
            if (count == 5 && i + 1 < stuffedData.length() && stuffedData.charAt(i + 1) == '0') {
                i++;
                count = 0;
            }
        }
        return originalData.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entered binary data for Bit Stuffing: ");
        String data = "0111111011101111111001";
        System.out.println(data);
        String stuffedData = senderBitStuffing(data);
        System.out.println("Sender Side -> ");
        System.out.println("Stuffed Data: " + stuffedData);
        
        String receivedData = receiverBitUnstuffing(stuffedData);
        System.out.println("receiver Side -> ");
        System.out.println("Unstuffed Data (Received): " + receivedData);
    }
}

