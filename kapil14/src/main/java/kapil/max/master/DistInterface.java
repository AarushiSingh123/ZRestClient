package kapil.max.master;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DistInterface extends CrudRepository<DistrictEntity, String>{

	List<DistrictEntity> getDistrictEntityListByStCode(String stCode);
	
	DistrictEntity  getDistrictEntityDistNameByDistCode(String distCode);
	
}
