import database.Slip;
import database.SlipDao;
import http.SearchResponse;
import http.SlipDto;
import http.SlipNotFoundException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public final AdviceService adviceService;
    public final AdviceClient adviceClient;


    public Menu(AdviceService adviceService, AdviceClient adviceClient) {
        this.adviceService = adviceService;
        this.adviceClient = adviceClient;
    }

    //user menu
    public void displayMenu(){
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
            if (scanner.hasNextInt()) {
                nextInt = scanner.nextInt();
            }


            //what to do after user choice
            switch (nextInt) {
                case 1: {
                    SlipDto randomAdvice = adviceClient.getRandomAdvice();
                    String advice = randomAdvice.getAdvice();
//                    adviceService.saveAdvice(randomAdvice);

                    System.out.println("");
                    System.out.println("*** ADVICE FOR YOU***");
                    System.out.println(advice);
                    System.out.println("****");
                    menuCase1();
                    break;

                    //dodajemy zapisz albo powrót
                }
                case 2: {
                    menuCase2();
                    break;
                }
                case 3: {
                    // List<Slip> allAdvices = adviceService.getAllAdvices();
                    // System.out.println(Arrays.toString(allAdvices.toArray()));
                    menuCase3();
                    break;
                    //do dodania: wyświetl, usuń i powrót
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

    public void menuCase1() {
        boolean doContinue = true;
        SlipDto randomAdvice = adviceClient.getRandomAdvice();
        while (doContinue) {

            System.out.println("");
            System.out.println("What would you like to do next?");
            System.out.println("Choose one of the options:");
            System.out.println("1. Get next quote");
            System.out.println("2. Add to favorites");
            System.out.println("0. Exit");
            int nextInt = -1;
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                nextInt = scanner.nextInt();
            }

            switch (nextInt) {
                case 1: {
                    randomAdvice = adviceClient.getRandomAdvice();
                    String advice = randomAdvice.getAdvice();

                    System.out.println("");
                    System.out.println("*** ADVICE FOR YOU***");
                    System.out.println(advice);
                    System.out.println("****");
                    break;
                }
                case 2: {
                    adviceService.saveAdvice(randomAdvice);
                    System.out.println("Record added to favourites ");
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

    private void menuCase2() {
        boolean continuing = true;
        //SlipDto fetchedSlip = null;

        while (continuing) {
            System.out.println();
            System.out.println("Search submenu");
            System.out.println("Choose:");
            System.out.println("1 - Search by keyword");
            System.out.println("2 - Search by Id");
            System.out.println("0 - Exit");

            int option = -1;
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                option = Integer.parseInt((scanner.nextLine()));
            }

            switch (option) {
                case 0: {
                    continuing = false;
                    break;
                }
                case 1: {
                    System.out.println("Insert keyword:");
                    String keyword = scanner.nextLine();
                    try {
                        SearchResponse sr = adviceClient.searchByString(keyword);
                        System.out.println(sr) ;
                    } catch (SlipNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 2: {
                    System.out.println("Insert ID:");
                    int id = scanner.nextInt();
                    SlipDto slipDto = adviceClient.searchById(id);
                    System.out.println(slipDto);
                    break;
                }
                case -1: {
                    System.out.println("Pass a number!");
                    break;
                }
                default: {
                    System.out.println("Unknown function");
                    break;
                }
            }
        }
    }

    public void menuCase3() {
        boolean doContinue = true;

        while (doContinue) {
            System.out.println("");
            System.out.println("Choose option");
            System.out.println("1. Show my favourites");
            System.out.println("2. Delete quote (slipID)");
            System.out.println("0. Exit");
            int nextInt = -1;
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                nextInt = scanner.nextInt();
            }

            switch (nextInt) {
                case 1: {
                    List<Slip> allAdvices = adviceService.getAllAdvices();
                    System.out.println(Arrays.toString(allAdvices.toArray()));
                    break;
                }

                case 2: {
                    System.out.println("Write slipID to delete");

                    int deleteID = scanner.nextInt();
                    SlipDao slipdao = new SlipDao();
                    slipdao.deleteID(deleteID);


                    //do dodania: wyświetl, usuń i powrót
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
