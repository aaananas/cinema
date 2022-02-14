package movie.theater.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseResponse<T> {
    private T data;
    private Status status;
    private String message;

    private BaseResponse(T data, Status status, String message) {
        this.data = data;
        this.status = status;
        this.message = message;
    }

    public static <T> BaseResponse<T> ok(T data) {
        return new BaseResponse<>(data, Status.OK, null);
    }

    public static <T> BaseResponse<T> error(String message) {
        return new BaseResponse<>(null, Status.ERROR, message);
    }

    public enum Status {
        OK, ERROR
    }
}
