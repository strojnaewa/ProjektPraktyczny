import database.Slip;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class AdviceExporter {

              //w tym miejscu zmień ścieżkę do pliku
       private final String dirPath= "C:\\Users\\Xander Realiity\\IdeaProjects\\ProjektPraktyczny\\";

    public void exportToFile(List<Slip> allAdvice){
        PrintWriter save = null;
        try {
            save = new PrintWriter(dirPath+"favourite.txt");

            for (Slip advice:allAdvice
                 ) {


                save.println("|slipID = "+advice.getSlipId()+" | ID= "+advice.getId()+" | advice = "+advice.getAdvice()+" |");
                            }

            save.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }


    }
}
