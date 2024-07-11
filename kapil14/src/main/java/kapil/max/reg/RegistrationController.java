package kapil.max.reg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lowagie.text.DocumentException;

import kapil.max.master.DistInterface;
import kapil.max.master.DistrictEntity;
import kapil.max.master.StateEntity;
import kapil.max.master.StateInterface;

@Controller
public class RegistrationController {
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
	@RequestMapping(value = "RegSave", method = RequestMethod.GET)
	public String getRegitDetail(@ModelAttribute("tt") RegBean regBean)
	{
		
		BeanUtils.copyProperties(regBean, registDTOEntity);
		if(registDao.saveData(registDTOEntity)>0)
		return "S";
		
		else
		return "E";
		
		
	}
	
	@RequestMapping(value = "view", method = RequestMethod.GET)
	public ModelAndView viewRegitDetail()
	{
		
		List<CommanBean> list = pDFGenerate.setDataWithLactionName();
		
		  
		//m.addAttribute("lst", l);
		//m.addAttribute(c);
		return new ModelAndView("view","lst",list);
		
		
		
		
	}
	@RequestMapping(value = "downloadPDF", method = RequestMethod.GET)
	
	public String download(HttpServletResponse response) throws DocumentException, IOException
	{
		
		userPDFExporter.export(response);
		return "S";
	}
	
	

}
