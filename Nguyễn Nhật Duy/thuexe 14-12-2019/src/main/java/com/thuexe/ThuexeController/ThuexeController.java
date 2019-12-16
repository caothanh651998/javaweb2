package com.thuexe.ThuexeController;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thuexe.entity.ThuexeDto;
import com.thuexe.entity.ThuexeEntity;
import com.thuexe.security.ThuexeService;

@Controller
public class ThuexeController {

	@Autowired
	ThuexeService thuexeService;
	
	@RequestMapping(value = "/getAllDataThueXe")
	public List<ThuexeDto> getAllDataThueXe(){
		return thuexeService.getDS();
	}
	
	@RequestMapping("/timkiem")
	public List<ThuexeEntity> timkiem(@RequestParam("noidi") String noidi,@RequestParam("noiden") String noiden, @RequestParam("ngaydi") Date ngaydi){
		return thuexeService.search(noidi,noiden,ngaydi);
	}
	
	@RequestMapping("/del/{id}")
	public void delete(@PathVariable int id) {
		thuexeService.xoa(id);
	}
	
	@RequestMapping("/del")
	public boolean del(@RequestBody ThuexeEntity ngaydi) {
		thuexeService.delByDate(ngaydi.getNgaydi());
		return true;
	}
	
	@RequestMapping("/update/{id}")
	public ThuexeEntity update(@PathVariable int id,@RequestBody ThuexeEntity entity) {
		
		return thuexeService.update(entity);
		
	}
	
//	cau 2
	@RequestMapping("/thuexe")
	public String get() {
		
		return "thuexe";
	}
	
	@RequestMapping("/search")
	public String search(@RequestParam("noidi") String noidi,@RequestParam("noiden") String noiden, @RequestParam("ngaydi") Date ngaydi, Model model){
		
		if (StringUtils.isEmpty(noiden) & StringUtils.isEmpty(noiden) & StringUtils.isEmpty(ngaydi)) {
            return "redirect:/thuexe";
        }
		
		model.addAttribute("thuexe", thuexeService.search(noidi,noiden,ngaydi));
		return "thuexe";
	}
	
	@RequestMapping("/thuexe/{id}/del")
	public String xoa(@PathVariable int id,RedirectAttributes attributes) {
		thuexeService.xoa(id);
		attributes.addFlashAttribute("successMessage", "Deleted thue xe  thanh cong!");
		return "redirect:/thuexe";
	}
	
	@RequestMapping("/thuexe/{id}/edit")
	public String capnhat(@PathVariable int id, Model model ) {
		model.addAttribute("thuexe", thuexeService.edit(id));
		return "form";
	}
	
	@RequestMapping("/thuexe/save")
	public String save(@Valid ThuexeEntity thuexeEntity , BindingResult result, RedirectAttributes redirect) {
		
		thuexeService.save(thuexeEntity);
		redirect.addFlashAttribute("successMessage", "save thue xe thanh cong!");
		return "redirect:/thuexe";
	}
	
	@RequestMapping("/sort")
	public String sort(Model model) {
		model.addAttribute("thuexe", thuexeService.getSortGia());
		return "thuexe";
	}
	
	@RequestMapping("/sortGia")
	public String sortGia(Model model) {
		model.addAttribute("thuexe", thuexeService.getSortGiaT());
		return "thuexe";
	}
	
	@RequestMapping("/sortDate")
	public String sortDate(Model model) {
		model.addAttribute("thuexe", thuexeService.getSortDate());
		return "thuexe";
	}
	
	@RequestMapping("/sortDateT")
	public String sortDateT(Model model) {
		model.addAttribute("thuexe", thuexeService.getSortDateT());
		return "thuexe";
	}
	
}
