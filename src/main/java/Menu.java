import java.util.Scanner;

public class Menu {

    public final AdviceService adviceService;

    public Menu(AdviceService adviceService) {
        this.adviceService = adviceService;
    }

    //user menu
    public void displayMenu() {
        boolean doContinue = true;

        while (doContinue) {
            System.out.println("");
            System.out.println("Great advice for every day");
            System.out.println("Choose one of the options:");
            System.out.println("1. Random advice");
            System.out.println("2. Search for advice by id or topic");
            System.out.println("3. Saved quotes");  //in next step we can export saved quotes to file or delete them
            System.out.println("0. Exit");
            int nextInt = -1;
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()){
                nextInt=scanner.nextInt();
            }



            //what to do after user choice
            switch (nextInt) {
                case 1: {
                    System.out.println("");
                    System.out.println("*** ADVICE FOR YOU***");
                    System.out.println(AdviceService.getRandomAdvice().getAdvice());
                    System.out.println("****");
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


}
