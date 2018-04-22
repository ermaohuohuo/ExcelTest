package com.huohuo.ExcelToWord.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huohuo.ExcelToWord.entity.Customer;
import com.huohuo.ExcelToWord.util.ReadExcel;
import com.huohuo.ExcelToWord.util.WDWUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;



/**
 * @author wkr
 * @Date 2016-11-18
 */
@Controller
@RequestMapping("")
public class ClientController {

    private static Log log = LogFactory.getLog(ClientController.class);
    /**
     * 访问controller进入操作页面
     * @return
     */
    @RequestMapping(value="/init")
    public String init(){
        System.out.println("控制台输出：初始化页面信息");
        return "admin/client";
    }
    /**
     * 上传Excel,读取Excel中内容
     * @param file
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/batchimport",method = RequestMethod.POST)
    public String batchimport(@RequestParam(value="filename") MultipartFile file,
                              HttpServletRequest request,HttpServletResponse response) throws IOException{
        log.info("ClientController ..batchimport() start");
        String Msg =null;
        boolean b = false;

        //判断文件是否为空
        if(file==null){
            Msg ="文件是为空！";
            request.getSession().setAttribute("msg",Msg);
            return "admin/client";
        }

        //获取文件名
        String name=file.getOriginalFilename();

        //进一步判断文件是否为空（即判断其大小是否为0或其名称是否为null）验证文件名是否合格
        long size=file.getSize();
        if(name==null || ("").equals(name) && size==0 && !WDWUtil.validateExcel(name)){
            Msg ="文件格式不正确！请使用.xls或.xlsx后缀文档。";
            request.getSession().setAttribute("msg",Msg);
            return "admin/client";
        }

        //创建处理EXCEL
        ReadExcel readExcel=new ReadExcel();
        //解析excel，获取客户信息集合。
        List<Customer> customerList = readExcel.getExcelInfo(file);
        if(customerList != null && !customerList.toString().equals("[]") && customerList.size()>=1){
            b = true;
        }

        if(b){
            //迭代添加客户信息（注：实际上这里也可以直接将customerList集合作为参数，在Mybatis的相应映射文件中使用foreach标签进行批量添加。）
            for(Customer customer:customerList){
                //这里可以做添加数据库的功能
                System.out.println("第一个值："+customer.getCustomer1()+"\t第二个值："+customer.getCustomer2()+"\t第三个值："+customer.getCustomer3());
            }
            Msg ="批量导入EXCEL成功！";
            request.getSession().setAttribute("msg",Msg);
        }else{
            Msg ="批量导入EXCEL失败！";
            request.getSession().setAttribute("msg",Msg);
        }
        return "admin/client";
    }
    /**
     * 下载Excel模板
     * @param fileName
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/download")
    public String download(String fileName, HttpServletRequest request,
                           HttpServletResponse response) {
        System.out.println("控制台输出：走入下载");
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName="+ fileName);
        try {
            /*String path = Thread.currentThread().getContextClassLoader()
                    .getResource("").getPath()
                    + "download";//这个download目录为啥建立在classes下的
            */
            String path="D:\\upload";
            InputStream inputStream = new FileInputStream(new File(path+ File.separator + fileName));

            OutputStream os = response.getOutputStream();
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }

            // 这里主要关闭。
            os.close();

            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //  返回值要注意，要不然就出现下面这句错误！
        //java+getOutputStream() has already been called for this response
        return null;
    }

}