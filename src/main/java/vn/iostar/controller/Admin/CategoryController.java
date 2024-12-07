package vn.iostar.controller.Admin;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;
import vn.iostar.entity.Category;
import vn.iostar.model.CategoryModel;
import vn.iostar.repository.CategoryRepository;
import vn.iostar.services.CategoryService;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@GetMapping("")
	public String all(Model model) {
		List<Category> list = categoryService.findAll();
		model.addAttribute("list", list);
		return "admin/categories/list";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		CategoryModel categoryModel = new CategoryModel();
		categoryModel.setIsEdit(false);
		model.addAttribute("category", categoryModel);
		return "admin/categories/add";
	}
	
	@PostMapping("/save")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("category") CategoryModel categoryModel, BindingResult result) {
		if(result.hasErrors()) {
			return new ModelAndView("admin/categories/add");
		}
		Category entity = new Category();
		//copy từ Model sang Entity
		BeanUtils.copyProperties(categoryModel, entity);
		//gọi hàm save trong service
		categoryService.save(entity);
		//đưa thông báo về cho biến message
		String mess = "";
		if(categoryModel.getIsEdit() == true) {
			mess = "Category is Edited!!!";
		} else {
			mess = "Category is Saved!!!";
		}
		model.addAttribute("mess", mess);
		//redirect vể URL controller
		return new ModelAndView("forward:/admin/categories", model);
	}
}
