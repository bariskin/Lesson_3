/**
 * Java Level 1. Lesson 3.
 *
 * @author  Aleksander Kyurkchu
 * @version dated 20 Sep 2018
 */


import java . util . Scanner ;


public class HW3Lesson {

    public static Scanner sc = new Scanner(System.in);     // сканер вводимых чисел

    public static void main(String[] args) {
        // call for task №1
        runGame1();
        // call for task №2
        runGame2();
    }

    /**
     * Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3
     * попытки угадать это число. При каждой попытке компьютер должен сообщить больше ли
     * указанное пользователем число, чем загаданное, или меньше. После победы или проигрыша
     * выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
     */

    public static void runGame1() {
        int c;
        int b;

        b = (int) (Math.random() * 10);

        for (int i = 0; i < 3; i++) {
                 c = getNumberFromScanner("Введите число: пределах 0 и 10 ", 0, 10);

               if (c > b) System.out.println("Введенное Вами число больше");
               else if (c < b) System.out.println("Введенное Вами число меньше");
               else {
                   System.out.println("Вы угадали число");
                   break;
               }
        }

        System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        c = sc.nextInt();

        if (c == 1) runGame1();

        else if (c == 0) return;
    }


    public static int getNumberFromScanner(String message, int min, int max) {
        int x;
        do {
            System.out.println(message);
            x = sc.nextInt();
        } while (x < min || x > max);
        return x;
    }
/**
   * Создать массив из слов
   * String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
   *         "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
   *         "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
   * При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
   * сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если
   * слово не угадано, компьютер показывает буквы которые стоят на своих местах.
   * apple – загаданное
   * apricot - ответ игрока
   * ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
   * Для сравнения двух слов посимвольно, можно пользоваться:
   * String str = "apple";
   * str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
   * Играем до тех пор, пока игрок не отгадает слово
  *  Используем только маленькие буквы
*/

    public static void runGame2() {

        Scanner sc = new Scanner(System.in);
        int random_number;
        String[] words;
        String temp_word;
        char[] word1;
        char[] word2;
        String scan_word;
        char[] result = new char[15];
         int arrayL = 0;

        // создание массива слова
        words = new String[]{"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};


        // генерация случайного индекса в пределах индекса массива слов
        random_number = (int) (Math.random() * words.length);

        // выбор случайного слова из массива
        temp_word = words[random_number];

        // пребразование слова в массив типа char []
        word1 = temp_word.toCharArray();

        System.out.println("Введите строку: ");

       // считать введеное слово
        scan_word = sc.nextLine();

        // пребразование слова в массив типа char []
        word2 = scan_word.toCharArray();

       // пока слова не совпали
        while (!( scan_word .equals(temp_word))) {

            if(word1.length > word2.length) arrayL = word2.length;
            else if (word1.length  < word2.length) arrayL = word1.length;
            else if (word1.length == word2.length) arrayL = word1.length;
            else arrayL = 0;
            // ловля исключений
            try {

                for (int i = 0; i < arrayL; i++) {

                    if(word1[i] == word2[i]) {
                        result[i] = word1[i];
                    }
                    else if(word1[i] != word2[i]) {
                        result[i] = '#';
                    }
                }

                // дополняем массив знаками #
                for(int j = 0 ;j < 15; j++) {
                   if ( result[j] == ' ') result[j] = '#';;
                }
               }
               // обработка исключений
               catch(StringIndexOutOfBoundsException e){
                        System.out.println("String  out of: " + e);
                    }
               catch(ArrayIndexOutOfBoundsException e){
                        System.out.println("Array out of: " + e);
                    }

            System.out.println(result);
            for (int i = 0; i < result.length; i++) {result[i] = ' ';}
            System.out.println("Введите строку заново: ");

            scan_word = sc.nextLine();                             //считать новое веденное слово
            word2 = scan_word.toCharArray();

        }
         System.out.println("Вы угадали слово " );
         System.out.println(temp_word );
    }
}

