import database.Slip;
import database.SlipDao;
import http.HttpClient;
import http.SlipDto;
import http.SlipResponse;

import java.util.List;


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
}
