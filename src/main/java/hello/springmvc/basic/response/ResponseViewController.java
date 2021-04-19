package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello!");
        return mav;
    }

    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data", "hello!");
        //String으로 반환되면 반환하는 스트링이 바로 뷰의 논리적 이름이 됨
        //뷰리졸버를 통해 해당 뷰를 찾음
        return "response/hello";
    }

    //권장하지는 않는 방법 (ModelAndView 객체, View 이름 아무것도 리턴하지 않음)
    //컨트롤러의 경로 이름이랑 뷰의 논리적 이름 일치하면 리턴 값 생략 가능
    //컨트롤러의 경로 이름을 뷰의 논리적 이름으로 취급
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model) {
        model.addAttribute("data", "hello!!");
    }

}
