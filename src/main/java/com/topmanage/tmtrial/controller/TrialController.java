/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.topmanage.tmtrial.controller;

import com.topmanage.tmtrial.models.Dataset;
import com.topmanage.tmtrial.models.ResponseModel;
import com.topmanage.tmtrial.service.TrialService;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Services")
public class TrialController {

        @Value("${application.token}")
	private String fbToken;
        
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private TrialService testService;

        
        @RequestMapping(value = "/findUsersByName", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
        @CrossOrigin
	public @ResponseBody ResponseModel<Dataset> findUsersByName(@RequestParam(value = "name", required = true) final String name) throws ParseException {
		logger.info("Retrieving users");
		ResponseModel<Dataset> response = new ResponseModel<Dataset>();
		response.setResponse(testService.findUsersByName(name, fbToken));
		return response;
	}
        
        @RequestMapping(value = "/findPagesByName", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
        @CrossOrigin
	public @ResponseBody ResponseModel<Dataset> findPagesByName(@RequestParam(value = "name", required = true) final String name) throws ParseException {
		logger.info("Retrieving pages");
		ResponseModel<Dataset> response = new ResponseModel<Dataset>();
		response.setResponse(testService.findPageByName(name, fbToken));
		return response;
	}
        
        @RequestMapping(value = "/findEventsByName", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
        @CrossOrigin
	public @ResponseBody ResponseModel<Dataset> findEventsByName(@RequestParam(value = "name", required = true) final String name) throws ParseException {
		logger.info("Retrieving pages");
		ResponseModel<Dataset> response = new ResponseModel<Dataset>();
		response.setResponse(testService.findEventsByName(name, fbToken));
		return response;
	}
        
        @RequestMapping(value = "/findGroupsByName", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
        @CrossOrigin
	public @ResponseBody ResponseModel<Dataset> findGroupsByName(@RequestParam(value = "name", required = true) final String name) throws ParseException {
		logger.info("Retrieving pages");
		ResponseModel<Dataset> response = new ResponseModel<Dataset>();
		response.setResponse(testService.findGroupsByName(name, fbToken));
		return response;
	}
        
        @RequestMapping(value = "/findAllSets", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
        @CrossOrigin
	public @ResponseBody ResponseModel<List<Dataset>> findAllSets(@RequestParam(value = "type", required = false) final String type, 
                @RequestParam(value = "order", required = false) final String order, 
                @RequestParam(value = "sort", required = false) final String sort, 
                @RequestParam(value = "date", required = false) @DateTimeFormat(pattern="dd/MM/yyyy") final Date date, 
                @RequestParam(value = "pattern", required = false) final String pattern) {
		logger.info("Retrieving pages");
		ResponseModel<List<Dataset>> response = new ResponseModel<List<Dataset>>();
		response.setResponse(testService.findAllSets(type, order, date, pattern, sort));
		return response;
	}
        
        @RequestMapping(value = "/deleteSet", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
        @CrossOrigin
	public @ResponseBody ResponseModel<String> deleteSet(@RequestParam(value = "id", required = true) final String id) {
		logger.info("Retrieving pages");
		ResponseModel<String> response = new ResponseModel<String>();
                testService.deleteSet(id);
                response.setMessage("Succesfully deleted "+id);
                response.setResponse("Finished with no errors");
		return response;
	}
        
        @ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.CONFLICT)
        public @ResponseBody ResponseModel<String> handleError(HttpServletRequest req, Exception ex) {
            logger.error("Request: " + req.getRequestURL() + " raised " + ex);
            ResponseModel<String> response = new ResponseModel<String>();
            response.setResponse(ex.getMessage());
            response.setOptional("FB Token probably expired, please refresh the token");
            return response;
        }

}
