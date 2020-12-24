package livscode.tes.greenly;

import android.util.Log;

import org.junit.Assert;
import org.junit.Test;

import livscode.tes.greenly.core.Logic;

import static junit.framework.TestCase.assertEquals;

public class LogicTest1 {
    private Logic logic = new Logic();
    private String tesInput1 ="FBFBBFFRLR";
    private String tesInput2 ="BFFFBBFRRR";
    private String tesInput3 ="FFFBBBFRRR";
    private String tesInput4 ="BBFFBBFRLL";

    @Test
    public void eliminasiBarisInput1() {
        assertEquals(44, logic.eliminateRow(tesInput1));
    }

    @Test
    public void eliminasiKolomInput1() {
        assertEquals(5, logic.eliminateColumn(tesInput1));
    }

    @Test
    public void eliminasiBarisInput2() {
        /*BFFFBBFRRR: row 70, column 7, seat ID 567*/
        assertEquals(70, logic.eliminateRow(tesInput2));
    }

    @Test
    public void eliminasiKolomInput2() {
        /*BFFFBBFRRR: row 70, column 7, seat ID 567*/
        assertEquals(7, logic.eliminateColumn(tesInput2));
    }

    @Test
    public void eliminasiBarisInput3() {
        /*FFFBBBFRRR: row 14, column 7, seat ID 119.*/
        assertEquals(14, logic.eliminateRow(tesInput3));
    }

    @Test
    public void eliminasiKolomInput3() {
        /*FFFBBBFRRR: row 14, column 7, seat ID 119.*/
        assertEquals(7, logic.eliminateColumn(tesInput3));
    }

    @Test
    public void eliminasiBarisInput4() {
        /*BBFFBBFRLL: row 102, column 4, seat ID 820.*/
        assertEquals(102, logic.eliminateRow(tesInput4));
    }

    @Test
    public void eliminasiKolomInput4() {
        /*BBFFBBFRLL: row 102, column 4, seat ID 820.*/
        assertEquals(4, logic.eliminateColumn(tesInput4));
    }

    @Test
    public void seatId() {
        assertEquals(357, logic.getSeatId(44,5));
    }


}
