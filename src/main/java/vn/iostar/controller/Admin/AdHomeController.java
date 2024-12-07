package vn.iostar.controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdHomeController {
	@GetMapping("/admin")
	public String adHome() {
		return "/admin/home";
	}
}
