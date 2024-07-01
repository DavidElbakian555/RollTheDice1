import java.util.Random;
import java.util.Scanner;

public class RollTheDice {
    public static void main(String[] args) {
        int count = 0;
        int bestCount = Integer.MAX_VALUE;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int randomNumber = random.nextInt(100) + 1;

            while (true) {
                System.out.println("Введите число от 1 до 100 (или RESULT для вывода результатов): ");
                String input = scanner.next();

                if (input.equalsIgnoreCase("RESULT")) {
                    System.out.println("Текущие количество попыток: " + count);
                    if (bestCount == Integer.MAX_VALUE) {
                        System.out.println("Ещё не было побед.");
                    } else {
                        System.out.println("Лучший результат (наименьшее количество попыток): " + bestCount);
                    }
                    continue;
                }

                int myNumber;
                try {
                    myNumber = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Пожалуйста, введите корректное число или команду RESULT.");
                    continue;
                }

                System.out.println("Загаданное число: " + randomNumber);

                if (myNumber < randomNumber) {
                    System.out.println("Я сам в шоке, но, загаданное число больше, брат");
                } else if (myNumber > randomNumber) {
                    System.out.println("Не ожидал от тебя такого. Загаданное число меньше, брат");
                } else {
                    count++;
                    System.out.println("Всего попыток было совершено: " + count);
                    System.out.println("Ты угадал! Загаданное число = " + randomNumber);

                    if (count < bestCount) {
                        bestCount = count;
                        System.out.println("Это новый рекорд!");
                    }

                    break;
                }

                count++;
            }

            count = 0;
        }
    }
}