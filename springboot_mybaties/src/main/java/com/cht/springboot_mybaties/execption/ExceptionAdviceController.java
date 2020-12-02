package com.cht.springboot_mybaties.execption;

import com.cht.springboot_mybaties.util.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice(basePackages = "com.cht.springboot_mybaties.controller")
public class ExceptionAdviceController {

    private Logger logger = LoggerFactory.getLogger(ExceptionAdviceController.class);

    /**
     * 参数校验异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResultUtils handleValidException(MethodArgumentNotValidException exception) {
        Map<String, String> map = new HashMap<>();
        BindingResult bindingResult = exception.getBindingResult();
        bindingResult.getFieldErrors().forEach(fieldError -> {
            String message = fieldError.getDefaultMessage();
            String field = fieldError.getField();
            map.put(field, message);
        });
        ResultUtils r = new ResultUtils();
        r.setStatus(ErrorEnum.DATA_VALID_ERROR.getCode());
        r.setMessage(ErrorEnum.DATA_VALID_ERROR.getMessage());
        r.setData(map);
        logger.error("数据校验出现问题{},异常类型{}", exception.getMessage(), exception.getClass());
        return r;
    }

    @ExceptionHandler(value = Throwable.class)
    public ResultUtils handleValidException(Throwable exception) {
        ResultUtils r = new ResultUtils();
        r.setStatus(ErrorEnum.UNNOW_ERROR.getCode());
        r.setMessage(ErrorEnum.UNNOW_ERROR.getMessage());
        return r;
    }


}
