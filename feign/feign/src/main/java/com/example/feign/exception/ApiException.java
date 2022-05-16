package com.example.feign.exception;

public class ApiException extends Exception {
    private String code;

    private String message;

    private String source;

    private String sourceErrorCode;

    private Exception causedBy;

    private String payload;

    private boolean retryable;

    private long retryInterval;

    public ApiException() {
        this("API_ERROR", "API Error", "Backend", new Exception());
    }

    public ApiException(String code, String source) {
        super(new Exception());
        this.code = code;
        this.source = source;
    }

    public ApiException(String code, String source, Exception ex) {
        super(code, ex);
        this.code = code;
        this.causedBy = ex;
        this.source = source;
    }

    public ApiException(String code, String message, String source, Exception ex, String payload) {
        this(code, message, source, ex);
        this.payload = payload;
    }

    public ApiException(String code, String message, String source) {
        this(code, message, source, new Exception());
    }

    public ApiException(String code, String message, String source, Exception ex) {
        super(message, ex);
        this.code = code;
        this.message = message;
        this.source = source;
        this.causedBy = ex;
    }

    public ApiException(String code, String message, String source, String sourceErrorCode, Exception ex) {
        super(message, ex);
        this.code = code;
        this.message = message;
        this.source = source;
        this.sourceErrorCode = sourceErrorCode;
        this.causedBy = ex;
    }

    public ApiException(String code, String message, String source, Exception ex, String payload, boolean retryable) {
        this(code, message, source, ex);
        this.payload = payload;
        this.retryable = retryable;
    }

    public ApiException(String code, String message, String source, String sourceErrorCode, Exception ex, boolean retryable) {
        super(message, ex);
        this.code = code;
        this.message = message;
        this.source = source;
        this.sourceErrorCode = sourceErrorCode;
        this.causedBy = ex;
        this.retryable = retryable;
    }

    public ApiException(String code, String message, String source, String sourceErrorCode, Exception ex, boolean retryable, long retryInterval) {
        super(message, ex);
        this.code = code;
        this.message = message;
        this.source = source;
        this.sourceErrorCode = sourceErrorCode;
        this.causedBy = ex;
        this.retryable = retryable;
        this.retryInterval = retryInterval;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSourceErrorCode() {
        return sourceErrorCode;
    }

    public void setSourceErrorCode(String sourceErrorCode) {
        this.sourceErrorCode = sourceErrorCode;
    }

    public Exception getCausedBy() {
        return causedBy;
    }

    public boolean isRetryable() {
        return retryable;
    }

    public void setRetryable(boolean retryable) {
        this.retryable = retryable;
    }

    public void setCausedBy(Exception causedBy) {
        this.causedBy = causedBy;
    }

    public Long getRetryInterval() {
        return retryInterval;
    }

    public void setRetryInterval(Long l) {
        this.retryInterval = l;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

}
