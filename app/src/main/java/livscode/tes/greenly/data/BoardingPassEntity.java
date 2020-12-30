package livscode.tes.greenly.data;

public class BoardingPassEntity {

    private String boardingPassCode;
    private int seatId,row,column;


    public BoardingPassEntity(String boardingPassCode, int seatId, int row, int column) {
        this.boardingPassCode = boardingPassCode;
        this.seatId = seatId;
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
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

    @Override
    public String toString() {
        return "BoardingPassEntity{" +
                "seatId=" + seatId +
                ", row=" + row +
                ", column=" + column +
                '}';
    }
}
