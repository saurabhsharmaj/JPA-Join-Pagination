package com.bezkoder.spring.data.jpa.pagingsorting.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bezkoder.spring.data.jpa.pagingsorting.model.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
  Page<Tutorial> findByPublished(boolean published, Pageable pageable);

  //Page<Tutorial> findByTitleContaining(String title, Pageable pageable);
  
  @Query(value="SELECT t.* FROM testdb.tutorials t left outer join testdb.books b on t.id = b.id", 
      countQuery="SELECT count(*) FROM testdb.tutorials t left outer join testdb.books b on t.id = b.id \n#pageable\n",
      nativeQuery=true)
  Page<Tutorial> findByTitleContaining(String title, Pageable pageable);
  
  List<Tutorial> findByTitleContaining(String title, Sort sort);
}
