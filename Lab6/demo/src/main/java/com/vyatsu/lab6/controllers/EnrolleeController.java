package com.vyatsu.lab6.controllers;

import com.vyatsu.lab6.dao.EnrolleeDBDao;
import com.vyatsu.lab6.dao.EnrolleeListDao;
import com.vyatsu.lab6.dao.ExamDBDao;
import com.vyatsu.lab6.dao.ExamListDao;
import com.vyatsu.lab6.entity.ExamEntity;
import com.vyatsu.lab6.models.Enrollee;
import com.vyatsu.lab6.models.Exam;
import com.vyatsu.lab6.service.EnrolleeService;
import com.vyatsu.lab6.service.ExamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EnrolleeController {

    ExamDBDao examDBDao = new ExamDBDao();
    EnrolleeDBDao enrolleeDBDao = new EnrolleeDBDao();
    EnrolleeListDao enrolleeDAO = new EnrolleeListDao(enrolleeDBDao);
    ExamListDao examDao = new ExamListDao();
    EnrolleeService enrolleeService = new EnrolleeService(enrolleeDBDao);

    ExamService examService = new ExamService(examDBDao);
    

    @GetMapping("/enrollees")
    public String enrollees(Model model){
        model.addAttribute("title","Список абитуриентов");
        List<Enrollee> enrollees = enrolleeService.getAllEnrollees();// получение списка абитуриентов
        model.addAttribute("enrollees", enrollees);
        return "enrollees";
    }

    @GetMapping("/enrollee/{id}")
    public String enrollee(@PathVariable int id, Model model){
        Enrollee enrollee = enrolleeService.getEnrollee(id);
        List<Exam> exams = examDBDao.getEnrolleeExams(id).stream().map(Exam::new).toList();// получение экзаменов, сданных абитуриентом TODO: A
        model.addAttribute("enrollee", enrollee);
        model.addAttribute("exams", exams);

        return "enrollee";
    }

    @GetMapping("/add")
    public String enrolleeForm(Model model) {
        model.addAttribute("title","Добавление абитуриента");
        Enrollee enrollee = new Enrollee();
        model.addAttribute("enrollee", enrollee);
        model.addAttribute("number", enrolleeDAO.getEnrollees().size() + 1);
        return "add";
    }

    @PostMapping("/add")
    public String enrolleeSubmit(@ModelAttribute Enrollee enrollee,
                                 Model model) {
        enrolleeDAO.save(enrollee);
        List<Enrollee> enrollees = enrolleeDAO.getEnrollees();
        model.addAttribute("enrollees", enrollees);
        return "redirect:/enrollees";
    }

    @GetMapping("/exam/{id}")
    public String examForm(@PathVariable int id, Model model) {
        model.addAttribute("title","Добавление экзамена");
        List<String> subjects = new ArrayList<>();
        subjects.add("Русский язык");
        subjects.add("Математика");
        subjects.add("Информатика");
        subjects.add("Физика");
        subjects.add("Биология");

        model.addAttribute("subjects", subjects);
        Exam exam = new Exam();
        model.addAttribute("exam", exam);
        model.addAttribute("id", id);
        model.addAttribute("subject", "");
        return "exam";
    }

    @PostMapping("/exam")
    public String examSubmit(@ModelAttribute Exam exam,
                             Model model) {
        ExamEntity examEntity = new ExamEntity(exam);
        examDao.save(examEntity);
        List<ExamEntity> exams = examDao.getExams();
        model.addAttribute("exams", exams);
        return "redirect:/enrollees";
    }
}