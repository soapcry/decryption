# Преобразование строки шифром Цезаря
Преобразует строку шифром Цезаря, возвращает зашифрованную строку:

```java
Encryptor.encrypt(String raw, int key);
```
# Декодирование путем частотного анализа
Декодирует строку с применением частотного анализа, возвращает расшифрованную строку:

```java
Decryptor.decrypt(String raw, char supposed_char, boolean message);
```
Аналог предыдущего метода, но возвращает все возможные варианты расшифрованной строки для каждой буквы алфавита:

```java
Decryptor.decryptTotally(String raw, boolean message);
```
Результат работы программы:
![Image alt](https://github.com/soapcry/decryption/blob/main/image.png)
