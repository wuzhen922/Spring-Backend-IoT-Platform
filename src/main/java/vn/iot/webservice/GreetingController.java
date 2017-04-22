package vn.iot.webservice;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.iot.entity.Greeting;

@RestController
public class GreetingController {

	@RequestMapping("/greet")
	public Greeting greeting(@RequestParam(value="name", defaultValue="test_service") String name) {
		return new Greeting(1, "Service call in " + new SimpleDateFormat("DD-MMM-YYYY HH:MI:SS A").format(Calendar.getInstance().getTime()));
	}
}
