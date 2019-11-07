package com.mastahcode.LearnSpringWeb.Controller;

import com.mastahcode.LearnSpringWeb.Model.Mahasiswa;
import com.mastahcode.LearnSpringWeb.Service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MahasiswaController {
    @Autowired
    private MahasiswaService serv;

    @RequestMapping("/mahasiswa")
    public String viewMhs(Model model) {
        List<Mahasiswa> listMhs = serv.listAll();
        model.addAttribute("listMhs", listMhs);

        return "mahasiswa";
    }

    @RequestMapping("/new")
    public String newMhs(Model model) {
        Mahasiswa mhs = new Mahasiswa();
        model.addAttribute("mhs", mhs);

        return "addMahasiswa";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String addMhs(@ModelAttribute("mhs") Mahasiswa mhs) {
        serv.save(mhs);

        return "redirect:/mahasiswa";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView editMhs(@PathVariable(name = "id") Integer id) {
        ModelAndView mav = new ModelAndView("editMahasiswa");
        Mahasiswa mhs = serv.get(id);
        mav.addObject("mhs", mhs);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteMhs(@PathVariable(name = "id") Integer id) {
        serv.delete(id);

        return "redirect:/mahasiswa";
    }

}
