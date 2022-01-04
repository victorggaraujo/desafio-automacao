package app;

public enum Version {
    BOOTSTRAP_V4_THEME("Bootstrap V4 Theme");

    private String visibleText;

    Version(String visibleText) {
        this.visibleText = visibleText;
    }

    public String getVisibleText() {
        return visibleText;
    }
}
