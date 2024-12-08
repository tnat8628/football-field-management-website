package vn.iostar.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdHomeController {
	@GetMapping("/admin")
	public String adHome() {
		return "/admin/home";
	}
}
