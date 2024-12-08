package vn.iostar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.iostar.entity.Category;
import vn.iostar.services.CategoryService;

@Controller
@RequestMapping({"/", "", "/home"})
public class HomeController {
	
	@Autowired
	CategoryService categoryService;
	
	// Hiển thị trang chủ, bao gồm cả danh sách loại sân
    @GetMapping
    public String home(Model model, @RequestParam(value = "keyword", required = false) String keyword) {
    	// Lấy danh sách các loại sân từ cơ sở dữ liệu
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        
        // Lọc các loại sân nếu có từ khóa tìm kiếm
        List<Category> searchCategory = new ArrayList<>();
        
        if (keyword != null && !keyword.isEmpty()) {
        	searchCategory = categoryService.findByCategoryNameContaining(keyword);
        }
        
        model.addAttribute("categories", categories);
        model.addAttribute("keyword", keyword);
        model.addAttribute("searchCategory", searchCategory);
        return "home"; // Trả về view home.jsp hoặc home.html tùy vào cấu hình của bạn
    }
	
}
