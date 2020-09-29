package com.hnisi.roger.refugescene.web.rest;

import com.hnisi.roger.refugescene.domain.RefugeScene;
import com.hnisi.roger.refugescene.service.RefugeSceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 避难场所 Resource
 *
 * @author Roger
 * @since 2020/9/30
 */
@RestController
@RequestMapping("/api/sceneResource")
public class RefugeSceneResource {

    @Autowired
    private RefugeSceneService refugeSceneService;

    @RequestMapping(value = "/getVildSceneResource", method = RequestMethod.POST)
    public List<RefugeScene> getVildSceneResource(){
        return  refugeSceneService.getValidRefugeScene();
    }
}
