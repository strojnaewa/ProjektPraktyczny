import http.HttpClient;
import http.SearchResponse;
import http.SlipDto;
import http.SlipResponse;

public class AdviceClient {

    //metody związane z obsługą API

    private static final String URL = "https://api.adviceslip.com/";
    private final HttpClient httpClient = new HttpClient();



    public SlipDto getRandomAdvice() {
        return httpClient.fetch(URL + "advice", SlipResponse.class).getSlip();
    }

    public void searchById(int id){


    }


    public SearchResponse searchByString(String query){
        return httpClient.fetch(URL+"advice/search/"+query, SearchResponse.class);

    }
}
