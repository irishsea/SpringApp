package com.irishsea.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GeoController{
    @GetMapping(value = "/albedo")
    public @ResponseBody
    String infoAlbedo() {
        return "Albedo, also known as the \"Kreideprinz\", is a playable Geo character in Genshin Impact.\n" +
                "A synthetic human made by the alchemist Rhinedottir, the mysterious Albedo is the Chief Alchemist" +
                " and Captain of the Investigation Team of the Knights of Favonius. Through a recommendation from the adventurer" +
                " Alice, with Sucrose as his assistant, he holds an infinite desire to learn about the world of Teyvat, carefully" +
                " studying every object around him.";
    }

    @GetMapping(value = "/zhongli")
    public @ResponseBody
    String infoZhongli() {
        return "He is a consultant of the Wangsheng Funeral Parlor. He is later revealed to be the current vessel of the Geo Archon," +
                " Morax, who has decided to experience the world from the perspective of a mortal.";
    }


}
