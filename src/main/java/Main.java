import java.util.Scanner;

public class Main {

    private static final String URL = "https://api.adviceslip.com/";

    public static void main(String[] args) {

        displayMenu();

    }

    //user menu
    public static void displayMenu() {
        boolean doContinue = true;

        while (doContinue) {
            System.out.println("Great advice for every day");
            System.out.println("Choose one of the options:");
            System.out.println("1. Random advice");
            System.out.println("2. Search for advice by id or topic");
            System.out.println("3. Saved quotes");  //in next step we can export saved quotes to file or delete them
            System.out.println("0. Exit");
            Scanner scanner = new Scanner(System.in);
            final int nextInt = scanner.nextInt();
            //what to do after user choice
            switch (nextInt) {
                case 1: {
                    getRandomAdvice();
                    break;
                }
                case 2: {
                    System.out.println("Not implemented yet, ssorry :( ");
                    break;
                }
                case 3: {
                    System.out.println("Not implemented yet, ssorry :( ");
                    break;
                }
                case 0: {
                    doContinue = false;
                    break;
                }
                default: {
                    System.out.println("Wrong command");
                }
            }


        }

    }

    public static void getRandomAdvice() {
        HttpClient httpClient = new HttpClient();
        Slip slip = httpClient.fetch(URL + "advice", SlipResponse.class).getSlip();
        System.out.println(slip.getAdvice());


    }

}
