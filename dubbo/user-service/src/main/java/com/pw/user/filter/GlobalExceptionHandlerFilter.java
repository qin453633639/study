package com.pw.user.filter;

import com.alibaba.dubbo.rpc.*;
import com.alibaba.dubbo.rpc.service.GenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description:   全局统异常处理
 * @Author:         qinwei
 * @CreateDate:     2018/10/12 0012 下午 6:41
 * @Version:        1.0
*/

public class GlobalExceptionHandlerFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandlerFilter.class);

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        try {
            Result result = invoker.invoke(invocation);
            if (  ! result.hasException() || ! (GenericService.class != invoker.getInterface()) ) {
                return result;
            }

            return new  RpcResult();
        }catch (Throwable e) {
            logger.error("GlobalExceptionHandlerFilter.invoke", e);
            return new  RpcResult( );
        }

    }
}
