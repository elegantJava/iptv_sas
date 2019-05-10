package com.hgys.iptv.controller;

import com.hgys.iptv.exception.BaseException;
import com.hgys.iptv.model.SettlementDimension;
import com.hgys.iptv.model.enums.ResultEnum;
import com.hgys.iptv.model.vo.ResultVO;
import com.hgys.iptv.service.SettlementDimensionService;
import com.hgys.iptv.util.ResultVOUtil;
import com.hgys.iptv.util.excel.ExcelForWebUtil;
import com.hgys.iptv.util.excel.PathConstant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/demo")
@Api(value = "Demo",tags = "demo演示接口")
public class DemoContronller {

    @Autowired
    private SettlementDimensionService settlementDimensionService;

    @GetMapping("demoReturn")
    @ApiOperation(value = "演示接口",notes = "返回json数据类型")
    public ResultVO<?> signBaseAgreement(@ApiParam(value = "用户名称",required = true) @RequestParam("name")String name) {
        /**
         * 抛异常处理
         */
        if (StringUtils.isBlank(name)){
            throw new BaseException(ResultEnum.ACCESS_DENIED_ERROR);
        }

        /**
         * 处理成功情况
         */
        if (true){
            //success方法对象为T型，Object、List等查询的对象都可放入其中
            //return ResultVOUtil.success(Boolean.TRUE);
            return ResultVOUtil.success(name);
        }
        /**
         * 处理失败情况
         */
        return ResultVOUtil.error(ResultEnum.SYSTEM_INTERNAL_ERROR);

    }

    @GetMapping("/excel")
    @ApiOperation(value = "excel导出模板",notes = "返回Excel文件")
    public void excel(HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException {
        Map<String, Object> beanParams = new HashMap<>();
        List<Map> l = new ArrayList<>();
        for(int i=1;i<29;i++){
            Map<String,String> a = new HashMap<>();
            a.put("name","名称："+i);
            a.put("code","编码："+i);
            l.add(a);
        }
        beanParams.put("pList",l);
        ExcelForWebUtil.exportExcel(response,beanParams,"test.xlsx", PathConstant.getExcelExportResource(),"导出测试文件.xlsx");

    }

    @GetMapping("/test")
    @ApiOperation(value = "QueryDSL  SQL方法测试",notes = "")
    @ResponseStatus(HttpStatus.CREATED)
    public Page<SettlementDimension> updateSettlementDimension(){
        return settlementDimensionService.a();
    }

}
