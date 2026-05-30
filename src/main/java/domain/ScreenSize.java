package domain;


public record ScreenSize(int width, int height) {
    @Override
    public int width() {
        return width;
    }

    @Override
    public int height() {
        return height;
    }
}

