package livscode.tes.greenly.core;

import java.util.ArrayList;

public class Logic {

    private ArrayList<String> listBoardingPassTxt;

    public Logic(ArrayList<String> listBoardingPassTxt) {
        this.listBoardingPassTxt = listBoardingPassTxt;
    }

    public int partitionRow(String singleInput) {
        String code = singleInput.substring(1, 7);
        int startValue = 0;
        int endValue = 127;
        int middleValue = 0;
        for (int i = 0; i < code.length(); i++) {
            middleValue = Math.round((startValue + endValue) / 2);
            if (code.charAt(i) == 'F') {
                endValue = middleValue;
            } else if (code.charAt(i) == 'B') {
                startValue = middleValue;
            }

        }
        return middleValue;
    }

    public int partitionColumn(String singleInput) {
        String code = singleInput.substring(8, 10);
        int startValue = 0;
        int endValue = 7;
        int middleValue = 0;
        for (int i = 0; i < code.length(); i++) {
             middleValue = Math.round((startValue + endValue) / 2);
            if (code.charAt(i) == 'R') {
                endValue = middleValue;
            } else if (code.charAt(i) == 'L') {
                startValue = middleValue;
            }
        }

        return middleValue;
    }


}
