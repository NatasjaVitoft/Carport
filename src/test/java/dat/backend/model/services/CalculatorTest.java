package dat.backend.model.services;

import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private static ConnectionPool connectionPool;

    @BeforeEach
    void setUp() throws SQLException {
        connectionPool = new ConnectionPool();
        connectionPool.getConnection();
    }

    /**
     * Jeg har sat længden og bredden til at være 600 x 780 da det er nemmere at teste ift. den oprindelse stykliste.
     * OBS strap test metoden er udregnet med andre mål, for at teste om skurdelen også virker.
     * OBS metoden til at teste remmene til skur har også andre mål selvfølgelig.
     */

    @Test

    void calcPost() throws DatabaseException {

        int post = Calculator.calcPost(0, 600, 780, connectionPool).getQuantity();
        int expectedPost = 6;
        assertEquals(expectedPost, post);

    }

    @Test
    void calcStrap() throws DatabaseException {

        int strap = Calculator.calcStrap(0, 600, 1200, 600, 200, connectionPool).getQuantity();
        int expectedStrap = 4;
        assertEquals(expectedStrap, strap);
    }


    @Test
    void calcRafter() throws DatabaseException, SQLException {

        int rafter = Calculator.calcRafter(connectionPool, 0, 600, 780).getQuantity();
        int expectedRafter = 15;
        assertEquals(expectedRafter, rafter);

    }

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

    @Test
    void calcStraps () throws DatabaseException {
        int strap = Calculator.calcStrap(0, 600, 1200, 600, 200, connectionPool).getQuantity();
        int expectedStrap = 4;
        assertEquals(expectedStrap, strap);
    }

    @Test
    void vandbrædtSiderne () throws DatabaseException {
        int vandbræt = Calculator.calcWeatherboard1(0, 600, 780, connectionPool).getQuantity();
        int expectedVandbræt = 4;
        assertEquals(expectedVandbræt, vandbræt);
    }

    @Test
    void vandbrætForende () throws DatabaseException {
        int vandbræt = Calculator.calcWeatherboard2(0, 600, 780, connectionPool).getQuantity();
        int expectedVandbræt = 2;
        assertEquals(expectedVandbræt, vandbræt);
    }

    @Test
    void measurementTape () throws DatabaseException {
        int measurementTape = Calculator.calcMeasurementTape(0, 600, 780, 400, 400, connectionPool).getQuantity();
        int expectedMeasurementTape = 1;
        assertEquals(expectedMeasurementTape, measurementTape);
    }

    @Test
    void strapForShed () throws DatabaseException {
        int strapForShed = CalculatorShed.calcStrapForShed(0, 600, 400, connectionPool).getQuantity();
        int expectedStrapForShed = 2;
        assertEquals(expectedStrapForShed, strapForShed);
    }
}


