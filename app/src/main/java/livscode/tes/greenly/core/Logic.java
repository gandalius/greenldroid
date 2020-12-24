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
        int lower = 1;
        int upper = 128;
        int currentValue = 0;
        for (int i = 0; i < code.length(); i++) {
            currentValue = (lower + upper) / 2;
            if (code.charAt(i) == 'F') {
                upper = currentValue;
            } else if (code.charAt(i) == 'B') {
                lower = currentValue;
            }
        }
        return lower;
    }

    public int eliminateColumn(String singleInput) {
        String code = singleInput.substring(7, singleInput.length());
        int lower = 1;
        int upper = 8;
        int currentValue = 0;
        for (int i = 0; i < code.length(); i++) {
            currentValue = (lower + upper) / 2;
            if (code.charAt(i) == 'L') {
                upper = currentValue;
            } else if (code.charAt(i) == 'R') {
                lower = currentValue;
            }

        }
        return lower;
    }

    public int getSeatId(int row, int column) {
        return (row * 8) + column;
    }

}
