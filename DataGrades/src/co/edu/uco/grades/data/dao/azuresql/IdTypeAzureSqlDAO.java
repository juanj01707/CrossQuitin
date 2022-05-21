package co.edu.uco.grades.data.dao.azuresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import co.edu.uco.grades.crosscutting.exception.GradesException;
import co.edu.uco.grades.data.dao.IdTypeDAO;
import co.edu.uco.grades.data.dao.connection.ConnectionSQL;
import co.edu.uco.grades.dto.IdTypeDTO;

public class IdTypeAzureSqlDAO extends ConnectionSQL implements IdTypeDAO {

	private IdTypeAzureSqlDAO(Connection connection) {
		super(connection);
	}

	public static IdTypeDAO build(Connection connection) {
		return new IdTypeAzureSqlDAO(connection);
	}

	@Override
	public void create(IdTypeDTO idType) {
		String sql = "INSERT INTO IdType(name) VALUES (?)";

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, idType.getName());

			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException("There was a problem trying to create the new IdType on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException("An unexpected problem has ocurred trying to create the new IdType on Azure SQL Server", exception);
		}
	}
	
	

	@Override
	public void update(IdTypeDTO idType) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<IdTypeDTO> find(IdTypeDTO idType) {
		
		boolean setWhere = true;
		List<Object> parameters =new ArrayList<>();
		List<IdTypeDTO> results = new Arraylist<>();
		
		StringBuilder sb = new StringBuilder() {
			sb.append("SELECT	id, name").append(SPACE);
			sb.append("FROMT	idType").append(SPACE);
			
			if(!UtilObject.getUtilObject().isNull(idType)) {
				if(UtilNumeric.getUtilNumeric().isGreterThan(idType.getId)),{
					
					sb.append("WHERE id =").append(idType.getId());
					setWhere = false;                
					
				}
				
				if(!UtilText.isEmpty(idType.getName())) {
					sb.append(setWhere ? "WHERE": "AND");
					sb.append("name = ?");
					parameters.add(UtilText.trim(idType.getName()));
					
				}
			}
			
			sb.append("ORDER BY name ASC");
			
			try (PreparedStatement preparedStatement = getConnection().prepareStatement(sb.getName)) {
				
				for(int index = 0 ; index < parameters.size(); index++) {
				preparedStatement.setobject(index + 1, parameters.get(index));	
				}
				
				result = executeQuery(preparedStatement);
				
				try(ResultSet resulSet = preparedStatement.executeQuery()){
				}{
				} catch (SQLException exception) {
					throw GradesException.buildTechnicalDataException("There was a problem trying to retrive the new IdType on Azure SQL Server", exception);
				} catch (Exception exception) {
					throw GradesException.buildTechnicalDataException("An unexpected problem has ocurred trying to create the new IdType on Azure SQL Server", exception);
				}	
				}

			} catch (SQLException exception) {
				throw GradesException.buildTechnicalDataException("There was a problem trying to create the new IdType on Azure SQL Server", exception);
			} catch (Exception exception) {
				throw GradesException.buildTechnicalDataException("An unexpected problem has ocurred trying to create the new IdType on Azure SQL Server", exception);
			}
			
			return results;
		}
		
		private List<IdTypeDTO> executeQuery(preparedStatement prepareStatement){
			
			List<IdTypeDto>
			
			try(ResultSet resulSet = preparedStatement.executeQuery()){
			} catch (SQLException exception) {
				throw GradesException.buildTechnicalDataException("There was a problem trying to execute the new IdType on Azure SQL Server", exception);
			} catch (Exception exception) {
				throw GradesException.buildTechnicalDataException("An unexpected problem has ocurred trying to create the new IdType on Azure SQL Server", exception);
			}	
		}
		
		
		 
		private List<IdTypeDTO> assembleResults(resultSet resultSet){
		 List<IdTypeDTO> results = new ArrayList<>();
		 
		 try {
			 while(resultSet.next()) {
				 results.add(assemble);
			 }
			 catch(Grades)
		 } catch (SQLException exception) {
				throw GradesException.buildTechnicalDataException("There was a problem trying to recover the new IdType on Azure SQL Server", exception);
			} catch (Exception exception) {
				throw GradesException.buildTechnicalDataException("An unexpected problem has ocurred trying to create the new IdType on Azure SQL Server", exception);
			}
		 return results;
		 }
		 
		private IdTypeDTO assembleDTO(ResultSet resultSet) {
			IdTypeDTO dto = new IdTypeDTO();
			 try {
				 dto.setId(resultSet.getInt("id"));
				 dto.setName(resultSet.getString("name"));
				 
				
			 } catch (SQLException exception) {
					throw GradesException.buildTechnicalDataException("There was a problem trying to assemble the IdType on Azure SQL Server", exception);
				} catch (Exception exception) {
					throw GradesException.buildTechnicalDataException("An unexpected problem has ocurred trying to assemble the IdType on Azure SQL Server", exception);
				}
			 return results;
			 }
			return dto;
		}
	}
}
