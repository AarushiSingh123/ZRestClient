package kapil.max.master;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LocationDAO {
   @Autowired
	StateInterface stateInterface;
   @Autowired
   DistInterface distInterface;
	public List<StateEntity> getSateList()
	{
		return (List<StateEntity>)stateInterface.findAll();
	}
	
	public List<DistrictEntity> getDist(String stCode)
	{
		return distInterface.getDistrictEntityListByStCode(stCode);
	}
	
	
}
