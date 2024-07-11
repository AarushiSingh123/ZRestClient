package kapil.max.master;

import org.springframework.data.repository.CrudRepository;

public interface StateInterface extends CrudRepository<StateEntity, Integer>{

	StateEntity getStateEntityStateNameByStCode(int stCode);
	
}
