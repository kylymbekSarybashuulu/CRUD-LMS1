package com.peaksoft.config;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class DispatcherServlet extends AbstractAnnotationConfigDispatcherServletInitializer{
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }


    @Override
    public void onStartup(ServletContext aServletContext) throws ServletException {
        super.onStartup(aServletContext);
        registerHiddenFieldFilter(aServletContext);
    }

    private void registerHiddenFieldFilter(ServletContext aContext) {
        aContext.addFilter("hiddenHttpMethodFilter",
                new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null ,true, "/*");
    }
}
/*
1) CRUD LMS приложение жазыныз. Spring MVC + Hibernate колдонунуз.

2) Company(Peaksoft, ...), Course(Java1, Java2, Technical Sckils , ...), Teacher(Zamir Sabyrzhanov, ...),
Student(Hadicha Zamirbekova, ...), Group(JavaBatch4, ...) деген класстар болушу керек.

Company(id, companyName, locatedCountry) + List<Course> courses;
Course(id, courseName, duration(Month)
Teacher(id, firstName, email, lastName)
Student(id, firstName, email, lastName, studyFormat(Enum)
Group(id, groupName, dateOfStart, dateOfFinish)

3) Entity'лердин колдонулушу:
I -  Бир компанияда бир канча курстар болушу керек
II - Бир курста бир канча группа боло алат, бир группа дагы бир канча курсту ала алат
II - Бир группада бир канча студенттер болушу керек
III - Бир инструктор бир гана курсту ала алат,  бир курста бир гана инструктор боло алат

4) Entity-relationship:
I - Приложениеде ар бир Entity'нин  страницасы болсун, очуруп жана озгорто турган мумкунчулуктору менен болот.
II - курсту тузуп же озгортуп жатканда ага компаниясын бере алышыбыз керек
III - группаны тузуп же озгортуп жатканда кайсы курстарды окуй аларын тандай алышыбыз керек
III - Студент тузуп же озгортуп жатканда анын кайсы группага кирээрин тандай алышыбыз керек
IV - Инструктор тузуп же озгортуп жатканда кайсы курсту окутаарын тандай алышыбыз керек

5) Аткарыла турчу функцияналдар:
I- компаниянын канча студентти окутат санын чыгара алышыбыз керек
II - бир инструктордун канча студенти бар санын чыгара алышыбыз керек
III - группанын страницасында поиск студента по имени болушу керек

6) Конфигурация Spring JavaConfig жана аннотациялар аркылуу болсун. xml файлсыз. Spring boot колдонбонуз.

7) База менен иштоо учун конфигурацияга озгортуулорду кылыныз. SessionFactory-нин ордуна EntityManager колдонунуз.
 */
