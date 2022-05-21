package co.edu.uco.businesslogic.bussiness.impl;

import java.util.List;

import co.edu.uco.businesslogic.bussiness.IdTypeBussiness;
import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.grades.data.factory.DAOFactory;
import co.edu.uco.grades.dto.IdTypeDTO;

public class IdTypeBussinessImpl implements IdTypeBussiness  {
	
	
	private DAOFactory daoFactory;
	
	public IdTypeBussinessImpl(DAOFactory daoFactory) {
		if (UtilObject.getUtilObject().isNull(daoFactory)) {
			twrow GradesException.buildTechnicalBusinessLogicException("It´s not possible create a IdTypeBusinessImpl when the DAO Factory is null "); 
		}
		this.daoFactory = daoFactory;
	}

	@Override
	public void create(IdTypeDTO dto) {
		daoFactory.getIdTypeDAO().create(dto);
		
	}

	@Override
	public void update(IdTypeDTO dto) {
		daoFactory.getIdTypeDAO().update(dto);
		
	}

	@Override
	public void delate(int id) {
		daoFactory.getIdTypeDAO().delete(id);
		
	}

	@Override
	public List<IdTypeDTO> find(IdTypeDTO deto) {
		return daoFactory.getIdTypeDAO().find(dto);
		
		
	}

}
