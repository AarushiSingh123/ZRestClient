package kapil.max.reg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RegistDao {
	@Autowired
	RegistInterface registInterface;
	
	public int saveData(RegistDTOEntity registDTOEntity)
	{
		RegistDTOEntity i = registInterface.save(registDTOEntity);
		registDTOEntity=null;
		return i.getRid();
		
	}
	
	
	public List<RegistDTOEntity> viewDetail()
	{
		try {
			List<RegistDTOEntity> list=(List<RegistDTOEntity>)registInterface.findAll();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
