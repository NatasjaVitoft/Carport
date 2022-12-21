package dat.backend.model.services;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.BillOfMaterialLine;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.ItemMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private static ConnectionPool connectionPool;


    int post = 0;
    int stern = 0;


    @BeforeEach
    void setUp() throws SQLException {
        connectionPool = new ConnectionPool();
        connectionPool.getConnection();

    }



    // udregning af stern til front og bag parti
    @Test
    void calcUnderSternFrontAndBack() throws DatabaseException {


        stern = Calculator.calcUnderSternFrontAndBack(0,600,0, connectionPool).getQuantity();
        System.out.println(connectionPool);



        // sætter forventede antal stern vi skal bruge ud fra vores bredde
        int expectedStern = 3;

        //sammenligner resultatet af forventet stern og faktisk stern fra udregningen
        assertEquals(expectedStern,stern);

    }


}
