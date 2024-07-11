package kapil.max.reg;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kapil.max.master.DistInterface;
import kapil.max.master.DistrictEntity;
import kapil.max.master.StateEntity;
import kapil.max.master.StateInterface;

@Service
public class PDFGenerate {
	@Autowired
	RegBean regBean;
	@Autowired
	RegistInterface registInterface;
	@Autowired
	RegistDTOEntity registDTOEntity;
	@Autowired
	RegistDao registDao;
	@Autowired
	StateInterface stateInterface;
	@Autowired
	DistInterface distInterface;
	@Autowired
	UserPDFExporter userPDFExporter;
	@Autowired
	PDFGenerate pDFGenerate;
	
	
	public List<CommanBean> setDataWithLactionName()
	{
		List<RegistDTOEntity> list = registDao.viewDetail();
		CommanBean c=null;
		List<CommanBean> l=new ArrayList<CommanBean>();
		  for(RegistDTOEntity p:list)
		  {
			c = new  CommanBean();
			c.setName(p.getName());
			c.setMob(p.getMob());
			StateEntity sb = stateInterface.getStateEntityStateNameByStCode(Integer.parseInt(p.getStCode()));
			DistrictEntity db = distInterface.getDistrictEntityDistNameByDistCode(p.getDistCode());
			c.setStName(sb.getStName());
			c.setDistName(db.getDistName());
			l.add(c);
		  }
		return l;
	}
	

}
