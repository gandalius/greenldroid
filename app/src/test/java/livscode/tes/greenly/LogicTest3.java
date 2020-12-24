package livscode.tes.greenly;

import org.junit.Test;

import livscode.tes.greenly.core.Logic;

import static junit.framework.TestCase.assertEquals;

public class LogicTest3 {
    private Logic logic = new Logic();

    private String tesInput3 ="FFFBBBFRRR";



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
    public void seatId() {
        assertEquals(357, logic.getSeatId(44,5));
    }


}
