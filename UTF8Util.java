import java.io.UnsupportedEncodingException;

public class UTF8Util {
    // Kullanıcıdan alınan veriyi UTF-8 formatına dönüştürme
    public static String convertToUTF8(String input) {
        try {
            byte[] bytes = input.getBytes("UTF-8");
            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            System.out.println("Error converting to UTF-8: " + e.getMessage());
            return input; // Eğer hata olursa, orijinal veriyi döndür
        }
    }
}
