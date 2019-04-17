package com.java.controller;

import com.java.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: LiGX
 * @Date: 2019-04-17 下午 4:07
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private  static List<User> list=new ArrayList<>();
    static {
        User user1=new User(1,"admin111","admin111");
        User user2=new User(2,"admin222","admin222");
        User user3=new User(3,"admin333","admin333");
        list.add(user1);
        list.add(user2);
        list.add(user3);
    }
    @RequestMapping("/list")
    public String query(Model model){
        model.addAttribute("list",list);
        return "/user/list";
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id")Integer id){
        User user=null;
        for (User u:list) {
            if(u.getId().equals(id)){
                user= u;
                break;
            }
        }
        list.remove(user);

        return "redirect:/user/list";
    }
    @RequestMapping("/queryOne/{id}")
    public ModelAndView queryOne(@PathVariable(name = "id")Integer id){
        User user=null;
        for (User u : list) {
            if(u.getId().equals(id)){
                user=u;
                break;
            }
        }
        ModelAndView modelAndView=new ModelAndView("/user/update");
        modelAndView.addObject("user",user);
        return modelAndView;
    }
    @RequestMapping("/add")
    public String add(User user){
        Integer id;
        if(list.size()==0){
             id=1;
        }else {
             id = list.get(list.size() - 1).getId() + 1;
        }
        if(user.getId()==null){
            user.setId(id);
            list.add(user);
        }else {
            int index=-1;
            for (int i = 0; i <list.size() ; i++) {
                if (list.get(i).getId().equals(user.getId())){
                    index=i;
                    break;
                }
            }
           if(index!=-1){
              list.set(index,user);
           }
        }
        return "redirect:/user/list";
    }
    @RequestMapping("/toadd")
    public String toadd(){
        return "/user/update";
    }
}
