package hello;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import hello.Mapper.SalesMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/msb") // This means URL's start with /demo (after Application path)
@Slf4j
public class MainController {
	@Autowired // This means to get the bean called userRepository
	           // Which is auto-generated by Spring, we will use it to handle the data
	private UserRepository userRepository;
	@Autowired
	private SalesRecordRepository salesRecordRepository;
	RestTemplate restTemplate = new RestTemplate();
	private HttpHeaders httpHeaders;

	@PostMapping(path="/getSales")
	public @ResponseBody SalesRecord getSalesRecord(@RequestBody StaffB staffB)  {
		try{
            //ObjectMapper mapper = new ObjectMapper();
			//Object objects = httpEntity.getBody();
			//staffB = mapper.readValue(httpEntity.getBody(), StaffB.class);
			//System.out.println(normalView);
			//staffB = mapper.readValue(string, StaffB.class);
			log.info(staffB.toString());
            //staffB= mapper.readValue((JsonParser) httpEntity.getBody(),StaffB.class);
			//log.info(staffB.toString());
			SalesRecord salesRec = salesRecordRepository.getSalesRecord(staffB.getFName());
			return (salesRec);
		}catch(NullPointerException e){
			System.out.println(e.getStackTrace());
			return null;
		}
		//
	}

}
