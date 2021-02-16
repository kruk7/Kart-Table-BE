package exception;

import model.ErrorMessage;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class EntityDuplicateValueExceptionMapper implements ExceptionMapper<EntityDuplicateValueException> {

    @Override
    public Response toResponse(EntityDuplicateValueException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), 409);
        return Response.status(Response.Status.CONFLICT)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity(errorMessage)
                .build();
    }
}
