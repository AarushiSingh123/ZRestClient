package kapil.max.reg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kapil.max.master.DistInterface;
import kapil.max.master.DistrictEntity;

//@Controller
@RestController
public class DistController {
	@Autowired
	DistInterface distInterface;
	@RequestMapping(value = "distList", method = RequestMethod.GET)
	
	public @ResponseBody List<DistrictEntity>  getDist(@RequestParam("stCode") String stCode) throws JsonProcessingException
	{
		System.out.println("kkk");
		return distInterface.getDistrictEntityListByStCode(stCode); // must be return json
		
      }
	
	
	
	
	/*
	 * public @ResponseBody String getDist(@ModelAttribute("stCode") String stCode)
	 * throws JsonProcessingException { List<DistrictEntity> list =
	 * distInterface.getDistrictEntityListByStCode(stCode); ObjectMapper m = new
	 * ObjectMapper(); String jstring = m.writeValueAsString(list); return jstring;
	 * //json }
	 */
	
}
