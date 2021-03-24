
package Dao;

import Model.Domain.Medicine;
import Utilities.GenericDao;

/**
 *
 * @author eddy
 */
public class MedicineDao extends GenericDao<Medicine> {
    
    public MedicineDao(Class<Medicine> type) {
        super(type);
    }
    
}
