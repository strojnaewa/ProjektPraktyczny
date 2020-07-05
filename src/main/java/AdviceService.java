import database.Slip;
import database.SlipDao;
import http.HttpClient;
import http.SlipDto;
import http.SlipResponse;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class AdviceService {

    private static final String URL = "https://api.adviceslip.com/";
    private final HttpClient httpClient = new HttpClient();

    public SlipDto getRandomAdvice() {
        return httpClient.fetch(URL + "advice", SlipResponse.class).getSlip();
    }

    public void saveAdvice(SlipDto slip) {
        Slip slipToSave = new Slip(slip);
        SlipDao slipdao = new SlipDao();
        slipdao.insertOrUpdate(slipToSave);
    }

    public List<Slip> getAllAdvices() {
        SlipDao slipdao = new SlipDao();
        List<Slip> slips = slipdao.getAll();
        return slips;
    }

    public void addToFavorites(SlipDto slip){
        Slip slipToSave = new Slip(slip);
        SlipDao slipdao = new SlipDao();
        slipdao.insertOrUpdate(slipToSave);
    }

    public void menuCase1() {
        boolean doContinue = true;
        Menu menu = new Menu(new AdviceService());
        SlipDto randomAdvice = menu.adviceService.getRandomAdvice();
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

                    String advice = randomAdvice.getAdvice();
//                    adviceService.saveAdvice(randomAdvice);

                    System.out.println("");
                    System.out.println("*** ADVICE FOR YOU***");
                    System.out.println(advice);
                    System.out.println("****");
                    break;
                }
                case 2: {
                    menu.adviceService.saveAdvice(randomAdvice);
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
}

