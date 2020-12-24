package livscode.tes.greenly;

import org.junit.Test;

import livscode.tes.greenly.core.Logic;

import static junit.framework.TestCase.assertEquals;

public class LogicTest2 {
    private Logic logic = new Logic();

    private String tesInput2 ="BFFFBBFRRR";



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
    public void seatId() {
        assertEquals(357, logic.getSeatId(44,5));
    }


}
