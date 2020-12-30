package livscode.tes.greenly;





import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import livscode.tes.greenly.core.Logic;



public class LogicTest1 {
    private Logic logic = new Logic();
    private String tesInput1 ="FBFBBFFRLR";
    //44 * 8 + 5 = 357.

    @Test
    public void eliminasiBarisInput1() {
        assertEquals(44, logic.eliminateRow(tesInput1));
    }

    @Test
    public void eliminasiKolomInput1() {
        assertEquals(5, logic.eliminateColumn(tesInput1));
    }

    @Test
    public void seatId() {
        assertEquals(357,
                logic.getSeatId(
                        logic.eliminateRow(tesInput1),
                        logic.eliminateColumn(tesInput1)
                )
        );

    }


}
