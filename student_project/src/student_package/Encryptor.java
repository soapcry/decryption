/*
 * Файл - Encryptor.java
 * --------------------------
 * Методы:
 * 
 * encrypt - преобразует строку шифром Цезаря, возвращает зашифрованную строку
 */

package student_package;

public class Encryptor {

	public static void main(String[] args) {}

	public static String encrypt(String raw, int key) {

		String output = "";

		for (int i = 0; i < raw.length(); i++) {

			char letter = raw.toUpperCase().charAt(i);

			if (letter >= 'A' && letter <= 'Z') {

				int encrypted_letter_code = ((int) letter - 'A' + key) % 26 + 'A';
				char encrypted_letter = (char) encrypted_letter_code;
				output += encrypted_letter;
			} else {

				output += letter;
			}
		}
			
		System.out.println("Зашифрованная строка: ");
		return output;
	}
}
