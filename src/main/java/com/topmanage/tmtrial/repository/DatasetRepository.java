package com.topmanage.tmtrial.repository;

import com.topmanage.tmtrial.models.Dataset;
import java.util.Date;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DatasetRepository extends PagingAndSortingRepository<Dataset, String> {

    //3 MATCHCASE
    List<Dataset> findByTypeAndPatternAndDateOrderByPatternAsc(String type, String pattern, Date date);
    List<Dataset> findByTypeAndPatternAndDateOrderByPatternDesc(String type, String pattern, Date date);
    
    List<Dataset> findByTypeAndPatternAndDateOrderByTypeAsc(String type, String pattern, Date date);
    List<Dataset> findByTypeAndPatternAndDateOrderByTypeDesc(String type, String pattern, Date date);
    
    List<Dataset> findByTypeAndPatternAndDateOrderByDateAsc(String type, String pattern, Date date);
    List<Dataset> findByTypeAndPatternAndDateOrderByDateDesc(String type, String pattern, Date date);
    
    List<Dataset> findByTypeAndPatternAndDate(String type, String pattern, Date date);
    
    //2 MATCHCASE
    List<Dataset> findByTypeAndPatternOrderByPatternAsc(String type, String pattern);
    List<Dataset> findByTypeAndPatternOrderByPatternDesc(String type, String pattern);
    
    List<Dataset> findByTypeAndPatternOrderByTypeAsc(String type, String pattern);
    List<Dataset> findByTypeAndPatternOrderByTypeDesc(String type, String pattern);
    
    List<Dataset> findByTypeAndPatternOrderByDateAsc(String type, String pattern);
    List<Dataset> findByTypeAndPatternOrderByDateDesc(String type, String pattern);
    
    List<Dataset> findByTypeAndPattern(String type, String pattern);
    
    
    List<Dataset> findByTypeAndDateOrderByTypeAsc(String type, Date date);
    List<Dataset> findByTypeAndDateOrderByTypeDesc(String type, Date date);
    
    List<Dataset> findByTypeAndDateOrderByPatternAsc(String type, Date date);
    List<Dataset> findByTypeAndDateOrderByPatternDesc(String type, Date date);
    
    List<Dataset> findByTypeAndDateOrderByDateAsc(String type, Date date);
    List<Dataset> findByTypeAndDateOrderByDateDesc(String type, Date date);
    
    List<Dataset> findByTypeAndDate(String type, Date date);
    
    
    List<Dataset> findByPatternAndDateOrderByPatternAsc(String pattern, Date date);
    List<Dataset> findByPatternAndDateOrderByPatternDesc(String pattern, Date date);
    
    List<Dataset> findByPatternAndDateOrderByTypeAsc(String pattern, Date date);
    List<Dataset> findByPatternAndDateOrderByTypeDesc(String pattern, Date date);
    
    List<Dataset> findByPatternAndDateOrderByDateAsc(String pattern, Date date);
    List<Dataset> findByPatternAndDateOrderByDateDesc(String pattern, Date date);
    
    List<Dataset> findByPatternAndDate(String pattern, Date date);
    
    //1 MATCHCASE
    List<Dataset> findByTypeOrderByTypeAsc(String type);
    List<Dataset> findByTypeOrderByTypeDesc(String type);
    
    List<Dataset> findByTypeOrderByPatternAsc(String type);
    List<Dataset> findByTypeOrderByPatternDesc(String type);
    
    List<Dataset> findByTypeOrderByDateAsc(String type);
    List<Dataset> findByTypeOrderByDateDesc(String type);
    
    List<Dataset> findByType(String type);
    
    
    List<Dataset> findByPatternOrderByPatternAsc(String pattern);
    List<Dataset> findByPatternOrderByPatternDesc(String pattern);
    
    List<Dataset> findByPatternOrderByTypeAsc(String pattern);
    List<Dataset> findByPatternOrderByTypeDesc(String pattern);
    
    List<Dataset> findByPatternOrderByDateAsc(String pattern);
    List<Dataset> findByPatternOrderByDateDesc(String pattern);
    
    List<Dataset> findByPattern(String pattern);
    
    
    List<Dataset> findByDateOrderByDateAsc(Date date);
    List<Dataset> findByDateOrderByDateDesc(Date date);
    
    List<Dataset> findByDateOrderByTypeAsc(Date date);
    List<Dataset> findByDateOrderByTypeDesc(Date date);
    
    List<Dataset> findByDateOrderByPatternAsc(Date date);
    List<Dataset> findByDateOrderByPatternDesc(Date date);
    
    List<Dataset> findByDate(Date date);
    
    //ALL
    List<Dataset> findAllByOrderByPatternAsc();
    List<Dataset> findAllByOrderByPatternDesc();
    
    List<Dataset> findAllByOrderByDateAsc();
    List<Dataset> findAllByOrderByDateDesc();
    
    List<Dataset> findAllByOrderByTypeAsc();
    List<Dataset> findAllByOrderByTypeDesc();
    
    
}
