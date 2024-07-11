package kapil.max;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kapil.max.master.LocationDAO;

import kapil.max.master.StateEntity;
import kapil.max.reg.RegBean;

@Controller
public class LoginController {
  @Autowired
	User user;
  @Autowired
  RegBean regBean;
  @Autowired
  LocationDAO locationDAO;
	@RequestMapping(value = "open", method = RequestMethod.GET)
  //@GetMapping("/")
	public ModelAndView login()
	{
		return new ModelAndView("login","l",user);
	}
	
	@RequestMapping(value = "ok", method = RequestMethod.POST)
	
	public ModelAndView getLoginDetail(@ModelAttribute("l")User user,HttpServletRequest req)
	{
		if(!user.getUid().equalsIgnoreCase(user.getPass()))
		{
			req.getSession().setAttribute("uid", user.getUid());
			return new ModelAndView("reg","tt",regBean);
		}
		else
		{
			return new ModelAndView("login");
		}
		}
	
	@ModelAttribute("modiList")
	public List<StateEntity>  getStateList()
	{
		
		List<StateEntity> list = locationDAO.getSateList();
		return list;
	}
	
	
}
