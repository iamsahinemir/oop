import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Date {
    private static final String DATE_PATTERN = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$";

    private int year;
    private int month;
    private int day;

    /**
     * Constructor: Tarih formatını ve geçerli olup olmadığını kontrol ederek bir Date nesnesi oluşturur.
     *
     * @param dateStr Kullanıcıdan alınan tarih stringi (YYYY-MM-DD formatında olmalı).
     */
    public Date(String dateStr) {
        if (!isValidFormat(dateStr)) {
            throw new IllegalArgumentException("Geçersiz tarih formatı! Beklenen format: YYYY-MM-DD");
        }
        if (!isValidDate(dateStr)) {
            throw new IllegalArgumentException("Geçersiz tarih!");
        }

        String[] parts = dateStr.split("-");
        this.year = Integer.parseInt(parts[0]);
        this.month = Integer.parseInt(parts[1]);
        this.day = Integer.parseInt(parts[2]);
    }



    /**
     * Tarih stringinin formatını kontrol eder (YYYY-MM-DD).
     *
     * @param dateStr Kontrol edilecek tarih stringi.
     * @return Format doğruysa true, değilse false.
     */
    private static boolean isValidFormat(String dateStr) {
        Pattern pattern = Pattern.compile(DATE_PATTERN);
        Matcher matcher = pattern.matcher(dateStr);
        return matcher.matches();
    }

    /**
     * Tarihin gerçek bir tarih olup olmadığını kontrol eder.
     *
     * @param dateStr Kontrol edilecek tarih stringi.
     * @return Tarih geçerliyse true, geçersizse false.
     */
    private static boolean isValidDate(String dateStr) {
        String[] parts = dateStr.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        if (month < 1 || month > 12 || day < 1) {
            return false;
        }

        int daysInMonth = getDaysInMonth(year, month);
        return day <= daysInMonth;
    }

    /**
     * Verilen yıl ve aya göre ayın kaç gün çektiğini döndürür.
     *
     * @param year  Yıl.
     * @param month Ay.
     * @return Ayın gün sayısı.
     */
    private static int getDaysInMonth(int year, int month) {
        switch (month) {
            case 2: // Şubat
                return isLeapYear(year) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11: // 30 gün çeken aylar
                return 30;
            default: // 31 gün çeken aylar
                return 31;
        }
    }

    /**
     * Bir yılın artık yıl olup olmadığını kontrol eder.
     *
     * @param year Kontrol edilecek yıl.
     * @return Artık yıl ise true, değilse false.
     */
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    /**
     * Tarihi `YYYY-MM-DD` formatında döndürür.
     *
     * @return Formatlanmış tarih stringi.
     */
    @Override
    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    /**
     * Kullanıcıdan tarih girdisi alır ve bir Date nesnesi oluşturur.
     *
     * @return Oluşturulan Date nesnesi.
     */
    public static Date fromUserInput() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        try {
            System.out.print("Tarih (YYYY-MM-DD): ");
            String dateStr = scanner.nextLine();
            return new Date(dateStr);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return fromUserInput();
        } finally {
            scanner.close(); // Scanner nesnesi burada kapatılıyor.
        }
    }

    /**
     * Ana metot: Kullanıcıdan bir tarih alır ve sonucu ekrana yazdırır.
     */
    public static void main(String[] args) {
        try {
            Date date = Date.fromUserInput();
            System.out.println("Girilen Tarih: " + date);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
