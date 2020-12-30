package livscode.tes.greenly;

import androidx.collection.ArraySet;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.CookieStore;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import livscode.tes.greenly.core.Logic;
import livscode.tes.greenly.data.BoardingPassEntity;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LogicSortMax {
    private Logic logic = new Logic();
    public static Comparator<BoardingPassEntity> seatIdSortComparator = new Comparator<BoardingPassEntity>() {
        @Override
        public int compare(BoardingPassEntity s1, BoardingPassEntity s2) {
            /*For ascending order*//*
            //return s1.getSeatId()-s2.getSeatId();

            /*For descending order  */
            return s2.getSeatId()-s1.getSeatId();

        }
    };

    List<BoardingPassEntity> sortedList;
    ArrayList<BoardingPassEntity> listEntity;
    BoardingPassEntity entity;
    Logic logic1;

    @Test
    @Order(1)
    public void initInput() {
        ArrayList<String> boardingPassCode = new ArrayList<>();
        InputStream inputStream = this.getClass().getClassLoader()
                .getResourceAsStream("input_test.txt");
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = reader.readLine();
            while (line != null) {
                boardingPassCode.add(line);
                line = reader.readLine();
            }
            logic.setListBoardingPassTxt(boardingPassCode);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

       assertNotNull(logic.getListBoardingPassTxt());
    }
    @Test
    @Order(2)
    public void initList(){

        listEntity =  new ArrayList<>();
        for (String input : logic.getListBoardingPassTxt()) {
            System.out.println(input);
            logic1 = new Logic();
            int row = logic1.eliminateRow(input);
            int column = logic1.eliminateColumn(input);
            int seatID = logic1.getSeatId(row,column);
            System.out.println("row : "+row+" kolom : "+column+" seatID:"+seatID);
            entity = new BoardingPassEntity(input, seatID, row, column);
            listEntity.add(entity);
        }
        for (BoardingPassEntity e :listEntity) {
            System.out.println( e.toString());
        }
        assertNotNull(listEntity);
    }

    @Test
    @Order(3)
    public void sorted(){
        sortedList = listEntity.stream()
                .sorted(seatIdSortComparator)
                .collect(Collectors.toList());
       /* for (BoardingPassEntity e :sortedList) {
            System.out.println( e.toString());
        }*/
        assertNotNull(sortedList);
    }




}
