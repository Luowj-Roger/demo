package com.hnisi.roger.refugescene.repostiory;

import com.hnisi.roger.refugescene.domain.RefugeScene;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *
 * @author work
 * @since 2020/9/30
 */
public interface RefugeSceneRepository extends JpaRepository<RefugeScene, String> {
    public List<RefugeScene> findByZtOrderByDlwzzb(String zt);
}
