import database.Slip;
import database.SlipDao;
import http.HttpClient;
import http.SlipDto;
import http.SlipResponse;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//metody związane z bazą danych
public class AdviceService {


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

    public void addToFavorites(SlipDto slip) {
        Slip slipToSave = new Slip(slip);
        SlipDao slipdao = new SlipDao();
        slipdao.insertOrUpdate(slipToSave);
    }


}

