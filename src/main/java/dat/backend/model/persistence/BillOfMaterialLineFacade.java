package dat.backend.model.persistence;

import dat.backend.model.entities.BillOfMaterialLine;
import dat.backend.model.exceptions.DatabaseException;

public class BillOfMaterialLineFacade {

    public static BillOfMaterialLine createBOML(int item_id, String name, String unit, int length, int price, String description, int quantity, int orders_id, ConnectionPool connectionPool) throws DatabaseException
    {
        return BillOfMaterialLineMapper.createBOML( item_id,  name,  unit,  length,  price,  description, quantity,orders_id, connectionPool);
    }
}
