package com.HMT.mood;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.HMT.mood.controller.MainController;
import com.HMT.mood.dao.IDiaryDAO;
import com.HMT.mood.dao.IMemberDAO;

@SpringBootApplication
@ComponentScan(basePackages = {"com.HMT.mood"})
// @ComponentScan(basePackageClasses = MainController.class)
// @ComponentScan(basePackageClasses = MemberController.class)
// @ComponentScan(basePackageClasses = DiaryController.class)
@MapperScan(basePackageClasses = IMemberDAO.class)
@MapperScan(basePackageClasses = IDiaryDAO.class)
public class MoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoodApplication.class, args);
	}

}
