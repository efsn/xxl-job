package com.xxl.job.admin.controller;

import com.xxl.job.admin.controller.annotation.PermissionLimit;
import com.xxl.job.admin.controller.request.QueryGidParam;
import com.xxl.job.admin.core.conf.XxlJobAdminConfig;
import com.xxl.job.admin.core.model.XxlJobGroup;
import com.xxl.job.admin.core.model.XxlJobInfo;
import com.xxl.job.admin.core.util.I18nUtil;
import com.xxl.job.admin.dao.XxlJobGroupDao;
import com.xxl.job.admin.service.XxlJobService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.util.GsonTool;
import com.xxl.job.core.util.XxlJobRemotingUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * @author elmi
 * @date 2021/03/25
 */
@Controller
@RequestMapping("/api/job")
public class DynamicJobApiController {

    @Resource
    public XxlJobGroupDao xxlJobGroupDao;
    @Resource
    private XxlJobService xxlJobService;

    /**
     * api
     *
     * @param uri
     * @param data
     * @return
     */
    @RequestMapping("/{uri}")
    @ResponseBody
    @PermissionLimit(limit = false)
    public ReturnT<String> api(HttpServletRequest request, @PathVariable("uri") String uri, @RequestBody(required = false) String data) {

        // valid
        if (!"POST".equalsIgnoreCase(request.getMethod())) {
            return new ReturnT<>(ReturnT.FAIL_CODE, "invalid request, HttpMethod not support.");
        }
        if (uri == null || uri.trim().length() == 0) {
            return new ReturnT<>(ReturnT.FAIL_CODE, "invalid request, uri-mapping empty.");
        }
        if (XxlJobAdminConfig.getAdminConfig().getAccessToken() != null
                && XxlJobAdminConfig.getAdminConfig().getAccessToken().trim().length() > 0
                && !XxlJobAdminConfig.getAdminConfig().getAccessToken().equals(request.getHeader(XxlJobRemotingUtil.XXL_JOB_ACCESS_TOKEN))) {
            return new ReturnT<>(ReturnT.FAIL_CODE, "The access token is wrong.");
        }

        // services mapping
        if ("gid".equals(uri)) {
            String appName = GsonTool.fromJson(data, QueryGidParam.class).getAppName();
            Optional<XxlJobGroup> group = xxlJobGroupDao.findAll().stream().filter(g -> g.getAppname().equals(appName)).findFirst();
            if (!group.isPresent()) {
                return new ReturnT<>(ReturnT.FAIL_CODE, (I18nUtil.getString("jobinfo_field_jobgroup") + I18nUtil.getString("system_not_found")));
            }
            return new ReturnT<>(String.valueOf(group.get().getId()));
        } else if ("add-start".equals(uri)) {
            return xxlJobService.addStart(GsonTool.fromJson(data, XxlJobInfo.class));
        } else if ("update".equals(uri)) {
            return xxlJobService.update(GsonTool.fromJson(data, XxlJobInfo.class));
        } else if ("update-schedule".equals(uri)) {
            return xxlJobService.updateSchedule(GsonTool.fromJson(data, XxlJobInfo.class));
        } else if ("remove".equals(uri)) {
            return xxlJobService.remove(GsonTool.fromJson(data, XxlJobInfo.class).getId());
        } else {
            return new ReturnT<>(ReturnT.FAIL_CODE, "invalid request, uri-mapping(" + uri + ") not found.");
        }
    }

}
