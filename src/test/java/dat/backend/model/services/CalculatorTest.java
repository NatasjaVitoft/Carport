package dat.backend.model.services;

import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private static ConnectionPool connectionPool;


    // stabler en test connection på
    @BeforeEach
    void setUp() throws SQLException {
        connectionPool = new ConnectionPool();
        connectionPool.getConnection();

    }

    // OBS ALLE TEST ER KØRT MED MÅL 600X600 UDEN SKUR!


    // udregning af stern til front og bag parti
    @Test
    void calcUnderSternFrontAndBack() throws DatabaseException {

        int stern = 0;

        stern = Calculator.calcUnderSternFrontAndBack(0, 600, 0, connectionPool).getQuantity();

        // sætter forventede antal stern vi skal bruge ud fra vores bredde
        int expectedStern = 3;

        //sammenligner resultatet af forventet stern og faktisk stern fra udregningen
        assertEquals(expectedStern, stern);
    }

    @Test
        // udregning af antal stolper vi skal bruge
    void calcPost() throws DatabaseException {

        int post = Calculator.calcPost(0, 600, 780, connectionPool).getQuantity();

        // sætter forventede antal post vi skal bruge ud fra vores bredde
        int expectedpost = 4;

        //sammenligner resultatet af forventet post og faktisk post fra udregningen
        assertEquals(expectedpost, post);

    }

    // udregning af rem til carport uden skur
    @Test
    void calcStrap() throws DatabaseException {

        int strap = Calculator.calcStrap(0, 600, 780, 0, 0, connectionPool).getQuantity();

        // sætter forventede antal rem vi skal bruge ud fra vores længde
        int expectedStrap = 2;

        //sammenligner resultatet af forventet rem og faktisk rem fra udregningen
        assertEquals(expectedStrap, strap);
    }


    // udregning af spær til carporten
    @Test
    void calcRafter() throws DatabaseException, SQLException {

        int rafter = Calculator.calcRafter(connectionPool, 0, 600, 780).getQuantity();

        // sætter forventede antal stern vi skal bruge ud fra vores bredde
        int expectedRafter = 15;

        //sammenligner resultatet af forventet stern og faktisk stern fra udregningen
        assertEquals(expectedRafter, rafter);

    }

    /** Calc til stern brædderne giver ikke helt mening. Det er som om den bliver halveret. Det skal vi lige kigge på */

    @Test
    void calcUndersternFrontAndBack () throws DatabaseException {
        int stern = Calculator.calcUnderSternFrontAndBack(0, 600, 780, connectionPool).getQuantity();
        int expectedStern = 4;
        assertEquals(expectedStern, stern);
    }

    @Test
    void calcUnderSternSides () throws DatabaseException {
        int stern = Calculator.calcUnderSternSides(0, 600, 780, connectionPool).getQuantity();
        int expectedStern = 4;
        assertEquals(expectedStern, stern);
    }

    @Test
    void calcUndersternSmall () throws DatabaseException {
        int stern = Calculator.calcUnderSternSmall(0, 600, 780, connectionPool).getQuantity();
        int expectedStern = 2;
        assertEquals(expectedStern, stern);
    }
}


