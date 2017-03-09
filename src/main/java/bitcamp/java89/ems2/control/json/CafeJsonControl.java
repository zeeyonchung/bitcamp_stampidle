package bitcamp.java89.ems2.control.json;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.java89.ems2.domain.Cafe;
import bitcamp.java89.ems2.domain.CafePhoto;
import bitcamp.java89.ems2.domain.CafeTime;
import bitcamp.java89.ems2.domain.Likes;
import bitcamp.java89.ems2.domain.Menu;
import bitcamp.java89.ems2.domain.Tag;
import bitcamp.java89.ems2.service.CafePhotoService;
import bitcamp.java89.ems2.service.CafeService;
import bitcamp.java89.ems2.service.CafeTimeService;
import bitcamp.java89.ems2.service.LikesService;
import bitcamp.java89.ems2.service.MenuService;
import bitcamp.java89.ems2.service.TagService;


@RestController
public class CafeJsonControl {
  @Autowired ServletContext sc;
  
  @Autowired CafeService cafeService;
  @Autowired CafeTimeService cafeTimeService;
  @Autowired TagService tagService;
  @Autowired CafePhotoService cafePhotoService;
  @Autowired MenuService menuService;
  @Autowired LikesService likesService;
  
  @RequestMapping("/admin/cafe/add")
  public AjaxResult add(Cafe cafe) throws Exception {
    cafeService.add(cafe);
    return new AjaxResult(AjaxResult.SUCCESS, "등록 성공입니다.");
  }
  
  @RequestMapping("/admin/cafeTime/add")
  public AjaxResult add(CafeTime cafeTime) throws Exception {
    cafeTimeService.add(cafeTime);
    return new AjaxResult(AjaxResult.SUCCESS, "등록 성공입니다.");
  }
  
  @RequestMapping("/admin/tag/add")
  public AjaxResult add(Tag tag) throws Exception {
    tagService.add(tag);
    return new AjaxResult(AjaxResult.SUCCESS, "등록 성공입니다.");
  }
  
  @RequestMapping("/admin/cafePhoto/add")
  public AjaxResult add(CafePhoto cafePhoto) throws Exception {
  	cafePhotoService.add(cafePhoto);
  	return new AjaxResult(AjaxResult.SUCCESS, "등록 성공입니다.");
  }
  
  @RequestMapping("/admin/menu/add")
  public AjaxResult add(Menu menu) throws Exception {
  	menuService.add(menu);
  	return new AjaxResult(AjaxResult.SUCCESS, "등록 성공입니다.");
  }
  

  @RequestMapping(value ={"/admin/cafe/detail","/cstmr_m/cafe/detail"})
  public AjaxResult detail(int cafeMemberNo) throws Exception {
    Cafe cafe = (Cafe)cafeService.getDetail(cafeMemberNo);
    if (cafe == null) {
      return new AjaxResult(AjaxResult.FAIL, "해당 회원이 없습니다.");
    }
    return new AjaxResult(AjaxResult.SUCCESS, cafe);
  }
  
  
  @RequestMapping(value = {"/admin/cafeTime/detail", "/cstmr_m/cafeTime/detail"})
  public AjaxResult detailTime(int cafeMemberNo) throws Exception {
  	CafeTime cafeTime = (CafeTime)cafeTimeService.detailTime(cafeMemberNo);
  	if (cafeTime == null) {
      return new AjaxResult(AjaxResult.FAIL, "해당 회원이 없습니다.");
    }
    return new AjaxResult(AjaxResult.SUCCESS, cafeTime);
  }
  
  
  @RequestMapping(value = {"/admin/tag/detail", "/cstmr_m/tag/detail"})
  public AjaxResult detailTag(int cafeMemberNo) throws Exception {
  	Tag tag = (Tag)tagService.detailTag(cafeMemberNo);
  	if (tag == null) {
      return new AjaxResult(AjaxResult.FAIL, "해당 회원이 없습니다.");
    }
    
    return new AjaxResult(AjaxResult.SUCCESS, tag);
  }
  
  
  @RequestMapping(value = {"/admin/cafePhoto/detail"})
  public AjaxResult detailCafePhoto(int cafeMemberNo) throws Exception {
  	CafePhoto cafePhoto = (CafePhoto)cafePhotoService.detailCafePhoto(cafeMemberNo);
  	if (cafePhoto == null) {
      return new AjaxResult(AjaxResult.FAIL, "해당 회원이 없습니다.");
    }
    
    return new AjaxResult(AjaxResult.SUCCESS, cafePhoto);
  }
  
  
  @RequestMapping(value = {"/admin/menu/detail"})
  public AjaxResult detailMenu(int cafeMemberNo) throws Exception {
  	Menu menu = (Menu)menuService.detailMenu(cafeMemberNo);
  	if (menu == null) {
      return new AjaxResult(AjaxResult.FAIL, "해당 회원이 없습니다.");
    }
    
    return new AjaxResult(AjaxResult.SUCCESS, menu);
  }
  

  @RequestMapping(value = {"/admin/cafe/update"})
  public AjaxResult update(Cafe cafe) throws Exception {
    int count = cafeService.update(cafe);
    if (count == 0) {
      return new AjaxResult(AjaxResult.FAIL, "해당 번호의 회원이 없습니다.");
    }
    return new AjaxResult(AjaxResult.SUCCESS, "변경 성공입니다.");
  }
  
  
  @RequestMapping(value = {"/admin/cafeTime/update"})
  public AjaxResult update(CafeTime cafeTime) throws Exception {
    int count = cafeTimeService.update(cafeTime);
    if (count == 0) {
      return new AjaxResult(AjaxResult.FAIL, "해당 번호의 회원이 없습니다.");
    }
    return new AjaxResult(AjaxResult.SUCCESS, "변경 성공입니다.");
  }
  
  
  @RequestMapping(value = {"/admin/tag/update"})
  public AjaxResult update(Tag tag) throws Exception {
    int count = tagService.update(tag);
    if (count == 0) {
      return new AjaxResult(AjaxResult.FAIL, "해당 번호의 회원이 없습니다.");
    }
    return new AjaxResult(AjaxResult.SUCCESS, "변경 성공입니다.");
  }
  
  
  @RequestMapping(value = {"/admin/cafePhoto/update"})
  public AjaxResult update(CafePhoto cafePhoto) throws Exception {
    int count = cafePhotoService.update(cafePhoto);
    if (count == 0) {
      return new AjaxResult(AjaxResult.FAIL, "해당 번호의 회원이 없습니다.");
    }
    return new AjaxResult(AjaxResult.SUCCESS, "변경 성공입니다.");
  }
  
  @RequestMapping(value = {"/admin/menu/update"})
  public AjaxResult update(Menu menu) throws Exception {
    int count = menuService.update(menu);
    if (count == 0) {
      return new AjaxResult(AjaxResult.FAIL, "해당 번호의 회원이 없습니다.");
    }
    return new AjaxResult(AjaxResult.SUCCESS, "변경 성공입니다.");
  }
  
  @RequestMapping(value = {"/admin/likes/count"})
  public AjaxResult count(int cafeMemberNo) throws Exception {
  	int num = likesService.count(cafeMemberNo);
    Likes likes = new Likes();
    likes.setNum(num);
    return new AjaxResult(AjaxResult.SUCCESS, likes);
  }
  
  
  
}





