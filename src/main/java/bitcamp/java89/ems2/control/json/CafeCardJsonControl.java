package bitcamp.java89.ems2.control.json;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.java89.ems2.domain.StampCardInfo;
import bitcamp.java89.ems2.domain.StampPosition;
import bitcamp.java89.ems2.service.CafeCardService;

@RestController
public class CafeCardJsonControl {
  @Autowired ServletContext sc;
  
  @Autowired CafeCardService cafeCardService;
  
  @RequestMapping(value = "/admin/cardadd/add")
  public AjaxResult add(StampCardInfo stampCardInfo) throws Exception {
	int stampCafeCardNo = cafeCardService.add(stampCardInfo);
    return new AjaxResult(AjaxResult.SUCCESS, stampCafeCardNo);
  }
  
  
  @RequestMapping(value = "/admin/cardadd/addStampPosition")
  public AjaxResult add(StampPosition stampPosition) throws Exception {
	cafeCardService.addPosition(stampPosition);
    
    return new AjaxResult(AjaxResult.SUCCESS, "등록 성공입니다.");
  }
  
}




