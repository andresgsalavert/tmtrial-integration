package com.topmanage.tmtrial.service;

import com.topmanage.tmtrial.models.Dataset;
import com.topmanage.tmtrial.models.Events;
import com.topmanage.tmtrial.models.Groups;
import com.topmanage.tmtrial.models.Pages;
import com.topmanage.tmtrial.models.Users;
import com.topmanage.tmtrial.repository.DatasetRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class TrialService {

	@Autowired
	private DatasetRepository datasetsRepository;

	public Dataset findUsersByName(String name, String fbToken) throws ParseException {
            
            RestTemplate restTemplate = new RestTemplate();
            Users users = restTemplate.getForObject("https://graph.facebook.com/v2.8/search?q="+name+"&type=user&access_token="+fbToken, Users.class);
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date now = new Date();

            String dateAsString = sdf.format(now); 
            Date date = sdf.parse(dateAsString);
            
            Dataset<Users> dataset = new Dataset();
            dataset.setData(users);
            dataset.setDate(date);
            dataset.setType("User");
            dataset.setPattern(name);
            
//            List<Dataset> datasets = (List<Dataset>) datasetsRepository.findAll();
//            datasets.add(dataset);
            datasetsRepository.save(dataset);
            
            return dataset;
	
        }

        public Dataset findPageByName(String name, String fbToken) throws ParseException {
            
            RestTemplate restTemplate = new RestTemplate();
            Pages pages = restTemplate.getForObject("https://graph.facebook.com/v2.8/search?q="+name+"&type=page&access_token="+fbToken, Pages.class);
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date now = new Date();

            String dateAsString = sdf.format(now); 
            Date date = sdf.parse(dateAsString);
            
            Dataset<Pages> dataset = new Dataset();
            dataset.setData(pages);
            dataset.setDate(date);
            dataset.setType("Page");
            dataset.setPattern(name);
            
//            List<Dataset> datasets = (List<Dataset>) datasetsRepository.findAll();
//            datasets.add(dataset);
            datasetsRepository.save(dataset);
            
            return dataset;
	
        }
        
        public Dataset findEventsByName(String name, String fbToken) throws ParseException {
            
            RestTemplate restTemplate = new RestTemplate();
            Events events = restTemplate.getForObject("https://graph.facebook.com/v2.8/search?q="+name+"&type=event&access_token="+fbToken, Events.class);
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date now = new Date();

            String dateAsString = sdf.format(now); 
            Date date = sdf.parse(dateAsString);
            
            Dataset<Events> dataset = new Dataset();
            dataset.setData(events);
            dataset.setDate(date);
            dataset.setType("Event");
            dataset.setPattern(name);
            
//            List<Dataset> datasets = (List<Dataset>) datasetsRepository.findAll();
//            datasets.add(dataset);
            datasetsRepository.save(dataset);
            
            return dataset;
	
        }
        
        public Dataset findGroupsByName(String name, String fbToken) throws ParseException {
            
            RestTemplate restTemplate = new RestTemplate();
            Groups groups = restTemplate.getForObject("https://graph.facebook.com/v2.8/search?q="+name+"&type=group&access_token="+fbToken, Groups.class);
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date now = new Date();

            String dateAsString = sdf.format(now); 
            Date date = sdf.parse(dateAsString);
            
            Dataset<Groups> dataset = new Dataset();
            dataset.setData(groups);
            dataset.setDate(date);
            dataset.setType("Group");
            dataset.setPattern(name);
            
//            List<Dataset> datasets = (List<Dataset>) datasetsRepository.findAll();
//            datasets.add(dataset);
            datasetsRepository.save(dataset);
            
            return dataset;
	
        }
        
        public List<Dataset> findAllSets(String type, String order, Date date, String pattern, String sort) {
       
            List<Dataset> datasets = new ArrayList();
            
            if (order == null){
                order = "ASC";
            }
            
            if ((type != null) && (pattern != null) && (date != null)){
                if (order.equals("ASC")){
                    if (sort == null){
                        datasets = datasetsRepository.findByTypeAndPatternAndDate(type, pattern, date);
                    } else if (sort.equals("type")){
                        datasets = datasetsRepository.findByTypeAndPatternAndDateOrderByTypeAsc(type, pattern, date);
                    } else if (sort.equals("date")){
                        datasets = datasetsRepository.findByTypeAndPatternAndDateOrderByDateAsc(type, pattern, date);
                    } else if ((sort.equals("pattern")) || (sort == null)){
                        datasets = datasetsRepository.findByTypeAndPatternAndDateOrderByPatternAsc(type, pattern, date);
                    }
                } else if (order.equals("DESC")){
                    if (sort == null){
                        datasets = datasetsRepository.findByTypeAndPatternAndDate(type, pattern, date);
                    } else if (sort.equals("type")){
                        datasets = datasetsRepository.findByTypeAndPatternAndDateOrderByTypeDesc(type, pattern, date);
                    } else if (sort.equals("date")){
                        datasets = datasetsRepository.findByTypeAndPatternAndDateOrderByDateDesc(type, pattern, date);
                    } else if ((sort.equals("pattern")) || (sort == null)){
                        datasets = datasetsRepository.findByTypeAndPatternAndDateOrderByPatternDesc(type, pattern, date);
                    }
                }
            } else if ((type == null) && (pattern != null) && (date != null)){
                if (order.equals("ASC")){
                    if (sort == null){
                        datasets = datasetsRepository.findByPatternAndDate(pattern, date);
                    } else if (sort.equals("type")){
                        datasets = datasetsRepository.findByPatternAndDateOrderByTypeAsc(pattern, date);
                    } else if (sort.equals("date")){
                        datasets = datasetsRepository.findByPatternAndDateOrderByDateAsc(pattern, date);
                    } else if ((sort.equals("pattern")) || (sort == null)){
                        datasets = datasetsRepository.findByPatternAndDateOrderByPatternAsc(pattern, date);
                    }
                } else if (order.equals("DESC")){
                    if (sort == null){
                        datasets = datasetsRepository.findByPatternAndDate(pattern, date);
                    } else if (sort.equals("type")){
                        datasets = datasetsRepository.findByPatternAndDateOrderByTypeDesc(pattern, date);
                    } else if (sort.equals("date")){
                        datasets = datasetsRepository.findByPatternAndDateOrderByDateDesc(pattern, date);
                    } else if ((sort.equals("pattern")) || (sort == null)){
                        datasets = datasetsRepository.findByPatternAndDateOrderByPatternDesc(pattern, date);
                    }
                }
            } else if ((type != null) && (pattern == null) && (date != null)){
                if (order.equals("ASC")){
                    if (sort == null){
                        datasets = datasetsRepository.findByTypeAndDate(type, date);
                    } else if (sort.equals("type")){
                        datasets = datasetsRepository.findByTypeAndDateOrderByTypeAsc(type, date);
                    } else if (sort.equals("date")){
                        datasets = datasetsRepository.findByTypeAndDateOrderByDateAsc(type, date);
                    } else if ((sort.equals("pattern")) || (sort == null)){
                        datasets = datasetsRepository.findByTypeAndDateOrderByPatternAsc(type, date);
                    }
                } else if (order.equals("DESC")){
                    if (sort == null){
                        datasets = datasetsRepository.findByTypeAndDate(type, date);
                    } else if (sort.equals("type")){
                        datasets = datasetsRepository.findByTypeAndDateOrderByTypeDesc(type, date);
                    } else if (sort.equals("date")){
                        datasets = datasetsRepository.findByTypeAndDateOrderByDateDesc(type, date);
                    } else if ((sort.equals("pattern")) || (sort == null)){
                        datasets = datasetsRepository.findByTypeAndDateOrderByPatternDesc(type, date);
                    }
                }
            } else if ((type != null) && (pattern != null) && (date == null)){
                if (order.equals("ASC")){
                    if (sort == null){
                        datasets = datasetsRepository.findByTypeAndPattern(type, pattern);
                    } else if (sort.equals("type")){
                        datasets = datasetsRepository.findByTypeAndPatternOrderByTypeAsc(type, pattern);
                    } else if (sort.equals("date")){
                        datasets = datasetsRepository.findByTypeAndPatternOrderByDateAsc(type, pattern);
                    } else if ((sort.equals("pattern")) || (sort == null)){
                        datasets = datasetsRepository.findByTypeAndPatternOrderByPatternAsc(type, pattern);
                    }
                } else if (order.equals("DESC")){
                    if (sort == null){
                        datasets = datasetsRepository.findByTypeAndPattern(type, pattern);
                    } else if (sort.equals("type")){
                        datasets = datasetsRepository.findByTypeAndPatternOrderByTypeDesc(type, pattern);
                    } else if (sort.equals("date")){
                        datasets = datasetsRepository.findByTypeAndPatternOrderByDateDesc(type, pattern);
                    } else if ((sort.equals("pattern")) || (sort == null)){
                        datasets = datasetsRepository.findByTypeAndPatternOrderByPatternDesc(type, pattern);
                    }
                }
            } else if ((type != null) && (pattern == null) && (date == null)){
                if (order.equals("ASC")){
                    if (sort == null){
                        datasets = datasetsRepository.findByType(type);
                    } else if (sort.equals("type")){
                        datasets = datasetsRepository.findByTypeOrderByTypeAsc(type);
                    } else if (sort.equals("date")){
                        datasets = datasetsRepository.findByTypeOrderByDateAsc(type);
                    } else if ((sort.equals("pattern")) || (sort == null)){
                        datasets = datasetsRepository.findByTypeOrderByPatternAsc(type);
                    }
                } else if (order.equals("DESC")){
                    if (sort == null){
                        datasets = datasetsRepository.findByType(type);
                    } else if (sort.equals("type")){
                        datasets = datasetsRepository.findByTypeOrderByTypeDesc(type);
                    } else if (sort.equals("date")){
                        datasets = datasetsRepository.findByTypeOrderByDateDesc(type);
                    } else if ((sort.equals("pattern")) || (sort == null)){
                        datasets = datasetsRepository.findByTypeOrderByPatternDesc(type);
                    }
                }
            } else if ((type == null) && (pattern != null) && (date == null)){
                if (order.equals("ASC")){
                    if (sort == null){
                        datasets = datasetsRepository.findByPattern(pattern);
                    } else if (sort.equals("type")){
                        datasets = datasetsRepository.findByPatternOrderByTypeAsc(pattern);
                    } else if (sort.equals("date")){
                        datasets = datasetsRepository.findByPatternOrderByDateAsc(pattern);
                    } else if ((sort.equals("pattern")) || (sort == null)){
                        datasets = datasetsRepository.findByPatternOrderByPatternAsc(pattern);
                    }
                } else if (order.equals("DESC")){
                    if (sort == null){
                        datasets = datasetsRepository.findByPattern(pattern);
                    } else if (sort.equals("type")){
                        datasets = datasetsRepository.findByPatternOrderByTypeDesc(pattern);
                    } else if (sort.equals("date")){
                        datasets = datasetsRepository.findByPatternOrderByDateDesc(pattern);
                    } else if ((sort.equals("pattern")) || (sort == null)){
                        datasets = datasetsRepository.findByPatternOrderByPatternDesc(pattern);
                    }
                }
            } else if ((type == null) && (pattern == null) && (date != null)){
                if (order.equals("ASC")){
                    if (sort == null){
                        datasets = datasetsRepository.findByDate(date);
                    } else if (sort.equals("type")){
                        datasets = datasetsRepository.findByDateOrderByTypeAsc(date);
                    } else if (sort.equals("date")){
                        datasets = datasetsRepository.findByDateOrderByDateAsc(date);
                    } else if ((sort.equals("pattern")) || (sort == null)){
                        datasets = datasetsRepository.findByDateOrderByPatternAsc(date);
                    }
                } else if (order.equals("DESC")){
                    if (sort == null){
                        datasets = datasetsRepository.findByDate(date);
                    } else if (sort.equals("type")){
                        datasets = datasetsRepository.findByDateOrderByTypeDesc(date);
                    } else if (sort.equals("date")){
                        datasets = datasetsRepository.findByDateOrderByDateDesc(date);
                    } else if ((sort.equals("pattern")) || (sort == null)){
                        datasets = datasetsRepository.findByDateOrderByPatternDesc(date);
                    }
                }
            } else if ((type == null) && (pattern == null) && (date == null)){
                if (order.equals("ASC")){
                    if (sort == null){
                        datasets = (List<Dataset>) datasetsRepository.findAll();
                    } else if (sort.equals("type")){
                        datasets = datasetsRepository.findAllByOrderByTypeAsc();
                    } else if (sort.equals("date")){
                        datasets = datasetsRepository.findAllByOrderByDateAsc();
                    } else if (sort.equals("pattern")){
                        datasets = datasetsRepository.findAllByOrderByPatternAsc();
                    }
                } else if (order.equals("DESC")){
                    if (sort == null){
                        datasets = (List<Dataset>) datasetsRepository.findAll();
                    } else if (sort.equals("type")){
                        datasets = datasetsRepository.findAllByOrderByTypeDesc();
                    } else if (sort.equals("date")){
                        datasets = datasetsRepository.findAllByOrderByDateDesc();
                    } else if ((sort.equals("pattern")) || (sort == null)){
                        datasets = datasetsRepository.findAllByOrderByPatternDesc();
                    }
                }
            }
            
            return datasets;
	
        }
        
        public void deleteSet(String id){
            datasetsRepository.delete(id);
        }

}
