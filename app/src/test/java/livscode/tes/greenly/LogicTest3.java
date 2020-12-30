package livscode.tes.greenly;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import livscode.tes.greenly.core.Logic;

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
        assertEquals(119,  logic.getSeatId(
                logic.eliminateRow(tesInput3),
                logic.eliminateColumn(tesInput3)
        ));
    }


}
