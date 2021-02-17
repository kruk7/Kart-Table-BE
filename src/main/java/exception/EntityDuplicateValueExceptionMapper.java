package exception;

import model.ErrorMessage;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class EntityDuplicateValueExceptionMapper implements ExceptionMapper<EntityDuplicateValueException> {

    @Override
    public Response toResponse(EntityDuplicateValueException error) {
        ErrorMessage errorMessage = new ErrorMessage(409, error.getMessage());
        return Response.status(Response.Status.CONFLICT)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity(errorMessage)
                .build();
    }
}
