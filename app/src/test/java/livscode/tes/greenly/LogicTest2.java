package livscode.tes.greenly;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import livscode.tes.greenly.core.Logic;

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
        assertEquals(567,  logic.getSeatId(
                logic.eliminateRow(tesInput2),
                logic.eliminateColumn(tesInput2)
        ));
    }


}
