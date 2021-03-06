package bitcamp.java89.ems2.control.json;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import bitcamp.java89.ems2.domain.Event;
import bitcamp.java89.ems2.service.EventService;
import bitcamp.java89.ems2.util.MultipartUtil;

@RestController
public class EventJsonControl {
  @Autowired ServletContext sc;
  
  @Autowired EventService eventService;
  
  @RequestMapping(value = "/admin/event/list")
  public AjaxResult list(int cafeMemberNo, int pageCount, int postNo, String searchCondition, String searchKeyword) throws Exception {
    List<Event> list = eventService.getList(cafeMemberNo, pageCount, postNo, searchCondition, searchKeyword);
    int allEventNo = eventService.getCount(cafeMemberNo, searchCondition, searchKeyword);
    
    if (list.size() == 0) {
      return new AjaxResult(AjaxResult.FAIL, "페이지가 존재하지 않습니다.");
    }
    
    HashMap<String,Object> resultMap = new HashMap<>();
    resultMap.put("list", list);
    resultMap.put("allEventNo", allEventNo);
    
    return new AjaxResult(AjaxResult.SUCCESS, resultMap);
  }
  @RequestMapping(value ="/cstmr_m/event/getAllList")
  public AjaxResult getAllList(int pageCount, int postNo, String searchCondition) throws Exception {
    List<Event> list = null;
    if(searchCondition == null) {
      list = eventService.getAllListInfinityScroll(pageCount, postNo);
    } else {
      list = eventService.getAllListInfinityScrollSearchCondition(pageCount, postNo,searchCondition);
    }
    
    if (list.size() == 0) {
      return new AjaxResult(AjaxResult.FAIL, "페이지가 존재하지 않습니다.");
    }
    return new AjaxResult(AjaxResult.SUCCESS, list);
  }
  
  @RequestMapping(value ="/cstmr_m/event/getAllListCount")
  public AjaxResult getAllListCount() throws Exception {
    int eventCountAll = eventService.getCountAll();
    return new AjaxResult(AjaxResult.SUCCESS, eventCountAll);
  }
  
  @RequestMapping(value ="/cstmr_m/event/getAllListBanner")
  public AjaxResult getAllList() throws Exception {
    List<Event> list = eventService.getAllListBanner();
    
    if (list.size() == 0) {
      return new AjaxResult(AjaxResult.FAIL, "페이지가 존재하지 않습니다.");
    }
    
    
    return new AjaxResult(AjaxResult.SUCCESS, list);
  }
  
  @RequestMapping(value = { "/admin_m/event/list"})
  public AjaxResult list(int cafeMemberNo, int pageCount, int postNo) throws Exception {
    List<Event> list = eventService.getListInfinityScroll(cafeMemberNo, pageCount, postNo);
    
    if (list.size() == 0) {
      return new AjaxResult(AjaxResult.FAIL, "페이지가 존재하지 않습니다.");
    }
    
    HashMap<String,Object> resultMap = new HashMap<>();
    resultMap.put("list", list);
    
    return new AjaxResult(AjaxResult.SUCCESS, resultMap);
  }
  
  
  @RequestMapping(value = {"/admin/event/add", "/admin_m/event/add"})
  public AjaxResult add(Event event, MultipartFile photo) throws Exception {
    
    // 페이지 컨트롤러는 입력 파라미터 값을 가공하여 모델 객체에게 전달하는 일을 한다.
    if (photo != null && photo.getSize() > 0) { 
      String newFilename = MultipartUtil.generateFilename();
      photo.transferTo(new File(sc.getRealPath("/upload/" + newFilename)));
      event.setEventPhotoPath(newFilename);
    }
    
    eventService.add(event);

    return new AjaxResult(AjaxResult.SUCCESS, "등록 성공입니다.");
  }
  
  
  @RequestMapping(value ={"/admin/event/detail", "/cstmr_m/event/detail", "/admin_m/event/detail"})
  public AjaxResult detail(int eventNo) throws Exception {
    Event event = eventService.getDetail(eventNo);
    
    if (event == null) {
      return new AjaxResult(AjaxResult.FAIL, "해당 글이 없습니다.");
    }
    
    return new AjaxResult(AjaxResult.SUCCESS, event);
  }
  
  
  @RequestMapping(value = {"/admin/event/delete", "/admin_m/event/delete"})
  public AjaxResult delete(int eventNo) throws Exception {
    int count = eventService.delete(eventNo);
    if (count == 0) {
      return new AjaxResult(AjaxResult.FAIL, "해당 글이 없습니다.");
    }
    return new AjaxResult(AjaxResult.SUCCESS, "삭제 성공입니다.");
  }
  
  @RequestMapping(value="/admin/event/updateView")
  public void updateView(int eventNo) throws Exception {
    eventService.updateView(eventNo);
  }
  
  @RequestMapping(value={"/admin/event/update","/admin_m/event/update"})
  public AjaxResult update(Event event) throws Exception {

    int count = eventService.update(event);
    
    if (count == 0) {
      return new AjaxResult(AjaxResult.FAIL, "해당 번호의 학생이 없습니다.");
    }
    
    return new AjaxResult(AjaxResult.SUCCESS, "변경 성공입니다.");
  }
  
  @RequestMapping("/admin/event/pagination")
  public AjaxResult pagination(int cafeMemberNo, int currentPage, int postNo, String searchCondition, String searchKeyword) throws Exception {
    List<Integer> pageNumbers = eventService.getPagination(cafeMemberNo, currentPage, postNo, searchCondition, searchKeyword);
    
    if (pageNumbers.size() == 0) {
      return new AjaxResult(AjaxResult.FAIL, "페이지 번호 정보가 존재하지 않습니다.");
    }
    
    return new AjaxResult(AjaxResult.SUCCESS, pageNumbers);
  }
}





