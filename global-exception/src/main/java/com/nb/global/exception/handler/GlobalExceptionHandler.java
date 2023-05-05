package com.nb.global.exception.handler;


import com.nb.common.base.enums.ServiceExceptionEnum;
import com.nb.common.base.response.CommonResult;
import com.nb.global.exception.GlobalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

/**
 * @author dev
 */
@Slf4j
@Service
@RestControllerAdvice(basePackages = "com.nb.demo.controller")
public class GlobalExceptionHandler {

    public GlobalExceptionHandler(){

    }

    @ExceptionHandler(value = GlobalException.class)
    public CommonResult globalExceptionHandler(HttpServletRequest req, GlobalException ex) {
        log.error(ex.toString());
        log.error("[GlobalExceptionHandler]", ex);
        return CommonResult.error(ex.getCode(), ex.getMsg());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public CommonResult<Object> validationBodyException(MethodArgumentNotValidException ex) {
        log.error(ServiceExceptionEnum.METHOD_ARGUMENT_NOT_VALID_EXCEPTION.toString());
        log.error("[MethodArgumentNotValidException]", ex);
        BindingResult bindingResult = ex.getBindingResult();
        return this.responseValidate(
                ServiceExceptionEnum.METHOD_ARGUMENT_NOT_VALID_EXCEPTION.getCode(),
                this.getBindingResult(bindingResult)
        );
    }

    @ExceptionHandler({org.springframework.validation.BindException.class})
    public CommonResult<Object> validationBodyException(BindException ex) {
        log.error(ServiceExceptionEnum.BIND_EXCEPTION.toString());
        log.error("[BindException]", ex);
        BindingResult bindingResult = ex.getBindingResult();
        return this.responseValidate(
                ServiceExceptionEnum.BIND_EXCEPTION.getCode(),
                this.getBindingResult(bindingResult)
        );
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public CommonResult<Object> handleServiceException(ConstraintViolationException ex) {
        log.error(ServiceExceptionEnum.CONSTRAINT_VIOLATION_EXCEPTION.toString());
        log.error("[ConstraintViolationException]", ex);
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        ConstraintViolation<?> violation = (ConstraintViolation)violations.iterator().next();
        String message = violation.getMessage();
        return this.responseValidate(
                ServiceExceptionEnum.CONSTRAINT_VIOLATION_EXCEPTION.getCode(),
                message
        );
    }

    @ExceptionHandler({MissingServletRequestParameterException.class})
    public CommonResult<Object> missingServletRequestParameterException(MissingServletRequestParameterException ex) {
        log.error(ServiceExceptionEnum.MISSING_SERVLET_REQUEST_PARAMETER_EXCEPTION.toString());
        log.error("[MissingServletRequestParameterException]", ex);
        return this.responseValidate(
                ServiceExceptionEnum.MISSING_SERVLET_REQUEST_PARAMETER_EXCEPTION.getCode(),
                ex.getParameterName() + "不能为空！"
        );
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public CommonResult httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex, HttpServletRequest request) {
        log.error(ServiceExceptionEnum.HTTP_REQUEST_METHOD_NOT_SUPPORTED_EXCEPTION.toString());
        log.error("[HttpRequestMethodNotSupportedException]", ex);
        return this.responseValidate(
                ServiceExceptionEnum.HTTP_REQUEST_METHOD_NOT_SUPPORTED_EXCEPTION.getCode(),
                "当前请求方式错误，不是" + request.getMethod() + "方式。"
        );
    }

    private CommonResult responseValidate(Integer code, String msg) {
        return CommonResult.error(code,msg);
    }

    private String getBindingResult(BindingResult bindingResult) {
        List<ObjectError> list = bindingResult.getAllErrors();
        return CollectionUtils.isEmpty(list) ? "" : list.get(0).getDefaultMessage();
    }

}
