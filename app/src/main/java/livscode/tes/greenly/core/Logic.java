package livscode.tes.greenly.core;

import java.util.ArrayList;

public class Logic {

    private ArrayList<String> listBoardingPassTxt;

    public Logic(ArrayList<String> listBoardingPassTxt) {
        this.listBoardingPassTxt = listBoardingPassTxt;
    }

    public int eliminateRow(String singleInput) {
        String code = singleInput.substring(1, 7);
        int startValue = 0;
        int endValue = 127;
        int currentValue = 0;
        for (int i = 0; i < code.length(); i++) {
            if ((endValue - startValue) == 1) {

                if (code.charAt(i) == 'F') {
                    currentValue = endValue;
                } else if (code.charAt(i) == 'B') {
                    currentValue = startValue;
                }
            } else {
                currentValue = Math.round((startValue + endValue) / 2);
                if (code.charAt(i) == 'F') {
                    endValue = currentValue;
                } else if (code.charAt(i) == 'B') {
                    startValue = currentValue;
                }
            }
        }
        return currentValue;
    }

    public int eliminateColumn(String singleInput) {
        String code = singleInput.substring(1, 7);
        int startValue = 0;
        int endValue = 127;
        int currentValue = 0;
        for (int i = 0; i < code.length(); i++) {
            if ((endValue - startValue) == 1) {

                if (code.charAt(i) == 'F') {
                    currentValue = endValue;
                } else if (code.charAt(i) == 'B') {
                    currentValue = startValue;
                }
            } else {
                currentValue = Math.round((startValue + endValue) / 2);
                if (code.charAt(i) == 'F') {
                    endValue = currentValue;
                } else if (code.charAt(i) == 'B') {
                    startValue = currentValue;
                }
            }
        }
        return currentValue;
    }

    public int getSeatId(int row, int column) {
        return (row * 8) + column;
    }

}
