package dat.backend.model.services;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.BillOfMaterialLine;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    int post = 0;
    int stern = 0;

    private ConnectionPool connectionPool;

    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    // udregning af stern til front og bag parti
    @Test
    void calcUnderSternFrontAndBack() throws DatabaseException {


        stern = Calculator.calcUnderSternFrontAndBack(0,600,0, connectionPool).getQuantity();


        // sætter forventede antal stern vi skal bruge ud fra vores bredde
        int expectedStern = 2;

        //sammenligner resultatet af forventet stern og faktisk stern fra udregningen
        assertEquals(stern, expectedStern);

    }


}
