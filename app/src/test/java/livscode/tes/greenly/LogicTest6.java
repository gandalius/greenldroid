package livscode.tes.greenly;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import livscode.tes.greenly.core.Logic;


public class LogicTest6 {
    private Logic logic = new Logic();

    private String tesInput4 ="BBFFBBFLLL";//BBFFBBFLLL BBFFBBFLLR

    @Test
    public void eliminasiBarisInput() {
        System.out.println(logic.eliminateRow(tesInput4));
        assertEquals(102, logic.eliminateRow(tesInput4));
    }

    @Test
    public void eliminasiKolomInput() {
        System.out.println(logic.eliminateColumn(tesInput4));
        assertEquals(1, logic.eliminateColumn(tesInput4));
    }

    @Test
    public void seatId() {
        System.out.println(logic.getSeatId(
                logic.eliminateRow(tesInput4),
                logic.eliminateColumn(tesInput4)));

        assertEquals(817,  logic.getSeatId(
                logic.eliminateRow(tesInput4),
                logic.eliminateColumn(tesInput4)
        ));
    }

}
