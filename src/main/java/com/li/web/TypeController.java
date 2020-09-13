package com.li.web;

import com.li.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin") // 路径为admin,因为配置了拦截器，这样其他人不登录进入不了你的admin资源
public class TypeController {

    @Autowired
    private ITypeService service;

    /**
     * @PageableDefault 注解 可以设置分页的大小，按什么进行排序，以及是升序还是降序
     *                  sort 是排序 后边可以跟多个参数
     *                  direction 是排序类型，降序，还是升序
     *                  pageable 分页对象
     *                  model    封装参数，前台获取，进行展示
     * @return
     */
    @GetMapping("/types")
    public String types(@PageableDefault(size = 10,sort = {"id"},
                        direction = Sort.Direction.DESC)
                        Pageable pageable,Model model)
    {
        // 封装对象，类似于map，根据key 进行取值,page里的数据结构，是根据page.content获取的，数据在content
        model.addAttribute("page",service.listType(pageable));
        return "admin/types";
    }
}
