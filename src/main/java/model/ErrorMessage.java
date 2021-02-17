package model;

public class ErrorMessage {

    private int statusCode;
    private String errorMessage;

    public ErrorMessage() {}

    public ErrorMessage(int statusCode, String errorMessage) {
        super();
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
    }

    public int getStatusCode()
    { return statusCode; }

    public String getErrorMessage()
    { return errorMessage; }

    public void setErrorMessage(String errorMessage)
    { this.errorMessage = errorMessage; }

    public void setStatusCode(int statusCode)
    { this.statusCode = statusCode; }
}
