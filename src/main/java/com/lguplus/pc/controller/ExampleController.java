/**
* @packageName	: com.lguplus.pc.controller
* @fileName		: ExampleController.java
* @author		: 83474
* @date			: 2024.08.22
* @description	:
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2024.08.22        83474       	최초 생성
*/
package com.lguplus.pc.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lguplus.pc.dto.ExampleDTO;
import com.lguplus.pc.service.ExampleService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/example")
@RequiredArgsConstructor
@Tag(name = "ExampleController", description = "Example Controller")
public class ExampleController {

	@Autowired
	private ExampleService exampleService;
	
	@GetMapping("/list")
	public ResponseEntity<List<ExampleDTO>> getAllEmployees() {
		List<ExampleDTO> employees = exampleService.getAllEmployees();
		
		return ResponseEntity.ok(employees);
	}
	
	/**
	 * @description	:
	 * @param header
	 * @return
	 */
	@GetMapping("/hello")
    public String sayHello(@RequestHeader HttpHeaders header) {

        // 현재 시간 가져오기
        LocalDateTime currentTime = LocalDateTime.now();

        // 출력 형식 지정
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // 현재 시간을 문자열로 변환
        String currentTimeString = currentTime.format(formatter);

        System.out.println(currentTimeString);
        //log.info("Hello, {}", currentTimeString);
        //FATAL, ERROR, WARN, INFO, DEBUG, TRACE
        
        log.info("Hello, {}", currentTimeString);
        
        return "Hello";
    }
}
