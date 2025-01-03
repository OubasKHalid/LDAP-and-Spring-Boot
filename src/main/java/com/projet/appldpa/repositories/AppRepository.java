package com.projet.appcnss.repositories;

import com.projet.appcnss.entities.App;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppRepository extends JpaRepository<App,Long> {
    Page<App> findByTitleContains(String kw, Pageable pageable); ;

}
