package Interfaces.SmartPhone;

public class SmartPhone implements Phone, MusicPlayer, Camera{
    @Override
    public void takePicture() {
        System.out.println("Taking picture");
    }

    @Override
    public void recordVideo() {
        System.out.println("Recording video");
    }

    @Override
    public void playMusic() {
        System.out.println("Playing music");
    }

    @Override
    public void pauseMusic() {
        System.out.println("Pausing music");
    }

    @Override
    public void makeCall() {
        System.out.println("Making a call");
    }

    @Override
    public void endCall() {
        System.out.println("Ending call");
    }
}
