package g.library.enums;

public enum BookStatus {
    AVAILABLE("Available"),
    NOT_AVAILABLE("Not available");

    private final String status;

    BookStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
