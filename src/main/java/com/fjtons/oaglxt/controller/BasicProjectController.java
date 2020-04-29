package com.fjtons.oaglxt.controller;

import com.fjtons.oaglxt.aspect.SystemControllerLog;
import com.fjtons.oaglxt.pojo.BasicProject;
import com.fjtons.oaglxt.pojo.PageRequest;
import com.fjtons.oaglxt.pojo.User;
import com.fjtons.oaglxt.service.BasicProjectService;
import com.fjtons.oaglxt.utils.DataUtil;
import org.omg.CORBA.portable.InputStream;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/Basic")
public class BasicProjectController {
    @Resource
    private BasicProjectService  basicProjectService;

    /**
     * 获取分页
     * @param  page, limit
     * @return
     * page=1&limit=10
     */
    @RequestMapping(value="/selectPage")
    @ResponseBody
    public Object selectPage2(int page,int limit,BasicProject basicProject) {
        //需要判断自己得权限
        PageRequest pageQuery=new PageRequest();
        pageQuery.setPageNum(page);
        pageQuery.setPageSize(limit);
        return basicProjectService.selectPage(pageQuery,basicProject);
    }

    //selectAll

    @RequestMapping(value="/selectAll")
    @ResponseBody
    public  Object selectAll(BasicProject basicProject){
        return   basicProjectService.selectAll(basicProject);
    }

    /**
     * 利用序号删除
     */
    @RequestMapping(value="/deletBasicProjectList")
    @ResponseBody
    public  Object deletBasicProjectList(@RequestParam("lists")String[] list){
        return   basicProjectService.deletBasucByserialNumber(list);
    }

    /**
     * 删除单条
     * @param xuhao
     * @return
     */
    @RequestMapping(value="/deletOneBasicProject")
    @ResponseBody
    public Object deletOneBasicProject(String xuhao){
        //删除数据时，需要判断权限审批

        return  basicProjectService.deletOneBasicProject(xuhao);
    }

    /**
     * 添加数据
     * @param basicProject
     * @return
     */
    @RequestMapping(value="/insertBasucByserialNumber")
    @ResponseBody
    @SystemControllerLog(operteContent="项目立项")
    public Object insertBasucByserialNumber(BasicProject basicProject){
        //添加数据时需要审核判断
        //添加签订项目数据     项目名称，工程总金额
        return basicProjectService.insertBasucByserialNumber(basicProject);
    }

    /**
     * 项目审批
     * @param basicProject
     * @return
     */
    @RequestMapping(value="/examinationProject")
    @ResponseBody
    @SystemControllerLog(operteContent="项目审批")
    public Object examinationProject(BasicProject basicProject,HttpSession session){
        //添加数据时需要审核判断
        //添加签订项目数据     项目名称，工程总金额
        User user=(User) session.getAttribute("loginUser");
        if(user.getPermissions()=="3"){
            return  "权限不够";
        }
        return basicProjectService.examinationProject(basicProject);
    }

    /**
     * 修改数据
     * @param basicProject
     * @return
     */
    @RequestMapping(value="/updateBasucByserialNumber")
    @ResponseBody
    public Object updateBasucByserialNumber(BasicProject basicProject){
        return basicProjectService.updateBasucByserialNumber(basicProject);
    }



    /**
     * 上传图片  uploadImage
     */
    @RequestMapping("uploadImage")
    @ResponseBody
    public  Object uploadImage(MultipartFile file, HttpServletRequest request){
        String prefix="";
        String dateStr="";
        //保存上传
        OutputStream out = null;
        InputStream fileInput=null;
        try{
            if(file!=null){
                String originalName = file.getOriginalFilename();
                prefix=originalName.substring(originalName.lastIndexOf(".")+1);
                Date date = new Date();
                String uuid = UUID.randomUUID()+"";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dateStr = simpleDateFormat.format(date);
                //获取静态资源目录
                String path   = ClassUtils.getDefaultClassLoader().getResource("").getPath();
                String filepath = path+"static/" + dateStr+"/"+uuid+"." + prefix;
                //D:\Mywork\MY\oaglxt\src\main\resources\static\images\
                //D:\Mywork\MY\oaglxt\src\main\resources\static\images
                File files=new File(filepath);
                //打印查看上传路径
                System.out.println(filepath);
                if(!files.getParentFile().exists()){
                    files.getParentFile().mkdirs();
                }
                file.transferTo(files);
                Map<String,Object> map2=new HashMap();
                Map<String,Object> map=new HashMap();
                map.put("code",0);
                map.put("msg","");
                map.put("data",map2);
                //获取id
                map2.put("src","static/" + dateStr+"/"+uuid+"." + prefix);
                return map;
            }
        }catch (Exception e){
        }finally{
            try {
                if(out!=null){
                    out.close();
                }
                if(fileInput!=null){
                    fileInput.close();
                }
            } catch (IOException e) {
            }
        }
        Map<String,Object> map=new HashMap();
        map.put("code",1);
        map.put("msg","");
        return null;
    }
    @PostMapping("/upload")
    @ResponseBody
    public Map upload(@RequestParam("file") MultipartFile imgFile, HttpServletRequest request, HttpSession session) throws IOException {
        Map<String,Object> map=new HashMap();
        if (imgFile.isEmpty()) {
            // 设置错误状态码
            return map;
        }
        // 拿到文件名
        String filename = imgFile.getOriginalFilename();
        String  newfileimg= UUID.randomUUID() +filename.substring(filename.indexOf("."));
        System.out.println(newfileimg);
        // 存放上传图片的文件夹
        File fileDir = DataUtil.getImgDirFile();
        File newFile = new File(fileDir.getAbsolutePath() + File.separator + newfileimg);
        imgFile.transferTo(newFile);
        Map<String,Object> map2=new HashMap();
        map.put("code",0);
        map.put("msg","");
        map.put("data",map2);
        //获取id
        map2.put("src",newFile.getAbsolutePath().substring(41));//D:\Mywork\MY\oaglxt\src\main\resources\
        return map;
    }
}
