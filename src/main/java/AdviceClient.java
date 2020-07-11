import com.google.gson.Gson;
import database.Slip;
import http.*;

public class AdviceClient {

    //metody związane z obsługą API

    private static final String URL = "https://api.adviceslip.com/";
    private final HttpClient httpClient = new HttpClient();


    public SlipDto getRandomAdvice() {
        String response = httpClient.fetch(URL + "advice");
        SlipResponse slipResponse = ResponseParser.parseFromString(response, SlipResponse.class);
        return slipResponse.getSlip();
    }

    public SearchResponse searchByString(String query) throws SlipNotFoundException {
        String response = httpClient.fetch(URL + "advice/search/" + query);
        SearchResponse searchResponse = ResponseParser.parseFromString(response, SearchResponse.class);
        if (searchResponse.getQuery() == null) {
            throw new SlipNotFoundException("Slip not found for keyword: " + query);
        }
        return searchResponse;

    }

    public SlipDto searchById(int id) {
        String s = httpClient.fetch(URL + "advice/" + id);
        s+='}';
        SlipResponse slipResponse = ResponseParser.parseFromString(s, SlipResponse.class);
        return slipResponse.getSlip();

    }


}
