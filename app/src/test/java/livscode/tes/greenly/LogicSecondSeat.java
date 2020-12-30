package livscode.tes.greenly;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import livscode.tes.greenly.core.Logic;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("First Seat ID")
public class LogicSecondSeat {
    private Logic logic = new Logic();

    private String tesInput4 ="FFFFFFFLLR";

    @Test
    public void eliminasiBarisInput4() {

        assertEquals(0, logic.eliminateRow(tesInput4));
    }

    @Test
    public void eliminasiKolomInput4() {

        assertEquals(2, logic.eliminateColumn(tesInput4));
    }

    @Test
    public void seatId() {
        assertEquals(2,  logic.getSeatId(
                logic.eliminateRow(tesInput4),
                logic.eliminateColumn(tesInput4)
        ));
    }

}
