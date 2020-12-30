package livscode.tes.greenly.core;

import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Logic {

    private ArrayList<String> listBoardingPassTxt;

    public Logic() {

    }


    public ArrayList<String> getListBoardingPassTxt() {
        return listBoardingPassTxt;
    }

    public void setListBoardingPassTxt(ArrayList<String> listBoardingPassTxt) {
        this.listBoardingPassTxt = listBoardingPassTxt;
    }

    public int eliminateRow(String singleInput) {
        String code = singleInput.substring(0, 7);
        int lower = 0;
        int upper = 128;
        int currentValue;
        for (int i = 0; i < code.length(); i++) {
            currentValue = (int) Math.round((double) (lower + upper) / 2);
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
        int upper = 9;
        int currentValue;
        for (int i = 0; i < code.length(); i++) {
            currentValue = (int) Math.floor((double) (lower + upper) / 2);
            if (code.charAt(i) == 'L') {
                upper = currentValue;
            } else if (code.charAt(i) == 'R') {
                lower = currentValue;
            }
        }

        //return lower == 0 ? 1 : lower;
        return lower;
    }

    public int getSeatId(int row, int column) {
        return (row * 8) + column;
    }

}
