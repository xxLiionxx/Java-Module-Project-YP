import java.util.Locale;
import java.util.Scanner;

public class GetUserData {
    int numberOfGuests = 0;
    double total;
    private String stopCode, listOfProducts = "Добавленные товары:\n";
    private Scanner userInput = new Scanner(System.in);

    void execute() {

        numberOfGuests = getNumberOfGuests();
        while (true) {
            stopCode = getProduct();

            if (stopCode.toLowerCase(Locale.ROOT).equals("завершить")) {
                break;
            }

            total = getPrice();
        }
        userInput.close();
        System.out.println(listOfProducts);
    }

    private int getNumberOfGuests () {

        System.out.println("На сколько человек разделить счет?");
        while (numberOfGuests <= 1) {
            if (userInput.hasNextInt()) {
                numberOfGuests = userInput.nextInt();
                if (numberOfGuests == 1) {
                    System.out.println("Некорректный ввод! На 1 человека нет смысла делить счет.");
                }
                if (numberOfGuests <= 0) {
                    System.out.println("Некорректный ввод! Количество человек не может быть меньше или равно 0.");
                }
            } else {
                System.out.println("Некорректный ввод! Количество человек может быть только целом числом.");
                userInput.next();
            }
        }
        System.out.println("Количество человек: " + numberOfGuests);
        return numberOfGuests;
    }

    private String getProduct() {
        String temp;

        while (true) {
            System.out.println("Введите название товара");
            userInput.useDelimiter("\\n");
            temp = userInput.next();
            if (temp.isEmpty()) {
                System.out.println("Введена пустная строка. Попробуйте еще раз.");
                continue;
            }
            if (temp.toLowerCase(Locale.ROOT).equals("завершить")) {
                return "завершить";
            } else {
                listOfProducts += temp + " ";
                return "продолжаем";
            }
        }
    }

    private double getPrice() {
        double price;

        while (true) {
            System.out.println("Введите цену товара в формате \"рубли,копейки\", например: 4,20");
            if (userInput.hasNextDouble()) {
                price = userInput.nextDouble();
                if (price <= 0) {
                    System.out.println("Цена товара не может быть меньше или равна 0");
                } else {
                    listOfProducts += price + "\n";
                    total += price;
                    System.out.println("Товар и его цена успешно добавлены.\nВы можете продолжить добавление товаров или закончить введя \"завершить\".");
                    return total;
                }
            } else {
                System.out.println("Некорректный ввод!");
                userInput.next();
                continue;
            }
        }
    }
}
