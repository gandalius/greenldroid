package livscode.tes.greenly.data;

public class BoardingPassEntity {

    private String boardingPassCode;
    private int seatId;

    public BoardingPassEntity(String boardingPassCode, int seatId) {
        this.boardingPassCode = boardingPassCode;
        this.seatId = seatId;
    }

    public String getBoardingPassCode() {
        return boardingPassCode;
    }

    public void setBoardingPassCode(String boardingPassCode) {
        this.boardingPassCode = boardingPassCode;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }
}
