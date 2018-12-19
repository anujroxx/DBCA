package dbca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dbca.domain.DbcaData;

@Repository
public interface DbcaDataRepository extends JpaRepository<DbcaData, Integer>{
	
	
}
