package livscode.tes.greenly;

import org.junit.Test;

import livscode.tes.greenly.core.Logic;

import static junit.framework.TestCase.assertEquals;

public class LogicTest5 {
    private Logic logic = new Logic();

    private String tesInput4 ="FFFFFFFLLL";

    @Test
    public void eliminasiBarisInput4() {

        assertEquals(0, logic.eliminateRow(tesInput4));
    }

    @Test
    public void eliminasiKolomInput4() {

        assertEquals(1, logic.eliminateColumn(tesInput4));
    }

    @Test
    public void seatId() {
        assertEquals(1,  logic.getSeatId(
                logic.eliminateRow(tesInput4),
                logic.eliminateColumn(tesInput4)
        ));
    }

}
