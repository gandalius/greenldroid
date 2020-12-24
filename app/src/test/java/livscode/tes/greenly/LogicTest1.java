package livscode.tes.greenly;

import android.util.Log;

import org.junit.Assert;
import org.junit.Test;

import livscode.tes.greenly.core.Logic;

import static junit.framework.TestCase.assertEquals;

public class LogicTest1 {
    private Logic logic = new Logic();
    private String tesInput1 ="FBFBBFFRLR";


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
