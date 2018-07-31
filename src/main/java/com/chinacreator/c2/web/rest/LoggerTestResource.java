package com.chinacreator.c2.web.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.chinacreator.c2.logger.C2Self4jLogger;
import com.chinacreator.c2.logger.IOperationContent;
import com.chinacreator.c2.logger.LoggerConstants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api("日志測試")
@Path("v1/logtest")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoggerTestResource {
	private static final Logger logger = LoggerFactory.getLogger(LoggerTestResource.class);
	

	@GET
	@Path("/hello/{name}")
	@ApiOperation(value = "打招呼", notes = "")
	public String hello(@PathParam("name") final String name) {
		logger.info("正常记录运行日志。");
		//记录操作日志
		C2Self4jLogger.logOperation(logger, LoggerConstants.OP_TYPE_ACCESS_FUNC, "user", "s1", "zhangsan", 0, 10, new IOperationContent() {
			
			@Override
			public String toJson() {
				return "{\"content\": \"和["+name+"]打招呼\"}";
			}
		});
		return "hello " + name;
	}

}
