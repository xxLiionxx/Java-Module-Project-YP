public class Calculator {
    private double result;
    private String rightRubleEnding, outputTemplate;

    void calculate() {
        GetUserData userData = new GetUserData();

        userData.execute();

        if (userData.total == 0) {
            System.out.println("Список товаров пуст. Рассчет не требуются.");
        } else {
            rightRubleEnding = getRubleEnding(userData.total);
            outputTemplate = "Итого: %.2f %s";
            System.out.println(String.format(outputTemplate, userData.total, rightRubleEnding));

            result = userData.total / userData.numberOfGuests;
            rightRubleEnding = getRubleEnding(result);
            outputTemplate = "Каждый должен по счету: %.2f %s";
            System.out.println(String.format(outputTemplate, result, rightRubleEnding));
        }
    }

    private String getRubleEnding (double price) {
        int tempPrice;

        tempPrice = (int) price % 100;
        if (tempPrice < 21) {
            switch (tempPrice) {
                case 1:
                    rightRubleEnding = "рубль";
                    break;
                case 2:
                case 3:
                case 4:
                    rightRubleEnding = "рубля";
                    break;
                default:
                    rightRubleEnding = "рублей";
                    break;
            }
        } else {
            tempPrice %= 10;
            switch (tempPrice) {
                case 1:
                    rightRubleEnding = "рубль";
                    break;
                case 2:
                case 3:
                case 4:
                    rightRubleEnding = "рубля";
                    break;
                default:
                    rightRubleEnding = "рублей";
                    break;
            }
        }
        return rightRubleEnding;
    }
}
