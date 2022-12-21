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
        // denne udregning er ikke rigtig
    void calcPost() throws DatabaseException {

        int post = 0;

        post = Calculator.calcPost(0, 0, 600, connectionPool).getQuantity();

        // sætter forventede antal post vi skal bruge ud fra vores bredde
        int expectedpost = 6;

        //sammenligner resultatet af forventet post og faktisk post fra udregningen
        assertEquals(expectedpost, post);

    }

    // udregning af rem til carport uden skur
    @Test
    void calcStrap() throws DatabaseException {

        int strap = 0;

        strap = Calculator.calcStrap(0, 0, 600, 0, 0, connectionPool).getQuantity();

        // sætter forventede antal rem vi skal bruge ud fra vores længde
        int expectedStrap = 2;

        //sammenligner resultatet af forventet rem og faktisk rem fra udregningen
        assertEquals(expectedStrap, strap);

    }

    // udregning af spær til carporten
    @Test
    void calcRafter() throws DatabaseException, SQLException {

        int rafter = 0;

        rafter = Calculator.calcRafter(connectionPool, 0, 0, 600).getQuantity();

        // sætter forventede antal stern vi skal bruge ud fra vores bredde
        int expectedRafter = 11;

        //sammenligner resultatet af forventet stern og faktisk stern fra udregningen
        assertEquals(expectedRafter, rafter);

    }

}
