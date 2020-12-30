package livscode.tes.greenly;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import livscode.tes.greenly.core.Logic;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Last Seat ID")
public class LogicLastSeat {
    private Logic logic = new Logic();

    private String tesInput4 ="BBBBBBBRRR";

    @Test
    public void eliminasiBarisInput4() {
        assertEquals(127, logic.eliminateRow(tesInput4));
    }

    @Test
    public void eliminasiKolomInput4() {
        assertEquals(8, logic.eliminateColumn(tesInput4));
    }

    @Test
    public void seatId() {
        assertEquals(1024,  logic.getSeatId(
                logic.eliminateRow(tesInput4),
                logic.eliminateColumn(tesInput4)
        ));
    }

}
