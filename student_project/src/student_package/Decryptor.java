/*
 * Файл - Decryptor.java
 * --------------------------
 * Методы:
 * 
 * mostCommonLetter - возвращает самую часто встречаемую букву в строке
 * mostCommonLetterAmount - возвращает количество вхождений такой буквы в строке
 * decrypt - декодирует строку с применением частотного анализа, возвращает расшифрованную строку
 * decryptTotally - аналог decrypt, но возвращает все возможные варианты расшифровки строки
 */

package student_package;

public class Decryptor {

	public static void main(String[] args) {}
	
	public static char mostCommonLetter(String raw) {
		
		char most_common_letter = '?';
		int most_common_amount = 0;

		// Первый цикл зашифрованной строки
		for (int i = 0; i < raw.length(); i++) {

			// Символ зашифрованной строки для сравнения
			char i_letter = raw.toUpperCase().charAt(i);

			// Начинаем подсчет, если символ является частью алфавита
			if (i_letter >= 'A' && i_letter <= 'Z') {

				int i_letter_amount = 0;

				// Второй цикл зашифрованной строки
				for (int j = 0; j < raw.length(); j++) {

					char j_letter = raw.toUpperCase().charAt(j);

					// Добавляем +1 к вхождениям символа для сравнения
					if (i_letter == j_letter) {

						i_letter_amount++;
					}
				}

				// Проверяем, является ли символ наиболее частым в строке
				if (i_letter_amount > most_common_amount) {

					most_common_letter = i_letter;
					most_common_amount = i_letter_amount;
				}
			}
		}
		
		return most_common_letter;
	}

	public static int mostCommonLetterAmount(String raw) {
		
		int most_common_amount = 0;

		// Первый цикл зашифрованной строки
		for (int i = 0; i < raw.length(); i++) {

			// Символ зашифрованной строки для сравнения
			char i_letter = raw.toUpperCase().charAt(i);

			// Начинаем подсчет, если символ является частью алфавита
			if (i_letter >= 'A' && i_letter <= 'Z') {

				int i_letter_amount = 0;

				// Второй цикл зашифрованной строки
				for (int j = 0; j < raw.length(); j++) {

					char j_letter = raw.toUpperCase().charAt(j);

					// Добавляем +1 к вхождениям символа для сравнения
					if (i_letter == j_letter) {

						i_letter_amount++;
					}
				}

				// Проверяем, является ли символ наиболее частым в строке
				if (i_letter_amount > most_common_amount) {

					most_common_amount = i_letter_amount;
				}
			}
		}
		
		return most_common_amount;
	}
	
	public static String decrypt(String raw, char supposed_char, boolean message) {
		
		// Расшифрованная строка, которая будет возвращена методом
		String output = "";
		
		// Наиболее частая буква в зашифрованном тексте и ее количество вхождений
		char most_common_letter = mostCommonLetter(raw);
		int most_common_amount = mostCommonLetterAmount(raw);
		
		// Находим величину сдвига шифра - модуль разности предполагаемой и наиболее частой буквы
		int key = Math.abs( (int) most_common_letter - (int) supposed_char );
		
		// Применяем найденный сдвиг для всей зашифрованной строки с учетом мощности алфавита
		for (int i = 0; i < raw.length(); i++) {
			
			// Текущий символ зашифрованной строки
			char letter = raw.toUpperCase().charAt(i);
			
			// Если текущий символ является буквой алфавита..
			if (letter >= 'A' && letter <= 'Z') {
				
				// Сдвигаем в обратном направлении с учетом мощности алфавита
				int decrypted_letter_code = ((int) letter - 'A' - key + 26) % 26 + 'A';
				char decrypted_letter = (char) decrypted_letter_code;
				output += decrypted_letter;
			} else {
				
				output += letter;
			}
		}
		
		if (message) System.out.println("Самая частая буква - " + most_common_letter + ". Количество вхождений - " + most_common_amount + ". Расшифрованная строка (предположительно буква " + supposed_char + "): ");
		
		return output;
	}

	public static String decryptTotally(String raw, boolean message) {
		String output = "";
		
		for (int i = (int) 'A'; i <= (int) 'Z'; i++) {
			
			output += decrypt(raw, (char) i, false) + "\n";
		}
		
		if (message) System.out.println("Все варианты расшифрованной строки: ");
		return output;
	}
}
