package dat.backend.model.persistence;

import dat.backend.model.entities.ItemVariant;
import dat.backend.model.exceptions.DatabaseException;

public class ItemVariantFacade {

    public static ItemVariant getItemByID(int ID, ConnectionPool connectionPool) throws DatabaseException {
        return ItemVariantMapper.getItemVariantByID(ID, connectionPool);
    }
}
