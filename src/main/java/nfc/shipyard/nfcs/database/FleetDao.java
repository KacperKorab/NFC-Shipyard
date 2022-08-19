package nfc.shipyard.nfcs.database;

import nfc.shipyard.nfcs.Classes.Fleet;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class FleetDao {
    @PersistenceContext
    EntityManager entityManager;

    public void saveFleetToDB(Fleet fleet) {
        entityManager.persist(fleet);
    }
}
