package co.com.sofka.administracion.common.ex;

public class BusinessException  extends ApplicationException {

    public enum Type {

        INVALID_DT_INITIAL_DATA("blank or null fields are not allowed");

        private final String message;
        public Throwable build;

        public String getMessage() {
            return message;
        }

        public BusinessException build() {
            return new BusinessException(this);
        }

        Type(String message) {
            this.message = message;
        }

    }

    private final Type type;

    public BusinessException(Type type){
        super(type.message);
        this.type = type;
    }

    @Override
    public String getCode(){
        return type.name();
    }
}
