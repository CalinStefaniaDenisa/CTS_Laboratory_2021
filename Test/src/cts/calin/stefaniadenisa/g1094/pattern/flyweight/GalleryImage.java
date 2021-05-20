package cts.calin.stefaniadenisa.g1094.pattern.flyweight;
public class GalleryImage {
    String bitmapName;
    byte[] pixels;

    public GalleryImage(String fileName) {
        this.bitmapName = fileName;
        this.pixels = new byte[1000];
    }
}