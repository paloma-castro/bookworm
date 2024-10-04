package santander.bookstore.config;

public class ExceptionMessage {
    String message;
    String path;
    String erro;

    public ExceptionMessage(String message, String path, String erro) {
        this.message = message;
        this.path = path;
        this.erro = erro;
    }

    public ExceptionMessage() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }
}
