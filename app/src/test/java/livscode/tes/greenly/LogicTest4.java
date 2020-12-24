package livscode.tes.greenly;

import org.junit.Test;

import livscode.tes.greenly.core.Logic;

import static junit.framework.TestCase.assertEquals;

public class LogicTest4 {
    private Logic logic = new Logic();

    private String tesInput4 ="BBFFBBFRLL";



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
        assertEquals(820, logic.getSeatId(102,4));
    }


}
