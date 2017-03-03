package com.topmanage.tmtrial.service;

import com.topmanage.tmtrial.models.Dataset;
import com.topmanage.tmtrial.models.Events;
import com.topmanage.tmtrial.models.Groups;
import com.topmanage.tmtrial.models.Pages;
import com.topmanage.tmtrial.models.Users;
import com.topmanage.tmtrial.repository.DatasetRepository;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class TrialService {

	@Autowired
	private DatasetRepository datasetsRepository;
        
        @Autowired
        private MongoTemplate mongoTemplate;

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
        
          
        private String getMethodName(String methodName, String att){
            methodName += (methodName.contains("By") ? "And"+att.substring(0,1).toUpperCase()+att.substring(1) : "By"+att.substring(0,1).toUpperCase()+att.substring(1));
            return methodName;
        }
        
        public List<Dataset> findAllSets(String type, String order, Date date, String pattern, String sort) {
       
            List<Dataset> datasets = new ArrayList();
            String methodName = "find";
            List<Object> obj = new ArrayList();
            if (type != null){
                methodName += (methodName.contains("By") ? "AndType" : "ByType");
                obj.add(type);
            }
            if (pattern != null){
                methodName += (methodName.contains("By") ? "AndPattern" : "ByPattern");
                obj.add(pattern);
            }
            if (date != null){
                methodName += (methodName.contains("By") ? "AndDate" : "ByDate");
                obj.add(date);
            }
            if (sort != null)
                methodName += "OrderBy"+sort.substring(0,1).toUpperCase()+sort.substring(1) + ((order == null) ? "" : order.substring(0,1)+order.substring(1).toLowerCase());
            if (methodName.length() == 4)
                methodName += "All";
            
            Class<?> params[] = new Class[obj.size()];
            for (int i = 0; i < obj.size(); i++) {
                if (obj.get(i) instanceof String) {
                    params[i] = String.class;
                }
                // you can do additional checks for other data types if you want.
            }
            
            String[] args = new String[obj.size()];
            args = obj.toArray(args); 
            
            try {
                Method method = datasetsRepository.getClass().getDeclaredMethod(methodName, params);
                datasets = (List<Dataset>) method.invoke(datasetsRepository, args);
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(TrialService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(TrialService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(TrialService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(TrialService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(TrialService.class.getName()).log(Level.SEVERE, null, ex);
            }
          
            return datasets;
	
        }
        
        public void deleteSet(String id){
            datasetsRepository.delete(id);
        }

}
