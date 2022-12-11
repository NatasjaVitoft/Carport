package dat.backend.model.persistence;

import dat.backend.model.entities.Orderline;
import dat.backend.model.exceptions.DatabaseException;

public class OrderlineFacade {

    //Husk at tilføje order id hertil i parameter hvis den tages med i mapper.

    public static Orderline create(int item_id, int various_id, int shed_id, int price, ConnectionPool connectionPool) throws DatabaseException {
        return OrderlineMapper.create(item_id, various_id, shed_id, price, connectionPool);
    }
}
