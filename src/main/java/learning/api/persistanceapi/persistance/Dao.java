package learning.api.persistanceapi.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import learning.api.persistanceapi.model.Data;

@Repository
public interface Dao extends JpaRepository<Data, Integer>{


}
