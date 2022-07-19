package com.springbootjpah2.project.springbootjpah2.controller;

import com.springbootjpah2.project.springbootjpah2.dao.AlienRepo;
import com.springbootjpah2.project.springbootjpah2.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

//@Controller //Then mention each returning responsebody (json) worked fun
@RestController
public class AlienController {

    @Autowired
    AlienRepo repo;

    @RequestMapping("/")
    public String home() {
        return "home.jsp";
    }

    @PostMapping(path = "/addAlien", consumes = {"application/json"})
    public Alien addAlien(@RequestBody Alien alien) {
        System.out.println(alien + "Alien");
        repo.save(alien);
        //return "home.jsp";
        return alien;
    }

    //@RequestMapping("/getAlien") // Default 'Get', but better to mention.
    @GetMapping("/getAlien")
    public ModelAndView getAlien(@RequestParam int aId) {
        ModelAndView mv = new ModelAndView("showAlien.jsp");
        Optional<Alien> alien = repo.findById(aId);
        if (alien.isEmpty()) {
            alien = Optional.of(new Alien());
        }
        System.out.println(repo.findByTech("Java"));
        System.out.println(repo.findByTechSorted("Java"));
        mv.addObject(alien.get());
        return mv;
    }

    @GetMapping(path="/aliens", produces = {"application/xml","application/json"})
    //@ResponseBody //No need because @RestController
    public List<Alien> getAliens() {
        return repo.findAll();
    }

    @RequestMapping("/alien/{aid}")
    @ResponseBody
    public Optional<Alien> getAlienById(@PathVariable("aid") int aId) {
        return repo.findById(aId);
    }

    @PutMapping(path = "/addAlien", consumes = {"application/json"})
    public Alien updateOrSaveAlien(@RequestBody Alien alien) {
        repo.save(alien);
        return alien;
    }

    @DeleteMapping("/alien/{aid}")
    public Alien deleteAlien(@PathVariable int aid){
        Optional<Alien> a = repo.findById(aid);
        repo.delete(a.get());
        return a.get();
    }
}
