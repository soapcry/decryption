package student_package;

public class Program {
	public static void main(String[] args) {

		// Текст для работы
		String raw_text = "I'd like to tell you about Halloween. It is an old festival. "
				+ "It is more than two thousand years old. In the past this festival was "
				+ "a time of fear because people believed in ghosts and witches.";

		// Шифровка и вывод зашифрованной строки
		String encrypted_text = Encryptor.encrypt(raw_text, 3);
		System.out.println(encrypted_text + "\n");

		// Расшифровка и вывод расшифрованной строки
		String decrypted_text = Decryptor.decrypt(encrypted_text, 'K', true);
		System.out.println(decrypted_text + "\n");
		
		// Все варианты расшифровки
		String decrypted_texts = Decryptor.decryptTotally(encrypted_text, true);
		System.out.println(decrypted_texts + "\n");
	}
}
