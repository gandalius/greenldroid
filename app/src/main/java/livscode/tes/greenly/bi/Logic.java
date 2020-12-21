package livscode.tes.greenly.bi;

import java.util.ArrayList;
import java.util.List;

public class Logic {

    private ArrayList<String> listBoardingPassTxt;

    public Logic(ArrayList<String> listBoardingPassTxt) {
        this.listBoardingPassTxt = listBoardingPassTxt;
    }

    public void partitionRow(String singleinput) {
        String code = singleinput.substring(1,7);
        int batasAwal = 0;
        int batasAkhir = 127;
        char huruf;


        for (int i = 0; i < code.length(); i++) {
            huruf = code.charAt(i);


        }

    }

    public void partitionColumn(String singleinput) {
        String code = singleinput.substring(1,7);
        int batasAwal = 0;
        int batasAkhir = 7;

        for (int i = 0; i < code.length(); i++) {
            if(code.charAt(i)=='R'){

            }else if(code.charAt(i)=='L'){

            }

        }
    }


}
