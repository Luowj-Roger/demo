package com.hnisi.roger.refugescene.service;

import com.hnisi.roger.refugescene.domain.RefugeScene;
import com.hnisi.roger.refugescene.repostiory.RefugeSceneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 *  避难场所service
 *
 * @author Roger
 * @since 2020/9/30
 */

@Service
@Transactional
public class RefugeSceneService {

    @Autowired
    private RefugeSceneRepository refugeSceneRepository;

    /**
     * 获取有效的避难场所 1为有效 0为无效
     * @return
     */
    public List<RefugeScene> getValidRefugeScene(){
        return  refugeSceneRepository.findByZtOrderByDlwzzb("1");
    }
}
