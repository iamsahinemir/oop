// Şifreleme, +
//Şifre Çözme +
//Ana Menüye Dön. +
//Kullanıcı Şifreleme veya Şifre Çözme'yi seçtiğinde +
//kendisinden [-26, 26] aralığında bir kaydırma değeri ve şifrelenecek veya çözülecek metni girmesi istenecektir.+
//Rakamlar ve boşluklar aynen kalıcak+
//aralık dışındaysa alt menüye geri dön.   +6
import java.util.Scanner;

public class encryption
{
	public static String getMessage()
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Please, enter your message to be encrypted: ");
		String message = input.nextLine();
		System.out.println("Your message before encrypted: " +message);
		return message;
	}

	public static String get_en_Message()
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Please, enter your encryted message to be decryption: ");
		String message = input.nextLine();
		System.out.println("Your message before decrytion: " +message);
		return message;
	}
	public static int enc_number(){
        Scanner input = new Scanner(System.in);
        int number;
        System.out.println("Please, enter a number for encryption.");
        System.out.println("It should be between [-26, 26].");

        while (true) {
            number = input.nextInt();
            if (number > 26 || number < -26) {
                System.out.println("You entered the wrong range and you are returned to the main menu.");
                return 0; 
            } else {
                break; 
            }
        }
        return number; 
	}

	public static String text_to_enc(String message,int number)
	{
		String enc_message="";

		for(int i =0; i<message.length(); i++){
			char ch = message.charAt(i);
			if((message.charAt(i)>=65) && (message.charAt(i)<=90)){
				ch = (char) (((ch - 65 + number) % 26 + 26) % 26 + 65);
			}
			else if((message.charAt(i)>=97) && (message.charAt(i)<=122)){
				ch = (char) (((ch - 97 + number) % 26 + 26) % 26 + 97);
            	}
				enc_message+=ch;
			}
			return enc_message;
	}

	public static String text_to_dec(String message, int number) {
		return text_to_enc(message, -number); 
	}

	public static void print_enc_message(int number,String enc_message_out){
		if (number > 26 || number < -26){
		}
		else{
			System.out.println("Encrypted Message: " + enc_message_out);
		}
	}


	public static void main (String[] args) { 
		String message;
		int number;
		boolean cond=true;
		System.out.println("Plase select one of them");
		System.out.println("[+] = Message encryption");
		System.out.println("[-] = Message decoding");
		System.out.println("[*] = Back to menu");
		Scanner input = new Scanner(System.in);
		String selection = input.nextLine();
		if(selection.charAt(0) != '+' && selection.charAt(0) != '-' && selection.charAt(0) != '*'){
			System.out.println("You have entered an incorrect entry and are being redirected back to the main menu.");
			cond= false;
		}
		else{
			char real_selection='.';
			while(cond){
				real_selection = selection.charAt(0);
				if(real_selection == '*'){
					cond=false;
				}
				else if(real_selection == '+'){
					message = getMessage(); // Mesajı al
					number = enc_number();  // Şifreleme numarasını al
					String enc_message_out = text_to_enc(message, number); // Şifreleme işlemi
					print_enc_message(number,"Encrypted Message: " + enc_message_out); // Şifrelenmiş mesajı yazdır
					cond=false;
				}
				else if(real_selection == '-'){
					message=get_en_Message();
					number = enc_number();
					String enc_message_out =text_to_dec(message, number);
					print_enc_message(number, "Decrypted message: "+ enc_message_out);
					cond=false;
				}
			}


		}	

	}
}






