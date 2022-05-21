package co.edu.uco.businesslogic.bussiness;

import java.util.List;

import co.edu.uco.grades.dto.IdTypeDTO;

public interface IdTypeBussiness {
	
	void create (IdTypeDTO dto);
	
	void update (IdTypeDTO dto);
	
	void delate (int id);
	
	List<IdTypeDTO> find(IdTypeDTO dto);
	
	

}
