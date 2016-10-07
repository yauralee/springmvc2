package com.liyu.spring.test;

import com.liyu.spring.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by twcn on 10/7/16.
 */
@Controller
public class SpringMVCTest {
    @Autowired
    private EmployeeDao employeeDao;


    @RequestMapping(value="/testDefaultHandlerExceptionResolver", method = RequestMethod.POST)
    public String testDefaultHandlerExceptionResolver(){
        System.out.println("testDefaultHandlerExceptionResolver");
        return "success";
    }

    @ResponseStatus(reason="for test", value= HttpStatus.NOT_FOUND)
    @RequestMapping("/testResponseStatusExceptionResolver")
    public String testResponseStatusExceptionResolver(@RequestParam("i") int i){
        if(i == 13){
            throw new UsernameNotMatchPasswordException();
        }
        System.out.println("normal");
        return "success";
    }

    @RequestMapping("/testSimpleMappingExceptionResolver")
    public String testSimpleMappingExceptionResolver(@RequestParam("i") int i){
        String[] vals = new String[10];
        System.out.println(vals[i]);
        return "success";
    }


    /**
     * 1. 在@ExceptionHandler方法的入参中可以加入Exception类型的参数，该参数即对应发生的异常对象
     * 2. @ExceptionHandler方法的入参中不能传入map,若希望把异常信息传到页面上，需要使用ModelAndView作为返回值
     * 3. @ExceptionHandler方法标记的异常有优先级问题。
     * 4. @ControllerAdvice：如果在当前handler中找不到@ExceptionHandler方法来处理当前方法出现的异常，则
     *    将去@ControllerAdvice标记的类中查找@ExceptionHandler标记的方法来处理异常。
     */
//    @ExceptionHandler({ArithmeticException.class})
//    public String handleArithmeticException(Exception ex, Map<String, Object> map){
//        System.out.println("异常：" + ex);
//        map.put("exception", ex);
//        return "error";
//    }
//    public ModelAndView handleArithmeticException(Exception ex){
//        System.out.println("exception：" + ex);
//        ModelAndView mv = new ModelAndView("error");
//        mv.addObject("exception", ex);
//        return mv;
//    }

//    @ExceptionHandler({ RuntimeException.class})
//    public ModelAndView handleARuntimeException(Exception ex){
//        System.out.println("[exception]：" + ex);
//        ModelAndView mv = new ModelAndView("error");
//        mv.addObject("exception", ex);
//        return mv;
//    }



}
