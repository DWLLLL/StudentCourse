package com.rabbiter.cm.controller;

import com.rabbiter.cm.model.vo.response.ResultVO;

public class BaseController {
    protected ResultVO result(Object data) {
        return new ResultVO(ResultVO.SUCCESS, "success", data);
    }

    protected ResultVO result(Object data, String message) {
        return new ResultVO(ResultVO.SUCCESS, message, data);
    }

    protected ResultVO failedResult(String message) {
        return new ResultVO(ResultVO.FAIL, message, null);
    }

    protected ResultVO failedResult(String message, Object data) {
        return new ResultVO(ResultVO.FAIL, message, data);
    }

    protected boolean isNullOrEmpty(String str) {
        return "".equals(str);
    }
}
