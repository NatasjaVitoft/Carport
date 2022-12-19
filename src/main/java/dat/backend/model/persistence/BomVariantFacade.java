package dat.backend.model.persistence;

import dat.backend.model.entities.BillOfMaterialLine;
import dat.backend.model.exceptions.DatabaseException;

public class BomVariantFacade {

    public static BillOfMaterialLine createBOMLVariant(String name, String unit, int price, String description, int quantity, int orders_id, int itemvariant_id, ConnectionPool connectionPool) throws DatabaseException {
        return BomVariantMapper.createBOMLVariant(name, unit, price, description, quantity, orders_id, itemvariant_id, connectionPool);
    }
}
