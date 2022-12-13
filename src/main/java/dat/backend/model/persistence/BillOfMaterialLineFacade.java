package dat.backend.model.persistence;

import dat.backend.model.entities.BillOfMaterialLine;
import dat.backend.model.entities.Carport;
import dat.backend.model.exceptions.DatabaseException;

public class BillOfMaterialLineFacade {
    public static BillOfMaterialLine createBOML(int material_id, String name, String unit, int length, int price, String description, int carport_id, int quantity, ConnectionPool connectionPool) throws DatabaseException
    {
        return BillOfMaterialLineMapper.createBOML( material_id,  name,  unit,  length,  price,  description,  carport_id,  quantity,  connectionPool);
    }
}
