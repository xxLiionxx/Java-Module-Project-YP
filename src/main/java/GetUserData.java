import java.util.Locale;
import java.util.Scanner;

public class GetUserData {
    int numberOfGuests = 0;
    double total;
    private double price;
    private String temp = null, listOfProducts = "Добавленные товары:\n";
    private Scanner userInput = new Scanner(System.in);

    void execute() {
        String stopCode;

        getNumberOfGuests();
        while (true) {
            stopCode = getProduct();
            if (stopCode.toLowerCase(Locale.ROOT).equals("завершить")) {
                break;
            }
            total = getPrice();
        }
        System.out.println(listOfProducts);
    }

    private int getNumberOfGuests () {
        System.out.println("На сколько человек разделить счет?");
        while (numberOfGuests <= 1) {
            Scanner userInput = new Scanner(System.in);
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
            }
        }
        System.out.println("Количество человек: " + numberOfGuests);
        return numberOfGuests;
    }

    private String getProduct() {

        while (true) {
            System.out.println("Введите название товара");
            if (userInput.hasNextDouble()) {
                System.out.println("Название товара не может состоять из одних только цифр!");
                userInput.next();
                continue;
            } else {
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
                    return "продолжем";
                }
            }
        }
    }

    private double getPrice() {

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
