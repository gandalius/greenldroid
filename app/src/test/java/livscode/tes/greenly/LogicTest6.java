package livscode.tes.greenly;

import org.junit.Test;

import livscode.tes.greenly.core.Logic;

import static junit.framework.TestCase.assertEquals;

public class LogicTest6 {
    private Logic logic = new Logic();

    private String tesInput4 ="BBFFBBFRRL";//BBFFBBFRRL

    @Test
    public void eliminasiBarisInput() {

        assertEquals(102, logic.eliminateRow(tesInput4));
    }

    @Test
    public void eliminasiKolomInput() {

        assertEquals(1, logic.eliminateColumn(tesInput4));
    }

    @Test
    public void seatId() {
        assertEquals(817,  logic.getSeatId(
                logic.eliminateRow(tesInput4),
                logic.eliminateColumn(tesInput4)
        ));
    }

}
