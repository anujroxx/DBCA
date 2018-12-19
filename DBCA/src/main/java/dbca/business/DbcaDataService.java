package dbca.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dbca.domain.DbcaData;
import dbca.repositories.DbcaDataRepository;

@Service
public class DbcaDataService{

	@Autowired
	DbcaDataRepository dbcaRepo;
	
	public List<DbcaData> list(){
		return dbcaRepo.findAll();
	}
}
