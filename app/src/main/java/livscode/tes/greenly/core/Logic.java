package livscode.tes.greenly.core;

import java.util.ArrayList;

public class Logic {

    private ArrayList<String> listBoardingPassTxt;

    public Logic() {

    }

    public Logic(ArrayList<String> listBoardingPassTxt) {
        this.listBoardingPassTxt = listBoardingPassTxt;
    }

    public int eliminateRow(String singleInput) {
        String code = singleInput.substring(0, 7);
        int lower = 0;
        int upper = 127;
        int currentValue = 0;
        for (int i = 0; i < code.length(); i++) {
            if ((upper - lower) == 1) {

                if (code.charAt(i) == 'F') {
                    currentValue = lower;
                } else if (code.charAt(i) == 'B') {
                    currentValue = upper;
                }
            } else {
                /*currentValue = (int) Math.round((double)(startValue + endValue) / 2);*/
                currentValue = Math.round((lower + upper) / 2);
                if (code.charAt(i) == 'F') {
                    upper = currentValue;
                } else if (code.charAt(i) == 'B') {
                    lower = currentValue;
                }
            }
        }
        return currentValue;
    }

    public int eliminateColumn(String singleInput) {
        String code = singleInput.substring(7, singleInput.length());
        int lower = 0;
        int upper = 7;
        int currentValue = 0;
        for (int i = 0; i < code.length(); i++) {
            if ((upper - lower) == 1) {
                if (code.charAt(i) == 'L') {
                    currentValue = lower;
                } else if (code.charAt(i) == 'R') {
                    currentValue = upper;
                }
            } else {
                /*currentValue = (int) Math.round((double)(startValue + upper) / 2);
                currentValue =(int)Math.ceil((startValue + upper) / 2);
                currentValue = Math.round(((lower + upper)) / 2)
                currentValue = (int) Math.round((double)(lower + upper) / 2);*/
                currentValue = (int) Math.round((double)(lower + upper) / 2);
                if (code.charAt(i) == 'L') {
                    upper = currentValue;
                } else if (code.charAt(i) == 'R') {
                    lower = currentValue;
                }
            }
        }
        return currentValue;
    }

    public int getSeatId(int row, int column) {
        return (row * 8) + column;
    }

}
